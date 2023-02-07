<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@font-face {
	font-family: 'NanumSquareRound';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_two@1.0/NanumSquareRound.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}
#cancel, #save, #ti, #t1 {
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
	margin-bottom: 100px;
	border-radius: 15px;
	box-shadow: 3px 3px 4px 3px rgba(128, 128, 128, 0.334);
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
#list1 {
	margin-top: 14px;
	height: 9%;
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
.en {
	margin-left: 250px;
}
#tii {
	font-size: 16px;
}
#tiii {
	font-size: 16px;
}
#ti {
	border-top: none;
	border-left: none;
	border-right: none;
	border-bottom: none;
	border-radius: 8px;
	font-size: 15px;
	box-shadow: 1px 1px 2px 1px rgba(128, 128, 128, 0.334);
}
#t1 {
	border-top: none;
	border-left: none;
	border-right: none;
	border-bottom: none;
	border-radius: 8px;
	font-size: 15px;
	box-shadow: 1px 1px 2px 1px rgba(128, 128, 128, 0.334);
}
#enroll-form>table {
	border: 1px solid white;
}
#enroll-form input, #enroll-form textarea {
	width: 100%; /*가로길이를 부모요소의 100%로 */
	box-sizing: border-box;
}
.rbtng {
	/*취소/등록 버튼*/
	padding: 30px;
	margin: auto;
}
.rbtng a {
	text-decoration: none;
	/*밑줄 없애기*/
	color: black;
}
.rbtng .rbtn {
	background-color: rgba(186, 185, 180, 0.308);
	border: none;
	color: black;
	margin: 10px;
	padding: 10px 32px;
	border-radius: 4px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 14px;
	cursor: pointer;
	box-shadow: 1px 1px 1px 1px rgba(128, 128, 128, 0.334);
}
.rbtng .rbtn#save:hover {
	background-color: rgb(236, 206, 103);
}
.rbtng .rbtn#cancel:hover {
	background-color: rgba(148, 146, 138, 0.698);
}
</style>
</head>
<body>
	<%@ include file="/views/common/menubar.jsp"%>
	<div class="outer1">
		<div id="list1">
			<h2 id="ntt">
				<img src="resources/image/common/pencil.png" id="r-logo">공지사항 작성</h2>
		</div>
		<form action="<%=contextPath%>/insert.in" method="get"
			id="enroll-form">
			<input type="hidden" name="nno"
				value="<%=loginUser.getMemberNo()%>">
			<div class="en">
				<table aling="center">
					<tr>
						<th width="50" id="tii">제목</th>
						<td width="650"><input type="text" name="title" id="t1"
							required></td>
					</tr>
					<tr>
						<th class="en" id="tiii">&nbsp;</th>
						<td></td>
					</tr>
					<tr>
						<td colspan="2"><textarea name="content" rows="22"
								style="resize: none" id="ti" required placeholder="내용을 입력해주세요."
								maxlength="700"></textarea></td>
					</tr>
				</table>
			</div>
			<div align="center" class="rbtng">
				<button type="button" class="rbtn" id="cancel"
					onclick="history.back();">취소</button>
				<button type="submit" class="rbtn" id="save" onclick="textArea(); ">등록</button>
			</div>
			<br>
			<br>
		</form>
	</div>
	<%@include file="/views/common/footer.jsp"%>
	<script>
		function textArea() {
			var str = document.getElementById("ti").value;
			str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');
			document.getElementById("ti").value = str;
		}
	</script>
</body>
</html>