package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {

    Properties properties;

    String path = "Configuration/config.properties";

    public ReadConfig() throws FileNotFoundException {

        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(path);
            properties.load(fis);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getBaseUrl(){
        String value = properties.getProperty("baseUrl");
        if(value!=null){
            return value;
        }
        else{
            throw new RuntimeException("URL not specified in config file!");
        }
    }

    public String getBrowser(){
        String value = properties.getProperty("browser");
        if(value!=null){
            return value;
        }
        else{
            throw new RuntimeException("Browser not specified in config file!");
        }
    }

}
