package com.example.demo_login_check;

import org.postgresql.Driver;

import java.sql.*;

public class GetUserData {
    public boolean checkData(String userName, String userPassword) throws SQLException, ClassNotFoundException{
        Class.forName("org.postgresql.Driver");

        //Connect to postgres data_base
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_users", "postgres", "nhuchuahechia");

        String sql_check = "SELECT * FROM user_info_2 where user_name = ? and user_password = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql_check);
        pstmt.setString(1, userName);
        pstmt.setString(2, userPassword);

        ResultSet rs = pstmt.executeQuery();

        if(!rs.isBeforeFirst()){
            return false;
        }
        else{
            return true;
        }


    }
}
