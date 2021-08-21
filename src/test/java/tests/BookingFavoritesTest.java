package tests;

import org.junit.Test;
import pages.BookingPage;
import steps.BookingSteps;

public class BookingFavoritesTest {
    BookingSteps step = new BookingSteps();
    BookingPage page = new BookingPage();

    @Test
    public void checkFavoritesHotelsTest(){
        step.loginAsRegistered("yuliyatest66@gmail.com", "123654ghjJ");

    }
}
