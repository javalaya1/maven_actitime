package com.atlas.maven_actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActitimeLoginPage {
	private WebDriver driver; // this.driver;

	public ActitimeLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this); // only because of this @FindBy will work
	}

	@FindBy(id = "username")  //html
	private WebElement username_element; // we can reuse this element in multiple methods

	@FindBy(name = "pwd")
	private WebElement password_element;

	@FindBy(xpath = "//div[normalize-space()='Login']")
	private WebElement loginButton_element;

	public void enterUserName(String usernameInput) {  //functional
		username_element.clear();
		username_element.sendKeys(usernameInput);
	}

	public void enterPassword(String passInput) {
		password_element.clear();
		password_element.sendKeys(passInput);
	}

	public void clickLoginButton() {
		loginButton_element.click();
	}
}
