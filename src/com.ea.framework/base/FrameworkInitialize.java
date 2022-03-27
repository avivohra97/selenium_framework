package com.ea.framework.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameworkInitialize extends Base{

    public void initializeBrowser(BrowserType type,String URL) {

        switch (type){
            case Chrome:{
                System.setProperty("webdriver.chrome.driver", "resources/Drivers/chromedriver.exe");
                DriverContext.driver = new ChromeDriver();
                break;
            }
            case Firefox:{
                System.setProperty("webdriver.gecko.driver", "resources/Drivers/geckodriver.exe");
                DriverContext.driver = new FirefoxDriver();
            }

        }

        System.out.println("driver set");
        DriverContext.browser = new Browser(DriverContext.driver);
        DriverContext.browser.goToUrl(URL);

    }
}
