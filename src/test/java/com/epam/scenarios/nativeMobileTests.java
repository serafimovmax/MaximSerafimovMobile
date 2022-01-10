package com.epam.scenarios;

import static com.epam.util.Randomator.email;
import static com.epam.util.Randomator.password;
import static com.epam.util.Randomator.userName;
import static org.testng.AssertJUnit.assertTrue;
import static com.epam.pageObjects.NativePageObject.signIn;
import static com.epam.pageObjects.NativePageObject.signUp;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.epam.setup.BaseTest;

public class nativeMobileTests extends BaseTest {

    @Parameters({"platformName"})
    @Test(groups = {"native"}, description = "Sign Up and Sign In test")
    public void simpleNativeTest(String platformName)
        throws NoSuchFieldException, IllegalAccessException, InstantiationException{

        signUp(email, userName, password, platformName);
        signIn(email, password);

        assertTrue(getPo().getWebElement("budgetTitle").isDisplayed());

        System.out.println("Android/IOS native test is done");
    }
}
