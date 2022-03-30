let firstName = document.getElementById("formFirstName");
let lastName = document.getElementById("formLastName");
let email = document.getElementById("formEmailAddress");
let Password = document.getElementById("formPassword");
let confirmPassword = document.getElementById("formConfirmPassword");

let hiddenFN = document.getElementById("hiddenFNError");
let hiddenLN = document.getElementById("hiddenLNError");
let hiddenE = document.getElementById("hiddenEmailError");
let hiddenPwd = document.getElementById("hiddenPasswordError");
let hiddenCPwd = document.getElementById("hiddenCPasswordError");

let sButton = document.getElementById("sButton");
sButton.addEventListener("click", function(e) {
    e.preventDefault();
    validate();
});

firstName.addEventListener("input", function() {
    hiddenFN.style.display = "none";
    firstName.style.border = "none";
});

lastName.addEventListener("input", function() {
    hiddenLN.style.display = "none";
    lastName.style.border = "none";
});

email.addEventListener("input", function() {
    hiddenE.style.display = "none";
    email.style.border = "none";
});

Password.addEventListener("click", function() {
    hiddenPwd.style.display = "none";
    Password.style.border = "none";
    hiddenCPwd.style.display = "none";
    confirmPassword.style.border = "none";
});

Password.addEventListener("input", function() {
    hiddenPwd.style.display = "none";
    Password.style.border = "none";
    hiddenCPwd.style.display = "none";
    confirmPassword.style.border = "none";
});

confirmPassword.addEventListener("input", function() {
    hiddenCPwd.style.display = "none";
    confirmPassword.style.border = "none";
});

function validate() {
    let validFN = validateFName(firstName.value);
    let validLN = validateLName(lastName.value);
    let validE = validateEmail(email.value);
    let validP = validatePasswords(Password.value, confirmPassword.value);
    if ( validFN && validLN && validE && validP) {
        alert("Welcome, " + firstName.value + "!");
    }
}

function validateFName(fName) {
    if (fName == '') {
        firstName.style.border = "3px solid red";
        hiddenFN.style.display = "block";
        hiddenFN.textContent = "First Name cannot be blank."
        return false;
    }
    else {
        return true;
    }
}

function validateLName(lName) {
    if (lName == '') {
        lastName.style.border = "3px solid red";
        hiddenLN.style.display = "block";
        hiddenLN.textContent = "Last Name cannot be blank."
        return false;
    }
    else {
        return true;
    }
}
function validateEmail(emailstr) {
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(emailstr)) {
        return true;
    }
    else {
        hiddenE.style.display = "block";
        hiddenE.textContent = "Please enter a valid email.";
        email.style.border = "3px solid red";
        return false;
    }
}

function validatePasswords(fPassword, fconfirmPassword) {
    if (fPassword.length < 8 || fPassword.length > 20) {
        // don't really need to check length of confirmPassword
        Password.style.border = "red solid 3px";
        confirmPassword.style.border = "red solid 3px";
        hiddenPwd.style.display = "block";
        hiddenPwd.textContent = "Password length must be between 8 and 20 characters.";
        return false;
    }else if (!/[a-zA-Z]/.test(fPassword)) {
        //uses regex to check that pw contains one letter
        Password.style.border = "red solid 3px";
        confirmPassword.style.border = "red solid 3px";
        hiddenPwd.style.display = "block";
        hiddenPwd.textContent = "Password must contain a letter.";
        return false;
    } else if (!(/\d/.test(fPassword))) {
        //uses regex to check that pw contains one number
        Password.style.border = "red solid 3px";
        confirmPassword.style.border = "red solid 3px";
        hiddenPwd.style.display = "block";
        hiddenPwd.textContent = "Password must contain a number.";
        return false;
    } else if (fPassword != fconfirmPassword) {
        hiddenPwd.style.display = "block";
        hiddenPwd.textContent = "Passwords need to match.";
        hiddenCPwd.style.display = "block";
        hiddenCPwd.textContent = "Passwords need to match.";
        return false;
    }
    return true;
}