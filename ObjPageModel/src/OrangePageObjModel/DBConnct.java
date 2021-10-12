package OrangePageObjModel;

import org.testng.annotations.Test;

import PageModel.DashboardPage;
import PageModel.LoginPage;

import org.testng.annotations.BeforeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DBConnct extends BeforeAndAfterMethod {
	//WebDriver driver;

	@Test
	public void dbconect() throws Exception {

		Connection con = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "LTI", "1234567");

		String str1 = "Select * from TSL";
		Statement st1 = con.createStatement();
		ResultSet rs = st1.executeQuery(str1);

		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

		while (rs.next()) {
			String un = rs.getString("un");
			String pwd = rs.getString("pwd") ;
			System.out.println(un + "   " + pwd);

			new LoginPage(driver).doLogin(un, pwd);
		
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (driver.getCurrentUrl().contains("dashboard")) {
				new DashboardPage(driver).doLogout();
				System.out.println("Login Done");

			} else {
				System.out.println("Login failed");

			}

		}
	}



}
