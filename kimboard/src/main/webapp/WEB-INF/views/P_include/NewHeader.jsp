<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page session="true"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New main header</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<script src="${contextPath}/resources/jQuery/jquery-3.4.1.min.js"></script>
<script src="${contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>

</head>
<body class="skin-black sibebar-mini">

	<div class="NewHeader">
		<header class="mainH">
			<div class="left-Header">
				<header class="LeftH">
					<li><img src="./P-img/apple.png" width="80" height="80" alt="logo" href="main"></li>
					<li><select class="language">
							<option>ENG</option>
							<option selected>KR</option>
					</select></li>
					<li><img src="" name="serchImg"></li>
					<li><input type="search" value="search all" name="검색"></li>
				</header>
			</div>
			<div class="right-Header" style="">
				<header class="RightH">
					<li><a href="">로그인</a></li>
					<li><a href="">내정보</a></li>
					<li><a href="" hidden>페이지 관리</a></li>
					<li><input type="button" value="로그아웃" onclick=""></li>
				</header>
			</div>

		</header>


	</div>



</body>
</html>