package utilityLayer;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> td = new ThreadLocal<WebDriver>();

private DriverManager() {
	
}
public static void setDriver(WebDriver driver) {
td.set(driver);
}

public static WebDriver getDriver()
{
	return td.get();
}
}
