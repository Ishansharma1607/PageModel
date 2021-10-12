package com.google;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertEquals;
public class RefiffMail {
	
	WebDriver driver = null;
	
	public void readprperty() throws IOException {

		FileInputStream fis = new FileInputStream("Resources\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);

		String browser1 = prop.getProperty("browser");
		fis.close();
		
		String URL = prop.getProperty("URL2");
		
		setup(browser1,URL);			
	
		
		
	}
	
	public void setup(String browser1,String URL) throws MalformedURLException, IOException
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
	//	linkchk();
		rediffMailLinkTest();
		
	}
	
	
	
	
	 public void linkchk() throws MalformedURLException, IOException
	    {
	        String url = null;
	        HttpURLConnection huc = null;

	        List<WebElement> links = driver.findElements(By.tagName("a"));
	        Iterator ite = links.iterator();

	        while (ite.hasNext())
	        {
	            url =((WebElement) ite.next()).getAttribute("href");
	            System.out.print(url + " -- ");

	            if (url == null ||  url.isEmpty())
	            {
	                System.out.println("Empty URL");
	                continue;
	            }
	            if (url.equals("https://www.rediff.com/"))
	            {
	                System.out.println("Home page link");
	                continue;
	            }   
	            huc = (HttpURLConnection) new URL(url).openConnection();
	            huc.setRequestMethod("HEAD");
	            huc.connect();

	            int rscd = huc.getResponseCode();
	            if (rscd == 200)
	                System.out.println("ALL OK");
	            else if (rscd == 404)
	                System.out.println("Broken link");           
	        }
	        driver.close();
	    }	
	public void rediffMailLinkTest() {
		
		driver.findElement(By.linkText("Rediffmail")).click();
		String NavigatedURL = driver.getCurrentUrl();
		
		assertEquals("Fail","https://mail.rediff.com/cgi-bin/login.cgi",NavigatedURL );
//		
//		if(NavigatedURL.equals("https://mail.rediff.com/cgi-bin/login.cgi"))
//				{
//			System.out.println("Pass");
//		}
//		else {
//			System.out.println("Fail");
//		}
//		
//		
//		signUp();
		
	//	Login();
	//	orderOfCursor();
		
		teardown();
		
	}
	
	public void Login() {
		
		driver.findElement(By.id("remember")).click();
		System.out.println("Unchecked Keep Me Signed In");
		
		
		
	}
	
	
	public void orderOfCursor()
	{
	if (driver.findElement(By.id("login1")).getAttribute("tabindex").equals("1"))
	System.out.println("Login 1st focus");
	
	if (driver.findElement(By.id("password")).getAttribute("tabindex").equals("2"))
			System.out.println("Login 2st focus");
	
	
	}
	
	
	public void signUp() {
	
		driver.findElement(By.linkText("Create a new account")).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]/input[2]")).click();
		
	}
	
	
	public void teardown() {
		driver.close();
		
	}
	

	public static void main(String[] args) throws IOException {
		
		RefiffMail gsp = new RefiffMail();
		gsp.readprperty();
		
		
	}

}
