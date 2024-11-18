<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    댓글 목록 <br>
  <table class="table">
	<form>
	<div class="form-group1">
	<c:forEach var="boardreply" items="${list}">
		<tr>
			<td>작성자 : ${boardreply.rewriter}    작성일자 : ${boardreply.redate} </td>
		</tr>
		<tr>
			<td><textarea name="rememo" rows="5" cols="40"
				readonly="readonly" class="form-control1">${boardreply.rememo}</textarea>
			</td>
			<td><a href="replyupdate?reno=${boardreply.reno}">댓글수정</a>
			<button class="btn btn-defalut">댓글수정</button>
			<script>
			$(function(){
				//댓글수정 버튼을 눌렀을 때 처리
				$(".btn-defalut").click(function(){
					location.href="replyupdate?reno=" + ${boardreply.reno}; 
				});
			})		
			</script>
			</td>
		</tr>
	</c:forEach>
	</table>
	</div>
			

</form>	
    </section>
