package org.onlineexam.repository;

import java.util.ArrayList;
import java.util.List;

import org.onlineexam.model.UserModel;

public class ViewStudentRepoImpl extends DBConfig
implements ViewStudentRepo {

    List<UserModel> list;

    @Override
    public List<UserModel> getAllStudents() {

        System.out.println("line 16");
        try {

            list = new ArrayList<>();

            String query =

            "select u.user_id,u.full_name,u.email,u.mobile,c.course_name,u.course_id " +
            "from users u " +
            "left join course c " +
            "on u.course_id=c.course_id " +
            "where u.role='STUDENT'";

            stmt = conn.prepareStatement(query);

            rs = stmt.executeQuery();

            while(rs.next()) {

                UserModel model =
                        new UserModel();

                model.setUserId(rs.getInt("user_id"));

                model.setUserName(rs.getString("full_name"));

                model.setUserEmail(rs.getString("email"));

                model.setUserMobile(rs.getString("mobile"));
                //System.out.println(rs.getString("course_name"));
                model.setCourseName(rs.getString("course_name"));

                model.setUserCourseId(rs.getInt("course_id"));
                list.add(model);
            }

            return list;

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }

    @Override
    public boolean isDeleteStudent(int userId) {

        try {

            stmt = conn.prepareStatement(
            "delete from users where user_id=?");

            stmt.setInt(1, userId);

            int value = stmt.executeUpdate();

            return value > 0;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }

    @Override
    public UserModel getStudentById(int id) {

        try {

            stmt = conn.prepareStatement(
            "select * from users where user_id=?");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if(rs.next()) {

                UserModel model =
                        new UserModel();

                model.setUserId(rs.getInt("user_id"));

                model.setUserName(rs.getString("full_name"));

                model.setUserEmail(rs.getString("email"));

                model.setUserMobile(rs.getString("mobile"));

                model.setUserGender(rs.getString("gender"));

                model.setUserCourseId(rs.getInt("course_id"));

                return model;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean isUpdateStudent(UserModel model) {

        try {

            stmt = conn.prepareStatement(

            "update users set full_name=?,email=?,mobile=?,gender=?,course_id=? where user_id=?"

            );

            stmt.setString(1, model.getUserName());

            stmt.setString(2, model.getUserEmail());

            stmt.setString(3, model.getUserMobile());

            stmt.setString(4, model.getUserGender());

            stmt.setInt(5, model.getUserCourseId());

            stmt.setInt(6, model.getUserId());

            int value = stmt.executeUpdate();

            return value > 0;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }
}