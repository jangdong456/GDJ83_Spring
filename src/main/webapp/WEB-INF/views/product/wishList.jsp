<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<c:import url="/WEB-INF/views/templete/header_css.jsp"></c:import>
<body id="page-top">
<div id="wrapper">
    <c:import url="/WEB-INF/views/templete/sidebar.jsp"></c:import>
    <div id="content-wrapper" class="d-flex flex-column"> 
        <div id="content">
            <c:import url="/WEB-INF/views/templete/topbar.jsp"></c:import>
            <div class="col-md-10 ms-10 mt-4">   
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>
                                <input type="checkbox">
                            </th>
                            <th>번호</th>
                            <th>상품명</th>
                            <th>이자율</th>
                            <th>상품설명</th>
                        </tr>
                    </thead>
                    
                    <tbody>
                        <c:forEach items="${list}" var="map" varStatus="i">
                            <tr id="w${i.index}">
                                <td>
                                    <input type="checkbox">
                                </td>
                                <td>${map.product_id}</td>
                                <td>${map.product_type}</td>
                                <td>${map.product_rate}</td>
                                <td>${map.product_detail}</td>
                                
                                <td>
                                    <button type="button" class="btn btn-primary wishDelte" data-del-id="w${i.index}" data-wish-id="${map.product_id}">X</button>
                                </td>
                            </tr>
                        </c:forEach>		
                    </tbody>
                </table>
            </div>
        </div>    
    </div>   
</div>
    <c:import url="/WEB-INF/views/templete/footerscript.jsp"></c:import>
    <script src="/resources/js/product/wishdelete.js"></script>
</body>
</html>
