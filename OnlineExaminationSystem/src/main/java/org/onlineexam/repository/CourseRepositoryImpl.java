package org.onlineexam.repository;

import java.util.ArrayList;
import java.util.List;

import org.onlineexam.model.CourseModel;

public class CourseRepositoryImpl extends DBConfig implements CourseRepository {

    @Override
    public List<CourseModel> getAllCourses() {

        List<CourseModel> list = new ArrayList<>();

        try {

            stmt = conn.prepareStatement("select * from course");

            rs = stmt.executeQuery();

            while(rs.next()) {

                CourseModel model = new CourseModel();

                model.setCourseId(rs.getInt("course_id"));
                model.setCourseName(rs.getString("course_name"));

                list.add(model);
            }

        } catch(Exception e) {

            System.out.println("Course Error : " + e);
        }

        return list;
    }
}