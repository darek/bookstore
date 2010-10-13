<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tag" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<% 
	pageContext.setAttribute("moduleName","catalog", PageContext.REQUEST_SCOPE);
	pageContext.setAttribute("pageName","search", PageContext.REQUEST_SCOPE);
%>

<c:if test="${not empty searchResults}">
	<c:forEach items="${searchResults}" var="res">
		${res.title}
	</c:forEach>
</c:if>