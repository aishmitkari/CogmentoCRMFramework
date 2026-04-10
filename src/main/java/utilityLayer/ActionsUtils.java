package utilityLayer;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

	public class ActionsUtils {

		public static Actions getActionsInstance() {
			return new Actions(DriverManager.getDriver());
		}

		public static void clickAction(WebElement wb) {
			WaitUtils.elementToBeClickable(wb);
			ActionsUtils.getActionsInstance().click(wb).perform();
		}

		public static void doubleClickAction(WebElement wb) {
			WaitUtils.elementToBeClickable(wb);
			ActionsUtils.getActionsInstance().doubleClick(wb).perform();
		}

		public static void rightClickAction(WebElement wb) {
			WaitUtils.elementToBeClickable(wb);
			ActionsUtils.getActionsInstance().contextClick(wb).perform();
		}

		public static void dragAndDropAction(WebElement source, WebElement target) {
			WaitUtils.visibilityOf(source);
			WaitUtils.visibilityOf(target);
			ActionsUtils.getActionsInstance().dragAndDrop(source, target).perform();
		}

		public static void scrollToElementAction(WebElement wb) {
			WaitUtils.visibilityOf(wb);
			ActionsUtils.getActionsInstance().scrollToElement(wb).perform();
		}

		public static void moveToElementAction(WebElement wb) {
			WaitUtils.visibilityOf(wb);
			ActionsUtils.getActionsInstance().moveToElement(wb).perform();
		}

}
