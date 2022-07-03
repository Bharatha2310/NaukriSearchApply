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

public class LinkedInTestEngineer extends BaseClass {

	@Test
	public void searchDotNet() throws AWTException, InterruptedException {
		driver.get("https://www.linkedin.com/");
		logger.info("Entering the valid data in naukri website");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		Robot robot = new Robot();
		String linkedintitle = driver.getTitle();
		wait.until(ExpectedConditions.titleContains(linkedintitle));
		driver.findElement(By.xpath("//*[@id=\"session_key\"]")).sendKeys("pranaybharatha@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"session_password\"]")).sendKeys("Pr2n2y2310");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@data-tracking-control-name=\"homepage-basic_signin-form_submit-button\"]")).click();
		String naukrihome = driver.getTitle();
		wait.until(ExpectedConditions.titleContains(naukrihome));
		//click on the jobs icon
		driver.findElement(By.xpath("//*[@id=\"ember19\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@aria-label=\"Search by title, skill, or company\"]")).click();
		driver.findElement(By.xpath("//*[@aria-label=\"Search by title, skill, or company\"]")).sendKeys("software testing");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@aria-label=\"City, state, or zip code\"]")).sendKeys("Ireland");
		driver.findElement(By.xpath("//*[@class=\"jobs-search-box__submit-button\r\n"
				+ "      artdeco-button artdeco-button--2 artdeco-button--secondary\"]/button")).click();
		Thread.sleep(3000);
		String jobresult = driver.getTitle();
		wait.until(ExpectedConditions.titleContains(jobresult));
		Thread.sleep(5000);
		for (int j = 1; j <= 20; j++) {
			for (int i = 1; i <= 20; i++) {
				WebElement article = driver.findElement(
						By.xpath("//*[@id=\"root\"]/div[3]/div[2]/section[2]/div[2]/article[" + i + "]/div[1]"));
				js.executeScript("arguments[0].scrollIntoView(true);", article);
				Thread.sleep(5000);
				String jobprofile = driver
						.findElement(By.xpath(
								"//*[@id=\"root\"]/div[3]/div[2]/section[2]/div[2]/article[" + i + "]/div[1]/div[1]/a"))
						.getAttribute("title");
				System.out.println(jobprofile);
				Thread.sleep(3000);
				if (jobprofile.contains("Test Engineer") || jobprofile.contains("QA") || jobprofile.contains("Manual")
						|| jobprofile.contains("Test") || jobprofile.contains("Engineer")) {
					String jobtype = driver.findElement(By.xpath(
							"//*[@id=\"root\"]/div[3]/div[2]/section[2]/div[2]/article[" + 1 + "]/div[3]/div[1]/span"))
							.getText();
					driver.findElement(
							By.xpath("//*[@id=\"root\"]/div[3]/div[2]/section[2]/div[2]/article[" + i + "]/div[3]"))
							.click();
					Thread.sleep(5000);
					for (String handle : driver.getWindowHandles()) {
						driver.switchTo().window(handle);
					}
					String title = driver.getTitle();
					System.out.println(title);
					if (title.contains(jobprofile)) {
						driver.findElement(
								By.xpath("//*[@id=\"root\"]/main/div[2]/div[2]/section[1]/div[1]/div[3]/div/button[2]"))
								.click();
						Thread.sleep(5000);
						System.out.println("Applied Successfully");
						driver.switchTo().window(tabs2.get(0));
						String index = driver.getTitle();
						System.out.println(index);
					} else {
						driver.switchTo().window(tabs2.get(0));
						String index = driver.getTitle();
						System.out.println(index);
					}

				}
			}

			driver.findElement(By.xpath("//a[@class='fright fs14 btn-secondary br2']")).click();
			Thread.sleep(2000);
		}
	}

}
