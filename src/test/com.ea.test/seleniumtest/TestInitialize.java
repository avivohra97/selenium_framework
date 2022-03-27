package com.ea.test.seleniumtest;

import com.ea.framework.base.FrameworkInitialize;
import com.ea.framework.config.Settings;
import com.ea.framework.config.configReader;
import com.ea.framework.utilities.ApacheExcelUtil;
import com.ea.framework.utilities.DatabaseUtil;
import com.ea.framework.utilities.LogUtil;
//import io.cucumber.java.Before;
import org.junit.Before;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;

public class TestInitialize extends FrameworkInitialize {

    /**
     *
     *
     * @Before with junit will not work for cucumber cases,
     * will have to remove org.junit.Before
     */

    @Before
    public void initialize() throws IOException {
        configReader.populateSettings();
        LogUtil logUtil = new LogUtil();
        logUtil.createLogFile(Settings.LogPath);
        logUtil.write("Framework Initialized");
//        initializeBrowser(BrowserType.Chrome,"http://eaapp.somee.com");
// can make Settings.Logs to provide log util to all the classes
        initializeBrowser(Settings.BrowserType,"http://eaapp.somee.com");
        try{
            ApacheExcelUtil excelUtil = new ApacheExcelUtil(System.getProperty("user.dir")+ File.separator+ Settings.ExcelUtilPath);
            Connection connection = DatabaseUtil.getConnection();
            DatabaseUtil.executeQuery("select * from emp1;",connection);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
