package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.BookingPage;
import steps.BookingSteps;

public class BookingHeaderTest {

    BookingSteps step = new BookingSteps();
    BookingPage page = new BookingPage();

    @Test
    public void checkHeadersTest(){
        step.loginAsRegistered("yuliyatest66@gmail.com", "123654ghjJ");
        Assert.assertTrue(page.allHeadersPresented());
    }
}
