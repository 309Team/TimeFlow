package TimeFlow.util;


public class TableNameUtil {
	public static String getLEName(Integer uid) {
		return uid.toString() + "_label_event";
	}

	public static String getMEName(Integer uid) {
		return uid.toString() + "_moment_event";
	}

	public static String getTEName(Integer uid) {
		return uid.toString() + "_time_event";
	}

	public static String getTECLName(Integer uid) {
		return uid.toString() + "_te_classification";
	}

    public static String getMidTabName(Integer uid) {
        return uid.toString() + "_te_class_category";
    }


}
