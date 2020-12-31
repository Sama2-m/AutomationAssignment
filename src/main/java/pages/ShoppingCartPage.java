package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PageBase;

public class ShoppingCartPage extends PageBase {
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, 20);
		actions = new Actions(driver);
	}

	By cartTitle = By.xpath("//*[@class='page-heading']//self::h1");
	By checkOut = By.xpath("(//*[@title='Proceed to checkout'])[2]");

	By checkOut2 = By.xpath("//button[@name='processAddress']");

	By trmsConditios = By.id("cgv");

	By checkOut3 = By.xpath("//button[@name='processCarrier']");
	By payOption1 = By.xpath("//a[@title='Pay by bank wire']");
	By confirmOrder = By.xpath("//*[@id='cart_navigation']//child::button");
	By ordrConfirmation = By.xpath("(//*[@class='dark'])[6]");

	public String getTextInShoppingCart() {
		WebElement cartTitleTxt = driver.findElement(cartTitle);
		System.out.println("displayed text in Cart is : " + cartTitleTxt.getText());
		return cartTitleTxt.getText();

	}

	public void clickOnProceedToCheckOut() {

		WebElement checkOutBtn = driver.findElement(checkOut);
		checkOutBtn.click();

	}

	public void clickOnProceedSecondStp() {
		WebElement checkOut2Btn = driver.findElement(checkOut2);
		checkOut2Btn.click();
	}

	public void accptTermsAndCondition() {
		WebElement termsAndConditionsChckBox = driver.findElement(trmsConditios);
		termsAndConditionsChckBox.click();

	}

	public void clickOnProceedThrdStp() {
		WebElement checkOut3Btn = driver.findElement(checkOut3);
		checkOut3Btn.click();
	}

	public void selectPayOption1() {
		WebElement payOption1Btn = driver.findElement(payOption1);
		payOption1Btn.click();
	}

	public void confirmOrder() {
		WebElement confirmOrderBtn = driver.findElement(confirmOrder);
		confirmOrderBtn.click();
	}

	public String getConfirmationTxt() {
		WebElement orderConfirmationTxt = driver.findElement(ordrConfirmation);
		System.out.println("order confirmed with text : " + orderConfirmationTxt.getText());
		return orderConfirmationTxt.getText();
	}
}
