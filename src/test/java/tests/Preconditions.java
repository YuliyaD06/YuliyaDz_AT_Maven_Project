package tests;

import driver.Config;
import driver.Driver;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class Preconditions {

    WebDriver driver = Driver.initDriver(Config.CHROME);

    @Before
    public void makePreconditions(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
