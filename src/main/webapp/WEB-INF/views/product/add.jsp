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
            
            
            
	<div class="container">
		<div class="row">
			<div class="row">
				<h1>상품등록</h1>			
			</div>
			<form action="./add" method="post" enctype="multipart/form-data">
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

			  <div class="mb-3">
				<button type="button" id="add" class="btn btn-primary">사진파일추가</button>
						<div id="result"></div>		
				</div>	
			  <button type="submit" class="btn btn-primary">등록</button>
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