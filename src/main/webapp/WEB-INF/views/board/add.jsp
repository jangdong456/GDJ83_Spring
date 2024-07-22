<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
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
            			<div class="container mt-5">
		<div class="row">
			<div class="row">
				<h1>${board}작성</h1>			
			</div>
<!-- 			현재 url주소가 action 주소로 알아서 들어간다. 그래서 action="";생략가능 -->
<!-- 			<form action="./add" method="post"> -->
			<form method="post" enctype="multipart/form-data">
				<input type="hidden" value="${boardDTO.board_num}" name = "board_num">

			  <div class="mb-3">
			    <label for="board_title" class="form-label">제목</label>
			    <input type="text" class="form-control" value ="${dto.board_title}" id="board_title" name="board_title">
			  </div>
			  
			  
			  <div class="mb-3">
			    <label for="board_contents" class="form-label">내용</label>
<!-- 			    <input type="text" class="form-control form-control-lg"  id="board_contents" name="board_contents"> -->
			  	<textarea rows="" cols="" id="board_contents" name="board_contents">${dto.board_contents}</textarea>
			  </div>
			  
				<div class="mb-3">
					<button type="button" id="add" class="btn btn-primary">첨부파일추가</button>
				<div id="result"></div>	
				</div>
				
			  <button type="submit" class="btn btn-primary">글쓰기</button>
			</form>
		</div>
	</div>
</div>
	</div>
	</div>
	<c:import url="/WEB-INF/views/templete/footerscript.jsp"></c:import>
	<script src="/resources/js/commons/files.js"></script>
	<script>
		setMax(5);
	</script>

</body>
</html>