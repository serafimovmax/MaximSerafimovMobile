package scenarios;

import static org.testng.AssertJUnit.assertTrue;
import static pageObjects.NativePageObject.signIn;
import static pageObjects.NativePageObject.signUp;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {

    @Parameters({"email", "username", "password"})
    @Test(groups = {"native"}, description = "Sign Up and Sign In test")
    public void simpleNativeTest(String email, String username, String password)
        throws NoSuchFieldException, IllegalAccessException, InstantiationException{

        signUp(email, username, password);
        signIn(email, password);

        assertTrue(getPo().getWebElement("addExpenseButton").isDisplayed());

        System.out.println("Android native test is done");
    }
}
