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
	<div class="row justify-content-center">
		<div class="row">	
			<h3>상품명 : ${dto.productDTO.product_type}</h3>
			<h3>이자율 : ${dto.productDTO.product_rate}</h3>
			<h3>개설일 : ${dto.join_date}</h3>
			<h3>잔액 : ${dto.balance}</h3>
			<h3>계좌번호 : ${dto.account_number}</h3>
			<c:forEach items="${ac.dtos}" var = "acc">
				<h3> pk번호 : ${acc.product_info_id}</h3>
			</c:forEach>
		</div>
	</div>

	<div>
		<h3><a href="transfer?product_info_id=${dto.product_info_id}">이체하기</a></h3>
		<c:import url="/transfer">
			<c:param name="num" value="${dto.account_number}"></c:param>
		</c:import>
		<h3><a href="./list?product_info_id=${dto.product_info_id}&order=0">내역조회</a></h3>
	</div>

<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>

