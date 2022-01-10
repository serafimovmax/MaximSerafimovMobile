package com.epam.scenarios;

import static org.testng.AssertJUnit.assertTrue;
import static com.epam.pageObjects.WebPageObject.getSearchResults;
import static com.epam.pageObjects.WebPageObject.inputSearchData;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.epam.setup.BaseTest;

public class webMobileTests extends BaseTest {

    @Parameters({"keyword"})
    @Test(groups = {"web"}, description = "Make sure that there are some relevant results.")
    public void simpleWebTest(String keyword) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getDriver().get("http://www.google.com");

        inputSearchData(keyword);
        assertTrue(getSearchResults().stream().anyMatch(str -> str.trim().contains(keyword)));

        System.out.println("EPAM keyword is found");
    }
}
