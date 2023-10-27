package TimeFlow.util;

import java.util.HashMap;

public class TableNameUtil {
	public static String getLEName(Integer uid) {
		return uid.toString() + "labelevent";
	}

	public static String getMEName(Integer uid) {
		return uid.toString() + "momentevent";
	}

	public static String  getTEName(Integer uid) {
		return uid.toString() + "timeevent";
	}

	public static String  getCLName(Integer uid) {
		return uid.toString() + "classification";
	}

}
