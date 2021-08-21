package tests;

import org.junit.Test;
import steps.BookingSteps;

public class BookingRegistrationTest extends Preconditions {

    BookingSteps step = new BookingSteps();

    @Test
    public void registrationTest(){
        step.startRegistration("wuckert.ima@trashmail.fr", "SBb6tPijl7");
        step.passCaptcha();
        //step.openMailbox();
    }

}
