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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.naukri.baseclass.BaseClass;
import com.naukri.pageobject.NaukriPage;

import ch.qos.logback.classic.Logger;

public class SearchTestEngineer extends BaseClass {

	@Test
	public void searchTestEngineer() throws AWTException, InterruptedException {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest naukriTest = extent.createTest("Search Job for Test Engineer","This is automatic job apply");
		NaukriPage naukri = new NaukriPage(driver);
		driver.get(baseUrl);
		logger.info("Entering the valid data in naukri website");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		Robot robot = new Robot();
		logger.info("Validating title of the naukri home page");
		String naukrititle = driver.getTitle();
		wait.until(ExpectedConditions.titleContains(naukrititle));
		logger.info("Clicking on the sigin button");
		naukri.naukriLogin();
		logger.info("Entering the naukri email id");
		naukri.naukri_Emailid(email);
		logger.info("Entering the naukri password");
		naukri.naukri_Password(password);
		logger.info("Clicking on the login");
		naukri.naukriEmailPassLogin();
		logger.info("validating nuakri profile search");
		naukriTest.pass("Login success");
		String naukrihome = driver.getTitle();
		wait.until(ExpectedConditions.titleContains(naukrihome));
		logger.info("Enter the profile title and location ");
		naukri.naukri_ProfileSearchClick();
		naukri.naukri_ProfileSearch(profilesearch);
		naukri.naukri_JobClick();
		naukri.naukri_LocationSearch(location);
		naukri.naukri_JobClick();
		extent.flush();
		String jobresult = driver.getTitle();
		wait.until(ExpectedConditions.titleContains(jobresult));
		for (int j = 1; j <= 20; j++) {
			for (int i = 1; i <= 20; i++) {
				WebElement article = driver.findElement(
						By.xpath("//*[@id=\"root\"]/div[4]/div/section[2]/div[2]/article["+ i +"]/div[1]"));
				js.executeScript("arguments[0].scrollIntoView(true);", article);
				Thread.sleep(5000);
				String jobprofile = driver
						.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/section[2]/div[2]/article["+i+"]/div[1]/div/a")).getAttribute("title");
				System.out.println(jobprofile);
				Thread.sleep(3000);
				if (jobprofile.contains("Test Engineer") || jobprofile.contains("QA") || jobprofile.contains("Manual")
						|| jobprofile.contains("Test") || jobprofile.contains("Engineer")) {
					String jobtype = driver.findElement(By.xpath(
							"//*[@id=\"root\"]/div[4]/div/section[2]/div[2]/article["+i+"]/div[1]/div/a"))
							.getText();
					Thread.sleep(5000);
					driver.findElement(
							By.xpath("//*[@id=\"root\"]/div[4]/div/section[2]/div[2]/article["+ i +"]"))
							.click();
					Thread.sleep(5000);
					for (String handle : driver.getWindowHandles()) {
						driver.switchTo().window(handle);
					}
					String title = driver.getTitle();
					System.out.println(title);
					if (title.contains(jobprofile)) {
						Thread.sleep(5000);
						naukri.naukri_JobApply();
						Thread.sleep(3000);
						System.out.println("Applied Successfully");
						Thread.sleep(3000);
						driver.switchTo().window(tabs2.get(0));
						Thread.sleep(3000);
						String index = driver.getTitle();
						System.out.println(index);
					} else {
						driver.switchTo().window(tabs2.get(0));
						String index = driver.getTitle();
						System.out.println(index);
					}

				}
			}
			naukri.naukri_Pagination();
			Thread.sleep(2000);
		}
	}
}