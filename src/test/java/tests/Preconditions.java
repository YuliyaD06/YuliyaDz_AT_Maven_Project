package tests;

import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Preconditions {

    WebDriver driver;

    @Before
    public void makePreconditions(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        System.out.println("PRECONDITIONS");
    }
}
