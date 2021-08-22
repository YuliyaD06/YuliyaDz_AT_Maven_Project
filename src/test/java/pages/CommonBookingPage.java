package pages;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommonBookingPage {

    WebDriver driver = Driver.getWebDriver();

    public void openBookingPage(){
        driver.get("https://www.booking.com");
    }
    public void passCaptcha(){
        List<WebElement> iframeElements = driver.findElements(By.xpath("//iframe"));
        //make waiter
        System.out.println(iframeElements.size());

        //driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='px-captcha']/iframe[8]")));
        /*WebElement captcha = driver.findElement(By.id("jmtizSJxDoYzibW"));

        Actions action = new Actions(driver);
        action.clickAndHold(captcha).build().perform();
        try{
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        action.release(captcha).build().perform();*/
    }

}
