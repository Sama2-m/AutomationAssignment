package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PageBase;

public class CreateAnAccntPage extends PageBase {
	public CreateAnAccntPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, 20);
		actions = new Actions(driver);
	}

	By firstName = By.id("customer_firstname");
	By lastName = By.id("customer_lastname");
	By password = By.id("passwd");
	By firstNameAddInfo = By.id("firstname");
	By lastNameAddInfo = By.id("lastname");
	By address1 = By.id("address1");
	By cityAdd = By.id("city");
	By state = By.id("id_state");
	By countryAdd = By.id("id_country");
	By mobileNum = By.id("phone_mobile");
	By addAliasInfo = By.id("alias");
	By zipCodeFld = By.id("postcode");

	By rgistr = By.id("submitAccount");

	public void fillRegisterationForm(String frstName, String lstName, String passwd, String frstNameAddInfo,
			String lstNameAddInfo, String addrs, String city, String stateName, String zipCode, String mobilNum,
			String addAliasName) {
		WebElement fisrtNameTxt = driver.findElement(firstName);
		WebElement lastNameTxt = driver.findElement(lastName);
		WebElement passwordTxt = driver.findElement(password);
		WebElement firstNameAddInfoTxt = driver.findElement(firstNameAddInfo);
		WebElement lastNameAddInfoTxt = driver.findElement(lastNameAddInfo);
		WebElement address1Txt = driver.findElement(address1);
		WebElement cityAddTxt = driver.findElement(cityAdd);
//		WebElement stateTxt = driver.findElement(state);
//		WebElement countryAddTxt = driver.findElement(countryAdd);
		WebElement mobileNumTxt = driver.findElement(mobileNum);
		WebElement addAliasInfoTxt = driver.findElement(addAliasInfo);
		WebElement zipCodeTxt = driver.findElement(zipCodeFld);
		fisrtNameTxt.sendKeys(frstName);
		lastNameTxt.sendKeys(lstName);
		passwordTxt.sendKeys(passwd);
		firstNameAddInfoTxt.sendKeys(frstNameAddInfo);
		lastNameAddInfoTxt.sendKeys(lstNameAddInfo);
		address1Txt.sendKeys(addrs);
		cityAddTxt.sendKeys(city);

		Select stateNameDrop = new Select(driver.findElement(state));
		stateNameDrop.selectByVisibleText(stateName);
		zipCodeTxt.sendKeys(zipCode);
//		stateTxt.sendKeys(stateName);
//		countryAddTxt.sendKeys(cntryName);
		mobileNumTxt.sendKeys(mobilNum);
		addAliasInfoTxt.clear();
		addAliasInfoTxt.sendKeys(addAliasName);
	}

	public void clickObRegistrBtn() {
		WebElement registerBtn = driver.findElement(rgistr);
		registerBtn.click();
	}
}
