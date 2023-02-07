<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>navigationBar</title>
<!-- jQuery library -->
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<style>
/*제목 부제목 공통 속성*/
.title, .subhead {
	border: none;
	font-weight: bold;
	!
	important /* margin-top: 5%; */
}
/*제목 속성*/
.title {
	font-size: 20px;
	color: rgb(236, 206, 103);;
	/* margin-top: 10%; */
}
/*부제목 속성*/
.subhead {
	margin-top: 10px;
}
/*a태그 스타일속성x*/
a {
	text-decoration: none;
	color: inherit;
}
/*hr 구분선 길이 높이 속성*/
hr {
	width: 180px;
	margin-top: 3%;
}
</style>
</head>
<body>
	<div id="nav"
		style="text-align: center; border: initial; padding-top: 150px;">

		<div class="title">일반게시판 관리</div>
		<div class="subhead">
			<a href="<%=request.getContextPath()%>/adminBoardView.bo?cPage=1">전체게시판</a>
		</div>
		<div class="subhead">
			<a
				href="<%=request.getContextPath()%>/adminBoardView.bo?cPage=1&bt=B1">공지사항</a>
		</div>
		<div class="subhead">
			<a
				href="<%=request.getContextPath()%>/adminBoardView.bo?cPage=1&bt=B4">자유게시판</a>
		</div>
		<hr>
		<div class="title">레시피 게시판 관리</div>
		<div class="subhead">
			<a
				href="<%=request.getContextPath()%>/adminBoardView.bo?cPage=1&bt=B2">오늘의
				레시피</a>
		</div>
		<div class="subhead">
			<a
				href="<%=request.getContextPath()%>/adminBoardView.bo?cPage=1&bt=B3">레시피게시판</a>
		</div>
		<div class="subhead">
			<a href="<%=request.getContextPath()%>/adminBestView.bo?cPage=1">이달의레시피
				관리</a>
		</div>
		<hr>
		<div class="title">회원관리</div>
		<div class="subhead">
			<a href="<%=request.getContextPath()%>/adminMemberView.me?cPage=1">회원목록
				조회</a>
		</div>
		<hr>
		<div class="title">문의 관리</div>
		<div class="subhead">
			<a
				href="<%=request.getContextPath()%>/adminBoardView.bo?cPage=1&bt=B5">1대1
				문의게시판</a>
		</div>
		<div class="subhead">
			<a>답변 미등록글 조회</a>
		</div>
		<hr>
		<div class="title">데이터베이스 관리</div>
		<div class="subhead">
			<a href="<%=request.getContextPath()%>/adminIngrdList.da?cPage=1">레시피
				재료</a>
		</div>
		<div class="subhead">
			<a href="<%=request.getContextPath()%>/adminDoseList.da?cPage=1">정량
				단위</a>
		</div>
	</div>
	<script>
		$(function() {
			$("#nav a").css("font-weight", "bold");
		})
	</script>
</body>
</html>