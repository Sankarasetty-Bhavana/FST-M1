package LMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {
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

        WebElement Login = driver.findElement(By.linkText("Login"));
        Login.click();

        WebElement username = driver.findElement(By.id("user_login"));
        WebElement password = driver.findElement(By.id("user_pass"));

        username.sendKeys("root");
        password.sendKeys("pa$$w0rd");

        WebElement login_submit = driver.findElement(By.id("wp-submit"));
        login_submit.click();

        String MyUsername = driver.findElement(By.xpath("/html/body/div[2]/div/ul[2]/li[2]/a/span")).getText();
        Assert.assertEquals("root", MyUsername);
        System.out.println("Username:" + MyUsername + " Logged in Successfully");

    }
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
