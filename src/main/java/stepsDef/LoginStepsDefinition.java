package stepsDef;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pages.Login;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




//Set 1 Commit
/*public class LoginStepsDefinition {

	   private ContextSteps contextSteps;

	   // PicoContainer injects class ContextSteps
	   public LoginStepsDefinition (ContextSteps contextSteps) {
	      this.contextSteps = contextSteps;
	   }*/

	  
	   public class LoginStepsDefinition  {
	
		   public WebDriver driver;
			//HomePage homePage;//=new HomePage(driver);
			/*CartPage cartPage;//=new CartPage(driver);
			ProductListingPage productListingPage;//=new ProductListingPage(driver);
			CheckOutPage checkOutPage;//=new CheckOutPage(driver);
*/			PageObjectManager pageObjectManager;
			ConfigFileReader configFileReader;
			WebDriverManager webDriverManager;
			
	
	
	/*ExtentReports Report;
	ExtentTest Test;*/
	//LoginPage loginpage=new LoginPage(driver, Report, Test);
	//ActionSwitch AS =new ActionSwitch(driver, Report, Test);
	
	/*SettingsPage settingsPage=new SettingsPage(driver,Report,Test);
	HomePage  homePage=new HomePage(driver,Report,Test);
	 StartReviewPage startReviewPage = new StartReviewPage(driver,Report,Test);
	 DrillDownPage drilldownPage=new DrillDownPage(driver,Report,Test);
	 LoginPage loginPage=new LoginPage(driver,Report,Test);
	 ReviewPage reviewPage=new ReviewPage(driver,Report,Test);
	 MenuPage menuPage=new MenuPage(driver,Report,Test);
	 String reviewId;
	 List<String> parameters = null;
	 String parentwindow;*/
	 
	 Login login;
	
 

	 @Given("^User is on application Home Page$")
	 public void user_is_on_application_Home_Page() throws Throwable , InterruptedException, IOException {
	  
	 // PropertyFileReader.property();
	 // System.setProperty(PropertyFileReader.getChrome(),PropertyFileReader.getChromePath());
	  /*System.setProperty(chrome,ChromePath);--PropertyFileREader.java
	   * System.setProperty(webdriver.chrome.driver,D\://chromedriver.exe)--from the Config.properties file */
	  
	 // System.setProperty(PropertyFileReader.getPath(),PropertyFileReader.getHappypathSheet());
		 webDriverManager=new WebDriverManager(); 
		driver=webDriverManager.getDriver();
		 driver.manage().window().maximize();
		// Report=ExtentManager.getInstance();
		  Thread.sleep(1000);
		  
		pageObjectManager=new PageObjectManager(driver);
		login=pageObjectManager.getLogin();
		login.navigateTo_LoginPage();
	  //driver=new ChromeDriver();
	  //WebDriver driver = contextSteps.getDriver();
	 	
	 
	  //driver.navigate().to(PropertyFileReader.getURL());
	  //https\://test.cdduk.kycnet.com/
	  Thread.sleep(5000);
  }
  
  
  
	 @When("^User enters valid username \"([^\"]*)\" and password \"([^\"]*)\"$")
	 public void user_enters_valid_username_and_password(String uname, String pwd) throws Throwable {
 		 
		 login.enter_userName(uname);
		 login.enter_password(pwd);
		 login.click_login();
		 
		 
 		    /*driver.findElement(By.id("user_name")).sendKeys(uname);
 		    driver.findElement(By.id("user_pass")).sendKeys(pwd);
 		    driver.findElement(By.xpath("//button[@id ='loginButton']")).click();*/
		 
		 
 	 /* String parameter = uname.concat(",").concat(pwd);
 	  System.out.println(parameter);
 	  LoginPage loginpage=new LoginPage(driver, Report, Test);
 	  passActionArguments(loginpage,methodname,parameter);
 	  //loginpage.loginUser(parameter);
*/ 	   
 	}

  @Then("^User should be able to login successfully$")
	public void user_should_be_able_to_login_successfully() throws Throwable {
	  Thread.sleep(1000);
	  
        String header = login.homePage_headerText();  
		//String str = driver.findElement(By.xpath("//*[@id=\"mineReviews\"]/h2")).getText();
		String headeractual = "My reviews";
		Assert.assertEquals(header, headeractual);
		login.click_logout();
		//driver.findElement(By.xpath("//a[@href='/users/logout/']")).click();
	
	}
	
  @When("^User enters invalid username \"([^\"]*)\" and password \"([^\"]*)\"$")
  public void user_enters_invalid_username_and_password(String uname, String pwd) throws Throwable {
	  login.enter_userName(uname);
		 login.enter_password(pwd);
		 login.click_login();
  }

	@Then("^User should not be able to login successfully$")
	public void user_should_not_be_able_to_login_successfully() throws Throwable {
		 String str = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div")).getText();
		System.out.println(str);
		
		Assert.assertTrue(str.contains("Login failed"));
	}

	
	
	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		driver.close();
	}
	
	
	/* Change Password*/
	
	//@When("^User clicks on the settings button$")
	@When("^User clicks on the settings button \"([^\"]*)\"$")
	public void user_clicks_on_the_settings_button(String parameter) throws Throwable ,NullPointerException,IOException{
		
		Thread.sleep(3000);
		
		WebElement settings = driver.findElement(By.xpath("//a[contains(@href,'/users/profile/')]"));
		settings.click();
		Assert.assertTrue(driver.getTitle().toString().contains("Change your profile"));
		
		 /*try
			 { System.out.println("Parameter agaib: "+parameter);
				parameters=ControlHandling.getParameters(parameter);				    
			    menuPage.clickSettings();
				ControlHandling.trueAssertion(settingsPage.header.getText().toString().contains("Change your profile"), Test, "header");
				ControlHandling.listOfAssertion(settingsPage.label,"Username:,Change your password:,Repeat password:,Theme:,Display:,First name:,Last name:,Email address:,Current password:",Test);
				settingsPage.editSettingFields(parameters.get(1),parameters.get(2),parameters.get(3));
				settingsPage.enterCurrentPwd(parameters.get(0));
				settingsPage.clickOnSave();
				settingsPage.clickCancel();		
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Report.flush();
			 }
			 
			 catch(Exception e)
			 	{
			 		Test.log(Status.FAIL, e.toString());
			 		
			 		ExceptionScreenshot.getScreenshot();
			 	}
			 */
			 
		 }

	   
	

	@Then("^User navigates to the change profile password page \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void user_navigates_to_the_change_profile_password_page(String firstname, String lastname, String currentpwd) throws Throwable {
	    
		Assert.assertTrue(driver.getTitle().toString().contains("Change your profile"));
		
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys(firstname);
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys(lastname);
		driver.findElement(By.id("old_password")).sendKeys(currentpwd);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='Save your profile']")).click();
	
		
	
	}

	
 /* @AfterSuite
  public void afterSuite() {
	  driver.close();
	  driver.quit();
  }*/

}
