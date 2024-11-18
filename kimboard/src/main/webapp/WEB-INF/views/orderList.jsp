<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>주문 내역</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
        <h2 class="text-center mb-4">주문 내역</h2>
        
        <!-- 주문 내역 테이블 -->
        <table class="table table-bordered table-striped">
            <thead class="table-light">
                <tr>
                    <th scope="col">주문 번호</th>
                    <th scope="col">주문 날짜</th>
                    <th scope="col">상품명</th>
                    <th scope="col">수량</th>
                    <th scope="col">상태</th>
                    <th scope="col">가격</th>
                    <th scope="col">상세 보기</th>
                </tr>
            </thead>
            <tbody>
                <!-- 첫 번째 주문 내역 -->
                <tr>
                    <td>ORD123456</td>
                    <td>2024-11-01</td>
                    <td>아이폰 14</td>
                    <td>1</td>
                    <td><span class="badge bg-success">배송 완료</span></td>
                    <td>1,200,000원</td>
                    <td><a href="#" class="btn btn-info btn-sm">상세 보기</a></td>
                </tr>
                <!-- 두 번째 주문 내역 -->
                <tr>
                    <td>ORD123457</td>
                    <td>2024-10-28</td>
                    <td>삼성 갤럭시 Z</td>
                    <td>2</td>
                    <td><span class="badge bg-warning">배송 중</span></td>
                    <td>2,400,000원</td>
                    <td><a href="#" class="btn btn-info btn-sm">상세 보기</a></td>
                </tr>
                <!-- 세 번째 주문 내역 -->
                <tr>
                    <td>ORD123458</td>
                    <td>2024-10-20</td>
                    <td>애플 워치</td>
                    <td>1</td>
                    <td><span class="badge bg-danger">취소됨</span></td>
                    <td>500,000원</td>
                    <td><a href="#" class="btn btn-info btn-sm">상세 보기</a></td>
                </tr>
            </tbody>
        </table>

        <!-- 주문 내역 없을 때 메시지 -->
        <div class="alert alert-info text-center" role="alert">
            아직 주문 내역이 없습니다.
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>