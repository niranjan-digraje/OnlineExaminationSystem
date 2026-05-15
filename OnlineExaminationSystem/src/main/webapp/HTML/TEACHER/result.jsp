<%@page import="java.util.*"%>
<%@page import="org.onlineexam.model.ResultModel"%>

<%
List<ResultModel> list =
(List<ResultModel>)request.getAttribute("results");
%>

<!DOCTYPE html>
<html>
<head>

<title>Results</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
rel="stylesheet">

</head>

<body>

<div class="container mt-5">
    <a href="/OnlineExaminationSystem/HTML/TEACHER/teacherdashboard.jsp"
               class="btn btn-light me-3">

                <i class="bi bi-arrow-left"></i>

                Back

            </a>
    <h2 class="mb-4">
        Result List
    </h2>

    <table class="table table-bordered">

        <thead class="table-dark">

            <tr>

                <th>Result ID</th>
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
        if(list != null){

            for(ResultModel r : list){
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
                    if(r.getResultStatus().equals("PASS")){
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

</body>
</html>