package org.onlineexam.controller;

import java.io.IOException;
import java.util.List;

import org.onlineexam.model.CourseModel;
import org.onlineexam.model.SubjectModel;
import org.onlineexam.repository.CourseRepositoryImpl;
import org.onlineexam.repository.SubjectRepositoryImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updatesubjectpage")
public class UpdateSubjectPage extends HttpServlet {

    @Override
	protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int subjectId =
                Integer.parseInt(
                        request.getParameter("id"));

        // SUBJECT

        SubjectRepositoryImpl subjectRepo =
                new SubjectRepositoryImpl();

        SubjectModel subject =
                subjectRepo.getSubjectById(subjectId);

        // COURSES

        CourseRepositoryImpl courseRepo =
                new CourseRepositoryImpl();

        List<CourseModel> courses =
                courseRepo.getAllCourses();

        // SET DATA

        request.setAttribute("subject", subject);

        request.setAttribute("courses", courses);

        // FORWARD

        RequestDispatcher rd =
                request.getRequestDispatcher(
                        "HTML/TEACHER/updatesubject.jsp");

        rd.forward(request, response);
    }
}