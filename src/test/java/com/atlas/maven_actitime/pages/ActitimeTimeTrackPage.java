package com.atlas.maven_actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActitimeTimeTrackPage extends BasePage {
	private WebDriver driver; // this.driver;

	public ActitimeTimeTrackPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//div[normalize-space()='Tasks']")
	public WebElement tasksLink;

	public void clickTasksLink() {
//		FluentWait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(120));
//		wait.pollingEvery(Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[normalize-space()='Tasks']")));
		tasksLink.click();
	}

}
