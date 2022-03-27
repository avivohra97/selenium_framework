package com.ea.test.pages;

import com.ea.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {
    @FindBy(how = How.LINK_TEXT, using = "Login")
    public WebElement linkLogin;

    @FindBy(how = How.LINK_TEXT, using = "Employee List")
    public WebElement linkEmployeeList;

    public boolean IsLogin(){
        return linkLogin.isDisplayed();
    }

    public BasePage clickLogin(){
        linkLogin.click();
//        return new LoginPage();// to add pagination
//        before generic

        // after generic
        return GetInstance(LoginPage.class);
    }
}
