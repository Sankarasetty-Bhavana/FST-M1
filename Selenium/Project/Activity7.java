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

public class Activity7 {
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

        WebElement AllCourses = driver.findElement(By.id("menu-item-1508"));
        AllCourses.click();
        Thread.sleep(3000);

        List courses = driver.findElements(By.xpath("//*[@id='ld-course-list-content-2f03b97ab51efe00449b53a93c07fbeb']/div/div"));
        //display product count
        System.out.println("No. of courses count:"+courses.size() );

    }
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
