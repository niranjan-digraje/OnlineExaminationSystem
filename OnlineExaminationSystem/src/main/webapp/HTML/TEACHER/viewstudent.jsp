<%@ page import="java.util.*" %>
<%@ page import="org.onlineexam.model.UserModel" %>

<%

/* ================= SESSION VALIDATION ================= */

String user = (String)session.getAttribute("user");

if(user == null){

    response.sendRedirect("../Home.html");

    return;
}

/* ================= FETCH STUDENT LIST ================= */

List<UserModel> list =
(List<UserModel>)request.getAttribute("list");

System.out.println("Student List : " + list);

%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>View Student</title>

<!-- Bootstrap CSS -->

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

<!-- Bootstrap Icons -->

<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<!-- External CSS -->

<link rel="stylesheet"
href="../../CSS/TEACHER/viewstudent.css">

</head>

<body>

<!-- ================= NAVBAR ================= -->

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">

    <div class="container-fluid px-4">

        <!-- LOGO -->

        <a class="navbar-brand fw-bold fs-3">

            <i class="bi bi-mortarboard-fill me-2"></i>

            Online Examination System

        </a>



        <!-- RIGHT SECTION -->

        <div class="d-flex align-items-center">

            <!-- BACK BUTTON -->

            <a href="/OnlineExaminationSystem/HTML/TEACHER/teacherdashboard.jsp"
   class="btn btn-light me-3">

                <i class="bi bi-arrow-left"></i>

                Back

            </a>

            <!-- ADMIN PROFILE -->

            <div class="admin-profile text-white fw-bold">

                <i class="bi bi-person-circle me-2"></i>

                <%= user %>

            </div>

            <!-- LOGOUT -->

            <!-- <a href="../../logout"
               class="btn btn-danger ms-3">

                <i class="bi bi-box-arrow-right"></i>

                Logout

            </a> -->

        </div>

    </div>

</nav>



<!-- ================= PAGE CONTAINER ================= -->

<div class="container-fluid page-container">

    <!-- PAGE TITLE -->

    <h1 class="page-title">

        VIEW STUDENT

    </h1>



    <!-- MAIN CARD -->

    <div class="card main-card">

        <!-- TOP SECTION -->

        <div class="top-box">

            <div class="left-box">

                <div class="icon-box">

                    <i class="bi bi-people-fill"></i>

                </div>

                <div>

                    <h3>Student Overview</h3>

                </div>

            </div>

        </div>

        <hr>



        <!-- TABLE SECTION -->

        <div class="table-responsive mt-5">

            <table class="table table-bordered align-middle">

                <thead>

                    <tr>

                        <th>ID</th>
                        <th>Student Name</th>
                        <th>Email</th>
                        <th>Mobile</th>
                        <th>Course</th>
                        <th>Status</th>
                        <th>UPDATE / DELETE</th>

                    </tr>

                </thead>

                <tbody>

                <%

                if(list != null && !list.isEmpty()){

                    for(UserModel m : list){

                %>

                    <tr>

                        <!-- USER ID -->

                        <td>

                            <%= m.getUserId() %>

                        </td>

                        <!-- USER NAME -->

                        <td>

                            <%= m.getUserName() %>

                        </td>

                        <!-- EMAIL -->

                        <td>

                            <%= m.getUserEmail() %>

                        </td>

                        <!-- MOBILE -->

                        <td>

                            <%= m.getUserMobile() %>

                        </td>

                        <!-- COURSE -->

                        <td>

                            <%= m.getCourseName() %>

                        </td>

                        <!-- STATUS -->

                        <td>

                            <span class="badge bg-success">

                                Active

                            </span>

                        </td>

                        <!-- ACTION BUTTONS -->

                        <td>

                            <!-- UPDATE -->

                            <a href="/OnlineExaminationSystem/updatestudent?id=<%=m.getUserId()%>"
                               class="btn btn-primary btn-sm me-2">

                                <i class="bi bi-pencil-fill"></i>

                            </a>

                            <!-- DELETE -->

                            <a href="/OnlineExaminationSystem/deletestudent?id=<%=m.getUserId()%>"
                               class="btn btn-danger btn-sm"
                               onclick="return confirm('Are you sure to delete this student?')">

                                <i class="bi bi-trash-fill"></i>

                            </a>

                        </td>

                    </tr>

                <%

                    }

                }else{

                %>

                    <!-- NO STUDENTS -->

                    <tr>

                        <td colspan="7"
                            class="text-center text-danger fw-bold">

                            No Students Found

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

    © 2026 Online Examination System | All Rights Reserved

</footer>



<!-- Bootstrap JS -->

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>