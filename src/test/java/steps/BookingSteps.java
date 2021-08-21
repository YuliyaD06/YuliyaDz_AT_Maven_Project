package steps;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BookingPage;

public class BookingSteps {

    BookingPage bookingStep = new BookingPage();


    public void startRegistration(String mail, String password){
        bookingStep.openBookingPage();
        bookingStep.openRegistrationForm();
        bookingStep.enterMailDuringReg(mail);
        bookingStep.enterPasswordDuringReg(password);
    }
    public void loginAsRegistered(String mail, String password){
        bookingStep.openBookingPage();
        bookingStep.loginWithEmail(mail, password);
    }
    public void passCaptcha(){
        bookingStep.passCaptcha();
    }



}

//******** IF CAPTCHA
/*
driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(30))
        .pollingEvery(Duration.ofMillis(5))
        .ignoring(NoSuchElementException.class)
        .until(ExpectedConditions.invisibilityOfElementLocated(By.id("px-captcha")));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement captcha = driver.findElement(By.id("px-captcha"));
        actions
        .moveToElement(captcha)
        .clickAndHold(captcha)
        .build()
        .perform();
        try{}
        actions.release(captcha).build().perform();
 */
