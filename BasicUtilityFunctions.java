package com.selenium.codp.utilities;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.regex.Matcher;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import com.selenium.codp.utilities.SpreadsheetData;


public class BasicUtilityFunctions {

	 public static String createDirectory(String folderpath)
	 {	
		 
		 
		 DateFormat df = new SimpleDateFormat("MM_dd_yyyy HH_mm_ss");
		java.util.Date today = Calendar.getInstance().getTime();        
		String reportDate = df.format(today);
		
		folderpath=folderpath+reportDate;

		File theDir = new File(folderpath);
		
		if (!theDir.exists()) {
		    System.out.println("creating directory: " + folderpath);
		    boolean result = false;
	
			    try{
			        theDir.mkdir();
			        result = true;
			    } 
			    catch(SecurityException se){
			    	System.out.println("Unable to Created directory : "+folderpath);
			        se.printStackTrace();
			    }        
			    if(result) {    
			        //System.out.println("DIR created :"+folderpath);  
			        
			    }
		}
		
		return folderpath;
	 }
	 
	 
	 public static List<String> unzipfile(String file,String filePath) throws Exception{
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

	 public static String prepareComparisonResultsExcelSheet(String fileName,String folderpath,ArrayList<String> DBRecords,ArrayList<String> ExcelRecords, ArrayList<String> compareRecordsResultFinal ) throws Exception
	   {
		   
		    DateFormat df = new SimpleDateFormat("MM_dd_yyyy HH_mm_ss");
			java.util.Date today = Calendar.getInstance().getTime();        
			String reportDate = df.format(today);
			//System.out.println("Report Date: " + reportDate);
			String resultFile=fileName+reportDate;
			//String folderpath="C:\\Users\\sotakanj\\TestResults\\";
			
			
			WriteDBdata.writeExcelDataArrayList(resultFile, folderpath, "DB Data",DBRecords);
			WriteDBdata.writeExcelDataArrayList(resultFile, folderpath, "App Data",ExcelRecords);
			WriteDBdata.writeExcelDataArrayList(resultFile, folderpath, "Result Sheet",compareRecordsResultFinal);
		   
		   //return folderpath+"\\"+resultFile+".xls";
		   return resultFile;
		   
	   }	 
	 
	 public static String prepareResultsExcelSheet(String fileName,String folderpath,ArrayList<String> compareRecordsResultFinal ) throws Exception
	   {
		   
		    DateFormat df = new SimpleDateFormat("MM_dd_yyyy HH_mm_ss");
			java.util.Date today = Calendar.getInstance().getTime();        
			String reportDate = df.format(today);
			String resultFile=fileName+reportDate;

			WriteDBdata.writeExcelDataArrayList(resultFile, folderpath, "Result Sheet",compareRecordsResultFinal);
		   return resultFile;
		   
	   }
	 
	  private String fileNameToSearch;
	  private ArrayList<String> result = new ArrayList<String>();
		
	  public String getFileNameToSearch() {
		return fileNameToSearch;
	  }

	  public void setFileNameToSearch(String fileNameToSearch) {
		this.fileNameToSearch = fileNameToSearch;
	  }

	  public ArrayList<String> getResult() {
		return result;
	  }
	 
	 
	 public void searchDirectory(File directory, String fileNameToSearch) {

			setFileNameToSearch(fileNameToSearch);

			if (directory.isDirectory()) {
			    search(directory);
			} else {
			    System.out.println(directory.getAbsoluteFile() + " is not a directory!");
			}

		  }

		  private void search(File file) {

			if (file.isDirectory()) {
			  System.out.println("Searching directory ... " + file.getAbsoluteFile());
			
			    if (file.canRead()) {
					for (File temp : file.listFiles()) 
					{
					    if (temp.isDirectory()) {
					    	search(temp);
					    } 
					    else {
					    		if (temp.getName().matches(getFileNameToSearch())) {			
								    result.add(temp.getAbsoluteFile().toString());
						}
					  }
				    }

			    } 
			    else
			    {
			    	System.out.println(file.getAbsoluteFile() + "Permission Denied");
			    }
		      }
			
			
		  }
		  
		  
		  public void createConsolidatedTestResult(ArrayList<String> Files) throws Exception
		  {
			  ArrayList<String> TestResults=new ArrayList<>();
			  for(String F: Files)
				  TestResults.add(this.readXLSXFile(F));
			  
			  writeDataToExcel("ConsolidatedSuiteRunResults", System.getProperty("user.dir")+"\\src\\com\\anz\\selenium\\TestResults", "ConsidatedSuiteRunTestResults", TestResults);
		  }
		  
	public String readXLSXFile(String FileInput) throws IOException
		{
				InputStream ExcelFileToRead = new FileInputStream(FileInput);
				HSSFWorkbook  wb = new HSSFWorkbook(ExcelFileToRead);
				HSSFSheet sheet;
				int index=wb.getSheetIndex("ExecutionStatus");
				
				if(index==-1)
					return "";
				else					
				sheet = wb.getSheet("ExecutionStatus");
				HSSFRow row; 
				HSSFCell cell;
				String testresult="";
				int c=1;
				Iterator rows = sheet.rowIterator();
				while (rows.hasNext())
				{					
					row=(HSSFRow) rows.next();
					if(row.getRowNum()!=0)
					{		if(row.toString().length()==0)
								continue;
							Iterator cells = row.cellIterator();
							while (cells.hasNext())
							{
								cell=(HSSFCell) cells.next();
								if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
								{
									testresult=testresult+","+cell.getStringCellValue();
									c++;
								}
								else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
								{
									testresult=testresult+","+cell.getStringCellValue();
									c++;
								}
							}
					}
							System.out.println();
							testresult=testresult.replaceFirst(",","");
							testresult=testresult.replaceAll(",$", "");
				}
			
				ExcelFileToRead.close();
				if(c==5)
					testresult=testresult+","+","+FileInput;
				else
					testresult=testresult+","+FileInput;
				return testresult;
			}

	
	public static void writeDataToExcel(String FileName,String resultsPath,String sheetname,
            ArrayList<String> AllTestResults) throws Exception {
     
     FileInputStream filein=null;
     FileOutputStream fileOut=null;
     HSSFWorkbook workbook=null;
     HSSFSheet worksheet=null;
     String s = resultsPath+"\\"+FileName+".xls" ;
                  
     File file=new File(s);
     
     Pattern pattern = null;
     java.util.regex.Matcher matcher;
     
     
     if(file.exists()){
            filein=new FileInputStream(new File(s));
            workbook = new HSSFWorkbook(filein);
            worksheet=workbook.createSheet(sheetname);     
            fileOut = new FileOutputStream(new File(s));
     }
     else{
            fileOut = new FileOutputStream(new File(s));
            workbook = new HSSFWorkbook();
            worksheet=workbook.createSheet(sheetname);
     }
                                       
     int rownum = 0;
     Row row = worksheet.createRow(rownum++);
     int cellnum = 0;
     Cell cell = row.createCell(cellnum++);
     cell.setCellValue("TestcaseName");
     cell = row.createCell(cellnum++);
     cell.setCellValue("ExecutionDate");
     cell = row.createCell(cellnum++);
     cell.setCellValue("ExecutionStatus");
     cell = row.createCell(cellnum++);
     cell.setCellValue("Errors");
     cell = row.createCell(cellnum++);
     cell.setCellValue("Test Execution Results Folder");
     
     for( String eachtestresult: AllTestResults)
     {
    	 
    	 if(eachtestresult.length()!=0)
    	 {
	    	 String[] data=eachtestresult.split(",");
		     row = worksheet.createRow(rownum++);
		     cellnum=0;
		     for(;cellnum< data.length;cellnum++)
		     {	   
		    	if(!data[cellnum].isEmpty())
		    	{
		    		if(cellnum==4)
		    		{
		    			cell = row.createCell(cellnum);
		    			pattern = Pattern.compile("(.*)\\.*$");
		    			matcher= pattern.matcher((data[cellnum]));
		    			matcher.find();
		    			System.out.println(matcher.group(1).trim());
		    			cell.setCellValue(matcher.group(1).trim());
		    		}
		    		else
		    		{
			    		cell = row.createCell(cellnum);
			    		cell.setCellValue(data[cellnum]);
		    		}
			    	 
		    	}
		    	
		     }
		     
		     
    	 }
	     
     }      
     

     workbook.write(fileOut);
     fileOut.flush();
     fileOut.close();
}

	 
	
		  
		  
		  
}
