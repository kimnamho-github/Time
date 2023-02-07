<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.user.board.open.model.vo.Board"%>
<%
	Board b = (Board) request.getAttribute("b");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@font-face {
    font-family: 'NanumSquareRound';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_two@1.0/NanumSquareRound.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
#rbtn-u,#rbtn-d,#rbtn-l, #rbtn-2,#replyDel, #coUpdateNo{
font-family: 'NanumSquareRound';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_two@1.0/NanumSquareRound.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

* {
	font-family: 'NanumSquareRound';
}
.outer1 {
              width: 1200px;
              height: auto;
              background-color:rgba(104, 100, 100, 0.163);
              margin: auto;
           margin-top: 20px;
              margin-bottom : 100px;
               border-radius: 15px;
               box-shadow: 3px 3px 4px 3px rgba(128, 128, 128, 0.334);
          }  


#ntt{/*공지사항 작성*/
        
         padding: 27px;
         margin-right: 4px;
        margin-left: 10px;
        font-size: 20px;
          margin-bottom : 30px;
           color: black;
              font-weight: bold; 
      } 

#list1{
          margin-top: 14px;
         height: 9%;
         margin-bottom: 50px;
         background-color: rgba(236, 205, 103, 0.727);
          border-radius: 6px;
    
          }   

#r-logo { /*위에 확성기*/
	margin-right: 4px;
	margin-bottom: 4px;
	width: 18px;
	height: 18px;
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

        .rbtng1 .rbtn1  {
            background-color:  rgba(186, 185, 180, 0.308);
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
    

        #rbtn-l{
            background-color: rgba(236, 205, 103, 0.727);
      
            
        }

        .rbtng1 .rbtn1#rbtn-l:hover {
            background-color: rgb(236, 206, 103);
          
        }

        .rbtng1 .rbtn1#rbtn-u:hover {
            background-color:rgba(85, 170, 24, 0.205);
        }
        .rbtng1 .rbtn1#rbtn-d:hover {
            background-color:rgba(240, 68, 25, 0.274);
        }
		.hh{
        	width: 900px;
            height: 570px;
			background-color:rgba(250, 248, 248, 0.12);
			box-shadow: 2px 2px 2px 3px rgba(128, 128, 128, 0.334);
			border-radius: 8px;
           	padding: 28px;
           	margin:auto;
        }
.q2{/*제목*/
        color: black;
        font-weight: bold; 
       width: 100%;
        }
        
        #q3{/*작성일 0*/
        color: gray;
        font-size: 15px;
        float: right;
        margin-top : 5px;
       /* margin-left: 678px;*/
        }
         
        #q5{/*작성자 0*/
    
        color: gray;
        font-size: 16px;
        font-weight: bold; 
        }
        
        #q6{/*내용*/
        color: black;
         font-size: 16px;
        }
        #o1{
         padding: 8px;
         border-bottom-style: double;
         border-color: gray;
        }
        #o2{
          padding: 8px;
       border-bottom-style: solid;
         border-width: 2px;
           border-color: gray;
        }
        
        #o3{
         padding: 8px;
        }
        
        #o4{
         padding: 20px;
        }
        #pp{
        width: 30px;
        height:30px;
         border-radius: 80px;
          margin-right: 5px;
           float-left: right;
        }

.commentT{
	width: 1000px;
	margin: auto;
}
.commentT>tbody>tr>td{
	width:400px;
}


#op-reply-area {
	width: 1200px;
	height: auto;
	background-color: rgba(104, 100, 100, 0.163);
	margin: auto;
	border-radius: 15px;
	box-shadow: 3px 3px 4px 3px rgba(128, 128, 128, 0.334);
}
#rbtn-2{
 	background-color:  rgba(186, 185, 180, 0.308);
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
            font-size:12px; 
}
        #rbtn-2:hover {
            background-color: rgb(236, 206, 103);
          
        }
#replyDel, #coUpdateNo{
			background-color:  rgba(186, 185, 180, 0.308);
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
            font-size:12px; 
}
#replyDel:hover{
background-color: rgb(236, 206, 103);
}
#replyNo1:hover{
background-color: rgb(236, 206, 103);
}


