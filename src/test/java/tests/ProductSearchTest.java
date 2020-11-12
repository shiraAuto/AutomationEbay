package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageobjects.HomePage;
import pageobjects.ResultPage;
import utilities.AllureAttachment;
import utilities.Log;
import utilities.Utils;

public class ProductSearchTest extends BaseTest{
	   
	    SoftAssert softAssert = new SoftAssert();

      @DataProvider(name = "test-data")
      public Object[][] dataProvFunc(){
        return new Object[][]{
                {"pazzle"},{"doll"}
        };
       }

        @Description("search - dataprovider")
        @Severity(SeverityLevel.NORMAL)
        @Test(dataProvider ="test-data")
        public void test00_searcItem(String searchText) throws InterruptedException {
            HomePage home = new HomePage(driver);
            home.searchItem(searchText);
			ResultPage rp = new ResultPage(driver);
			softAssert.assertTrue(rp.getResultText(searchText));

        }

		@Description("search for item")
	    @Severity(SeverityLevel.NORMAL)
	    @Test
		public void test01_searcItem() throws InterruptedException {
        HomePage home = new HomePage(driver);
		home.chooseCategory("Baby");
		///search.searchItem("cannon IXUS Digital camera");
		home.searchItem("baby pazzle");

		}

    	
    	@Description("result after search")
	    @Severity(SeverityLevel.NORMAL)
	    @Test
		public void test02_resultsSearch() throws InterruptedException {		
        String currentUrl;		
		ResultPage rp = new ResultPage(driver);
		softAssert.assertTrue(rp.getResultNumber());
		//rp.printControls();
		rp.chooseControl("Buy It Now");		
		////rp.printControls();
		currentUrl=driver.getCurrentUrl();
		softAssert.assertEquals(currentUrl, "https://demoqa.com/elements");
		softAssert.assertAll();
    	}
			
    
    	
    
}
