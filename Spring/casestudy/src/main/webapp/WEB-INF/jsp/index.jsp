<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="users" scope="request" type="java.util.List"/> -->

<jsp:include page="include/header.jsp"/>
<h1>This is an index page.</h1>
<ol>
    <c:forEach var="u" items="${users}">
        <li>${u.email}</li>
    </c:forEach>
</ol>
<jsp:include page="include/footer.jsp"/>