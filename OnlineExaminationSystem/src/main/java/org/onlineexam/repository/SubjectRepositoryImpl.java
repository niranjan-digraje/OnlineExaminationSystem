package org.onlineexam.repository;

import java.util.ArrayList;
import java.util.List;

import org.onlineexam.model.CourseModel;
import org.onlineexam.model.SubjectModel;

public class SubjectRepositoryImpl extends DBConfig implements SubjectRepository {

    @Override
    public boolean isAddSubject(SubjectModel model) {

        try {

            stmt = conn.prepareStatement(
                    "insert into subject(subject_name,course_id) values(?,?)");

            stmt.setString(1, model.getSubjectName());

            stmt.setInt(2, model.getCourseId());

            int value = stmt.executeUpdate();

            return value > 0;

        } catch (Exception e) {

            System.out.println(e);

            return false;
        }
    }

    @Override
    public List<CourseModel> getAllCourses() {

        List<CourseModel> list = new ArrayList<>();

        try {

            stmt = conn.prepareStatement("select * from course");

            rs = stmt.executeQuery();

            while (rs.next()) {

                CourseModel model = new CourseModel();

                model.setCourseId(rs.getInt("course_id"));

                model.setCourseName(rs.getString("course_name"));

                list.add(model);
            }

        } catch (Exception e) {

            System.out.println(e);
        }

        return list;
    }

    @Override
    public List<SubjectModel> getAllSubjects() {

        List<SubjectModel> list = new ArrayList<>();

        try {

            stmt = conn.prepareStatement(
                    "select s.subject_id,s.subject_name,c.course_name " +
                    "from subject s inner join course c " +
                    "on s.course_id=c.course_id");

            rs = stmt.executeQuery();

            while (rs.next()) {

                SubjectModel model = new SubjectModel();

                model.setSubjectId(rs.getInt(1));

                model.setSubjectName(rs.getString(2));

                model.setCourseName(rs.getString(3));

                list.add(model);
            }

        } catch (Exception e) {

            System.out.println(e);
        }

        return list;
    }

    @Override
    public boolean isDeleteSubject(int subjectId) {

        try {

            stmt = conn.prepareStatement(
                    "delete from subject where subject_id=?");

            stmt.setInt(1, subjectId);

            int value = stmt.executeUpdate();

            return value > 0;

        } catch (Exception e) {

            System.out.println(e);

            return false;
        }
    }

    @Override
    public SubjectModel getSubjectById(int subjectId) {

        SubjectModel model = new SubjectModel();

        try {

            stmt = conn.prepareStatement(
                    "select * from subject where subject_id=?");

            stmt.setInt(1, subjectId);

            rs = stmt.executeQuery();

            if (rs.next()) {

                model.setSubjectId(rs.getInt("subject_id"));

                model.setSubjectName(rs.getString("subject_name"));

                model.setCourseId(rs.getInt("course_id"));
            }

        } catch (Exception e) {

            System.out.println(e);
        }

        return model;
    }

    @Override
    public boolean isUpdateSubject(SubjectModel model) {

        try {

            stmt = conn.prepareStatement(
                    "update subject set subject_name=?,course_id=? where subject_id=?");

            stmt.setString(1, model.getSubjectName());

            stmt.setInt(2, model.getCourseId());

            stmt.setInt(3, model.getSubjectId());

            int value = stmt.executeUpdate();

            return value > 0;

        } catch (Exception e) {

            System.out.println(e);

            return false;
        }
    }

    @Override
    public SubjectModel fetchSubjectById(int subjectId) {

        SubjectModel model = null;

        try {

            stmt = conn.prepareStatement(
                    "select * from subject where subject_id=?");

            stmt.setInt(1, subjectId);

            rs = stmt.executeQuery();

            if (rs.next()) {

                model = new SubjectModel();

                model.setSubjectId(rs.getInt("subject_id"));

                model.setSubjectName(rs.getString("subject_name"));

                model.setCourseId(rs.getInt("course_id"));
            }

        } catch (Exception e) {

            System.out.println("Error : " + e);
        }

        return model;
    }
    
    @Override
public List<SubjectModel> getExamAllSubjects() {

    List<SubjectModel> list =
            new ArrayList<>();

    try {

        stmt = conn.prepareStatement(
        "select * from subject");

        rs = stmt.executeQuery();

        while(rs.next()){

            SubjectModel model =
                    new SubjectModel();

            model.setSubjectId(
                    rs.getInt("subject_id"));

            model.setSubjectName(
                    rs.getString("subject_name"));

            model.setCourseId(
                    rs.getInt("course_id"));

            list.add(model);
        }

    } catch (Exception e) {

        System.out.println(e);
    }

    return list;
}
}