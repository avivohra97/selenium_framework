package com.ea.framework.utilities;




import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class DatabaseUtil {
    private static Connection conn = null;

    public static Connection getConnection() throws SQLException {
        try (FileInputStream f = new FileInputStream("F:\\process\\resources\\db.properties")) {

            // load the properties file
            Properties pros = new Properties();
            pros.load(f);

            // assign db parameters
            String url = pros.getProperty("url");
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");

            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            System.out.println(String.format("Connected to database %s "
                    + "successfully.", conn.getCatalog()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void close() throws SQLException{
        conn.close();
    }

    public static void executeQuery(String query, Connection connection) throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet resultset =  statement.executeQuery(query);
        while (resultset.next()) {
            System.out.println(
                    resultset.getRow());
        }
        System.out.println("DONE");
    }

}