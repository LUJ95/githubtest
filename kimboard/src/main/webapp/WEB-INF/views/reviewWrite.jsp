<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<script src="/resources//ckeditor/ckeditor.js"></script>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>리뷰 작성 페이지</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	 <div class="container mt-5">
        <h2 class="text-center">후기 작성 폼</h2>
        <form action="/submit" method="post" enctype="multipart/form-data">
            <!-- 제목 입력란 -->
            <div class="form-group">
                <label for="title">제목</label>
                <input type="text" class="form-control" id="title" name="title" required>
            </div>

            <!-- 작성자 입력란 -->
            <div class="form-group">
                <label for="id">작성자</label>
                <input type="text" class="form-control" id="id" name="id" value="작성자 아이디" readonly>
            </div>

            <!-- 내용 입력란 -->
            <div class="form-group">
                <label for="content">내용</label>
                <textarea class="form-control" id="content" name="content" rows="10" required></textarea>
            </div>
            
             <div class="form-group">
                <label for="image">이미지 파일 첨부</label>
                <input type="file" class="form-control-file" id="image" name="image" accept="image/*">
                <small class="form-text text-muted">최대 파일 크기: 5MB, JPG/PNG 형식만 허용</small>
            </div>
            
          
            

            <!-- 제출 버튼 -->
            <button type="submit" class="btn btn-primary btn-block">작성 완료</button>
        </form>
    </div>
    
     <script>
        	CKEDITOR.replace("content", {
            	filebrowserUploadUrl: "/imageUpload" // 이미지 업로드 경로
        	});
     </script>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>