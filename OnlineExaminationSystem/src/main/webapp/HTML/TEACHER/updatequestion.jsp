<%@page import="org.onlineexam.model.QuestionModel"%>

<%
QuestionModel q =
(QuestionModel)request.getAttribute("question");
%>

<!DOCTYPE html>
<html>
<head>

<title>Update Question</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

</head>

<body>

<div class="container mt-5">

    <div class="card p-4">

        <h2 class="mb-4">

            Update Question

        </h2>

        <form action="/OnlineExaminationSystem/updatequestion"
              method="post">

            <input type="hidden"
                   name="questionId"
                   value="<%=q.getQuestionId()%>">

            <div class="mb-3">

                <label class="form-label">

                    Question
                </label>

                <textarea class="form-control"
                          name="question"><%=q.getQuestionText()%></textarea>

            </div>

            <div class="mb-3">

                <input type="text"
                       name="optionA"
                       class="form-control"
                       value="<%=q.getOptionA()%>">

            </div>

            <div class="mb-3">

                <input type="text"
                       name="optionB"
                       class="form-control"
                       value="<%=q.getOptionB()%>">

            </div>

            <div class="mb-3">

                <input type="text"
                       name="optionC"
                       class="form-control"
                       value="<%=q.getOptionC()%>">

            </div>

            <div class="mb-3">

                <input type="text"
                       name="optionD"
                       class="form-control"
                       value="<%=q.getOptionD()%>">

            </div>

            <div class="mb-3">

                <select class="form-select"
                        name="correctAnswer">

                    <option value="A">A</option>
                    <option value="B">B</option>
                    <option value="C">C</option>
                    <option value="D">D</option>

                </select>

            </div>

            <button type="submit"
                    class="btn btn-primary">

                UPDATE QUESTION

            </button>

        </form>

    </div>

</div>

</body>
</html>