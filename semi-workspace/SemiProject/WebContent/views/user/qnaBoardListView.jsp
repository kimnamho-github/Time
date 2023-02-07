<%@page import="com.common.model.vo.PageInfo"%>
<%@page import="com.user.board.recipe.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list"); //질문게시판 게시글 리스트
	PageInfo pi = (PageInfo)request.getAttribute("pi"); //페이징처리 객체
%>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A 게시판</title>

<style>
	@font-face {
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
		height: 800px;
		background-color: rgba(104, 100, 100, 0.163);
		margin: auto;
		margin-top: 20px;
		margin-bottom: 100px;
		border-radius: 15px;
		box-shadow: 3px 3px 4px 3px rgba(128, 128, 128, 0.334);
	}
	/*질문게시판*/
	#nt{
		padding: 27px;
		margin-right: 4px;
		margin-left: 10px;
		font-size: 20px;
		margin-bottom: 30px;
		color: black;
		font-weight: bold;
	}

	#list-area>tbody>tr:hover{
		background-color:rgba(236, 205, 103, 0.237);
		cursor: pointer;
	}
	
	#t1{/*글번호/제목/작성자/조회수/작성일*/
		font-weight: bold;
		font-size: 18px;
	}
	.btn-r a {
		text-decoration: none; /*밑줄 없애기*/
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
        width: 170px;
        transition: all 0.5s;
        cursor: pointer;
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
	
	#r-logo{/*위에 종*/
		margin-right: 4px;
		margin-bottom: 4px;
		width:18px;
		height:18px;      
	}
	
	#r-logo1{
		margin-right: 4px;
		margin-bottom: 4px;
		margin-top: 4px;
		width:18px;
		height:18px;      
	}
	.paging-b {
		color: black;
		padding: 8px 15px;
		text-decoration: none;
		border: none;
		font-size: 15px;
		box-shadow: 1px 2px 1px 1px rgba(128, 128, 128, 0.334);   
	}
	
	.paging-b {
		background-color: rgb(224, 224, 224);
		color: black;
		border-radius: 4px;
		margin: 4px;
	}
	
	.paging-b:hover:not(.active) {
		background-color: rgb(236, 206, 103);
		border-radius: 4px;
		color: white;
	} 
	
	#t1{
		background-color: rgb(224, 224, 224);
	}
	
	#list1{
		margin-top: 14px;
		height: 9%;
		margin-bottom: 50px;
		background-color: rgba(236, 205, 103, 0.727);
		border-radius: 6px;
	}
	
	#list2{
		margin-top: 22px;
		height: 42%;
		padding-right: 75px;
		padding-left: 75px;
		font-size: 14px;
	}
	
	#l1 {
		font-size: 14px;
		font-weight: bold;
	}
	#t2{
		font-weight: bold; 
	}
	
	.tt{
		background-color: rgba(224, 224, 224, 0.704);
	}
	
	#te{
		background-color: rgba(104, 100, 100, 0.163);
		font-weight: bold;
		color: gray;
	}
	
	.ff{  
		margin-top: 100px;
	}
	#ri{
        margin-top:190px;
    }
	#btn-outer{
		width: 100%;
		text-align: center;
	}
	#list-area {
		cursor: pointer;
	}
   
	</style>

</head>
<body>
	<!-- menubar include -->
	<%@include file="/views/common/menubar.jsp" %>
	
	<br><br>
	<% if(loginUser != null){ %>
	<div id="btn-outer">
		<div class="btn-r" style="vertical-align:middle">
			<a href="<%=contextPath%>/enrollForm.qa"><img src="resources/image/common/text.png" id="r-logo1">
				<span>Q&A게시판 작성</span>
			</a>
		</div>
	</div>
	
	<br>
	<%} %>
	
	<div class="outer1">
		
		<div id="list1">
			<h5 id="nt"><img src="resources/image/common/Questions.png" id="r-logo"> Q&A Board</h5>
		</div>
		
		<!-- 게시글 리스트 영역 -->
		<div id="list2">
			<table id="list-area" align="center" class="table table-hover">
				<thead class="tt" align="center">
			        <tr id="l1">
					<th width="30" scope="col">No.</th>
					<th width="500" scope="col">제목</th>
					<th width="150" scope="col">작성자</th>
					<th width="150" scope="col">작성일</th>
					<th width="100" scope="col">조회수</th>
				</tr>
		    	</thead>
				
				<tbody>
					<%if (list.isEmpty()) { %>
				<tr>
					<td colspan="5">등록된 게시글이 없습니다...</td>
				</tr>
					<%} else { %>
						<tr  id="t2">
				            <td width="30" id="l1" align="center">공지</td>
				            <td width="500" ><img src="resources/image/common/megaphone.png" id="r-logo">Q&A게시판 작성시 주의사항 안내</td>
				            <td width="150" align="center">admin</td>
				            <td width="150" align="center">2022-11-17</td>
				            <td width="100" align="center">210</td>
				        </tr>
				
						<%for (Board b : list) { %>
							<tr class="table-light" id="l1">
								<td id="te" align="center"><%=b.getBoardNo()%></td>
								<td id="te"><%=b.getBoardTitle()%></td>
								<td id="te" align="center"><%=b.getBoardWriter()%></td>
								<td id="te" align="center"><%=b.getCreatedDate()%></td>
								<td id="te" align="center"><%=b.getViews()%></td>
							</tr>
						<%} %>
					<%} %>
				</tbody>

			</table>
		</div>
	
		<div class="ff">
			<!-- 페이징바 -->
			<div align="center" id="ri" style="text-align: center;">
		        <!-- 만약 현재 페이지가 1이 아니면 버튼 동작 가능 -->
		        <%if(pi.getCurrentPage() != 1){ %>
		        	<button class="paging-b" onclick="location.href='<%=contextPath%>/list.qa?currentPage=<%=pi.getCurrentPage()-1%>'">&lt;</button>
		        <%}else{ %>
		        	<button class="paging-b" disabled>&lt;</button>
		       	<%} %>
		        	
		       	<%for(int i = pi.getStartPage(); i<= pi.getEndPage(); i++) {%>
		       		<%if(i == pi.getCurrentPage()) {%> 
		       	 		<button class="paging-b" disabled><%=i %></button>
		       		<%}else{ %> 
		       			<button class="paging-b" onclick="location.href='<%=contextPath%>/list.qa?currentPage=<%=i%>'"><%=i%></button>
					<%} %>     	 
		       	<%} %>
		       	
		       	<%if(pi.getCurrentPage() != pi.getMaxPage()) {%>
		       	<button class="paging-b"  onclick="location.href='<%=contextPath%>/list.qa?currentPage=<%=pi.getCurrentPage()+1%>'">&gt;</button>
		       	<%} %>
		    </div>  
		</div>
	
	</div>
	
	<!-- 
    	list-arae의 tbody tr 속성을 클릭했을 경우 함수가 실행되고
    	href 속성을 이용해 detail.qa 매핑 컨트롤러로 bno를 get방식을 이용해 가지고 가도록 하는 함수
    	(this)는 클릭되는 tr속성 자신의 children(자식)속성인 td의 eq(0)첫번째 값 '글번호'의 text를 가져오도록 한다
     -->
	<script>
		$(function() {
			$("#list-area>tbody>tr").click(function() {
				var bno = $(this).children().eq(0).text();
				
				location.href="<%=contextPath%>/detail.qa?bno="+bno;
			});
			
		});
	
	</script>
	
	<%@include file="/views/common/footer.jsp" %>

</body>
</html>