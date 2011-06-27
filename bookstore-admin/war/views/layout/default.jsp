<!doctype html>
<html lang="pl" dir="ltr">
	<head>
		<title><sitemesh:write property='title' /> - BookStore</title>
		<link rel="stylesheet" href="/resources/style/reset.css" />
		<link rel="stylesheet" href="/resources/style/smoothness/smoothness.css" />
		<link rel="stylesheet" href="/resources/style/default.css" />
		<link rel="stylesheet" href="/resources/style/site.css" />
		<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
		<script type="text/javascript" src="/resources/js/jquery-ui.min.js"></script>
		<script type="text/javascript" src="/resources/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript" src="/resources/js/main.js"></script>
		<sitemesh:write property='head' />
	</head>
	<body>
		<%@ include file="../includes/navigation.jsp" %>
		<sitemesh:write property='body' />
	</body>
</html>