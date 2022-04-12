<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<h1 class="text-center m-5">Search</h1>

<!-- <form action="/user/searchSubmit" method="post"> -->
<form action="/user/searchNoBean" method="get">
    <div class="row">
        <div class="col-md-2">
            <label for="search">First name:</label>
        </div>
        <div class="col-md-8">
            <input class="form-control" type="text" name="search" id="search" value="${form.search}"></input>
        </div>
        <div class="col-md-2">
            <button class="btn btn-primary" type="submit">Search</button>
        </div>
    </div>
</form>
<br><br>
<table class="table table-sm" style="width:60%;margin:auto">
    <tr>
        <th>ID</th>
        <th>Email</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>User Since</th>
        <th>Edit</th>
    </tr>
<c:forEach items="${user}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.email}</td>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>${user.createDate}</td>
        <th><a href="/user/edit/${user.id}">Edit</a></th>
    </tr>
</c:forEach>
</table>
<jsp:include page="../include/footer.jsp"/>