<%@page import="java.util.*"%>
<%@page import="org.onlineexam.model.ResultModel"%>

<%

String user =
(String)session.getAttribute("user");

if(user == null){

    response.sendRedirect("../../Home.html");
    return;
}

List<ResultModel> results =
(List<ResultModel>)request.getAttribute("results");

%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>View Result</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>

<body>

<nav class="navbar navbar-dark bg-success">

    <div class="container-fluid px-4">

        <a class="navbar-brand fw-bold fs-3">

            Online Examination System

        </a>

        <div class="text-white">

            <i class="bi bi-person-circle"></i>

            <%=user%>

        </div>

    </div>

</nav>

<div class="container mt-5">

    <h2 class="mb-4 text-center">

        Exam Results

    </h2>

    <div class="table-responsive">

        <table class="table table-bordered table-hover">

            <thead class="table-success">

                <tr>

                    <th>ID</th>
                    <th>Student Name</th>
                    <th>Exam Name</th>
                    <th>Obtained Marks</th>
                    <th>Total Marks</th>
                    <th>Percentage</th>
                    <th>Status</th>

                </tr>

            </thead>

            <tbody>

            <%

            if(results != null){

                for(ResultModel r : results){

            %>

                <tr>

                    <td>
                        <%=r.getResultId()%>
                    </td>

                    <td>
                        <%=r.getUserName()%>
                    </td>

                    <td>
                        <%=r.getExamTitle()%>
                    </td>

                    <td>
                        <%=r.getObtainedMarks()%>
                    </td>

                    <td>
                        <%=r.getTotalMarks()%>
                    </td>

                    <td>
                        <%=r.getPercentage()%>%
                    </td>

                    <td>

                    <%

                    if(r.getResultStatus()
                    .equalsIgnoreCase("PASS")){
                    %>

                    <span class="badge bg-success">

                        PASS

                    </span>

                    <%
                    } else {
                    %>

                    <span class="badge bg-danger">

                        FAIL

                    </span>

                    <%
                    }
                    %>

                    </td>

                </tr>

            <%
                }
            }
            %>

            </tbody>

        </table>

    </div>

</div>

</body>
</html>