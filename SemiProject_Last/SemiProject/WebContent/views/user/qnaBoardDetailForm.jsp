<%@page import="com.user.board.recipe.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Board b = (Board)request.getAttribute("qnaBoard"); //댓글 리스트
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A게시판 상세조회 페이지</title>

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
		margin-bottom: 40px;
		height: 75px;
		background-color: rgba(236, 205, 103, 0.727);
		border-radius: 6px;
	}
	
	#r-logo {
		margin-right: 4px;
		margin-bottom: 4px;
		width: 18px;
		height: 18px;
	}
	#ntt { /*질문게시글 상세보기*/
		padding: 27px;
		margin-right: 4px;
		margin-left: 20px;
		font-size: 20px;
		margin-bottom: 30px;
		color: black;
		font-weight: bold;
	}
	.rbtng1 { /*취소,등록 버튼*/
		margin: auto;
		font-size: 12px;
	}
	.rbtng1 a {
		text-decoration: none;
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
		background-color:rgba(250, 248, 248, 0.12);
		box-shadow: 2px 2px 2px 3px rgba(128, 128, 128, 0.334);
		border-radius: 8px;
       	padding: 28px;
       	margin:auto;
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
        margin-top : 5px;
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
	#reply-area{ /*댓글 영역*/
		margin-top: 10px;
		padding: 20px;
	}
	#replyNo{ /*댓글 삭제 버튼*/
		width: 58px;
		margin-left: 10px;
	}
	#reply-table>tbody>tr:hover{ /*댓글 리스트 호버*/
		background-color: white;
	}
	#pp{
		width: 30px;
		height:30px;
		border-radius: 80px;
		margin-right: 5px;
		float-left: right;
	}
</style>

