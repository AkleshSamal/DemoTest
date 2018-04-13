package com.selenium.codp.utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.selenium.codp.LoginPage.Browser;



public class ScreenShot {

	
	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	  Calendar cal = Calendar.getInstance();
	 //System.out.println(dateFormat.format(cal.getTime()));
	 
	public static void TakesScreenshot(String screenShotName) {

		DateFormat dateFormat = new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss");
		Calendar cal = Calendar.getInstance();
		String dt = dateFormat.format(cal.getTime());
		String s = screenShotName + dt;

		try {
			File scrFile = ((TakesScreenshot)Browser.driver())
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("C:\\Users\\sotakanj\\TestResults\\" + s + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void TakesScreenshot(String screenShotName,String folderPath) {

		DateFormat dateFormat = new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss");
		Calendar cal = Calendar.getInstance();
		String dt = dateFormat.format(cal.getTime());
		String s = screenShotName + dt;

		try {
			File scrFile = ((TakesScreenshot)Browser.driver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(folderPath+"\\"+s+ ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	// /with folder
	public static void TakesScreenshot1(String screenShotName) {

		DateFormat dateFormat = new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss");
		Calendar cal = Calendar.getInstance();
		String dt = dateFormat.format(cal.getTime());
		String s = screenShotName + dt;

		try {
			File scrFile = ((TakesScreenshot)Browser.driver())
					.getScreenshotAs(OutputType.FILE);
			

			String callerClassName = new Exception().getStackTrace()[3]
					.getClassName();
			// split by .
			String[] sdot = callerClassName.split("\\.");
			String folderName = sdot[3];

			FileUtils.copyFile(scrFile, new File(
					"C:\\NotBackedUp\\EclipseWorkspace\\ScreenShot\\" + folderName + "\\"
							+ s + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
