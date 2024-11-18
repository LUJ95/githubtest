<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>주문 상세 내역</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
 <div class="container mt-5">
        <h2 class="text-center mb-4">주문 상세 내역</h2>
        
        <!-- 주문 정보 테이블 -->
        <table class="table table-bordered">
            <thead class="table-light">
                <tr>
                    <th colspan="2" class="text-center">주문 정보</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">주문 번호</th>
                    <td>ORD123456</td>
                </tr>
                <tr>
                    <th scope="row">주문 날짜</th>
                    <td>2024-11-01</td>
                </tr>
                <tr>
                    <th scope="row">결제 방법</th>
                    <td>신용카드</td>
                </tr>
                <tr>
                    <th scope="row">배송 상태</th>
                    <td><span class="badge bg-success">배송 완료</span></td>
                </tr>
                <tr>
                    <th scope="row">총 금액</th>
                    <td>1,200,000원</td>
                </tr>
            </tbody>
        </table>

        <!-- 상품 내역 -->
        <h4>상품 내역</h4>
        <table class="table table-bordered">
            <thead class="table-light">
                <tr>
                    <th>상품명</th>
                    <th>수량</th>
                    <th>단가</th>
                    <th>금액</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>아이폰 14</td>
                    <td>1</td>
                    <td>1,200,000원</td>
                    <td>1,200,000원</td>
                </tr>
            </tbody>
        </table>

        <!-- 배송 주소 -->
        <h4>배송 주소</h4>
        <table class="table table-bordered">
            <tbody>
                <tr>
                    <th scope="row">받는 사람</th>
                    <td>홍길동</td>
                </tr>
                <tr>
                    <th scope="row">주소</th>
                    <td>서울시 강남구 테헤란로 123, 3층</td>
                </tr>
                <tr>
                    <th scope="row">연락처</th>
                    <td>010-1234-5678</td>
                </tr>
            </tbody>
        </table>

        <!-- 배송 추적 링크 -->
        <div class="mb-4">
            <a href="#" class="btn btn-primary">배송 추적</a>
        </div>

        <!-- 취소 버튼 -->
        <div class="mb-4">
            <a href="#" class="btn btn-danger">주문 취소</a>
        </div>

        <!-- 후기 작성 버튼 -->
        <div class="mb-4">
            <a href="#" class="btn btn-secondary">후기 작성하기</a>
        </div>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>