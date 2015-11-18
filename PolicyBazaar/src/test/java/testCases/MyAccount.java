package testCases;


import libraries.Generic;

public class MyAccount 
{
	static Generic find = new Generic();
	public static void main(String a[])
	{
		String MobileNumber = find.valueof("MobileNumber");
		String appPath = find.valueof("appPath");
		String deviceName = find.valueof("deviceName");
		String appActivity = find.valueof("appActivity");
		String appPackage = find.valueof("appPackage");
		
		System.out.println(MobileNumber);
		System.out.println(appPath);
		System.out.println(deviceName);
		System.out.println(appActivity);
		System.out.println(appPackage);
	}
}
