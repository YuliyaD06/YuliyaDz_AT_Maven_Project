package webdriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectClassTest {
    WebDriver driver;

    @Before
    public void makePreconditions(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/select-menu");
    }

    @Test
    public void oldStyleSelectTest(){
        Select oldStyleSelect = new Select(driver.findElement(By.xpath("//select[@id='oldSelectMenu']")));
        oldStyleSelect.selectByValue("3");
        String actualColor = driver.findElement(By.xpath("//select[@id='oldSelectMenu']/option[@value='3']")).getText();
        Assert.assertEquals("Yellow", actualColor);
    }
    @Test
    public void multiSelectTest(){
        Select multiSelect = new Select(driver.findElement(By.xpath("//select[@id='cars']")));
        multiSelect.selectByValue("audi");
        String actualCar = driver.findElement(By.xpath("//select[@id='cars']/option[contains(.,'Audi')]"))
                .getAttribute("value");
        Assert.assertEquals("audi", actualCar);
    }

    @Test
    public void selectOneTest(){
        WebElement firstSelect = driver.findElement(By.xpath("//div[@class=' css-1hwfws3']/div[contains(.,'Select Option')]"));
        firstSelect.click();
        Actions makeFirstAction = new Actions(driver);
        makeFirstAction
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .build()
                .perform();
        System.out.println(firstSelect.getText());
        Assert.assertEquals("Group 2, option 2", firstSelect.getText());
    }

    @Test
    public void selectSecondTest(){
        WebElement secondSelect = driver.findElement(By.xpath("//div[@class=' css-1hwfws3']/div[contains(.,'Select Option')]"));
        secondSelect.click();
        System.out.println(secondSelect.getText());
        Assert.assertEquals("Group 2, option 2", secondSelect.getText());
    }

    @After
    public void makePostconditions(){
        driver.close();
        driver.quit();
    }
}
