package org.onlineexam.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

import org.onlineexam.model.ExamModel;
import org.onlineexam.service.ExamService;
import org.onlineexam.service.ExamServiceImpl;

@WebServlet("/studentexams")
public class GetStudentExams extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
               


        HttpSession session =
                request.getSession(false);

        if(session == null ||
           session.getAttribute("user") == null){

            response.sendRedirect(
                    "HTML/Home.html");

            return;
        }

        // EMAIL FROM SESSION

        String email =
                (String)session.getAttribute("user");
        System.out.println(email);
        ExamService service =
                new ExamServiceImpl();

        List<ExamModel> list =
                service.getStudentExams(email);

        request.setAttribute("exams", list);

        request.getRequestDispatcher(
                "/HTML/STUDENT/viewexam.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}