// package org.onlineexam.controller;

// import jakarta.servlet.ServletException;
// import jakarta.servlet.annotation.WebServlet;
// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import jakarta.servlet.http.HttpSession;

// import java.io.IOException;
// import java.io.PrintWriter;

// import org.onlineexam.service.LoginUserService;
// import org.onlineexam.service.LoginUserServiceImpl;

// @WebServlet("/loginuser")
// public class LoginUser extends HttpServlet {

//     protected void doPost(HttpServletRequest request,
//                           HttpServletResponse response)
//             throws ServletException, IOException {

//         response.setContentType("text/html");

//         PrintWriter out = response.getWriter();

//         // Fetch form data

//         String email = request.getParameter("email");

//         String password = request.getParameter("password");
// 		System.out.print(email);
// 		System.out.print(password);
// 		LoginUserService loginUserService = new LoginUserServiceImpl();
// 		String role = loginUserService.getRole(email, password);
//         // Temporary Login Validation
// 		System.out.println(role+" in login user");
//         if (role != null) {
//             if(role.equals("ADMIN"))
//         {
//             // Create Session

//             HttpSession session = request.getSession();

//             session.setAttribute("user", email);

//             // Redirect to Dashboard

//             response.sendRedirect("HTML/TEACHER/teacherdashboard.html");
//         }else if (role.equals("STUDENT")) {
// 			// Create Session

//             HttpSession session = request.getSession();

//             session.setAttribute("user", email);

//             // Redirect to Dashboard

//             response.sendRedirect("HTML/STUDENT/studentdashboard.html");
// 		}

//         }
//         else
//         {
//             out.println("<h2 style='color:red;text-align:center;'>");
//             out.println("Invalid Email or Password");
//             out.println("</h2>");

//             out.println("<div style='text-align:center;'>");
//             out.println("<a href='HTML/Home.html'>");
//             out.println("Try Again");
//             out.println("</a>");
//             out.println("</div>");
//         }
//     }
// }

package org.onlineexam.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import org.onlineexam.service.LoginUserService;
import org.onlineexam.service.LoginUserServiceImpl;

@WebServlet("/loginuser")
public class LoginUser extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");
        
        LoginUserService service =
                new LoginUserServiceImpl();

        String role =
                service.getRole(email, password);
        
        if(role != null) {

            String fullName =
                    service.getUserName(email);
            int userId = service.getUserId(email, password);

            // Session

            HttpSession session =
                    request.getSession();
            session.setAttribute("userId", userId);
            session.setAttribute("user", fullName);

            session.setAttribute("role", role);

            session.setAttribute("email", email);

            

            // Redirect

            if(role.equals("ADMIN")) {

                response.sendRedirect(
                "HTML/TEACHER/teacherdashboard.jsp");
            }
            else if(role.equals("STUDENT")) {

                response.sendRedirect(
                "HTML/STUDENT/studentdashboard.jsp");
            }

        } else {

            out.println("<h2 style='color:red;text-align:center;'>");
            out.println("Invalid Email or Password");
            out.println("</h2>");
            out.println("<div style='text-align:center;'>");
            out.println("<a href='HTML/Home.html'>");
            out.println("Try Again");
            out.println("</a>");
            out.println("</div>");
        }
    }
}