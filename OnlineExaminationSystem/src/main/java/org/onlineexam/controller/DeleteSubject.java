package org.onlineexam.controller;

import java.io.IOException;

import org.onlineexam.service.SubjectService;
import org.onlineexam.service.SubjectServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deletesubject")
public class DeleteSubject extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int subjectId =
                Integer.parseInt(request.getParameter("id"));

        SubjectService service = new SubjectServiceImpl();

        service.isDeleteSubject(subjectId);

        response.sendRedirect(
                "/OnlineExaminationSystem/addsubject");
    }
}