


<%@page import="java.util.*"%>
<%@page import="org.onlineexam.model.ExamModel"%>
<%@page import="org.onlineexam.model.QuestionModel"%>

<%
String studentName =
(String)session.getAttribute("user");

if(studentName == null){

    response.sendRedirect("../Home.html");

    return;
}

ExamModel examModel =
(ExamModel)request.getAttribute("exam");

List<QuestionModel> questions =
(List<QuestionModel>)request.getAttribute("questions");
%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>Start Exam</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
}

body{
    background:#f4f6f9;
    font-family:Arial, Helvetica, sans-serif;
}

/* NAVBAR */

.navbar{
    background:#0b8f53;
    padding:18px;
}

.navbar-brand{
    font-size:22px;
    font-weight:bold;
}

.student-profile{
    font-size:20px;
    font-weight:bold;
}

/* INFO SECTION */

.exam-info-section{
    padding:20px;
}

.info-card{
    background:white;
    border-radius:15px;
    padding:25px;
    display:flex;
    align-items:center;
    gap:20px;
    box-shadow:0px 2px 10px rgba(0,0,0,0.08);
}

.info-card i{
    font-size:40px;
    color:#0b8f53;
}

.info-card span{
    color:gray;
    font-size:16px;
}

.info-card h5{
    font-size:32px;
    font-weight:bold;
    margin-top:8px;
}

.timer-text{
    color:red;
}

/* QUESTION BOX */

.question-box{
    background:white;
    border-radius:18px;
    padding:40px;
    margin:20px;
    box-shadow:0px 2px 10px rgba(0,0,0,0.08);
}

.question-title{
    color:#0b8f53;
    font-size:30px;
    font-weight:bold;
}

.question-text{
    margin-top:25px;
    margin-bottom:35px;
    font-size:45px;
    font-weight:bold;
}

/* OPTIONS */

.option-box{
    border:2px solid #ddd;
    border-radius:12px;
    padding:20px;
    margin-bottom:18px;
    display:flex;
    align-items:center;
    gap:18px;
    cursor:pointer;
    transition:0.3s;
}

.option-box:hover{
    border-color:#0b8f53;
}

.option-box input[type="radio"]{
    width:22px;
    height:22px;
}

.option-box label{
    font-size:28px;
    cursor:pointer;
}

.active-option{
    border-color:#0b8f53;
    background:#eef8f3;
}

/* BUTTONS */

.exam-buttons{
    margin-top:40px;
    display:flex;
    justify-content:space-between;
    align-items:center;
}

.prev-btn{
    width:180px;
    height:55px;
    border-radius:12px;
    font-size:20px;
}

.next-btn{
    width:160px;
    height:55px;
    border-radius:12px;
    font-size:20px;
    background:#0b8f53;
    border:none;
}

.submit-btn{
    width:230px;
    height:55px;
    border-radius:12px;
    font-size:20px;
    border:none;
}

/* FOOTER */

footer{
    background:white;
    text-align:center;
    padding:20px;
    margin-top:30px;
    box-shadow:0px -2px 10px rgba(0,0,0,0.08);
}

/* MOBILE */

@media(max-width:768px){

    .question-text{
        font-size:28px;
    }

    .option-box label{
        font-size:20px;
    }

    .exam-buttons{
        flex-direction:column;
        gap:20px;
    }
}

</style>

</head>

<body>

<!-- NAVBAR -->

<nav class="navbar navbar-expand-lg navbar-dark">

    <div class="container-fluid">

        <a class="navbar-brand">

            <i class="bi bi-mortarboard-fill me-2"></i>

            Online Examination System

        </a>

        <div class="student-profile text-white">

            <i class="bi bi-person-circle me-2"></i>

            <%=studentName%>

        </div>

    </div>

</nav>

<!-- INFO SECTION -->

<div class="container-fluid exam-info-section">

    <div class="row g-4">

        <div class="col-md-3">

            <div class="info-card">

                <i class="bi bi-card-checklist"></i>

                <div>

                    <span>Exam Name</span>

                    <h5>

                        <%=examModel.getExamTitle()%>

                    </h5>

                </div>

            </div>

        </div>

        <div class="col-md-3">

            <div class="info-card">

                <i class="bi bi-list-task"></i>

                <div>

                    <span>Total Questions</span>

                    <h5>

                        <%=examModel.getTotalQuestions()%>

                    </h5>

                </div>

            </div>

        </div>

        <div class="col-md-3">

            <div class="info-card">

                <i class="bi bi-trophy-fill"></i>

                <div>

                    <span>Total Marks</span>

                    <h5>

                        <%=examModel.getTotalMarks()%>

                    </h5>

                </div>

            </div>

        </div>

        <div class="col-md-3">

            <div class="info-card">

                <i class="bi bi-clock-history"></i>

                <div>

                    <span>Time Left</span>

                    <h5 id="timer"
                        class="timer-text">

                        00 : 00 : 00

                    </h5>

                </div>

            </div>

        </div>

    </div>

