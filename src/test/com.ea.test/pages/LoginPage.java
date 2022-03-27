package com.ea.test.pages;

import com.ea.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    @FindBy(how = How.NAME, using = "UserName")
    public WebElement txtUsername;

    @FindBy(how = How.NAME, using = "Password")
    public WebElement txtPassword;

    @FindBy(how = How.CSS, using = "[class*='btn-default']")
    public WebElement btnLogin;

//    public LoginPage(WebDriver driver) {
//        super(driver);
//    }
// to initialize objects and provide driver to page
//    public LoginPage(WebDriver driver) {
//        this.driver = driver;// if this line not present , will get error that the pacakge pages not found
//        PageFactory.initElements(driver,this);
//    }

    public BasePage Login(String username, String password){
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.submit();
        /*
        before generic
        return new HomePage();
         */
        return GetInstance(HomePage.class);

    }


}
