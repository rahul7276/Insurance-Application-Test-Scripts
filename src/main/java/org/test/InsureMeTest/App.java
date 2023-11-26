package org.test.InsureMeTest;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException
    {
    	System.out.println("Script Started");	
    	System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    	WebDriverManager.chromedriver().setup();
    	ChromeOptions chromeOptions = new ChromeOptions();
  	  	chromeOptions.addArguments("--headless");
  	  	System.out.println("Driver opening up the url in browser");	
  	  	WebDriver driver = new ChromeDriver(chromeOptions);
  	  	driver.get("http://65.0.32.245:8081/contact.html");	
  	  	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
  	  	System.out.println("Enter details in the form");
  	  	driver.findElement(By.id("inputName")).sendKeys("Rahul");
  	  	driver.findElement(By.id("inputNumber")).sendKeys("000000000");
  	  	driver.findElement(By.id("inputMail")).sendKeys("rahul@abc.com");
  	  	driver.findElement(By.id("inputMessage")).sendKeys("Hi, I am intrested for insurance");
  	  	Thread.sleep(5000);
  	  	driver.findElement(By.id("my-button")).click();
  	  	String response = driver.findElement(By.id("response")).getText();
  	  	System.out.println(response);
  	  	Thread.sleep(1000);
  	  	System.out.println("Test scripts are executed");
  	  	TakesScreenshot scrShot = ((TakesScreenshot)driver);
  	  	File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
  	  	File destFile = new File("/var/lib/jenkins/workspace/Screenshot.jpg");
  	  	FileUtils.copyFile(srcFile, destFile);
  	  	driver.quit();
    }
}
