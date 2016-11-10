package com.rserg.jdbc;


import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASS = "root";

    public static void main(String[] args)
    {
        Connection connection = null;

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager drvmanager;
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASS);
            if (!connection.isClosed())
                System.out.println("Соединение с БД установленно!");
        } catch (SQLException e) {
            System.out.println("Не удалось загрузить класс драйвера!");
        }
        finally {
            try {
                connection.close();
                System.out.println("Соединение с БД закрыто!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
