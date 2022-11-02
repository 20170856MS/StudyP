<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
</head>
<body>
	<h1>Detail Page</h1>
	
	<h3>Title : ${vo.title}</h3>
	
	<c:forEach items="${vo.listFiles}" var="fileVO">
		<img alt="" src="/file/list/${fileVO.fileName}">
		<a href="/fileDown/list?fileNum=${fileVO.fileNum}">${fileVO.oriName}</a>
	</c:forEach>
</body>
</html>