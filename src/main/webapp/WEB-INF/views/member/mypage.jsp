<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

<div class="container-fluid mt-5">
	<div class="row justify-content-center">
		<div class="col-md-6">
			<h3>${member.member.member_name}</h3>
			<h3>${member.member.phone}</h3>
			<h3>${member.member.email}</h3>
			
			<div>
				<h3>계좌정보</h3>
				<c:forEach items="${member.accounts}" var = "ac">
					<h3>${ac.account_number} : ${ac.balance}</h3>			
				</c:forEach>
			</div>


			<div>
				<a href="./update" class="btn btn-primary">회원수정</a>
				<form action="delete" method="post">
					<button class="btn btn-danger">회원탈퇴</button>
				</form>
			</div>
		</div>
	</div>
</div>

	
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>