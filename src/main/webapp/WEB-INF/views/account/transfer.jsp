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
			    <h1><label for="my_number" class="form-label">내 계좌번호 : ${param.product_info_id}</label></h1>
			    <h1>${param.product_info_id}</h1>
			</div>

			
			<form action="./transfer" method="post">
			  <div class="mb-3">
			    <input type="hidden" class="form-control" id="product_info_id" name="product_info_id" value="${param.product_info_id}">
			  </div>
			  
			  <div class="mb-3">  
			    <label for="receiveNumber" class="form-label">계좌번호</label> 
			    <input type="text" class="form-control" id="receiveNumber" name="receiveNumber">
			  </div>
			  
			  <div class="mb-3"> 
			    <label for=amount class="form-label">이체금액</label>
			    <input type="text" class="form-control" id="amount" name="amount">
			  </div>
			  
			  <div class="mb-3"> 
			    <label for=type class="form-label">입출금</label>
			    <input type="text" class="form-control" id="type" name="type">
			  </div>
			  

			  <button type="submit" class="btn btn-primary">이체하기</button>
			</form>
		</div>
	</div>	


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>