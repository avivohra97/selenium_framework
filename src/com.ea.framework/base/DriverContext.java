package com.ea.framework.base;

import org.openqa.selenium.WebDriver;

public class DriverContext {
    public static WebDriver driver;

    public static Browser browser;

    public static void setDriver(WebDriver driver) {
        DriverContext.driver = driver;
    }

    public static void setBrowser(Browser browser) {
        DriverContext.browser = browser;
    }
}
