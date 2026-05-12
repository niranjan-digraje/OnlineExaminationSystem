/* ================= CREATE EXAM VALIDATION ================= */

function validateExamForm()
{

    /* GET VALUES */

    let examName =
    document.forms["examForm"]["examName"].value;

    let subject =
    document.forms["examForm"]["subject"].value;

    let totalMarks =
    document.forms["examForm"]["totalMarks"].value;

    let passingMarks =
    document.forms["examForm"]["passingMarks"].value;

    let examDate =
    document.forms["examForm"]["examDate"].value;

    let examTime =
    document.forms["examForm"]["examTime"].value;

    let duration =
    document.forms["examForm"]["duration"].value;



    /* EXAM NAME */

    if(examName == "")
    {

        alert("Please Enter Exam Name");

        return false;
    }



    /* SUBJECT */

    if(subject == "")
    {

        alert("Please Select Subject");

        return false;
    }



    /* TOTAL MARKS */

    if(totalMarks == "")
    {

        alert("Please Enter Total Marks");

        return false;
    }



    if(totalMarks <= 0)
    {

        alert("Total Marks Must Be Greater Than 0");

        return false;
    }



    /* PASSING MARKS */

    if(passingMarks == "")
    {

        alert("Please Enter Passing Marks");

        return false;
    }



    if(Number(passingMarks) > Number(totalMarks))
    {

        alert("Passing Marks Cannot Be Greater Than Total Marks");

        return false;
    }



    /* EXAM DATE */

    if(examDate == "")
    {

        alert("Please Select Exam Date");

        return false;
    }



    /* EXAM TIME */

    if(examTime == "")
    {

        alert("Please Select Exam Time");

        return false;
    }



    /* DURATION */

    if(duration == "")
    {

        alert("Please Enter Exam Duration");

        return false;
    }



    if(duration <= 0)
    {

        alert("Duration Must Be Greater Than 0");

        return false;
    }



    /* SUCCESS */

    alert("Exam Created Successfully");

    return true;
}