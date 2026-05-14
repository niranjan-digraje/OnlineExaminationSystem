package org.onlineexam.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

import org.onlineexam.model.ResultModel;
import org.onlineexam.service.ResultService;
import org.onlineexam.service.ResultServiceImpl;

@WebServlet("/viewresult")
public class ViewResult extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        ResultService service =
        new ResultServiceImpl();

        List<ResultModel> list =
        service.getAllResults();

        request.setAttribute("results", list);

        RequestDispatcher r =
        request.getRequestDispatcher(
            "/HTML/STUDENT/result.jsp");

        r.forward(request, response);
    }
}