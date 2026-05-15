package org.onlineexam.repository;

import java.util.ArrayList;
import java.util.List;

import org.onlineexam.model.QuestionModel;

public class QuestionRepositoryImpl extends DBConfig implements QuestionRepository {

    List<QuestionModel> list = new ArrayList<>();

    @Override
    public boolean isAddQuestion(QuestionModel model) {

        try {

            stmt = conn.prepareStatement(
                    "insert into question(exam_id,question_text,option_a,option_b,option_c,option_d,correct_answer) values(?,?,?,?,?,?,?)");

            stmt.setInt(1, model.getExamId());
            stmt.setString(2, model.getQuestionText());

            stmt.setString(3, model.getOptionA());
            stmt.setString(4, model.getOptionB());
            stmt.setString(5, model.getOptionC());
            stmt.setString(6, model.getOptionD());

            stmt.setString(7, model.getCorrectAnswer());

            int value = stmt.executeUpdate();

            return value > 0;

        } catch (Exception e) {

            System.out.println("QuestionRepositoryImpl Error : " + e);

            return false;
        }
    }

    @Override
    public List<QuestionModel> getAllQuestions() {

        try {

            stmt = conn.prepareStatement(
                    "select q.question_id,e.exam_title,q.question_text,q.option_a,q.option_b,q.option_c,q.option_d,q.correct_answer from question q inner join exam e on q.exam_id=e.exam_id");

            rs = stmt.executeQuery();

            while (rs.next()) {

                QuestionModel model = new QuestionModel();

                model.setQuestionId(rs.getInt(1));

                model.setExamTitle(rs.getString(2));

                model.setQuestionText(rs.getString(3));

                model.setOptionA(rs.getString(4));
                model.setOptionB(rs.getString(5));
                model.setOptionC(rs.getString(6));
                model.setOptionD(rs.getString(7));

                model.setCorrectAnswer(rs.getString(8));

                list.add(model);
            }

        } catch (Exception e) {

            System.out.println("Get All Questions Error : " + e);
        }

        return list;
    }

    @Override
    public boolean isDeleteQuestion(int questionId) {

        try {

            stmt = conn.prepareStatement(
                    "delete from question where question_id=?");

            stmt.setInt(1, questionId);

            int value = stmt.executeUpdate();

            return value > 0;

        } catch (Exception e) {

            System.out.println(e);
        }

        return false;
    }

    @Override
    public QuestionModel getQuestionById(int questionId) {

        QuestionModel model = null;

        try {

            stmt = conn.prepareStatement(
                    "select * from question where question_id=?");

            stmt.setInt(1, questionId);

            rs = stmt.executeQuery();

            if (rs.next()) {

                model = new QuestionModel();

                model.setQuestionId(
                        rs.getInt("question_id"));

                model.setQuestionText(
                        rs.getString("question_text"));

                model.setOptionA(
                        rs.getString("option_a"));

                model.setOptionB(
                        rs.getString("option_b"));

                model.setOptionC(
                        rs.getString("option_c"));

                model.setOptionD(
                        rs.getString("option_d"));

                model.setCorrectAnswer(
                        rs.getString("correct_answer"));
            }

        } catch (Exception e) {

            System.out.println(e);
        }

        return model;
    }

    @Override
    public boolean isUpdateQuestion(QuestionModel model) {

        try {

            stmt = conn.prepareStatement(

                    "update question set " +
                            "question_text=?, " +
                            "option_a=?, " +
                            "option_b=?, " +
                            "option_c=?, " +
                            "option_d=?, " +
                            "correct_answer=? " +
                            "where question_id=?"

            );

            stmt.setString(1,
                    model.getQuestionText());

            stmt.setString(2,
                    model.getOptionA());

            stmt.setString(3,
                    model.getOptionB());

            stmt.setString(4,
                    model.getOptionC());

            stmt.setString(5,
                    model.getOptionD());

            stmt.setString(6,
                    model.getCorrectAnswer());

            stmt.setInt(7,
                    model.getQuestionId());

            int value = stmt.executeUpdate();

            return value > 0;

        } catch (Exception e) {

            System.out.println(e);
        }

        return false;
    }

    @Override
public List<QuestionModel> getQuestionsByExamId(int examId) {

    List<QuestionModel> list =
            new ArrayList<>();

    try {

        stmt = conn.prepareStatement(
                "select * from question where exam_id=?");

        stmt.setInt(1, examId);

        rs = stmt.executeQuery();

        while(rs.next()) {

            QuestionModel model =
                    new QuestionModel();

            model.setQuestionId(
                    rs.getInt("question_id"));

            model.setQuestionText(
                    rs.getString("question_text"));

            model.setOptionA(
                    rs.getString("option_a"));

            model.setOptionB(
                    rs.getString("option_b"));

            model.setOptionC(
                    rs.getString("option_c"));

            model.setOptionD(
                    rs.getString("option_d"));

            model.setCorrectAnswer(
                    rs.getString("correct_answer"));

            list.add(model);
        }

    } catch(Exception e) {

        System.out.println(e);
    }

    return list;
}
}