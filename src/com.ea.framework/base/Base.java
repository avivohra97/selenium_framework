package com.ea.framework.base;

import org.openqa.selenium.support.PageFactory;

public class Base {

    public static BasePage currentPage;// this now gets extended to base Page class and be available to all other page classes

    /**
     * Page Factory is a class provided by Selenium WebDriver to support Page Object Design patterns.
     * In Page Factory, testers use @FindBy annotation.
     * The initElements method is used to initialize web elements.
     * Similarly, one can use @FindBy with different location strategies to find web elements and perform actions on them.
     */

    public <Tpage extends BasePage> Tpage GetInstance(Class<Tpage> page){
        Object obj = PageFactory.initElements(DriverContext.driver, page);
        return page.cast(obj);
    }
}
