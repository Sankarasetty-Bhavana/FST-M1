package liveProject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity6_Proj {
    WebDriverWait wait;
    AndroidDriver<MobileElement> driver = null;

    @BeforeClass
    public void setup() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "c01dca5a");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testSearchAppium() {
        // Open page in browser
        driver.get("https://www.training-support.net/selenium");
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";

        // wait for page to load
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")));


        /// Scroll to To do list
        driver.findElement(MobileBy.AndroidUIAutomator(UiScrollable + ".scrollForward(0).scrollIntoView(text(\"Popups Tooltips and Modals\"))")).click();

        // Wait for new page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.TextView[@text='Popups']")));

        //find Signin and click
        driver.findElementByXPath("//android.widget.Button[@text='Sign In']").click();

        // Wait for new page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.TextView[@text='Sign In']")));

        //Username and Password and enter keys
        MobileElement userName = driver.findElementById("username");
        MobileElement passWord = driver.findElementById("password");

        userName.sendKeys("admin");
        passWord.sendKeys("password");

        driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();

        MobileElement successLogin =  driver.findElementByXPath("//android.view.View[@text='Welcome Back, admin']");

        // Assertion1
        String loginsuccess = driver.findElementByXPath("//android.view.View[@text='Welcome Back, admin']").getText();
        Assert.assertEquals(loginsuccess, "Welcome Back, admin");

        //InvalidUsername and Password and enter keys
        MobileElement userName2 = driver.findElementById("username");
        MobileElement passWord2 = driver.findElementById("password");

        userName2.sendKeys("admin");
        passWord2.sendKeys("password1");

        driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();

        MobileElement failureLogin =  driver.findElementByXPath("//android.view.View[@text='Invalid Credentials']");


        // Assertion2
        String loginfailure = driver.findElementByXPath("//android.view.View[@text='Invalid Credentials']").getText();
        Assert.assertEquals(loginfailure, "Invalid Credentials");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}

