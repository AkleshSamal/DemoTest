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

public class VerifyMT940format {

	
	
	public ArrayList<String> convertMT940format( String forlderPath,String FilePath) throws IOException
	{
		
			 
			ArrayList<String> mt940records= new ArrayList<String>();
			
			FileInputStream in = new FileInputStream(FilePath);
		    BufferedReader br = new BufferedReader(new InputStreamReader(in));
		   
	        
	        String regex1 = "1:(.*?)\\}\\{2:(.*?)\\}";
	        String regex2 = "(:\\d\\d:|:\\d\\d.:)(.*)";
	        String regex3 = ":20:(\\d{8,8})(.*)";
	        String record = "",line="";
	        int i=0;
	        while ((line = br.readLine()) != null)   
	        {  
	        	//System.out.println(line);
	        	Pattern pattern = Pattern.compile(regex1);
	            Matcher matcher = pattern.matcher(line);
	            
	            Pattern pattern1 = Pattern.compile(regex2);
	            Matcher matcher1 = pattern1.matcher(line);
	            
	         /*   if(line.contains("{1"))
	            {
	            	record="";
	            	if(matcher.find()) {
	            		record=matcher.group(1)+","+matcher.group(2);
	                }	                
	            	continue;
	            }*/
	         	if(line.matches(regex3))
	         	{
	         		Pattern pattern3 = Pattern.compile(regex3);
		            Matcher matcher3 = pattern3.matcher(line);
		            if(matcher3.find()) 
		            {
		            	if(i==0 )
		            		record=record+matcher3.group(1).replace(",","").replaceAll("\\s+", " ");
		            	else
		            		//if(matcher1.group(2).trim().length()!=0)
		            		record=record+","+matcher3.group(1).replace(",","").replaceAll("\\s+", " ");
		            	i++;
		            	continue;
		            }
	         		
	         	}
	            
	            if(matcher1.find()) {
	       
	            		
	            	if(i==0 )
	            		record=record+matcher1.group(2).replace(",","").replaceAll("\\s+", " ");
	            	else
	            		if(matcher1.group(2).trim().length()!=0)
	            		record=record+","+matcher1.group(2).replace(",","").replaceAll("\\s+", " ");
	            	i++;
	            }
	            
	            	
	            if(line.contains("-}"))
	            {
	            	
	            	mt940records.add(record);
	            	record="";
	            	i=0;
	            }
	            
	         }  
	        

	        br.close();  
		    
		return mt940records;
	}

	
	
