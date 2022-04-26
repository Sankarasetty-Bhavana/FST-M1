package liveProject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1_Proj {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "c01dca5a");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void googleTasks() {
        driver.findElementByAccessibilityId("Create new task").click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));

        //First Task
        WebElement Task1 = driver.findElementById("add_task_title");
        Task1.sendKeys("Complete Activity with Google tasks");

        // Save the task
        driver.findElementById("add_task_done").click();

        // Wait for task bar to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("action_bar_root")));

        //Second Task
        driver.findElementByAccessibilityId("Create new task").click();

        // Wait for fields to load
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
        driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Keep");
        driver.findElementById("add_task_done").click();

        // Wait for task bar to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("action_bar_root")));

        //Third Task
        driver.findElementByAccessibilityId("Create new task").click();

        // Wait for fields to load
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));

        driver.findElementById("add_task_title").sendKeys("Complete the second Activity Google Keep");
        driver.findElementById("add_task_done").click();

        //Assertions

        String task1 = driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Complete Activity with Google tasks']")).getText();
        Assert.assertEquals(task1, "Complete Activity with Google tasks");

        String task2 = driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Complete Activity with Google keep']")).getText();
        Assert.assertEquals(task2, "Complete Activity with Google keep");

        String task3 = driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Complete the second Activity Google keep']")).getText();;
        Assert.assertEquals(task3, "Complete the second Activity Google keep");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
