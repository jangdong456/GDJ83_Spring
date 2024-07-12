<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
		<div class="container mt-5">
		<div class="row">
			<div class="row">
				<h1>글작성</h1>			
			</div>
			<form action="./join" method="post">
			  <div class="mb-3">
			    <label for="member_id" class="form-label">작성자</label>
			    <input type="text" class="form-control" id="member_id" name="member_id">
			  </div>
			  
			  <div class="mb-3">
			    <label for="board_title" class="form-label">제목</label>
			    <input type="text" class="form-control" id="board_title" name="board_title">
			  </div>
			  
			  <div class="mb-3">
			    <label for="board_contents" class="form-label">내용</label>
			    <input type="text" class="form-control form-control-lg"  id="board_contents" name="board_contents">
			  </div>

			  <button type="submit" class="btn btn-primary">글쓰기</button>
			</form>
		</div>
	</div>

<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>