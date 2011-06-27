<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tag" uri="http://www.springframework.org/tags" %>
<div class="form">
	<form:form commandName="administrator">
	<ol>
		<li>
			<form:label path="username"><tag:message code="administrator.username" /></form:label> 
			<form:input path="username" />
			<form:errors path="username" />
		</li>
		<li>
			<form:label path="password"><tag:message code="administrator.password" /></form:label> 
			<form:password path="password" />
			<form:errors path="password" />
		</li>
		<li>
			<form:label path="repeatedPassword"><tag:message code="administrator.repeatedPassword" /></form:label> 
			<form:password path="repeatedPassword" /> 
			<form:errors path="repeatedPassword" />
		</li>
		<li class="submit">
			<input type="submit" />
		</li>
	</ol>
	</form:form>
</div>