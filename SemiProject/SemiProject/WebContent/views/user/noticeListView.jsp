<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,
								 com.user.board.notice.model.vo.Notice,
								 com.common.model.vo.PageInfo"%>
<%
ArrayList<Notice> nlist = (ArrayList<Notice>) request.getAttribute("nlist");
PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 리스트 뷰</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="resources/css/view.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Bungee+Spice&family=Rubik+Dirt&family=Walter+Turncoat&display=swap"
	rel="stylesheet">
<style>
@font-face {
	font-family: 'NanumSquareRound';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_two@1.0/NanumSquareRound.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}
* {
	font-family: 'NanumSquareRound';
}
.outer1 {
	width: 1200px;
	height: 800px;
	background-color: rgba(104, 100, 100, 0.163);
	margin: auto;
	margin-top: 20px;
	margin-bottom: 80px;
	border-radius: 15px;
	box-shadow: 3px 3px 4px 3px rgba(128, 128, 128, 0.334);
}
#nt { /*공지사항*/
	padding: 27px;
	margin-right: 4px;
	margin-left: 10px;
	font-size: 20px;
	margin-bottom: 30px;
	color: black;
	font-weight: bold;
}
.list-area {
	text-align: center;
	font-size: 17px;
}
.list-area>tbody>tr:hover {
	background-color: rgba(236, 205, 103, 0.237);
	cursor: pointer;
}
#t1 { /*글번호/제목/작성자/조회수/작성일*/
	font-weight: bold;
	font-size: 18px;
}
.btn-r a {
	text-decoration: none;
	/*밑줄 없애기*/
	color: black;
}
.btn-r {
	display: inline-block;
	border-radius: 5px;
	background-color: rgb(236, 206, 103);
	border: none;
	color: black;
	text-align: center;
	font-size: 5px;
	padding: 8px;
	width: 150px;
	transition: all 0.5s;
	cursor: pointer;
	margin-left: 520px;
	margin-top: 5px;
	margin-bottom: 30px;
	box-shadow: 1px 2px 1px 1px rgba(128, 128, 128, 0.334);
}
.btn-r span {
	cursor: pointer;
	display: inline-block;
	position: relative;
	transition: 0.5s;
	font-size: 14px;
}
.btn-r span:after {
	content: '\00bb';
	position: absolute;
	opacity: 0;
	top: 0;
	right: -20px;
	transition: 0.5s;
}
.btn-r:hover span {
	padding-right: 25px;
	color: black;
}
.btn-r:hover span:after {
	opacity: 1;
	right: 0;
}
#r-logo { /*위에 종*/
	margin-right: 4px;
	margin-bottom: 3px;
	width: 18px;
	height: 18px;
}
#r-logo1 {
	margin-right: 4px;
	margin-bottom: 4px;
	margin-top: 4px;
	width: 18px;
	height: 18px;
}
.pagination {
	display: inline-block;
	width: 100%;
	margin: auto;
	margin-bottom: 60px;
	margin-top: 140px;
}
.paging-b {
	background-color: rgb(224, 224, 224);
	color: black;
	border-radius: 4px;
	margin: 4px;
	padding: 8px 15px;
	text-decoration: none;
	border: none;
	font-size: 15px;
	box-shadow: 1px 2px 1px 1px rgba(128, 128, 128, 0.334);
}
.paging-b:hover:not (.active ) {
	background-color: rgb(236, 206, 103);
	border-radius: 4px;
	color: white;
}
#t1 {
	background-color: rgb(224, 224, 224);
}
#list1 {
	margin-top: 7px;
	height: 9%;
	margin-bottom: 40px;
	background-color: rgba(236, 205, 103, 0.727);
	border-radius: 6px;
}
#list2 {
	margin-top: 22px;
	height: 42%;
	padding-right: 75px;
	padding-left: 75px;
	font-size: 14px;
}
#l1 { /*공지*/
	color: rgba(239, 59, 59, 0.704);
	font-size: 12px;
	font-weight: bold;
}
#t2 {
	font-weight: bold;
}
.tt {
	background-color: rgba(224, 224, 224, 0.704);
}
#te {
	background-color: rgba(104, 100, 100, 0.163);
	font-weight: bold;
	color: gray;
}
.ff {
	margin-top: 80px;
	margin-right: 77px;
	float: right;
}
#ri {
    margin-top: 160px;
}
</style>
</head>
<body>
	<%@include file="/views/common/menubar.jsp"%>
	<div class="outer1">
		<div id="list1">
			<h5 id="nt">
				<img src="resources/image/common/bell.png" id="r-logo">공지사항
			</h5>
		</div>
		<div id="list2">
			<table class="table table-hover" id="list-area">
				<thead class="tt" align="center">
					<tr>
						<th scope="col">No.</th>
						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">작성일</th>
						<th scope="col">조회수</th>
					</tr>
				</thead>
				<tbody>
					<%
						if (nlist.isEmpty()) {
					%>
					<%
						} else {
					%>
					<tr id="t2">
						<td width="30" id="l1" align="center">공지</td>
						<td width="500"><img
							src="resources/image/common/megaphone.png" id="r-logo">레시피작성시
							주의사항 안내</td>
						<td width="150" align="center">admin</td>
						<td width="150" align="center">2022-11-09</td>
						<td width="100" align="center">167</td>
					</tr>
					<tr id="t2">
						<td width="35" id="l1" align="center">공지</td>
						<td width="500"><img
							src="resources/image/common/megaphone.png" id="r-logo">CookCook
							가이드</td>
						<td width="150" align="center">admin</td>
						<td width="150" align="center">2022-11-10</td>
						<td width="100" align="center">522</td>
					</tr>
					<%
						for (Notice n : nlist) {
					%>
					<tr class="table-light">
						<th id="te" align="center"><%=n.getBoardNo()%></th>
						<td id="te"><%=n.getBoardTitle()%></td>
						<td id="te" align="center"><%=n.getBoardWriter()%></td>
						<td id="te" align="center"><%=n.getCreatedDate()%></td>
						<td id="te" align="center"><%=n.getViews()%></td>
					</tr>
					<%
						}
					%>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
		<br>
		<br>
		<br>
		<div class="ff">
			<%
				if (loginUser != null && loginUser.getMemberId().equals("admin")) {
			%>
			<button class="btn-r" onclick="" style="vertical-align: middle">
				<a href="<%=contextPath%>/enrollForm.in"><img
					src="resources/image/common/bell.png" id="r-logo1"><span>공지사항
						작성</span></a>
			</button>
			<br>
			<%
				}
			%>
		</div>
		<div style="text-align: center;" id="ri">
			<%
				if (pageInfo.getCurrentPage() != 1) {
			%>
			<button class="paging-b"
				onclick="location.href='<%=contextPath%>/list.in?currentPage=<%=pageInfo.getCurrentPage() - 1%>'">&lt;</button>
			<%
				} else {
			%>
			<button class="paging-b" disabled>&lt;</button>
			<%
				}
			%>
			<%
				for (int i = pageInfo.getStartPage(); i <= pageInfo.getEndPage(); i++) {
			%>
			<%
				if (i == pageInfo.getCurrentPage()) {
			%>
			<button class="paging-b" disabled><%=i%></button>
			<%
				} else {
			%>
			<button class="paging-b"
				onclick="location.href='<%=contextPath%>/list.in?currentPage=<%=i%>'"><%=i%></button>
			<%
				}
			%>
			<%
				}
			%>
			<%
				if (pageInfo.getCurrentPage() != pageInfo.getMaxPage()) {
			%>
			<button class="paging-b"
				onclick="location.href='<%=contextPath%>/list.in?currentPage=<%=pageInfo.getCurrentPage() + 1%>'">&gt;</button>
			<%
				}
			%>
		</div>
	</div>
	<script>
	$(function() {
		$("#list-area>tbody>tr").click(function() {
			var nno = $(this).children().eq(0).text();			
			location.href="<%=contextPath%>/detail.in?nno=" + nno;
			});
		});
	</script>
	<%@include file="/views/common/footer.jsp"%>
	<script>
		function textArea() {
			var str = document.getElementById("coutent").value;
			str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');
			document.getElementById("content").value = str;
		}
	</script>
</body>
</html>