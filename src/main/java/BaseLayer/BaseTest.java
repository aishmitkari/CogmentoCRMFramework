package BaseLayer;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utilityLayer.ConfigReaderUtils;
import utilityLayer.DriverFactory;
import utilityLayer.DriverManager;

public class BaseTest {

	@Parameters({ "browsername" })
	@BeforeTest
	public void setup(String browsername) throws IOException 
	{
		DriverFactory.initBrowser(browsername);
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().get(ConfigReaderUtils.readProperty("URL"));
	}

	@AfterTest
	public void tearDown() 
	{
		DriverManager.getDriver().quit();
	}

}
