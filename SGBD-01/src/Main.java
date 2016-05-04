import java.util.Scanner;

import javax.swing.plaf.FileChooserUI;

public class Main {
	
	public static void main(String[] args) {
		Scanner readFromKeyboard = new Scanner(System.in);;
		TreeManager mTreeManager = new TreeManager();
		int key = 0;
		
		while(true) {
			System.out.println("Digite 1 para sair ou digite o ano da CEPA: ");
			
			key = readFromKeyboard.nextInt();
			
			if (key == 1) {
				break;
			}
			
			if (key > 2011 || key < 2001) {
				System.out.println("CEPA NAO ENCONTRADA! :(");
			} else {
				mTreeManager.searchRecord(key);	
			}
			
			System.out.println();
		}
		
		mTreeManager.finish();
	}
}
