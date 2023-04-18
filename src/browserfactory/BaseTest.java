package browserfactory;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driv;                          //Defining variable to store value of Webdriver
    public static String baseUrl = " ";                   //Defining variable to store value of URL

    @Test
    public void openBrowser(String baseUrl) {            //Method to setup to get drivers for browser
        driv = new ChromeDriver();                       //Storing value of driver to variable
        driv.get(baseUrl);                               //Storing value of Url to varialbe
        driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  // Defining implicit wait time
    }

    @After                                              //Closing browser
    public void closeBrowser() {
        driv.quit();
    }
}
