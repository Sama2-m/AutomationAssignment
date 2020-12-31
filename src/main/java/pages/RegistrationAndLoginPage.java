package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PageBase;

public class RegistrationAndLoginPage extends PageBase {

	public RegistrationAndLoginPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, 20);
		actions = new Actions(driver);
	}

	By registrationMail = By.id("email_create");
	By CrteAccnt = By.id("SubmitCreate");

	By mailtoLogin = By.id("email");
	By passwordtoLogin = By.id("passwd");
	By login = By.id("SubmitLogin");

	public void insertMailAddress(String mail) throws InterruptedException {
		WebElement registrationMailBx = driver.findElement(registrationMail);
		registrationMailBx.sendKeys(mail);

	}

	public void clickOnCrteAccountBtn() {
		WebElement CrteAccntBtn = driver.findElement(CrteAccnt);
		wait.until(ExpectedConditions.elementToBeClickable(CrteAccntBtn));
//		CrteAccntBtn.sendKeys(Keys.TAB);
//		CrteAccntBtn.sendKeys(Keys.ENTER);

		CrteAccntBtn.click();

	}

	public void fillLoginInfo(String mail, String password) {
		WebElement mailToLoginTxt = driver.findElement(mailtoLogin);
		mailToLoginTxt.sendKeys(mail);

		WebElement passwordToLoginTxt = driver.findElement(passwordtoLogin);
		passwordToLoginTxt.sendKeys(password);
	}

	public void clickOnLoginBtn() {
		WebElement loginBtn = driver.findElement(login);
		loginBtn.click();

	}
}
