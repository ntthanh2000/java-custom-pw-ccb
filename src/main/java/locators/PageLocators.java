package locators;

import java.util.HashMap;
import java.util.Map;

public class PageLocators {
    public static Map<String, String> getButtonLocators(){
        Map<String, String> locators = new HashMap<>();
        locators.put("get started", "//a[text()='Get started']");
        return locators;
    }
}
