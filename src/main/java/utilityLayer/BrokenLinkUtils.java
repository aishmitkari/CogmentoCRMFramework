package utilityLayer;


	import java.net.HttpURLConnection;
	import java.net.URL;
	import java.net.URLConnection;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;

	public class BrokenLinkUtils {
		@SuppressWarnings("deprecation")
		public static void getAllBrokenLinks()
		{
			List<WebElement> links = DriverManager.getDriver().findElements(By.tagName("a"));

			int toatlLinks = links.size();
			int validLinks = 0;
			int invalidLinks = 0;

			for (WebElement link : links) {

				String linkAddress = link.getAttribute("href");

				if (linkAddress.isEmpty() || linkAddress == null) {

					invalidLinks++;
					System.err.println("Invalid Link : " + linkAddress);

				} else if (linkAddress.startsWith("http")) {

					try {

						URL url = new URL(linkAddress);

						URLConnection urlCon = url.openConnection();

						HttpURLConnection httpCon = (HttpURLConnection) urlCon;

						//httpCon.setRequestMethod("HEAD");

						httpCon.connect();

						int statusCode = httpCon.getResponseCode();

						if (statusCode >= 400) {

							invalidLinks++;
							System.err.println("Invalid Link : " + linkAddress);

						} else {

							validLinks++;
							System.out.println("Valid Link : " + linkAddress);

						}

					} catch (Exception e) {

						e.printStackTrace();
						invalidLinks++;
						System.err.println("Invalid Link : " + linkAddress);

					}
				} else {

					invalidLinks++;
					System.err.println("Invalid Link : " + linkAddress);

				}
			}

			System.out.println("Total Links : " + toatlLinks);
			System.out.println("Valid Links : " + validLinks);
			System.out.println("Invalid Links : " + invalidLinks);
		}
		

	}


