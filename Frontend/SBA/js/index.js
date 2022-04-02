document.getElementById("goodreads").addEventListener("click", goGoodReadsPage);
document.getElementById("slogin").addEventListener("click", goStaffLoginPage);
document.getElementById("plogin").addEventListener("click", goPatronLoginPage);
document.getElementById("pregister").addEventListener("click", goPatronRegistrationPage);

function goGoodReadsPage() {
    location.assign("./GoodReads.html");
}

function goStaffLoginPage() {
    location.assign("./StaffLogin.html");
}

function goPatronLoginPage() {
    location.assign("./PatronLogin.html");
}

function goPatronRegistrationPage() {
    location.assign("./PatronRegistration.html");
}