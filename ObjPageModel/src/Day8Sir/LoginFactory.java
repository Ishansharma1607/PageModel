package Day8Sir;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginFactory {
	
	
	@FindBy(name ="txtUsername") WebElement e_un;
	@FindBy(name ="txtPassword") WebElement e_pwd;
	@FindBy(name ="Submit") WebElement e_login;
	@FindBy(linkText ="Forgot your password?") WebElement e_forget;
	
	
	public void setUserName(String user) {
		e_un.sendKeys(user);

		}

		public void setPassWord(String pwd) {
		e_pwd.sendKeys(pwd);

		}

		public void clickLogin() {
		(e_login).click();
		

		} 
		public void clickForget() {
			(e_forget).click();
			
			
		}
		
		public void doLogin(String user, String pwd) {
			setUserName(user);
			setPassWord(pwd);
			clickLogin();

			}

}
