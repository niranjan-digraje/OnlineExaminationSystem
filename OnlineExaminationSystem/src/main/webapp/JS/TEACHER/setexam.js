/* ================= SET EXAM PAGE ================= */

console.log("Set Exam Page Loaded Successfully");



/* ================= ADD OPTION ================= */

function addOption()
{

    let optionContainer =
    document.getElementById("optionContainer");



    let optionCount =
    optionContainer.children.length + 1;



    if(optionCount > 6)
    {

        alert("Maximum 6 Options Allowed");

        return;
    }



    let optionDiv =
    document.createElement("div");



    optionDiv.className =
    "option-box";



    optionDiv.innerHTML = `

        <input type="radio" name="answer">

        <input type="text"
               class="form-control option-text"
               placeholder="Enter option ${optionCount}">

    `;



    optionContainer.appendChild(optionDiv);

}



/* ================= ADD QUESTION ================= */

function addQuestion(event)
{

    event.preventDefault();



    /* ================= SELECT EXAM VALIDATION ================= */

    let selectedExam =
    document.getElementById("selectedExam").value;



    if(selectedExam == "")
    {

        alert("Please Select Exam");

        return;
    }



    /* ================= QUESTION VALIDATION ================= */

    let question =
    document.getElementById("question").value;



    if(question == "")
    {

        alert("Please Enter Question");

        return;
    }



    /* ================= OPTIONS VALIDATION ================= */

    let options =
    document.querySelectorAll(".option-text");



    let optionValues = [];



    for(let i = 0; i < options.length; i++)
    {

        if(options[i].value == "")
        {

            alert("Please Fill All Options");

            return;
        }



        optionValues.push(options[i].value);

    }



    /* ================= CORRECT OPTION VALIDATION ================= */

    let correctOption =
    document.querySelector('input[name="answer"]:checked');



    if(correctOption == null)
    {

        alert("Please Select Correct Option");

        return;
    }



    let correctIndex =
    Array.from(document.querySelectorAll('input[name="answer"]'))
    .indexOf(correctOption);



    /* ================= TABLE ================= */

    let table =
    document.getElementById("questionTable");



    /* REMOVE EMPTY ROW */

    let emptyRow =
    document.getElementById("emptyRow");



    if(emptyRow)
    {

        emptyRow.remove();

    }



    /* ================= INSERT ROW ================= */

    let row =
    table.insertRow();



    row.innerHTML = `

        <td>${table.rows.length}</td>

        <td>${selectedExam}</td>

        <td>${question}</td>

        <td>${optionValues.join("<br>")}</td>

        <td>${optionValues[correctIndex]}</td>

        <td>

            <button class="btn btn-danger btn-sm"
                    onclick="deleteQuestion(this)">

                <i class="bi bi-trash-fill"></i>

            </button>

        </td>

    `;



    /* ================= RESET FORM ================= */

    document.getElementById("questionForm").reset();



    alert("Question Added Successfully");

}



/* ================= DELETE QUESTION ================= */

function deleteQuestion(button)
{

    let confirmDelete =
    confirm("Are You Sure You Want To Delete This Question ?");



    if(confirmDelete)
    {

        let row =
        button.parentElement.parentElement;

        row.remove();

    }

}