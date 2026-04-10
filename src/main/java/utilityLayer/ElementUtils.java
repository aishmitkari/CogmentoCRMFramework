package utilityLayer;

import org.openqa.selenium.WebElement;

public class ElementUtils {

//	static WebDriver driver= DriverManager.getDriver() ;

	public static void sendKeys(WebElement wb, String value) {
		WaitUtils.visibilityOf(wb).sendKeys(value);
	}

	public static void click(WebElement wb) {
		WaitUtils.elementToBeClickable(wb).click();
	}

	public static String getText(WebElement wb) {
		return WaitUtils.visibilityOf(wb).getText();
	}
	
	

}
