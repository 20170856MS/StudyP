<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add List</title>
</head>
<body>

	<h1>Write Page</h1>
	<form action="add" method="post" enctype="multipart/form-data">
		<div class="mb-3">
		  <label for="title" class="form-label">Title</label>
		  	<input type="text" name="title" class="form-control" id="title" placeholder="제목">
		</div>
		<div class="mb-3">
		  <label for="writer" class="form-label">Writer</label>
		  	<input type="text" name="writer" class="form-control" id="writer" placeholder="작성자">
		</div>
		<div class="mb-3">
		  <label for="contents" class="form-label">Contents</label>
		  <textarea class="form-control" name="contents" id="contents"></textarea>
		</div>
		
		<div class="mb-3" id="fileAddResult">
			
		</div>
		<div class="mb-3">
			<button type="button" id="fileAdd">FileAdd</button>
		</div>

		<div>
			<button>WRITE</button>
		</div>
	</form>

</body>
</html>