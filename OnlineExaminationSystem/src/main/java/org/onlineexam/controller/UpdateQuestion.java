package org.onlineexam.controller;

import java.io.IOException;

import org.onlineexam.model.QuestionModel;
import org.onlineexam.service.QuestionService;
import org.onlineexam.service.QuestionServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updatequestion")
public class UpdateQuestion extends HttpServlet {

    @Override
	protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int questionId =
                Integer.parseInt(
                        request.getParameter("questionId"));

        String question =
                request.getParameter("question");

        String optionA =
                request.getParameter("optionA");

        String optionB =
                request.getParameter("optionB");

        String optionC =
                request.getParameter("optionC");

        String optionD =
                request.getParameter("optionD");

        String correctAnswer =
                request.getParameter("correctAnswer");

        QuestionModel model =
                new QuestionModel();

        model.setQuestionId(questionId);
        model.setQuestionText(question);
        model.setOptionA(optionA);
        model.setOptionB(optionB);
        model.setOptionC(optionC);
        model.setOptionD(optionD);
        model.setCorrectAnswer(correctAnswer);

        QuestionService service =
                new QuestionServiceImpl();

        boolean result =
                service.isUpdateQuestion(model);

        response.sendRedirect(
                "/OnlineExaminationSystem/getallquestions");
    }
}