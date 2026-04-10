package utilityLayer;

public class AlertUtils {
	
//	WebDriver = DriverManager.getDriver();
	
	public static void accept()
	{
		WaitUtils.alertIsPresent().accept();
	}
	public static void dismiss()
	{
		WaitUtils.alertIsPresent().dismiss();
	}
	public static String getText()
	{
		return WaitUtils.alertIsPresent().getText();
	}
	public static void sendkeys(String value)
	{
		 WaitUtils.alertIsPresent().sendKeys(value);
	}
	

}
