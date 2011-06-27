<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="tag" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<% 
	pageContext.setAttribute("moduleName","catalog", PageContext.REQUEST_SCOPE);
	pageContext.setAttribute("pageName","index", PageContext.REQUEST_SCOPE);
%>

<a href="<%= request.getContextPath() %>/category/add.html" class="single-button right">
	<tag:message code="option.add" />
</a>

<c:if test="${not empty categories}">
	<ul>
		<c:forEach items="${categories}" var="category">
			<li><a href="<%= request.getContextPath() %>/category/details/id/${category.id}">${category.name}</a></li>
		</c:forEach>
	</ul>
</c:if>

<t:categoriestable categories="${categories}" level="0" tableClass="dataTable" />