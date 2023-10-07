const pwd = document.getElementById("passwordS");
const confirmPwd = document.getElementById("passwordSConfirm");
const inputBox = document.getElementById("input-box");
const inputLable = document.getElementById("input-lable");
function validateSignin() {
    if (pwd.value != confirmPwd.value){
        inputBox.style.borderBottom = "3px solid red";
        inputLable.style.color = "red";
    } else if (pwd.value == confirmPwd.value){
        inputBox.style.borderBottom = "2px solid white";
        inputLable.style.color = "white";
    }

}

const pwd2 = document.getElementById("pwd");
const confirmPwd2 = document.getElementById("confirmPwd");

function validate() {
    if (pwd2.value != confirmPwd2.value){
        confirmPwd2.style.background = "red";
    } else if (pwd2.value == confirmPwd2.value){
        confirmPwd2.style.background = "";
    }

}