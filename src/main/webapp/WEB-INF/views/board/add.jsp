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
				<h1>${board}작성</h1>			
			</div>
<!-- 			현재 url주소가 action 주소로 알아서 들어간다. 그래서 action="";생략가능 -->
<!-- 			<form action="./add" method="post"> -->
			<form method="post">
				<input type="hidden" value="${boardDTO.board_num}" name = "board_num">
<!-- 			  <div class="mb-3"> -->
<!-- 					속성 disabled  : 파라미터로 안보내짐 -->
<!-- 					    readonly : 파라미터로 보내짐 -->
<!-- 					  하지만 중요한 데이터는 클라이언트에서 보낼때 보안에 위험에 있거나 값이 바뀔 수가 있다. -->
<!-- 					  컨트롤러에서 session값을 꺼내와서 서버로 값을 전달하는게 안전하다. -->
<%-- 			    세션에서 값 꺼내오기  value="${member.m_id}" --%>
<%-- 			    <input type="text" class="form-control" id="m_id" name="m_id"  value="${member.m_id}"> --%>
<!-- 			  </div> -->
			  
			  <div class="mb-3">
			    <label for="board_title" class="form-label">제목</label>
			    <input type="text" class="form-control" value ="${dto.board_title}" id="board_title" name="board_title">
			  </div>
			  
			  
			  <div class="mb-3">
			    <label for="board_contents" class="form-label">내용</label>
<!-- 			    <input type="text" class="form-control form-control-lg"  id="board_contents" name="board_contents"> -->
			  	<textarea rows="" cols="" id="board_contents" name="board_contents">${dto.board_contents}</textarea>
			  </div>
			  
				
			  <button type="submit" class="btn btn-primary">글쓰기</button>
			</form>
		</div>
	</div>

<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>