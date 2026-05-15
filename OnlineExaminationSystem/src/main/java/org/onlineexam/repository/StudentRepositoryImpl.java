package org.onlineexam.repository;

import java.util.ArrayList;
import java.util.List;

import org.onlineexam.model.UserModel;

public class StudentRepositoryImpl extends DBConfig
        implements StudentRepository {

    List<UserModel> list;

    @Override
    public List<UserModel> getAllStudents() {

        try {

            list = new ArrayList<>();

            stmt = conn.prepareStatement(
                "select * from users where role='STUDENT'");

            rs = stmt.executeQuery();

            while(rs.next()) {

                UserModel model = new UserModel();

                model.setUserId(rs.getInt("user_id"));
                model.setUserName(rs.getString("full_name"));
                model.setUserEmail(rs.getString("email"));
        
                model.setUserMobile(rs.getString("mobile"));
                model.setUserGender(rs.getString("gender"));

                list.add(model);
            }

        } catch(Exception e) {

            System.out.println("Error : " + e);
        }

        return list;
    }

    @Override
    public boolean isDeleteStudent(int id) {

        try {

            stmt = conn.prepareStatement(
                "delete from users where user_id=?");

            stmt.setInt(1, id);

            int value = stmt.executeUpdate();

            return value > 0;

        } catch(Exception e) {

            System.out.println("Delete Error : " + e);

            return false;
        }
    }

    @Override
    public UserModel getStudentById(int id) {

        UserModel model = null;

        try {

            stmt = conn.prepareStatement(
            "select * from users where user_id=?");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if(rs.next()) {

                model = new UserModel();

                model.setUserId(rs.getInt("user_id"));
                model.setUserName(rs.getString("full_name"));
                model.setUserEmail(rs.getString("email"));
                model.setUserPassword(rs.getString("password"));
                model.setUserMobile(rs.getString("mobile"));
                model.setUserGender(rs.getString("gender"));
            }

        } catch(Exception e) {

            System.out.println(e);
        }

        return model;
    }

    @Override
    public boolean isUpdateStudent(UserModel model) {

        try {

            stmt = conn.prepareStatement(
            "update users set full_name=?,email=?,password=?,mobile=?,gender=? where user_id=?");

            stmt.setString(1, model.getUserName());
            stmt.setString(2, model.getUserEmail());
            stmt.setString(3, model.getUserPassword());
            stmt.setString(4, model.getUserMobile());
            stmt.setString(5, model.getUserGender());
            stmt.setInt(6, model.getUserId());

            int value = stmt.executeUpdate();

            return value > 0;

        } catch(Exception e) {

            System.out.println(e);

            return false;
        }
    }
}