</head>
<body>
	<!-- menubar include -->
	<%@include file="/views/common/menubar.jsp"%>

	<div class="outer">
		<br>
		<!-- 게시글 상세 내용 -->
		<div class="outer1">
			<div id="list1">
				<h5 id="ntt">
					<img src="resources/image/common/text.png" id="r-logo"> 질문게시글 상세보기
				</h5>
			</div>
			<div class="hh">

				<div id="o1">
					<b style="font-size: 18px;"><%=b.getBoardTitle()%> </b>
				</div>

				<div id="o2">
					<b id="q5"><img src="resources/image/common/다운로드.jfif" id="pp"><%=b.getBoardWriter()%></b><b id="q3"><img src="resources/image/common/calendar.png" id="r-logo"><%=b.getCreatedDate()%></b>
				</div>

				<div id="o4">
					<b id="q6" style="overflow: hiddlen; word-break: break-all;"
						style="resize: none;"><%=b.getBoardContent()%></b>
				</div>
			</div>

			<br>
			
			<!-- 목록,수정,삭제 버튼 -->
			<div class="rbtng1" align="center">
				<a style="font-size: 15px;" href="<%=contextPath%>/list.qa?currentPage=1" class="rbtn1" id="rbtn-l">목록</a>
				
				<!-- 수정과 삭제 버튼은 글 작성자 본인만 가능하도록 조건추가 -->
				<%if(loginUser!=null && loginUser.getMemberId().equals(b.getBoardWriter())){ %>
					<a style="font-size: 15px;" href="<%=contextPath%>/updateForm.qa?bno=<%=b.getBoardNo()%>" class="rbtn1" id="rbtn-u">수정</a>
					<a style="font-size: 15px;" class="rbtn1" id="rbtn-d" onclick="return chk();">삭제</a>
				<%} %>
			</div>

			<!-- 댓글 등록 영역 -->
			<div id="reply-area">
				<%if ((loginUser != null) && (loginUser.getMemberId().equals("admin"))) {%>
				<table id="reply-table" align="center">
					<thead>
						<tr>
							<th style="padding: 20px">댓글작성</th>
							<td><textarea id="replyContent" rows="2" cols="50"
									style="resize: none;"></textarea></td>
							<td><button onclick="insertReply(<%=b.getBoardNo()%>);" style="margin-bottom: 10px; margin-left: 20px; width: 90px;" class="btn btn-success">등록</td>
						</tr>
					</thead>

					<tbody>
					</tbody>

				</table>
				<%} %>

			</div>
		</div>
		
		<!-- 댓글 수정 모달 -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">댓글 수정 내용을 입력해주세요!</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		      	<textarea id="updateContent" rows="2" cols="49.8"
									style="resize: none;"></textarea>
					<div id="reply_cnt">(0 / 50)</div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
		        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="UpdateReply();">수정하기</button>
		      </div>
		    </div>
		  </div>
		</div>
	</div>

		<script>
			
			let reUpdateNo; //댓글 수정을 위한 전역변수 선언
			
			//페이지 동작시 함수 실행
			$(function(){
				selectReplyList(); 
			});
			//댓글 등록
			function insertReply(bno){ //댓글번호 매개변수로 넣어서 사용해봄
				$.ajax({
					url : "reInsert.qa",
					data : {
						bno : bno, // 댓글 작성한 게시글의 번호
						content : $("#replyContent").val() // 댓글 작성한 글 내용
					},
					type : "post",
					success : function(result){
						
						if(result > 0){
							selectReplyList(); // 댓글 작성이 성공하면 댓글 내용을 바로 조회하도록!
							$("#replyContent").val(""); // 댓글이 등록되면 댓글창의 내용을 빈문자열로 초기화
						}else{
							console.log("댓글 작성 실패!");
						}
						
					},
					error : function(){
						console.log("통신 실패");
					}
				});
			}
			//댓글 수정버튼을 클릭!했을때 댓글의 번호를 전역변수 reUpdateNo에 담아
			//댓글 수정 ajax에서 사용하자!!
			$(document).on("click","table #reUpdateNo",function(){
				reUpdateNo = $(this).val();	
			});
			//댓글 리스트 출력
			function selectReplyList(){
				$.ajax({
					url : "reList.qa",
					data : { bno : <%=b.getBoardNo()%> },
					success : function(reList){
						var str = "";
			
						for(var i=0; i<reList.length; i++){
							str += "<tr>"
								 + "<td align='center'>"+reList[i].commentsWriter+"</td>"
								 + "<td>"+reList[i].commentsContent+"</td>"
								 + "<td align='center'>"+reList[i].createdDate+"</td>"
								 + "<td><button class='btn btn-outline-primary' data-toggle='modal' data-target='#exampleModal' id='reUpdateNo' value=+"+reList[i].commentsNo+">수정</button></td>"
								 + "<td><button onclick='return deleteReply("+reList[i].commentsNo+")' class='btn btn-outline-danger'>삭제</button></td>"
								 + "</tr>";
						}
						$("#reply-area tbody").html(str);
					
					},
					error : function(){
						console.log("통신실패....");
					}
				});
			}
			//댓글 수정 글자 수 제한
			$('#updateContent').on('keyup',function(){
				$('#reply_cnt').html("("+$(this).val().length+" / 50)");
				
				if($(this).val().length > 50){
					$(this).val($(this).val().substring(0, 50));
					$('#reply_cnt').html("(50 / 50)");
				}
			});
			//댓글 수정
			function UpdateReply(){
				$.ajax({
					url : "reUpdate.qa",
					data : {
						bno : <%=b.getBoardNo()%>,
						rno : reUpdateNo, //전역변수로 설정한 수정할 댓글의 번호
						reContent : $("#updateContent").val()
					},
					type : "post",
					success : function(result){
						$('#updateContent').val(""); //수정하기 클릭시 수정내용 초기화
						$('#reply_cnt').html("(0 / 50)"); //수정하기 클릭시 글자 수 초기화
						selectReplyList();
					},
					error : function(){
						console.log("통신실패...........");
					}
				})
			}
			//댓글 삭제
			function deleteReply(reDeleteNo){
				$.ajax({
					url : "reDelete.qa",
					data : {
						bno : <%=b.getBoardNo()%>,
						rno : reDeleteNo
					},
					success : function(result){
						let deleteReply = confirm("정말 삭제하시겠습니까?");
						//결과값이 0이 아니고 사용자가 삭제하겠다고하면
						if((result != 0) && deleteReply){
							alert("댓글을 삭제하였습니다!")
							selectReplyList(); // 댓글 삭제가 성공하면 댓글 내용을 바로 조회하도록!
						}
						return false;
					},
					error : function(){
						console.log("통신 실패.....");
					}
				});
			}
			//게시글 삭제 confirm
			function chk(){
				let deleteBoard = confirm("정말 삭제하시겠습니까?");
				if(deleteBoard){
					location.href="<%=contextPath%>/delete.qa?bno=<%=b.getBoardNo()%>";
					alert("삭제가 완료되었습니다!");
				}
				return result;
			}
		</script>

		<!-- footer include -->
		<%@include file="/views/common/footer.jsp"%>
</body>
</html>