package com.ea.framework.base;

import org.openqa.selenium.WebDriver;

public class Browser extends Base {

    public BrowserType type;
    private WebDriver driver;
    public Browser(WebDriver driver){
        this.driver = driver;
    }

    public void goToUrl(String URL){
        driver.get(URL);
    }

    public void maximizeWindow(){
        driver.manage().window().maximize();
    }
}

