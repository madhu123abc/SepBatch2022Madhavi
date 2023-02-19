package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import browserFactory.BrowserFactory;
import dataprovider.ConfigReader;


public class BaseClass 
{
	public WebDriver driver;
	@BeforeMethod
public void setBrowser()
{     System.out.println("LOG:INFO -Application is up and Running");
	  System.out.println("LOG:INFO -Setting up Browser");
	 driver = BrowserFactory.startBrowser(ConfigReader.getProperty("browser"),ConfigReader.getProperty("url"));
	 System.out.println("LOG INFO -Closing the browser and application");
}
 @AfterMethod
 public void closeBrowser()
 {
	 driver.quit();
	 System.out.println("LOG:INFO -Closing the browser and application");
 }
}
