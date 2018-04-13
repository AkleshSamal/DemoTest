package com.selenium.codp.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xslf.model.geom.Context;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Multimap;

public class WriteDBdata {

	/*
	 * public static void main(String[] args) throws Exception {
	 * 
	 * List<String[]> jk = new ArrayList<String[]>(); jk.add(new String[] { "A",
	 * "B", "C", "D" }); jk.add(new String[] { "GH", "sddf", "er", "hj" });
	 * 
	 * WriteDBdata.writeDatatoExcelfile("FINNNET", "postDate", "valDate",
	 * "bankReference", "swiftCode", "transactionAmount", jk);
	 * 
	 * }
	 */

	// create static method

	public static void writeDatatoExcelfile(String testcaseName,
			String postDate, String valDate, String TranType,
			String swiftCode, String BAIcode,String BankReference,String DebitAmount, List<String[]> lst)
			throws Exception {

		// String DBfileName = "DBvalues";
		DateFormat dateFormat = new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss");
		Calendar cal = Calendar.getInstance();
		String dt = dateFormat.format(cal.getTime());
		String s = testcaseName + dt;
		// create an Excel file , need random names from Test case class name
		FileOutputStream fileOut = new FileOutputStream(
				"C:\\Users\\perumans\\Test Results\\DBdatafiles\\" + s + ".xls");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet worksheet = workbook.createSheet("DBdata");

		Map<Integer, Object[]> data = new HashMap<Integer, Object[]>();

		data.put(1, new Object[] { postDate, valDate, TranType, swiftCode,
				BAIcode,BankReference, DebitAmount});
		int iKey = 2;
		for (Object[] rowData : lst) {

			// /split
			String toSplit = Arrays.deepToString(rowData);

			// remove [ and ]
			String removefirst = toSplit.replace("[", "");
			String removeSecond = removefirst.replace("]", "");

			String[] finalString = removeSecond.split(",");

			data.put(iKey++, new Object[] { finalString[0], finalString[1],
					finalString[2], finalString[3], finalString[4],finalString[5],finalString[6] });

		}

		// This data needs to be written (Object[])

		Set<Integer> keySet = data.keySet();
		int rownum = 0;

		for (Integer key : keySet) {
			Row row = worksheet.createRow(rownum++);
			Object[] objARR = data.get(key);
			int cellnum = 0;
			for (Object obj : objARR) {
				Cell cell = row.createCell(cellnum++);

				if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
				}

			}
		}

