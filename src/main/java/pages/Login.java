package pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;
 
public class Login {
	WebDriver driver;
	//ConfigFileReader configFileReader;
	
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//configFileReader=new ConfigFileReader();
	}
	
	

	public void perform_Search(String search) {
		driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		//driver.navigate().to(configFileReader.getApplicationUrl()+ "/?s=" + search + "&post_type=product");
		//driver.navigate().to("http://shop.demoqa.com/?s=" + search + "&post_type=product");
	}
	
	public void navigateTo_LoginPage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		//driver.get(configFileReader.getApplicationUrl());
		//driver.get("http://www.shop.demoqa.com");
	}
 
}