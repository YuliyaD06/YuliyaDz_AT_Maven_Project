package tests;

import org.junit.Test;
import pages.CommonBookingPage;
import pages.GmailPage;
import pages.RegistrationPage;
import steps.BookingSteps;

public class BookingRegistrationTest extends Preconditions {

    BookingSteps step = new BookingSteps();
    CommonBookingPage mainPage = new CommonBookingPage();
    RegistrationPage registrationPage = new RegistrationPage();
    GmailPage gmailPage = new GmailPage();

    @Test
    public void registrationTest(){
        mainPage.openBookingPage();
        registrationPage.openRegistrationForm();
        registrationPage.enterMailDuringRegistration("brakus.amber@trashmail.fr");
        registrationPage.enterPasswordDuringRegistration("SBb6tPijl7");
        //step.passCaptcha();
        mainPage.closeWelcomeCard();
        gmailPage.confirmRegistration("SBb6tPijl7", "yuliyatest66@gmail.com");
    }

}
