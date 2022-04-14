package LMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Activity8 {
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/lms");
    }
    @Test
    public void test() throws InterruptedException {

        WebElement Contact = driver.findElement(By.id("menu-item-1506"));
        Contact.click();
        Thread.sleep(3000);

        WebElement fullname = driver.findElement(By.id("wpforms-8-field_0"));
        WebElement email = driver.findElement(By.id("wpforms-8-field_1"));
        WebElement subject = driver.findElement(By.id("wpforms-8-field_3"));
        WebElement message = driver.findElement(By.id("wpforms-8-field_2"));

        fullname.sendKeys("Name1");
        email.sendKeys("name1@gmail.com");
        subject.sendKeys("NewUser");
        message.sendKeys("Hello");

        WebElement submit = driver.findElement(By.id("wpforms-submit-8"));
        submit.click();
        Thread.sleep(3000);

        String Message_AftSub = driver.findElement(By.id("wpforms-confirmation-8")).getText();
        System.out.println(Message_AftSub);
    }
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
