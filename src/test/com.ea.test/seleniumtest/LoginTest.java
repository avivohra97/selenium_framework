package com.ea.test.seleniumtest;

import com.ea.framework.base.DriverContext;
import com.ea.framework.utilities.ApacheExcelUtil;
import com.ea.test.pages.HomePage;
import com.ea.test.pages.LoginPage;
import org.junit.Test;

import java.io.IOException;


public class LoginTest extends TestInitialize {

    @Test
    public void start() throws InterruptedException, IOException {
        initialize();
        System.out.println("test method");
//        way 1
//        driver.findElement(By.name("UserName")).sendKeys("admin");
//        driver.findElement(By.name("Password")).sendKeys("password");
//        driver.findElement(By.name("Login")).submit();
//        driver.wait(4000);
//        driver.close();
//        HomePage homePage = new HomePage();
//        homePage.clickLogin();
//
//        LoginPage loginPage;
//        loginPage = new LoginPage();
//        loginPage.Login("admin","password");
// before pagination

//        After pagination

//        LoginPage loginPage = (LoginPage) homePage.clickLogin();
//        Thread.sleep(2000);
//
//        loginPage.Login("admin","password");


//
//        EmployeeList employeeList = new EmployeeList();
//        employeeList.clickCreateNew();
       /*
       After generic
        */

        currentPage = GetInstance(HomePage.class);
        currentPage= currentPage.As(HomePage.class).clickLogin();
        Thread.sleep(2000);
        /*
        hardcoded
        currentPage.As(LoginPage.class).Login("admin","password");
         */

        currentPage.As(LoginPage.class).Login(ApacheExcelUtil.ReadCell("UserName",1),ApacheExcelUtil.ReadCell("Password",1));


        DriverContext.driver.close();
    }


}
