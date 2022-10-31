<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List</h1>
	<table>
			<thead>
				<tr>
					<th>NUM</th>
					<th>TILTE</th>
					<th>WRITER</th>
					<th>HIT</th>
					<th>DATE</th>
				</tr>
			</thead>
			
			<tbody>
			<c:forEach items="${list}" var="vo">
				<tr>
					<td>${vo.num}</td>
					<td><a href="detail?num=${vo.num}">${vo.title}</a></td>
					<td>${vo.writer}</td>
					<td>${vo.hit}</td>
					<td>${vo.regDate}</td>
				</tr>	
			</c:forEach>
			
			</tbody>
			
			
		</table>
</body>
</html>