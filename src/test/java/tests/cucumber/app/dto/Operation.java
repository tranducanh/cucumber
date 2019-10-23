package tests.cucumber.app.dto;

import org.apache.commons.lang3.StringUtils;
import tests.cucumber.app.utils.Utils;

public class Operation {
    public String name;
    public Operation(String regex){
        if (StringUtils.isNotEmpty(regex))
          name = Utils.GenerateStringByRegex(regex);
    }
}
