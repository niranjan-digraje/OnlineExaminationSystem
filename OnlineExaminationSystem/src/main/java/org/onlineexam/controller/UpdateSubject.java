package org.onlineexam.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.onlineexam.model.SubjectModel;
import org.onlineexam.service.SubjectService;
import org.onlineexam.service.SubjectServiceImpl;

@WebServlet("/updatesubject")
public class UpdateSubject extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String sid =
                request.getParameter("subjectId");

        if(sid == null || sid.equals("")){

            response.getWriter().println(
                    "Subject ID Missing"
            );

            return;
        }

        int subjectId = Integer.parseInt(sid);

        String subjectName =
                request.getParameter("subjectName");

        int courseId =
                Integer.parseInt(
                        request.getParameter("courseId")
                );

        SubjectModel model =
                new SubjectModel();

        model.setSubjectId(subjectId);

        model.setSubjectName(subjectName);

        model.setCourseId(courseId);

        SubjectService service =
                new SubjectServiceImpl();

        boolean result =
                service.isUpdateSubject(model);

        if(result){

            response.sendRedirect(
                    "/OnlineExaminationSystem/addsubject"
            );

        }else{

            response.getWriter().println(
                    "Subject Not Updated"
            );
        }
    }
}