package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    @Before
    public void setUp(){
        openBrowser("http://demo.nopcommerce.com/");
    }
    @Test
    public void UserShouldNavigateToRegisterPageSuccessfully(){

        // click on the ‘Register’ link
        WebElement registerLink=driv.findElement(By.linkText("Register"));
        registerLink.click();

        // Verify the text ‘Register’
        String expectedMessage="Register";

        //Finding element Xpath
        WebElement actualTextElement=driv.findElement(By.xpath("//h1[text()='Register']"));

        //Getting text from webpage and storing in variable
        String actualMessage=actualTextElement.getText();

        //Comparing actual and expected result and printing in message in console
        Assert.assertEquals("Register not displayed",expectedMessage,actualMessage);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        // click on the ‘Register’ link
        WebElement registerLink=driv.findElement(By.linkText("Register"));

        //Click on register link
        registerLink.click();

        // Select gender radio button
        driv.findElement(By.id("gender-female")).click();

        // Find element for first name
        WebElement firstNameField=driv.findElement(By.id("FirstName"));

        //send the text to Firstname field
        firstNameField.sendKeys("Pinks");

        //Find element for last name
        WebElement lastNameField=driv.findElement(By.name("LastName"));

        //send the text to Last name field
        lastNameField.sendKeys("Shah");

        // Select Day Month and Year , input the value and click
        driv.findElement(By.name("DateOfBirthDay")).click();
        driv.findElement(By.xpath("//option[@value='6']")).click();
        driv.findElement(By.name("DateOfBirthMonth")).click();
        driv.findElement(By.xpath("//option[@value='5' and text()='May']")).click();
        driv.findElement(By.name("DateOfBirthYear")).click();
        driv.findElement(By.xpath("//option[@value='1990']")).click();

        // Find element and enter Email address
        driv.findElement(By.id("Email")).sendKeys("ozapurvi@gmail.com");

        // Find element and Enter Password
        driv.findElement(By.name("Password")).sendKeys("Snow1234");

        // Enter Confirm password
        driv.findElement(By.name("ConfirmPassword")).sendKeys("Snow1234");

        // Click on REGISTER button
        driv.findElement(By.id("register-button")).click();

        // Verify the text 'Your registration completed'.
        String expectedMessage="Your registration completed";
        WebElement actualTextElement=driv.findElement(By.className("result"));
        String actualMessage=actualTextElement.getText();
        Assert.assertEquals("Your registration completed not displayed",expectedMessage,actualMessage);
    }
    @After                       //Close browser
    public void tearDown(){
        closeBrowser();
    }
}




