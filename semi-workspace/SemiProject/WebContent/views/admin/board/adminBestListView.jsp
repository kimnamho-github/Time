<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.common.model.vo.PageInfo
,com.admin.board.model.vo.BoardType
,com.admin.board.model.vo.Board
,java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<BoardType> btList = (ArrayList<BoardType>)request.getAttribute("btList");
	String bt = (String)request.getAttribute("bt");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 관리</title>
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
                <br>
                <h1 align="center" style="margin: initial;">이달의 레시피</h1>
                <br>
                <div class="search-area" style="margin-top: 20px;">
                    <button class="btn btn-danger" id="removeBtn" data-toggle="modal" data-target="#deleteModal" style="width: 10%; float: right; margin-right: 10px;">삭제</button>
                    <button class="btn btn-dark" id="searchBtn" style="width: 10%; float: right; margin-right: 10px;">조회</button>
                    <input type="text" id="boardName" class="form-control" style="width: 20%; float: right; margin-right: 10px;" placeholder="게시판 제목 입력"> 
                    <select name="categoryCode" id="categoryCode" class="form-select" style="width: 20%; float: right; margin-right: 10px;">
                        <option value="VIEWS" selected>조회수</option>
                        <option value="LIKES">좋아요</option>
                    </select>     
                </div>
                <div style="border: initial; height: 750px; margin-top: 80px; margin-bottom: 20px;">
                    <table id="list-area" class="table " align="center" style="text-align: center;">
                        <thead>
                            <tr>
                                <th width="8%">체크</th>
                                <th width="9%">No.</th>
                                <th width="8%">년월</th>
                                <th width="30%">글 제목</th>
                                <th width="10%">작성자</th>
                                <th width="10%">조회수</th>
                                <th width="10%">좋아요</th>
                            </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
                <div align="center" style="border: none;" id="page-area">

                </div>
            </div>
        </div>
    </div>
    <script>
        <%@ include file="../../../resources/js/adminBest.js" %>
    </script>

    <!-- deleteModal -->
    <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">게시글 삭제</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <p>선택한 게시글을 삭제 하시겠습니까?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                <button type="button" class="btn btn-primary" onclick="boardDelete();">확인</button>
            </div>
            </div>
        </div>
    </div>
</body>
</html>