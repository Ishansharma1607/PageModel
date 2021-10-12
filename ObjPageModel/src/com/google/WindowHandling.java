package com.google;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandling {
	
	WebDriver driver = null;
	
	public void readprperty() throws Exception {

		FileInputStream fis = new FileInputStream("Resources\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);

		String browser1 = prop.getProperty("browser");
		fis.close();
		
		String URL = prop.getProperty("URL1");
		
		setup(browser1,URL);			
		
		
		
	}
	
	public void setup(String browser1,String URL) throws Exception
	{
		
		switch (browser1) {
		case "firefox":

			System.setProperty("webdriver.gecko.driver", "Resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		}	
		
	
		driver.get(URL);
		titletest();
	}
	
	
	public void titletest() throws Exception {
		
			driver.findElement(By.cssSelector(".\\_2doB4z")).click();
		    driver.findElement(By.name("q")).click();
		    driver.findElement(By.name("q")).sendKeys("iphone");
		    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);	
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div[3]/div/div/div/a/div[2]/div[1]/div[1]")).click();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.findElement(By.xpath(" /html/body/div[1]/div/div[3]/div[1]/div[2]/div[4]/div/div/div/a/div[2]/div[1]/div[1]")).click();
		   
		   // WebDriverWait wait = new WebDriverWait(driver,30);
//		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".\\_1AtVbE:nth-child(2) .\\_4rR01T")));
//		    driver.findElement(By.cssSelector(".\\_1AtVbE:nth-child(2) .\\_4rR01T")).click();
//		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("///li[3]//div[1]//a[1]")));
//		    driver.findElement(By.xpath("//li[3]//div[1]//a[1]")).click();
		   // driver.findElement(By.xpath("//*[@id=\'container\']/div/div[1]/div[1]/div[2]/div[2]/form/div/button")).click();

		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 //   driver.findElement(By.xpath("//*[@id=\'container\']/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")).click();
		   
		    String parentwindow = driver.getWindowHandle();
		    System.out.println(parentwindow);

		    Set<String> allwindows = driver.getWindowHandles();
		    Iterator<String> ite = allwindows.iterator();
		    
		    while(ite.hasNext())

		    {
		    String childwindow = ite.next();
		    driver.switchTo().window(childwindow);
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		  
		   // driver.switchTo().window(parentwindow);
		    
		    }
		    
		    driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[2]/form/button")).click();
		//  teardown();
		
	}
	
	
	
	
	
	
	public void teardown() {
		//driver.close();
		driver.quit();
		
	}
	

	public static void main(String[] args) throws Exception {
		
		WindowHandling gsp = new WindowHandling();
		gsp.readprperty();
		
		
	}

}
