package com.edutech.progressive.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {
    private static final String PROPERTIES_FILE="application.properties";
    private static final Properties properties=new Properties();
    static{
        loadProperties();
    }
    private static void loadProperties(){
        try(FileInputStream fis=new FileInputStream(PROPERTIES_FILE)){
            properties.load(fis);
        }catch(IOException e){
            System.out.println("Error loading properties file: "+e.getMessage());
        }
    }
    public static Connection getConnection() throws SQLException{
        String url=properties.getProperty("spring.datasource.url");
        String password=properties.getProperty("spring.datasource.url.password");
        String username=properties.getProperty("spring.datasource.username");
        return DriverManager.getConnection(url,username,password);

    }
    

}
