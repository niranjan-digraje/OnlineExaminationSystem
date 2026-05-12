package org.onlineexam.repository;

import org.onlineexam.model.UserModel;

public class RegisterUserRepoImpl extends DBConfig implements RegisterUserRepo{

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
