package com.epam.pageObjects;

import static com.epam.setup.BaseTest.getPo;
import static com.epam.setup.BaseTest.getWebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NativePageObject  {

    private static final String BASE_LOCATOR = "platkovsky.alexey.epamtestapp:id/";

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Sign In']")
    @AndroidFindBy(id = BASE_LOCATOR + "email_sign_in_button")
    WebElement signInButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Register new account']")
    @AndroidFindBy(id = BASE_LOCATOR + "register_button")
    WebElement registerButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    @AndroidFindBy(id = BASE_LOCATOR + "registration_email")
    WebElement emailInputField;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='TimApple']")
    @AndroidFindBy(id = BASE_LOCATOR + "registration_username")
    WebElement usernameInputField;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    @AndroidFindBy(id = BASE_LOCATOR + "registration_password")
    WebElement passwordInputField;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Repeat please']")
    @AndroidFindBy(id = BASE_LOCATOR + "registration_confirm_password")
    WebElement passwordConfirmationField;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Register new account']")
    @AndroidFindBy(id = BASE_LOCATOR + "register_new_account_button")
    WebElement registerNewAccountButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    @AndroidFindBy(id = BASE_LOCATOR + "login_email")
    WebElement loginEmailInput;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    @AndroidFindBy(id = BASE_LOCATOR + "login_pwd")
    WebElement loginPasswordInput;
    @AndroidFindBy(id = BASE_LOCATOR + "add_new_expense")
    WebElement addExpenseButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@value='0']")
    @AndroidFindBy(className = "android.widget.CheckedTextView")
    WebElement confirmAgreements;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Budget']")
    @AndroidFindBy(className = "android.widget.TextView")
    WebElement budgetTitle;

    public static void signUp(String email, String username, String password, String platformName)
        throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getPo().getWebElement("registerButton").click();
        getPo().getWebElement("emailInputField").sendKeys(email);
        getPo().getWebElement("usernameInputField").sendKeys(username);
        getPo().getWebElement("passwordInputField").sendKeys(password);
        getPo().getWebElement("passwordConfirmationField").sendKeys(password);
        getPo().getWebElement("confirmAgreements").click();
        getPo().getWebElement("registerNewAccountButton").click();
    }

    public static void signIn(String email, String password)
        throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(getPo().getWebElement("loginEmailInput"))).sendKeys(email);
        getPo().getWebElement("loginPasswordInput").sendKeys(password);
        getPo().getWebElement("signInButton").click();
    }

    public NativePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }
}
