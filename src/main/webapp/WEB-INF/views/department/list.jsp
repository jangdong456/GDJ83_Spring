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
	<h1>부서 리스트</h1>
	<div class="row">
		<c:forEach items="${info}" var="m">
			<h3>${m.id}</h3>
			<h3>${m.sum}</h3>
			<h3>${m.avg}</h3>
		</c:forEach>
	</div>
	
	<div class = "row col-md-8">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>부서번호</th>
					<th>부서명</th>
					<th>관리자</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.department_id}</td>
						<!--  url 넣는법 href= "현재폴더니까 detail"만쓴다.-->
						<%-- jsp파일인데도 불구하고, 주석을 jsp주석을 사용하고 el문을 쓴다면, 에러가남 그래서, el문 주석작성시에 무조건 el주석 으로 해줘야함--%>
						<%--파라미터 넣는법 | ?파라미터이름 = 값 ${} --%>
						<td><a href="detail?department_id=${dto.department_id}">${dto.department_name}</a></td>
						<td>${dto.manager_id}</td>
					</tr>			
				</c:forEach>
			
			</tbody>
		</table>
		
		<div>
		
			<a href="add" class="btn btn-primary" role="button">부서등록</a>
		
		</div>
		
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>