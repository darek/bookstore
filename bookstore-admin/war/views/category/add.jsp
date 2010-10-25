<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tag" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<% 
   pageContext.setAttribute("moduleName","catalog", PageContext.REQUEST_SCOPE);
   pageContext.setAttribute("pageName","add", PageContext.REQUEST_SCOPE); 
%>
<a href="<%= request.getContextPath() %>/category.html" class="single-button right">
	<tag:message code="option.list" />
</a>
<div class="form">
	<form:form commandName="category">
	<ol>
		<li>
			<form:label path="name"><tag:message code="category.name" /></form:label> 
			<form:input path="name" />
			<form:errors path="name" />
		</li>
		<li>
			<form:label path="parentId"><tag:message code="category.parent" /></form:label>
			<t:categoriesselect categories="${categories}" level="0" category="${category}"/> 
			<form:errors path="parentId" />
		</li>
		<li class="submit">
			<input type="submit" />
		</li>
	</ol>
	</form:form>
</div>