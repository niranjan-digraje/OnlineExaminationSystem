<%@page import="java.util.*"%>
<%@page import="org.onlineexam.model.CourseModel"%>
<%@page import="org.onlineexam.model.SubjectModel"%>

<%
String user = (String)session.getAttribute("user");

if(user == null){

    response.sendRedirect("../Home.html");
    return;
}

List<CourseModel> courses =
(List<CourseModel>)request.getAttribute("courses");

List<SubjectModel> subjects =
(List<SubjectModel>)request.getAttribute("subjects");
%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>Add Subject</title>

<!-- Bootstrap CSS -->

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

<!-- Bootstrap Icons -->

<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<!-- External CSS -->

<link rel="stylesheet"
href="../../CSS/TEACHER/addsubjects.css">

</head>

<body>

<!-- ================= NAVBAR ================= -->

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">

    <div class="container-fluid px-4">

        <!-- LOGO -->

        <a class="navbar-brand fw-bold fs-3"
           href="teacherdashboard.jsp">

            <i class="bi bi-mortarboard-fill me-2"></i>

            Online Examination System

        </a>



        <!-- RIGHT SIDE -->

        <div class="d-flex align-items-center">

            <!-- BACK BUTTON -->

            <a href="/OnlineExaminationSystem/HTML/TEACHER/teacherdashboard.jsp"
   class="btn btn-light me-3">

    <i class="bi bi-arrow-left"></i>

    Back

</a>



            <!-- ADMIN NAME -->

            <div class="admin-profile text-white">

                <i class="bi bi-person-circle me-2"></i>

                <%= user %>

            </div>



            <!-- LOGOUT -->

            <a href="../../logout"
               class="btn btn-danger ms-3">

                <i class="bi bi-box-arrow-right"></i>

                Logout

            </a>

        </div>

    </div>

</nav>

<!-- ================= PAGE CONTAINER ================= -->

<div class="container page-container">

    <!-- PAGE TITLE -->

    <h1 class="page-title">

        ADD SUBJECT

    </h1>



    <!-- ================= ADD SUBJECT CARD ================= -->

    <div class="card subject-card">

        <!-- CARD HEADING -->

        <div class="card-heading">

            <div class="icon-box">

                <i class="bi bi-book-fill"></i>

            </div>



            <div>

                <h3>Add New Subject</h3>

                <p>

                    Fill in the details below to add a new subject.

                </p>

            </div>

        </div>

        <hr>



        <!-- FORM -->

        <form action="/OnlineExaminationSystem/addsubject"
              method="post">

            <!-- COURSE -->

            <div class="mb-4">

                <label class="form-label fw-bold">

                    Select Course

                </label>



                <select name="courseId"
                        class="form-select"
                        required>

                    <option value="">

                        -- Select Course --

                    </option>

                    <%
                    if(courses != null){

                        for(CourseModel c : courses){
                    %>

                    <option value="<%=c.getCourseId()%>">

                        <%=c.getCourseName()%>

                    </option>

                    <%
                        }
                    }
                    %>

                </select>

            </div>



            <!-- SUBJECT NAME -->

            <div class="mb-4">

                <label class="form-label fw-bold">

                    Subject Name

                </label>



                <div class="input-group">

                    <span class="input-group-text">

                        <i class="bi bi-book"></i>

                    </span>



                    <input type="text"
                           name="subjectName"
                           class="form-control"
                           placeholder="Enter subject name"
                           required>

                </div>

            </div>



            <!-- BUTTON -->

            <div class="button-box">

                <button type="submit"
                        class="btn btn-primary add-btn">

                    <i class="bi bi-plus-lg me-2"></i>

                    ADD SUBJECT

                </button>

            </div>

        </form>

    </div>



    <!-- ================= SUBJECT LIST CARD ================= -->

    <div class="card subject-card mt-4">

        <!-- HEADING -->

        <div class="card-heading">

            <div class="icon-box">

                <i class="bi bi-card-list"></i>

            </div>



            <div>

                <h3>Subject List</h3>

            </div>

        </div>



        <!-- TABLE -->

        <div class="table-responsive mt-3">

            <table class="table table-bordered align-middle">

                <thead>

                    <tr>

                        <th>SR.NO</th>
                        <th>Subject Name</th>
                        <th>Course Name</th>
                        <th>Actions</th>

                    </tr>

                </thead>



                <tbody>

                    <%
                    if(subjects != null){

                        int count = 1;

                        for(SubjectModel s : subjects){
                    %>

                    <tr>

                        <td>

                            <%=count++%>

                        </td>



                        <td>

                            <%=s.getSubjectName()%>

                        </td>



                        <td>

                            <%=s.getCourseName()%>

                        </td>



                        <td>

                            <!-- UPDATE -->

                            <a href="/OnlineExaminationSystem/editsubject?id=<%=s.getSubjectId()%>"
                               class="btn btn-primary btn-sm me-2">

                                <i class="bi bi-pencil-fill"></i>

                            </a>



                            <!-- DELETE -->

                            <a href="/OnlineExaminationSystem/deletesubject?id=<%=s.getSubjectId()%>"
                               class="btn btn-danger btn-sm">

                                <i class="bi bi-trash-fill"></i>

                            </a>

                        </td>

                    </tr>

                    <%
                        }
                    }
                    else{
                    %>

                    <tr>

                        <td colspan="4"
                            class="text-center text-danger fw-bold">

                            No Subjects Found

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

<!-- ================= FOOTER ================= -->

<footer>

    � 2026 Online Examination System | All Rights Reserved

</footer>

<!-- Bootstrap JS -->

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>