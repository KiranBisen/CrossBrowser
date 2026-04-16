package crossbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class crossBrowserBase {
	protected WebDriver drv;
	
	@Parameters("browsers")
	@BeforeClass
	public void browserSetup(String browser_name) {
		if(browser_name.equalsIgnoreCase("chrome")) {
			drv = new ChromeDriver();
		}
		else if(browser_name.equalsIgnoreCase("firefox")) {
			drv = new FirefoxDriver();
		}
		else if(browser_name.equalsIgnoreCase("edge")) {
			drv = new EdgeDriver();
		}
		else {
			throw new IllegalArgumentException("Invalid browser object:" + browser_name);
		}
	}
	
	@AfterClass
	public void tearDown() {
		if(drv != null) {
			drv.quit();
		}
	}
}
