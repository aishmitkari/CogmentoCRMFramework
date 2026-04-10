package utilityLayer;

import org.openqa.selenium.WebElement;

public class FrameUtils {

	public static void frame(String idOrName) {
		WaitUtils.frameToBeAvailableAndSwitchToIt(idOrName);

	}

	public static void frame(int index) {

		WaitUtils.frameToBeAvailableAndSwitchToIt(index);
	}

	public static void frame(WebElement wb) {

		WaitUtils.frameToBeAvailableAndSwitchToIt(wb);
	}

	public static void parentFrame() {
		DriverManager.getDriver().switchTo().parentFrame();
	}

	public static void defaultContent() {

		DriverManager.getDriver().switchTo().defaultContent();
	}
}
