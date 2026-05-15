package org.onlineexam.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.onlineexam.model.UserModel;
import org.onlineexam.service.RegisterUserService;
import org.onlineexam.service.RegisterUserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registeruser")
public class RegisterUser extends HttpServlet {

    @Override
	protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        try {

            // Fetch Form Data

            String userName =
                    request.getParameter("userName");

            String userEmail =
                    request.getParameter("userEmail");

            String userPassword =
                    request.getParameter("userPassword");

            String userMobile =
                    request.getParameter("userMobile");

            String userGender =
                    request.getParameter("userGender");

            // Safe Course Fetch

            String courseValue =
                    request.getParameter("userCourse");
			System.out.println(courseValue);
            int userCourseId = 0;

            if(courseValue != null &&
                    !courseValue.equals("")) {

                userCourseId =
                        Integer.parseInt(courseValue);
            }

            // Create Model Object

            UserModel usermodel = new UserModel();

            usermodel.setUserName(userName);

            usermodel.setUserEmail(userEmail);

            usermodel.setUserPassword(userPassword);

            usermodel.setUserMobile(userMobile);

            usermodel.setUserGender(userGender);

            usermodel.setUserCourseId(userCourseId);

            // Debug

            System.out.println(
                    usermodel.getUserName() + " " +
                    usermodel.getUserEmail() + " " +
                    usermodel.getUserGender() + " " +
                    usermodel.getUserCourseId()
            );

            // Service Object

            RegisterUserService registerUserService =
                    new RegisterUserServiceImpl();

            boolean result =
                    registerUserService
                    .isRegisterUser(usermodel);

            // Success

            if(result) {

                System.out.println(
                        "New User Registered");

                response.sendRedirect(
                        "HTML/STUDENT/studentlogin.html");
            }

            // Failure

            else {

                System.out.println(
                        "User Registration Failed");

                response.sendRedirect(
                        "HTML/STUDENT/studentregistrationform.html");
            }

        }
        catch(Exception e) {

            e.printStackTrace();

            out.println("<h2 style='color:red'>");
            out.println("Registration Error");
            out.println("</h2>");
        }
    }

    @Override
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}