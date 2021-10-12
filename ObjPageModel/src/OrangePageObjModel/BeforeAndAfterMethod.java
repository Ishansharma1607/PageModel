package OrangePageObjModel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import PageModel.LoginPage;

public class BeforeAndAfterMethod {

	WebDriver driver;
	LoginPage lp;
	
	@BeforeTest
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterMethod() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
