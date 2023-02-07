<%@page import="com.admin.date.model.vo.Dose"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.common.model.vo.PageInfo
,java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PageInfo pageInfo  = (PageInfo)request.getAttribute("pageInfo");
	ArrayList<Dose> list = (ArrayList<Dose>)request.getAttribute("list");
	String search = (String)request.getAttribute("Search");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>재료 데이터 관리</title>
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
                <h1 align="center" style="margin: initial;">정량단위 데이터</h1>
                <br>
                <div class="search-area" style="margin-top: 20px;">
                    <button class="btn btn-primary" id="insertBtn" data-toggle="modal" data-target="#insertModal" style="width: 10%; float: right; margin-right: 10px; color: white;">추가</button>
                    <button class="btn btn-danger" id="removeBtn" data-toggle="modal" data-target="#deleteModal" style="width: 10%; float: right; margin-right: 10px;">삭제</button>
                    <button class="btn btn-dark" id="searchBtn" style="width: 10%; float: right; margin-right: 10px;">조회</button>
                    <input type="text" id="doseName" class="form-control" style="width: 20%; float: right; margin-right: 10px;" placeholder="정량단위 입력"> 
   
                </div>
                <div style="border: initial; height: 750px; margin-top: 80px; margin-bottom: 20px;">
                	
                <% if(list==null){ %>
                    <table id="list-area" class="table " align="center" style="text-align: center; width: 50%; float: left;" >
                    	<colgroup>
					    	<col width="16%" /><col width="16%" />
					    	<col width="16%" /><col width="16%" />
					    	<col width="16%" /><col width="16%" />
                        </colgroup>
                        <thead>
                            <tr>
                                <th>체크</th>
                                <th>No.</th>
                                <th>정량단위</th>
                                <th>체크</th>
                                <th>No.</th>
                                <th>정량단위</th>
                            </tr>
                        </thead>
                        <tbody>
                       	
                            <tr>
                            	<td colspan='6'>The thread does not exist</td>
                            </tr>
                        </tbody>
                    </table>
                <% }else{ %>
                    <table id="list-area" class="table " align="center" style="text-align: center; width: 50%; float: left;" >
                    	<colgroup>
					    	<col width="20%" />
					    	<col width="20%" />
					    	<col width="60%" />
                        </colgroup>
                        <thead>
                            <tr>
                                <th>체크</th>
                                <th>No.</th>
                                <th>정량단위</th>
                            </tr>
                        </thead>
                        <tbody>
                        <% 
                	 		int size = 10;
                        	if(list!=null){ 
                        %>
                        	<% 
                        		if(list.size()<10){ 
                        			size = list.size();
                        		}
                        	%>
                        	
                            <% for(int i = 0; i < size; i++){ %>
                            <tr>
                                <td id='boardCheck'><input type='checkbox' value='<%= list.get(i).getDoseCode() %>' name='dno' id='dno' style='width:25px;height:25px'></td>
                                <td><%= list.get(i).getDoseCode().substring(1) %></td>
                                <td><%= list.get(i).getDoseName() %></td>
                            </tr>
                            <% } %>
                        <% } %>
                        </tbody>
                    </table>
                    
                    <table id="list-area" class="table " align="center" style="text-align: center; width: 50%">
                    	<colgroup>
					    	<col width="20%" />
					    	<col width="20%" />
					    	<col width="60%" />
                        </colgroup>
                        <thead>
                            <tr>
                                <th>체크</th>
                                <th>No.</th>
                                <th>정량단위</th>
                            </tr>
                        </thead>
                        <tbody>
							
                        <% if(list!=null&&list.size()>10){ %>
                            <% for(int i = 10; i < list.size(); i++){ %>
                            <tr>
                                <td id='boardCheck'><input type='checkbox' value='<%= list.get(i).getDoseCode() %>' name='dno' id='dno' style='width:25px;height:25px'></td>
                                <td><%= list.get(i).getDoseCode().substring(1) %></td>
                                <td><%= list.get(i).getDoseName() %></td>
                            </tr>
                            <% } %>
                        <% } %>
                        </tbody>
                    </table>
                <% } %>
                </div>
                	<div align="center" style="border: none;" id="page-area">
					    <button class="btn btn-light"
					    <% if(pageInfo.getStartPage()==1){ %>
					    	disabled
					    <% } %>
					    >&lt;</button>
					    <% for(int i = pageInfo.getStartPage(); i < pageInfo.getEndPage()+1; i++){ %>
					    <button 
					        <% if(i==pageInfo.getCurrentPage()){ %>
					        	class="btn btn-link" style='text-decoration-line : none;'
					        <% }else { %>
					        	class="btn btn-light"
					    	<% } %>
					    	><%= i %></button>
					    <% } %>
					    <button class="btn btn-light"
					    <% if(pageInfo.getEndPage()==pageInfo.getMaxPage()){ %>
					    	disabled
					    <% } %>
					    >&gt;</button>
					</div>
            	</div>
        	</div>
    	</div>
    <script>
    <!-- 정량단위 추가 메서드 -->
    function dateInsert(){
        let dname = $("#doseInsertName").val();
        let regExp = /^[가-힣a-zA-Z0-9]+$/;
        if(regExp.test(dname)){
        	$.ajax({
	            url:"adminDoseCheck.da",
	            target:"get",
	            data:{
	            dname:dname},
	            success:function(result){
	                if(result > 0){
	                    alert("there is a name");
	                }else{
	                    $(location).attr("href","<%= request.getContextPath() %>/adminDoseInsert.da?dname="+dname);
	                }
	            },
	            error:function(){
	                alert("The thread does not exist");
	            }
        	});
        }else{
            alert("You entered an incorrect name");
        }
     }
     function dateDelete(){
        let index = 0;
        let dno = [];
        $("#list-area>tbody>tr").each(function(e){
            const checkEl = $(this).children().eq(0).children();
            if($(checkEl).is(':checked')){
            	dno[index] = $(this).children().eq(0).children().val();
                index++;
            }
        })
        if(dno.length > 0){
           $(location).attr("href","<%= request.getContextPath() %>/adminDoseListDelete.da?dno="+dno);
        }else{
            alert("There are no selected posts");
        }
     }
     $(function(){
    	 
    	$("#searchBtn").on('click',function(){
            location.href = "<%= request.getContextPath() %>/adminDoseList.da?search="+$("#doseName").val()+"&cPage=1";
    	})
    	
        $("#page-area>button").on('click',function(){
            let regExp = /^[0-9]*$/;
            
            let url = "<%= request.getContextPath() %>/adminDoseList.da?";
			<% if(search!=null){ %>
				url = "search=<%= search %>&";
			<% } %>
			url += "cPage=";
            let cPage = 1;
            if(regExp.test($(this).text())){
        		if($(this).text()==<%= pageInfo.getCurrentPage() %>){
        			return;
        		}
                cPage = $(this).text();
            }else if($(this).text()=='<'){
                cPage = <%= pageInfo.getStartPage() %>-1;
            }else{
                cPage = <%= pageInfo.getEndPage() %>+1;
            }
            location.href = url+cPage;
        })

        $('#list-area>tbody>tr').hover(function() {
			$(this).css('background-color','initial');
			$(this).css('cursor','Default');
		});

		$('#list-area>tbody>tr>td').css('padding-top','20px');
     })    
    </script>
    <!-- insertModal -->
    <div class="modal fade" id="insertModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">정량단위 데이터 생성</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <p>정량단위명을 입력해 주세요.</p>
                <p style="float: left; margin-right: 10px">정량단위명 : </p>
                <input style="width: 300px;" type="text" class="form-control form-control-sm" id="doseInsertName" maxlength="15">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                <button type="button" class="btn btn-primary" onclick="dateInsert();">확인</button>
            </div>
            </div>
        </div>
    </div>
    <!-- deleteModal -->
    <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">단위 데이터 삭제</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <p>선택한 단위 데이터를 삭제 하시겠습니까?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                <button type="button" class="btn btn-primary" onclick="dateDelete();">확인</button>
            </div>
            </div>
        </div>
    </div>
</body>
</html>