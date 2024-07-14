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
<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
	<div class="row col-md-4 ms-5 mt-5">
	
	<form action="./list" method ="get" class="row row-cols-lg-auto g-3 align-items-center">
				 
			<div class="col-12">
			    <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
			    <select name="kind" class="form-select" id="inlineFormSelectPref">
			      <option value="k1">제목</option>
			      <option value="k2">내용</option>
			      <option value="k3">작성자</option>
		    	</select>
		  </div>

		  <div class="col-12">
		    <label class="visually-hidden" for="inlineFormInputGroupUsername">Username</label>
		    <div class="input-group">		 
		      <input type="text" name="search" class="form-control" id="inlineFormInputGroupUsername" placeholder="Username">
		    </div>
		  </div>

		  <div class="col-12">
		    <button type="submit" class="btn btn-primary">Submit</button>
		  </div>
		</form>

	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>목록</th>
				<th>작성자</th>
				<th>생성일</th>
				<th>수정일</th>
				<th>조회수</th>
<%-- 				<c:forEach items="${list.dtos}" var = "m">					 --%>
<%-- 					<td>${m.member_id}</td> --%>
<%-- 				</c:forEach> --%>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${map.list}" var="map">
				<tr>
					<td>${map.board_num}</td>
					<td><a href="./detail?board_num=${map.board_num}">${map.board_title}</a></td>				
					<td>${map.board_writer}</td>					
					<td>${map.create_date}</td>
					<td>${map.update_date}</td>
					<td>${map.board_hit}</td>
				</tr>
			</c:forEach>		
		</tbody>
	</table>
	</div>
	
		<nav aria-label="Page navigation example">
	  <ul class="pagination">
		<li class="page-item ${map.pre?'':'disabled'}">
		  <a class="page-link" href="./list?page=${map.startNum-1}&kind=${map.kind}&search=${map.search}" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>  
	    </li>
	
	    <!--  for(int i=0; i<=10; i=i+2-->
	    <c:forEach begin="${map.startNum}" end="${map.lastNum}" step="1" var="i">
	    	<li class="page-item"><a class="page-link" href="list?page=${i}&kind=${map.kind}&search=${map.search}">${i}</a></li>    
	    </c:forEach>
	
		<li class="page-item ${map.next?'':'disabled'}">
			<a class="page-link" href="./list?page=${map.lastNum+1}&kind=${map.kind}&search=${map.search}" aria-label="Next">
	        	<span aria-hidden="true">&raquo;</span>
	     	</a>
	    </li>
	  </ul>
	</nav>
	
	
	<div>
		<a href="add" class="btn btn-primary" role="button">글쓰기</a>
	</div>





<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>