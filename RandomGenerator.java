package com.selenium.codp.utilities;

import java.util.Random;

public class RandomGenerator {

	private static final String CHAR_LIST = "abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int RANDOM_STRING_LENGTH = 10;
	
	//generate Random String
	public static String generateRandomString() {

		StringBuffer randStr = new StringBuffer();

		for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}

	// generate random Numbers
	public static int getRandomNumber() {
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}

	}
	
	public static String getRandomString() {

		StringBuffer randStr = new StringBuffer();

		for (int i = 0; i < 3; i++) {
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}
	

}
