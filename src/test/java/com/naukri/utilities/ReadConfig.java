package com.naukri.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig  {

	
Properties pro;
	
	public  ReadConfig()
	{
		File src = new File("./configuration/naukriinput.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is"+ e.getMessage());
		}
		}
	
	//Getting ChromePath
	public String getChromepath()
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	
	//Getting URL
	public String getbaseURL() {
		String url = pro.getProperty("baseUrl");
		return url;
	}
	
	//Getting email address
	public String getEmail()
	{
	String emailaddress = pro.getProperty("email");	
	return emailaddress;
	
	}
	
	//Getting Password
	public String getPassword()
	{
		String pwd = pro.getProperty("password");
		return pwd;
	}
	
	//Getting ProfileSearch
		public String getProfileSearch()
		{
			String ps = pro.getProperty("profilesearch");
			return ps;
		}
}
