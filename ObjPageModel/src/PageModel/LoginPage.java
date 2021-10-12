package PageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	
	
	WebDriver driver;
	
	//creating constructor so that we can call LoginPage.MethodName in PomRunner.java
	public LoginPage(WebDriver driver) {
	this.driver=driver;

	}

	By e_un = By.name("txtUsername");

	By e_pwd = By.name("txtPassword");

	By e_login = By.name("Submit");

	By e_forget = By.linkText("Forgot your password?");

	

	public void setUserName(String user) {
	driver.findElement(e_un).sendKeys(user);

	}

	public void setPassWord(String pwd) {
	driver.findElement(e_pwd).sendKeys(pwd);

	}

	public void clickLogin() {
	driver.findElement(e_login).click();
	

	} 
	public void clickForget() {
		driver.findElement(e_forget).click();
		
		
	}
	
	public void doLogin(String user, String pwd) {
		setUserName(user);
		setPassWord(pwd);
		clickLogin();

		}
	
	

}
