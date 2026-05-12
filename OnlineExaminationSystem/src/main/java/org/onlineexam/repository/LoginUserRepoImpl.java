package org.onlineexam.repository;

import java.sql.ResultSet;

public class LoginUserRepoImpl extends DBConfig implements LoginUserRepo {

    @Override
    public String getRole(String email, String password) {

        try {

            // SQL Query

            

            // Prepared Statement

            stmt = conn.prepareStatement("SELECT role FROM users WHERE email=? AND password=?");

            stmt.setString(1, email.trim());

            stmt.setString(2, password.trim());

            // Execute Query

            rs = stmt.executeQuery();

            // Check Result

            if (rs.next()) {
                System.out.print(rs.getString("role"));
                return rs.getString("role");
            }else{
                return "error";
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String getUserName(String email) {
       try {

            String query =
            "SELECT full_name FROM users WHERE email=?";

            stmt =
                    conn.prepareStatement(query);

            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {

                return rs.getString("full_name");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }

}
