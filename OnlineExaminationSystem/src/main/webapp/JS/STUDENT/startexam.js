let minutes = 45;
let seconds = 30;

function startTimer()
{

    let timer =
    document.getElementById("timer");



    let interval =
    setInterval(function(){

        if(seconds == 0)
        {

            if(minutes == 0)
            {

                clearInterval(interval);

                alert("Time Over!");

                return;
            }

            minutes--;

            seconds = 59;

        }
        else
        {

            seconds--;

        }



        let min =
        minutes < 10 ? "0"+minutes : minutes;

        let sec =
        seconds < 10 ? "0"+seconds : seconds;



        timer.innerHTML =
        "00 : " + min + " : " + sec;

    },1000);

}

startTimer();

let optionBoxes =
document.querySelectorAll(".option-box");



optionBoxes.forEach(function(box){

    box.addEventListener("click",function(){

        optionBoxes.forEach(function(removeBox){

            removeBox.classList.remove("active-option");

        });

        this.classList.add("active-option");



        let radio =
        this.querySelector("input[type='radio']");

        radio.checked = true;

    });

});


let submitBtn =
document.querySelector(".submit-btn");



submitBtn.addEventListener("click",function(){

    let confirmSubmit =
    confirm("Are you sure you want to submit exam ?");



    if(confirmSubmit)
    {

        alert("Exam Submitted Successfully");

        window.location.href =
        "viewresult.html";

    }

});