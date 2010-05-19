<!doctype html>
<html lang="pl" dir="ltr">
	<head>
		<title><sitemesh:write property='title' /> - BookStore</title>
		<link rel="stylesheet" href="/resource/style/default.css" />
		<sitemesh:write property='head' />
	</head>
	<body>
		<%@ include file="../includes/navigation.jsp" %>
		<sitemesh:write property='body' />
	</body>
</html>