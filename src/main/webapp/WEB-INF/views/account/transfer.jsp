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
<c:import url = "/WEB-INF/views/sample/header.jsp"></c:import>
	<div class="container mt-5">
		<div class="row">
			<div class="row">		
			    <h1><label for="my_number" class="form-label">내 계좌번호 : ${param.product_info_id}</label></h1>
			    <h1>${param.product_info_id}</h1>
			    <h1>${param.account_number}</h1>
			</div>

			
			<form action="transfer" method="post">
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


<c:import url = "/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>