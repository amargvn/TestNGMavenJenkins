package mavenTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
	public static String currentpath() throws Exception
	{
		String current = new java.io.File( "." ).getCanonicalPath();
	    System.out.println("Current dir:"+current);
	    return current+ "\\lib\\";
	}

	public static WebDriver driver;
	
	public static WebDriver getBrowser(String browserType) throws Exception {
		String driverPath = currentpath();
		System.out.println("The current path is :" +driverPath);
		switch (browserType) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
			return driver = new FirefoxDriver();
		case "chrome":
			System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
			return	driver = new ChromeDriver();
		case "IE":
			System.setProperty("webdriver.ie.driver", driverPath+"IEDriverServer.exe");
			return	driver = new InternetExplorerDriver();
		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			
		}
		return driver;
	}
}