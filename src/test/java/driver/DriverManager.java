package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    public static WebDriver getDriver(Config config) {
        return switch (config) {
            case CHROME -> new ChromeDriver();
            case FIREFOX, EDGE, SAFARI -> null;
        };
    }
}
