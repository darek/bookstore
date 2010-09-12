<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tag" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<% 
	pageContext.setAttribute("moduleName","catalog", PageContext.REQUEST_SCOPE);
	pageContext.setAttribute("pageName","add", PageContext.REQUEST_SCOPE);
%>

<a href="<%= request.getContextPath() %>/book.html" class="single-button right">
	<tag:message code="option.list" />
</a>


<div class="form">
	<form:form commandName="book">
	<ol>
		<li>
			<form:label path="title"><tag:message code="book.title" /></form:label> 
			<form:input path="title" />
			<form:errors path="title" />
		</li>
		<li>
			<form:label path="originalTitle"><tag:message code="book.originalTitle" /></form:label> 
			<form:input path="originalTitle" />
			<form:errors path="originalTitle" />
		</li>
		<li>
			<form:label path="price"><tag:message code="book.price" /></form:label> 
			<form:input path="price" />
			<form:errors path="price" />
		</li>
		<li>
			<form:label path="language"><tag:message code="book.language" /></form:label> 
			<form:select path="language">
				<form:option value="pl">Polski</form:option>
				<form:option value="en">Angielski</form:option>
			</form:select>
			<form:errors path="language" />
		</li>
		<li>
			<form:label path="shortDescription"><tag:message code="book.shortDescription" /></form:label> 
			<form:textarea path="shortDescription"/>
			<form:errors path="shortDescription" />
		</li>
		<li>
			<form:label path="description"><tag:message code="book.description" /></form:label> 
			<form:textarea path="description"/>
			<form:errors path="description" />
		</li>
		<li>
			<form:label path="publishDate"><tag:message code="book.publishDate" /></form:label> 
			<form:input path="publishDate" cssClass="dateBox" />
			<form:errors path="publishDate" />
		</li>
		<li>
			<form:label path="isbn10"><tag:message code="book.isbn10" /></form:label> 
			<form:input path="isbn10" />
			<form:errors path="isbn10" />
		</li>
		
		<li class="submit">
			<input type="submit" />
		</li>
	</ol>
	</form:form>
</div>