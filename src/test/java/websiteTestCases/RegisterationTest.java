package websiteTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.CreateAnAccntPage;
import pages.HomePage;
import pages.MyAccountPage;
import pages.RegistrationAndLoginPage;



public class RegisterationTest 
    extends TestBase{
	
	HomePage HomePageObject;
	RegistrationAndLoginPage registrationAndLoginPageObject;
	CreateAnAccntPage createAnAccntPageObject;
	MyAccountPage myAccountPageObject;
	
	
	String HomeUrl= utilities.LoadProperties.userData.getProperty("MyStoreUrl");
	String mail = utilities.LoadProperties.userData.getProperty("EmailAddress");
	String firstName = utilities.LoadProperties.userData.getProperty("FirstName");
	String lstName = utilities.LoadProperties.userData.getProperty("LastName");
	String password = utilities.LoadProperties.userData.getProperty("Password");
	String AddInfo1 = utilities.LoadProperties.userData.getProperty("firstNameAddInfo");
	String AddInfo2 = utilities.LoadProperties.userData.getProperty("lastNameAddInfo");
	String Address = utilities.LoadProperties.userData.getProperty("address1");
	String cityName = utilities.LoadProperties.userData.getProperty("cityAdd");
	String stateName = utilities.LoadProperties.userData.getProperty("state");
	String cntryName = utilities.LoadProperties.userData.getProperty("countryAdd");
	String basicMobileNum = utilities.LoadProperties.userData.getProperty("mobileNum");
	String aliasAddName = utilities.LoadProperties.userData.getProperty("addAliasInfo");
	String zipCodeValue = utilities.LoadProperties.userData.getProperty("ZipCode");
	

	
	@BeforeMethod
	public void BeforeMethod() {
		openBrowser(HomeUrl);
	}
	
	@Test
	@Severity(SeverityLevel.NORMAL)
	@Description("register to mystore website successfully")
	public void registerSuccessfully () throws InterruptedException {
		HomePageObject = new HomePage(driver);
		HomePageObject.clickOnSignInBtn();
		
		registrationAndLoginPageObject = new RegistrationAndLoginPage(driver);
		registrationAndLoginPageObject.insertMailAddress(mail);
		
		
		registrationAndLoginPageObject.clickOnCrteAccountBtn();
		
		createAnAccntPageObject = new CreateAnAccntPage(driver);
		createAnAccntPageObject.fillRegisterationForm(firstName, lstName, password, AddInfo1, AddInfo2, Address, cityName, stateName,zipCodeValue,basicMobileNum,aliasAddName);
		
		createAnAccntPageObject.clickObRegistrBtn();
		myAccountPageObject = new MyAccountPage(driver);
		Assert.assertEquals(myAccountPageObject.getCstmrName(), firstName+" "+ lstName);
		System.out.println("registeration has been done successfully and user name of Customer is : "+ myAccountPageObject.getCstmrName());
		
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
    
}
