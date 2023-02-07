<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
		String errorMsg = (String)request.getAttribute("errorMsg");   
   
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center" style="color:red"><%= errorMsg %> Page 오류 <br>
	잘못된 접근입니다. </h1>
	<h3 align="center"><a href="<%= request.getContextPath() %>/index.jsp" style="text-decoration:none">메인페이지로 돌아가기</a></h3>

</body>
</html>