package com.epam.pageObjects;

import static com.epam.setup.BaseTest.getPo;
import static com.epam.setup.BaseTest.getWebDriverWait;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebPageObject  {

    @FindBy(xpath = "//div[1]/input[1]")
    WebElement searchInputField;
    @FindBy(xpath = "//span[text()='epam']")
    static List<WebElement> searchResultsList;

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);

    }

    public static void inputSearchData(String keyword)
        throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getPo().getWebElement("searchInputField").sendKeys(keyword);
        getPo().getWebElement("searchInputField").sendKeys(Keys.ENTER);
    }

    public static List<String> getSearchResults() {
        getWebDriverWait().until(webDriver -> ((JavascriptExecutor) webDriver)
            .executeScript("return document.readyState").equals("complete"));
        return searchResultsList.stream()
                          .map(WebElement::getText)
                          .collect(Collectors.toList());
    }
}
