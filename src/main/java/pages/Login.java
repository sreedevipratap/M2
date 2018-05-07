package pages;
 
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
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
//----------------------------------------------------------------	
	@FindBy(how =How.XPATH, using = "//input[@name ='user_name']")
    public WebElement username_Fld; 
	
    @FindBy(how =How.XPATH, using = "//input[@name ='user_pass']")
    public WebElement password_Fld; 
    
    @FindBy(how = How.XPATH, using = "//button[@id ='loginButton']")
    public WebElement login_Btn; 
    
	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger']")
    public WebElement alert_msg;
	
	@FindBy(how = How.XPATH, using = "//div[@id='mineReviews']/h2")
	public WebElement homePage_header;
	
	@FindBy(how = How.XPATH, using = "//a[@href='/users/logout/']")
	public WebElement logout_Btn;
	
    
    List<String> parameters = null;
    
    public void enter_userName(String username)
	{
    	username_Fld.sendKeys(username);
	}
	
	public void enter_password(String password) {
		
		password_Fld.sendKeys(password);
	}

	public void click_login() {
		login_Btn.click();
	}
	
	public String homePage_headerText() {
		return homePage_header.getText();
	}
	
	public void click_logout() {
		logout_Btn.click();
	}
//--------------------------------------------------
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