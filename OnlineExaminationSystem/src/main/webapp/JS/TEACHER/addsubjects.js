function validateSubjectForm()
{
    let subjectName = document.forms["subjectForm"]["subjectName"].value;
    let subjectCode = document.forms["subjectForm"]["subjectCode"].value;

    if(subjectName == "")
    {
        alert("Please enter subject name");
        return false;
    }

    if(subjectCode == "")
    {
        alert("Please enter subject code");
        return false;
    }

    alert("Subject added successfully");
    return true;
}