package com.epam.setup;

import static com.epam.util.DataVariables.API_KEY;
import static com.epam.util.DataVariables.APPIUM_HUB;
import static com.epam.util.DataVariables.PROJECT_NAME;
import static java.lang.String.format;

import io.appium.java_client.AppiumDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.epam.pageObjects.PageObject;

public class BaseTest implements IDriver {

    private static AppiumDriver appiumDriver; // singleton
    static IPageObject po;

    @Override
    public AppiumDriver getDriver() { return appiumDriver; }

    public static IPageObject getPo() {
        return po;
    }

    @Parameters({"platformName","appType","deviceName","browserName","app", "udid", "appPackage", "appActivity", "bundleId"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String platformName, String appType,
                      @Optional("") String deviceName,
                      @Optional("") String browserName,
                      @Optional("") String app,
                      @Optional("") String udid,
                      @Optional("") String appPackage,
                      @Optional("") String appActivity,
                      @Optional("") String bundleId) throws Exception {
        System.out.println("Before: app type - " + appType);
        setAppiumDriver(platformName, deviceName, browserName, app, udid, appPackage, appActivity, bundleId);
        setPageObject(appType, appiumDriver);

    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        System.out.println("After");
        appiumDriver.closeApp();
    }

    private void setAppiumDriver(String platformName,
                                 String deviceName,
                                 String browserName,
                                 String app,
                                 String udid,
                                 String appPackage,
                                 String appActivity,
                                 String bundleId){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability("platformName",platformName);
        capabilities.setCapability("deviceName",deviceName);
        capabilities.setCapability("udid", udid);

        if(app.endsWith(".apk")) capabilities.setCapability("app", (new File(app)).getAbsolutePath());

        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("chromedriverDisableBuildCheck","true");

        // Capabilities for test of Android native app on EPAM Mobile Cloud
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);

        // Capabilities for test of iOS native app on EPAM Mobile Cloud
        capabilities.setCapability("bundleId", bundleId);
        if(platformName.equals("iOS")) capabilities.setCapability("automationName","XCUITest");

        try {
            appiumDriver = new AppiumDriver(new URL(format("https://%s:%s@%s", PROJECT_NAME, API_KEY, APPIUM_HUB)), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Timeouts tuning
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private void setPageObject(String appType, AppiumDriver appiumDriver) throws Exception {
        po = new PageObject(appType, appiumDriver);
    }

    public static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(appiumDriver, 10L);
    }
}
