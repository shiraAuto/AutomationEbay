package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageobjects.HomePage;
import pageobjects.ResultPage;
import utilities.AllureAttachment;
import utilities.Log;
import utilities.Utils;

public class FilesAttachmentsTest extends BaseTest{
	   
	    SoftAssert softAssert = new SoftAssert();	
     
    	@Description("log file attachment")
	    @Severity(SeverityLevel.NORMAL)
    	@Link(name="ebay",url="https://www.ebay.com/")
	    @Test
		public void test01_logFileAttachment() throws InterruptedException {
	       AllureAttachment.addTextAttachment("this is a log file");
		}
    	
    	@Description("screenshot attachment")
	    @Severity(SeverityLevel.NORMAL)
    	@Issue("2")
	    @Test
		public void test02_screenshotAttachment() throws InterruptedException {		
	        String currentUrl;		
			currentUrl=driver.getCurrentUrl();
			softAssert.assertTrue(currentUrl.contains("shira"));
			softAssert.assertAll();
    	}
			
    	@Description("page source attachment")
	    @Severity(SeverityLevel.NORMAL)
	    @Test
		public void test03_pageSourceAttachment() throws InterruptedException {		
    		AllureAttachment.getPageSource(driver);
    	}
    	
    	@Description("element screenshot attachment")
	    @Severity(SeverityLevel.NORMAL)
	    @Test
		public void test04_elementScreenshotAttachment() throws InterruptedException {		
    		 HomePage elShots = new HomePage(driver);
    		 elShots.searchItem("camera");
    	}
    	
    	@Description("json attachment")
	    @Severity(SeverityLevel.NORMAL)
	    @Test
		public void test05_jsonAttached() throws InterruptedException {		
    	AllureAttachment.attachJson("{\n" +
    				"    \"glossary\": {\n" +
    				"        \"title\": \"example glossary\",\n" +
    				"\t\t\"GlossDiv\": {\n" +
    				"            \"title\": \"S\",\n" +
    				"\t\t\t\"GlossList\": {\n" +
    				"                \"GlossEntry\": {\n" +
    				"                    \"ID\": \"SGML\",\n" +
    				"\t\t\t\t\t\"SortAs\": \"SGML\",\n" +
    				"\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
    				"\t\t\t\t\t\"Acronym\": \"SGML\",\n" +
    				"\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n" +
    				"\t\t\t\t\t\"GlossDef\": {\n" +
    				"                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
    				"\t\t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
    				"                    },\n" +
    				"\t\t\t\t\t\"GlossSee\": \"markup\"\n" +
    				"                }\n" +
    				"            }\n" +
    				"        }\n" +
    				"    }\n" +
    				"}");
    		
    		
    	}
    	
    	@Description("xml attachment")
	    @Severity(SeverityLevel.NORMAL)
	    @Test
		public void test06_xmlAttached() throws InterruptedException {	
    		AllureAttachment.attachXml("<note>\n" +
    				"<to>Tove</to>\n" +
    				"<from>Jani</from>\n" +
    				"<heading>Reminder</heading>\n" +
    				"<body>Don't forget me this weekend!</body>\n" +
    				"</note>");
    		
    	}
    	
    	@Description("csv attachment")
	    @Severity(SeverityLevel.NORMAL)
	    @Test
		public void test07_csvAttached() throws InterruptedException {	
    		AllureAttachment.attachCSV("John,Doe,120 jefferson st.,Riverside, NJ, 08075\n" +
    				"Jack,McGinnis,220 hobo Av.,Phila, PA,09119\n" +
    				"\"John \"\"Da Man\"\"\",Repici,120 Jefferson St.,Riverside, NJ,08075\n" +
    				"Stephen,Tyler,\"7452 Terrace \"\"At the Plaza\"\" road\",SomeTown,SD, 91234\n" +
    				",Blankman,,SomeTown, SD, 00298\n" +
    				"\"Joan \"\"the bone\"\", Anne\",Jet,\"9th, at Terrace plc\",Desert City,CO,00123");
    	}
    	
    	@Description("url attachment")
	    @Severity(SeverityLevel.NORMAL)
	    @Test
		public void test08_urlAttachment() throws InterruptedException {		
    		AllureAttachment.attachURL("https://www.google.co.il/");
    	}
    
}
