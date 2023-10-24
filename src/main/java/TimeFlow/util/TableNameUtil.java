package TimeFlow.util;

public class TableNameUtil {
    public static String getLEName(Integer uid) {
        return uid.toString() + "LabelEvent";
    }

    public static String getMEName(Integer uid) {
        return uid.toString() + "MomentEvent";
    }

    public static String getTEName(Integer uid) {
        return uid.toString() + "TimeEvent";
    }
}
