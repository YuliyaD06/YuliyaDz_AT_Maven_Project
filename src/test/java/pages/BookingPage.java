package pages;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FindDate;

public class BookingPage {

    WebDriver driver = Driver.getWebDriver();
    //FindDate date = new FindDate();

    //------*** for REGISTRATION flow
    private static final String REGISTRATION_FORM_XPATH = "//header//div[2]/div[5]/a";
    private static final String CONTINUE_WITH_EMAIL_XPATH = "//div[@class='app']//button[1]";
    private static final String CREATE_ACCOUNT_BUTTON = "//div[@class='app']//button";
    //------*** for LOGIN flow
    private static final String HEADER_SIGN_IN_BUTTON = "//header//div[2]/div[6]/a/span";
    private static final String ENTER_MAIL_FIELD = "//div[@class='bui-input-text__field']/input";
    private static final String ENTER_PASSWORD_FIELD = "//div/input[@type='password']";
    private static final String LOGIN_FLOW_IGN_IN_BUTTON = "//form/button/span[text()='Sign in']";
    //------*** for BOOKING WELCOME FORM
    //------*** HEADERS
    private static final String BOOKING_LOGO = "//nav[@class='bui-header__bar']/div/div";
    private static final String CURRENCY = "//nav[@class='bui-header__bar']/div[2]/div[1]";
    private static final String LANGUAGE = "//nav[@class='bui-header__bar']/div[2]/div[2]";
    private static final String CUSTOMER_SERVICES = "//nav[@class='bui-header__bar']/div[2]/div[3]";
    private static final String NOTIFICATIONS = "//nav[@class='bui-header__bar']/div[2]/div[4]";
    private static final String LIST_OF_PROPERTY = "//nav[@class='bui-header__bar']/div[2]/div[5]";
    private static final String YOUR_ACCOUNT = "//nav[@class='bui-header__bar']/div[2]/div[6]";
    //------*** for new trip
    private static final String DESTINATION_SEARCH_INPUT = "//label[@class='sb-destination-label-sr']/input";
    private static final String CHECK_IN_DATE = "//div[@class='xp__input-group xp__date-time']//div[@data-placeholder='Check-in']";
    private static final String CHECK_OUT_DATE = "//div[@class='xp__input-group xp__date-time']//div[@data-placeholder='Check-out']";
    private static final String GUESTS_FORM = "//label[@id='xp__guests__toggle']";
    private static final String ADD_ADULTS_GUESTS_FORM = "//button[@aria-describedby='group_adults_desc']/span[text()='+']";
    private static final String ADD_CHILDREN_GUESTS_FORM = "//button[@aria-describedby='group_children_desc']/span[text()='+']";
    private static final String ADD_ROOMS_GUESTS_FORM = "//button[@aria-describedby='no_rooms_desc']/span[text()='+']";


    public void openBookingPage(){
        driver.get("https://www.booking.com");
    }
    public void openRegistrationForm(){
        driver.findElement(By.xpath(REGISTRATION_FORM_XPATH)).click();
    }
    public void enterMailDuringReg(String mail){
        driver.findElement(By.id("username")).sendKeys(mail);
        driver.findElement(By.xpath(CONTINUE_WITH_EMAIL_XPATH)).click();
    }
    public void enterPasswordDuringReg(String password){
        driver.findElement(By.id("new_password")).sendKeys(password);
        driver.findElement(By.id("confirmed_password")).sendKeys(password);
        driver.findElement(By.xpath(CREATE_ACCOUNT_BUTTON)).click();
    }
    public void loginWithEmail(String mail, String password){
        driver.findElement(By.xpath(HEADER_SIGN_IN_BUTTON)).click();
        driver.findElement(By.xpath(ENTER_MAIL_FIELD)).sendKeys(mail);
        driver.findElement(By.xpath(CONTINUE_WITH_EMAIL_XPATH)).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ENTER_PASSWORD_FIELD)));

        driver.findElement(By.xpath(ENTER_PASSWORD_FIELD)).sendKeys(password);
        driver.findElement(By.xpath(LOGIN_FLOW_IGN_IN_BUTTON)).click();
    }

    public void chooseDestination(String city){
        driver.findElement(By.xpath(DESTINATION_SEARCH_INPUT)).sendKeys(city);
    }
    public void choosePeriodOfTrip(){
        driver.findElement(By.xpath(CHECK_IN_DATE)).click();

        driver.findElement(By.xpath(CHECK_OUT_DATE)).click();

    }

    public boolean allHeadersPresented() {
        boolean headers = false;
        boolean bookingLogoPresented = driver.findElement(By.xpath(BOOKING_LOGO)).isDisplayed();
        boolean currencyPresented = driver.findElement(By.xpath(CURRENCY)).isDisplayed();
        boolean languagePresented = driver.findElement(By.xpath(LANGUAGE)).isDisplayed();
        boolean customerServicesPresented = driver.findElement(By.xpath(CUSTOMER_SERVICES)).isDisplayed();
        boolean notificationsPresented = driver.findElement(By.xpath(NOTIFICATIONS)).isDisplayed();
        boolean listOfPropertyPresented = driver.findElement(By.xpath(LIST_OF_PROPERTY)).isDisplayed();
        boolean accountPresented = driver.findElement(By.xpath(YOUR_ACCOUNT)).isDisplayed();
        if (bookingLogoPresented && currencyPresented &&
                languagePresented && customerServicesPresented &&
                notificationsPresented && listOfPropertyPresented && accountPresented) {
            headers = true;
        }
        return headers;
    }


    //<<<---MAKE AS TEST--->>>
    public void welcomeBookingForm(){

    }

    public void passCaptcha(){
        //WebElement iframeElement = driver.findElement(By.xpath("//div[@id='px-captcha']/iframe[8]"));
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='px-captcha']/iframe[8]")));
        WebElement captcha = driver.findElement(By.id("jmtizSJxDoYzibW"));

        Actions action = new Actions(driver);
        action.clickAndHold(captcha).build().perform();
        try{
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        action.release(captcha).build().perform();
    }

}
