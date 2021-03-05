package com.example.demo_login_check;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserData {
    public void connect(UserClass user) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_users", "postgres","nhuchuahechia");

        String sql_insert = "INSERT INTO user_info_2(user_name, user_password)" +
                "VALUES (?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql_insert);
        pstmt.setString(1,user.getUserName());
        pstmt.setString(2, user.getUserPassword());
        pstmt.execute();
    }


}