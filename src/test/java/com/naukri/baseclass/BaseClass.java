package com.naukri.baseclass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.naukri.utilities.ReadConfig;


public class BaseClass {

	ReadConfig read_config=new ReadConfig();
	public String baseUrl = read_config.getbaseURL();
	public String email = read_config.getEmail();
	public String password = read_config.getPassword();
	public String profilesearch = read_config.getProfileSearch();
	public String location = read_config.getNaukriLocation();
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",read_config.getChromepath());
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", "disable-popup-blocking");
		driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
		logger = Logger.getLogger("Naukri Search");
		PropertyConfigurator.configure("log4j.properties");
			
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/screenshot/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
}
