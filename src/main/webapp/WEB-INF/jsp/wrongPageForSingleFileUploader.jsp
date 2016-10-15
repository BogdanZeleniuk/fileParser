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
        <br/><br/><br/><br/><br/>
            <div align="center">
                <div class="form-container">
                    <h3>Sorry, Your file <strong>${fileName}</strong> is empty or has other type than ".txt"!
                    Please, check it one more time.</h3>
                    <br/>
                    <h4><a href="<c:url value='/singleUpload' />">Back</a></h4>

                </div>
            </div>
</div>
<jsp:include page="fragments/footerJSP.jsp"/>
</body>
</html>
