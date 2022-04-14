package LMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
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
        // Check the title of the first info box
        String title_infobox = driver.findElement(By.xpath("//h3[contains(text(),'Actionable Training')]")).getText();

        //Print the title of the first info box
        System.out.println("Title of the first info box is: " + title_infobox);

        //Assertion for title of the first info box
        Assert.assertEquals("Actionable Training", title_infobox);

    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }


}
