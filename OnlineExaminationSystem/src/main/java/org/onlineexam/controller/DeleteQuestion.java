package org.onlineexam.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;


import org.onlineexam.service.QuestionService;
import org.onlineexam.service.QuestionServiceImpl;

@WebServlet("/deletequestion")
public class DeleteQuestion extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int questionId =
                Integer.parseInt(
                        request.getParameter("id"));

        QuestionService service =
                new QuestionServiceImpl();

        boolean result =
                service.isDeleteQuestion(questionId);

        response.sendRedirect(
                "/OnlineExaminationSystem/getallquestions");
    }
}