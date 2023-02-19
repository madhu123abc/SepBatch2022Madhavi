package helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

public class Utility {
	
	
	/*
	 * method will accept url,browser and return WebDriver driver*/
	 
	public static WebDriver startBrowser(String browserName,String applicationURL)
	
	{
		WebDriver driver =null;
		
		if(browserName.contains("Chrome")||browserName.contains("GC")||browserName.contains("Google Chrome"))
		{   
			driver=new ChromeDriver();
			
		}
		else if(browserName.contains("Firefox")) {
			driver =new FirefoxDriver();
		}
		else if(browserName.contains("Safari")) {
			driver =new SafariDriver();
		}
		else if(browserName.contains("Edge")) {
			driver =new EdgeDriver();
		}
		
		else {
			Reporter.log("Sorry "+browserName+ " not supported Running test in default browser");
			driver =new ChromeDriver();
		}
		
	     
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
		driver.get(applicationURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
	

	public  static Alert waitForAlert(WebDriver driver) {
		Alert alert =null;
		for(int i=0;i<=15;i++) 
		{	
			try 
			{
				alert  =driver.switchTo().alert();
				break;
			}
			catch(NoAlertPresentException e)
			{
				System.out.println("NoAlertFound -wait for alert");
				waitForSeconds(1);
	
				
			}
		  
		}
		return alert;
		
	}
	public  static Alert waitForAlert(WebDriver driver,int time) {
		Alert alert =null;
		for(int i=0;i<=time;i++) 
		{	
			try 
			{
				alert  =driver.switchTo().alert();
				break;
			}
			catch(NoAlertPresentException e)
			{
				System.out.println("NoAlertFound -wait for alert");
				waitForSeconds(1);
	
				
			}
		  
		}
		return alert;
	}
		public static void waitForSeconds(int seconds) 
		{	
			try {
				Thread.sleep(seconds*1000);
			}
			catch (InterruptedException e) {
				
			 
			}
		}
		public static String captureScreenshotInBase64(WebDriver driver)
		{    
			TakesScreenshot ts=(TakesScreenshot)driver;
			String base64=ts.getScreenshotAs(OutputType.BASE64);
			return base64;}
		//}
		
		public void captureScreenshot(WebDriver driver) {
			try {
				FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),new File("./MyScreenshot1.png"));
				//FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),new File("./Screenshot "  +getCurrentTime()+".png"));
			} catch (IOException e) {
				System.out.println("Something went wrong " + e.getMessage());

			}
			
			
			
		
		
}
		public  static String getCurrentTime() {
	        String date1 =new SimpleDateFormat("HH:mm:ss_dd_MM_yyyy ").format(new Date()); 

			return date1;
		}	
			

}
