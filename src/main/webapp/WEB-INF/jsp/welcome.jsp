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
            <div class="form-container">
    <br/>
    <br/>
    <br/>
    <h1>Welcome to my FILE_PARSER </h1>

    <h2>Click on below links to see FileUpload in action.</h2><br/><br/>

    <h3><a href="<c:url value='/singleUpload' />">Single File Upload</a>  OR  <a href="<c:url value='/multiUpload' />">Multi File Upload</a> </h3>
            </div>
        </div>
</div>
<jsp:include page="fragments/footerJSP.jsp"/>
</body>
</html>