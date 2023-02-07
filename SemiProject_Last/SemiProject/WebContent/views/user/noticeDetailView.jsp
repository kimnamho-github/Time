<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.user.board.notice.model.vo.Notice"%>
<%
	Notice n = (Notice) request.getAttribute("notice");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세보기</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<!-- Popper JS -->
<!--<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script> -->
<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="resources/css/view.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap"
	rel="stylesheet">
<!-- <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->
<style>
@font-face {
	font-family: 'NanumSquareRound';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_two@1.0/NanumSquareRound.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

#rbtn-u, #rbtn-d, #rbtn-l {
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
	height: auto;
	background-color: rgba(104, 100, 100, 0.163);
	margin: auto;
	margin-top: 20px;
	margin-bottom: 100px;
	border-radius: 15px;
	box-shadow: 3px 3px 4px 3px rgba(128, 128, 128, 0.334);
}

#list1 {
	margin-top: 14px;
	height: 72px;
	margin-bottom: 50px;
	background-color: rgba(236, 205, 103, 0.727);
	border-radius: 6px;
}

#r-logo { /*위에 종*/
	margin-right: 4px;
	margin-bottom: 3px;
	width: 18px;
	height: 18px;
}

#ntt { /*공지사항 작성*/
	padding: 27px;
	margin-right: 4px;
	margin-left: 10px;
	font-size: 20px;
	margin-bottom: 30px;
	color: black;
	font-weight: bold;
}

.rbtng1 {
	/*취소/등록 버튼*/
	margin: auto;
	font-size: 12px;
}

.rbtng1 a {
	text-decoration: none;
	/*밑줄 없애기*/
	color: black;
}

.rbtng1 .rbtn1 {
	background-color: rgba(186, 185, 180, 0.308);
	border: none;
	color: black;
	margin: 8px;
	padding: 8px 30px;
	border-radius: 4px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	cursor: pointer;
	box-shadow: 1px 1px 1px 1px rgba(128, 128, 128, 0.334);
}

#rbtn-l {
	background-color: rgba(236, 205, 103, 0.727);
}

.rbtng1 .rbtn1#rbtn-l:hover {
	background-color: rgb(236, 206, 103);
}

.rbtng1 .rbtn1#rbtn-u:hover {
	background-color: rgba(85, 170, 24, 0.205);
}

.rbtng1 .rbtn1#rbtn-d:hover {
	background-color: rgba(240, 68, 25, 0.274);
}

.hh {
	width: 900px;
	height: 570px;
	background-color: rgba(250, 248, 248, 0.12);
	box-shadow: 2px 2px 2px 3px rgba(128, 128, 128, 0.334);
	border-radius: 8px;
	padding: 28px;
	margin: auto;
}

.q2 { /*제목*/
	color: black;
	font-weight: bold;
	width: 100%;
}

#q3 { /*작성일 0*/
	color: gray;
	font-size: 15px;
	float: right;
	margin-top: 5px;
	/* margin-left: 678px;*/
}

#q5 { /*작성자 0*/
	color: gray;
	font-size: 16px;
	font-weight: bold;
}

#q6 { /*내용*/
	color: black;
	font-size: 16px;
}

#o1 {
	padding: 8px;
	border-bottom-style: double;
	border-color: gray;
}

#o2 {
	padding: 8px;
	border-bottom-style: solid;
	border-width: 2px;
	border-color: gray;
}

#o3 {
	padding: 8px;
}

#o4 {
	padding: 20px;
}

#pp {
	width: 30px;
	height: 30px;
	border-radius: 80px;
	margin-right: 5px;
	float-left: right;
}

#rreply-area {
	margin-bottom: 50px;
}

#replyContent {
	border-radius: 8px;
	box-shadow: 1px 1px 1px 1px rgba(128, 128, 128, 0.334);
	font-size: 14px;
}

#re {
	font-size: 14px;
	font-weight: bold;
}

