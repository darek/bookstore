<%-- /WEB-INF/tags/repeatchar.tag --%>
<%@ attribute name="repeats" type="java.lang.Integer" required="true" %>
<%@ attribute name="character" type="java.lang.String" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<c:if test="${repeats gt 0}">
	<c:forEach var="i" begin="0" end="${repeats}">
		${character}
	</c:forEach>
</c:if>