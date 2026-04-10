package utilityLayer;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	private static WebDriverWait getWebDriverwaitInstance() {
		return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));
	}

	public static WebElement visibilityOf(WebElement wb) {
		return WaitUtils.getWebDriverwaitInstance().until(ExpectedConditions.visibilityOf(wb));
	}

	public static WebElement elementToBeClickable(WebElement wb) {
		return WaitUtils.getWebDriverwaitInstance().until(ExpectedConditions.elementToBeClickable(wb));
	}

	public static Alert alertIsPresent() {
		return WaitUtils.getWebDriverwaitInstance().until(ExpectedConditions.alertIsPresent());
	}

	public static WebDriver frameToBeAvailableAndSwitchToIt(String idOrName) {
		return WaitUtils.getWebDriverwaitInstance().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idOrName));
	}

	public static WebDriver frameToBeAvailableAndSwitchToIt(int index) {
		return WaitUtils.getWebDriverwaitInstance().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}

	public static WebDriver frameToBeAvailableAndSwitchToIt(WebElement wb) {
		return WaitUtils.getWebDriverwaitInstance().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(wb));
	}
	

}
