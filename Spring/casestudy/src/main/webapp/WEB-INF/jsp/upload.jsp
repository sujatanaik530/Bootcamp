<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp"/>

<h1 class="text-center m-5">File upload</h1>

<form action="/upload" method="post" enctype="multipart/form-data">
    Subject: <input type="text" name="subject">
    <br>
    Select file: <input type="file" name="file">
    <br>
    <input type="submit" value="Submit">
</form>

<jsp:include page="include/footer.jsp"/>