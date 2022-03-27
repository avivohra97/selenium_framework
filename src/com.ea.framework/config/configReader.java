package com.ea.framework.config;

import com.ea.framework.base.BrowserType;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class configReader{

    public static  void populateSettings() throws IOException {
        configReader configReader = new configReader();
        configReader.readProperty();
    }
    private void readProperty() throws IOException {
        Properties p = new Properties();
        p.load(new FileInputStream("F:\\process\\src\\com.ea.framework\\config\\GlobalConfig.properties"));
        Settings.ExcelUtilPath = p.getProperty("ExcelUtilPath");
        Settings.LogPath = p.getProperty("LogPath");
        Settings.BrowserType = BrowserType.valueOf(p.getProperty("BrowserType"));
    }
}
