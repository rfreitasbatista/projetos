document.querySelector(".birthday").DatePickerX.init({ format: "dd/mm/yyyy", minDate: "01/01/1905" });

const firstnameInput = document.getElementsByClassName("firstname-input")[0];
const lastnameInput = document.getElementsByClassName("lastname-input")[0];
const gender = document.getElementsByClassName("gender-input");
const register = document.getElementsByClassName("send-button")[0];

//POP UP VALID
validation.init("#register-form");
register.addEventListener("click", function (event) {
  event.preventDefault();
  let genderCheck = "";
  for (i = 0; i < gender.length; i += 1) {
    if (gender[i].checked) {
      genderCheck = gender[i].value;
    }
  }
  if (validation.isValid("#register-form")) {
    alert(
      firstnameInput.value + " " + lastnameInput.value + " - " + genderCheck
    );
  } else {
    alert("Dados inválidos");
  }
});

//Login
const enterButton = document.getElementsByClassName("button-login")[0];
const userLogin = document.getElementsByClassName("input-login")[0];

validation.init("#login-form");
enterButton.addEventListener("click", function (event) {

  console.log(validation.isValid("#login-form"))
  if (validation.isValid("#login-form")) {
    alert(userLogin.value);
  } else {
    alert("Usuário inválido");
  }
  event.preventDefault();
});
