<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	
	<div class="container">
		<div class="row">
			<div class="row">
				<h1>수정폼</h1>			
			</div>
			<form method="post">				
			  <div class="mb-3">
			    <label for="member_name" class="form-label">이름</label>
			    <input type="text" value="${member_name}" class="form-control" id="member_name" name="member_name">
			  </div>	
			
			  <div class="mb-3">
			    <label for="member_phone" class="form-label">폰번호</label>
			    <input type="text" value="${phone}" class="form-control" id="member_phone" name="phone">
			  </div>
			  
			  <div class="mb-3">
			    <label for="member_email" class="form-label">이메일</label>
			    <input type="text" value="${email}" class="form-control" id="member_email" name="email">
			  </div>
			 
			  <button type="submit" class="btn btn-primary">등록</button>
			</form>
		</div>
	</div>
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>	
</body>
</html>