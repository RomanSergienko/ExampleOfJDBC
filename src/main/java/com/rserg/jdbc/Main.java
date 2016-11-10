package com.rserg.jdbc;


import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASS = "root";

    public static void main(String[] args)
    {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("Драйвер не найден!");
        }

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASS);
        Statement statement = connection.createStatement();)
        {
           statement.addBatch("INSERT INTO animal(anim_name, anim_desc) VALUES ('batch1','desc1')");
           statement.addBatch("INSERT INTO animal(anim_name, anim_desc) VALUES ('batch2','desc2')");
           statement.addBatch("INSERT INTO animal(anim_name, anim_desc) VALUES ('batch3','desc3')");

           statement.executeBatch();
        }
        catch (SQLException e)
        {

        }

    }
}
