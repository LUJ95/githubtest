<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<%@ include file="include/head.jsp"%>
<script>
<!--페이징리스트 next , prev -->
	function commentList(board_id, pageNum) {
		$
				.ajax({
					url : '/commentlist',
					type : 'POST',
					data : {
						'board_id' : board_id,
						'page' : pageNum
					},
					dataType : "json",
					success : function(data) {
						var a = '';
						var page = data.page;
						var startpage = data.startpage;
						var endpage = data.endpage;
						var boardList = data.boardList;

						$
								.each(
										boardList,
										function(key, value) {
											console.log("data : " + boardList);
											console.log(boardList);
											console.log(page + "," + startpage
													+ "," + endpage);
											console.log("start : " + startpage);
											console.log("end : " + endpage);
											a += '<div class="commentArea" style="boarder-bottom:1px solid darkgray; margin-bottom: 15px;">';
											a += '<div class="commentInfo'+value.board_re_id+'">'
													+ '댓글번호 : '
													+ value.board_re_id
													+ ' / 작성자 : '
													+ value.mem_id;
											a += '<a onclick="commentUpdate('
													+ value.board_re_id + ',\''
													+ value.board_re_content
													+ '\');"> 수정 </a>';
											a += '<a onclick="commentDelete('
													+ value.board_re_id
													+ ');"> 삭제 </a> </div>';
											a += '<div class="commentContent'+value.board_re_id+'"> <p> 내용 : '
													+ value.board_re_content
													+ '</p>';
											a += '</div></div>';
										});

						for (var num = startpage; num <= endpage; num++) {
							if (num == page) {
								a += '<a href="#" onclick="commentList('
										+ board_id + ', ' + num
										+ '); return false;" class="page-btn">'
										+ num + '</a>';
							} else {
								a += '<a href="#" onclick="commentList('
										+ board_id + ', ' + num
										+ '); return false;" class="page-btn">'
										+ num + '</a>';
							}
						}
						$('.commentList').html(a);
					}
				});
	}
</script>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<!-- Main Header -->
		<!-- 기존 Header -->
		<%-- <%@ include file="include/main_header.jsp"%> --%>

		
		<!-- Left side column. contains the logo and sidebar -->

		<%-- <%@ include file="include/left_column.jsp"%> --%>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					Page Header <small>Optional description</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="/"><i class="fa fa-dashboard"></i> Level</a></li>
					<li class="active">Here</li>
				</ol>
			</section>

			<!-- Main content -->

			<section class="content container-fluid">
				<div>${msg}</div>
				<div class="table-responsive">
					<table class="table">
						<tr>
							<td>글번호</td>
							<td>제목</td>
							<td>작성일</td>
							<td>작성자</td>
							<td>조회수</td>
						</tr>
						<c:forEach var="board" items="${list }">
							<tr>
								<td>${board.bno}</td>
								<td><a href="detail?bno=${board.bno}"> ${board.title} </a></td>
								<td>${board.regdate}</td>
								<td>${board.id}</td>
								<td><span class="badge">${board.readcnt }</span></td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="5" align="center"><input
								class="btn btn-success" type="button" value="메인으로" id="main" />
								<script>
								$(function(){
									$(".btn-success").click(function(){
										location.href="../";
									})		
								})
						</script></td>
						</tr>
					</table>
					<!-- 페이징 처리 시작 -->
					<div class="paging" style="text-align: center; color: #be0000;">
						<c:forEach var="i" begin="1" end="${totalPage}">
							<a href="list?pageNUM=${i }">${i }</a>
						</c:forEach>
						<a style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;[${totalPage}]</a>
					</div>

					<!-- 페이징 처리 끝 -->
					<div class="box">
						<div class="box-header with-border">
							<a href="/board/register"><h3 class="box-title"
									style="text-align: center; color: #03fc49;">게시판 글쓰기</h3></a>
						</div>
					</div>
				</div>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- Main Footer -->
		<%@ include file="include/main_footer.jsp"%>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Create the tabs -->
			<ul class="nav nav-tabs nav-justified control-sidebar-tabs">
				<li class="active"><a href="#control-sidebar-home-tab"
					data-toggle="tab"><i class="fa fa-home"></i></a></li>
				<li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i
						class="fa fa-gears"></i></a></li>
			</ul>
			<!-- Tab panes -->
			<div class="tab-content">
				<!-- Home tab content -->
				<div class="tab-pane active" id="control-sidebar-home-tab">
					<h3 class="control-sidebar-heading">Recent Activity</h3>
					<ul class="control-sidebar-menu">
						<li><a href="javascript:;"> <i
								class="menu-icon fa fa-birthday-cake bg-red"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

									<p>Will be 23 on April 24th</p>
								</div>
						</a></li>
					</ul>
					<!-- /.control-sidebar-menu -->

					<h3 class="control-sidebar-heading">Tasks Progress</h3>
					<ul class="control-sidebar-menu">
						<li><a href="javascript:;">
								<h4 class="control-sidebar-subheading">
									Custom Template Design <span class="pull-right-container">
										<span class="label label-danger pull-right">70%</span>
									</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-danger"
										style="width: 70%"></div>
								</div>
						</a></li>
					</ul>
					<!-- /.control-sidebar-menu -->

				</div>
				<!-- /.tab-pane -->
				<!-- Stats tab content -->
				<div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab
					Content</div>
				<!-- /.tab-pane -->
				<!-- Settings tab content -->
				<div class="tab-pane" id="control-sidebar-settings-tab">
					<form method="post">
						<h3 class="control-sidebar-heading">General Settings</h3>

						<div class="form-group">
							<label class="control-sidebar-subheading"> Report panel
								usage <input type="checkbox" class="pull-right" checked>
							</label>

							<p>Some information about this general settings option</p>
						</div>
						<!-- /.form-group -->
					</form>
				</div>
				<!-- /.tab-pane -->
			</div>
		</aside>
		<!-- /.control-sidebar -->
		<!-- Add the sidebar's background. This div must be placed
  immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->
	<%@ include file="include/plugin_js.jsp"%>
</body>
</html>