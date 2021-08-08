package webdriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;
//Задание:
//1. Перейти на сайт https://booking.com
//2. Навести мышь на индикатор валюты
//3. Проверить значение подсказки
//4. Навести мышь на индикатор языка
//5. Проверить значение подсказки
public class MouseHoverTest {
    WebDriver driver;

    @Before
    public void makePreconditions(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.booking.com/");
    }

    @Test
    public void checkTextOfCurrency(){
        WebElement currencyElement = driver.findElement(By.xpath("//button[@data-modal-aria-label='Select your currency']"));
        Actions currencyActions = new Actions(driver);
        currencyActions
                .moveToElement(currencyElement)
                .perform();
        Assert.assertEquals("Choose your currency", currencyElement.getAttribute("data-tooltip-text"));
    }
    @Test
    public void checkTextOfLanguage(){
        WebElement languageElement = driver.findElement(By.xpath("//button[@data-modal-aria-label='Select your language']"));
        Actions languageActions = new Actions(driver);
        languageActions
                .moveToElement(languageElement)
                .perform();
        Assert.assertEquals("Choose your language", languageElement.getAttribute("data-tooltip-text"));
    }

    @After
    public void makePostConditions(){
        driver.close();
        driver.quit();
    }
}
