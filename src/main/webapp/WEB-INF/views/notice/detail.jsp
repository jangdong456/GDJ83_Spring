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
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>내용</th>		
		</thead>
		<tbody>
				<tr>
					<td>${dto.board_num}</td>
					<td>${dto.board_title}</td>				
					<td>${dto.m_id}</td>					
					<td>${dto.create_date}</td>
					<td>${dto.board_hit}</td>
					<td>${dto.board_contents}</td>
				</tr>
		</tbody>
	</table>
	<div>
		<a href ="update?board_num=${dto.board_num}" class="btn btn-primary" role="button">수정</a>
		<a href ="delete?board_num=${dto.board_num}" class="btn btn-primary" role="button">삭제</a>
	</div>
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>