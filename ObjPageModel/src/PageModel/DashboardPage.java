package PageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	
	
		WebDriver driver;
		
		public DashboardPage(WebDriver driver) {
		this.driver = driver;
		}
		
		By e_welcome=By.id("welcome");
		By e_logout=By.linkText("Logout");

		public void doLogout() throws Exception {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(e_welcome).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(e_logout).click();

		}

		}


