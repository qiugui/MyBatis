<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${articles }" var="item">
		用户id：${item.users.id } ，用户名：${item.users.userName } ，文章ID：${item.id } ，文章名：${item.title } ，文章内容：${item.content }</br>
	</c:forEach>
</body>
</html>