<%@page import="com.admin.board.model.vo.RecipeIngrd"%>
<%@page import="com.admin.board.model.vo.Recipe"%>
<%@page import="com.common.model.vo.Attachment"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.common.model.vo.PageInfo
,com.admin.board.model.vo.Board
,java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Board b = (Board)request.getAttribute("b");
	String bt = (String)request.getAttribute("bt");
	ArrayList<Attachment> at = (ArrayList<Attachment>)request.getAttribute("at");
	ArrayList<Recipe> recipe = (ArrayList<Recipe>)request.getAttribute("recipe");
	ArrayList<RecipeIngrd> ingrd = (ArrayList<RecipeIngrd>)request.getAttribute("ingrd");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <style>
        <%@ include file="../../../resources/css/adminFrame.css" %>
    </style>
</head>
<body>

    <%@ include file="../../common/menubar.jsp" %>
    <div class="outer">
        <div id="content">
            <!-- 관리목록 영역 -->
            <div id="content1" style="text-align: center;">
				<%@ include file="../common/navigationBar.jsp" %>
            </div>
            <!-- 게시판 영역 -->
            <div id="content2">
                <div style="border: initial; height: 40px;">
                    <button class="btn btn-danger" id="removeBtn" data-toggle="modal" data-target="#deleteModal" style="width: 10%; float: right; margin-right: 30px; margin-top: 40px;">삭제</button>
                </div>
                <h1 align="center" style="margin: initial; margin-top: 40px;"><%= b.getBoardCode() %></h1>
                <div style=" overflow:auto; border: initial; height: 750px; margin-top: 60px; margin-bottom: 20px;">
                    <table id="board-area" class="table table-borderless" align="center" style="text-align: center; width: 100%;">
                        
					  	<colgroup>
					    	<col width="10%" /><col width="10%" />
					    	<col width="10%" /><col width="10%" />
					    	<col width="10%" /><col width="10%" />
					    	<col width="10%" /><col width="10%" />
					    	<col width="10%" /><col width="10%" />
					  	</colgroup>
                        <tr>
                            <td colspan="7"></td>
                            <td colspan="3" style='text-align: right;'>작성일자 : <%= b.getCreatedDateStr() %></td>
                        </tr>
                        <tr>
                            <td colspan="10"><h3 style='text-align:left; font-weight:bold; padding:10px 10px 10px 50px; display:white-space:nowrap;'><%= b.getBoardTitle() %></h3></td>
                        </tr>
                        <tr>
                            <td colspan="6"></td>
                            <td colspan="4"><pre>조회수 : <%= b.getViews() %>       좋아요 : <%= b.getLikes() %>       작성자 : <%= b.getBoardWriter() %></pre></td>
                        </tr>
                        <tr height="200px" >
                            <td  colspan="7">
                                <div  style="border: initial; width:100%; height:100%; overflow:hiddlen; word-break:break-all; padding-left: 30px; overflow:auto; text-align: left;">
                                	<%= b.getBoardContent() %>
                                </div>
                            </td>
                            <td colspan="3">
                                <img width="100%" height="100%" style="background-size: cover;" src="<%= request.getContextPath()+at.get(0).getFilePath()+at.get(0).getChangeName() %>" alt="<%= at.get(0).getOriginName() %>">
                            </td>
                        </tr>
                        <tr style="width: 100%;">
                            <td colspan="10"><b>[재료]</b></td>
                            <% 		
                    			StringBuffer sbEven = new StringBuffer();
                    			StringBuffer sbOdd = new StringBuffer();
                            	StringBuffer sb = null;
                            	for(int i = 0; i < ingrd.size();i++){
                            		if(i % 2 == 0){
                            			sb = sbEven;
                            		}else{
                            			sb = sbOdd;
                            		}
                               		sb.append(ingrd.get(i).getIngrdCode()+" : "+ingrd.get(i).getDose()+ingrd.get(i).getDoseCode()+"<br>");
                            	}
                            %>
                        </tr>
                        
                        <tr>
                            <td colspan="3"></td>
                            <td colspan="3" style="text-align: left;"><%= sbEven %></td>
                            <td colspan="3" style="text-align: left;"><%= sbOdd %></td>
                            <td colspan="1"></td>
                        </tr>
                        
                        <tr>
                            <td colspan="10">[조리 내용]</td>
                        </tr>
                        <%
                        for(int i = 1;i < at.size();i++){ %>
                        <tr>
                            <td colspan="1" style="padding-top: 20px">stap<%= recipe.get(i-1).getOrderNo() %></td>
                            <td colspan="6" style="text-align: left;  word-break:break-all; padding: 20px 20px 20px 20px;"><%= recipe.get(i-1).getRecipeContent() %></td>
                            <td colspan="3">
                            	<img width="100%" height="100%" style="background-size: cover;" src="<%= request.getContextPath()+at.get(i).getFilePath()+at.get(i).getChangeName() %>" alt="<%= at.get(1).getOriginName() %>">
                            </td>
                        </tr>
                        <% } %>
                    </table>
                </div>
                <div style="border: initial;" align="center"><a class="btn btn-success" href="<%= request.getContextPath() %>/adminBoardView.bo?cPage=1&bt=<%= bt %>">목록으로</a></div>
            </div>
        </div>
    </div>

    <!-- deleteModal -->
    <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">게시글 삭제</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <p>게시글을 삭제하겠습니까?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                <form action="adminBoardDelete.bo" method="get">
                    <input type="hidden" value="<%= b.getBoardNo() %>" name="bno">
                    <input type="hidden" value="<%= bt %>" name="bt">
                    <button type="submit" class="btn btn-primary">확인</button>
                </form>
            </div>
            </div>
        </div>
    </div>
    
	<script>
        $(function(){
            $("#board-area>tr>td").css("padding-top","20px");
        })
	</script>
</body>
</html>