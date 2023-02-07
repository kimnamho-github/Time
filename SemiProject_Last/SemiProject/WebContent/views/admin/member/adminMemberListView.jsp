
<%@page import="com.admin.member.model.vo.AdminMember"%>
<%@page import="com.admin.member.model.vo.MemberGrade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.common.model.vo.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	ArrayList<AdminMember> mList = (ArrayList<AdminMember>)request.getAttribute("mList");
	ArrayList<MemberGrade> mgList = (ArrayList<MemberGrade>)request.getAttribute("mgList");
	String search = (String)request.getAttribute("search");
	String mg = (String)request.getAttribute("mg");
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
                <h1 align="center" style="margin: initial;">회원 게시판</h1>
                <br>
                
                <div class="search-area" style="margin-top: 20px;">
                
                    <button class="btn btn-danger" id="removeBtn" data-toggle="modal" data-target="#deleteModal" style="width: 10%; float: right; margin-right: 10px;">삭제</button>
                    <button class="btn btn-dark" id="searchBtn" style="width: 10%; float: right; margin-right: 10px;">조회</button>
                    <input type="text" id="memberName" class="form-control" style="width: 20%; float: right; margin-right: 10px;" placeholder="아이디 입력"> 
                    <select name="memberGrade" id="memberGrade" class="form-select" style="width: 20%; float: right; margin-right: 10px;">
                        <% if(mgList!=null){ %>                                
                        	<option value="%">all</option>
                            <% for(MemberGrade grade : mgList){ %>
                                <option value="<%= grade.getGradeCode() %>"><%= grade.getGradeName() %></option>
                            <% } %>
                        <% } %>
                    </select>     
                </div>
                <div style="border: initial; height: 750px; margin-top: 80px; margin-bottom: 20px;">
                    <table id="list-area" class="table " align="center" style="text-align: center;">
                        <thead>
                            <tr>
                                <th width="8%">체크</th>
                                <th width="12%">등급</th>
                                <th width="15%">아이디</th>
                                <th width="15%">닉네임</th>
                                <th width="15%">이메일</th>
                                <th width="15%">전화번호</th>
                                <th width="20%">생성일</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<% for(AdminMember m : mList){ %>
                        	
	                            <tr>
	                                <td id='boardCheck'>
	                                <% if(!m.getGradeCode().equals("ADMIN")){ %>
	                                    <input type='checkbox' value='<%= m.getMemberNo() %>' name='bno' id='bno' style='width:25px;height:25px'>
	                                <% }else{ %>
                                        <input type="hidden" value="<%= m.getMemberNo() %>">
                                    <% } %>
	                                </td>
	                                <td><%= m.getGradeCode() %></td>
	                                <td><%= m.getMemberId() %></td>
	                                <td><%= m.getMemberName() %></td>
	                                <td style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis;"><%= m.getEmail() %></td>
	                                <td style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis;"><%= m.getPhone() %></td>
	                                <td><%= m.getSubscriptionDate() %></td>
	                            </tr>
                        	<% } %>
                        </tbody>
                    </table>
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
	    <!-- 회원 탈퇴 메서드 -->
	    function memberDelete(){
	       let index = 0;
	       let mno = [];
	       $("#list-area>tbody>tr").each(function(e){
	           const checkEl = $(this).children().eq(0).children();
	           if($(checkEl).is(':checked')){
	           	mno[index] = $(this).children().eq(0).children().val();
	               index++;
	           }
	       })
	       if(mno.length > 0){
	          $(location).attr("href","<%= request.getContextPath() %>/adminMemberListDelete.me?mno="+mno);
	       }else{
	           alert("There are no selected posts");
	       }
	    }
	   $(function(){

    	$("#searchBtn").on('click',function(){
            location.href = "<%= request.getContextPath() %>/adminMemberView.me?search="+$("#memberName").val()+"&cPage=1&mg="+$("#memberGrade").val();
    	})
    	
        $("#page-area>button").on('click',function(){
            let regExp = /^[0-9]*$/;
            
            let url = "<%= request.getContextPath() %>/adminMemberView.me?";

			<% if(search!=null){ %>
				url += "search=<%= search %>&";
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
        });

		$('#list-area>tbody>tr>td').css('padding-top','20px');
    	$("#list-area>tbody>tr").on('click',function(e){
            if (!$(e.target).is('#boardCheck')&&!$(e.target).is('#boardCheck>input[type=checkbox]')) {
    	        let mno = $(this).children().eq(0).children().val();

    	        $.ajax({
    	        	url:"adminMemberSelect.me",
    	            target:"get",
    	            data:{mno : mno},
    	            success:function(m){
    	                if(m==null){
    	                    alert("member does not exist");
    	                }else{

							if(m["gradeCode"] == 'M1'){
								$("#grade").attr("disabled",true);
	    						$("#grade>option").each(function() {
	    							if($(this).val() == 'M1'){
	    								$(this).attr("selected",true);
	    							}
	    						});
							}else{
	    						$("#grade>option").each(function() {
	    							if($(this).val() == m["gradeCode"]){
	    								$(this).attr("selected",true);
	    								$(this).parent().attr("disabled",false);
	    							}
	    						});
							}
    						$("#mno").val(mno);
    						$("#id").val(m["memberId"]);
    						$("#pwd").val(m["memberPwd"]);
    						$("#name").val(m["memberName"]);
    						$("#phone").val(m["phone"]);
    						$("#email").val(m["email"]);
    						$("#address").val(m["address"]);
							$("#updateModal").modal('show');
							//.show();class=""
    	                }
    	            },
    	            error:function(){
    	                alert("The thread does not exist");
    	            }
            	});
    	        
        	}else{
            	const checkEl = $(this).children().eq(0).children();
    	        if($(checkEl).is(':checked')){
    		        $(checkEl).attr("checked",false);
    	        }else{
    	    	    $(checkEl).attr("checked",true);
    	        }
    		}
    	});

        });
    </script>
    <!-- deleteModal -->
    <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">회원 탈퇴</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <p>선택한 회원을 탈퇴 시키겠습니까?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                <button type="button" class="btn btn-primary" onclick="memberDelete();">확인</button>
            </div>
            </div>
        </div>
    </div>
    <!-- 회원 정보 모달 -->
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title" id="myModalLabel">회원 정보</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="location.href='<%= request.getContextPath() %>/adminMemberView.me?search=<%= search %>&cPage=<%= pageInfo.getCurrentPage() %>&mg=<%= mg %>'"><span aria-hidden="true">&times;</span></button>
        </div>
        <form action="<%= request.getContextPath() %>/adminMemberUpdate.me" method="post">
        <div class="modal-body">
          <table align="center" style="width: 400px;">
            <tr>
              <td>회원 등급</td>
              <td>
	            <input type="hidden" name="mno" id="mno">
                <select name="grade" class="form-control" id="grade">
                	<% for(MemberGrade grade : mgList){ %>
                  		<option value="<%= grade.getGradeCode() %>"><%= grade.getGradeName() %></option>
                  	<% } %>
                </select>
              </td>
            </tr>
            <tr>
                <td>아이디</td>
                <td><input type="text" class="form-control" name="id" disabled maxlength="30" id="id" required></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="text" class="form-control" name="pwd" maxlength="30" id="pwd" required></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" class="form-control" name="name" id="name" required></td>
            </tr>
            <tr>
                <td>전화번호</td>
                <td><input type="text" class="form-control" name="phone" id="phone"></td>
            </tr>
            <tr>
                <td>이메일</td>
                <td><input type="email" class="form-control" name="email" id="email"></td>
            </tr>
            <tr>
                <td>주소</td>
                <td><input type="text" class="form-control" name="address" id="address"></td>
            </tr>
        </table>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="location.href='<%= request.getContextPath() %>/adminMemberView.me?search=<%= search %>&cPage=<%= pageInfo.getCurrentPage() %>&mg=<%= mg %>'">닫기</button>
            <button type="submit" class="btn btn-primary">저장</button>
        </div>
        </form>
        </div>
    </div>
    </div>
</body>
</html>