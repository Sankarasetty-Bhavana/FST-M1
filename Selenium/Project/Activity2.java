package LMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
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
        // Check the title of the page
        String heading = driver.findElement(By.xpath("//h1[contains(@class,'uagb-ifb-title')]")).getText();

        //Print the title of the page
        System.out.println("Heading is: " + heading);

        //Assertion for page title
        Assert.assertEquals("Learn from Industry Experts", heading);

    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }


}
