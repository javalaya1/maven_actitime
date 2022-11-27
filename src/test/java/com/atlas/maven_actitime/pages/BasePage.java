package com.atlas.maven_actitime.pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver = null;

	protected BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public String getPageTitle() {
		FluentWait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.pollingEvery(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[normalize-space()='Tasks']")));

		return this.driver.getTitle();
	}

	public String getTakeScreenShot() {
		TakesScreenshot tss = (TakesScreenshot) driver;
		File screenshotFile = tss.getScreenshotAs(OutputType.FILE);
		String dest = "acttime_screenshots//" + getCurrentDate() + ".png";
		try {
			FileHandler.copy(screenshotFile, new File(dest));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.driver.getTitle();
	}

	public String getCurrentDate() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd-hh_mm_ss"));
	}
}
