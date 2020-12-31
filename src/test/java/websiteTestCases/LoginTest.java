package websiteTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.HomePage;
import pages.MyAccountPage;
import pages.RegistrationAndLoginPage;

public class LoginTest extends TestBase {

	HomePage HomePageObject;
	RegistrationAndLoginPage registrationAndLoginPageObject;
	MyAccountPage myAccountPageObject;

	String HomeUrl = utilities.LoadProperties.userData.getProperty("MyStoreUrl");
	String loginMail = utilities.LoadProperties.userData.getProperty("EmailAddress");
	String loginPassword = utilities.LoadProperties.userData.getProperty("Password");

	@BeforeMethod
	public void BeforeMethod() {
		openBrowser(HomeUrl);
	}

	@Test
	@Severity(SeverityLevel.NORMAL)
	@Description("login successfully")
	public void loginSuccessfully() {
		HomePageObject = new HomePage(driver);
		HomePageObject.clickOnSignInBtn();

		registrationAndLoginPageObject = new RegistrationAndLoginPage(driver);
		registrationAndLoginPageObject.fillLoginInfo(loginMail, loginPassword);
		registrationAndLoginPageObject.clickOnLoginBtn();

		myAccountPageObject = new MyAccountPage(driver);
		Assert.assertEquals(myAccountPageObject.accntWelcomeMsg(),
				"Welcome to your account. Here you can manage all of your personal information and orders.");
		
		System.out.println("login has been done successfully and welcome message displayed is : "+ myAccountPageObject.accntWelcomeMsg());
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

}
