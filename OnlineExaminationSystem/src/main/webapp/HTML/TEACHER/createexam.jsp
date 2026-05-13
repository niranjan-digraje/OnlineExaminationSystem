<%@page import="java.util.*" %>
    <%@page import="org.onlineexam.model.SubjectModel" %>

        <% String user=(String)session.getAttribute("user"); if(user==null){ response.sendRedirect("../Home.html");
            return; } List<SubjectModel> subjects =
            (List<SubjectModel>)request.getAttribute("subjects");
                %>

                <!DOCTYPE html>
                <html lang="en">

                <head>

                    <meta charset="UTF-8">

                    <meta name="viewport" content="width=device-width, initial-scale=1.0">

                    <title>Create Exam</title>

                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
                        rel="stylesheet">

                    <link rel="stylesheet"
                        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

                    <link rel="stylesheet" href="../../CSS/TEACHER/createexam.css">

                </head>

                <body>

                    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">

                        <div class="container-fluid px-4">

                            <a class="navbar-brand fw-bold fs-3">

                                <i class="bi bi-mortarboard-fill me-2"></i>

                                Online Examination System

                            </a>

                            <div class="d-flex align-items-center">

                                <a href="teacherdashboard.jsp" class="btn btn-light me-3">

                                    <i class="bi bi-arrow-left"></i>

                                    Back
                                </a>

                                <div class="admin-profile text-white">

                                    <i class="bi bi-person-circle me-2"></i>

                                    <%=user%>
                                </div>

                                <a href="../../logout" class="btn btn-danger ms-3">

                                    Logout
                                </a>

                            </div>

                        </div>

                    </nav>

                    <div class="container-fluid page-container">

                        <h1 class="page-title">

                            CREATE EXAM

                        </h1>

                        <div class="card main-card">

                            <div class="top-box">

                                <div class="left-box">

                                    <div class="icon-box">

                                        <i class="bi bi-file-earmark-plus-fill"></i>

                                    </div>

                                    <div>

                                        <h3>Create New Exam</h3>

                                    </div>

                                </div>

                            </div>

                            <hr>

                            <form action="/OnlineExaminationSystem/createexam" method="post">

                                <div class="row g-4">

                                    <div class="col-md-6">

                                        <label class="form-label fw-bold">
                                            Exam Name
                                        </label>

                                        <input type="text" name="examTitle" class="form-control">
                                    </div>

                                    <div class="col-md-6">

                                        <label class="form-label fw-bold">
                                            Select Subject
                                        </label>

                                        <select class="form-select" name="subjectId">

                                            <option value="">
                                                Select Subject
                                            </option>

                                            <% if(subjects !=null){ for(SubjectModel s : subjects){ %>

                                                <option value="<%=s.getSubjectId()%>">

                                                    <%=s.getSubjectName()%>

                                                </option>

                                                <% } } %>

                                        </select>
                                    </div>

                                    <div class="col-md-6">

                                        <label>Total Questions</label>

                                        <input type="number" name="totalQuestions" class="form-control">
                                    </div>

                                    <div class="col-md-6">

                                        <label>Total Marks</label>

                                        <input type="number" name="totalMarks" class="form-control">
                                    </div>

                                    <div class="col-md-6">

                                        <label>Duration</label>

                                        <input type="number" name="duration" class="form-control">
                                    </div>

                                    <div class="col-md-6">

                                        <label>Exam Date</label>

                                        <input type="date" name="examDate" class="form-control">
                                    </div>

                                    <div class="col-md-6">

                                        <label>Start Time</label>

                                        <input type="time" name="startTime" class="form-control">
                                    </div>

                                    <div class="col-md-6">

                                        <label>End Time</label>

                                        <input type="time" name="endTime" class="form-control">
                                    </div>

                                </div>

                                <div class="button-box mt-4">

                                    <button class="btn btn-primary">

                                        CREATE EXAM

                                    </button>

                                </div>

                            </form>

                        </div>

                    </div>

                    <footer>

                        � 2026 Online Examination System

                    </footer>

                </body>

                </html>