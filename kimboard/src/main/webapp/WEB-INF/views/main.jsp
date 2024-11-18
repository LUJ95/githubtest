<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@include file="include/header.jsp" %>
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">

		<section class="content">
			<div>${contextPath }  <br> 
				 전달 받은 내용 출력 : ${name }
			</div>
			<div><a href="login/loginForm">로그인하기</a></div>
		</section>
	</div>
<%@include file="include/footer.jsp" %>		