</div>

<!-- QUESTION SECTION -->

<div class="container-fluid">

    <div class="question-box">

        <form action="/OnlineExaminationSystem/submitexam"
      method="post"
      id="examForm">

    <input type="hidden"
           name="examId"
           value="<%=examModel.getExamId()%>">

    <input type="hidden"
           name="totalMarks"
           value="<%=examModel.getTotalMarks()%>">
           

            <%
            int count = 1;

            for(QuestionModel q : questions){
            %>

            <div class="question-item"
                 <%=count != 1 ? "style='display:none'" : ""%>>

                <h5 class="question-title">

                    Question <%=count%> of <%=questions.size()%>

                </h5>

                <h2 class="question-text">

                    <%=q.getQuestionText()%>

                </h2>

                <!-- OPTION A -->

                <div class="option-box">

                    <input type="radio"
                           name="answer_<%=q.getQuestionId()%>"
                           value="A">

                    <label>

                        <%=q.getOptionA()%>

                    </label>

                </div>

                <!-- OPTION B -->

                <div class="option-box">

                    <input type="radio"
                           name="answer_<%=q.getQuestionId()%>"
                           value="B">

                    <label>

                        <%=q.getOptionB()%>

                    </label>

                </div>

                <!-- OPTION C -->

                <div class="option-box">

                    <input type="radio"
                           name="answer_<%=q.getQuestionId()%>"
                           value="C">

                    <label>

                        <%=q.getOptionC()%>

                    </label>

                </div>

                <!-- OPTION D -->

                <div class="option-box">

                    <input type="radio"
                           name="answer_<%=q.getQuestionId()%>"
                           value="D">

                    <label>

                        <%=q.getOptionD()%>

                    </label>

                </div>

            </div>

            <%
            count++;
            }
            %>

            <!-- BUTTONS -->

            <div class="exam-buttons">

                <button type="button"
                        class="btn btn-outline-secondary prev-btn"
                        onclick="previousQuestion()">

                    <i class="bi bi-arrow-left me-2"></i>

                    Previous

                </button>

                <div>

                    <button type="submit"
                            class="btn btn-danger submit-btn">

                        <i class="bi bi-send-fill me-2"></i>

                        Submit Exam

                    </button>

                    <button type="button"
                            class="btn btn-success next-btn ms-3"
                            onclick="nextQuestion()">

                        Next

                        <i class="bi bi-arrow-right ms-2"></i>

                    </button>

                </div>

            </div>

        </form>

    </div>

</div>

<footer>

    © 2026 Online Examination System | All Rights Reserved

</footer>

<script>

/* QUESTION NAVIGATION */

let currentQuestion = 0;

let questionItems =
document.querySelectorAll(".question-item");

function showQuestion(index){

    questionItems.forEach(function(item){

        item.style.display = "none";

    });

    questionItems[index].style.display = "block";
}

function nextQuestion(){

    if(currentQuestion < questionItems.length - 1){

        currentQuestion++;

        showQuestion(currentQuestion);
    }
}

function previousQuestion(){

    if(currentQuestion > 0){

        currentQuestion--;

        showQuestion(currentQuestion);
    }
}

/* OPTION ACTIVE */

document.querySelectorAll(".option-box")
.forEach(function(box){

    box.addEventListener("click",function(){

        let parent =
        this.parentElement;

        parent.querySelectorAll(".option-box")
        .forEach(function(removeBox){

            removeBox.classList.remove("active-option");

        });

        this.classList.add("active-option");

        let radio =
        this.querySelector("input[type='radio']");

        radio.checked = true;

    });

});

/* TIMER */

// let minutes = (exam != null)
//                                 ? exam.getDurationMinutes()
//                                 : 0 ;



let duration =
"<%= examModel.getDurationMinutes() %>";

let minutes =
parseInt(duration);

if(isNaN(minutes))
{
    minutes = 0;
}

let seconds = 0;

const timer =
document.getElementById("timer");

function updateTimer()
{
    let min =
    minutes < 10 ? "0" + minutes : minutes;

    let sec =
    seconds < 10 ? "0" + seconds : seconds;

    timer.innerHTML =
    "00 : " + min + " : " + sec;
}

updateTimer();

let interval =
setInterval(function(){

    if(minutes === 0 && seconds === 0)
    {
        clearInterval(interval);

        alert("Time Over! Exam Submitted Automatically.");

        document.getElementById("examForm").submit();

        return;
    }

    if(seconds === 0)
    {
        minutes--;
        seconds = 59;
    }
    else
    {
        seconds--;
    }

    updateTimer();

},1000);


</script>

</body>

</html>