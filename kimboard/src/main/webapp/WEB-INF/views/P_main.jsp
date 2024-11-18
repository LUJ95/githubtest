<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<!-- cdn css -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<!-- js -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<title>환장하는 회원가입</title>
</head>
<body>
	<%@include file="include/NewHeader.jsp"%>
	<div class="container-fluid p-5 bg-primary text-white text-center">
		<table class="table table-hover">
			<tr>
				<td><img src="dist/img/apple.png" alt="logo" class="user-image"></td>
			</tr>
			<tr>
				<td>회원가입</td>
			</tr>
			<tr>
				<td><input type="text" placeholder="아이디" name="id" id="id"
					class="table-label "> <input type="button" value="아이디 중복확인"
					class="btn btn-success w-10 h-10 p-2"></td>
			</tr>
			<tr>
				<td><input type="password" placeholder="비밀번호" name="pass"
					id="pass"></td>
			</tr>
			<tr>
				<td><input type="password" placeholder="비밀번호 확인" name="pass_ck"
					id="pass_ck"> <input type="button" value="비밀번호 중복확인">
				</td>
			</tr>
			<tr class="cols">
				<td class="row-1"><input type="text" placeholder="이름을 입력해주세요." name="name"
					id="name"></td>
				<td class="row-2"><input type="datetime" placeholder="생년월일을 입력해주세요."
					name="datetime" id="datetime"></td>
			</tr>
			<tr>
				<td>성별<br> <input type="radio" value="남성" name="gender"
					id="maile">남성 &nbsp; <input type="radio" value="여성"
					name="gender" id="femail">여성
				</td>
			</tr>
			<tr>
				<td><select>
						<option selected>대한민국 +82</option>
						<option>이집트 +20</option>
						<option>미국 +1</option>
				</select><br> <input type="text" placeholder="휴대전화번호" name="phone_num"
					id="phone_num"></td>
			</tr>
			<tr>
				<td><input type="email" placeholder="email" name="email"
					id="email" class="table-label "> <a>@</a> <select>
						<option disabled selected>select pz your email</option>
						<option>@naver.com</option>
						<option>@google.com</option>
						<option>@daum.net</option>
						<option>@yahoo.com</option>
						<option>@nate.com</option>
				</select></td>
			</tr>
		</table>

		<button type="submit" onclick="return joinCheck()"
			class="btn btn-danger">회원가입</button>
		<a href="main2" class="text-black">main2이동</a>
		<a href="index" class="text-black">index이동</a>
		<a href="reviewWrite" class="text-black">reviewWrite이동</a> 
		<a href="myPage" class="text-black">myPage이동</a>
		<a href="myEdit" class="text-black">myEdit이동</a>
		
		<a href="orderList" class="text-black">orderList이동</a>
		<a href="orderDetail" class="text-black">orderDetail이동</a>
		<a href="reviewWriteV0_2" class="text-black">reviewWriteV0_2이동</a>
		<a href="index" class="text-black">index이동</a>
	</div>
	<%@include file="include/Newfooter.jsp"%>
</body>
</html>
