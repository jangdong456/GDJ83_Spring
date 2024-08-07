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
    


	<h1>금융상품 리스트</h1>
	<div class="col-md-10 ms-10 mt-4">
		<!-- 검색어 입력 폼 -->	
		<form action="./list" method ="get" class="row row-cols-lg-auto g-3 align-items-center">
				 
			<div class="col-12">
			    <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
			    <select name="kind" class="form-select" id="inlineFormSelectPref">
			      <option value="k1">상품명</option>
			      <option value="k2">상품내용</option>
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
					<th>상품명</th>
					<th>이자율</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${list}" var="map">
					<tr>
						<td>${map.product_id}</td>
						<td><a href="detail?product_id=${map.product_id}">${map.product_type}</a></td>
						<td>${map.product_rate}</td>
					</tr>
				</c:forEach>		
			</tbody>
		</table>
	</div>
	
	
		<nav aria-label="Page navigation example">
	  <ul class="pagination">
		<li class="page-item ${pager.pre?'':'disabled'}">
		  <a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>  
	    </li>
	
	    <!--  for(int i=0; i<=10; i=i+2-->
	    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1" var="i">
	    	<li class="page-item"><a class="page-link" href="list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>    
	    </c:forEach>
	
		<li class="page-item ${pager.next?'':'disabled'}">
			<a class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
	        	<span aria-hidden="true">&raquo;</span>
	     	</a>
	    </li>
	  </ul>
	</nav>
	<div>
		<a href="add" class="btn btn-primary" role="button">상품등록</a>
	</div>
	</div>
	</div>
	</div>
	<c:import url="/WEB-INF/views/templete/footerscript.jsp"></c:import>

</body>
</html>