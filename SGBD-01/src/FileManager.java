import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class FileManager {

	private static final String DEFAULT_DIRECTORY = "/home/stenio/workspace/SGBD-01/src/arquivos/";
	
	public static final String WINE_FILE_NAME = "vinhos.txt";
	public static final String INDEX_FILE_NAME = "indice.txt";
	
	private File directoryFolder = null;
	private File wineFile = null;	
	private File indexFile = null;
	
	private RandomAccessFile currentIndexRecord;
	private RandomAccessFile currentWineRecord;
	
	public FileManager() {
		createDefaultDirectory();
		setupFiles();
		setupPointers();
	}
	
	public void writeFile(String content, String fileName) {		
		try {			
			PrintWriter mPrintWriter = new PrintWriter(new FileWriter(DEFAULT_DIRECTORY + fileName, true));		  
			
			mPrintWriter.println(content); 
			mPrintWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Indice retrieveIndexRecord(int rowNumber) {
		Indice indexRetrieved = null;
		String indexSplit[];
	
		try {
			indexSplit = readIndexFileRow(rowNumber).split(" ");
			indexRetrieved = new Indice(Integer.valueOf(indexSplit[0]), indexSplit[1], indexSplit[2]);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return indexRetrieved;
	}
	
	private String readIndexFileRow(int rowNumber) throws IOException {
		String rowContent = "";
		
		currentIndexRecord.seek(0);
		
		for (int i = 0; i < (rowNumber - 1); i++) {
			currentIndexRecord.readLine();
		}
	
		rowContent = currentIndexRecord.readLine();
			
		return rowContent;
	}
	
	public Vinho retrieveWineRecord(int rowNumber) {
		Vinho wineRetrieved = null;
		String wineSplit[];

		try {
			wineSplit = readWineFileRow(rowNumber).split("-");
			wineRetrieved = new Vinho(wineSplit[0], wineSplit[1], wineSplit[2], wineSplit[3], Integer.valueOf(wineSplit[4]));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return wineRetrieved;
	}
	
	public void deleteFiles() {
		wineFile.delete();
		indexFile.delete();
		directoryFolder.delete();
	}
	
	private String readWineFileRow(int rowNumber) throws IOException {
		String rowContent = "";

		currentWineRecord.seek(0);
		
		for (int i = 0; i < (rowNumber - 1); i++) {
			currentWineRecord.readLine();
		}
		
		rowContent = currentWineRecord.readLine();
		
		return rowContent;
	}
	
	private void createDefaultDirectory() {
		directoryFolder = new File(DEFAULT_DIRECTORY);
		directoryFolder.mkdirs();
	}
	
	private void setupFiles() {
		wineFile = new File(DEFAULT_DIRECTORY + WINE_FILE_NAME);
		indexFile = new File(DEFAULT_DIRECTORY + INDEX_FILE_NAME);	
	}
	
	private void setupPointers() {
		try {
			currentIndexRecord = new RandomAccessFile(indexFile, "rw");
			currentWineRecord = new RandomAccessFile(wineFile, "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
}
