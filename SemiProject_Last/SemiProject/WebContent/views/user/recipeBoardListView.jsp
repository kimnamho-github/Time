<%@page import="com.user.board.recipe.model.vo.Board"%>
<%@page import="com.common.model.vo.PageInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	// list와 pi 꺼내기
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>레시피 게시판</title>

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/recipelist.css">

<style>
	.pagination {
			width: 100%;
            display: inline-block;
            margin-left: 320px;
            margin-bottom: 60px;
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
	.paging-b:hover:not(.active) {
            background-color: rgb(236, 206, 103);
            border-radius: 4px;
            color: white;
}
</style>

</head>

<body>
	<%@include file="/views/common/menubar.jsp"%>

	<!-- Start Content Page -->
	<div class="container-fluid bg-light py-5">
		<div class="col-md-6 m-auto text-center">
			<h1 class="h1">레시피 게시판</h1>
			<p>자신만 알고있는 특별한 레시피를 다른 사람에게 공유해주세요!</p>
		</div>
	</div>


	<!-- Start Contact -->
	<div class="container">
		<div class="row">
			<form class="col-md-9 m-auto" action="<%=contextPath%>/enrollForm.re">
				<div class="content1">
					<script
						src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
						integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
						crossorigin="anonymous"></script>
					<div class="outer">
						<br>
						<div class="btn-group" align="center">
							<button type="button" class="button">전체</button>
							<button type="button" class="button">한식</button>
							<button type="button" class="button">양식</button>
							<button type="button" class="button">일식</button>
							
							<%if(loginUser != null){ %>
							<button class="btn-r">
								<span>
								<img src="<%=contextPath%>/resources/image/common/free-icon-font-utensils-5070432.png" id="r-logo">
								레시피 등록
								</span>
							</button>
							<%}%>
							
						</div>

						<br>
						<div class="dropdown">
							<button class="dropbtn">
								최신순<img
									src="<%=contextPath%>/resources/image/common/caret-down.png"
									id="down">
							</button>
							<div class="dropdown-content">
								<a href="#" align="center">최신순</a> <a href="#" align="center">조회순</a>
							</div>
						</div>

						<div class="row">
							<%if(!list.isEmpty()){ %>
							<%for(Board b : list){ %>
							<div class="col-lg-4">
								<div class="thumbnail" style="width: 17rem;">
									<input type="hidden" value="<%=b.getBoardNo()%>">
									<input type="hidden" name="mno" value="<%=b.getBoardWriter()%>">
									<input type="hidden" name="bc" value="<%=b.getBoardCode()%>">
									
										<img src="<%=contextPath%><%=b.getTitleImg()%>" style="width: 300px; height: 250px;"
											class="card-img-top" alt="...">
											<div class="up-area">
												<div class="card-title">제목 : <%=b.getBoardTitle() %>
												</div>
													<div class="card-like">
													<img src="<%=contextPath%>/resources/image/common/social-network1.png"
														width="17px" height="17px" >&nbsp;
														
														<%if(b.getLikes() > 999){%>
															999+
														<%}else{ %>
															<%=b.getLikes() %>
														<%} %>
													</div>
											</div>
											<div class="card-p">
													<img src="<%=contextPath%>/resources/image/common/userimage.jfif"
														width="30px" height="30px">
												</div>
											<div class="card-Id"><%=b.getBoardWriter() %></div>
											<div class="card-view">조회수 : <%=b.getViews() %></div>
								</div>
							</div>
									<%} %>
								<%}else{ %>
									조회된 게시글이 없습니다.
								<%} %>
						</div>
						
							
						<script>
				        	$(function () {
								$(".col-lg-4").click(function(){
									location.href="<%=contextPath%>/detail.re?bno=" + $(this).children().children().eq(0).val();
								})
							});
				        	
				        </script>
						
					</div>
				</div>
			</form>
		</div>
			
		
		<!-- 페이징바 -->
		<div align="center" style="text-align: center;">
			<%if(pi.getCurrentPage() != 1){ %>
			<button class="paging-b"
				onclick="location.href='<%=contextPath%>/list.re?currentPage=<%=pi.getCurrentPage()-1%>'">&lt;</button>
			<%}else{ %>
			<button class="paging-b" disabled>&lt;</button>
			<%} %>
			
			<%for (int i = pi.getStartPage(); i <= pi.getEndPage(); i++) { %>
			<%if (i == pi.getCurrentPage()) { %>
			<button class="paging-b" disabled><%=i%></button>
			<%} else { %>
			<button class="paging-b"
				onclick="location.href='<%=contextPath%>/list.re?currentPage=<%=i%>'"><%=i%></button>
			<%} %>
			<%} %>

			<%if (pi.getCurrentPage() != pi.getMaxPage()) {%>
			<button class="paging-b"
				onclick="location.href='<%=contextPath%>/list.re?currentPage=<%=pi.getCurrentPage() + 1%>'">&gt;</button>
			<%} else {%>
			<button class="paging-b" disabled>&gt;</button>
			<%}	%>
		</div>
		<br><br>
		
	</div>

	<!-- End Contact -->

	<%@include file="/views/common/footer.jsp"%>


</body>

</html>