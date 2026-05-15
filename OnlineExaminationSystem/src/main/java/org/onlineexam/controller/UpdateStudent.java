package org.onlineexam.controller;

import java.io.IOException;

import org.onlineexam.model.UserModel;
import org.onlineexam.service.StudentService;
import org.onlineexam.service.StudentServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updatestudent")
public class UpdateStudent extends HttpServlet {

    @Override
	protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int id =
        Integer.parseInt(request.getParameter("id"));

        StudentService service =
                new StudentServiceImpl();

        UserModel model =
                service.getStudentById(id);

        request.setAttribute("student", model);

        request.getRequestDispatcher(
                "HTML/TEACHER/updatestudent.jsp")
                .forward(request, response);
    }
}