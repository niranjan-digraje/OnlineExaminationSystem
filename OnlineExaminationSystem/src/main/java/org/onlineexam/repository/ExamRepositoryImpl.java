package org.onlineexam.repository;

import java.util.ArrayList;
import java.util.List;

import org.onlineexam.model.ExamModel;

public class ExamRepositoryImpl extends DBConfig
        implements ExamRepository {

    @Override
    public boolean isAddExam(ExamModel model) {

        try {

            stmt = conn.prepareStatement(
                    "insert into exam(exam_title,subject_id,total_questions,total_marks,duration_minutes,exam_date,start_time,end_time) values(?,?,?,?,?,?,?,?)");

            stmt.setString(1, model.getExamTitle());
            stmt.setInt(2, model.getSubjectId());
            stmt.setInt(3, model.getTotalQuestions());
            stmt.setInt(4, model.getTotalMarks());
            stmt.setInt(5, model.getDurationMinutes());
            stmt.setString(6, model.getExamDate());
            stmt.setString(7, model.getStartTime());
            stmt.setString(8, model.getEndTime());

            int value = stmt.executeUpdate();

            return value > 0;

        } catch (Exception e) {

            System.out.println(e);

            return false;
        }
    }

    @Override
    public List<ExamModel> getAllExams() {

        List<ExamModel> list = new ArrayList<>();

        try {

            stmt = conn.prepareStatement(
                    "select * from exam");

            rs = stmt.executeQuery();

            while (rs.next()) {

                ExamModel model = new ExamModel();

                model.setExamId(
                        rs.getInt("exam_id"));

                model.setExamTitle(
                        rs.getString("exam_title"));

                list.add(model);
            }

        } catch (Exception e) {

            System.out.println(
                    "getAllExams Error : " + e);
        }

        return list;
    }

    @Override
public List<ExamModel> getStudentExams(String email) {

    List<ExamModel> list =
            new ArrayList<>();

    try {

        String sql =
                "select e.*, s.subject_name " +
                "from exam e " +
                "inner join subject s " +
                "on e.subject_id = s.subject_id " +
                "inner join users u " +
                "on s.course_id = u.course_id " +
                "where u.full_name=?";

        stmt = conn.prepareStatement(sql);

        stmt.setString(1, email);

        rs = stmt.executeQuery();

        while(rs.next()) {

            ExamModel model =
                    new ExamModel();

            model.setExamId(
                    rs.getInt("exam_id"));

            model.setExamTitle(
                    rs.getString("exam_title"));

            model.setSubjectName(
                    rs.getString("subject_name"));

            model.setTotalQuestions(
                    rs.getInt("total_questions"));

            model.setTotalMarks(
                    rs.getInt("total_marks"));

            model.setDurationMinutes(
                    rs.getInt("duration_minutes"));

            // DATE

            java.sql.Date examDate =
                    rs.getDate("exam_date");

            model.setExamDate(
                    examDate.toString());

            // START TIME

            java.sql.Time startTime =
                    rs.getTime("start_time");

            model.setStartTime(
                    startTime.toString());

            // END TIME

            java.sql.Time endTime =
                    rs.getTime("end_time");

            model.setEndTime(
                    endTime.toString());

            list.add(model);
        }

        System.out.println(
                "TOTAL EXAMS = " + list.size());

    } catch(Exception e) {

        System.out.println(e);
    }

    return list;
}

@Override
public ExamModel getExamById(int examId) {

    ExamModel model = null;

    try {

        stmt = conn.prepareStatement(
                "select * from exam where exam_id=?");

        stmt.setInt(1, examId);

        rs = stmt.executeQuery();

        if(rs.next()) {

            model = new ExamModel();

            model.setExamId(
                    rs.getInt("exam_id"));

            model.setExamTitle(
                    rs.getString("exam_title"));

            model.setTotalQuestions(
                    rs.getInt("total_questions"));

            model.setTotalMarks(
                    rs.getInt("total_marks"));

            model.setDurationMinutes(
                    rs.getInt("duration_minutes"));

            model.setExamDateString(
                    rs.getDate("exam_date").toString());

            model.setStartTimeString(
                    rs.getTime("start_time").toString());

            model.setEndTimeString(
                    rs.getTime("end_time").toString());
        }

    } catch(Exception e) {

        System.out.println(e);
    }

    return model;
}
}