package com.selenium.codp.utilities;

import java.io.IOException;

public class AutoITUtil {
	
	public String autoFileDownload(String fileSavePath,String fileName,String browsertype){
		String[] dialog;
		String path=fileSavePath+"\\"+fileName;
		//dialog=new String[]{"SaveAsDialog_Chrome.exe",browsertype.toLowerCase(),"Save As",path};
		dialog=new String[]{"SaveAsDialog_Chrome.exe","Save As","C:\\NotBackedUp\\Nidheesh\\ScreenShots","DeclineTransactionGrid.csv"};
		path="SaveAsDialog_Chrome.exe";
		try {
			//Runtime.getRuntime().exec(path);
		Runtime.getRuntime().exec(dialog);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
		
	}
	
	public String IEAutoSavedialog(){
		String fileSavePath="C:\\Users\\perumans\\data";
		String fileName="Sam.xls";
		String[] dialog;
		String path=fileSavePath+"\\"+fileName;
		dialog=new String[]{"C:\\Users\\perumans\\NewIEDialog.exe","File Download",path};
		//dialog=new String[]{"SaveAsDialog_Chrome.exe","Save As","C:\\Users\\perumans\\","my file.csv"};
		//path="SaveAsDialog_Chrome.exe";
		try {
			//Runtime.getRuntime().exec(path);
			Runtime.getRuntime().exec(dialog);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	

}
