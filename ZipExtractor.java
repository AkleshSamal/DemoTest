package com.selenium.codp.utilities;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipExtractor {
	
	public  List<String> unzipfile(String file,String filePath) throws Exception{
		FileInputStream fis=null;
		FileOutputStream fos=null;
		ZipInputStream zis=null;
		ZipEntry zEntry=null;
		List<String> obj=new ArrayList<String>();
		fis=new FileInputStream(file);
		zis=new ZipInputStream(new BufferedInputStream(fis));
		while((zEntry=zis.getNextEntry())!=null) {
			byte[] tmp=new byte[4*1024];
			String opFilePath=filePath+"\\"+zEntry.getName();
			obj.add(zEntry.getName());
			System.out.println("opFilePath: "+opFilePath);
			fos=new FileOutputStream(opFilePath);
			int size=0;
			while((size=zis.read(tmp))>0){
				fos.write(tmp,0,size);
			}
			fos.flush();
			fos.close();
			
		}
		zis.close();
		return obj;
		
	}

}
