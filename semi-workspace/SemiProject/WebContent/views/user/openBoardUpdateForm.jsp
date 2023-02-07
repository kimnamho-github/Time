<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.user.board.open.model.vo.Board" %>
<% 
	Board b = (Board)request.getAttribute("b");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 게시글 수정</title>
<style>
@font-face {
    font-family: 'NanumSquareRound';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_two@1.0/NanumSquareRound.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
#cancel,#save,#cancel1,#ti,#t1{
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
              background-color:rgba(104, 100, 100, 0.163);
              margin: auto;
             margin-top: 20px;
              margin-bottom : 100px;
               border-radius: 15px;
               box-shadow: 3px 3px 4px 3px rgba(128, 128, 128, 0.334);
          }         
        #ntu{/*공지사항 작성*/
         padding: 27px;
    
         margin-right: 4px;
    	 margin-left: 10px;
    	 font-size: 20px;
    	   margin-bottom : 30px;
    	    color: black;
    	       font-weight: bold; 
  
      } 
       #list1{
          margin-top: 14px;
         height: 9%;
         margin-bottom: 50px;
         background-color: rgba(236, 205, 103, 0.727);
          border-radius: 6px;
          }
        #r-logo{/*위에 종*/
              margin-right: 4px;
              margin-bottom: 3px;
       
              width:18px;
              height:18px;      
          }
          .en{
         margin-left: auto;
      
          }
       #tii{
       	 font-size: 16px;
     
       }
        #tiii{
       	 font-size: 16px;
       	   
   
       }
          #ti{
          border-top: none;
            border-left: none;
            border-right: none;
            border-bottom: none;
            border-radius: 8px;
            font-size: 15px;
            width: 650px;
            box-shadow: 1px 1px 2px 1px  rgba(128, 128, 128, 0.334);
          }
           #t1{
          border-top: none;
            border-left: none;
            border-right: none;
            border-bottom: none;
             border-radius: 8px;
            font-size: 15px;
            width: 600px;
            box-shadow: 1px 1px 2px 1px  rgba(128, 128, 128, 0.334);
          }
         
       #enroll-form>table {border:1px solid white;}
	#enroll-form input,#enroll-form textarea{
		width:100%; /*가로길이를 부모요소의 100%로 */
		box-sizing:border-box; 
	}	
	.rbtng {
            /*취소/등록 버튼*/
            padding: 30px;
            margin: auto;

        }

        .rbtng .rbtn {
            background-color:rgba(186, 185, 180, 0.308);
            border: none;
            color: black;
            margin: 10px;
            padding: 10px 32px;
            border-radius: 4px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            cursor: pointer;
            box-shadow: 1px 1px 1px 1px rgba(128, 128, 128, 0.334);
        }

        .rbtng .rbtn#save:hover {
            background-color: rgb(236, 206, 103);
        }

        .rbtng .rbtn#cancel:hover {
            background-color: rgba(148, 146, 138, 0.698);
        }
        .rbtng .rbtn#cancel1{
        	background-color:rgba(186, 185, 180, 0.308);
            border: none;
            color: black;
            margin: 10px;
            padding: 10px 32px;
            border-radius: 4px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            cursor: pointer;
            box-shadow: 1px 1px 1px 1px rgba(128, 128, 128, 0.334);
        
        }
        .rbtng .rbtn#cancel1:hover{
            background-color: rgba(148, 146, 138, 0.698);
        }
        
</style>        
</head>
<body>
	
	<%@ include file = "/views/common/menubar.jsp" %>
	<div class="outer1">
		<div id="list1">
			<h2 id="ntu"><img src="resources/image/common/pencil.png" id="r-logo">자유게시판 수정</h2>
		</div>
		
		<div>
		<form action="<%= contextPath %>/update.op" id="update-form" method="post" >
			
			<input type="hidden" name="boardNo" value="<%=b.getBoardNo()%>">
			
			<div class="en">
			<table align="center">
			 
				<tr>
					<th width="50" id="tii">제목</th>
					<td width="650"><input type="text" id="t1" name="op-title" required value="<%=b.getBoardTitle() %>"></td>
				</tr>
				<tr>
					<th class="en" id="tiii">&nbsp;</th>
					<td></td>
				</tr>
			
				<tr>
					
					<td colspan="2">
						<textarea name="op-content" rows="22" id="ti" style="resize:none" id="ti" required placeholder="수정하실 내용을 입력해주세요."  maxlength="700"><%=b.getBoardContent()%></textarea>
					</td>
				</tr>
		
			
			</table>	
			</div>
			
			
				<div align="center" class="rbtng">
					<a href="<%=contextPath%>/list.op?currentPage=1" class="rbtn" id="cancel1">목록</a>
					<button type="submit" class="rbtn" id="save">수정</button>
					<button type="reset" class="rbtn" id="cancel">취소</button> 
				</div>
		
		
		
		
		</form>
	</div>
			
	
	</div>
	
	<%@include file="/views/common/footer.jsp" %>
	
			<script>
			function textArea(){
			var str = document.getElementById("ti").value;
			str = str.replace(/(?:\r\n|\r|\n)/g,'<br/>');
			document.getElementById("ti").value = str;		
			}	
		
	
		</script>

</body>
</html>