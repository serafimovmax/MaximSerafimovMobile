package com.epam.setup;

import org.openqa.selenium.WebElement;

public interface IPageObject {

    WebElement getWebElement(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;
}
