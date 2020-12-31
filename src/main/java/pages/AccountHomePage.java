package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PageBase;

public class AccountHomePage extends PageBase {
	public AccountHomePage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, 20);
		actions = new Actions(driver);
	}

	By firstItem = By.xpath("//*[@id='homefeatured']//child::li[1]");
	By addToCart = By.xpath("//*[@data-id-product='1']");
	By productLst = By.id("homefeatured");

	By checkOut = By.xpath("//*[@title='Proceed to checkout']");

	By itemAddedToCart = By.xpath("//i[@class='icon-ok']");

	public void addItemToCart() {
		Actions actions = new Actions(driver);
		WebElement firstProduct = driver.findElement(firstItem);
		actions.moveToElement(firstProduct).perform();

		WebElement addToCartBtn = driver.findElement(addToCart);
		addToCartBtn.click();
	}

	public void clickOnProceedToCheckOut() {
//		WebElement successMsg = driver.findElement(itemAddedToCart);		
		WebElement checkOutBtn = driver.findElement(checkOut);
		checkOutBtn.click();

	}

}
