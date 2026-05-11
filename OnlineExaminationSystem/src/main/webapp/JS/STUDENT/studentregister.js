/* ================= REGISTRATION VALIDATION ================= */

function validateForm()
{

    /* GET VALUES */

    let name = document.forms["regForm"]["name"].value;

    let email = document.forms["regForm"]["email"].value;

    let mobile = document.forms["regForm"]["mobile"].value;

    let course = document.forms["regForm"]["course"].value;

    let password = document.forms["regForm"]["password"].value;





    /* NAME VALIDATION */

    if(name=="")
    {

        alert("Please Enter Full Name");

        return false;
    }





    /* EMAIL VALIDATION */

    if(email=="")
    {

        alert("Please Enter Email");

        return false;
    }



    if(!email.includes("@"))
    {

        alert("Please Enter Valid Email");

        return false;
    }





    /* MOBILE VALIDATION */

    if(mobile=="")
    {

        alert("Please Enter Mobile Number");

        return false;
    }



    if(isNaN(mobile))
    {

        alert("Mobile Number Must Be Numeric");

        return false;
    }



    if(mobile.length != 10)
    {

        alert("Mobile Number Must Contain 10 Digits");

        return false;
    }





    /* COURSE VALIDATION */

    if(course=="")
    {

        alert("Please Select Course");

        return false;
    }





    /* PASSWORD VALIDATION */

    if(password=="")
    {

        alert("Please Enter Password");

        return false;
    }



    if(password.length < 6)
    {

        alert("Password Must Contain Minimum 6 Characters");

        return false;
    }





    /* SUCCESS */

    alert("Registration Successful");

    return true;
}