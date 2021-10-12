package PageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgetPage {
	

	WebDriver driver;
	
	//creating constructor so that we can call LoginPage.MethodName in PomRunner.java
	ForgetPage(WebDriver driver) {
	this.driver=driver;

	}

	By e_un = By.id("securityAuthentication_userName");
	By e_reset = By.id("btnSearchValues");
	By e_cancel = By.id("btnCancel");

	

	

	public void doReset(String user) {
	driver.findElement(e_un).sendKeys(user);
	driver.findElement(e_reset).click();

	}

	

	public void clickCancel() {
	
	driver.findElement(e_cancel).click();

	}
	
	
	

}
