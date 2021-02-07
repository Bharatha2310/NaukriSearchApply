package com.naukri.testcase;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.naukri.baseclass.BaseClass;

public class SearchDotNetDeveloper extends BaseClass {
	
	@Test
	public void searchDotNet() throws AWTException, InterruptedException
	{
		driver.get(baseUrl);
		logger.info("Entering the valid data in IRCTC Username");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,50);
		JavascriptExecutor js =(JavascriptExecutor)driver;
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		Robot robot = new Robot();
	    String naukrititle = 	driver.getTitle();
	    wait.until(ExpectedConditions.titleContains(naukrititle));
	    driver.findElement(By.xpath("//div[normalize-space()='Login']")).click();
	    Thread.sleep(5000);
	   // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")));
	    driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")).sendKeys(email);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys(password);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	    String naukrihome = driver.getTitle();
	    wait.until(ExpectedConditions.titleContains(naukrihome));
	    driver.findElement(By.xpath("//input[@id='qsb-keyskill-sugg']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@id='qsb-keyskill-sugg']")).sendKeys("Dot Net");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@id='qsb-keyskill-sugg']")).click();
	    driver.findElement(By.xpath("//input[@id='qsb-keyskill-sugg']")).sendKeys(Keys.TAB);
	    driver.findElement(By.xpath("//*[@id=\"qsb-location-sugg\"]")).sendKeys("Bangalore");
	    driver.findElement(By.xpath("//*[@id=\"search-jobs\"]/button")).click();
	    Thread.sleep(3000);
	    String jobresult = driver.getTitle();
	    wait.until(ExpectedConditions.titleContains(jobresult));
	    Thread.sleep(5000);
	    
	    for(int i = 1 ; i <= 20; i++)
	    {   
	    WebElement article = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/section[2]/div[2]/article["+i+"]/div[1]"));
	    	js.executeScript("arguments[0].scrollIntoView(true);",article);
	    Thread.sleep(5000);
	    String jobprofile =  driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/section[2]/div[2]/article["+i+"]/div[1]/div[1]/a")).getAttribute("title");
	    System.out.println(jobprofile); 
	    Thread.sleep(3000);
	    if (jobprofile.contains(".NET") || jobprofile.contains("Dot Net") || jobprofile.contains("DotNet") || jobprofile.contains(".net"))
	    {
	    	String jobtype = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/section[2]/div[2]/article[1]/div[3]/div[1]/span")).getText();
	    	if(jobtype.contains("HOT JOB") || jobtype.contains("PREFERRED")) {
	    	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/section[2]/div[2]/article["+i+"]/div[3]")).click();
	    	}
			//driver.switchTo().window(tabs2.get(1));
			Thread.sleep(5000);
	    	for (String handle : driver.getWindowHandles()) {
			    driver.switchTo().window(handle);}
	    	String title = driver.getTitle();
	    	System.out.println(title);
	    	if(title.contains( jobprofile ))
	    	{
	    	driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[2]/div[2]/section[1]/div[1]/div[3]/div/button[2]")).click();
	    	Thread.sleep(5000);
	    	System.out.println("Applied Successfully");
	    	driver.switchTo().window(tabs2.get(0));
	    	String index = driver.getTitle();
	    	System.out.println(index);
	    	}
	    	else
	    	{
	    	driver.switchTo().window(tabs2.get(0));
	    	String index = driver.getTitle();
	    	System.out.println(index);
	    }
	    
	    	}
	}
	}

	
}
