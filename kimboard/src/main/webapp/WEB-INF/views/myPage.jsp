<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>마이 페이지</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.8.1/font/bootstrap-icons.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
        <!-- 사용자 정보 섹션 -->
        <div class="d-flex align-items-center mb-4">
            <!-- 아이디와 알림, 설정, 장바구니 -->
            <h2 class="me-3">아이디님</h2>
            <div>
                <a href="#" class="text-decoration-none me-2"><i class="bi bi-bell"></i> 알림</a>
                <a href="#" class="text-decoration-none"><i class="bi bi-cart"></i> 장바구니</a>
            </div>
        </div>

        <!-- 로그인 여부에 따라 보여줄 링크 -->
        <div class="mb-4">
            <a href="#" class="btn btn-outline-primary btn-sm">로그인/회원가입하기</a>
        </div>

        <!-- 적립금, 쿠폰, 후기 -->
        <div class="row text-center mb-4">
            <div class="col">
                <h5>적립금</h5>
                <p>1,000원</p>
            </div>
            <div class="col">
                <h5>쿠폰</h5>
                <p>3장</p>
            </div>
            <div class="col">
                <h5>작성한 후기</h5>
                <p>5건</p>
            </div>
        </div>

        <hr>

        <!-- 마이 페이지 메뉴 -->
        <ul class="list-group">
        	<li class="list-group-item">
                <a href="#" class="text-decoration-none text-dark d-flex align-items-center">
                    <i class="bi bi-arrow-repeat me-3"></i> 회원 정보 수정
                </a>
            </li>
            <li class="list-group-item">
                <a href="#" class="text-decoration-none text-dark d-flex align-items-center">
                    <i class="bi bi-card-list me-3"></i> 주문내역
                </a>
            </li>
            <li class="list-group-item">
                <a href="#" class="text-decoration-none text-dark d-flex align-items-center">
                    <i class="bi bi-arrow-repeat me-3"></i> 취소/반품/교환 내역
                </a>
            </li>
            <li class="list-group-item">
                <a href="#" class="text-decoration-none text-dark d-flex align-items-center">
                    <i class="bi bi-eye me-3"></i> 최근 본 상품
                </a>
            </li>
        </ul>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>