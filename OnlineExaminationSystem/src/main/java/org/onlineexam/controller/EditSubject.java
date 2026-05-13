package org.onlineexam.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import org.onlineexam.model.CourseModel;
import org.onlineexam.model.SubjectModel;
import org.onlineexam.repository.CourseRepositoryImpl;
import org.onlineexam.service.SubjectService;
import org.onlineexam.service.SubjectServiceImpl;

@WebServlet("/editsubject")
public class EditSubject extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        // FETCH SUBJECT ID

        int subjectId =
                Integer.parseInt(
                        request.getParameter("id"));

        // SUBJECT SERVICE

        SubjectService subjectService =
                new SubjectServiceImpl();

        // FETCH SUBJECT

        SubjectModel subject =
                subjectService.fetchSubjectById(subjectId);

        // FETCH COURSES

        CourseRepositoryImpl courseRepo =
                new CourseRepositoryImpl();

        List<CourseModel> courses =
                courseRepo.getAllCourses();

        // SET ATTRIBUTES

        request.setAttribute("subject", subject);

        request.setAttribute("courses", courses);

        // FORWARD JSP PAGE

        RequestDispatcher rd =
                request.getRequestDispatcher(
                        "HTML/TEACHER/editsubject.jsp");

        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}