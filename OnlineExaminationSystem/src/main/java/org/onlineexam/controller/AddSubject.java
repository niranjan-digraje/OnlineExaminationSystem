package org.onlineexam.controller;

import java.io.IOException;
import java.util.List;

import org.onlineexam.model.CourseModel;
import org.onlineexam.model.SubjectModel;
import org.onlineexam.service.SubjectService;
import org.onlineexam.service.SubjectServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addsubject")
public class AddSubject extends HttpServlet {

    @Override
	protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        SubjectService service = new SubjectServiceImpl();

        List<CourseModel> courses = service.getAllCourses();

        List<SubjectModel> subjects = service.getAllSubjects();

        request.setAttribute("courses", courses);

        request.setAttribute("subjects", subjects);

        request.getRequestDispatcher(
                "HTML/TEACHER/addsubjects.jsp")
                .forward(request, response);
    }

    @Override
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String subjectName =
                request.getParameter("subjectName");

        int courseId =
                Integer.parseInt(request.getParameter("courseId"));

        SubjectModel model = new SubjectModel();

        model.setSubjectName(subjectName);

        model.setCourseId(courseId);

        SubjectService service = new SubjectServiceImpl();

        service.isAddSubject(model);

        response.sendRedirect(
                "/OnlineExaminationSystem/addsubject");
    }
}