<%@page import="java.util.*"%>
<%@page import="org.onlineexam.model.CourseModel"%>
<%@page import="org.onlineexam.model.SubjectModel"%>

<%
SubjectModel subject =
(SubjectModel)request.getAttribute("subject");

List<CourseModel> courses =
(List<CourseModel>)request.getAttribute("courses");

String user =
(String)session.getAttribute("user");

if(user == null){
    response.sendRedirect("../Home.html");
    return;
}
%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>Update Subject</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>

<body style="background:#f5f5f5;">

<nav class="navbar navbar-dark bg-primary">

    <div class="container-fluid">

        <a class="navbar-brand fw-bold fs-3">

            Online Examination System

        </a>

        <div class="d-flex align-items-center">

            <span class="text-white fw-bold me-3">

                <i class="bi bi-person-circle"></i>

                <%=user%>

            </span>

            <a href="/OnlineExaminationSystem/logout"
               class="btn btn-danger">

                Logout

            </a>

        </div>

    </div>

</nav>

<div class="container mt-5">

    <div class="card shadow p-4">

        <h2 class="text-center text-primary mb-4">

            UPDATE SUBJECT

        </h2>

        <form action="/OnlineExaminationSystem/updatesubject"
              method="post">

            <input type="hidden"
                   name="subjectId"
                   value="<%=subject.getSubjectId()%>">

            <!-- SUBJECT NAME -->

            <div class="mb-4">

                <label class="form-label fw-bold">

                    Subject Name

                </label>

                <input type="text"
                       name="subjectName"
                       value="<%=subject.getSubjectName()%>"
                       class="form-control"
                       required>

            </div>

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
                    for(CourseModel c : courses){
                    %>

                    <option value="<%=c.getCourseId()%>"

                    <%
                    if(c.getCourseId()
                    == subject.getCourseId()){
                    %>

                    selected

                    <%
                    }
                    %>
                    >

                    <%=c.getCourseName()%>

                    </option>

                    <%
                    }
                    %>

                </select>

            </div>

            <!-- BUTTON -->

            <div class="text-center">

                <button type="submit"
                        class="btn btn-primary px-5">

                    <i class="bi bi-pencil-square"></i>

                    Update Subject

                </button>

                <a href="/OnlineExaminationSystem/addsubject"
                   class="btn btn-secondary px-5">

                    Back

                </a>

            </div>

        </form>

    </div>

</div>

</body>

</html>