	public ArrayList<String> getMT940RecordsFromFile( String forlderPath,String FilePath) throws IOException
	{
			ArrayList<String> mt940records= new ArrayList<String>();
			ArrayList<String> mt940FileRawrecords= new ArrayList<String>();
			
			FileInputStream in = new FileInputStream(FilePath);
		    BufferedReader br = new BufferedReader(new InputStreamReader(in));
		   
		    Pattern pattern;
            Matcher match;
	        String regex1 = "1:(.*?)\\}\\{2:(.*?)\\}";
	        String regex2 = "(:\\d\\d:|:\\d\\d.:)(.*)";
	        String regex3 = ":20:(\\d{8,8})(.*)";
	        String record = "",line="";
	        
	        String Data20="",Data25="",Data28C="",Data60F="",Data61="",Data62F="",Data64="",Data86="";
	        
	        int i=0;
	        
	        while ((line = br.readLine()) != null)   
	        {  
	        	mt940FileRawrecords.add(line);	        
	        }
	        
	        for (int index=0;index < mt940FileRawrecords.size() ; index++)
	       // while ((line = br.readLine()) != null)   
	        {  
	         	if(mt940FileRawrecords.get(index).matches(regex3))
	         	{
	         		pattern = Pattern.compile(regex3);
		            match = pattern.matcher(mt940FileRawrecords.get(index));
		            if(match.find()) 
		            {
		            	
		            	Data20=match.group(1).replace(",","").replaceAll("\\s+", "");		           
		            	continue;
		            }
	         		
	         	}
	            
	            if(mt940FileRawrecords.get(index).matches(regex2)) {
	            	
	            	pattern = Pattern.compile(regex2);
		            match = pattern.matcher(mt940FileRawrecords.get(index));
		            match.find(); 
		            String val=match.group(2).replace(",","").replaceAll("\\s+", "");
		            if(mt940FileRawrecords.get(index).startsWith(":25:") && match.group(2).trim().length()!=0)
	            		Data25=val;
	            	
		            else if(mt940FileRawrecords.get(index).startsWith(":28C:")  && match.group(2).trim().length()!=0)
	            		Data28C=val;
		            
	            	else if(mt940FileRawrecords.get(index).startsWith(":60F:") && match.group(2).trim().length()!=0)
		            	Data60F=val;
		            
		            else if(mt940FileRawrecords.get(index).startsWith(":61:"))
/*		            	 if(val.isEmpty())
		            		 Data61=Data61+","+"No61Data";
		            	 else*/
		            	Data61=Data61+","+val.replaceAll("\\.","");
		            	//Data61=Data61.replaceAll("D0", "D")+","+val.replaceAll("C0,", "C");
		            
		            else if(mt940FileRawrecords.get(index).startsWith(":86:") )
		            	{
		            		/*if(val.isEmpty())
		            			Data86=Data86+","+"No86Data";
		            		else		            			
		            		{*/
		            			Data86=Data86+","+val;		            		
		            			
		            			if(!mt940FileRawrecords.get(index+1).startsWith(":"))
		            			{ 	
		            				Data86=Data86+mt940FileRawrecords.get(index+1).replaceAll("\\s+", "");
		            			}
		            		//}
		            	}
				    else if(mt940FileRawrecords.get(index).startsWith(":62F:") && match.group(2).trim().length()!=0)
				    	Data62F=val;
				    else if(mt940FileRawrecords.get(index).startsWith(":64:") && match.group(2).trim().length()!=0)
				    	Data64=val;
		            	
	            		
	            	i++;
	            }
	            if(mt940FileRawrecords.get(index).contains("-}"))
	            {
	            	if(Data61.trim().length()==0 && Data86.trim().length()==0)
	            	{
	            		record=Data20+","+Data25+","+Data28C+","+Data60F+","+Data62F+","+Data64;
	            		record=record.replaceAll(",$","");
	            		mt940records.add(record);
	            	}
	            	else if(Data86.trim().length()==0)
	            	{
	            		record=Data20+","+Data25+","+Data28C+","+Data60F+","+Data61+","+Data62F+","+Data64;
	            		record=record.replaceAll(",$","");
	            		record=record.replaceAll(",,*",",");
	            		mt940records.add(record);
	            	}
	            	else
	            	{
	            		String[] MulData61=Data61.split(",");
	            		String[] MulData86=Data86.split(",");
	            		if(MulData61.length!=0 && MulData86.length!=0)
	            			for(int l=0;l < MulData61.length;l++ )
	            			{	
	            				if(MulData61[l].trim().length()!=0 && MulData86[l].trim().length()!=0)
	            				{	record=Data20+","+Data25+","+Data28C+","+Data60F+","+MulData61[l]+","+MulData86[l]+","+Data62F+","+Data64;
	            				record=record.replaceAll(",$","");
	            				record=record.replaceAll(",,*",",");
	            					mt940records.add(record);
	            				}
	            			}
	            		else
	            			{	
	            				record=Data20+","+Data25+","+Data28C+","+Data60F+","+Data61+","+Data86+","+Data62F+","+Data64;
	            				record=record.replaceAll(",$","");
	            				mt940records.add(record);
	            			}
	            	}
	            	
	            	//System.out.println(record);
	            	record="";
	            	Data61="";
	            	Data86="";
	            	Data64="";
	            	i=0;
	            }
	            
	         }  
	        

	        br.close();  
		    
		return mt940records;
	}


