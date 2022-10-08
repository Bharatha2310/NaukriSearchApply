package com.naukri.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaukriPage {

	WebDriver ldriver;


	public NaukriPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	    @FindBy(xpath="//*[@id=\"login_Layer\"]")
	    @CacheLookup
	    WebElement naukriLogin;
	    
	    public void naukriLogin()
	    {
	    	naukriLogin.click();
	    }
	    
	    @FindBy(xpath="//input[@placeholder='Enter your active Email ID / Username']")
	    @CacheLookup
	    WebElement naukriEmailId;
	    
	    public void naukri_Emailid(String nauEmail)
	    {
	    	naukriEmailId.sendKeys(nauEmail);
	    }
	    
	    @FindBy(xpath="//input[@placeholder='Enter your password']")
	    @CacheLookup
	    WebElement naukriPassword;
	    
	    public void naukri_Password(String nauPassword)
	    {
	    	naukriPassword.sendKeys(nauPassword);
	    }
	    
	    @FindBy(xpath="//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[6]/button")
	    @CacheLookup
	    WebElement naukriEmailPassLogin;
	    
	    public void naukriEmailPassLogin()
	    {
	    	naukriEmailPassLogin.click();
	    }
	    
	    @FindBy(xpath="//input[@id='qsb-keyskill-sugg']")
	    @CacheLookup
	    WebElement naukriProfileSearchClick;
	    
	    public void naukri_ProfileSearchClick()
	    {
	    	naukriProfileSearchClick.click();
	    }
	    
	    @FindBy(xpath="//input[@id='qsb-keyskill-sugg']")
	    @CacheLookup
	    WebElement naukriProfileSearch;
	    
	    public void naukri_ProfileSearch(String nauProfileSearch)
	    {
	    	naukriProfileSearch.sendKeys(nauProfileSearch);
	    }
	    
	    @FindBy(xpath="//*[@id=\"search-jobs\"]/button")
	    @CacheLookup
	    WebElement naukriJobClick;
	    
	    public void naukri_JobClick()
	    {
	    	naukriJobClick.click();
	    }
	    
	    @FindBy(xpath="//*[@id=\"qsb-location-sugg\"]")
	    @CacheLookup
	    WebElement naukriLocationSearch;
	    
	    public void naukri_LocationSearch(String nauLocationSearch)
	    {
	    	naukriLocationSearch.sendKeys(nauLocationSearch);
	    }
	    
	    @FindBy(xpath="//*[@id=\"root\"]/main/div[2]/div[2]/section[1]/div[1]/div[3]/div/button[2]")
	    @CacheLookup
	    WebElement naukriJobApply;
	    
	    public void naukri_JobApply()
	    {
	    	naukriJobApply.click();
	    }
	    
	    @FindBy(xpath="//a[@class='fright fs14 btn-secondary br2']")
	    @CacheLookup
	    WebElement naukriPagination;
	    
	    public void naukri_Pagination()
	    {
	    	naukriPagination.click();
	    }
}
