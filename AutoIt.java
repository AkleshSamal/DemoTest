package com.selenium.codp.utilities;

public class AutoIt {
	Process p;
	public String saveReportSummary(String fileSavePath,String fileName){
        String[] dialog;
        String path=fileSavePath+"\\"+fileName;
        dialog=new String[]{"SaveAsDialog_Chrome.exe","Save As",path};
        //dialog=new String[]{"SaveAsDialog_Chrome.exe","Save As","C:\\Users\\perumans\\","my file.csv"};
        //path="SaveAsDialog_Chrome.exe";
        try {
               //Runtime.getRuntime().exec(path);
        	p= Runtime.getRuntime().exec(dialog);
        } catch (Exception e) {
               e.printStackTrace();
        }
        return path;
        
 }

	public void killExeProcess()
	{
		p.destroy();
	}
	
	


}
