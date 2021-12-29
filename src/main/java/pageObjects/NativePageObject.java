package pageObjects;

import static setup.BaseTest.getPo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NativePageObject  {

    private static final String BASE_LOCATOR = "platkovsky.alexey.epamtestapp:id/";

    @AndroidFindBy(id = BASE_LOCATOR + "email_sign_in_button")
    private WebElement signInButton;
    @AndroidFindBy(id = BASE_LOCATOR + "register_button")
    private WebElement registerButton;
    @AndroidFindBy(id = BASE_LOCATOR + "registration_email")
    private WebElement emailInputField;
    @AndroidFindBy(id = BASE_LOCATOR + "registration_username")
    private WebElement usernameInputField;
    @AndroidFindBy(id = BASE_LOCATOR + "registration_password")
    private WebElement passwordInputField;
    @AndroidFindBy(id = BASE_LOCATOR + "registration_confirm_password")
    private WebElement passwordConfirmationField;
    @AndroidFindBy(id = BASE_LOCATOR + "register_new_account_button")
    private WebElement registerNewAccountButton;
    @AndroidFindBy(id = BASE_LOCATOR + "login_email")
    private WebElement loginEmailInput;
    @AndroidFindBy(id = BASE_LOCATOR + "login_pwd")
    private WebElement loginPasswordInput;
    @AndroidFindBy(id = BASE_LOCATOR + "add_new_expense")
    private WebElement addExpenseButton;


    public static void signUp(String email, String username, String password)
        throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getPo().getWebElement("registerButton").click();
        getPo().getWebElement("emailInputField").sendKeys(email);
        getPo().getWebElement("usernameInputField").sendKeys(username);
        getPo().getWebElement("passwordInputField").sendKeys(password);
        getPo().getWebElement("passwordConfirmationField").sendKeys(password);
        getPo().getWebElement("registerNewAccountButton").click();
    }

    public static void signIn(String email, String password)
        throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getPo().getWebElement("loginEmailInput").sendKeys(email);
        getPo().getWebElement("loginPasswordInput").sendKeys(password);
        getPo().getWebElement("signInButton").click();
    }

    public NativePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }
}
