/* ================= LOGIN VALIDATION ================= */

function validateLogin()
{

    let email = document.getElementById("email").value;

    let password = document.getElementById("password").value;



    /* EMAIL EMPTY */

    if(email=="")
    {

        alert("Please Enter Email Id");

        return false;
    }



    /* PASSWORD EMPTY */

    if(password=="")
    {

        alert("Please Enter Password");

        return false;
    }



    /* PASSWORD LENGTH */

    if(password.length < 6)
    {

        alert("Password must contain minimum 6 characters");

        return false;
    }



    return true;
}