package utilityLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	
	public static void initBrowser(String browsername) {
		WebDriver driver = null;
		ChromeOptions opt = null;

		switch (browsername.toLowerCase()) {
		case "chrome":
			opt = new ChromeOptions();
			opt.setAcceptInsecureCerts(true);
			opt.addArguments("--disable-notifications");
			driver = new ChromeDriver(opt);
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		case "headless":
			opt = new ChromeOptions();
			opt.setAcceptInsecureCerts(true);
			opt.addArguments("--headless", "--disable-notifications");
			driver = new ChromeDriver(opt);
			break;
		case "incognito":
			opt = new ChromeOptions();
			opt.setAcceptInsecureCerts(true);
			opt.addArguments("--incognito", "--disable-notifications");
			driver = new ChromeDriver(opt);
			break;
		default:
			System.err.println("Please enter valid browser name ");

		}
		DriverManager.setDriver(driver);

	}

}

