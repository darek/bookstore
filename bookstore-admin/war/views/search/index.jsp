<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tag" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<% 
	pageContext.setAttribute("moduleName","catalog", PageContext.REQUEST_SCOPE);
	pageContext.setAttribute("pageName","search", PageContext.REQUEST_SCOPE);
%>
<div class="form">
	<form method="post" action="/search/find.html">
	<ol>
		<li>
			<label for="phrase"><tag:message code="search.phrase" /></label> 
			<input id="phrase" name="phrase" />
		</li>
		<li class="submit">
			<input type="submit" class="right" />
		</li>
	</ol>
	</form>
</div>