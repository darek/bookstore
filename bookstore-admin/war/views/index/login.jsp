<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="tag" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><tag:message code="title.login" /></title>
</head>
<body>
<div class="top-login">
	<p><tag:message code="login.text" /></p>
</div>
<div class="login">
    <form action="<c:url value="/j_spring_security_check.html" />" method="POST">
        <div class="input">
            <label for="login"><tag:message code="administrator.username"/></label>
            <input id="login" name="j_username"/>
        </div>
        <div class="input">
            <label for="password"><tag:message code="administrator.password"/></label>
            <input type="password" id="password" name="j_password"/>
        </div>
        <div class="submit">
            <button>wyslij</button>
        </div>
    </form>
</div>
<c:if test="${isError eq true}">
	<div class="error"><tag:message code="login_error" /></div>
</c:if>
</body>
</html>