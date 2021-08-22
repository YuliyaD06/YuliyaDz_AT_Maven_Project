package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.CommonBookingPage;
import pages.LoginPage;
import pages.NavigationBarView;
import steps.BookingSteps;

public class BookingHeaderTest {

    NavigationBarView navigationBar = new NavigationBarView();
    CommonBookingPage page = new CommonBookingPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void checkHeadersTest() {
        page.openBookingPage();
        loginPage.loginWithEmail("yuliyatest66@gmail.com", "123654ghjJ");
        Assert.assertTrue(navigationBar.allHeadersPresent());
    }
}
