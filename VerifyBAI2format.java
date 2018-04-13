package com.selenium.codp.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyBAI2format {

	public ArrayList<String> getBAIRecordsFromFile( String forlderPath,String FilePath) throws IOException
	{
			ArrayList<String> bairecords= new ArrayList<String>();
			ArrayList<String> baiFileRawrecords= new ArrayList<String>();
			
			FileInputStream in = new FileInputStream(FilePath);
		    BufferedReader br = new BufferedReader(new InputStreamReader(in));
		   
		    Pattern pattern;
            Matcher match;
	        String regex1 = "(01),(.*)";
	        String regex2 = "(\\d\\d),(.*)";
	        String regex3 = "98,(.*)";
	        String record = "",line="";
	        
	        
	        String Data01="",Data02="",Data03="",Data16="",Data88="",Data49="",Data98="",Data99="";
	        
	        int i=0;
	        
	        while ((line = br.readLine()) != null)   
	        {  
	        	baiFileRawrecords.add(line);	        
	        }
	        br.close();
	        
	        for (int index=0;index < baiFileRawrecords.size() ; index++)
	        {  
	         	if(baiFileRawrecords.get(index).matches(regex1))
	         	{
	         		pattern = Pattern.compile(regex1);
		            match = pattern.matcher(baiFileRawrecords.get(index));
		            if(match.find()) 
		            {
		            	
		            	Data01=match.group(2).replaceAll(",+",",");		           
		            	continue;
		            }
	         		
	         	}
	            
	            if(baiFileRawrecords.get(index).matches(regex2)) {
	            	
	            	pattern = Pattern.compile(regex2);
		            match = pattern.matcher(baiFileRawrecords.get(index));
		            match.find(); 
		            String val=match.group(2).replaceAll(",{2}+", ",").replaceAll("/$","");;
		            if(baiFileRawrecords.get(index).startsWith("02,") && match.group(2).trim().length()!=0)
	            		Data02=val;
	            	
		            else if(baiFileRawrecords.get(index).startsWith("03,")  && match.group(2).trim().length()!=0)
	            		Data03=val;
		            
	            	else if(baiFileRawrecords.get(index).startsWith("16,") && match.group(2).trim().length()!=0)
		            	Data16=Data16+","+val;
		            
		            else if(baiFileRawrecords.get(index).startsWith("88,"))
		            		 Data88=Data88+","+val;
		            
		            else if(baiFileRawrecords.get(index).startsWith("49,") )	
            				Data49=val;

				    else if(baiFileRawrecords.get(index).startsWith("98,") && match.group(2).trim().length()!=0)
				    	{
				    		Data98=val;
				    	
				    		record=Data02+","+Data03+","+Data16+","+Data88+","+Data49+","+Data98;
            				record=record.replaceAll("/$","").replaceAll(",{2}+", ",");
            				bairecords.add(record);
            				record="";
            				Data01="";
            				Data02="";
            				Data03="";
            				Data16="";
            				Data88="";
            				Data49="";
            				Data98="";
            				Data99="";
				    		
				    	}

	            		
	            	i++;
	            }
	          i=0;
	       }
	            

		    
		return bairecords;
	}

	
	
	public void origconvertMT940format( String forlderPath,String FilePath) throws IOException
	{
		
		 String line = null;  
			
			FileInputStream in = new FileInputStream(FilePath);
		    BufferedReader br = new BufferedReader(new InputStreamReader(in));

		    File file = new File(forlderPath+"\\"+"FormatMT940.txt");
		    
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

	        String patternString = "(:\\d\\d:|:\\d\\d.:)(.*)";
	    	
	        
	        String patternString1 = "1:(.*?)\\}\\{2:(.*?)\\}";
	    	
	        // String[] fields = new String[count];
	        
	        while ((line = br.readLine()) != null)   
	        {  

	        	Pattern pattern = Pattern.compile(patternString);
	            Matcher matcher = pattern.matcher(line);
	            
	            Pattern pattern1 = Pattern.compile(patternString1);
	            Matcher matcher1 = pattern1.matcher(line);
	            
	            if(line.contains("{1"))
	            {
	            	if(matcher1.find()) {
	                	
	                	System.out.println("found ****: " + matcher1.group(1));
	                	System.out.println("found*****: " + matcher1.group(2));
	                	//fields[i]=matcher.group(2);
	                	bw.write(matcher1.group(1));
	                	bw.write("|");
	                	bw.write(matcher1.group(2));
	                	bw.write("|");
	                	
	                }
	                
	            	continue;
	            }
	            	
	            if(line.contains("-}"))
	            {	
	            	//lines.add(fields);
	            	bw.write("\n");
	            	//Arrays.fill(fields, null);
	            	 continue;
	            	 
	            }
	            if(matcher.find()) {

	            	System.out.println("found: " + matcher.group(2));
	            	//fields[i]=matcher.group(2);
	            	bw.write(matcher.group(2));
	            	bw.write("|");
	            }
	            
	            
	        }  
	        bw.close();

	        br.close();  
		    
		
	}
	
	
	public static ArrayList<String> prepareMT940DBRecordsList(ArrayList<String[]> DBRecords)
    {
    	
    	ArrayList<String> DBList=new ArrayList<String>();
    	
    	ArrayList<String> record=new ArrayList<String>();
    	
    	if(DBRecords.size()==0)
    	{
    		DBList.add("No Records");
    		return DBList;
    	}
    	for (ListIterator<String[]> iter = DBRecords.listIterator(); iter.hasNext(); ) {
			String[] element = iter.next();		
			String dbline="";
			String patternString;
			Pattern pattern;
			Matcher matcher;
			for (int i=0;i< element.length;i++) {

				element[i]=element[i].replaceAll("\\s+", "").trim();
				
				if(element[i].contains("No61Data"))
					continue;
/*				if(element[i].contains("No86Data"))
					continue;*/
				if(element[i].contains("No64FData"))
					continue;
				
			    if(i!=0 && element[i]!="")
		        	 dbline=dbline+","+element[i].trim();
		         else
		        	 dbline=dbline+element[i].trim();
			}
			
			DBList.add(dbline);
		}
    	
    	
    	return DBList;

    }
	
	public  static ArrayList<String> compareAppDBData(ArrayList<String> AppRecords,ArrayList<String> DBRecords)
	{
	
		ArrayList<String> Result=new ArrayList<String>();
		Collections.sort(AppRecords);
		Collections.sort(DBRecords);
	
		 if ((AppRecords.size() != DBRecords.size()) || ( AppRecords == null && DBRecords!= null) || ( AppRecords != null && DBRecords== null)){
		        
			 System.out.println("Sizes of Lists are not matched");
			 Result.add("No. Of records of App data and DB data are not equal");
			 //Result=null;
			 return Result;
	    }
		 else
		 {
		
			for (int counter=0; counter < DBRecords.size(); counter++) {
			        if (AppRecords.contains(DBRecords.get(counter))) {
			            System.out.println("Match Found ");
			            System.out.println("Excel Record  :"+ AppRecords.get(counter));
			            System.out.println("DB Record :"+ DBRecords.get(counter));
			            Result.add("Matched :  "+DBRecords.get(counter));
			            
			        }
			        else
			        {
			        	 System.out.println("Match NOT Found ");
			        	 System.out.println("Excel Record  :"+ AppRecords.get(counter));
			             System.out.println("DB Record :"+ DBRecords.get(counter));
			             Result.add("UnMatched :  "+DBRecords.get(counter));
			        }
			}
			
			return Result;
	    }
	}	
}
