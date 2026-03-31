package com.clinic.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/clinic_db",
                    "root",
                    "Ay@220903"
            );

            System.out.println("Connected to DB");
            return con;

        } catch (Exception e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
        return null;
    }
}
