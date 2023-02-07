<%@page import="com.common.model.vo.Attachment"%>
<%@page import="com.user.board.recipe.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Board b = (Board) request.getAttribute("b");
	Attachment at = (Attachment)request.getAttribute("Attachment");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>mainpage</title>
<style>
.img-fluid {
  width: 850px;
  height: 850px;
  object-fit: cover;
}
</style>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
	
	
	<!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	
	<link rel="apple-touch-icon" href="<%=request.getContextPath() %>/template/assets/img/apple-icon.png">
	
    <link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath() %>/resources/image/common/iconCook.png">

    <link rel="stylesheet" href="<%=request.getContextPath() %>/template/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/template/assets/css/templatemo.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/template/assets/css/custom.css">

    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="template/assets/css/fontawesome.min.css">
    
    
</head>
<body>
     <%@ include file="views/common/menubar.jsp" %>	
     
    <br><br><br>
    
    <div align="center" class="tm"><b>Today's Menu</b></div>
    
    <br><br>
    
    <!-- Start Banner Hero -->
    <div id="template-mo-zay-hero-carousel" class="carousel slide" data-bs-ride="carousel">
        <ol class="carousel-indicators">
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="0" class="active"></li>
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="1"></li>
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="2"></li>
        </ol>
        
        <div class="carousel-inner">
            <div class="carousel-item active">
                <div class="container">
                    <div class="row p-5">
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                        <a href="<%=contextPath %>/detail.re?bno=5">
                            <img class="img-fluid" src="resources/image/recipeImg/39665_T.jpg" alt="">
                        </a>   
                        </div>
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-left align-self-center">
                                <h1 class="h1 text-yellow"><b>Today's menu</b></h1>
                                <h3 class="h2">오늘은 이 메뉴 어때요?</h3>
                                <p>
                                	
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <div class="container">
                    <div class="row p-5">
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                            <a href="<%=contextPath %>/detail.re?bno=7">
                            	<img class="img-fluid" src="resources/image/recipeImg/5836_T.jpg" alt="">
                            </a> 
                        </div>
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-left">
                                <h1 class="h1"><b>Today's menu</b></h1>
                                <h3 class="h2">오늘은 이 메뉴 어때요?</h3>
                                <p>
                                	
                                	
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <div class="container">
                    <div class="row p-5">
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                        <a href="<%=contextPath %>/detail.re?bno=9">
                            <img class="img-fluid" src="resources/image/recipeImg/73679_T.jpg" alt="">
                          </a>
                        </div>
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-left">
                                <h1 class="h1"><b>Today's menu</b></h1>
                                <h3 class="h2">오늘은 이 메뉴 어때요?</h3>
                                <p>
                                	
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev text-decoration-none w-auto ps-3" href="#template-mo-zay-hero-carousel" role="button" data-bs-slide="prev">
            <i class="fas fa-chevron-left"></i>
        </a>
        <a class="carousel-control-next text-decoration-none w-auto pe-3" href="#template-mo-zay-hero-carousel" role="button" data-bs-slide="next">
            <i class="fas fa-chevron-right"></i>
        </a>
    </div>
    <!-- End Banner Hero -->
    
    
    <br><br>
    
     
    <!-- Start Script -->
    <script src="assets/js/jquery-1.11.0.min.js"></script>
    <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="assets/js/bootstrap.bundle.min.js"></script>
    <script src="assets/js/templatemo.js"></script>
    <script src="assets/js/custom.js"></script>
    <!-- End Script -->
     
    <br><br>
     <%@ include file="views/common/footer.jsp" %>	
</body>
</html>