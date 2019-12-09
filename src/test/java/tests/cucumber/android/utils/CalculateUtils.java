package tests.cucumber.android.utils;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static tests.cucumber.android.steps.Constants.EURO;

public class CalculateUtils {
    public static BigDecimal getValueDoubleWebElement(WebElement by) {
        DecimalFormat df = new DecimalFormat("0.00");
        String str = StringUtils.strip(by.getText(), EURO);
        str = str.replace(str.charAt(str.length() - 1) + StringUtils.EMPTY, StringUtils.EMPTY);
        DecimalFormat format = (DecimalFormat) NumberFormat.getInstance(Locale.GERMAN);
        format.setParseBigDecimal(true);
        BigDecimal number = null;
        try {
            number = (BigDecimal) format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return number;
    }

    public static BigDecimal getValueDoubleFromString(String by) {
        DecimalFormat df = new DecimalFormat("0.00");
        String str = StringUtils.strip(by, EURO);
        DecimalFormat format = (DecimalFormat) NumberFormat.getInstance(Locale.GERMAN);
        format.setParseBigDecimal(true);
        BigDecimal number = null;
        try {
            number = (BigDecimal) format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return number;
    }

    public static Calendar getDate(String dateData) {
        Calendar calendar = new GregorianCalendar(Integer.parseInt(dateData.substring(6, 10)), Integer.parseInt(dateData.substring(3, 5)), Integer.parseInt(dateData.substring(0, 2)));
        return calendar;
    }
}
