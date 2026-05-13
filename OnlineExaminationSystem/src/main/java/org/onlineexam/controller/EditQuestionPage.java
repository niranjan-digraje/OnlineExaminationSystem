package org.onlineexam.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import org.onlineexam.model.QuestionModel;
import org.onlineexam.service.QuestionService;
import org.onlineexam.service.QuestionServiceImpl;

@WebServlet("/editquestionpage")
public class EditQuestionPage extends HttpServlet {

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