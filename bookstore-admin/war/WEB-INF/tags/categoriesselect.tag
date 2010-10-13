<%-- /WEB-INF/tags/categoriesselect.tag --%>
<%@ attribute name="categories" type="java.util.Collection" required="true" %>
<%@ attribute name="level" type="java.lang.Integer" required="true" %>
<%@ attribute name="category" type="com.darekzon.bookstore.domain.Category" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="tags" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form," uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:choose>
	<c:when test="${level eq 0}">
		<form:select path="parentId">
			<form:option value="0"><tag:message code="category.main_category" /></form:option>
			<t:categoriesselect categories="${categories}" level="1" category="${category }" />
		</form:select>
	</c:when>
	<c:otherwise>
		<c:forEach items="${categories}" var="cat">
			<c:choose>
			<c:when test="${category.id eq cat.id}">
				<form:option value="${cat.id}" disabled="true"><t:repeatchar character="-" repeats="${level-1}" />${cat.name}</form:option>
			</c:when>
			<c:otherwhise>
				<form:option value="${cat.id}" disabled="false"><t:repeatchar character="-" repeats="${level-1}" />${cat.name}</form:option>
			</c:otherwhise>
			</c:choose>
			<t:categoriesselect categories="${cat.children}" level="${level+1}" category="${category}" />
		</c:forEach>
	</c:otherwise>
</c:choose>