package LMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {
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
        // Check the title of the second most popular course
        String title_second_popular_course = driver.findElement(By.xpath("//h3[contains(text(),'Email Marketing Strategies')]")).getText();

        //Print the title of the second most popular course
        System.out.println("Title of the second most popular course on the website is: " + title_second_popular_course);

        //Assertion for title of the second most popular course
        Assert.assertEquals("Email Marketing Strategies", title_second_popular_course);

    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }


}
