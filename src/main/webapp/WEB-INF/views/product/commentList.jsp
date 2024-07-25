<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<table>
    <tbody>
        <c:forEach items="${list}" var="comment">
            <tr>
                <td>${comment.board_contents}</td>
                <td>${comment.board_writer}</td>
                <td>${comment.create_date}</td>
                <td><c:if test="${comment.board_writer eq member.m_id}"><button class="commentDel cd" type="button" deta-delete-btn="${comment.board_num}">X</button></c:if></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<nav aria-label="Page navigation example">
    <ul class="pagination">
      <li class="page-item ${pager.pre?'':'disabled'}">
        <a class="page-link pn" data-page-num="${page.startNum-1}" href="#" aria-label="Previous">
          <span aria-hidden="true">&laquo;</span>
        </a>  
      </li>
  
      <!--  for(int i=0; i<=10; i=i+2-->
      <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1" var="i">
          <li class="page-item"><a class="page-link pn"  data-page-num="${i}" href="#">${i}</a></li>    
      </c:forEach>
  
      <li class="page-item ${pager.next?'':'disabled'}">
          <a class="page-link pn"  data-page-num="${pager.lastNum+1}" href="#" aria-label="Next">
              <span aria-hidden="true">&raquo;</span>
           </a>
      </li>
    </ul>
  </nav>
