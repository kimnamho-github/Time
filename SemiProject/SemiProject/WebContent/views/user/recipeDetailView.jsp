<%@page import="com.user.board.recipe.model.vo.RecipeIngrd"%>
<%@page import="com.common.model.vo.Attachment"%>
<%@page import="com.user.board.recipe.model.vo.Board"%>
<%@page import="com.user.board.recipe.model.vo.Recipe"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Board b = (Board)request.getAttribute("b");
	ArrayList<Attachment> at = (ArrayList<Attachment>)request.getAttribute("at");
	ArrayList<Recipe> recipe = (ArrayList<Recipe>)request.getAttribute("recipe");
	ArrayList<RecipeIngrd> ingrd = (ArrayList<RecipeIngrd>)request.getAttribute("ingrd");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/recipedetail.css">

	<style>
		
		
	</style>
</head>
<body>
	
	<%@include file="/views/common/menubar.jsp"%>

		
	        <div class="outer">
			    <div class="head-area">
		            <img class="titleImg" src="<%= request.getContextPath()+at.get(0).getFilePath()+at.get(0).getChangeName()%>" >
		            <h2 class="title"><b><%=b.getBoardTitle()%></b></h2>
		            
		            <div class="info">
		                    <img class="left" id="subImg" src="<%=contextPath%>/resources/image/common/people.jpg" >
		                    2인분
		                    <img class="left" id="subImg" src="<%=contextPath%>/resources/image/common/time.jpg" >
		                   	 소요시간 15분
		                    
		                    <span class="infoRight1">
		                        <span>작성 일자 </span><br>
		                        <span><%=b.getCreatedDate()%></span>
		                    </span>
		                    <span class="infoRight3">
		                        <span>좋아요</span><br>
		                        <span><%=b.getLikes()%></span>
		                    </span>
		                    <span class="infoRight4">
		                        <span>조회수</span><br>
		                        <span><%=b.getViews()%></span>
		                    </span>
		                    <span class="infoRight2">
		                        <span>작성자</span><br>
		                        <span><%=b.getBoardWriter()%></span>
		                    </span>
		            </div>
		            
		            <hr>
		
		            <div>
		                	<%=b.getBoardContent()%>
		            </div>
		        </div>
		        
		        <br><br><br><br>
		
		        <div class="recipeIngrd">
		            <h3><b>재료</b></h3>
		            <hr>
		            <div class="body-area">
		                <div>
		                	<%if(!ingrd.isEmpty()){ %>
		                		<%for(int i = 0; i < ingrd.size(); i++){ %>
		                			<span class="left1"><%=ingrd.get(i).getIngrdCode()%> : </span>
		                			<span class="right1"><%=ingrd.get(i).getDose()%><%=ingrd.get(i).getDoseCode()%></span><br>
		                		<%} %>	
		                	<%}else{ %>
		                		<span>등록된 재료가 없습니다.</span>
		                      <%} %>
		                </div>
		            </div>
		
		        </div>
		
		        <br><br><br><br>
		
		        <div class="recipeContent">
		            <h3><b>레시피</b></h3>
		            <hr>
		            <div class="recipe-area">
			
						<%if(!recipe.isEmpty()){ %>
							<%for(int i = 1; i < at.size(); i++){ %>
							
			                <div class="content" >
			                    <div class="left2">
			                        <img class="img" src="<%= request.getContextPath()+at.get(i).getFilePath()+at.get(i).getChangeName() %>" alt="<%=	at.get(1).getOriginName()%>">
			                    </div>
			
			                    <div class="right2">
			                        <h2>Step<%=i%></h2>
			                        <br>
			                        <div>
			                        	<%=recipe.get(i-1).getRecipeContent()%>
			                        </div>
			                    </div>
			                </div>
			
						<%} %>
					<%} %>
		                    
		            </div>
				
		        </div>
		        
		        <div class="btn-area">
		        	<button onclick="location.href='<%=contextPath%>/list.re?currentPage=1'">목록가기</button>
		        	<%if(loginUser != null && loginUser.getMemberId().equals(b.getBoardWriter())){ %>
		        	<button onclick="location.href='<%=contextPath%>/updateForm.re?bno=<%=b.getBoardNo()%>'">수정하기</button>
		        	<button onclick="location.href='<%=contextPath%>/delete.re?bno=<%=b.getBoardNo()%>'">삭제하기</button>
		        	<%} %>
		        	<br><br><br><br>
		        </div>
		        
				<%@include file="/views/common/footer.jsp"%>
				
		    </div>
		
		
			
			
    


	
	
</body>
</html>