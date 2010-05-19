<%@ taglib prefix="tag" uri="http://www.springframework.org/tags" %>
<%
	String moduleName = (String) pageContext.getAttribute("moduleName",PageContext.REQUEST_SCOPE);
	String pageName = (String) pageContext.getAttribute("pageName",PageContext.REQUEST_SCOPE);
%><br />
<nav>
	<ul>
		<li 
			class="<% if(moduleName=="content"){ out.print("active"); } %>">
			<a href="<%= request.getContextPath() %>/content.html">
				<tag:message code="menu.content" />
			</a>
		</li>
		<li 
			class="<% if(moduleName=="catalog"){ out.print("active"); } %>">
			<a href="<%= request.getContextPath() %>/catalog.html">
				<tag:message code="menu.catalog" />
			</a>
			<ul>
				<li
					class="<% if(moduleName=="categories"){ out.print("active"); } %>">
					<a href="<%= request.getContextPath() %>/catalog/categories.html">
						<tag:message code="menu.categories" />
					</a>
				</li>
				<li>
					<a href="<%= request.getContextPath() %>/catalog/books.html">
						<tag:message code="menu.books" />
					</a>
				</li>
			</ul>
		</li>
		<li 
			class="<% if(moduleName=="order"){ out.print("active"); } %>">
			<a href="<%= request.getContextPath() %>/orders.html">
				<tag:message code="menu.orders" />
			</a>
		</li>
		<li 
			class="<% if(moduleName=="client"){ out.print("active"); } %>">
			<a href="<%= request.getContextPath() %>/clients.html">
				<tag:message code="menu.clients" />
			</a>
		</li>
		<li>
			<a href="<%= request.getContextPath() %>/settings.html">
				<tag:message code="menu.settings" />
			</a>
			<ul>
				<li>
					<a href="<%= request.getContextPath() %>/settings/administrators.html">
						<tag:message code="menu.administrators" />
					</a>
				</li>
			</ul>
		</li>
		<li 
			class="logout">
			<a href="<%= request.getContextPath() %>/wyloguj.html">
				<tag:message code="menu.logout" />
			</a>
		</li>
	</ul>
</nav>