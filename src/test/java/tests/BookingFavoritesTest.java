package tests;

import org.junit.Test;
import pages.CalendarView;
import pages.CommonBookingPage;
import pages.DestinationView;
import pages.LoginPage;
import test.v6.C;

public class BookingFavoritesTest extends Preconditions {

    CommonBookingPage bookingPage = new CommonBookingPage();
    LoginPage loginPage = new LoginPage();
    CalendarView calendar = new CalendarView();
    DestinationView destination = new DestinationView();

    @Test
    public void checkFavoritesHotelsTest(){
        bookingPage.openBookingPage();
        loginPage.loginWithEmail("yuliyatest66@gmail.com", "123654ghjJ");
        ////<<<<To ASK>>>>////
        //bookingPage.closeWelcomeCard();
        calendar.choosePeriodOfTrip(1);
        destination.chooseDestination("Madrid");
        bookingPage.searchHotels();
    }
}
