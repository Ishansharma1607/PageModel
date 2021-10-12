package OrangePageObjModel;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Keywords {

	WebDriver driver;

	public WebElement getElement(String locatorType, String locatorValue) {
		WebElement E = null;
		if (locatorType.equals("id"))
			E = driver.findElement(By.id(locatorValue));
		else if (locatorType.equals("name"))
			E = driver.findElement(By.name(locatorValue));
		else if (locatorType.equals("css"))
			E = driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.equals("link"))
			E = driver.findElement(By.linkText(locatorValue));
		else if (locatorType.equals("xpath"))
			E = driver.findElement(By.xpath(locatorValue));
		else
			System.out.println("Invalid Locator");

		return E;

	}

	public Keywords(WebDriver driver) {
		this.driver = driver;
	}

	public void getUrl(String url) {
		driver.get(url);

	}
	
	
	public void click(String locatorType, String locatorValue) {
	getElement(locatorType, locatorValue).click();

	}

	public void type(String locatorType, String locatorValue, String data) {
		getElement(locatorType, locatorValue).sendKeys(data);
	}

	public void takeSnap(String filename) throws IOException {

		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		File srcfile = screenshot.getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(srcfile, new File("ScreenShots\\" + filename+".png"));
	        } catch (Exception E) {
	            System.out.println("Error with taking ScreenShot");
	        }
		// external lib needed

	}
	public void selectDropDown(String locatorType, String locatorValue,String visibleText) {
		Select sc = new Select(getElement(locatorType, locatorValue));
		sc.selectByVisibleText(visibleText);
		
	}
	
	
	

}