	public ArrayList<String> getBAIRecordsFromFile( String forlderPath,String FilePath) throws IOException
	{
			ArrayList<String> mt940records= new ArrayList<String>();
			ArrayList<String> mt940FileRawrecords= new ArrayList<String>();
			
			FileInputStream in = new FileInputStream(FilePath);
		    BufferedReader br = new BufferedReader(new InputStreamReader(in));
		   
		    Pattern pattern;
            Matcher match;
	        String regex1 = "1:(.*?)\\}\\{2:(.*?)\\}";
	        String regex2 = "(:\\d\\d:|:\\d\\d.:)(.*)";
	        String regex3 = ":20:(\\d{8,8})(.*)";
	        String record = "",line="";
	        
	        String Data20="",Data25="",Data28C="",Data60F="",Data61="",Data62F="",Data64="",Data86="";
	        
	        int i=0;
	        
	        while ((line = br.readLine()) != null)   
	        {  
	        	mt940FileRawrecords.add(line);	        
	        }
	        
	        for (int index=0;index < mt940FileRawrecords.size() ; index++)
	       // while ((line = br.readLine()) != null)   
	        {  
	         	if(mt940FileRawrecords.get(index).matches(regex3))
	         	{
	         		pattern = Pattern.compile(regex3);
		            match = pattern.matcher(mt940FileRawrecords.get(index));
		            if(match.find()) 
		            {
		            	
		            	Data20=match.group(1).replace(",","").replaceAll("\\s+", "");		           
		            	continue;
		            }
	         		
	         	}
	            
	            if(mt940FileRawrecords.get(index).matches(regex2)) {
	            	
	            	pattern = Pattern.compile(regex2);
		            match = pattern.matcher(mt940FileRawrecords.get(index));
		            match.find(); 
		            String val=match.group(2).replace(",","").replaceAll("\\s+", "");
		            if(mt940FileRawrecords.get(index).startsWith(":25:") && match.group(2).trim().length()!=0)
	            		Data25=val;
	            	
		            else if(mt940FileRawrecords.get(index).startsWith(":28C:")  && match.group(2).trim().length()!=0)
	            		Data28C=val;
		            
	            	else if(mt940FileRawrecords.get(index).startsWith(":60F:") && match.group(2).trim().length()!=0)
		            	Data60F=val;
		            
		            else if(mt940FileRawrecords.get(index).startsWith(":61:"))
		            	 if(val.isEmpty())
		            		 Data61=Data61+","+"No61Data";
		            	 else
		            		 Data61=Data61.replaceAll("D0", "D")+","+val.replaceAll("C0,", "C");
		            
		            else if(mt940FileRawrecords.get(index).startsWith(":86:") )
		            	{
		            		if(val.isEmpty())
		            			Data86=Data86+","+"No86Data";
		            		else		            			
		            		{
		            			Data86=Data86+","+val;		            		
		            			
		            			if(!mt940FileRawrecords.get(index+1).startsWith(":"))
		            			{ 	
		            				Data86=Data86+mt940FileRawrecords.get(index+1).replaceAll("\\s+", "");
		            			}
		            		}
		            	}
				    else if(mt940FileRawrecords.get(index).startsWith(":62F:") && match.group(2).trim().length()!=0)
				    	Data62F=val;
				    else if(mt940FileRawrecords.get(index).startsWith(":64:") && match.group(2).trim().length()!=0)
				    	Data64=val;
		            	
	            		
	            	i++;
	            }
	            if(mt940FileRawrecords.get(index).contains("-}"))
	            {
	            	if(Data61.trim().length()==0 && Data86.trim().length()==0)
	            	{
	            		record=Data20+","+Data25+","+Data28C+","+Data60F+","+Data62F+","+Data64;
	            		record=record.replaceAll(",$","");
	            		mt940records.add(record);
	            	}
	            	else if(Data86.trim().length()==0)
	            	{
	            		record=Data20+","+Data25+","+Data28C+","+Data60F+","+Data61+","+Data62F+","+Data64;
	            		record=record.replaceAll(",$","");
	            		mt940records.add(record);
	            	}
	            	else
	            	{
	            		String[] MulData61=Data61.split(",");
	            		String[] MulData86=Data86.split(",");
	            		if(MulData61.length!=0 && MulData86.length!=0)
	            			for(int l=0;l < MulData61.length;l++ )
	            			{	
	            				if(MulData61[l].trim().length()!=0 && MulData86[l].trim().length()!=0)
	            				{	record=Data20+","+Data25+","+Data28C+","+Data60F+","+MulData61[l]+","+MulData86[l]+","+Data62F+","+Data64;
	            				record=record.replaceAll(",$","");
	            					mt940records.add(record);
	            				}
	            			}
	            		else
	            			{	
	            				record=Data20+","+Data25+","+Data28C+","+Data60F+","+Data61+","+Data86+","+Data62F+","+Data64;
	            				record=record.replaceAll(",$","");
	            				mt940records.add(record);
	            			}
	            	}
	            	
	            	//System.out.println(record);
	            	record="";
	            	Data61="";
	            	Data86="";
	            	Data64="";
	            	i=0;
	            }
	            
	         }  
	        

	        br.close();  
		    
		return mt940records;
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
				if(i==4)
					element[i]=element[i].replaceAll("\\.", "").trim();
				
				if(element[i].contains("No61Data"))
					continue;
				if(element[i].contains("No86Data"))
					continue;
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
			        if (AppRecords.get(counter).equals(DBRecords.get(counter))) {
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
