package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver webDriver;

    public static WebDriver getWebDriver(){

        if (webDriver == null){
            webDriver = DriverManager.getDriver(Config.CHROME);
        }
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return webDriver;
    }

    public static WebDriver initDriver(Config config){
        if (webDriver == null){
            webDriver = DriverManager.getDriver(config);
        }
        return webDriver;
    }

    public static void destroy(){

        webDriver.close();
        webDriver.quit();

        webDriver = null;

    }

}
