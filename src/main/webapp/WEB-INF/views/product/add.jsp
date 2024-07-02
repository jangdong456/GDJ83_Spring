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
				<h1>상품등록</h1>			
			</div>
			<form action="./add" method="post">
			  <div class="mb-3">
			    <label for="product_type" class="form-label">상품명</label>
			    <input type="text" class="form-control" id="product_type" name="product_type">
			  </div>
			  
			  <div class="mb-3">
			    <label for="product_rate" class="form-label">이자율</label>
			    <input type="text" class="form-control" id="product_rate" name="product_rate">
			  </div>
			  
			  <div class="mb-3">
			    <label for="product_detail" class="form-label">상품설명</label>
			    <input type="text" class="form-control" id="product_detail" name="product_detail">
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