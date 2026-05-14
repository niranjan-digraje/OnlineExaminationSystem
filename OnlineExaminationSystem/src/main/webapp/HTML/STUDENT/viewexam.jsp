<%@page import="java.util.*"%>
<%@page import="org.onlineexam.model.ExamModel"%>

<%

String user =
(String)session.getAttribute("user");

if(user == null){

    response.sendRedirect("../Home.html");

    return;
}

List<ExamModel> exams =
(List<ExamModel>)request.getAttribute("exams");

%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>Student View Exam</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<link rel="stylesheet"
href="../../CSS/STUDENT/viewexam.css">

</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-success">

    <div class="container-fluid px-4">

        <a class="navbar-brand fw-bold fs-3">

            <i class="bi bi-mortarboard-fill me-2"></i>

            Online Examination System

        </a>

        <div class="d-flex align-items-center">

            <!-- BACK BUTTON -->

            <a href="/OnlineExaminationSystem/HTML/STUDENT/studentdashboard.jsp"
               class="btn btn-light me-3">

                <i class="bi bi-arrow-left"></i>

                Back

            </a>

            <!-- STUDENT NAME -->

            <div class="student-profile text-white">

                <i class="bi bi-person-circle me-2"></i>

                <%= user %>

            </div>

        </div>

    </div>

</nav>

<div class="container-fluid page-container p-4">

    <h1 class="page-title">

        VIEW EXAM

    </h1>

    <div class="info-box">

        <div class="info-icon">

            <i class="bi bi-info-lg"></i>

        </div>

        <div>

            <h4>Available Exams</h4>

            <p>

                Below is the list of exams
                available for your course.

            </p>

        </div>

    </div>

    <div class="card exam-card">

        <div class="table-responsive">

            <table class="table align-middle">

                <thead>

                    <tr>

                        <th>SR.NO</th>
                        <th>Exam Name</th>
                        <th>Subject</th>
                        <th>Total Questions</th>
                        <th>Total Marks</th>
                        <th>Duration</th>
                        <th>Exam Date</th>
                        <th>Action</th>

                    </tr>

                </thead>

                <tbody>

                <%

                if(exams != null &&
                   exams.size() > 0){

                    int count = 1;

                    for(ExamModel e : exams){

                %>

                    <tr>

                        <td>

                            <%=count++%>

                        </td>

                        <td>

                            <%=e.getExamTitle()%>

                        </td>

                        <td>

                            <span class="subject java">

                                <%=e.getSubjectName()%>

                            </span>

                        </td>

                        <td>

                            <%=e.getTotalQuestions()%>

                        </td>

                        <td>

                            <%=e.getTotalMarks()%>

                        </td>

                        <td>

                            <%=e.getDurationMinutes()%> Min

                        </td>

                        <td>

                            <i class="bi bi-calendar-event me-2"></i>

                            <%=e.getExamDate()%>

                            <br>

                            <i class="bi bi-clock me-2"></i>

                            <%=e.getStartTime()%>

                        </td>

                        <td>

                            <!-- <a href="/OnlineExaminationSystem/startexam?id=<%=e.getExamId()%>"
                               class="btn btn-success start-btn">

                                Start Exam

                            </a> -->
                            <a href="/OnlineExaminationSystem/startexam?examId=<%=e.getExamId()%>"
                                class="btn btn-success start-btn">

                                Start Exam

                            </a>
                        </td>

                    </tr>

                <%
                    }

                }else{
                %>

                    <tr>

                        <td colspan="8"
                            class="text-center text-danger fw-bold">

                            No Exams Available

                        </td>

                    </tr>

                <%
                }
                %>

                </tbody>

            </table>

        </div>

    </div>

</div>

<footer>

    � 2026 Online Examination System |
    All Rights Reserved

</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>