<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="tag" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<% 
	pageContext.setAttribute("moduleName","catalog", PageContext.REQUEST_SCOPE);
	pageContext.setAttribute("pageName","index", PageContext.REQUEST_SCOPE);
%>

<a href="<%= request.getContextPath() %>/book/add.html" class="single-button right">
	<tag:message code="option.add" />
</a>

<c:if test="${not empty books}">
	<ol>
	<c:forEach items="${books}" var="book">
		<li>
			<a href="<%= request.getContextPath() %>/book/details/${book.id}.html">
				${book.title}
			</a>
		</li>
	</c:forEach>
	</ol>
</c:if>