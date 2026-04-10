package utilityLayer;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Screenshots {
	public static String takeaScreenshot(String tcname, String status) {

		String tcStatus = "fail";
		TakesScreenshot ts = (TakesScreenshot) (DriverManager.getDriver());
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		if (status.equalsIgnoreCase("pass")) {
			tcStatus = "pass";
		}
		String path = System.getProperty("user.dir") + "\\Screenshot\\" + tcStatus + "\\" + DateUtils.getYear()
				+ "\\" + DateUtils.getMonthYear() + "\\" + DateUtils.getDateMonthYear() + "\\screenshot_"
				+ tcname + "_" + DateUtils.getDateMonthYearTime() + ".png";

		File destination = new File(path);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}

	public static String takeFullPageScreenshot(String tcname, String status) {

		String tcStatus = "fail";

		if (status.equalsIgnoreCase("pass")) {
			tcStatus = "pass";
		}
		AShot ashot = new AShot();

		ashot.shootingStrategy(ShootingStrategies.viewportPasting(2000));

		Screenshot source = ashot.takeScreenshot(DriverManager.getDriver());

		String path = System.getProperty("user.dir") + "\\FullPageScreenshot\\" + tcStatus + "\\"
				+ DateUtils.getYear() + "\\" + DateUtils.getMonthYear() + "\\"
				+ DateUtils.getDateMonthYear() + "\\full_page_screenshot_" + tcname + "_"
				+ DateUtils.getDateMonthYearTime() + ".png";
		File folder = new File(path);
		if (!folder.exists()) {
			folder.mkdirs();
		}

		File destination = new File(path);

		try {
			ImageIO.write(source.getImage(), "PNG", destination);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return path;
	}
}


