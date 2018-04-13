package com.selenium.codp.utilities;


	
	import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xalan.transformer.KeyIterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
	
	public class XMLUtil {
		private String name;
		private HashMap<String,String> map;
		private static String val;
		private static String  acctValue;
		private static String BalStatus="BalStatus:valid";

	//public static ArrayList<String> xmldata=null;

		public HashMap<String,String> readXMLData(String xmlFileName) throws Exception{
		
			map=new HashMap<String,String>();
				File xmlFile = new File(xmlFileName);
												
				DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
				Document document=dBuilder.parse(xmlFile);
				document.getDocumentElement().normalize();
				
				
				NodeList acctRecords=document.getElementsByTagName("BalRec");
				//int len=nodes.getLength();
				
				
				for(int i=0;i<acctRecords.getLength();i++){
					Element element=(Element)acctRecords.item(i);
					NodeList balRecords=element.getElementsByTagName("AcctBal");
					NodeList baldate=element.getElementsByTagName("EffDt");	
					NodeList AcctIdent=element.getElementsByTagName("AcctIdent");	
					
					//System.out.println("No of Balance Records"+balRecords.getLength());
					if(AcctIdent.getLength()>0){
						String AcctIdentType=element.getElementsByTagName("AcctIdentType").item(0).getTextContent();
						String acctValue=element.getElementsByTagName("AcctIdentValue").item(0).getTextContent();
						//System.out.println(AcctIdentType+":"+acctValue);
						map.put(AcctIdentType+i, acctValue);
					}
											
					if(baldate.getLength()>0){
					
					String date1=element.getElementsByTagName("EffDt").item(2).getTextContent();
					String[] d1=date1.split("T");
					date1=d1[0];
					DateFormat orgformat=new SimpleDateFormat("yyyy-MM-dd");
					DateFormat finalformat=new SimpleDateFormat("dd/MM/yyyy");
					Date date=orgformat.parse(date1);
					String mydate=finalformat.format(date);
					//System.out.println(mydate);
					map.put("Date"+i,mydate);
										
					}
					
					
									
					String balstatuscode=element.getElementsByTagName("BalStatusCode").item(0).getTextContent();
					//System.out.println(balstatuscode);	
					if(!balstatuscode.contains("valid")){
					map.put("balstatuscode"+i, balstatuscode);
				}
					
					for(int j=0;j<balRecords.getLength();j++){
							
												
						if(element.getNodeType()==Node.ELEMENT_NODE){
																												
									String tagName=element.getElementsByTagName("BalType").item(j).getTextContent();
									String bal=element.getElementsByTagName("Amt").item(j).getTextContent();
									map.put(tagName+i, bal);
									//System.out.println(tagName+": "+bal);
																	
						}
					}
						
							
					
				}
				
				return map;
				
								
				
				}
		/*public HashMap<String,String> readXMLData(String xmlFileName) throws Exception{
			
			
			//List<HashMap<String,String>> data=new ArrayList<HashMap<String,String>>();
				
			map=new HashMap<String,String>();
				File xmlFile = new File(xmlFileName);
												
				DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
				Document document=dBuilder.parse(xmlFile);
				document.getDocumentElement().normalize();
				
				
				NodeList acctRecords=document.getElementsByTagName("BalRec");
				//int len=nodes.getLength();
				
				
				for(int i=0;i<acctRecords.getLength();i++){
					
					Element element=(Element)acctRecords.item(i);
					NodeList balRecords=element.getElementsByTagName("AcctBal");
					NodeList baldate=element.getElementsByTagName("EffDt");	
					NodeList AcctIdent=element.getElementsByTagName("AcctIdent");	
					
					//System.out.println("No of Balance Records"+balRecords.getLength());
					if(AcctIdent.getLength()>0){
						String AcctIdentType=element.getElementsByTagName("AcctIdentType").item(0).getTextContent();
						String acctValue=element.getElementsByTagName("AcctIdentValue").item(0).getTextContent();
						//System.out.println(AcctIdentType+":"+acctValue);
						map.put(AcctIdentType, acctValue);
					}
											
					if(baldate.getLength()>0){
					
					String date1=element.getElementsByTagName("EffDt").item(0).getTextContent();
					String[] d1=date1.split("T");
					date1=d1[0];
					DateFormat orgformat=new SimpleDateFormat("yyyy-MM-dd");
					DateFormat finalformat=new SimpleDateFormat("dd/MM/yyyy");
					Date date=orgformat.parse(date1);
					String mydate=finalformat.format(date);
					//System.out.println(mydate);
					map.put(acctValue+" Date",mydate);
										
					}
					
					
									
					String balstatuscode=element.getElementsByTagName("BalStatusCode").item(0).getTextContent();
					//System.out.println(balstatuscode);	
					if(!balstatuscode.contains("valid")){
					map.put(acctValue+" balstatuscode", balstatuscode);
				}
					
					for(int j=0;j<balRecords.getLength();j++){
							
												
						if(element.getNodeType()==Node.ELEMENT_NODE){
																												
									String tagName=element.getElementsByTagName("BalType").item(j).getTextContent();
									String bal=element.getElementsByTagName("Amt").item(j).getTextContent();
									map.put(acctValue+" "+tagName, bal);
									//System.out.println(tagName+": "+bal);
																	
						}
					}
						
					//data.add(map);		
					
				}
				
				return map;
				
								
				
				}	
		*/
		public List<Object[]> readCISRBXMLData(String xmlFileName) throws Exception{
			
			
			//List<HashMap<String,String>> data=new ArrayList<HashMap<String,String>>();
			List<Object[]> allrows=new ArrayList<Object[]>();
			List<String> rowdata = null;	
			//map=new HashMap<String,String>();
				File xmlFile = new File(xmlFileName);
												
				DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
				Document document=dBuilder.parse(xmlFile);
				document.getDocumentElement().normalize();
				
				
				NodeList acctRecords=document.getElementsByTagName("BalRec");
				//int len=nodes.getLength();
				
				
				for(int i=0;i<acctRecords.getLength();i++){
					String OpeningAvail="OpeningAvail:--";
					String Ledger="Ledger:--";
					String Avail="Avail:--";
					String Current="Current:--";
					String AvailableFund="AvailableFund:--";
					String AcctNum=null;
					String Date=null;
					rowdata=new ArrayList<String>();
					
					Element element=(Element)acctRecords.item(i);
					NodeList balRecords=element.getElementsByTagName("AcctBal");
					NodeList baldate=element.getElementsByTagName("EffDt");	
					NodeList AcctIdent=element.getElementsByTagName("AcctIdent");	
					
					//System.out.println("No of Balance Records"+balRecords.getLength());
					if(AcctIdent.getLength()>0){
						String AcctIdentType=element.getElementsByTagName("AcctIdentType").item(0).getTextContent();
						String acctValue=element.getElementsByTagName("AcctIdentValue").item(0).getTextContent();
						//System.out.println(AcctIdentType+":"+acctValue);
						AcctNum="AcctNum:"+acctValue;
						//rowdata.add("AcctNum-"+acctValue);
						//map.put(AcctIdentType, acctValue);
					}
											
					if(baldate.getLength()>0){
					
					String date1=element.getElementsByTagName("EffDt").item(0).getTextContent();
					String[] d1=date1.split("T");
					date1=d1[0];
					DateFormat orgformat=new SimpleDateFormat("yyyy-MM-dd");
					DateFormat finalformat=new SimpleDateFormat("dd/MM/yyyy");
					Date date=orgformat.parse(date1);
					String mydate=finalformat.format(date);
					//System.out.println(mydate);
					Date="Date:"+mydate;
					//rowdata.add("Date-"+mydate);
					//map.put(acctValue+" Date",mydate);
										
					}
					
					
									
					String balstatuscode=element.getElementsByTagName("BalStatusCode").item(0).getTextContent();
					//System.out.println(balstatuscode);	
					BalStatus="BalStatus:"+balstatuscode;
					/*if(!balstatuscode.contains("valid")){
						BalStatus="BalStatus:"+balstatuscode;
						//rowdata.add("BalStatus-"+balstatuscode);	
					//map.put(acctValue+" balstatuscode", balstatuscode);
					}*/
					
					for(int j=0;j<balRecords.getLength();j++){
							
												
						if(element.getNodeType()==Node.ELEMENT_NODE){
																												
									String tagName=element.getElementsByTagName("BalType").item(j).getTextContent();
									String bal=element.getElementsByTagName("Amt").item(j).getTextContent();
									
									switch(tagName){
										case "OpeningAvail":
											OpeningAvail=tagName+":"+bal;
											//rowdata.add("tagName-"+bal);	
										break;
										case "Ledger":
											Ledger=tagName+":"+bal;
											//rowdata.add("tagName-"+bal);	
										break;
										case "Avail":
											Avail=tagName+":"+bal;
											//rowdata.add("tagName-"+bal);	
										break;
										case "Current":
											Current=tagName+":"+bal;
											//rowdata.add("tagName-"+bal);	
										break;
										case "AvailableFund":
											AvailableFund=tagName+":"+bal;
											//rowdata.add("tagName-"+bal);	
										break;
										
									}
									
									//map.put(acctValue+" "+tagName, bal);
									//System.out.println(tagName+": "+bal);
																	
						}
					}
					
					
					rowdata=Arrays.asList(AcctNum,Date,OpeningAvail,Ledger,Avail,Current,AvailableFund);
					if(BalStatus.contains("valid")){
					allrows.add(rowdata.toArray());
					}
				}
				
				
				/*for(Object[] obj:allrows){
					System.out.println(Arrays.deepToString(obj));
				}*/
				
				return allrows;
				
								
				
				}	
		
	public List<Object[]> readCISNostroRBXMLData(String xmlFileName) throws Exception{
			
			
			//List<HashMap<String,String>> data=new ArrayList<HashMap<String,String>>();
			List<Object[]> allrows=new ArrayList<Object[]>();
			List<String> rowdata = null;	
			//map=new HashMap<String,String>();
				File xmlFile = new File(xmlFileName);
												
				DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
				Document document=dBuilder.parse(xmlFile);
				document.getDocumentElement().normalize();
				
				
				NodeList acctRecords=document.getElementsByTagName("BalRec");
				//int len=nodes.getLength();
				
				
				for(int i=0;i<acctRecords.getLength();i++){
					String CurCode="CurCode:--";
					String Ledger="Ledger:--";
					String Current="Current:--";
					String AcctNum=null;
					String Date=null;
					rowdata=new ArrayList<String>();
					
					Element element=(Element)acctRecords.item(i);
					NodeList balRecords=element.getElementsByTagName("AcctBal");
					NodeList baldate=element.getElementsByTagName("EffDt");	
					NodeList AcctIdent=element.getElementsByTagName("AcctIdent");	
					
					//System.out.println("No of Balance Records"+balRecords.getLength());
					if(AcctIdent.getLength()>0){
						//String AcctIdentType=element.getElementsByTagName("AcctIdentType").item(0).getTextContent();
						String acctValue=element.getElementsByTagName("AcctIdentValue").item(0).getTextContent();
						//System.out.println(AcctIdentType+":"+acctValue);
						AcctNum="AcctNum:"+acctValue;
						//rowdata.add("AcctNum-"+acctValue);
						//map.put(AcctIdentType, acctValue);
					}
											
					if(baldate.getLength()>0){
					
					String date1=element.getElementsByTagName("EffDt").item(2).getTextContent();
					String[] d1=date1.split("T");
					date1=d1[0];
					DateFormat orgformat=new SimpleDateFormat("yyyy-MM-dd");
					DateFormat finalformat=new SimpleDateFormat("dd/MM/yyyy");
					Date date=orgformat.parse(date1);
					String mydate=finalformat.format(date);
					//System.out.println(mydate);
					Date="Date:"+mydate;
											
					}
					
					String currCode=element.getElementsByTagName("Value").item(0).getTextContent();
					//System.out.println(currCode);
					CurCode="CurCode:"+currCode;
									
					String balstatuscode=element.getElementsByTagName("BalStatusCode").item(0).getTextContent();
					//System.out.println(balstatuscode);	
					BalStatus="BalStatus:"+balstatuscode;
					/*if(!balstatuscode.contains("valid")){
						BalStatus="BalStatus:"+balstatuscode;
						//rowdata.add("BalStatus-"+balstatuscode);	
					//map.put(acctValue+" balstatuscode", balstatuscode);
					}*/
					
					for(int j=0;j<balRecords.getLength();j++){
							
												
						if(element.getNodeType()==Node.ELEMENT_NODE){
																												
									String tagName=element.getElementsByTagName("BalType").item(j).getTextContent();
									String bal=element.getElementsByTagName("Amt").item(j).getTextContent();
									
									switch(tagName){
										case "Ledger":
											Ledger=tagName+":"+bal;
										break;
										case "Current":
											Current=tagName+":"+bal;
										break;
									}
							}
					}
					
					
					rowdata=Arrays.asList(AcctNum,Date,Current,Date,CurCode,Ledger);
					if(BalStatus.contains("valid")){
					allrows.add(rowdata.toArray());
					}
				}
				
				
				/*for(Object[] obj:allrows){
					System.out.println(Arrays.deepToString(obj));
				}*/
				
				return allrows;
				
								
				
				}	
		
		public String createResultsFolder(String FileName){
			
			DateFormat dateFormat = new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss");
			Calendar cal = Calendar.getInstance();
			String dt = dateFormat.format(cal.getTime());
			String s = FileName + dt;
			String FilePath="C:\\Users\\samala\\Test Results\\";
			File dir=new File(FilePath+s);
			dir.mkdir();
		return FilePath+s;
		}
		
		
		
		public String writeXMLfile(String xmlfile,String FileName,String FilePath){
			try{
				DateFormat dateFormat = new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss");
				Calendar cal = Calendar.getInstance();
				String dt = dateFormat.format(cal.getTime());
				String s = FileName + dt;
				name=FilePath+"\\"+s+".xml";
			FileWriter fstream=	new FileWriter(name,true);
			BufferedWriter bw=new BufferedWriter(fstream);
			
			bw.write(xmlfile);
			bw.flush();
			bw.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return name;
			
		}
		public String writeXMLfile(ArrayList<String> xmlfile,String FileName,String FilePath){
			try{
				DateFormat dateFormat = new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss");
				Calendar cal = Calendar.getInstance();
				String dt = dateFormat.format(cal.getTime());
				String s = FileName + dt;
				name=FilePath+"\\"+s+".xml";
			FileWriter fstream=	new FileWriter(name,true);
			BufferedWriter bw=new BufferedWriter(fstream);
			
			for(int i=0;i<xmlfile.size();i++){
				bw.write(xmlfile.get(i));
				bw.flush();
			}
			
			bw.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return name;
			
		}
		
		/*public String writeXMLfile(String xmlfile,String FileName,String FilePath){
		DateFormat dateFormat = new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss");
		Calendar cal = Calendar.getInstance();
		String dt = dateFormat.format(cal.getTime());
		String s = "sample" + dt;
		String name=FileName+"\\"+s+".txt";
		BufferedWriter bw=new BufferedWriter(new FileWriter(name));
		Iterator itr=lst.iterator();
		while (itr.hasNext()){
		bw.write(itr.next().toString());
	}
	
	bw.close();
		}*/
		
		/*public List<HashMap<String,String>> readRCDTXMLData(String xmlFileName) throws Exception{
			//xmlFileName="C:\\Users\\perumans\\data\\Test Results\\IntradayNostroAccountActivityTest_18_06_2015_03_34_55\\RBResponse_18_06_2015_03_38_29.xml";
				File xmlFile = new File(xmlFileName);
				List<HashMap<String,String>> list=new ArrayList<HashMap<String,String>>();	
				DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
				Document document=dBuilder.parse(xmlFile);
				document.getDocumentElement().normalize();
				
				HashMap<String,String> data;
				
				NodeList acctnum=document.getElementsByTagName("AcctRef");
				Element acc=(Element)acctnum.item(0);
				String country=acc.getElementsByTagName("Country").item(0).getTextContent();
				//System.out.println(acctNum);
			
				
				NodeList nodes=document.getElementsByTagName("AcctTrnRef");
				
				int len=nodes.getLength();
				System.out.println("No of Account Records"+len);
				if(len==0){
					data=new HashMap<String,String>();
					data.put("Intraday Transactions", "No Records");
				}
				else{
				for(int i=0;i<len;i++){	
					data=new HashMap<String,String>();
					Element element=(Element)nodes.item(i);					
					NodeList prcdt=document.getElementsByTagName("PrcDt");
					NodeList PostedDt=document.getElementsByTagName("PostedDt");
					
					if(PostedDt.getLength()!=0){
						String date1=element.getElementsByTagName("PostedDt").item(0).getTextContent();
						String[] d1=date1.split("T");
						date1=d1[0];
						String time=d1[1];
						if(time.contains(".000")){
							time=time.replace(".000","");
							}
						data.put("Process time"+i,time);
						String mydate=getTagValue(date1);
						data.put("Post Date",mydate);
						
						}	
					
					if(prcdt.getLength()!=0){
					String date1=element.getElementsByTagName("PrcDt").item(0).getTextContent();
					String[] d1=date1.split("T");
					date1=d1[0];
					String time=d1[1];
					if(time.contains(".000")){
						time=time.replace(".000","");
						}
					if(country.equalsIgnoreCase("NZ")){
					SimpleDateFormat df=new SimpleDateFormat("HH:mm:SS");
					Date d=df.parse(time);
					Calendar cal=Calendar.getInstance();
					cal.setTime(d);
					cal.add(Calendar.HOUR, 2);
					time=df.format(cal.getTime());
					//System.out.println(time);
					}
					data.put("Process time",time);
					String mydate=getTagValue(date1);
					data.put("Post Date",mydate);
					
					}		
					
					NodeList EffDt=document.getElementsByTagName("EffDt");
					if(EffDt.getLength()!=0){
					String date2=element.getElementsByTagName("EffDt").item(0).getTextContent();
					String[] d2=date2.split("T");
					date2=d2[0];
					String mydate=getTagValue(date2);
					data.put("Value Date",mydate );
					}
					
					NodeList node3=document.getElementsByTagName("TotalCurAmt");
					if(node3.getLength()>0){
					Element element2=(Element)node3.item(i);
					String Amount=element2.getElementsByTagName("Amt").item(0).getTextContent();
					
					if (Amount.matches("-*\\d*\\.\\d0*$")) {
						// remove
						if(Amount.matches("-*\\d*\\.0*$")){
							Amount=Amount.replaceAll("\\.0*$", "");
						//System.out.println(Amount);
						}
						else{
							Amount=Amount.replaceAll("0*$", "");
							//System.out.println(Amount);
						}
					
				}
					
					
					
					if(Amount.contains("-")){
						Amount=Amount.replace("-", "").trim();
						
						data.put("Debits",Amount );
					}
					else{
						data.put("Credits",Amount );
					}
					
					}
					NodeList node4=document.getElementsByTagName("StmtRunningBal");
					if(node4.getLength()>0){
					Element element2=(Element)node4.item(i);
					String StmtRunningBal=element2.getElementsByTagName("Amt").item(0).getTextContent();
					data.put("StmtRunningBal", StmtRunningBal);
					}
					
					NodeList Memos=document.getElementsByTagName("Memo");
					if(Memos.getLength()>0){
					String Memo=element.getElementsByTagName("Memo").item(0).getTextContent().trim();
					data.put("Memo", Memo);
					}
					NodeList BankRefs=element.getElementsByTagName("RefData");
					//System.out.println(BankRefs.getLength());
					if(BankRefs.getLength()>1){
					String BankRef=element.getElementsByTagName("RefIdent").item(1).getTextContent();
					//System.out.println(BankRef);
					data.put("BankRef", BankRef);
					}
					
					list.add(data);
					
				
				}
				}return list;
				
				}*/
		
		public HashMap<String,String> readRCDTXMLData(String xmlFileName) throws Exception{
			//xmlFileName="C:\\Users\\perumans\\data\\Test Results\\IntradayNostroAccountActivityTest_18_06_2015_03_34_55\\RBResponse_18_06_2015_03_38_29.xml";
				File xmlFile = new File(xmlFileName);
					
				DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
				Document document=dBuilder.parse(xmlFile);
				document.getDocumentElement().normalize();
				
				HashMap<String,String> data=new HashMap<String,String>();
				NodeList nodes=document.getElementsByTagName("AcctTrnRef");
				
				int len=nodes.getLength();
				System.out.println("No of Account Records"+len);
				if(len==0){
					data.put("Intraday Transactions", "No Records");
				}
				else{
					NodeList acctnum=document.getElementsByTagName("AcctRef");
					Element acc=(Element)acctnum.item(0);
					String country=acc.getElementsByTagName("Country").item(0).getTextContent();
					//System.out.println(acctNum);
				for(int i=0;i<len;i++){	
					Element element=(Element)nodes.item(i);					
					NodeList prcdt=document.getElementsByTagName("PrcDt");
					NodeList PostedDt=document.getElementsByTagName("PostedDt");
					
					if(PostedDt.getLength()!=0){
						String date1=element.getElementsByTagName("PostedDt").item(0).getTextContent();
						String[] d1=date1.split("T");
						date1=d1[0];
						String time=d1[1];
						if(time.contains(".000")){
							time=time.replace(".000","");
							}
						data.put("Process time"+i,time);
						String mydate=getTagValue(date1);
						data.put("Post Date"+i,mydate);
						
						}	
					
					if(prcdt.getLength()!=0){
					String date1=element.getElementsByTagName("PrcDt").item(0).getTextContent();
					String[] d1=date1.split("T");
					date1=d1[0];
					String time=d1[1];
					if(time.contains(".000")){
						time=time.replace(".000","");
						}
					if(country.equalsIgnoreCase("NZ")){
					SimpleDateFormat df=new SimpleDateFormat("HH:mm:SS");
					Date d=df.parse(time);
					Calendar cal=Calendar.getInstance();
					cal.setTime(d);
					cal.add(Calendar.HOUR, 2);
					time=df.format(cal.getTime());
					//System.out.println(time);
					}
					data.put("Process time"+i,time);
					String mydate=getTagValue(date1);
					data.put("Post Date"+i,mydate);
					
					}		
					
					NodeList EffDt=document.getElementsByTagName("EffDt");
					if(EffDt.getLength()!=0){
					String date2=element.getElementsByTagName("EffDt").item(0).getTextContent();
					String[] d2=date2.split("T");
					date2=d2[0];
					String mydate=getTagValue(date2);
					data.put("Value Date"+i,mydate );
					}
					
					NodeList node3=document.getElementsByTagName("TotalCurAmt");
					if(node3.getLength()>0){
					Element element2=(Element)node3.item(i);
					String Amount=element2.getElementsByTagName("Amt").item(0).getTextContent();
					
					if (Amount.matches("-*\\d*\\.\\d0*$")) {
						// remove
						if(Amount.matches("-*\\d*\\.0*$")){
							Amount=Amount.replaceAll("\\.0*$", "");
						//System.out.println(Amount);
						}
						else{
							Amount=Amount.replaceAll("0*$", "");
							//System.out.println(Amount);
						}
					
				}
					
					
					
					if(Amount.contains("-")){
						Amount=Amount.replace("-", "").trim();
						
						data.put("Debits"+i,Amount );
					}
					else{
						data.put("Credits"+i,Amount );
					}
					
					}
					NodeList node4=document.getElementsByTagName("StmtRunningBal");
					if(node4.getLength()>0){
					Element element2=(Element)node4.item(i);
					String StmtRunningBal=element2.getElementsByTagName("Amt").item(0).getTextContent();
					data.put("StmtRunningBal"+i, StmtRunningBal);
					}
					
					NodeList Memos=document.getElementsByTagName("Memo");
					if(Memos.getLength()>0){
					String Memo=element.getElementsByTagName("Memo").item(0).getTextContent().trim();
					data.put("Memo"+i, Memo);
					}
					NodeList BankRefs=element.getElementsByTagName("RefData");
					//System.out.println(BankRefs.getLength());
					if(BankRefs.getLength()>1){
					String BankRef=element.getElementsByTagName("RefIdent").item(1).getTextContent();
					//System.out.println(BankRef);
					data.put("BankRef"+i, BankRef);
					}
					
					
				
				}
				}return data;
				
				}
		
		public String getTagValue(String date1) throws Exception{
			DateFormat orgformat=new SimpleDateFormat("yyyy-MM-dd");
			DateFormat finalformat=new SimpleDateFormat("dd/MM/yyyy");
			Date date=orgformat.parse(date1);
			String mydate=finalformat.format(date);
			//System.out.println(mydate);
			return mydate;
			
		}
		
		
		public Multimap<String,String> compareXMLS(HashMap<String,String> appdata, HashMap<String,String> cisRCDTData){
			
			Multimap<String, String> results=ArrayListMultimap.create();
			
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
	
	
	public HashMap<String,String> readRealTimeSwiftXMLMsg() throws Exception{
		
			File xmlFile = new File("C:\\Users\\perumans\\sample123.xml");
			
			DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
			Document document=dBuilder.parse(xmlFile);
			document.getDocumentElement().normalize();
			
			HashMap<String,String> data=new HashMap<String,String>();
		
			
			NodeList nodes=document.getElementsByTagName("header");
			
			int len=nodes.getLength();
			//System.out.println("No of header Records"+len);
			
			for(int i=0;i<len;i++){	
				Element element=(Element)nodes.item(i);
							
				String Block1=element.getElementsByTagName("line").item(0).getTextContent();
				String Block2=element.getElementsByTagName("line").item(1).getTextContent();
				data.put("Block1",Block1 );
				data.put("Block2",Block2 );
				
			}
			NodeList nodes2=document.getElementsByTagName("tag");
			int detailslength=nodes2.getLength();
			//System.out.println("No of tag Records"+detailslength);
			for(int j=0;j<detailslength;j++){
				Element element2=(Element)nodes2.item(j);
				String tagval =element2.getAttribute("id");
				String val =element2.getAttribute("value");
				data.put(tagval, val);
								
			}
	
		return data;
	
	}
	
	
	public HashMap<String,String> readRealTimedbSwiftMsgs(String FilePath) throws Exception{
		
		File xmlFile = new File(FilePath);
			
		DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		dBuilder = dbFactory.newDocumentBuilder();
		Document document=dBuilder.parse(xmlFile);
		document.getDocumentElement().normalize();
		
		HashMap<String,String> data=new HashMap<String,String>();
	
		NodeList nodes=document.getElementsByTagName("header");
		
		int len=nodes.getLength();
		//System.out.println("No of header Records"+len);
		
		for(int i=0;i<len;i++){	
			Node node1=nodes.item(i);
			NodeList chlist=node1.getChildNodes();
			
			for(int j=0;j<chlist.getLength();j++){
				Node chilnode=chlist.item(j);
				String val=chilnode.getTextContent();
				//System.out.println(val);
				switch(j){
				case 0:
					data.put("Block1"+i, val);
					break;
				case 1:
					data.put("Block2"+i, val);
					break;
				case 2:
					data.put("Block3"+i, val);
					break;
					
				}
			}
		}		
		
		NodeList nodes1=document.getElementsByTagName("details");
		//System.out.println("detail records"+nodes1.getLength());
		for(int m=0;m<nodes1.getLength();m++){
		
			Node node=nodes1.item(m);
			NodeList childnodes=node.getChildNodes();
		
		for(int h=0;h<childnodes.getLength();h++){
			Node cnode=childnodes.item(h);
			String content=cnode.getAttributes().getNamedItem("id").getNodeValue();
			String content2=cnode.getAttributes().getNamedItem("value").getNodeValue();
			//System.out.println(content+": "+content2);
			data.put(content+m, content2);
			
			
		}
		}
	
		return data;
		
		
	
	}
	public HashMap<String,String> getCISCurrentdata(HashMap<String,String> cisdata){
		Set KeySet=cisdata.keySet();
		Iterator key= KeySet.iterator();
		while(key.hasNext()){
			String val=(String) key.next();
			if(cisdata.get(val).contains("NotAvail")){
				key.remove();
			}
			
		}
		
	/*	HashMap<String,String> itr=cisdata.listIterator();
		while(itr.hasNext()){
			//System.out.println(itr.next());
			Iterator it = itr.next().entrySet().iterator();
			while(it.hasNext()){
			Map.Entry<String, String> map1=(Map.Entry)it.next();
			//System.out.println(map1.getKey()+':'+map1.getValue());			
			if(map1.getValue().contains("NotAvail")){
				//data.remove();
				itr.remove();
				break;
				
			}
			
		}
		}*/
		return cisdata;
		
	}
	
	public HashMap <String,String> readCIMxmlFile(String xmlFileName) throws ParserConfigurationException, SAXException, IOException
	{
		HashMap <String,String> CIMData=new HashMap<String,String>();
		
		File xmlFile = new File(xmlFileName);
		
		DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
		Document document=dBuilder.parse(xmlFile);
		document.getDocumentElement().normalize();
		
		NodeList nList = document.getElementsByTagName("GetCaseDetails");
		
		
		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);
					
			NodeList timeStamp=document.getElementsByTagName("TimeStamp");	
					
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
					if(eElement.getElementsByTagName("DebitAmount").item(0).getTextContent().length()>0)
						CIMData.put("DebitAmount", eElement.getElementsByTagName("DebitAmount").item(0).getTextContent().trim());
					else
						CIMData.put("DebitAmount","---");
					if(eElement.getElementsByTagName("CaseID").item(0).getTextContent().trim().length()>0)
						CIMData.put("CaseID", eElement.getElementsByTagName("CaseID").item(0).getTextContent().trim());
					else 	
						CIMData.put("CaseID", "---");	
					 if(eElement.getElementsByTagName("CaseReopenedDate").item(0).getTextContent().trim().length()>0)
					 {
						 String dt[]=eElement.getElementsByTagName("CaseReopenedDate").item(0).getTextContent().split("T");
						CIMData.put("CaseReopenedDate", dt[0].trim());
					 }
					else 
						CIMData.put("CaseReopenedDate", "---");
					 if(eElement.getElementsByTagName("AccountCurrency").item(0).getTextContent().trim().length()>0)
						CIMData.put("AccountCurrency", eElement.getElementsByTagName("AccountCurrency").item(0).getTextContent().trim());
					else 
						CIMData.put("AccountCurrency", "---");
					 if(eElement.getElementsByTagName("ClosedDate").item(0).getTextContent().trim().length()>0)
						CIMData.put("ClosedDate", eElement.getElementsByTagName("ClosedDate").item(0).getTextContent().trim());
					else 
							CIMData.put("ClosedDate", "---");
					 if(eElement.getElementsByTagName("TransactionDate").item(0).getTextContent().trim().length()>0)
						CIMData.put("TransactionDate", eElement.getElementsByTagName("TransactionDate").item(0).getTextContent().trim());
					else 
							CIMData.put("TransactionDate", "---");
					 if(eElement.getElementsByTagName("DebitValueDate").item(0).getTextContent().trim().length()>0)
						CIMData.put("DebitValueDate", eElement.getElementsByTagName("DebitValueDate").item(0).getTextContent().trim());
					else 
							CIMData.put("DebitValueDate", "---");
					 if(eElement.getElementsByTagName("InquiryDate").item(0).getTextContent().trim().length()>0)
						CIMData.put("InquiryDate", eElement.getElementsByTagName("InquiryDate").item(0).getTextContent().trim());
					 else
						CIMData.put("InquiryDate", "---");
					 if(eElement.getElementsByTagName("InquiryAmount").item(0).getTextContent().trim().length()>0)
						CIMData.put("InquiryAmount", eElement.getElementsByTagName("InquiryAmount").item(0).getTextContent().trim());
					 else 
						CIMData.put("InquiryAmount","---");
					 if(eElement.getElementsByTagName("CreditAmount").item(0).getTextContent().trim().length()>0)
						CIMData.put("CreditAmount", eElement.getElementsByTagName("CreditAmount").item(0).getTextContent().trim());
					else 
						CIMData.put("CreditAmount", "---");
					 if(eElement.getElementsByTagName("TransactionReference").item(0).getTextContent().trim().length()>0)
						CIMData.put("TransactionReference", eElement.getElementsByTagName("TransactionReference").item(0).getTextContent().trim());
					else  	
						CIMData.put("TransactionReference", "---");
					 if(eElement.getElementsByTagName("Case_Type").item(0).getTextContent().trim().length()>0)
						CIMData.put("Case_Type", eElement.getElementsByTagName("Case_Type").item(0).getTextContent().trim());
					else 
						CIMData.put("Case_Type", "---");
					 if(eElement.getElementsByTagName("InquiryCrDr").item(0).getTextContent().trim().length()>0)
						CIMData.put("InquiryCrDr", eElement.getElementsByTagName("InquiryCrDr").item(0).getTextContent().trim());
					else 
						CIMData.put("InquiryCrDr", "---");
					 if(eElement.getElementsByTagName("TransactionType").item(0).getTextContent().trim().length()>0)
						CIMData.put("TransactionType", eElement.getElementsByTagName("TransactionType").item(0).getTextContent().trim());
					else 
						CIMData.put("TransactionType", "---");
					 if(eElement.getElementsByTagName("Description").item(0).getTextContent().trim().length()>0)
						CIMData.put("Description", eElement.getElementsByTagName("Description").item(0).getTextContent().trim());
					else 
						CIMData.put("Description", "---");
					 if(eElement.getElementsByTagName("DebitAmountCurrency").item(0).getTextContent().trim().length()>0)
						CIMData.put("DebitAmountCurrency", eElement.getElementsByTagName("DebitAmountCurrency").item(0).getTextContent().trim());
					else 
						CIMData.put("DebitAmountCurrency", "---");
					 if(eElement.getElementsByTagName("CreditValueDate").item(0).getTextContent().trim().length()>0)
						CIMData.put("CreditValueDate", eElement.getElementsByTagName("CreditValueDate").item(0).getTextContent().trim());	
					else 
						CIMData.put("CreditValueDate", "---");	
					 if(eElement.getElementsByTagName("CaseStatus").item(0).getTextContent().trim().length()>0)
						CIMData.put("CaseStatus", eElement.getElementsByTagName("CaseStatus").item(0).getTextContent().trim());
					else 
						CIMData.put("CaseStatus", "---");
					 if(eElement.getElementsByTagName("Account_Number").item(0).getTextContent().trim().length()>0)
						CIMData.put("Account_Number", eElement.getElementsByTagName("Account_Number").item(0).getTextContent().trim()
								.replace("MDZ-NZW-", ""));
					else 
						CIMData.put("Account_Number", "---");
					 if(eElement.getElementsByTagName("IncomingTRN").item(0).getTextContent().trim().length()>0)
						CIMData.put("IncomingTRN", eElement.getElementsByTagName("IncomingTRN").item(0).getTextContent().trim());
					else 
						CIMData.put("IncomingTRN","---");
					 if(eElement.getElementsByTagName("DebitAmount").item(0).getTextContent().trim().length()>0)
						CIMData.put("DebitAmount", eElement.getElementsByTagName("DebitAmount").item(0).getTextContent().trim());
					else 
						CIMData.put("DebitAmount", "---");
					 if(eElement.getElementsByTagName("SwiftBIC").item(0).getTextContent().trim().length()>0)
						CIMData.put("SwiftBIC", eElement.getElementsByTagName("SwiftBIC").item(0).getTextContent().trim());
					else 
						CIMData.put("SwiftBIC", "---");
					 if(eElement.getElementsByTagName("LastPublicUpdateTimeStamp").item(0).getTextContent().trim().length()>0)
						CIMData.put("LastPublicUpdateTimeStamp", eElement.getElementsByTagName("LastPublicUpdateTimeStamp").item(0).getTextContent().trim()
								.replaceAll("T.*GMT", ""));
					else 
						CIMData.put("LastPublicUpdateTimeStamp", "---");
					 if(eElement.getElementsByTagName("CrRef").item(0).getTextContent().trim().length()>0)
						CIMData.put("CrRef", eElement.getElementsByTagName("CrRef").item(0).getTextContent().trim());
					else 
						CIMData.put("CrRef", "---");
					 if(eElement.getElementsByTagName("InstructionType").item(0).getTextContent().trim().length()>0)
						CIMData.put("InstructionType", eElement.getElementsByTagName("InstructionType").item(0).getTextContent().trim());	
					else 
						CIMData.put("InstructionType", "---");	
					 if(eElement.getElementsByTagName("CreditAmountCurrency").item(0).getTextContent().trim().length()>0)
						CIMData.put("CreditAmountCurrency", eElement.getElementsByTagName("CreditAmountCurrency").item(0).getTextContent().trim());
					else
						CIMData.put("CreditAmountCurrency", "---");
				
					 if(timeStamp.getLength()>0)
						 for(int j=0;j<timeStamp.getLength();j++){									
								if(nNode.getNodeType()==Node.ELEMENT_NODE){
																														
											String TimeStamp[]=eElement.getElementsByTagName("TimeStamp").item(j).getTextContent().split("T");
											String AttachmentType=eElement.getElementsByTagName("AttachmentType").item(j).getTextContent();
											CIMData.put("TimeStamp"+(j+1), TimeStamp[0]);
											if(AttachmentType.equalsIgnoreCase("swift"))
												CIMData.put("AttachmentType"+(j+1), "SWIFT Message");
											else
												CIMData.put("AttachmentType"+(j+1), AttachmentType);
								}
							}
						 
					 
			}
			
		}
		
		NodeList nMetaData = document.getElementsByTagName("GetMetadata");
		
		for (int temp = 0; temp < nMetaData.getLength(); temp++) {

			Node nNode = nMetaData.item(temp);						
			NodeList metaData=document.getElementsByTagName("MetaData");	
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
				int index=metaData.getLength();
				 if(metaData.getLength()>0)
					 for(int j=0;j<metaData.getLength();j++){									
							if(nNode.getNodeType()==Node.ELEMENT_NODE){
										String MetaData=eElement.getElementsByTagName("MetaData").item(j).getTextContent()
												.replaceAll("\\{5\\:.*", "");//.replaceAll(",\\s+", ",").replaceAll("\\s+-}", "-}");
										CIMData.put("MetaData"+(index), MetaData);
										index--;
							}
						}
			}
		}

		
		NodeList nGetCaseHistory = document.getElementsByTagName("GetCaseHistory");
		for (int temp = 0; temp < nGetCaseHistory.getLength(); temp++) {

			Node nNode = nGetCaseHistory.item(temp);			
			NodeList timeStamp=document.getElementsByTagName("TimeStamp");
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				 if(timeStamp.getLength()>0)
					 for(int j=0;j<timeStamp.getLength();j++){
						 
							if(nNode.getNodeType()==Node.ELEMENT_NODE){
								String TimeStamp[]=eElement.getElementsByTagName("TimeStamp").item(j).getTextContent().split("T");
								String Detail=eElement.getElementsByTagName("Detail").item(j).getTextContent();
								String ExternalPerformer =eElement.getElementsByTagName("ExternalPerformer").item(j).getTextContent();
								CIMData.put("TimeStamp"+(j+1), TimeStamp[0]);
								CIMData.put("Detail"+(j+1), Detail);
								CIMData.put("ExternalPerformer"+(j+1), ExternalPerformer);
							}
						}
			}

		}

		
		System.out.println();
		return CIMData;
				
		
		
	}
	
	
	}
	
	
	
		