</style>
</head>
<body>

	<%@ include file="/views/common/menubar.jsp"%>

	<div class="outer1">
		<div id="list1">
			<h5 id="ntt">
				<img src="resources/image/common/megaphone.png" id="r-logo">Open Board
				
			</h5>
		</div>
			
		<div class="hh">  
       
       	<div id="o1">
       		<b style="font-size: 18px;"><%=b.getBoardTitle()%></b>
       	</div>
       	
       	<div id="o2">
       		<b id="q5"><img src="resources/image/common/다운로드.jfif" id="pp"><%=b.getBoardWriter() %></b>
       		<b id="q3"><img src="resources/image/common/calendar.png" id="r-logo"><%=b.getCreatedDate() %></b>
       	</div> 
     
       	<div id="o4">
       		<b id="q6" style="overflow:hiddlen; word-break:break-all;" style="resize: none;"><%=b.getBoardContent() %></b>
       	</div>
       	
       	</div>
         
       	<br>
			<div align="center" class="rbtng1" >
				<a style="font-size:12px; " href="<%=request.getContextPath()%>/list.op?currentPage=1" class="rbtn1" id="rbtn-l">목록</a>
			
				<%if (loginUser != null && loginUser.getMemberId().equals(b.getBoardWriter())) {	%>
				
					<a style="font-size:12px; " href="<%=request.getContextPath()%>/updateForm.op?ono=<%=b.getBoardNo()%>" class="rbtn1" id="rbtn-u">수정</a>
					<a style="font-size:12px; " href="<%=request.getContextPath()%>/delete.op?ono=<%=b.getBoardNo()%>" class="rbtn1" id="rbtn-d" >삭제</a>
					
				<%}%>
						
					
			</div>
  <br>
    <br>
		</div>
		
		
		<!-- 댓글 작성 영역 -->
			<div id="op-reply-area">
			
			<div id="list1">
				<h5 id="ntt">Comment</h5>
			</div>
			
			
			<div class=commentT>
				<table align="center" class="opCommentTable">
					<colgroup>
					
					<col width="10%"/><col width="10%"/>
					<col width="10%"/><col width="10%"/>
					<col width="10%"/><col width="10%"/>
					<col width="10%"/><col width="10%"/>
					<col width="10%"/><col width="10%"/>
					</colgroup>
					<thead>
						
							<tr>
								
								<td colspan="8"><textarea style="resize:none;" id="replytext" rows="3" cols="80"></textarea>
									 
								</td>
								<!-- 로그인 한 회원만 댓글 작성 가능 -->	
								
								<%if (loginUser != null ) {%>	
								<td colspan="2"><button onclick="insertComments(<%=b.getBoardNo()%>);" id="rbtn-2">등록하기</button></td>
								<% } %>
								
								
							</tr>
					</thead>
					<tbody> 
						
					</tbody>
				</table>
				
			</div>
			</div>
				

	
			<script>
			
				let coUpdateNo; //댓글 수정을 위한 전역변수 선언
				const mdclose = document.querySelector("#mdclose");
				
				$(function() {
					selectReplyList();

				});
				
				
				//댓글 등록
				function insertComments(ono) {
					
					var str = document.getElementById("replytext").value;
					str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');
					document.getElementById("replytext").value = str;
					
					$.ajax({
						url : "rinsert.op",
						data : {
							ono :<%=b.getBoardNo()%>, //댓글 작성한 게시글 넘버
							content : $("#replytext").val() //댓글 내용
						}, 
						type : "post",
						success : function(result) {
							if (result > 0) {
								selectReplyList(); 
								$("#replytext").val("");  // 댓글이 등록되면 댓글창의 내용을 빈문자열로 초기화
							} else {
								console.log("댓글 작성 실패")
							}
						},
						error : function() {
							console.log("통신 실패 ");
						}
					});
				}
				
				
				//댓글 리스트 출력
				function selectReplyList() {
					$.ajax({
						url : "rlist.op",
						data : {ono :	<%=b.getBoardNo()%>},
						success : function(list) {
							var str = "";
							for ( var i=0; i<list.length; i++) {
								str += "<tr>" 
									+ "<td style='display:none;'>" + list[i].commentsNo + "</td>"
									+ "<td colspan='1.5'>" + list[i].commentsWriter + "</td>"
									+ "<td colspan='5'>" + list[i].commentsContent + "</td>"
									+ "<td colspan='2'>" + list[i].createdDate+ "</td>" 
									 + "<td colspan='1'><button class='btn btn-outline-secondary' id='coUpdateNo' data-toggle='modal' value="+list[i].commentsNo+" data-target='#exampleModal'>수정</button></td>"
									 + "<td colspan='1'><button class='btn btn-outline-secondary' id='replyDel'  value="+list[i].commentsNo+" >삭제</button></td>"
									+ "</tr>";
							}
							
							$("#op-reply-area tbody").html(str);
								replyDel();
						},
						error : function() {
							console.log("통신실패");
						}
					});

				}
				
				
				//댓글 삭제
				function replyDel() {
					$("#replyDel.btn.btn-outline-secondary").on('click',function(){
						let rno = $(this).parent().parent().children().eq(0).text();
						
						$.ajax({
							url : "rdelete.op",
							data : {
								ono : <%=b.getBoardNo()%>,
								rno : rno
							},
							type : "post",
							success : function(result){
								let deleteReplyop = confirm("정말 삭제하시겠습니까?");

								if((result != 0) && deleteReplyop){
									alert("댓글 삭제 완료")
									selectReplyList();
								}
								return false;
							},
							error : function(){
								console.log("통신 실패.....");
							}
						});
					});
					
				}

				
				//댓글 띄어쓰기 창
				function textArea(){
					var str = document.getElementById("replytext").value;
					str = str.replace(/(?:\r\n|\r|\n)/g,'<br/>');
					document.getElementById("replytext").value = str;		
					}
				
				
			</script>
		
		
		
		<br>
		<br>
	<br>
	<br>
	<br>
	<br>



	<%@ include file="/views/common/footer.jsp"%>
	






</body>
</html>