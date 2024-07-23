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
    <div id="wrapper">
    
    <c:import url="/WEB-INF/views/templete/sidebar.jsp"></c:import>
	
	 <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">
            <c:import url="/WEB-INF/views/templete/topbar.jsp"></c:import>
            
    		<h1>금융상품 리스트</h1>
				<div class="row col-md-4 ms-5 mt-5">
					<table class="table table-striped table-hover">

						<thead>
							<tr>
								<th>번호</th>
								<th>상품명</th>
								<th>이자율</th>
							</tr>
						</thead>
						<tbody>
								<tr>
									<td>${detail.product_id}</td>
									<td>${detail.product_type}</td>
									<td>${detail.product_rate}</td>
								</tr>
						</tbody>
					</table>
				</div>
				
				<div>
					<c:forEach items="${detail.fileDTOs}" var="f">
						<a href="/resources/upload/products/${f.filename}">${f.oriname}</a>
					</c:forEach>
				</div>
				
				<div id="wishResult">


				</div>


				<div>
					<a href ="../account/add?product_id=${detail.product_id}" class="btn btn-primary" role="button">상품가입</a>
					<a href ="delete?product_id=${detail.product_id}" class="btn btn-primary" role="button">삭제</a>
					<a href ="update?product_id=${detail.product_id}" class="btn btn-primary" role="button">수정</a>
					<button id ="addWish" type=button class ="btn btn-primary" data-product-id="${detail.product_id}">관심목록추가</button>
					
				</div>        
            </div>
       </div>
     </div>



	<<script src="/resources/js/product/wish.js"></script>
	<c:import url="/WEB-INF/views/templete/footerscript.jsp"></c:import>
</body>
</html>




