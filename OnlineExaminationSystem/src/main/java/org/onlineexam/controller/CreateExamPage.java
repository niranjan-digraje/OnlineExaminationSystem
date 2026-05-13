package org.onlineexam.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import org.onlineexam.model.SubjectModel;
import org.onlineexam.service.SubjectService;
import org.onlineexam.service.SubjectServiceImpl;

@WebServlet("/createexampage")
public class CreateExamPage extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        SubjectService service =
                new SubjectServiceImpl();

        List<SubjectModel> list =
                service.getAllSubjects();

        request.setAttribute("subjects", list);

        request.getRequestDispatcher(
        "HTML/TEACHER/createexam.jsp")
        .forward(request, response);
    }
}