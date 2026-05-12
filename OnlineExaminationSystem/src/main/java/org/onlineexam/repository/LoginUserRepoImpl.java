package org.onlineexam.repository;


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

}
