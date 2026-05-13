<%@page import="java.util.*" %>
    <%@page import="org.onlineexam.model.ExamModel" %>
        <%@page import="org.onlineexam.model.QuestionModel" %>

            <% String user=(String)session.getAttribute("user"); if(user==null){ response.sendRedirect("../Home.html");
                return; } List<ExamModel> exams =
                (List<ExamModel>)request.getAttribute("exams");

                    List<QuestionModel> questions =
                        (List<QuestionModel>)request.getAttribute("questions");
                            %>

                            <!DOCTYPE html>
                            <html lang="en">

                            <head>

                                <meta charset="UTF-8">

                                <meta name="viewport" content="width=device-width, initial-scale=1.0">

                                <title>Set Exam</title>

                                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
                                    rel="stylesheet">

                                <link rel="stylesheet"
                                    href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

                                <link rel="stylesheet" href="../../CSS/TEACHER/setexam.css">

                            </head>

                            <body>

                                <nav class="navbar navbar-expand-lg navbar-dark bg-primary">

                                    <div class="container-fluid px-4">

                                        <a class="navbar-brand fw-bold fs-3">

                                            <i class="bi bi-mortarboard-fill me-2"></i>

                                            Online Examination System

                                        </a>

                                        <div class="d-flex align-items-center">

                                            <a href="/OnlineExaminationSystem/HTML/TEACHER/teacherdashboard.jsp"
                                                class="btn btn-light me-3">

                                                <i class="bi bi-arrow-left"></i>

                                                Back
                                            </a>

                                            <div class="admin-profile text-white">

                                                <i class="bi bi-person-circle me-2"></i>

                                                <%= user %>

                                            </div>

                                        </div>

                                    </div>

                                </nav>

                                <div class="container-fluid page-container">

                                    <h1 class="page-title">

                                        SET QUESTIONS

                                    </h1>

                                    <div class="card main-card">

                                        <form action="/OnlineExaminationSystem/setquestion" method="post">

                                            <div class="mb-4">

                                                <label class="form-label fw-bold">

                                                    Select Exam

                                                </label>

                                                <select class="form-select" name="examId">

                                                    <option value="">
                                                        Select Exam
                                                    </option>

                                                    <% if(exams !=null){ for(ExamModel e : exams){ %>

                                                        <option value="<%=e.getExamId()%>">

                                                            <%=e.getExamTitle()%>

                                                        </option>

                                                        <% } } %>

                                                </select>

                                            </div>

                                            <div class="mb-4">

                                                <label class="form-label fw-bold">

                                                    Question

                                                </label>

                                                <textarea class="form-control" name="question"></textarea>

                                            </div>

                                            <div class="row">

                                                <div class="col-md-6 mb-3">

                                                    <input type="text" name="optionA" class="form-control"
                                                        placeholder="Option A">

                                                </div>

                                                <div class="col-md-6 mb-3">

                                                    <input type="text" name="optionB" class="form-control"
                                                        placeholder="Option B">

                                                </div>

                                                <div class="col-md-6 mb-3">

                                                    <input type="text" name="optionC" class="form-control"
                                                        placeholder="Option C">

                                                </div>

                                                <div class="col-md-6 mb-3">

                                                    <input type="text" name="optionD" class="form-control"
                                                        placeholder="Option D">

                                                </div>

                                            </div>

                                            <div class="mb-4">

                                                <label class="form-label fw-bold">

                                                    Correct Answer

                                                </label>

                                                <select class="form-select" name="correctAnswer">

                                                    <option value="A">Option A</option>
                                                    <option value="B">Option B</option>
                                                    <option value="C">Option C</option>
                                                    <option value="D">Option D</option>

                                                </select>

                                            </div>

                                            <button type="submit" class="btn btn-primary">

                                                ADD QUESTION

                                            </button>

                                        </form>

                                    </div>

                                    <div class="card table-card mt-5 p-4">

                                        <h3>
                                            Added Questions
                                        </h3>

                                        <div class="table-responsive">

                                            <table class="table table-bordered">

                                                <thead>

                                                    <tr>

                                                        <th>ID</th>
                                                        <th>Exam</th>
                                                        <th>Question</th>
                                                        <th>Options</th>
                                                        <th>Correct</th>
                                                        <th>Action</th>

                                                    </tr>

                                                </thead>

                                                <tbody>

                                                    <% if(questions !=null && questions.size()> 0){

                                                        for(QuestionModel q : questions){
                                                        %>

                                                        <tr>

                                                            <td>
                                                                <%=q.getQuestionId()%>
                                                            </td>

                                                            <td>
                                                                <%=q.getExamTitle()%>
                                                            </td>

                                                            <td>
                                                                <%=q.getQuestionText()%>
                                                            </td>

                                                            <td>

                                                                <b>A.</b>
                                                                <%=q.getOptionA()%>
                                                                    <br>

                                                                    <b>B.</b>
                                                                    <%=q.getOptionB()%>
                                                                        <br>

                                                                        <b>C.</b>
                                                                        <%=q.getOptionC()%>
                                                                            <br>

                                                                            <b>D.</b>
                                                                            <%=q.getOptionD()%>

                                                            </td>

                                                            <td>

                                                                <span class="badge bg-success">

                                                                    <%=q.getCorrectAnswer()%>

                                                                </span>

                                                            </td>

                                                            <td>

                                                                <!-- UPDATE BUTTON -->

                                                                <a href="/OnlineExaminationSystem/editquestionpage?id=<%=q.getQuestionId()%>"
                                                                    class="btn btn-primary btn-sm me-2">

                                                                    <i class="bi bi-pencil-fill"></i>

                                                                </a>

                                                                <!-- DELETE BUTTON -->

                                                                <a href="/OnlineExaminationSystem/deletequestion?id=<%=q.getQuestionId()%>"
                                                                    class="btn btn-danger btn-sm"
                                                                    onclick="return confirm('Are you sure you want to delete this question?')">

                                                                    <i class="bi bi-trash-fill"></i>

                                                                </a>

                                                            </td>

                                                        </tr>

                                                        <% } }else{ %>

                                                            <tr>

                                                                <td colspan="6" class="text-center text-danger fw-bold">

                                                                    No Questions Added Yet

                                                                </td>

                                                            </tr>

                                                            <% } %>

                                                </tbody>

                                            </table>

                                        </div>

                                    </div>
                                </div>

                            </body>

                            </html>