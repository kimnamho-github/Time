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

	<%@include file="/views/common/menubar.jsp"%>
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
                <div style="border: initial; height: 750px; margin-top: 60px; margin-bottom: 20px;">
                    <table id="board-area" class="table table-borderless" align="center" style="text-align: center;">
                    	<colgroup>
					    	<col width="10%" /><col width="10%" />
					    	<col width="10%" /><col width="10%" />
					    	<col width="10%" /><col width="10%" />
					    	<col width="10%" /><col width="10%" />
					    	<col width="10%" /><col width="10%" />
                    	</colgroup>
                        <tr>
                            <td colspan="7"></td>
                            <td colspan="3" style="padding-top: 20px; text-align: right; padding-right: 30px;">작성일자 : <%= b.getCreatedDateStr() %></td>
                        </tr>
                        <tr>
                            <td colspan="10"><h3 style='text-align:left; font-weight:bold; padding:10px 10px 10px 50px; display:white-space:nowrap;'><%= b.getBoardTitle() %></h2></td>
                        </tr>
                        <tr>
                            <td colspan="6"></td>
                            <td colspan="4">조회수 : <%= b.getViews() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;작성자 : <%= b.getBoardWriter() %></td>
                        </tr>
                        <tr>
                            <td colspan="10" style="padding: 40px 10px 10px 50px; overflow:auto; text-align: left;">
                            <%= b.getBoardContent() %>
                            </td>
                        </tr>
                            <td colspan="10" style="padding-top: 20px;">
                        		<div style="border: initial;" align="center"><a class="btn btn-success" href="<%= request.getContextPath() %>/adminBoardView.bo?cPage=1&bt=<%= bt %>">목록으로</a></div>
                            </td>
                    </table>
                </div>
                
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
    
</body>
</html>