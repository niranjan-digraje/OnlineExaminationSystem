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

@WebServlet("/editquestionpage")
public class EditQuestionPage extends HttpServlet {

    @Override
	protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int questionId =
                Integer.parseInt(
                        request.getParameter("id"));

        QuestionService service =
                new QuestionServiceImpl();

        QuestionModel question =
                service.getQuestionById(questionId);

        request.setAttribute("question", question);

        request.getRequestDispatcher(
                "/HTML/TEACHER/updatequestion.jsp")
                .forward(request, response);
    }
}