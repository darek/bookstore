<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<c:choose>
	<c:when test="${not empty accounts}">
		<c:forEach items="${accounts}" var="account" varStatus="status">
			${status.index} ${account.username}
		</c:forEach>
	</c:when>
	<c:otherwise>
		brak kont
	</c:otherwise>
</c:choose>