package org.onlineexam.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

import org.onlineexam.model.ExamModel;
import org.onlineexam.model.QuestionModel;
import org.onlineexam.service.ExamService;
import org.onlineexam.service.ExamServiceImpl;
import org.onlineexam.service.QuestionService;
import org.onlineexam.service.QuestionServiceImpl;

@WebServlet("/startexam")
public class StartExam extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String examIdStr =
                request.getParameter("examId");

        if(examIdStr == null || examIdStr.equals("")){

            response.getWriter().println(
                    "Exam ID Missing");

            return;
        }

        int examId =
                Integer.parseInt(examIdStr);

        ExamService examService =
                new ExamServiceImpl();

        ExamModel exam =
                examService.getExamById(examId);

        QuestionService questionService =
                new QuestionServiceImpl();

        List<QuestionModel> questions =
                questionService.getQuestionsByExamId(examId);

        request.setAttribute("exam", exam);

        request.setAttribute("questions", questions);

        RequestDispatcher r =
                request.getRequestDispatcher(
                        "/HTML/STUDENT/startExam.jsp");

        r.forward(request, response);
    }
}