package pageLayer;
	
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import utilityLayer.ElementUtils;

	public class LoginPage extends BasePage {
		@FindBy(name="email")
		private WebElement userName;
		@FindBy(name="password")
		private WebElement password;
		@FindBy(xpath="//div[text()='Login']")
		private WebElement loginButton;
		
		public LoginPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		public void loginFunctionality(String username,String password)
		{
			ElementUtils.sendKeys(userName, username);
			ElementUtils.sendKeys(this.password, password);
			ElementUtils.click(loginButton);
			
		}

}
