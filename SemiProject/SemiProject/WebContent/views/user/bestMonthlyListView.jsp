<%@page import="com.user.board.recipe.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("bestList"); //월간 인기 레시피 1~3위
	String now = (String)request.getAttribute("now"); //현재 년도와 월
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이달의 레시피</title>

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/recipelist.css">

<style>
	/* 게시판 전체 틀 */
	.outer1{
		width: 700px;
		height: 1450px;
		/*background-color:rgba(104, 100, 100, 0.163);*/
		margin: auto;
		margin-top: 20px;
		margin-bottom : 50px;
		border-radius: 15px;
		box-shadow: 3px 3px 4px 3px rgba(128, 128, 128, 0.334);
	}
	
	/* 2022/11/00/일자 인기 레시피 텍스트*/ 
	#nt{
    	padding: 25px;
        margin-right: 4px;
   	 	margin-left: 20px;
   	 	font-size: 30px;
   	   	margin-bottom : 20px;
   	    color: black;
   	  	font-weight: bold;
   	}
   	
   	#list1{
		margin-top: 15px;
		height: 80px;
		margin-bottom: 30px;
		background-color: rgba(236, 205, 103, 0.727);
		border-radius: 6px;
	}
	
	/* 순위 */
	.best{
		margin-top: 30px;
		height: 420px;
		
		/*border: 2px solid black;*/
	}
	
	.best img{
		width : 450px;
		height : 300px;
		border-radius: 10%;
	}
	.best:hover img{
        cursor: pointer;
	}
	.best h1{
		font-size: 30px;
	}
	.best-text{
		margin-top: 20px;
	}
	/*별 로고*/
	#r-logo{
		margin-right: 4px;
		margin-bottom: 4px;
		width: 18px;
		height: 18px;
	}
	/*순위 로고*/
	#l-logo{
		margin-right: 4px;
		margin-bottom: 4px;
		width: 31px;
		height: 31px;
	}
	/*좋아요 로고*/
	#like-logo{
		margin-right: 4px;
		margin-bottom: 4px;
		width: 31px;
		height: 31px;
	}
	
	/*타이틀 이미지 호버*/
	.hover14 figure {
		position: relative;
	}
	.hover14 figure::before {
		position: absolute;
		top: 0;
		left: -75%;
		z-index: 2;
		display: block;
		content: '';
		width: 50%;
		height: 100%;
		background: -webkit-linear-gradient(left, rgba(255,255,255,0) 0%, rgba(255,255,255,.3) 100%);
		background: linear-gradient(to right, rgba(255,255,255,0) 0%, rgba(255,255,255,.3) 100%);
		-webkit-transform: skewX(-25deg);
		transform: skewX(-25deg);
	}
	.hover14 figure:hover::before {
		-webkit-animation: shine .75s;
		animation: shine .75s;
	}
	@-webkit-keyframes shine {
		100% {
		left: 125%;
		}
	}
	@keyframes shine {
		100% {
		left: 125%;
		}
	}
	
</style>

</head>
<body>
	<%@include file="/views/common/menubar.jsp"%>
	
	<!-- Start Content Page -->
	<div class="container-fluid bg-light py-5">
		<div class="col-md-6 m-auto text-center">
			<h1 class="h1">이달의 레시피 top3</h1>
		</div>
	</div>
	
	<!-- Start Contact -->
	<div class="outer1">
		<div id="list1">
			<h5 id="nt"><img src="resources/image/common/star.png" id="r-logo"> <%=now %>월 인기 레시피</h5>
		</div>
		
		<div>
			<!-- 1위 -->
			<div class="best" align="center">
				<input type="hidden" name="boardNo" value="<%=list.get(0).getBoardNo() %>">
				<div class="hover14 column"><figure><img src="<%=contextPath %><%=list.get(0).getTitleImg()%>"></figure></div>
				<div class="best-text">
					<h1><img src="resources/image/common/like.png" id="l-logo"> 1위 <%=list.get(0).getBoardTitle() %></h1>
					<h3><img src="<%=contextPath%>/resources/image/common/social-network1.png" id="like-logo"> : <%=list.get(0).getLikes()%>개 조회수 : <%=list.get(0).getViews() %></h3>
				</div>
			</div>
			<!-- 2위 -->
			<div class="best" align="center">
				<input type="hidden" name="boardNo" value="<%=list.get(1).getBoardNo() %>">
				<div class="hover14 column"><figure><img src="<%=contextPath %><%=list.get(1).getTitleImg()%>"></figure></div>
				<div class="best-text">
					<h1><img src="resources/image/common/like.png" id="l-logo"> 2위 <%=list.get(1).getBoardTitle() %></h1>
					<h3><img src="<%=contextPath%>/resources/image/common/social-network1.png" id="like-logo"> : <%=list.get(1).getLikes()%>개 조회수 : <%=list.get(1).getViews() %></h3>
				</div>
			</div>
			<!-- 3위 -->
			<div class="best" align="center">
				<input type="hidden" name="boardNo" value="<%=list.get(2).getBoardNo() %>">
				<div class="hover14 column"><figure><img src="<%=contextPath %><%=list.get(2).getTitleImg()%>"></figure></div>
				<div class="best-text">
					<h1><img src="resources/image/common/like.png" id="l-logo"> 3위 <%=list.get(2).getBoardTitle() %></h1>
					<h3><img src="<%=contextPath%>/resources/image/common/social-network1.png" id="like-logo"> : <%=list.get(2).getLikes()%>개 조회수 : <%=list.get(2).getViews() %></h3>
				</div>
			</div>
		</div>	
		
	</div>
	
	<!-- 이미지 경로 설정 함수 -->
	<script>
		$(function(){
			$(".best").click(function(){
				var bno = $(this).children().eq(0).val();
				location.href="<%=contextPath%>/detail.re?bno="+bno;
			})
			
		});
	</script>

	<!-- End Contact -->

	<%@include file="/views/common/footer.jsp"%>
</body>
</html>