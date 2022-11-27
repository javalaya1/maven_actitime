package com.atlas.maven_actitime.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActTimeTasksPage extends BasePage {
	private WebDriver driver; // this.driver;
	public ActTimeTasksPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);// with this line @FindBy will work
	}

	@FindBy(xpath = "//div[@class='addNewButton']/div[normalize-space()='Add New']")
	private WebElement addNewButton;

	@FindBy(xpath = "//div[normalize-space()='+ New Customer']")
	private WebElement newCustomerButton;

	@FindBy(css = "div[class='customerNameDiv']>input[placeholder='Enter Customer Name']")
	private WebElement customerNameTextBox;

	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	private WebElement customerDescriptionTextBox;

	@FindBy(xpath = "//div[text()='Create Customer']")
	private WebElement createCustomerButton;

	@FindBy(xpath = "(//div[text()='ACTIONS'])[1]")
	private WebElement actionsButton;

	@FindBy(xpath = "(//div[text()='Delete'])[2]")
	private WebElement deleteButton;

	@FindBy(xpath = "//span[text()='Delete permanently']")
	private WebElement deletePermanetlyButton;

	public void clickAddNewButton() {
		addNewButton.click();
	}

	public void clickNewCustomerButton() {
		newCustomerButton.click();
	}

	public void enterCustomerName(String nameInput) {
		customerNameTextBox.clear();
		customerNameTextBox.sendKeys(nameInput);
	}

	public void enterCustomerDesc(String descMsg) {
		customerDescriptionTextBox.clear();
		customerDescriptionTextBox.sendKeys(descMsg);
	}

	public void clickCreateCustomer() {
		createCustomerButton.click();
	}

	public String getCreatedCustomerText(String customerName) {
		WebElement createdCustomerText = driver.findElement(By.xpath("//div[text()='" + customerName + "']"));
		return createdCustomerText.getText();
	}

	public void clickOnCustomerToDelete(String customerName) {
		WebElement createdCustomer = driver.findElement(By.xpath("//div[text()='" + customerName + "']"));
		createdCustomer.click();
	}

	public void clickEditButton(String customerToEdit) {

		WebElement customerEditButton = driver
				.findElement(By.xpath("//div[text()='" + customerToEdit + "']/../div[@class='editButton']"));
		customerEditButton.click();
	}

	public void clickActions() {
		String xpath = "//div[contains(@class,'edit_customer_sliding_panel')]//div[@class='actions']//div[text()='ACTIONS']";
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		FluentWait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.pollingEvery(Duration.ofSeconds(5));
		wait.ignoring(ElementClickInterceptedException.class);

		WebElement customerEditActionsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

		customerEditActionsButton.click();
	}

	public void clickDeleteLink() {
		String xpath = "//div[contains(@class,'edit_customer_sliding_panel')]//div[text()='Delete']";
		WebElement customerEditDeleteButton = driver.findElement(By.xpath(xpath));

		customerEditDeleteButton.click();
	}

	public void clickDeletePermanetlyButton() {
		deletePermanetlyButton.click();
	}

}
