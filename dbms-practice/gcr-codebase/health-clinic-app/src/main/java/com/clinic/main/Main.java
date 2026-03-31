package com.clinic.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.clinic.util.DBConnection;

public class Main {

    public static void main(String[] args) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "select * from patients";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                        rs.getString("name") + " " +
                        rs.getString("phone"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
