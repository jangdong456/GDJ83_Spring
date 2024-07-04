<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

	<div class="container mt-5">
		<div class="row">
			<div class="row">
				<h1>회원가입</h1>			
			</div>
			<form action="./join" method="post">
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
			    <input type="text" class="form-control" id="member_pwd" name="member_pwd">
			  </div>
			  

			  <button type="submit" class="btn btn-primary">회원가입</button>
			</form>
		</div>
	</div>
	

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>	
</body>
</html>