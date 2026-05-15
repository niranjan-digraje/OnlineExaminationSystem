<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    // Fetch Session Data

    String user =
    (String) session.getAttribute("user");

    // Session Validation

    if(user == null){

        response.sendRedirect("../Home.html");

        return;
    }
%>
        <!DOCTYPE html>
        <html lang="en">

        <head>

            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">

            <title>Admin Dashboard</title>

            <!-- Bootstrap CSS -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

            <!-- Bootstrap Icons -->
            <link rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

            <!-- External CSS -->
            <link rel="stylesheet" href="../../CSS/TEACHER/teacherdashboard.css">

        </head>

        <body>

            <!-- ================= NAVBAR START ================= -->

            <nav class="navbar navbar-expand-lg navbar-dark bg-primary">

                <div class="container-fluid px-4">

                    <!-- LOGO -->

                    <a class="navbar-brand fw-bold fs-3">

                        <i class="bi bi-mortarboard-fill me-2"></i>

                        Online Examination System

                    </a>



                    <!-- ADMIN PROFILE -->

                    <div class="admin-profile text-white d-flex align-items-center">

                        <i class="bi bi-person-circle me-2 fs-4"></i>

                        <span class="me-3 fw-bold">
                            <%= user %>
                        </span>

                        <a href="../../logout" class="btn btn-danger btn-sm">

                            <i class="bi bi-box-arrow-right"></i>

                            Logout
                        </a>

                    </div>

                </div>

            </nav>

            <!-- ================= NAVBAR END ================= -->



            <!-- ================= MAIN SECTION ================= -->

            <div class="container dashboard-container">

                <!-- TITLE -->

                <h1 class="dashboard-title">

                    ADMIN DASHBOARD

                </h1>



                <!-- DASHBOARD ROW -->

                <div class="row g-4 mt-4">



                    <!-- ADD STUDENT -->

                    <div class="col-md-6">

                        <div class="dashboard-card">

                            <div class="card-left">

                                <i class="bi bi-person-plus-fill dashboard-icon"></i>

                            </div>



                            <div class="card-center">

                                <h3>ADD STUDENT</h3>

                            </div>



                            <div class="card-right">

                                <a href="../STUDENT/studentregistrationform.html">
                                    <i class="bi bi-arrow-right-circle-fill arrow-icon"></i>
                                </a>

                            </div>

                        </div>

                    </div>



                    <!-- ADD SUBJECT -->

                    <div class="col-md-6">

                        <div class="dashboard-card">

                            <div class="card-left">

                                <i class="bi bi-book-fill dashboard-icon"></i>

                            </div>



                            <div class="card-center">

                                <h3>ADD SUBJECT</h3>

                            </div>



                            <div class="card-right">

                                <a href="/OnlineExaminationSystem/loadsubjectpage">
                                    <i class="bi bi-arrow-right-circle-fill arrow-icon"></i>
                                </a>

                            </div>

                        </div>

                    </div>



                    <!-- CREATE EXAM -->

                    <div class="col-md-6">

                        <div class="dashboard-card">

                            <div class="card-left">

                                <i class="bi bi-file-earmark-plus-fill dashboard-icon"></i>

                            </div>



                            <div class="card-center">

                                <h3>CREATE EXAM</h3>

                            </div>



                            <div class="card-right">

                                <a href="/OnlineExaminationSystem/createexampage">
                                    <i class="bi bi-arrow-right-circle-fill arrow-icon"></i>
                                </a>
                            </div>

                        </div>

                    </div>



                    <!-- SET EXAMS -->

                    <div class="col-md-6">

                        <div class="dashboard-card">

                            <div class="card-left">

                                <i class="bi bi-clipboard-data-fill dashboard-icon"></i>

                            </div>



                            <div class="card-center">

                                <h3>SET QUESTIONS</h3>

                            </div>



                            <div class="card-right">

                                <a href="/OnlineExaminationSystem/setquestion">
                                    <i class="bi bi-arrow-right-circle-fill arrow-icon"></i>
                                </a>
                            </div>

                        </div>

                    </div>


                    <!-- VIEW STUDENT -->

                    <div class="col-md-6">

                        <div class="dashboard-card">

                            <div class="card-left">

                                <i class="bi bi-people-fill dashboard-icon"></i>

                            </div>



                            <div class="card-center">

                                <h3>VIEW STUDENT</h3>

                            </div>



                            <div class="card-right">

                                <a href="/OnlineExaminationSystem/viewstudents">
                                    <i class="bi bi-arrow-right-circle-fill arrow-icon"></i>
                                </a>
                            </div>

                        </div>

                    </div>



                    <!-- VIEW RESULT -->

                    <div class="col-md-6">

                        <div class="dashboard-card">

                            <div class="card-left">

                                <i class="bi bi-bar-chart-fill dashboard-icon"></i>

                            </div>



                            <div class="card-center">

                                <h3>VIEW RESULT</h3>

                            </div>



                            <div class="card-right">

                                <a href="/OnlineExaminationSystem/viewadminresult">
                                    <i class="bi bi-arrow-right-circle-fill arrow-icon"></i>
                                </a>
                            </div>

                        </div>

                    </div>



                </div>

            </div>



            <!-- ================= FOOTER ================= -->

            <footer> © 2026 Online Examination System | All Rights Reserved </footer>


            <!-- Bootstrap JS -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

            <!-- External JS -->
            <script src="../../JS/TEACHER/teacherdashboard.js"></script>

        </body>

        </html>