package org.onlineexam.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.onlineexam.model.ExamModel;
import org.onlineexam.service.ExamService;
import org.onlineexam.service.ExamServiceImpl;

@WebServlet("/createexam")
public class CreateExam extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String examTitle =
                request.getParameter("examTitle");

        int subjectId =
                Integer.parseInt(
                        request.getParameter("subjectId"));

        int totalQuestions =
                Integer.parseInt(
                        request.getParameter("totalQuestions"));

        int totalMarks =
                Integer.parseInt(
                        request.getParameter("totalMarks"));

        int duration =
                Integer.parseInt(
                        request.getParameter("duration"));

        String examDate =
                request.getParameter("examDate");

        String startTime =
                request.getParameter("startTime");

        String endTime =
                request.getParameter("endTime");

        ExamModel model =
                new ExamModel();

        model.setExamTitle(examTitle);
        model.setSubjectId(subjectId);
        model.setTotalQuestions(totalQuestions);
        model.setTotalMarks(totalMarks);
        model.setDurationMinutes(duration);
        model.setExamDate(examDate);
        model.setStartTime(startTime);
        model.setEndTime(endTime);

        ExamService service =
                new ExamServiceImpl();

        boolean result =
                service.isAddExam(model);

        if(result){

            response.sendRedirect(
            "/OnlineExaminationSystem/HTML/TEACHER/createexam.jsp");

        }else{

            response.getWriter().println(
                    "Exam Not Created");
        }
    }
}