package com.crm.vtiger.GenericUtils;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	/*
	 * generate random number
	 * @Rincy
	 */
	
	public  static String getRandomData()
	{
		Random random=new Random();
		int ran=random.nextInt(500);
		return""+ran;
		
	}
	
	/*
	 * generate current system date
	 * @Rincy
	 */
	public static String getCurrentSystemDate()
	{
		Date date=new Date();
		String currentDate=date.toString();
		return currentDate;
	}
}
