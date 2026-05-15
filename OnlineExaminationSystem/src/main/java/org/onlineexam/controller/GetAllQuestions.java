package org.onlineexam.controller;

import java.io.IOException;
import java.util.List;

import org.onlineexam.model.ExamModel;
import org.onlineexam.model.QuestionModel;
import org.onlineexam.service.ExamService;
import org.onlineexam.service.ExamServiceImpl;
import org.onlineexam.service.QuestionService;
import org.onlineexam.service.QuestionServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getallquestions")
public class GetAllQuestions extends HttpServlet {

    @Override
	protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        // FETCH ALL EXAMS

        ExamService examService =
                new ExamServiceImpl();

        List<ExamModel> exams =
                examService.getAllExams();

        // FETCH ALL QUESTIONS

        QuestionService questionService =
                new QuestionServiceImpl();

        List<QuestionModel> questions =
                questionService.getAllQuestions();

        // SEND DATA TO JSP

        request.setAttribute("exams", exams);

        request.setAttribute("questions", questions);

        request.getRequestDispatcher(
                "/HTML/TEACHER/setexam.jsp")
                .forward(request, response);
    }

    @Override
	protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}