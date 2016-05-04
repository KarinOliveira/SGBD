import java.io.IOException;

public class TreeManager {
	
	private static final String GRAPES[] = {"MERIOT", "CABERNET SAUVIGNON", "MERLOT", "MALBEC", "CARMÉNÈRE", "PINOT NOIR", "SYRAH", "TANNAT", "TEMPRANILLO", "CHARDONNAY", "SAUVIGNON BLANC"};
	private static final String PRODUCING_COUNTRIES[] = {"PORTUGAL", "CHILE", "AFRICA DO SUL", "ALEMANHA", "AUSTRÁLIA", "ARGENTINA", "EUA", "ESPANHA", "ITÁLIA", "FRANÇA", "BRASIL"};
	private static final String WINE_PRODUCERS[] = {"MARCELO ANDRADE", "LUSCIOUZ LOPEZ", "PETER PARKER", "BASTIAN SCHWEINSTEIGER", "SNAKE SPIDER", "LIONEL MESSI", "BRIAN O'CONNER", "ABELLA ANDERSON", "CLAUDIA ANTONELLI", "ADÈLE EXARCHOPOULOS", "SÉRGIO MORO"}; 
	
	private static final String EIND_FILE_TYPE = "EInd";
	private static final String EDAD_FILE_TYPE = "Edad";
	
	private final int NUMBER_WINES = 11;
	private final int NUMBER_REGISTERS_EIND = 10;
	
	private final int ROOT_ROW = 4;

	private Indice rootIndex;
	private Indice currentIndexRecord;
	
	private FileManager mFileManager;
	private Vinho wineRetrieved;
		
	public TreeManager() {
		this.mFileManager = new FileManager();
		
		createIndexRecords();
		createWineRecords();
		
		rootIndex = mFileManager.retrieveIndexRecord(ROOT_ROW);
	}
	
	public void searchRecord(int key) {
		int mapping; 
		
		if (key == 2001) {
			mapping = mappingEindToEdad(0);
		} else {
			mapping = mappingEindToEdad(key - 2000);
		}
		
		currentIndexRecord = mFileManager.retrieveIndexRecord(mapping);
		wineRetrieved = mFileManager.retrieveWineRecord(mappingEdadToWineRow(mapping));
		System.out.println(wineRetrieved.toString());
	}
	
	public void finish() {
		mFileManager.deleteFiles();
	}
	
	private int mappingEindToEdad(int eindRow) {
		int mapping;
		
		mapping = NUMBER_REGISTERS_EIND + eindRow; 
				
		return mapping;
	}
	
	private int mappingEdadToWineRow(int edadRow) {
		int mapping;
		
		mapping = (10 - edadRow) * -1;
		
		return mapping;
	}
	
	private void createIndexRecords() {
		String eindData;
		String edadData;
		
		eindData = createEIndData();
		edadData = createEDadData();
		
		mFileManager.writeFile(eindData + edadData, FileManager.INDEX_FILE_NAME);
	}
	
	private void createWineRecords() {
		for (int i = 0; i < NUMBER_WINES; i++) {
			mFileManager.writeFile((new Vinho("V10" + i, WINE_PRODUCERS[i], GRAPES[i], PRODUCING_COUNTRIES[i], 2000 + (i + 1))).toString(), FileManager.WINE_FILE_NAME);
		}	
	}
	
	private String createEIndData() {
		StringBuilder eindContent = new StringBuilder();
		
		for (int i = 2; i <= NUMBER_WINES; i++) {
			eindContent.append((new Indice(2000 + i, "R" + (100 + i), EIND_FILE_TYPE)).toString() + "\n");
		}
	
		return eindContent.toString();
	}
	
	private String createEDadData() {
		StringBuilder edadContent = new StringBuilder();
		
		for (int i = 1; i <= NUMBER_WINES; i++) {
			edadContent.append((new Indice(2000 + i, "R" + (100 + i), EDAD_FILE_TYPE)).toString() + "\n");
		}
		
		return edadContent.toString();
	}
}
