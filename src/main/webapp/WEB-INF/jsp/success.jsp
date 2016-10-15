<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>fileParser for bInTime</title>
</head>
<body>
<div class="site-wrapper">
    <a href="<c:url value="/"/>" class="navbar-brand"> Home</a>
    <div align="center">
        <br/><br/><br/>
    <h3>File  <strong>${fileName}</strong> uploaded successfully.</h3>
    <br/><br/>
    <c:forEach items="${fileNames}" var="file">
        <c:out value="${file}"/> <br>
    </c:forEach>
        <br/><br/>
        <div
            style="font-family: verdana,serif; line-height: 25px; padding: 5px 10px; border-radius: 10px; border: 1px dotted #A4A4A4; width: 50%; font-size: 12px;">
                <h5>Count of lines in this file is <strong>${count}</strong>.</h5>
        </div>
        <br/><br/><br/><br/><br/>
    </div>
</div>
<jsp:include page="fragments/footerJSP.jsp"/>
</body>
</html>