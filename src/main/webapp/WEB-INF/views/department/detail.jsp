<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서 상세정보</h1>
	
	<h3>${detail.department_id}</h3>
	<h3>${detail.department_name}</h3>
	<h3>${detail.manager_id}</h3>
	<h3>${detail.location_id}</h3>
	
	<a href ="delete?department_id=${detail.department_id}">삭제</a>
	<a href ="update?department_id=${detail.department_id}">수정</a>
	
</body>
</html>