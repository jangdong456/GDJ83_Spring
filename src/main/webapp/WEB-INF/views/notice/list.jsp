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
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>목록</th>
				<th>작성자</th>
				<th>생성일</th>
				<th>수정일</th>
				<th>조회수</th>
				<c:forEach items="${list.dtos}" var = "member">					
					<td>${member.member_id}</td>
				</c:forEach>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="ar">
				<tr>
					<td>${ar.board_num}</td>
					<td>${ar.board_title}</td>

					<td>${ar.create_date}</td>
					<td>${ar.update_date}</td>
					<td>${ar.board_hit}</td>
				</tr>
			</c:forEach>		
		</tbody>
	</table>
	
	<div>
		<a href="add" class="btn btn-primary" role="button">글쓰기</a>
	</div>





<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>