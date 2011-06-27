<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="tag" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<% 
	pageContext.setAttribute("moduleName","catalog", PageContext.REQUEST_SCOPE);
	pageContext.setAttribute("pageName","index", PageContext.REQUEST_SCOPE);
%>