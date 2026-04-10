package pageLayer;
	
	import org.openqa.selenium.WebDriver;

	import utilityLayer.DriverManager;

	public class BasePage {
		protected WebDriver driver;
		public BasePage()
		{
			driver=DriverManager.getDriver();
		}

	}
	

