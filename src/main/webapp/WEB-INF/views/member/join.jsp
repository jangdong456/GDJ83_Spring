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
				<h1>회원가입</h1>			
			</div>
			<form action="./join" method="post" enctype="multipart/form-data">
			
			  <div class="mb-3">
			    <label for="member_name" class="form-label">이름</label>
			    <input type="text" class="form-control" id="member_name" name="member_name">
			  </div>
			  
			  <div class="mb-3">
			    <label for="member_number" class="form-label">주민번호</label>
			    <input type="text" class="form-control" id="member_number" name="member_number">
			  </div>
			  
			  <div class="mb-3">
			    <label for="phone" class="form-label">휴대폰번호</label>
			    <input type="text" class="form-control" id="phone" name="phone">
			  </div>
			  
			  <div class="mb-3">
			    <label for="email" class="form-label">이메일</label>
			    <input type="text" class="form-control" id="email" name="email">
			  </div>
			  
			  <div class="mb-3">
			    <label for="member_id" class="form-label">아이디</label>
			    <input type="text" class="form-control" id="member_id" name="member_id">
			  </div>
			  
			  <div class="mb-3">
			    <label for="member_pwd" class="form-label">비밀번호</label>
			    <input type="text" class="form-control" id="member_pwd2" name="">
			  </div>
			  <div class="mb-3">
			    <label for="member_pwd" class="form-label">비밀번호</label>
			    <input type="text" class="form-control" id="passwordCheck" name="member_pwd">
			  </div>
			  
			  
			  
			<div class="mb-3">
			<button type="button" id="add" class="btn btn-primary">사진파일추가</button>
			</div>	
			
			<div id="result">
			</div>

	 		<div class="mb-3">
				<button type="submit" id="btn" class="btn btn-primary">회원가입</button>
			</div>

			</form>
            </div>
            </div>
            

			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/views/templete/footerscript.jsp"></c:import>
	<script type="text/javascript" src="../resources/js/member/memberJoinCheck.js"></script>
	<script type="text/javascript" src="../resources/js/commons/files.js"></script>


</body>
</html>
    
