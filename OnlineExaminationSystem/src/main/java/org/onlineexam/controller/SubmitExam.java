// package org.onlineexam.controller;

// import java.io.IOException;
// import java.sql.*;

// import jakarta.servlet.*;
// import jakarta.servlet.annotation.WebServlet;
// import jakarta.servlet.http.*;

// @WebServlet("/submitexam")
// public class SubmitExam extends HttpServlet {

//     protected void doPost(HttpServletRequest request,
//                           HttpServletResponse response)
//             throws ServletException, IOException {

//         int examId =
//                 Integer.parseInt(
//                         request.getParameter("examId"));

//         HttpSession session =
//                 request.getSession();

//         String email =
//                 (String)session.getAttribute("user");

//         try {

//             Connection conn =
//                     DriverManager.getConnection("jdbc:mysql://localhost:3306/online_exam_system", "root", "root");

//             int userId = 0;

//             // GET USER ID

//             PreparedStatement stmt =
//                     conn.prepareStatement(
//                             "select user_id from users where email=?");

//             stmt.setString(1, email);

//             ResultSet rs =
//                     stmt.executeQuery();

//             if(rs.next()) {

//                 userId =
//                         rs.getInt("user_id");
//             }

//             // FETCH QUESTIONS

//             stmt = conn.prepareStatement(
//                     "select * from question where exam_id=?");

//             stmt.setInt(1, examId);

//             rs = stmt.executeQuery();

//             int correct = 0;
//             int total = 0;

//             while(rs.next()) {

//                 total++;

//                 int questionId =
//                         rs.getInt("question_id");

//                 String correctAnswer =
//                         rs.getString("correct_answer");

//                 String userAnswer =
//                         request.getParameter(
//                                 "question_" + questionId);

//                 if(correctAnswer.equals(userAnswer)) {

//                     correct++;
//                 }
//             }

//             int obtainedMarks =
//                     correct;

//             double percentage =
//                     ((double)obtainedMarks / total) * 100;

//             String status =
//                     percentage >= 40
//                     ? "PASS"
//                     : "FAIL";

//             // INSERT RESULT

//             stmt = conn.prepareStatement(
//                     "insert into result(user_id,exam_id,obtained_marks,total_marks,percentage,result_status) values(?,?,?,?,?,?)");

//             stmt.setInt(1, userId);

//             stmt.setInt(2, examId);

//             stmt.setInt(3, obtainedMarks);

//             stmt.setInt(4, total);

//             stmt.setDouble(5, percentage);

//             stmt.setString(6, status);

//             int value =
//                     stmt.executeUpdate();

//             if(value > 0){

//                 response.sendRedirect(
//                         "/OnlineExaminationSystem/viewresult");

//             }else{

//                 response.getWriter().println(
//                         "Result Not Saved");
//             }

//         } catch(Exception e) {

//             System.out.println(e);
//         }
//     }
// }

package org.onlineexam.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.*;
import java.util.*;

@WebServlet("/submitexam")
public class SubmitExam extends HttpServlet {

        protected void doPost(HttpServletRequest request,
                        HttpServletResponse response)
                        throws ServletException, IOException {

                HttpSession session = request.getSession();

                Integer userId = (Integer) session.getAttribute("userId");
                System.out.println( "USER ID = " + userId);
                if (userId == null) {

                        response.getWriter().println(
                                        "Session Expired. Please Login Again");

                        return;
                }

                int examId = Integer.parseInt(
                                request.getParameter("examId"));

                int totalMarks = Integer.parseInt(
                                request.getParameter("totalMarks"));

                int obtainedMarks = 0;

                Connection conn = null;

                PreparedStatement stmt = null;

                ResultSet rs = null;

                try {

                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_exam_system", "root",
                                        "root");

                        stmt = conn.prepareStatement(
                                        "select * from question where exam_id=?");

                        stmt.setInt(1, examId);

                        rs = stmt.executeQuery();

                        while (rs.next()) {

                                int questionId = rs.getInt("question_id");

                                String correctAnswer = rs.getString("correct_answer");

                                String userAnswer = request.getParameter(
                                                "answer_" + questionId);

                                if (userAnswer != null &&
                                                userAnswer.equals(correctAnswer)) {

                                        obtainedMarks++;
                                }
                        }
                        System.out.println("obtainedMarks = "+obtainedMarks);
                        double percentage = ((double) obtainedMarks / totalMarks) * 100;

                        String status = percentage >= 40
                                        ? "PASS"
                                        : "FAIL";

                        stmt = conn.prepareStatement(

                                        "insert into result(user_id,exam_id,"
                                                        + "obtained_marks,total_marks,"
                                                        + "percentage,result_status)"
                                                        + "values(?,?,?,?,?,?)"

                        );

                        stmt.setInt(1, userId);

                        stmt.setInt(2, examId);

                        stmt.setInt(3, obtainedMarks);

                        stmt.setInt(4, totalMarks);

                        stmt.setDouble(5, percentage);

                        stmt.setString(6, status);

                        int value = stmt.executeUpdate();

                        if (value > 0) {

                                response.sendRedirect(
                                                "/OnlineExaminationSystem/viewresult");

                        } else {

                                response.getWriter().println(
                                                "Result Not Stored");
                        }

                } catch (Exception e) {

                        System.out.println(e);
                }
        }
}