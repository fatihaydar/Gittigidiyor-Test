package com.gittigidiyor.base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static com.gittigidiyor.constans.ConstantLoginPage.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {


    static WebDriver driver = null;

    @BeforeScenario
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "properties/driver/chromedriverr.exe"); //kullanılacak driverin yolu seçilir
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-notifications");
        options.addArguments("disable-popup-blocking");
        options.addArguments("start-maximized");
        setDriver(new ChromeDriver(options));
        getDriver().navigate().to(webSite);
    }


    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        BaseTest.driver = driver;
    }

    @AfterScenario
    public void tearDown() {

//        getDriver().quit();
    }
}