#rr {
	font-size: 12px;
	border-radius: 8px;
	box-shadow: 1px 1px 1px 1px rgba(128, 128, 128, 0.334);
	background-color: rgba(236, 205, 103, 0.727);
	border: none;
	color: black;
	margin: 8px;
	padding: 8px 20px;
	border-radius: 4px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	cursor: pointer;
	box-shadow: 1px 1px 1px 1px rgba(128, 128, 128, 0.334);
}

#reply-area tbody {
	font-size: 15px;
	border-bottom-style: solid;
}
</style>
</head>
<body>
	<%@include file="/views/common/menubar.jsp"%>

	<div class="outer1">
		<div id="list1">
			<h5 id="ntt">
				<img src="resources/image/common/megaphone.png" id="r-logo">공지사항
			</h5>
		</div>
		<div class="hh">
			<div id="o1">
				<b style="font-size: 18px;"><%=n.getBoardTitle()%> </b>
			</div>
			<div id="o2">
				<b id="q5"><img src="resources/image/common/다운로드.jfif" id="pp"><%=n.getBoardWriter()%></b><b
					id="q3"><img src="resources/image/common/calendar.png"
					id="r-logo"><%=n.getCreatedDate()%></b>
			</div>
			<div id="o4">
				<b id="q6" style="overflow: hiddlen; word-break: break-all;"
					style="resize: none;"><%=n.getBoardContent()%></b>
			</div>
		</div>
		<br>
		<div class="rbtng1" align="center">
			<%
				if (loginUser != null && loginUser.getMemberId().equals("admin")) {
			%>
			<a style="font-size: 12px;"
				href="<%=contextPath%>/updateForm.in?nno=<%=n.getBoardNo()%>"
				class="rbtn1" id="rbtn-u" onclick="textArea();">수정</a> <a
				style="font-size: 12px;" href="<%=contextPath%>/list.in"
				class="rbtn1" id="rbtn-l">목록</a> <a style="font-size: 12px;"
				class="rbtn1" id="rbtn-d" onclick="return chk();">삭제</a>
			<%
				}
			%>
		</div>
		<br>
		<div id="reply-area">
			<table align="center" margin-bottom="3px;">
				<thead id="reply-area1">
					<tr id="rrr">
						<th id="re">댓글작성</th>
						<td><textarea id="replyContent" rows="3" cols="70"
								style="resize: none"></textarea></td>
						<td><button onclick="insertReply();" id="rr">댓글 작성</button></td>
					</tr>
				</thead>
				<br>
				<tbody>
				</tbody>
			</table>
			<br> <br>
		</div>
		<script>
        $(function() {
			console.log($(".rbtn1"));
			selectReplyList();
		});
        
        function chk() {
            var result = confirm("정말로 삭제시겠습니까?");
            if(result){
            	location.href="<%=contextPath%>/deleteForm.in?nno=<%=n.getBoardNo()%>";
			}
			return result;
		}
		</script>
	</div>
	<%@include file="/views/common/footer.jsp"%>
	<script>
		function textArea() {
			var str = document.getElementById("replyContent").value;
			str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');
			document.getElementById("replyContent").value = str;
		}
	</script>
	<script>
		function insertReply() {
			$.ajax({
				url : "rinsert.no",
				data : {
					nno : <%=n.getBoardNo()%>,
					comments_content : $("#replyContent").val(),
					board_code : "B1"
				    },
				type : "post",
				success : function(result) {
					if (result > 0) {
						console.log("댓글작성 성공");
						selectReplyList();
					} else {
						console.log("댓글작성 실패");
					}
				},
				error : function() {
					console.log("통신 실패");
				}
			});
		}
		function selectReplyList() {
			$.ajax({
				url : "rlist.no",
				data : {
					nno : <%=n.getBoardNo()%>
				},
				success : function(rlist) {
					let str = "";
					console.log(rlist);
					for (let i = 0; i < rlist.length; i++) {
						str += "<tr>" + "<td>" + rlist[i].comments_writer
								+ "</td>" + "<td>" + rlist[i].comments_content
								+ "</td>" + "<td>" + rlist[i].created_date
								+ "</td>" + "</tr>";
					}
					$("#reply-area tbody").html(str);
				},
				error : function() {
					console.log("통신 실패");
				}
			});
		}
	</script>
</body>
</html>