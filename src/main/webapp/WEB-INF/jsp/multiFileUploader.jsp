<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <h1>Please choose the file in form below: </h1>
            (Your file should be only ".txt" type)
            <br/>
            <br/>

        <form:form method="post" name="uploadForm" modelAttribute="uploadForm"
                   enctype="multipart/form-data" class="form-horizontal">

            <div class="row">
                <div class="form-group col-md-10">
                    <label class="col-md-7 control-lable">Upload a file</label>
                    <div class="col-md-3">
                        <input name="files[0]" type="file"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-10">
                    <label class="col-md-7 control-lable">Upload a file</label>
                    <div class="col-md-3">
                        <input name="files[1]" type="file" />
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-10">
                    <label class="col-md-7 control-lable">Upload a file</label>
                        <div class="col-md-3">
                            <input name="files[2]" type="file" />
                        </div>
                </div>
            </div>

            <div class="row">
                <div class="form-actions floatRight">
                    <input type="submit" value="Upload" class="btn btn-primary btn-sm">
                </div>
            </div>
        </form:form>

            <br />
        </div>
    </div>
</div>
<jsp:include page="fragments/footerJSP.jsp"/>
</body>
</html>