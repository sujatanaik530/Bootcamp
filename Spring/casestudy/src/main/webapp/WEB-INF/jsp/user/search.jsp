<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<h1 class="text-center m-5">Search</h1>

<!-- change below line for use without searchformbean ...url to /user/search and method to get -->
<form action="/user/searchSubmit" method="post">
    <input class="form-control" type="text" name="search" id="search" value="${form.search}"></input>
    <button class="btn btn-primary" type="submit">Search by first name</button>
</form>
<br><br>
<table class="table table-sm" style="width:60%;margin:auto">
    <tr>
        <th>ID</th>
        <th>Email</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>User Since</th>
    </tr>
<c:forEach items="${user}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.email}</td>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>${user.createDate}</td>
    </tr>
</c:forEach>
</table>
<jsp:include page="../include/footer.jsp"/>