package utilityLayer;

import java.util.List;

import org.openqa.selenium.WebElement;

public class CalenderUtils {
	public static void selectMonthYear(WebElement monthYear, WebElement next, String expectedMonthYear) {

		while (true) {
			String displayedMonthYear = ElementUtils.getText(monthYear);

			if (displayedMonthYear.equals(expectedMonthYear)) {
				break;
			} else {
				ElementUtils.click(next);

			}
		}
	}

	public static void selectDate(List<WebElement> listDates, String expectedDate) {
		for (WebElement abc : listDates) {
			String actualDate = ElementUtils.getText(abc);

			if (actualDate.equals(expectedDate)) {
				ElementUtils.click(abc);

				break;
			}
		}

	}

}

