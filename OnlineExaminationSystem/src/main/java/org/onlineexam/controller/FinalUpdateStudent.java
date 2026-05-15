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

@WebServlet("/finalupdatestudent")
public class FinalUpdateStudent extends HttpServlet {

    @Override
	protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int id =
        Integer.parseInt(request.getParameter("id"));

        String name =
        request.getParameter("name");

        String email =
        request.getParameter("email");

        String password =
        request.getParameter("password");

        String mobile =
        request.getParameter("mobile");

        String gender =
        request.getParameter("gender");

        UserModel model = new UserModel();

        model.setUserId(id);
        model.setUserName(name);
        model.setUserEmail(email);
        model.setUserPassword(password);
        model.setUserMobile(mobile);
        model.setUserGender(gender);

        StudentService service =
                new StudentServiceImpl();

        boolean result =
                service.isUpdateStudent(model);

        if(result) {

            response.sendRedirect("viewstudents");

        } else {

            response.getWriter().println(
            "Student Not Updated");
        }
    }
}