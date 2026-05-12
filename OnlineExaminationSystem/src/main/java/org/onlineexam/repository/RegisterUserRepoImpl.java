package org.onlineexam.repository;

import java.sql.ResultSet;

import org.onlineexam.model.UserModel;

public class RegisterUserRepoImpl extends DBConfig implements RegisterUserRepo{

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

    @Override
    public boolean isRegisterUser(UserModel userModel) {
         try {

            stmt = conn.prepareStatement(

                    "INSERT INTO users(full_name,email,password,mobile,gender,course_id) VALUES(?,?,?,?,?,?)"

            );

            stmt.setString(1, userModel.getUserName());

            stmt.setString(2, userModel.getUserEmail());

            stmt.setString(3, userModel.getUserPassword());

            stmt.setString(4, userModel.getUserMobile());

            stmt.setString(5, userModel.getUserGender());

            stmt.setInt(6, userModel.getUserCourseId());

            int value = stmt.executeUpdate();

            if(value > 0) {

                return true;
            }
            else {

                return false;
            }

        }
        catch(Exception e) {

            System.out.println(
                    "Error in RegisterUserRepoImpl : " + e);

            return false;
        }
    }

}
