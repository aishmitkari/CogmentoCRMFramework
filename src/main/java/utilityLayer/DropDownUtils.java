package utilityLayer;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtils {
	public static Select getSelect(WebElement dropdownElement) {
		return new Select(WaitUtils.visibilityOf(dropdownElement));
	}

	public static void selectByVisibleText(WebElement dropdownElement, String expectedValue) {
		DropDownUtils.getSelect(dropdownElement).selectByVisibleText(expectedValue);
	}

	public static void selectByValue(WebElement dropdownElement, String expectedValue) {
		DropDownUtils.getSelect(dropdownElement).selectByValue(expectedValue);
	}

	public static void selectByIndex(WebElement dropdownElement, int expectedValue) {
		DropDownUtils.getSelect(dropdownElement).selectByIndex(expectedValue);
	}

	public static void selecDropdown(List<WebElement> listValues, String expectedValue) {
         for(WebElement abc:listValues) {
        	 String actualValue=ElementUtils.getText(abc);
        	 if(actualValue.equals(expectedValue)) {
        		 ElementUtils.click(abc);
        		 break;
        	 }
         }
	}

}

