package LMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void test() {

        WebElement MyAccount = driver.findElement(By.id("menu-item-1507"));
        MyAccount.click();

        // Check the title of the page
        String MyAccount_title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + MyAccount_title);

        //Assertion for page title
        Assert.assertEquals("My Account – Alchemy LMS", MyAccount_title);


    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }


}
