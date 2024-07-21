<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <c:import url="/WEB-INF/views/templete/topbar.jsp"></c:import>

  				<div class="container-fluid mt-5">
            		<div class="col-md-6">
            			<div>
                      		<c:if test="${not empty member.memberFileDTO}">
                      			<img alt="" src="/resources/upload/members/${member.memberFileDTO.filename}">
                      		</c:if>
                      			
                      		<c:if test="${empty member.memberFileDTO}">
                      			<img alt="" src="/resources/upload/members/">
                      		</c:if>
                      	</div>
            		
			            <h3>${member.member_name}</h3>
						<h3>${member.phone}</h3>
						<h3>${member.email}</h3>
						
						<div>
							<a href="./update" class="btn btn-primary">회원수정</a>
							<form action="delete" method="post">
								<button class="btn btn-danger">회원탈퇴</button>
							</form>
						</div>
				  	</div>
				</div>

			<!-- product_info_id -->
<!-- 			<div> -->
<!-- 				<h3>계좌정보</h3> -->
<%-- 				<c:forEach items="${member.dtos}" var = "ac"> --%>
<%-- 					<h3>pk번호 : ${ac.product_info_id}</h3> --%>
<%-- 					<h3><a href="../account/detail?account_number=${ac.account_number}">${ac.account_number}</a> : ${ac.balance}</h3>	 --%>
<%-- 				</c:forEach> --%>
<!-- 			</div> -->
			



        </div>
    </div>
    <c:import url="/WEB-INF/views/templete/footerscript.jsp"></c:import>


</body>
</html>