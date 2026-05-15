package org.onlineexam.controller;

import java.io.IOException;

import org.onlineexam.service.StudentService;
import org.onlineexam.service.StudentServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deletestudent")
public class DeleteStudent extends HttpServlet {

    @Override
	protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("id"));

        StudentService service = new StudentServiceImpl();

        boolean result = service.isDeleteStudent(userId);

        if(result) {

            response.sendRedirect("viewstudents");

        } else {

            response.getWriter().println("Student Not Deleted");
        }
    }
}