<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<!-- Rewrite this as a case stmt using c:choose -->
<c:if test="${empty form.id}">
    <h1 class="text-center m-5">Sign Up</h1>
</c:if>

<c:if test="${not empty form.id}">
    <h1 class="text-center m-5">Edit User</h1>
</c:if>

<form action="/user/registerSubmit" method="get">
    <input type="hidden" name="id" value="${form.id}">
    <div class="mb-3 mt-3">
        <label for="emailId" class="form-label">Email:</label>
        <input type="text" class="form-control" id="emailId" placeholder="Enter email" name="email" value="${form.email}">
        <p class="hiddenMsg"></p>
        <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
            <div style="color: red;">${error.getDefaultMessage()}</div>
        </c:forEach>
    </div>
    <div class="row">
        <div class="col mb-3">
            <label for="firstNameId" class="form-label">First Name:</label>
            <input type="text" class="form-control" id="firstNameId" placeholder="Enter first name" name="firstName" value="${form.firstName}">
            <p class="hiddenMsg"></p>
            <c:forEach items="${bindingResult.getFieldErrors('firstName')}" var="error">
                <div style="color: red;">${error.getDefaultMessage()}</div>
            </c:forEach>
        </div>
        <div class="col mb-3">
            <label for="lastNameId" class="form-label">Last Name:</label>
            <input type="text" class="form-control" id="lastNameId" placeholder="Enter last name" name="lastName" value="${form.lastName}">
            <p class="hiddenMsg"></p>
            <c:forEach items="${bindingResult.getFieldErrors('lastName')}" var="error">
                <div style="color: red;">${error.getDefaultMessage()}</div>
            </c:forEach>
        </div>
    </div>
    <div class="row">
        <div class="col mb-3">
            <label for="passwordId" class="form-label">Password:</label>
            <input type="password" class="form-control" id="passwordId" placeholder="Enter password" name="password" value="${form.password}">
            <p class="hiddenMsg"></p>
            <c:forEach items="${bindingResult.getFieldErrors('password')}" var="error">
                <div style="color: red;">${error.getDefaultMessage()}</div>
            </c:forEach>
        </div>
        <div class="col mb-3">
            <label for="cpasswordId" class="form-label">Confirm Password:</label>
            <input type="password" class="form-control" id="cpasswordId" placeholder="Enter password" name="cpassword" value="${form.cpassword}">
            <p class="hiddenMsg"></p>
        </div>
    </div>
    <div class="mb-3 mt-3">
        Check  <input type="checkbox" name="checkbox">
        <c:forEach items="${bindingResult.getFieldErrors('checkbox')}" var="error">
            <div style="color: red;">${error.getDefaultMessage()}</div>
        </c:forEach>
    </div>
    <button type="submit" class="btn btn-primary" id="login">Register</button>
    <!-- The above button must be a submit, not a button. -->
</form>
<br>
<!--
<c:if test="${not empty errorMessages}">
    <c:forEach items="${errorMessages}" var="message">
        <div>${message}</div><br>
    </c:forEach>
</c:if>
-->
<jsp:include page="../include/footer.jsp"/>