package utilityLayer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
		
		static SimpleDateFormat simple=new SimpleDateFormat();
		
		public static String getYear()
		{
			simple=new SimpleDateFormat("yyyy");
			
			return simple.format(new Date());
		}
		public static String getMonthYear()
		{
			simple=new SimpleDateFormat("MMM-yyyy");
			
			return simple.format(new Date());
		}
		public static String getDateMonthYear()
		{
			simple=new SimpleDateFormat("dd-MMM-yyyy");
			
			return simple.format(new Date());
		}
		public static String getDateMonthYearTime()
		{
			simple=new SimpleDateFormat("dd-MMM-yyyy_HH-mm-ss");
			
			return simple.format(new Date());
		}

}
