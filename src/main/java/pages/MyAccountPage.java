package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PageBase;

public class MyAccountPage extends PageBase {
	public MyAccountPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, 20);
		actions = new Actions(driver);
	}

	By cstomrName = By.xpath("//*[@title='View my customer account']");
	By accntsentence = By.xpath("//*[@class='info-account']");

	By homeIcon = By.xpath("//*[@class='icon-home']");

	public String getCstmrName() {
		WebElement CustomerName = driver.findElement(cstomrName);
		System.out.println("customer name is :" + CustomerName.getText());
		return CustomerName.getText();

	}

	public String accntWelcomeMsg() {
		WebElement welcomeMsgTxt = driver.findElement(accntsentence);
		System.out.println("displayed message is " + welcomeMsgTxt.getText());
		return welcomeMsgTxt.getText();
	}

	public void navigateToAcctHome() {
		WebElement homeBtn = driver.findElement(homeIcon);
		homeBtn.click();
	}

}
