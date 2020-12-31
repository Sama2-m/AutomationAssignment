package websiteTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.AccountHomePage;
import pages.HomePage;
import pages.MyAccountPage;
import pages.RegistrationAndLoginPage;
import pages.ShoppingCartPage;

public class CartCheckOutTest extends TestBase {
	HomePage HomePageObject;
	RegistrationAndLoginPage registrationAndLoginPageObject;
	MyAccountPage myAccountPageObject;
	AccountHomePage accountHomePageObject;
	ShoppingCartPage shoppingCartPageObject;

	String HomeUrl = utilities.LoadProperties.userData.getProperty("MyStoreUrl");
	String loginMail = utilities.LoadProperties.userData.getProperty("EmailAddress");
	String loginPassword = utilities.LoadProperties.userData.getProperty("Password");

	@BeforeMethod
	public void BeforeMethod() {
		openBrowser(HomeUrl);
	}

	@Test
	@Severity(SeverityLevel.NORMAL)
	@Description("cart Check Out")
	public void cartCheckOut() {
		HomePageObject = new HomePage(driver);
		HomePageObject.clickOnSignInBtn();

		registrationAndLoginPageObject = new RegistrationAndLoginPage(driver);
		registrationAndLoginPageObject.fillLoginInfo(loginMail, loginPassword);
		registrationAndLoginPageObject.clickOnLoginBtn();

		myAccountPageObject = new MyAccountPage(driver);
		myAccountPageObject.navigateToAcctHome();

		accountHomePageObject = new AccountHomePage(driver);
		accountHomePageObject.addItemToCart();
		accountHomePageObject.clickOnProceedToCheckOut();

		shoppingCartPageObject = new ShoppingCartPage(driver);
//		Assert.assertEquals(shoppingCartPageObject.getTextInShoppingCart(), "Shopping-cart summary");
		shoppingCartPageObject.clickOnProceedToCheckOut();
		shoppingCartPageObject.clickOnProceedSecondStp();
		shoppingCartPageObject.accptTermsAndCondition();
		shoppingCartPageObject.clickOnProceedThrdStp();
		shoppingCartPageObject.selectPayOption1();
		shoppingCartPageObject.confirmOrder();
		Assert.assertEquals(shoppingCartPageObject.getConfirmationTxt(), "Your order on My Store is complete.");
		System.out.println("care check out is done successfully with confirmation message : "+shoppingCartPageObject.getConfirmationTxt());

	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
