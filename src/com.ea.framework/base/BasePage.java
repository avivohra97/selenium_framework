package com.ea.framework.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/*
to create a standard for initialization of page objects for testing
 */
public abstract class BasePage extends Base{

    /*
    A way for non generic pagination

    public BasePage(){
        PageFactory.initElements(DriverContext.driver,this);
    }
     */

    public <Tpage extends BasePage> Tpage As(Class<Tpage> pageInstance){
        try{
            return (Tpage)this;
        }catch (Exception e){
            e.getStackTrace();
        }
        return null;
    }
}
