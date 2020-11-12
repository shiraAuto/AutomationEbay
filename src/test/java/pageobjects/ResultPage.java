package pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class ResultPage extends BasePage{

	@FindBy(css=".srp-controls__default-refinements")
	private WebElement searchBar;
	
	@FindBy(css=".srp-controls__count>h1")
	private WebElement resultNum;
	
	public ResultPage(WebDriver driver) {
		super(driver);
	}

	@Step("print controls")
	public void printControls() {
	
	  List <WebElement> upperControlTabsList = driver.findElements(By.cssSelector(".srp-controls__control>ul>li"));
	      for (WebElement elControl : upperControlTabsList) {
			System.out.println(elControl.getText());
		  }	
	}
	
	
	@Step("get result number")
	public boolean getResultNumber() {
		String resultTextLine=resultNum.getText();
	    System.out.println(resultTextLine + " in the page");
	    if(resultTextLine.contains("result for"))
	       return true;
	    else
		   return false;
	}

	@Step("get result number")
	public boolean getResultText(String searchText) {
		String resultTextLine=resultNum.getText();
		System.out.println(resultTextLine + " in the page");
		if(resultTextLine.contains(searchText))
			return true;
		else
			return false;
	}

	@Step("choose control - {0}")
	public void chooseControl(String control) {		
      List <WebElement> upperControlTabsList = driver.findElements(By.cssSelector(".srp-controls__control>ul>li"));
	      for (WebElement elControl : upperControlTabsList) {
	    	  if(elControl.getText().equalsIgnoreCase("buy it now")) 
	    	  {
	    		  click(elControl);
	    		  break;
	    	  }

		  }	
	      System.out.println("After click " + control);
	      getResultNumber();
	}

}
