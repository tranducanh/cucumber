package tests.cucumber.android.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String convertDateToStringByFormat(Date date, String formatPattern){
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(formatPattern);
        String strDate = DATE_FORMAT.format(date);
        return strDate;
    }
}
