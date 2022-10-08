package com.naukri.testcase;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.naukri.baseclass.BaseClass;

public class Amazon extends BaseClass {
	
	
@Test
public void searchForCamera() throws InterruptedException
{
	driver.get("https://www.amazon.in/");
	Thread.sleep(5000);
	WebDriverWait wait = new WebDriverWait(driver,20);
	Actions action = new Actions(driver);
	 //WebElement elec = driver.findElement(By.xpath("//*[@data-csa-c-content-id=\"nav_cs_electronics\"]"));
	 //action.moveToElement(null)
	
	 driver.findElement(By.xpath("//*[@data-csa-c-content-id=\"nav_cs_electronics\"]")).click();
	 String title = driver.getTitle();
	 Thread.sleep(5000);
	 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("canon m50");
	 driver.findElement(By.id("nav-search-submit-button")).click();
	 
	 ArrayList<String> price = new ArrayList<String>();
	  for ( int i =0 ; i <= 20; i++)
	  {
		  for ( int j=0;j<20 ; j++)
		  {
			  //String cameraname = "Canon M50 Mark II Mirrorless Camera + SanDisk 128GB Extreme Pro SDXC UHS-I Card - C10, U3, V30, 4K UHD, SD Card"
					//  if (cameraname.equalsIgnoreCase("Canon M50 Mark II Mirrorless Camera + SanDisk 128GB Extreme Pro SDXC UHS-I Card - C10, U3, V30, 4K UHD, SD Card"));
			  
			  
			  
		  }
			  
	  }
	 
	 
	 
	 
	 
	 
	
}
	
	
}
