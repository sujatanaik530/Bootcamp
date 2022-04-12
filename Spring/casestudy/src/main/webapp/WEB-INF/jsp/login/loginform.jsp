<jsp:include page="../include/header.jsp"/>

<!--
    (1) loginSubmit MUST match loginProcessingUrl in SecurityConfig.java
    (2) form submit method MUST be POST
    (3) name must be username for username/email field
    (4) name must be password for password field
-->
<form action="/login/loginSubmit" method="POST"> <!-- The action URL can be anything. -->
    <div class="mb-3 mt-3">
        <label for="username" class="form-label">Email:</label>
        <input type="text" class="form-control" id="username" name="username">
    </div>
    <div class="mb-3 mt-3">
        <label for="password" class="form-label">Password:</label>
        <input type="text" class="form-control" id="password" name="password">
    </div>
    <button type="submit" class="btn btn-primary" id="login">Login</button>
</form>
<jsp:include page="../include/footer.jsp"/>