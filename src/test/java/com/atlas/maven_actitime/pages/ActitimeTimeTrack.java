package com.atlas.maven_actitime.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActitimeTimeTrack {
	private WebDriver driver; // this.driver;

	public ActitimeTimeTrack(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath = "//div[normalize-space()='Tasks']")
	public WebElement tasksLink;

	public String getPageTitle() {
		FluentWait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.pollingEvery(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[normalize-space()='Tasks']")));

		return this.driver.getTitle();
	}



	public void clickTasksLink() {
//		FluentWait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(120));
//		wait.pollingEvery(Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[normalize-space()='Tasks']")));
		tasksLink.click();
	}

}
