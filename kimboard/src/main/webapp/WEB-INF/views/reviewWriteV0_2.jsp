<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>후기 작성하기</title>
<script src="/resources//ckeditor/ckeditor.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <style>
        .star-rating {
            display: inline-block;
            direction: rtl;
        }
        .star-rating input {
            display: none;
        }
        .star-rating label {
            font-size: 2rem;
            cursor: pointer;
        }
        .star-rating .star {
            color: #ddd;
        }
        .star-rating input:checked ~ label .star,
        .star-rating label:hover .star,
        .star-rating label:hover ~ label .star {
            color: #f39c12; /* 선택된 별 색상 */
        }
    </style>
</head>
<body>
<div class="container mt-5">
        <h2 class="text-center mb-4">후기 작성하기</h2>
        
        <form action="/submitReview" method="post">
            <!-- 상품 선택 -->
            <div class="mb-3">
                <label for="product" class="form-label">상품 선택</label>
                <select class="form-select" id="product" name="product" required>
                    <option value="아이폰 14">아이폰 14</option>
                    <option value="삼성 갤럭시 Z">삼성 갤럭시 Z</option>
                    <option value="애플 워치">애플 워치</option>
                </select>
            </div>
			
			 <div class="mb-3">
                <label for="content" class="form-label">후기 내용</label>
                <textarea class="form-control" id="content" name="content" rows="5" placeholder="후기를 남겨주세요." required></textarea>
            </div>

            <!-- 평점 -->
            <div class="mb-3">
                 <label class="form-label">평점</label>
                <div class="star-rating">
                    <!-- 별 모양 라디오 버튼 -->
                    <input type="radio" id="star5" name="rating" value="5">
                    <label for="star5"><i class="fas fa-star star"></i></label>
                    
                    <input type="radio" id="star4" name="rating" value="4">
                    <label for="star4"><i class="fas fa-star star"></i></label>

                    <input type="radio" id="star3" name="rating" value="3">
                    <label for="star3"><i class="fas fa-star star"></i></label>

                    <input type="radio" id="star2" name="rating" value="2">
                    <label for="star2"><i class="fas fa-star star"></i></label>

                    <input type="radio" id="star1" name="rating" value="1">
                    <label for="star1"><i class="fas fa-star star"></i></label>
                </div>
            </div>

           

            <!-- 제출 버튼 -->
            <button type="submit" class="btn btn-primary w-100">후기 제출</button>
        </form>
    </div>
	<script>
        	CKEDITOR.replace("content", {
            	filebrowserUploadUrl: "/imageUpload" // 이미지 업로드 경로
        	});
     </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>