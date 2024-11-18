<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>내 정보 수정</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
        <h2 class="text-center mb-4">회원정보 수정</h2>
        
        <form action="/updateProfile" method="post">
            <!-- 이름 -->
            <div class="mb-3">
                <label for="username" class="form-label">이름</label>
                <input type="text" class="form-control" id="username" name="username" required value="value로 원래 정보 띄우기 아래 다 동일">
            </div>
            
            <!-- 이메일 -->
            <div class="mb-3">
                <label for="email" class="form-label">이메일</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            
            <!-- 비밀번호 -->
            <div class="mb-3">
                <label for="password" class="form-label">새 비밀번호</label>
                <input type="password" class="form-control" id="password" name="password">
                <small class="form-text text-muted">비밀번호를 변경하지 않으려면 비워 두세요.</small>
            </div>
            
            <!-- 연락처 -->
            <div class="mb-3">
                <label for="phone" class="form-label">연락처</label>
                <input type="tel" class="form-control" id="phone" name="phone" placeholder="010-1234-5678" required>
            </div>
            
            <!-- 주소 -->
            <div class="mb-3">
                <label for="address" class="form-label">주소</label>
                <input type="text" class="form-control" id="address" name="address" required>
            </div>
            
            <!-- 수정 버튼 -->
            <button type="submit" class="btn btn-primary w-100">수정 완료</button>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>