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

    List<ExamModel> list =
            new ArrayList<ExamModel>();

    try {

        stmt = conn.prepareStatement(
                "select * from exam");

        rs = stmt.executeQuery();

        while(rs.next()){

            ExamModel model =
                    new ExamModel();

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
}