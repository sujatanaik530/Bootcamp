<jsp:include page="../include/header.jsp"/>
<h1 class="text-center m-5">Registration</h1>
<form action="/user/registerSubmit" method="post">
    <div class="mb-3 mt-3">
        <label for="emailId" class="form-label">Email:</label>
        <input type="email" class="form-control" id="emailId" placeholder="Enter email" name="email">
        <p class="hiddenMsg"></p>
    </div>
    <div class="mb-3">
        <label for="firstNameId" class="form-label">First Name:</label>
        <input type="text" class="form-control" id="firstNameId" placeholder="Enter first name" name="firstName">
        <p class="hiddenMsg"></p>
    </div>
    <div class="mb-3">
        <label for="lastNameId" class="form-label">Last Name:</label>
        <input type="text" class="form-control" id="lastNameId" placeholder="Enter last name" name="lastName">
        <p class="hiddenMsg"></p>
    </div>
    <div class="mb-3">
        <label for="passwordId" class="form-label">Password:</label>
        <input type="password" class="form-control" id="passwordId" placeholder="Enter password" name="password">
        <p class="hiddenMsg"></p>
    </div>
    <div class="mb-3">
        <label for="cpasswordId" class="form-label">Confirm Password:</label>
        <input type="password" class="form-control" id="cpasswordId" placeholder="Enter password" name="cpassword">
        <p class="hiddenMsg"></p>
    </div>
    <button type="submit" class="btn btn-primary" id="login">Register</button>
    <!-- The above button must be a submit, not a button. -->
</form>
<jsp:include page="../include/footer.jsp"/>