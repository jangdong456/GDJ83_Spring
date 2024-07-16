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
	<h1>${board}</h1>
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>	
		</thead>
		<tbody>
				<tr>
					<td>${dto.board_num}</td>
					<td>${dto.board_title}</td>				
					<td>${dto.board_writer}</td>					
					<td>${dto.create_date}</td>
					<td>${dto.board_hit}</td>
				</tr>
		</tbody>
		
		<tr>
			<td colspan ="6">${dto.board_contents}</td>
		</tr>
	</table>
	<div>
<!-- 	어느글의 답글이냐 를 알아야해서 board_num이 넘어가야함 -->
<!-- 이 페이지가 notice 페이지인지 QnA 페이지인지 어떻게 구분 할까 ? -->
<!-- 1. url -->
<!-- 2. @ModelAttribute 의 key값 -->
		<c:if test="${board ne 'Notice'}">
			<a href ="./reply?board_num=${dto.board_num}" class="btn btn-primary" role="button">답글</a>
		</c:if>
		<c:if test="${dto.board_writer eq member.m_id}">
		<a href ="./update?board_num=${dto.board_num}" class="btn btn-primary" role="button">수정</a>
		<a href ="./delete?board_num=${dto.board_num}" class="btn btn-primary" role="button">삭제</a>
		</c:if>
	</div>
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>