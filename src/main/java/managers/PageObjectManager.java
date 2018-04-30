package managers;


import org.openqa.selenium.WebDriver;



//import Report.ExtentManager;

import pages.Login;

public class PageObjectManager {
	
	private WebDriver driver;
	/*private ExtentReports report;
	private ExtentTest test;
	*/
	private Login login;
	
	//private ConfirmationPage confirmationPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public Login getLogin() {
		return(login==null)? login=new Login(driver):login;
	}
	
	
	
	
	}
