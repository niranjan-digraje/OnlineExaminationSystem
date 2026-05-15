package org.onlineexam.controller;

import java.io.IOException;
import java.util.List;

import org.onlineexam.model.UserModel;
import org.onlineexam.service.StudentService;
import org.onlineexam.service.StudentServiceImpl;
import org.onlineexam.service.ViewStudentService;
import org.onlineexam.service.ViewStudentServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewstudents")
public class ViewStudents extends HttpServlet {

    @Override
	protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

       

        ViewStudentService service = new ViewStudentServiceImpl();

        List<UserModel> list =
                service.getAllStudents();
        request.setAttribute("list", list);

        request.getRequestDispatcher(
                "HTML/TEACHER/viewstudent.jsp")
                .forward(request, response);
    }
}