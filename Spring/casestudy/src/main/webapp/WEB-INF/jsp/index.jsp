<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="users" scope="request" type="java.util.List"/> -->

<html>
<head>
<title>The Index Page</title>
</head>
<body>
<h1>This is an index page.</h1>
<p><b>Iterated List:</b><p>

<ol>
    <c:forEach var="u" items="${users}">

        <!--<li>${u}</li>-->
        <li>${u.email}</li>

    </c:forEach>
</ol>
</body>
</html>