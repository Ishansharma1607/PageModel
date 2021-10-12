//<dependency>
//    <groupId>com.aventstack</groupId>
//    <artifactId>extentreports</artifactId>
//    <version>3.1.5</version>
//</dependency>
//  </dependencies>

package Day8Sir;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import PageModel.ForgetPage;

public class FactoryRunner {
	
	WebDriver driver;
	
	
	
	@Test
	public void cancelButtonTest() {
		ExtentReports ex = new ExtentReports();
		ex.attachReporter(new ExtentSparkReporter("Orange.html"));
		//ex.attachReporter(new ExtentHtmlReporter("Orange.html")); //in case of old extent reporter jar
		ExtentTest tc = ex.createTest("CancelButtonTest");
		tc.info("Opening URL");
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		tc.info("Initialising Login Factory Class");
		//PageFactory Official Way Of Attaching Driver to page classes
		LoginFactory lf = PageFactory.initElements(driver, LoginFactory.class);
		tc.info("Clicking on Forget");
		lf.clickForget();
		tc.info("Verifying");
		try {
			Assert.assertTrue(driver.getCurrentUrl().contains("requestPasswordResetCode"));
			tc.pass("Cancel Button Checked & Its Pass");

			} catch (AssertionError E) {
			tc.fail("Cancel button Test get Failed");
			Assert.fail(E.getMessage());
			}
		finally {
			ex.flush();// To Write report in actual Memory
		}
			
		//Assert.assertTrue(driver.getCurrentUrl().contains("requestPasswordResetCode"));
	}

	
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
