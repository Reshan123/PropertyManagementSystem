const passwordInput = document.getElementById("passwordInput");

function passwordLengthCheck(){
	if(passwordInput.value.length<=7){
		passwordInput.style.background = "red";
	} else {
		passwordInput.style.background = "transparent";
	}
}