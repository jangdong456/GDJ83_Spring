<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/templete/header_css.jsp"></c:import>
</head>
<body id="page-top">
	<!-- Page Wrapper -->
    <div id="wrapper">
    
    <c:import url="/WEB-INF/views/templete/sidebar.jsp"></c:import>
	
	 <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">
            <c:import url="/WEB-INF/views/templete/topbar.jsp"></c:import>
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
		<c:forEach items="${dto.boardFileDTOs}" var="f">
			<a href="./fileDown?filenum=${f.filenum}">${f.oriname}</a>
		</c:forEach>
	</div>
	
	<div>
		<c:if test="${board ne 'Notice'}">
			<a href ="./reply?board_num=${dto.board_num}" class="btn btn-primary" role="button">답글</a>
		</c:if>
		<c:if test="${dto.board_writer eq member.m_id}">
		<a href ="./update?board_num=${dto.board_num}" class="btn btn-primary" role="button">수정</a>
		<a href ="./delete?board_num=${dto.board_num}" class="btn btn-primary" role="button">삭제</a>
		</c:if>
	</div>
            </div>
        </div>
    </div>
    <c:import url="/WEB-INF/views/templete/footerscript.jsp"></c:import>


</body>
</html>