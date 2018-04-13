package com.selenium.codp.utilities;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class DataCompare {
	private static String val;
	private static Multimap<String, String> results;
	private static HashMap<String,String> dbdata;
	private static ArrayList<String[]> resdata;
	private static ArrayList<String> data;
	private static XMLUtil xmlUtil;
	
	public Multimap<String,String> compareXMLS(HashMap<String,String> appdata, HashMap<String,String> cisRCDTData){
		
		 results=ArrayListMultimap.create();
		
		for(Map.Entry e:cisRCDTData.entrySet()){
			//System.out.println(e.getKey()+": "+e.getValue());
			if(appdata.containsValue(e.getValue())){
				//System.out.println("Available"+e.getValue());
				val=e.getKey()+":"+e.getValue();
				results.put("Matched Records",val );
				
			}
			else{
				//System.out.println("Not Available"+e.getValue());
				val=e.getKey()+":"+e.getValue();
				results.put("UnMatched Records",val );
			}
		}
		
	//System.out.println(results);
			
		return results;
	}
	
	public ArrayList <String> compareAppDataCIMLogData(HashMap<String,String> appData, HashMap<String,String> CIMData){
		
		ArrayList <String> result  = new ArrayList <String>();
		
		for(Map.Entry e:CIMData.entrySet()){
			System.out.print("Key :"+e.getKey());
/*			System.out.println(" App Data :"+appData.get(e.getKey()));
			System.out.println("CIM Data :"+CIMData.get(e.getKey()));*/
			if(appData.get(e.getKey()).equals(CIMData.get(e.getKey()))){
				System.out.print("\t Matched : App Data :"+appData.get(e.getKey()));
				System.out.println("\t CIM Data :"+CIMData.get(e.getKey()));
				val=e.getKey()+":"+e.getValue();
				result.add("Matched Records  : "+val );
			}
			else{
				System.out.print("\t UnMatched : App Data :"+appData.get(e.getKey()));
				System.out.println("\t CIM Data :"+CIMData.get(e.getKey()));
				val=e.getKey()+":"+CIMData.get(e.getKey());
				result.add("UnMatched Records  : "+val );
			}
		}
		
			
		return result;
	}
	
	
	
	public Multimap<String,String> compareData(HashMap<String,String> appdata,ArrayList<String[]> dbnData){
		results=ArrayListMultimap.create();
		for(String[] s:dbnData){
			for(String n:s){
			if((appdata.containsValue(n))||(appdata.containsKey(n))){
				results.put("Matched Records",n );
				//break;
				
			}
			else{
				val=Arrays.deepToString(s);
				results.put("UnMatched Records",n );
			}
			}
		}
		
		return results;
				
		
	}
	public Multimap<String,String> compareData(ArrayList<String[]> dbnData,HashMap<String,String> appdata){
		results=ArrayListMultimap.create();
		for(String[] s:dbnData){
			for(String n:s){
			if((appdata.containsValue(n))||(appdata.containsKey(n))){
			
				results.put("Matched Records",n );
				//break;
				
			}
			else{
				if(n!=null){
				results.put("UnMatched Records",n );
				}
			
			}
			}
		}
		
		return results;
				
		
	}

	public Multimap<String,String> compareXMLS(TreeMap<String,String> appdata, TreeMap<String,String> cisRCDTData){
		
		 results=ArrayListMultimap.create();
		
		for(Map.Entry e:cisRCDTData.entrySet()){
			//System.out.println(e.getKey()+": "+e.getValue());
			if(appdata.containsValue(e.getValue())){
				//System.out.println("Available"+e.getValue());
				val=e.getKey()+":"+e.getValue();
				results.put("Matched Records",val );
				
			}
			else{
				//System.out.println("Not Available"+e.getValue());
				val=e.getKey()+":"+e.getValue();
				results.put("UnMatched Records",val );
			}
		}
		
	//System.out.println(results);
			
		return results;
	}
	
	
	
	public Multimap<String,String> compareXMLS(Multimap<String,String> appdata, Multimap<String,String> cisRCDTData){
		
		 results=ArrayListMultimap.create();
		
		for(Map.Entry<String,String> e:cisRCDTData.entries()){
							
			if(appdata.containsKey(e.getKey())){
				if(appdata.containsValue(e.getValue())){
					results.put("Matched Records",e.getKey()+": "+e.getValue() );
				}
				else{
					results.put("UnMatched Records",e.getKey()+": "+e.getValue() );
				}
				
			}
			else{
				results.put("UnMatched Records",e.getKey()+": "+e.getValue() );
			}
			
		}
			
		return results;
	}
	
	public Multimap<String,String> compareXMLS(ArrayList<String[]> appdata, ArrayList<String[]> cisRCDTData){
	
	resdata=new ArrayList<String[]>();
	data=new ArrayList<String>();
	 results=ArrayListMultimap.create();
	if(cisRCDTData.size()!=appdata.size()){
	System.out.println("Size not matched");
	}
	else{
		 //commonList=CollectionUtils.retainAll(appdata, cisRCDTData);
		
		
		
	for (String[] s : cisRCDTData) {
		int num=0;
		for (String[] m : appdata){
			num++;
				if(Arrays.deepToString(s).equals(Arrays.deepToString(m)))	
				{
					System.out.println("Matched Records: "+Arrays.deepToString(s));
					results.put("Matched Records",Arrays.deepToString(s) );
					num=0;
					break;
				}
				if(num==appdata.size())
				{
					results.put("UnMatched Records",Arrays.deepToString(s) );
					System.out.println("UnMatched Records: "+Arrays.deepToString(s));
					break;
					
				}
				
		}
	}
	}
	
	
	return results;
	
	
	}
		
	public Multimap<String,String> compareNostroGridBalances(HashMap<String,String> appdata, HashMap<String,Object> cisRCDTData){
		
		 results=ArrayListMultimap.create();
		 
		
		for(Map.Entry e:cisRCDTData.entrySet()){
			//System.out.println(e.getKey()+": "+e.getValue());
			if(appdata.containsValue(e.getValue())){
				//System.out.println("Available"+e.getValue());
				val=e.getKey()+":"+e.getValue();
				results.put("Matched Records",val );
				
			}
			else{
				//System.out.println("Not Available"+e.getValue());
				val=e.getKey()+":"+e.getValue();
				results.put("UnMatched Records",val );
			}
		}
		
	//System.out.println(results);
			
		return results;
	}
	public String executionstatus(Multimap<String,String> data){
		
		 results=ArrayListMultimap.create();
		 String status="Pass";
		
		for(Map.Entry e:data.entries()){
			
			if(data.containsKey("UnMatched Records")||(data.containsValue("Application data and db/CIS data not matched"))||(data.containsValue("No of app and db records not matched"))){
				status="Fail";
				break;
				
			}
			
		}
		
	//System.out.println(results);
			
		return status;
	}
	public String getDBSwiftMsg(HashMap<String,String> dbndata,int msgcount,String resultsPath){
		dbdata=new HashMap<String,String>();
		xmlUtil=new XMLUtil();
		ArrayList<String> obj=new ArrayList<String>();
		for(int i=1;i<=msgcount;i++){
			int j=i+1;
			//System.out.println(dbndata.get("MTMessage"+j));
			String xmlmsg=dbndata.get("MTMessage"+j).toString();
			obj.add(xmlmsg);
			
		}
		String name=xmlUtil.writeXMLfile(obj, "SwiftDbMsg", resultsPath);
		removeSwiftHeader(name);
		
		return name;
		
	}
//=======>>>>>>> .theirs	
	
	public void removeSwiftHeader(String FilePath){
		try {					
		File file=new File(FilePath);
		FileInputStream fis=null;
		BufferedInputStream bis=null;
		DataInputStream dis=null;
		fis=new FileInputStream(file);
		 dis=new DataInputStream(fis);
		 while(dis.available()!=0){
			//System.out.println(dis.readLine());
			 val=dis.readLine();
			 val=val.replace("</swift-msg><swift-msg isTrue=\"TRUE\" >", "");
			 //System.out.println(val);
			 
		 }
		 	FileWriter fstream=	new FileWriter(FilePath);
			BufferedWriter bw=new BufferedWriter(fstream);
				bw.write(val);
				bw.flush();
				bw.close();
			
	}
	catch (Exception e) {
		e.printStackTrace();
	}
		
	}		

	public static String executionstatus(ArrayList<String> data){
        
        results=ArrayListMultimap.create();
        String status="PASS";
        
        for(String s : data){
               
               if(s.contains("UnMatched")){
                     status="FAIL";
                     break;
                     
               }
               
        }
        return status;
	}
	
public static ArrayList<String> checkResults(ArrayList<String> data){
		ArrayList<String> result = new ArrayList<String>();
 		//ArrayList<List<String>> result = new ArrayList<List<String>>();
        String status="PASS",NotFoundElements="";
        
        for(String s : data){
               
               if(s.contains("NOT")){
                     status="FAIL";
                     if(NotFoundElements.trim().length()!=0)
                    	 NotFoundElements=s+","+NotFoundElements;
                     else
                    	 NotFoundElements=s;
                     //result.add(s);
                     //break;
                     
               }
               
        }
        result.add(status);
        result.add(NotFoundElements.replaceFirst(",", ""));
        return result;
	}

	
	 public static String prepareComparisonResultsExcelSheet(String fileName,String folderpath,HashMap<String,String> AppData,HashMap<String,String> CIMData, ArrayList <String> compareRecordsResultFinal ) throws Exception
	   {
		   
		    DateFormat df = new SimpleDateFormat("MM_dd_yyyy HH_mm_ss");
			java.util.Date today = Calendar.getInstance().getTime();        
			String reportDate = df.format(today);
			String resultFile=fileName+reportDate;

			
			WriteDBdata.writeExcelDataHashMap(resultFile, folderpath, "App Data",AppData);
			WriteDBdata.writeExcelDataHashMap(resultFile, folderpath, "CIM Log Data",CIMData);			
			WriteDBdata.writeExcelDataArrayList(resultFile, folderpath, "Result Sheet",compareRecordsResultFinal);

		   return resultFile;
		   
	   }
	
	


public Multimap<String,String> compareLists(List<Object[]> appdata, List<Object[]> cisdata){
	results=ArrayListMultimap.create();
	
	for (Object[] s : cisdata) {
		int num=0;
		for (Object[] m : appdata){
			num++;
				if(Arrays.deepToString(s).equals(Arrays.deepToString(m)))	
				{
					//System.out.println("Matched Records: "+Arrays.deepToString(s));
					results.put("Matched Records",Arrays.deepToString(s) );
					num=0;
					break;
				}
				if(num==appdata.size())
				{
					results.put("UnMatched Records",Arrays.deepToString(s) );
					//System.out.println("UnMatched Records: "+Arrays.deepToString(s));
					break;
					
				}
				
		}
	}
			
	return results;
			
	
}

public Multimap<String,String> compareList(List<Object[]> appdata, List<String[]> cisdata){
	results=ArrayListMultimap.create();
	
	for (String[] s : cisdata) {
		int num=0;
		for (Object[] m : appdata){
			num++;
				if(Arrays.deepToString(s).equals(Arrays.deepToString(m)))	
				{
					//System.out.println("Matched Records: "+Arrays.deepToString(s));
					results.put("Matched Records",Arrays.deepToString(s) );
					num=0;
					break;
				}
				if(num==appdata.size())
				{
					results.put("UnMatched Records",Arrays.deepToString(s) );
					//System.out.println("UnMatched Records: "+Arrays.deepToString(s));
					break;
					
				}
				
		}
	}
			
	return results;
			
	
}

public Multimap<String,String> compareData(List<String> appdata,List<String> dbnData){
	results=ArrayListMultimap.create();
	Collections.sort(appdata);
	Collections.sort(dbnData);
	
	
	 /*Collection<String> similar = new HashSet<String>( appdata );
     Collection<String> different = new HashSet<String>();
     
     
     different.addAll( appdata );
     different.addAll( dbnData );

     similar.retainAll( dbnData );
     different.removeAll( similar );
	
     System.out.println(similar);
     System.out.println(different);*/
     int m=0;
	if(dbnData.size()==appdata.size()){
		for(String d : dbnData){
			m=0;
			for(String a:appdata){
				m++;
				if(d.equals(a)){
					results.put("Matched Records",d );
					m=0;
					break;
				}
				 if(m==dbnData.size()){
					results.put("UnMatched Records",d );
					break;
				}
			}
			
		}
		
		

    /* for(int i=0;i<dbnData.size();i++){
    	 for(int j=0;i<dbnData.size();j++){
    	String myData1 = dbnData.get(i);
    	String myData2 = appdata.get(j);
    	
    	    if(myData1.equals(myData2)) {
    	    	results.put("Matched Records",myData1 );
    	    }
    	    else{
    	    	results.put("UnMatched Records",myData1 );
    	    }
     }
	}*/
	
	/*for(String s:dbnData){
		for(String e:appdata){
		
		if(s.contains(e)){
			results.put("Matched Records",n );
			//break;
			
		}
		else{
			
			results.put("UnMatched Records",n );
		}
		}
	}*/
	}
	else{
		results.put("Records","No of app and db records not matched" );
	}
	return results;
			
	
}
}