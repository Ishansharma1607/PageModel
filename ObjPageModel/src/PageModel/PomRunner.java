package PageModel;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class PomRunner  {

	
	
	WebDriver driver;
	LoginPage lp;

	@Test(priority = 1)
	public void forgetLinkTest() {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		lp = new LoginPage(driver);
		lp.clickForget();
		Assert.assertTrue(driver.getCurrentUrl().contains("requestPasswordResetCode"));
		// driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

	@Test(dependsOnMethods = "cancelButtonTest")
	public void doLoginTest() throws Exception {
		Assert.assertTrue(driver.getCurrentUrl().contains("index.php/auth/login"));
		lp = new LoginPage(driver);
		lp.doLogin("Admin", "admin123");
		Assert.assertTrue(driver.getCurrentUrl().contains("index.php/dashboard"));
		System.out.println("Login Successfull");
		DashboardPage dp = new DashboardPage(driver);
		dp.doLogout();
		Assert.assertTrue(driver.getCurrentUrl().contains("index.php/auth/login"));

	}

	@Test(dependsOnMethods = "forgetLinkTest")
	public void cancelButtonTest() {
		ForgetPage fp = new ForgetPage(driver);
		fp.clickCancel();
		Assert.assertTrue(driver.getCurrentUrl().contains("index.php/auth/login"));
	}

	@BeforeTest
	public void beforeMethod() {

		//System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterMethod() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}