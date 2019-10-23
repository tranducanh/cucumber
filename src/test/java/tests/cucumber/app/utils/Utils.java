package tests.cucumber.app.utils;

import com.mifmif.common.regex.Generex;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Properties;

import static tests.cucumber.android.steps.Constants.EURO;

public class Utils {
    public static BigDecimal ConvertToBigDecimal(String value) {
        DecimalFormat df = new DecimalFormat("0.00");
        String str = StringUtils.strip(value, EURO);
        str = str.replace(str.charAt(str.length() - 1) + StringUtils.EMPTY, StringUtils.EMPTY);
        DecimalFormat format = (DecimalFormat) NumberFormat.getInstance(Locale.GERMAN);
        format.setParseBigDecimal(true);
        BigDecimal number = BigDecimal.ZERO;
        try {
            if (StringUtils.isNotEmpty(str))
                number = (BigDecimal) format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return number;
    }

    public static String GenerateStringByRegex(String regex) {
        Generex generator = new Generex(regex);
        String result = generator.random();
        return result;

    }

    public static String readProperty(String property) {
        Properties prop;
        String value = null;
        try {
            prop = new Properties();
            prop.load(new FileInputStream(new File("config.properties")));

            value = prop.getProperty(property);

            if (value == null || value.isEmpty()) {
                throw new Exception("Value not set or empty");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }
}
