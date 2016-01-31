package myCode;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class GoogleLinkFind {
	WebDriver drv;

	@Test
	public void myMethod() throws IOException{
	drv = new FirefoxDriver();
	drv.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	drv.get("http://www.google.com/");
	
	try {
		
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
		obj.load(objfile);
		
		drv.findElement(By.id(obj.getProperty("SearchField"))).sendKeys("Apple");
		drv.findElement(By.name(obj.getProperty("SearchButton"))).click();
		
		WebElement ele = drv.findElement(By.linkText("Apple (India)"));
		Boolean result = ele.isDisplayed();
		
		   if(result==true){
			   Reporter.log("Link is displayed successfully");
			   ele.click();
			   Reporter.log("Link is opened successfully");
			   
		   }
		   
		   else{
			   Reporter.log("Link is not displayed");
		   }
		   
		   
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	

}
}
