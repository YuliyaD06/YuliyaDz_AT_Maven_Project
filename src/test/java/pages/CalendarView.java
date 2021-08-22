package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ActionsWithCurrentDate;

public class CalendarView {

    WebDriver driver;
    ActionsWithCurrentDate currentDate = new ActionsWithCurrentDate();

    private static final String CHECK_IN_DATE = "//div[@class='xp__input-group xp__date-time']//div[@data-placeholder='Check-in']";
    private static final String CHECK_OUT_DATE = "//div[@class='xp__input-group xp__date-time']//div[@data-placeholder='Check-out']";

    public void choosePeriodOfTrip(int month){
        driver.findElement(By.xpath(CHECK_IN_DATE)).click();
        String newDate = currentDate.addMonthToCurrentDate(month);
        System.out.println(newDate);
        String checkInDatePath = "//td[@data-date='2021-08-22']";
        String checkInDate = checkInDatePath.substring(0,16) + newDate + checkInDatePath.substring(27,28);
        System.out.println(checkInDate);
        driver.findElement(By.xpath(checkInDate)).click();
        driver.findElement(By.xpath(CHECK_OUT_DATE)).click();

    }

}
