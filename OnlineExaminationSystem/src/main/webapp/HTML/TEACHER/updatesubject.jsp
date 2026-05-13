<%@page import="org.onlineexam.model.SubjectModel"%>

<%
SubjectModel subject = (SubjectModel)request.getAttribute("subject");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Subject</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

</head>

<body>

<div class="container mt-5">

    <div class="card p-4">

        <h2 class="mb-4">Update Subject</h2>

        <form action="/OnlineExaminationSystem/updatesubject"
              method="post">

            <!-- IMPORTANT HIDDEN FIELD -->

            <input type="hidden"
                   name="subjectId"
                   value="<%=subject.getSubjectId()%>">

            <!-- SUBJECT NAME -->

            <div class="mb-3">

                <label class="form-label">
                    Subject Name
                </label>

                <input type="text"
                       name="subjectName"
                       class="form-control"
                       value="<%=subject.getSubjectName()%>">

            </div>

            <!-- COURSE ID -->

            <div class="mb-3">

                <label class="form-label">
                    Course ID
                </label>

                <input type="number"
                       name="courseId"
                       class="form-control"
                       value="<%=subject.getCourseId()%>">

            </div>

            <button type="submit"
                    class="btn btn-primary">

                Update Subject

            </button>

        </form>

    </div>

</div>

</body>
</html>