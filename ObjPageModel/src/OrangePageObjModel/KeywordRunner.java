package OrangePageObjModel;

import org.testng.annotations.Test;
import java.io.IOException;

public class KeywordRunner extends BeforeAndAfterMethod {
	
  @Test
  public void run() throws IOException {
	  
	  Keywords keyword = new Keywords(driver);
	  keyword.getUrl("https://www.google.com/");
	  keyword.type("name", "q", "selenium");
	  keyword.click("name", "btnK");
	  keyword.takeSnap("google");
  }
}

