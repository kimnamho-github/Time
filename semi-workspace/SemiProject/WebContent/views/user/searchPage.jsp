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
<title>searchPage</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/search.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/recipelist.css">
	
	<style>
	.pagination {
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

	<%@ include file="/views/common/menubar.jsp"%>

	<!-- 검색창 -->
	<br>
	<br>
	<br>
	<br>

	<h2 align="center">Recipe Search</h2>
	
	
		<div class="inner">
			<select name="type">
				<option>선택</option>
				<option value="title">제목</option>
				<option value="content">내용</option>
				<option value="writer">작성자</option>
			</select>
			<input type="search" class="search-input" name="searchText" id="searchText">
			<button class="sc-btn" onclick="recipeSearch();">
				<i class="fa fa-search" aria-hidden="true"></i> <!-- 검색이미지 클릭시 입력받은 값 검색 -->
			</button>
		</div>
		<br><br><br><br>
		
	
	
	<div class="container">
		<div class="row">
			<div class="col-md-9 m-auto">
				<div class="content1">	
					<div class="outer">
						<div class="row">
							<div class="col-lg-4">
								<div class="thumbnail" style="width: 17rem;">
									<!-- 검색 결과 ajax에서 출력 -->
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			
			<!-- 페이징바 -->
			<div align="center" class="pagination">
				<!-- ajax에서 페이징 처리 -->
			</div>
			
			<br><br><br><br>

			
		</div>
	</div>
	
	
	
		<script>
		
			function recipeSearch() {
				 $.ajax({
			            url: "<%=contextPath%>/recipeSearch.re",
			            data: {
							searchText : $("#searchText").val(),
							currentPage : 1
							/*currentPage :  // $("").val() // 페이징처리 하기  - attr로 currentPage가져와서 진행하기 https://www.codingfactory.net/10208 */
						},
			            success: function(list,page){ // 레시피 게시판 글, 페이지 정보 넘겨받음
							let search_result = "<div>조회된 게시글이 없습니다.</div>";
							let pageInfo = "";
							
							// 페이징 처리한 부분 str로 만들기..
							if(list != null){
								for(let i = 0; i < list.length; i++){
									if(list[i].likes > 999){
										list[i].likes = "999+"
									}
									
									search_result = "<input type=\"hidden\" value=\"" + list[i].boardNo + "\">"
												+ "<img src=\"http://localhost:8888/SemiProject" + list[i].titleImg + "\"" + "style=\"width: 300px; height: 250px;\" class=\"card-img-top\" alt=\"...\">"
												+ "<div class=\"up-area\">"
												+ "<div class=\"card-title\">" + "제목 : " + list[i].boardTitle + "</div>"
												+ "<div class=\"card-like\">"
												+ "<img src=\"http://localhost:8888/SemiProject/resources/image/common/social-network1.png\" width=\"17px\" height=\"17px\">&nbsp;"
												+ list[i].likes
												+ "</div>"
												+ "</div>"
												+ "</div>"
												+ "<div class=\"card-p\">"
												+ "<img src=\"http://localhost:8888/SemiProject/resources/image/common/userimage.jfif\" width=\"30px\" height=\"30px\">"
												+ "</div>"
												+ "<div class=\"card-Id\">" + list[i].boardWriter + "</div>"
												+ "<div class=\"card-view\">" + "조회수 : " + list[i].views + "</div>"
								}
								
									if(page.currentPage != 1){
										pageInfo =  "<button class=\"paging-b\""
												+ "onclick=\"location.href='http://localhost:8888/SemiProject/recipeSearch.re?currentPage="+ (page.currentPage-1) + "'\">&lt;</button>"
									} else{
										pageInfo = "<button class=\"paging-b\" disabled>&lt;</button>"
									}
									for (let i = page.startPage; i <= page.endPage; i++) {
										if (i == page.currentPage) { 
										pageInfo = "<button class=\"paging-b\" disabled>i</button>"
										} else{
											pageInfo = "<button class=\"paging-b\""
													+ "onclick=\"location.href='http://localhost:8888/SemiProject/recipeSearch.re?currentPage=i'\">" + i + "</button>"
										}
									}
										if (page.currentPage != page.maxPage) {
										pageInfo = "<button class=\"paging-b\""
												+ "onclick=\"location.href='http://localhost:8888/SemiProject/recipeSearch.re?currentPage=" + (curPage.currentPage+1) + "'\">&gt;</button>"
										} else{
										pageInfo =  "<button class=\"paging-b\" disabled>&gt;</button>"
										}
							}
							
			               $(".thumbnail").html(search_result);
			               $(".paging-area").html(pageInfo);
			               
			            },
			            error : function() {
							console.log("통신 실패");
							
						}
			        });
			}
			
			$(function () {
				$(".thumbnail").click(function(){
					location.href="<%=contextPath%>/detail.re?bno=" + $(this).children().eq(0).val();
				})
			});
			
			
			
		</script>
		

		
	<%@ include file="/views/common/footer.jsp"%>

</body>
</html>