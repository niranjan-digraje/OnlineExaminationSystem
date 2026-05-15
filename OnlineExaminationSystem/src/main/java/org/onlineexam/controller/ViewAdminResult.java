package org.onlineexam.controller;

import java.io.IOException;
import java.util.List;

import org.onlineexam.model.ResultModel;
import org.onlineexam.service.ResultService;
import org.onlineexam.service.ResultServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewadminresult")
public class ViewAdminResult extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        ResultService service =
                new ResultServiceImpl();

        List<ResultModel> list =
                service.getAllResults();

        request.setAttribute("results", list);

        request.getRequestDispatcher(
        "/HTML/TEACHER/result.jsp")
        .forward(request, response);
    }
}