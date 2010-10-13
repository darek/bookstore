<%-- /WEB-INF/tags/categoriestable.tag --%>
<%@ attribute name="categories" type="java.util.Collection" required="true" %>
<%@ attribute name="level" type="java.lang.Integer" required="true" %>
<%@ attribute name="tableClass" type="java.lang.String" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="tags" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:choose>
	<c:when test="${level eq 0}">
		<table class="${tableClass}">
			<thead>
				<tr>
					<th><tags:message code="category.name" /></th>
					<th><tags:message code="options" /></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty categories}">
					<t:categoriestable categories="${category.childrens}" level="1" />
				</c:if>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
		<c:forEach items="${categories}" var="category">
			<tr>
				<td><t:repeatchar character="-" repeats="${level-1}" />${category.name}</td>
				<td>
					<a href="<%= request.getContextPath() %>/category/edit/${category.id}.html">
						<tags:message code="option.edit" />
					</a>
				</td>
			</tr>
			<c:if test="${not empty category.childrens}">
				<t:categoriestable categories="${category.childrens}"
					level="${level +1}" />
			</c:if>
		</c:forEach>
	</c:otherwise>
</c:choose>