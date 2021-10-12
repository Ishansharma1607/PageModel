package com.google;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearchPage {
	
	WebDriver driver = null;
	
	public void readprperty() throws IOException {

		FileInputStream fis = new FileInputStream("Resources\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);

		String browser1 = prop.getProperty("browser");
		fis.close();
		
		String URL = prop.getProperty("URL");
		
		setup(browser1,URL);			
		
		
		
	}
	
	public void setup(String browser1,String URL)
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
	
	
	public void titletest() {
		
		System.out.println(driver.getTitle());
		teardown();
		
	}
	
	
	public void teardown() {
		driver.close();
		
	}
	

	public static void main(String[] args) throws IOException {
		
		GoogleSearchPage gsp = new GoogleSearchPage();
		gsp.readprperty();
		
		
	}

}
