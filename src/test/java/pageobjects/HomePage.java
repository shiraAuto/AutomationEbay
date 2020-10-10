package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import io.qameta.allure.Step;
import utilities.AllureAttachment;

public class HomePage extends BasePage{

	

	@FindBy(css="#gh-ac-box2>input")
	private WebElement searchBar;

	@FindBy(css="td:nth-child(3)>.btn")
	private WebElement searchBtn;

	@FindBy(css="noElement")
	private WebElement noElement;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	
	
	
	@Step("search item - {0}")
	public void searchItem(String query) {
		fillText(searchBar, query);
		AllureAttachment.attachElementScreenshot(searchBtn);
		//click(noElement);
		click(searchBtn);
		
	}
	
	@Step("choose category - {0}")
	public void chooseCategory(String categoryToSearch) {		
		Select categories = new Select(driver.findElement(By.cssSelector("#gh-cat")));
		categories.selectByVisibleText(categoryToSearch);
		
		
	}

}