		workbook.write(fileOut);
		fileOut.close();
	}

	public static void writeDatatoExcelfileDeposit(String testcaseName,
			String depositDate, String principalAmount, String maturityDate,
			String maturityAmount, String interestRate,
			String interestAtmaturity, String payoutAccount,
			String interestCalculation, String withHoldtaxApplicable,
			String lastwithHoldtax, String lastwithHoldTaxDate,
			String maturityDetails, List<String[]> lst) throws Exception {

		// String DBfileName = "DBvalues";
		DateFormat dateFormat = new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss");
		Calendar cal = Calendar.getInstance();
		String dt = dateFormat.format(cal.getTime());
		String s = testcaseName + dt;
		// create an Excel file , need random names from Test case class name
		FileOutputStream fileOut = new FileOutputStream(
				"C:\\NotBackedUp\\EclipseWorkspace\\DBdatafiles\\" + s + ".xls");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet worksheet = workbook.createSheet("DBdata");

		Map<Integer, Object[]> data = new HashMap<Integer, Object[]>();

		data.put(1, new Object[] { depositDate, principalAmount, maturityDate,
				maturityAmount, interestRate, interestAtmaturity,
				payoutAccount, interestCalculation, withHoldtaxApplicable,
				lastwithHoldtax, lastwithHoldTaxDate, maturityDetails });
		int iKey = 2;
		for (Object[] rowData : lst) {

			// /split
			String toSplit = Arrays.deepToString(rowData);

			// remove [ and ]
			String removefirst = toSplit.replace("[", "");
			String removeSecond = removefirst.replace("]", "");

			String[] finalString = removeSecond.split(",");

			data.put(iKey++, new Object[] { finalString[0], finalString[1],
					finalString[2], finalString[3], finalString[4],
					finalString[5], finalString[6], finalString[7],
					finalString[8], finalString[9], finalString[10],
					finalString[11] });

		}

		// This data needs to be written (Object[])

		Set<Integer> keySet = data.keySet();
		int rownum = 0;

		for (Integer key : keySet) {
			Row row = worksheet.createRow(rownum++);
			Object[] objARR = data.get(key);
			int cellnum = 0;
			for (Object obj : objARR) {
				Cell cell = row.createCell(cellnum++);

				if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
				}

			}
		}

		workbook.write(fileOut);
		fileOut.close();
	}

	public static void writeDatatoExcelfileDepositSearch(String testcaseName,
			String depositNumber, String openingDate, String maturityDate,
			String principalAmount, String maturityAmount, String currency,
			List<String[]> lst) throws Exception {

		// String DBfileName = "DBvalues";
		DateFormat dateFormat = new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss");
		Calendar cal = Calendar.getInstance();
		String dt = dateFormat.format(cal.getTime());
		String s = testcaseName + dt;
		// create an Excel file , need random names from Test case class name
		FileOutputStream fileOut = new FileOutputStream(
				"C:\\NotBackedUp\\EclipseWorkspace\\DBdatafiles\\" + s + ".xls");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet worksheet = workbook.createSheet("DBdata");

		Map<Integer, Object[]> data = new HashMap<Integer, Object[]>();

		data.put(1, new Object[] { depositNumber, openingDate, maturityDate,
				principalAmount, maturityAmount, currency });
		int iKey = 2;
		for (Object[] rowData : lst) {

			// /split
			String toSplit = Arrays.deepToString(rowData);

			// remove [ and ]
			String removefirst = toSplit.replace("[", "");
			String removeSecond = removefirst.replace("]", "");

			String[] finalString = removeSecond.split(",");

			data.put(iKey++, new Object[] { finalString[0], finalString[1],
					finalString[2], finalString[3], finalString[4],
					finalString[5] });

		}

		// This data needs to be written (Object[])

		Set<Integer> keySet = data.keySet();
		int rownum = 0;

		for (Integer key : keySet) {
			Row row = worksheet.createRow(rownum++);
			Object[] objARR = data.get(key);
			int cellnum = 0;
			for (Object obj : objARR) {
				Cell cell = row.createCell(cellnum++);

				if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
				}

			}
		}

		workbook.write(fileOut);
		fileOut.close();
	}

	public static void writeDatatoExcelfileAccountActivity(String testcaseName,
			String postDate, String valDate, String tranType,
			String swiftCode, String BIAcode, String Credits,
			String RunningBalance, String narrative, List<String[]> lst)
			throws Exception {

		// String DBfileName = "DBvalues";
		DateFormat dateFormat = new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss");
		Calendar cal = Calendar.getInstance();
		String dt = dateFormat.format(cal.getTime());
		String s = testcaseName + dt;
		// create an Excel file , need random names from Test case class name
		FileOutputStream fileOut = new FileOutputStream(
				"C:\\Users\\perumans\\Test Results\\DBdatafiles\\" + s + ".xls");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet worksheet = workbook.createSheet("DBdata");

		Map<Integer, Object[]> data = new HashMap<Integer, Object[]>();

		data.put(1, new Object[] { postDate, valDate, tranType, swiftCode,
				BIAcode, Credits, RunningBalance, narrative });
		int iKey = 2;
		for (Object[] rowData : lst) {

			// /split
			String toSplit = Arrays.deepToString(rowData);

			// remove [ and ]
			String removefirst = toSplit.replace("[", "");
			String removeSecond = removefirst.replace("]", "");

			String[] finalString = removeSecond.split(",");

			data.put(iKey++, new Object[] { finalString[0], finalString[1],
					finalString[2], finalString[3], finalString[4],
					finalString[5], finalString[6], finalString[7] });

		}

		// This data needs to be written (Object[])

		Set<Integer> keySet = data.keySet();
		int rownum = 0;

		for (Integer key : keySet) {
			Row row = worksheet.createRow(rownum++);
			Object[] objARR = data.get(key);
			int cellnum = 0;
			for (Object obj : objARR) {
				Cell cell = row.createCell(cellnum++);

				if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
				}

			}
		}

		workbook.write(fileOut);
		fileOut.close();
	}

	public static void writeDatatoExcelfileBalanceSummary(String testcaseName,
			String postDate, String openingAvailableBalance,
			String availableBalance, String openingLedgerBalance,
			String ledgerBalance, String totalDebits, String totalDebitAmount,
			String totalCredits, String totalCreditAmount,
			String overDraftLimit, List<String[]> lst) throws Exception {

		// String DBfileName = "DBvalues";
		DateFormat dateFormat = new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss");
		Calendar cal = Calendar.getInstance();
		String dt = dateFormat.format(cal.getTime());
		String s = testcaseName + dt;
		// create an Excel file , need random names from Test case class name
		FileOutputStream fileOut = new FileOutputStream(
				"C:\\Users\\perumans\\Test Results\\DBdatafiles\\" + s + ".xls");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet worksheet = workbook.createSheet("DBdata");

		Map<Integer, Object[]> data = new HashMap<Integer, Object[]>();

		data.put(1, new Object[] { postDate, openingAvailableBalance,
				availableBalance, openingLedgerBalance, ledgerBalance,
				totalDebits, totalDebitAmount, totalCredits, totalCreditAmount,
				overDraftLimit });
		int iKey = 2;
		for (Object[] rowData : lst) {

			// /split
			String toSplit = Arrays.deepToString(rowData);

			// remove [ and ]
			String removefirst = toSplit.replace("[", "");
			String removeSecond = removefirst.replace("]", "");

			String[] finalString = removeSecond.split(",");

			data.put(iKey++, new Object[] { finalString[0], finalString[1],
					finalString[2], finalString[3], finalString[4],
					finalString[5], finalString[6], finalString[7],
					finalString[8], finalString[9] });

		}

		// This data needs to be written (Object[])

		Set<Integer> keySet = data.keySet();
		int rownum = 0;

		for (Integer key : keySet) {
			Row row = worksheet.createRow(rownum++);
			Object[] objARR = data.get(key);
			int cellnum = 0;
			for (Object obj : objARR) {
				Cell cell = row.createCell(cellnum++);

				if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
				}

			}
		}

		workbook.write(fileOut);
		fileOut.close();
	}
	
	
	public static void writeDatatoExcelfileDepositHistory(String testcaseName,
			String depositDate, String BalanceAmount, String Interestpaidtodate,
			String withHoldingTax, List<String[]> lst) throws Exception {

		// String DBfileName = "DBvalues";
		DateFormat dateFormat = new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss");
		Calendar cal = Calendar.getInstance();
		String dt = dateFormat.format(cal.getTime());
		String s = testcaseName + dt;
		// create an Excel file , need random names from Test case class name
		FileOutputStream fileOut = new FileOutputStream(
				"C:\\Users\\perumans\\Test Results\\DBdatafiles\\" + s + ".xls");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet worksheet = workbook.createSheet("DBdata");

		Map<Integer, Object[]> data = new HashMap<Integer, Object[]>();

		data.put(1, new Object[] { depositDate, BalanceAmount, Interestpaidtodate,
				withHoldingTax });
		int iKey = 2;
		for (Object[] rowData : lst) {

			// /split
			String toSplit = Arrays.deepToString(rowData);

			// remove [ and ]
			String removefirst = toSplit.replace("[", "");
			String removeSecond = removefirst.replace("]", "");

			String[] finalString = removeSecond.split(",");

			data.put(iKey++, new Object[] { finalString[0], finalString[1],
					finalString[2], finalString[3] });

		}

		// This data needs to be written (Object[])

		Set<Integer> keySet = data.keySet();
		int rownum = 0;

		for (Integer key : keySet) {
			Row row = worksheet.createRow(rownum++);
			Object[] objARR = data.get(key);
			int cellnum = 0;
			for (Object obj : objARR) {
				Cell cell = row.createCell(cellnum++);

				if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
				}

			}
		}

		workbook.write(fileOut);
		fileOut.close();
	}
	
	
	public static void writeDatatoExcelfileCreateDAUser(String testcaseName,
			String USR_CD, String USR_NAME, String USR_ADDR1,
			String USR_ADDR2,String USR_CITY,
			String USR_CTRY_CD,String USR_EMAIL,String USR_FIRST_NAME,List<String[]> lst) throws Exception {

		// String DBfileName = "DBvalues";
		DateFormat dateFormat = new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss");
		Calendar cal = Calendar.getInstance();
		String dt = dateFormat.format(cal.getTime());
		String s = testcaseName + dt;
		// create an Excel file , need random names from Test case class name
		FileOutputStream fileOut = new FileOutputStream(
				"C:\\Users\\perumans\\Test Results\\DBdatafiles\\" + s + ".xls");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet worksheet = workbook.createSheet("DBdata");

		Map<Integer, Object[]> data = new HashMap<Integer, Object[]>();

		data.put(1, new Object[] { USR_CD, USR_NAME, USR_ADDR1,
				USR_ADDR2,USR_CITY,USR_CTRY_CD,USR_EMAIL,USR_FIRST_NAME
				});
		int iKey = 2;
		for (Object[] rowData : lst) {

			// /split
			String toSplit = Arrays.deepToString(rowData);

			// remove [ and ]
			String removefirst = toSplit.replace("[", "");
			String removeSecond = removefirst.replace("]", "");

			String[] finalString = removeSecond.split(",");

			data.put(iKey++, new Object[] { finalString[0], finalString[1],
					finalString[2], finalString[3],finalString[4],finalString[5],
					finalString[6],finalString[7]});

		}

		// This data needs to be written (Object[])

		Set<Integer> keySet = data.keySet();
		int rownum = 0;

		for (Integer key : keySet) {
			Row row = worksheet.createRow(rownum++);
			Object[] objARR = data.get(key);
			int cellnum = 0;
			for (Object obj : objARR) {
				Cell cell = row.createCell(cellnum++);

				if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
				}

			}
		}

		workbook.write(fileOut);
		fileOut.close();
	}
	
	
	public static void writeDatatoExcelfileDisableDAUser(String testcaseName,
			String AL_EVENT_ID, String AL_EVENT_TIMESTAMP, String AL_EVENT_GENERATORID,
			String AL_EVENT_GENERATORTYPE,String AL_AFFECTED_ENTITY,String AL_ENTITY_KEY,String AL_EVENT_TYPE,
			String AL_APPLICATION,String AL_LOGGER_IP_ADD,String AL_CAAS_RESPONSE_STATUS,
			List<String[]> lst) throws Exception {

		// String DBfileName = "DBvalues";
		DateFormat dateFormat = new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss");
		Calendar cal = Calendar.getInstance();
		String dt = dateFormat.format(cal.getTime());
		String s = testcaseName + dt;
		// create an Excel file , need random names from Test case class name
		FileOutputStream fileOut = new FileOutputStream(
				"C:\\Users\\perumans\\Test Results\\DBdatafiles\\" + s + ".xls");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet worksheet = workbook.createSheet("DBdata");

		Map<Integer, Object[]> data = new HashMap<Integer, Object[]>();

		data.put(1, new Object[] { AL_EVENT_ID, AL_EVENT_TIMESTAMP, AL_EVENT_GENERATORID,
				AL_EVENT_GENERATORTYPE,AL_AFFECTED_ENTITY,AL_ENTITY_KEY,AL_EVENT_TYPE,AL_APPLICATION,AL_LOGGER_IP_ADD,AL_CAAS_RESPONSE_STATUS
				});
		int iKey = 2;
		for (Object[] rowData : lst) {

			// /split
			String toSplit = Arrays.deepToString(rowData);

			// remove [ and ]
			String removefirst = toSplit.replace("[", "");
			String removeSecond = removefirst.replace("]", "");

			String[] finalString = removeSecond.split(",");

			data.put(iKey++, new Object[] { finalString[0], finalString[1],
					finalString[2], finalString[3],finalString[4],finalString[5],finalString[6],finalString[7],
					finalString[8],finalString[9]});

		}

		// This data needs to be written (Object[])

		Set<Integer> keySet = data.keySet();
		int rownum = 0;

		for (Integer key : keySet) {
			Row row = worksheet.createRow(rownum++);
			Object[] objARR = data.get(key);
			int cellnum = 0;
			for (Object obj : objARR) {
				Cell cell = row.createCell(cellnum++);

				if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
				}

			}
		}

		workbook.write(fileOut);
		fileOut.close();
	}
	
	
	public static void DBDataEnableUser(String testcaseName,
			String AL_EVENT_ID, String AL_EVENT_TIMESTAMP, String AL_EVENT_GENERATORID,
			String AL_EVENT_GENERATORTYPE,String AL_AFFECTED_ENTITY,String AL_ENTITY_KEY,String AL_EVENT_TYPE,
			String AL_APPLICATION,String AL_LOGGER_IP_ADD,String AL_CAAS_RESPONSE_STATUS,
			List<String[]> lst) throws Exception{
		
		// String DBfileName = "DBvalues";
				DateFormat dateFormat = new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss");
				Calendar cal = Calendar.getInstance();
				String dt = dateFormat.format(cal.getTime());
				String s = testcaseName + dt;
				// create an Excel file , need random names from Test case class name
				FileOutputStream fileOut = new FileOutputStream(
						"C:\\Users\\perumans\\Test Results\\DBdatafiles\\" + s + ".xls");
				HSSFWorkbook workbook = new HSSFWorkbook();
				HSSFSheet worksheet = workbook.createSheet("DBdata");

				Map<Integer, Object[]> data = new HashMap<Integer, Object[]>();

				data.put(1, new Object[] { AL_EVENT_ID, AL_EVENT_TIMESTAMP, AL_EVENT_GENERATORID,
						AL_EVENT_GENERATORTYPE,AL_AFFECTED_ENTITY,AL_ENTITY_KEY,AL_EVENT_TYPE,AL_APPLICATION,AL_LOGGER_IP_ADD,AL_CAAS_RESPONSE_STATUS
						});
				int iKey = 2;
				for (Object[] rowData : lst) {

					// /split
					String toSplit = Arrays.deepToString(rowData);

					// remove [ and ]
					String removefirst = toSplit.replace("[", "");
					String removeSecond = removefirst.replace("]", "");

					String[] finalString = removeSecond.split(",");

					data.put(iKey++, new Object[] { finalString[0], finalString[1],
							finalString[2], finalString[3],finalString[4],finalString[5],finalString[6],finalString[7],
							finalString[8],finalString[9]});

				}

				// This data needs to be written (Object[])

				Set<Integer> keySet = data.keySet();
				int rownum = 0;

				for (Integer key : keySet) {
					Row row = worksheet.createRow(rownum++);
					Object[] objARR = data.get(key);
					int cellnum = 0;
					for (Object obj : objARR) {
						Cell cell = row.createCell(cellnum++);

						if (obj instanceof String) {
							cell.setCellValue((String) obj);
						} else if (obj instanceof Integer) {
							cell.setCellValue((Integer) obj);
						}

					}
				}

				workbook.write(fileOut);
				fileOut.close();
			}
		
		
				
		
	public static void BTDBDataAssignApplication(String testcaseName,
			String AL_EVENT_ID, String AL_EVENT_TIMESTAMP, String AL_EVENT_GENERATORID,
			String AL_EVENT_GENERATORTYPE,String AL_AFFECTED_ENTITY,String AL_ENTITY_KEY,String AL_EVENT_TYPE,
			String AL_APPLICATION,String AL_LOGGER_IP_ADD,String AL_CAAS_RESPONSE_STATUS,
			List<String[]> lst) throws Exception{
		
		// String DBfileName = "DBvalues";
				DateFormat dateFormat = new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss");
				Calendar cal = Calendar.getInstance();
				String dt = dateFormat.format(cal.getTime());
				String s = testcaseName + dt;
				// create an Excel file , need random names from Test case class name
				FileOutputStream fileOut = new FileOutputStream(
						"C:\\Users\\perumans\\Test Results\\DBdatafiles\\" + s + ".xls");
				HSSFWorkbook workbook = new HSSFWorkbook();
				HSSFSheet worksheet = workbook.createSheet("DBdata");

				Map<Integer, Object[]> data = new HashMap<Integer, Object[]>();

				data.put(1, new Object[] { AL_EVENT_ID, AL_EVENT_TIMESTAMP, AL_EVENT_GENERATORID,
						AL_EVENT_GENERATORTYPE,AL_AFFECTED_ENTITY,AL_ENTITY_KEY,AL_EVENT_TYPE,AL_APPLICATION,AL_LOGGER_IP_ADD,AL_CAAS_RESPONSE_STATUS
						});
				int iKey = 2;
				for (Object[] rowData : lst) {

					// /split
					String toSplit = Arrays.deepToString(rowData);

					// remove [ and ]
					String removefirst = toSplit.replace("[", "");
					String removeSecond = removefirst.replace("]", "");

					String[] finalString = removeSecond.split(",");

					data.put(iKey++, new Object[] { finalString[0], finalString[1],
							finalString[2], finalString[3],finalString[4],finalString[5],finalString[6],finalString[7],
							finalString[8],finalString[9]});

				}

				// This data needs to be written (Object[])

				Set<Integer> keySet = data.keySet();
				int rownum = 0;

				for (Integer key : keySet) {
					Row row = worksheet.createRow(rownum++);
					Object[] objARR = data.get(key);
					int cellnum = 0;
					for (Object obj : objARR) {
						Cell cell = row.createCell(cellnum++);

						if (obj instanceof String) {
							cell.setCellValue((String) obj);
						} else if (obj instanceof Integer) {
							cell.setCellValue((Integer) obj);
						}

					}
				}

				workbook.write(fileOut);
				fileOut.close();
			}
	
	public static void writeBTDatatoExcelfileAssignApplication(String testcaseName,
			String USERID, String USERGROUP, String USERGROUP_USERID,
						List<String[]> lst) throws Exception {

		// String DBfileName = "DBvalues";
		DateFormat dateFormat = new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss");
		Calendar cal = Calendar.getInstance();
		String dt = dateFormat.format(cal.getTime());
		String s = testcaseName + dt;
		// create an Excel file , need random names from Test case class name
		FileOutputStream fileOut = new FileOutputStream(
				"C:\\Users\\perumans\\Test Results\\DBdatafiles\\" + s + ".xls");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet worksheet = workbook.createSheet("DBdata");

		Map<Integer, Object[]> data = new HashMap<Integer, Object[]>();

		data.put(1, new Object[] { USERID, USERGROUP, USERGROUP_USERID});
		int iKey = 2;
		for (Object[] rowData : lst) {

			// /split
			String toSplit = Arrays.deepToString(rowData);

			// remove [ and ]
			String removefirst = toSplit.replace("[", "");
			String removeSecond = removefirst.replace("]", "");

			String[] finalString = removeSecond.split(",");

			data.put(iKey++, new Object[] { finalString[0], finalString[1],
					finalString[2]});

		}

		// This data needs to be written (Object[])

		Set<Integer> keySet = data.keySet();
		int rownum = 0;

		for (Integer key : keySet) {
			Row row = worksheet.createRow(rownum++);
			Object[] objARR = data.get(key);
			int cellnum = 0;
			for (Object obj : objARR) {
				Cell cell = row.createCell(cellnum++);

				if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
				}

			}
		}

		workbook.write(fileOut);
		fileOut.close();
	}
		
	
	public static void writeDatatoExcelfileViewAllAuditHistory(String testcaseName,
			String AL_EVENT_ID, String AL_EVENT_TYPE,
			List<String[]> lst) throws Exception {

		// String DBfileName = "DBvalues";
		DateFormat dateFormat = new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss");
		Calendar cal = Calendar.getInstance();
		String dt = dateFormat.format(cal.getTime());
		String s = testcaseName + dt;
		// create an Excel file , need random names from Test case class name
		FileOutputStream fileOut = new FileOutputStream(
				"C:\\Users\\perumans\\Test Results\\DBdatafiles\\" + s + ".xls");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet worksheet = workbook.createSheet("DBdata");

		Map<Integer, Object[]> data = new HashMap<Integer, Object[]>();

		data.put(1, new Object[] { AL_EVENT_ID,AL_EVENT_TYPE});
		int iKey = 2;
		for (Object[] rowData : lst) {

			// /split
			String toSplit = Arrays.deepToString(rowData);

			// remove [ and ]
			String removefirst = toSplit.replace("[", "");
			String removeSecond = removefirst.replace("]", "");

			String[] finalString = removeSecond.split(",");

			data.put(iKey++, new Object[] { finalString[0], finalString[1]});
					
					

		}

		// This data needs to be written (Object[])

		Set<Integer> keySet = data.keySet();
		int rownum = 0;

		for (Integer key : keySet) {
			Row row = worksheet.createRow(rownum++);
			Object[] objARR = data.get(key);
			int cellnum = 0;
			for (Object obj : objARR) {
				Cell cell = row.createCell(cellnum++);

				if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
				}

			}
		}

		workbook.write(fileOut);
		fileOut.close();
	
	
	}
	
	public static void writeDatatoExcelfileEditDAUser(String testcaseName,
			String USR_CD, String USR_NAME, String USR_ADDR1,
			String USR_ADDR2,String USR_CITY,
			String USR_CTRY_CD,String USR_EMAIL,String USR_FIRST_NAME,List<String[]> lst) throws Exception {

		// String DBfileName = "DBvalues";
		DateFormat dateFormat = new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss");
		Calendar cal = Calendar.getInstance();
		String dt = dateFormat.format(cal.getTime());
		String s = testcaseName + dt;
		// create an Excel file , need random names from Test case class name
		FileOutputStream fileOut = new FileOutputStream(
				"C:\\Users\\perumans\\Test Results\\DBdatafiles\\" + s + ".xls");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet worksheet = workbook.createSheet("DBdata");

		Map<Integer, Object[]> data = new HashMap<Integer, Object[]>();

		data.put(1, new Object[] { USR_CD, USR_NAME, USR_ADDR1,
				USR_ADDR2,USR_CITY,USR_CTRY_CD,USR_EMAIL,USR_FIRST_NAME
				});
		int iKey = 2;
		for (Object[] rowData : lst) {

			// /split
			String toSplit = Arrays.deepToString(rowData);

			// remove [ and ]
			String removefirst = toSplit.replace("[", "");
			String removeSecond = removefirst.replace("]", "");

			String[] finalString = removeSecond.split(",");

			data.put(iKey++, new Object[] { finalString[0], finalString[1],
					finalString[2], finalString[3],finalString[4],finalString[5],
					finalString[6],finalString[7]});

		}

		// This data needs to be written (Object[])

		Set<Integer> keySet = data.keySet();
		int rownum = 0;

		for (Integer key : keySet) {
			Row row = worksheet.createRow(rownum++);
			Object[] objARR = data.get(key);
			int cellnum = 0;
			for (Object obj : objARR) {
				Cell cell = row.createCell(cellnum++);

				if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
				}

			}
		}

		workbook.write(fileOut);
		fileOut.close();
	}
	
	public static void writeDatatoExcelfileAssignApplication(String testcaseName,
			String AL_EVENT_ID, String AL_EVENT_TIMESTAMP, String AL_EVENT_GENERATORID,
			String AL_EVENT_GENERATORTYPE,String AL_AFFECTED_ENTITY,String AL_ENTITY_KEY,String AL_EVENT_TYPE,
			String AL_APPLICATION,String AL_LOGGER_IP_ADD,String AL_CAAS_RESPONSE_STATUS,
			List<String[]> lst) throws Exception {

		// String DBfileName = "DBvalues";
		DateFormat dateFormat = new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss");
		Calendar cal = Calendar.getInstance();
		String dt = dateFormat.format(cal.getTime());
		String s = testcaseName + dt;
		// create an Excel file , need random names from Test case class name
		FileOutputStream fileOut = new FileOutputStream(
				"C:\\Users\\perumans\\Test Results\\DBdatafiles\\" + s + ".xls");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet worksheet = workbook.createSheet("DBdata");

		Map<Integer, Object[]> data = new HashMap<Integer, Object[]>();

		data.put(1, new Object[] { AL_EVENT_ID, AL_EVENT_TIMESTAMP, AL_EVENT_GENERATORID,
				AL_EVENT_GENERATORTYPE,AL_AFFECTED_ENTITY,AL_ENTITY_KEY,AL_EVENT_TYPE,AL_APPLICATION,AL_LOGGER_IP_ADD,AL_CAAS_RESPONSE_STATUS
				});
		int iKey = 2;
		for (Object[] rowData : lst) {

			// /split
			String toSplit = Arrays.deepToString(rowData);

			// remove [ and ]
			String removefirst = toSplit.replace("[", "");
			String removeSecond = removefirst.replace("]", "");

			String[] finalString = removeSecond.split(",");

			data.put(iKey++, new Object[] { finalString[0], finalString[1],
					finalString[2], finalString[3],finalString[4],finalString[5],finalString[6],finalString[7],
					finalString[8],finalString[9]});

		}

		// This data needs to be written (Object[])

		Set<Integer> keySet = data.keySet();
		int rownum = 0;

		for (Integer key : keySet) {
			Row row = worksheet.createRow(rownum++);
			Object[] objARR = data.get(key);
			int cellnum = 0;
			for (Object obj : objARR) {
				Cell cell = row.createCell(cellnum++);

				if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
				}

			}
		}

		workbook.write(fileOut);
		fileOut.close();
	}
	
	public static void writeExcelData(String testcaseName,String resultsPath,String sheetname,
			HashMap<String,String> data) throws Exception {
		
		FileInputStream filein=null;
		FileOutputStream fileOut=null;
		HSSFWorkbook workbook=null;
		HSSFSheet worksheet=null;
		String s = resultsPath+"\\"+testcaseName+".xls" ;
				
		File file=new File(s);
		
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

		for (Map.Entry<String,String> m : data.entrySet()) {
			Row row = worksheet.createRow(rownum++);
			int cellnum = 0;
			Cell cell = row.createCell(cellnum++);
			cell.setCellValue(m.getKey().toString());
			cell = row.createCell(cellnum++);
			cell.setCellValue(m.getValue().toString());	

			}
		

		workbook.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
	public static void writeExcelData(String testcaseName,String resultsPath,String sheetname,
			Multimap<String,String> data) throws Exception {
		
		FileInputStream filein=null;
		FileOutputStream fileOut=null;
		HSSFWorkbook workbook=null;
		HSSFSheet worksheet=null;
		String s = resultsPath+"\\"+testcaseName+".xls" ;
				
		File file=new File(s);
		
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

		for (Map.Entry<String,String> m : data.entries()) {
			Row row = worksheet.createRow(rownum++);
			int cellnum = 0;
			Cell cell = row.createCell(cellnum++);
			cell.setCellValue(m.getKey().toString());
			cell = row.createCell(cellnum++);
			cell.setCellValue(m.getValue().toString());	
			/*cell.setCellValue(m.getKey().toString());
			cell = row.createCell(cellnum++);
			cell.setCellValue(m.getValue().toString());	*/

		}
	

	workbook.write(fileOut);
	fileOut.flush();
	fileOut.close();

	}

	/*public static void writeExcelDataHashMap(String testcaseName,String resultsPath,String sheetname,
			HashMap <String,String> data) throws Exception {
     
     FileInputStream filein=null;
     FileOutputStream fileOut=null;
     HSSFWorkbook workbook=null;
     HSSFSheet worksheet=null;
     String s = resultsPath+"\\"+testcaseName+".xls" ;
                  
     File file=new File(s);
     
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

     for (Map.Entry entry : data.entrySet()) {
		    Row row = worksheet.createRow(rownum++);
            int cellnum = 0;
            Cell cell = row.createCell(cellnum++);
            cell.setCellValue(entry.getValue().toString());
		}
     

     workbook.write(fileOut);
     fileOut.flush();
     fileOut.close();
}*/
			
	
	/*public static void writeExcelData(String testcaseName,String resultsPath,String sheetname,
			ArrayList<String[]> data) throws Exception {
		
		FileInputStream filein=null;
		FileOutputStream fileOut=null;
		HSSFWorkbook workbook=null;
		HSSFSheet worksheet=null;
		String s = resultsPath+"\\"+testcaseName+".xls" ;
				
		File file=new File(s);
		
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

		//for (Map.Entry<String,String> m : data.entrySet())
		for(String[] k:data)
		{
			Row row = worksheet.createRow(rownum++);
			int cellnum = 0;
			Cell cell = row.createCell(cellnum++);
			//System.out.println(k);
			if(k!=null){
				cell.setCellValue(Arrays.deepToString(k));
			}
		
			
			}
		

		workbook.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}*/
	
	public static void writeExcelData(String testcaseName,String resultsPath,String sheetname,
			List<String> data) throws Exception {
		
		FileInputStream filein=null;
		FileOutputStream fileOut=null;
		HSSFWorkbook workbook=null;
		HSSFSheet worksheet=null;
		String s = resultsPath+"\\"+testcaseName+".xls" ;
				
		File file=new File(s);
		
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

		//for (Map.Entry<String,String> m : data.entrySet())
		for(String k:data)
		{
			Row row = worksheet.createRow(rownum++);
			int cellnum = 0;
			Cell cell = row.createCell(cellnum++);
			//System.out.println(k);
			if(k!=null){
				cell.setCellValue(k);
			}
		
			
			}
		

		workbook.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
	public static void writeExcelData(String FileName,String resultsPath,String sheetname,
			String testcaseName,
			String status,String Errors) throws Exception {
		
		FileInputStream filein=null;
		FileOutputStream fileOut=null;
		HSSFWorkbook workbook=null;
		HSSFSheet worksheet=null;
		String s = resultsPath+"\\"+FileName+".xls" ;
				
		File file=new File(s);
		
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
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 Calendar cal = Calendar.getInstance();
		 CellStyle style;
		 style= excelHeaderStyle(workbook);
		Row row = worksheet.createRow(rownum++);
		int cellnum = 0;
		Cell cell = row.createCell(cellnum++);
		//cell.setCellStyle("");
		cell.setCellValue("TestcaseName");
		cell.setCellStyle(style);
		cell = row.createCell(cellnum++);
		
		cell.setCellValue("ExecutionDate");
		cell.setCellStyle(style);
		cell = row.createCell(cellnum++);
		cell.setCellValue("ExecutionStatus");
		cell.setCellStyle(style);
		cell = row.createCell(cellnum++);
		cell.setCellValue("Errors");
		cell.setCellStyle(style);
		
		style=excelRowStyle(workbook);
		 row = worksheet.createRow(rownum++);
		 cellnum=0;
		 cell = row.createCell(cellnum++);
		 	cell.setCellValue(testcaseName);
		 	cell.setCellStyle(style);
			cell = row.createCell(cellnum++);
			cell.setCellValue(dateFormat.format(cal.getTime()));
			cell.setCellStyle(style);
			cell = row.createCell(cellnum++);
			cell.setCellValue(status);
			cell.setCellStyle(style);
			cell = row.createCell(cellnum++);
			cell.setCellValue(Errors);
			cell.setCellStyle(style);
		
			for(int i=0;i<4;i++){
				worksheet.autoSizeColumn((short)i);
			}
		

		workbook.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
	
	public static void writeExcelData2(String testcaseName,String resultsPath,String sheetname,
			List<Object[]> data) throws Exception {
		
		FileInputStream filein=null;
		FileOutputStream fileOut=null;
		HSSFWorkbook workbook=null;
		HSSFSheet worksheet=null;
		String s = resultsPath+"\\"+testcaseName+".xls" ;
				
		File file=new File(s);
		
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

		//for (Map.Entry<String,String> m : data.entrySet())
		for(Object[] k:data)
		{
			Row row = worksheet.createRow(rownum++);
			int cellnum = 0;
			Cell cell = row.createCell(cellnum++);
			//System.out.println(k);
			if(k!=null){
				cell.setCellValue(Arrays.deepToString(k));
			}
		
			
			}
		

		workbook.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
	
	
	public static void writeExcelData1(String testcaseName,String resultsPath,String sheetname,
			List<HashMap<String,String>> data) throws Exception {
		
		FileInputStream filein=null;
		FileOutputStream fileOut=null;
		HSSFWorkbook workbook=null;
		HSSFSheet worksheet=null;
		String s = resultsPath+"\\"+testcaseName+".xls" ;
				
		File file=new File(s);
		
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

		for(HashMap<String,String> map:data){
			Row row = worksheet.createRow(rownum++);
			int cellnum = 0;
			Cell cell = row.createCell(cellnum++);
			cell.setCellValue(map.toString());
		}
		

		workbook.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
	
	
	public static  CellStyle excelHeaderStyle(Workbook workbook ){
		CellStyle style=workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.MAROON.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		style.setBorderBottom(CellStyle.BORDER_THIN);
	    style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	    style.setBorderLeft(CellStyle.BORDER_THIN);
	    style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	    style.setBorderRight(CellStyle.BORDER_THIN);
	    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
	    style.setBorderTop(CellStyle.BORDER_THIN);
	    style.setTopBorderColor(IndexedColors.BLACK.getIndex());
	    style.setAlignment(CellStyle.ALIGN_CENTER);
	    
	    Font font = workbook.createFont();
	    font.setBoldweight(Font.BOLDWEIGHT_BOLD);
	    font.setFontHeightInPoints((short)12);
	    font.setFontName("Calibri");
		font.setColor(HSSFColor.WHITE.index);
		
		style.setFont(font);
		return style;
		
	}
	
	public static  CellStyle excelRowStyle(Workbook workbook ){
		CellStyle style=workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		style.setBorderBottom(CellStyle.BORDER_THIN);
	    style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	    style.setBorderLeft(CellStyle.BORDER_THIN);
	    style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	    style.setBorderRight(CellStyle.BORDER_THIN);
	    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
	    style.setBorderTop(CellStyle.BORDER_THIN);
	    style.setTopBorderColor(IndexedColors.BLACK.getIndex());
	    style.setAlignment(CellStyle.ALIGN_CENTER);
	    
	    Font font = workbook.createFont();
	    font.setBoldweight(Font.BOLDWEIGHT_BOLD);
	    font.setFontHeightInPoints((short)12);
	    font.setFontName("Calibri");
		font.setColor(HSSFColor.WHITE.index);
		
		style.setFont(font);
		return style;
		
	}



	public static void writeExcelDataHashMap(String testcaseName,String resultsPath,String sheetname,
			HashMap <String,String> data) throws Exception {
     
     FileInputStream filein=null;
     FileOutputStream fileOut=null;
     HSSFWorkbook workbook=null;
     HSSFSheet worksheet=null;
     String s = resultsPath+"\\"+testcaseName+".xls" ;
                  
     File file=new File(s);
     
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

     for (Map.Entry entry : data.entrySet()) {
		    Row row = worksheet.createRow(rownum++);
            int cellnum = 0;
            Cell cell = row.createCell(cellnum++);
            cell.setCellValue(entry.getValue().toString());
		}
     

     workbook.write(fileOut);
     fileOut.flush();
     fileOut.close();
}
public static void writeExcelData(String testcaseName,String resultsPath,String sheetname,
            ArrayList<String[]> data) throws Exception {
     
     FileInputStream filein=null;
     FileOutputStream fileOut=null;
     HSSFWorkbook workbook=null;
     HSSFSheet worksheet=null;
     String s = resultsPath+"\\"+testcaseName+".xls" ;
                  
     File file=new File(s);
     
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

     //for (Map.Entry<String,String> m : data.entrySet())
     for(String[] k:data)
     {
            Row row = worksheet.createRow(rownum++);
            int cellnum = 0;
            Cell cell = row.createCell(cellnum++);
            cell.setCellValue(Arrays.deepToString(k));
            
            }
     

     workbook.write(fileOut);
     fileOut.flush();
     fileOut.close();
}
	
	public static void writeExcelDataArrayList(String testcaseName,String resultsPath,String sheetname,
            ArrayList<String> data) throws Exception {
     
     FileInputStream filein=null;
     FileOutputStream fileOut=null;
     HSSFWorkbook workbook=null;
     HSSFSheet worksheet=null;
     String s = resultsPath+"\\"+testcaseName+".xls" ;
                  
     File file=new File(s);
     
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

     
     for(String k:data)
     {
            Row row = worksheet.createRow(rownum++);
            int cellnum = 0;
            Cell cell = row.createCell(cellnum++);
            cell.setCellValue(k);
            
            }
     
     workbook.write(fileOut);
     fileOut.flush();
     fileOut.close();
     
     
     
}
	
	public static void old_setCellData(String testcaseName,String data,int rownum,int cellNum) throws Exception {
     
     FileInputStream filein=null;
     FileOutputStream fileOut=null;
     HSSFWorkbook workbook=null;
     HSSFSheet worksheet=null;
     //String s = resultsPath+"\\"+testcaseName+".xls" ;
     String s = testcaseName;
                  
     File file=new File(s);
     
     if(file.exists()){
            filein=new FileInputStream(new File(s));
            workbook = new HSSFWorkbook(filein);
            worksheet=workbook.getSheetAt(0);     
            fileOut = new FileOutputStream(new File(s));
     }
     else{
            fileOut = new FileOutputStream(new File(s));
            workbook = new HSSFWorkbook();
            worksheet=workbook.getSheetAt(0); 
     }
                    
    
    Row row = worksheet.createRow(rownum);
    
    Cell cell = row.createCell(cellNum);
    cell.setCellValue(data);
            

     workbook.write(fileOut);
     fileOut.flush();
     fileOut.close();
}

	
	public static void setCellData(String testcaseName,String data,int rownum,int cellNum) throws Exception {
	     
	     FileInputStream filein=null;
	     FileOutputStream fileOut=null;
	     HSSFWorkbook workbook=null;
	     HSSFSheet worksheet=null;
	     //String s = resultsPath+"\\"+testcaseName+".xls" ;
	     String s = testcaseName;
	                  
	     File file=new File(s);
	     
	     if(file.exists()){
	            filein=new FileInputStream(new File(s));
	            workbook = new HSSFWorkbook(filein);
	            worksheet=workbook.getSheetAt(0);     
	            fileOut = new FileOutputStream(new File(s));
	     }
	     else{
	            fileOut = new FileOutputStream(new File(s));
	            workbook = new HSSFWorkbook();
	            worksheet=workbook.getSheetAt(0); 
	     }
	                    
	    
	    Row row = worksheet.getRow(rownum);
	    
	    Cell cell = row.getCell(cellNum,row.RETURN_BLANK_AS_NULL);
	    if(cell==null)
	    {
	    	cell = row.createCell(cellNum);
	    	cell.setCellValue(data);
	    }
	    else
	    	cell.setCellValue(data);
	            

	     workbook.write(fileOut);
	     fileOut.flush();
	     fileOut.close();
	}
	
	/*public static void writeExcelData(String FileName,String resultsPath,String sheetname,
            String testcaseName,
            String status,String errors) throws Exception {
     
     FileInputStream filein=null;
     FileOutputStream fileOut=null;
     HSSFWorkbook workbook=null;
     HSSFSheet worksheet=null;
     String s = resultsPath+"\\"+FileName+".xls" ;
                  
     File file=new File(s);
     
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
     DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
     Calendar cal = Calendar.getInstance();
     
     
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
     
     row = worksheet.createRow(rownum++);
     cellnum=0;
     cell = row.createCell(cellnum++);
   cell.setCellValue(testcaseName);
    cell = row.createCell(cellnum++);
    cell.setCellValue(dateFormat.format(cal.getTime()));
    cell = row.createCell(cellnum++);
    cell.setCellValue(status);
    cell = row.createCell(cellnum++);
    cell.setCellValue(errors);
     
            
     

     workbook.write(fileOut);
     fileOut.flush();
     fileOut.close();
}*/
}

