package utilityLayer;

	import org.testng.IRetryAnalyzer;
	import org.testng.ITestResult;

	public class RetryAnalyzer implements IRetryAnalyzer {

		
		int counter = 0;
		
		int maxcounter = 4;

		@Override
		public boolean retry(ITestResult result) {
			
			if(counter < maxcounter){
				
				counter ++;
				return true;
			}
			return false;
		}
		
		
	
}
