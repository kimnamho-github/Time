<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.user.member.model.vo.Member"%>
<%@page import="com.user.member.model.vo.MyPage"%>
<!DOCTYPE html>
<%
		String contextPath = request.getContextPath();
		Member loginUser = (Member) session.getAttribute("loginUser");
		MyPage pro = (MyPage)session.getAttribute("pro");
		MyPage mp = (MyPage)session.getAttribute("mp");
		//로그인 성공시 띄워줄 알람 메세지
		String alertMsg = (String) session.getAttribute("alertMsg");
%>

<!--마이페이지 회원정보수정페이지에 넣어줄 변수선언  -->
	<%
	String profileOrigin = mp.getprofile_origin();
	String profileChange = mp.getprofile_change();
	String filePath = mp.getFilePath();
	String nickName = mp.getNickName();
	String aboutMe = mp.getAboutMe();
	
	String memberId = loginUser.getMemberId();
	String memberPwd = loginUser.getMemberPwd();
	String memberName = loginUser.getMemberName();
	String phone = (loginUser.getPhone() == null) ? "" : loginUser.getPhone();
	String email = (loginUser.getEmail() == null) ? "" : loginUser.getEmail();
	String address = (loginUser.getAddress() == null) ? "" : loginUser.getAddress();
	%>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>myPage</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="icon" type="image/x-icon"
	href="<%=request.getContextPath()%>/template_mypage/assets/img/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link
	href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:500,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Muli:400,400i,800,800i"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link
	href="<%=request.getContextPath()%>/template_mypage/css/styles.css"
	rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="${path}/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${path}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="${path}/dist/js/adminlte.min.js"></script>
<!-- HandleBars JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.11/handlebars.min.js"></script>
<style>
#success_message {
	display: none;
}

.myPageTop {
	height: 20%;
}

.myPageBottom {
	height: 80%;
}
.card {
  /* Add shadows to create the "card" effect */
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  width: 200px;
  height : 300px;
  float : left;
  margin-left: 50px;
  margin-right: 50px;
 
}

/* On mouse-over, add a deeper shadow */
.card:hover {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);

}

/* Add some padding inside the card container */
.container {
  padding: 2px 16px;
}
.comment-area{
	width: 1000px;
	width : 100%;
}
 .comment{
        margin-left: 10px;
        margin-right: 10px;
        padding: 0%;
      	float : left;
      	box-sizing: border-box;
        }
  
        .inquiry{
            width: 800px;
            
        }
        .inquiry>div{
            float: left;
            box-sizing: border-box;
            text-align: center;
        }
</style>

</head>
<!-- Start Top Nav -->

<body id="page-top">

	<script>
	let msg = "<%=alertMsg%>";

		if (msg != "null") {
			alert(msg);
			//성공때 띄운 session삭제
	<%session.removeAttribute("alertMsg");%>
		}
	</script>
	
	<div class="myPageTop">
		<nav
			class="navbar navbar-expand-lg navbar-light bg-yellow d-none d-lg-block"
			id="templatemo_nav_top">
			<div class="container text-light">
				<div class="w-100 d-flex justify-content-between">
					<div>
						<i class="fa fa-envelope mx-2"></i> <a
							class="navbar-sm-brand text-light text-decoration-none"></a> <i
							class="fa fa-phone mx-2"></i> <a
							class="navbar-sm-brand text-light text-decoration-none"></a>
					</div>
					<div>
						<a class="text-light" href="https://fb.com/" target="_blank"
							rel="sponsored"><i class="fab fa-facebook-f fa-sm fa-fw me-2"></i></a>
						<a class="text-light" href="https://www.instagram.com/"
							target="_blank"><i class="fab fa-instagram fa-sm fa-fw me-2"></i></a>
						<a class="text-light" href="https://twitter.com/" target="_blank"><i
							class="fab fa-twitter fa-sm fa-fw me-2"></i></a> <a
							class="text-light" href="https://www.linkedin.com/"
							target="_blank"><i class="fab fa-linkedin fa-sm fa-fw"></i></a>
					</div>
				</div>
			</div>
		</nav>
		<!-- Close Top Nav -->


		<!-- Header -->
		<nav class="navbar navbar-expand-lg navbar-light shadow">
			<div
				class="container d-flex justify-content-between align-items-center">
				<!-- 로고 -->
				<a class="navbar-brand text-success logo h1 align-self-center"
					href="<%=contextPath%>/index.jsp"> <img
					src="<%=contextPath%>/resources/image/common/logo.png" class="logo"
					width="200px" height="50px">
				</a>

				<button class="navbar-toggler border-0" type="button"
					data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<!-- 게시판 -->
				<div
					class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between"
					id="templatemo_main_nav">
					<div class="flex-fill">
						<ul
							class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
							<li class="nav-item"><a class="nav-link"
								href="<%=contextPath%>/list.re?currentPage=1"><b>Recipe
										Board</b></a></li>
							<li class="nav-item"><a class="nav-link"
								href="<%=contextPath%>/list.op?currentPage=1"><b>Open
										Board</b></a></li>
							<li class="nav-item"><a class="nav-link"
								href="<%=contextPath%>/list.qa?currentPage=1"><b>Q&A</b></a></li>
							<li class="nav-item"><a class="nav-link"
								href="<%=contextPath%>/list.mo?currentPage=1"><b>Monthly
										Best</b></a></li>
							<li class="nav-item"><a class="nav-link"
								href="<%=contextPath%>/list.in?currentPage=1"><b>Info</b></a></li>
						</ul>
					</div>


					<div class="navbar align-self-center d-flex">
						<div
							class="d-lg-none flex-sm-fill mt-3 mb-4 col-7 col-sm-auto pr-3">
							<div class="input-group">
								<input type="text" class="form-control" id="inputMobileSearch"
									placeholder="Search ...">
								<div class="input-group-text">
									<i class="fa fa-fw fa-search"> </i>
								</div>
							</div>
						</div>


						<!-- 검색창 -->
						<a class="nav-icon d-none d-lg-inline"
							href="<%=contextPath%>/search.re"> <i
							class="fa fa-fw fa-search text-dark mr-2"></i>
						</a>

						<!-- 로그인창 -->
						<% if (loginUser != null) { %>

						<a href="<%=contextPath%>/views/user/myPage.jsp"><%=mp.getNickName()%></a>

						<a class="nav-icon position-relative text-decoration-none"
							href="<%=contextPath%>/logout.me"> <i
							class="fa fa-fw fa-user-times text-dark mr-3"></i> <span
							class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark"></span>
						</a>
						<%} %>
						
					</div>
				</div>

			</div>
		</nav>
	</div>
	<!-- Navigation-->
	<div class="myPageBottom">
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top"
			id="sideNav">
			<a class="navbar-brand js-scroll-trigger" href="#page-top"> <!--내프로필사진 클릭 시 수정창띄우기-->
				<span class="d-block d-lg-none">Clarence Taylor</span> <span
				class="d-none d-lg-block"> 
				
					<%if(pro != null ){ %>
				<img 
					style="background-color: rgb(243, 243, 243);"
					class="img-fluid img-profile rounded-circle mx-auto mb-2"
					src="<%=contextPath + filePath + pro.getprofile_change() %>"
					alt="..." />
					<%} else{%>
					<img 
					style="background-color: rgb(243, 243, 243);"
					class="img-fluid img-profile rounded-circle mx-auto mb-2"
					src="<%=contextPath + filePath + profileChange %>"
					alt="..." />
						<%} %>
			</span>
			</a>
			<h6><%=nickName%></h6>
			<h6><%=aboutMe%></h6>
			<br>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#MyRecipe">MyRecipe</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#education">댓글</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#skills">Like</a></li>
					<br>
					<br>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#interests">문의결과</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#awardss">회원탈퇴</a></li>
				</ul>
			</div>

		</nav>
		<section class="resume-section" id="awards">
			<div class="resume-section-content">
				<h2 class="mb-5">MyPage</h2>
				<hr>
				<br>
				<div class="container">
					<form class="myPage-form" action="<%=contextPath%>/update.me" method="post" id="myPage-form" enctype="multipart/form-data">
						<fieldset>
							<!--프로필사진변경-->
							<div class="form-group">
								<div class="col-md-6 inputGroupContainer">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-user"></i></span> <label
											class="col-md-4 control-label" align="">ProFile</label>
										<%if(pro != null){ %>
											<img id="titleImg" width="100" height="100" src="<%=contextPath + filePath + pro.getprofile_change() %>" >	
										<%} else {%>
											<img id="titleImg" width="100" height="100" src="<%=contextPath + filePath + profileChange %>" >	
											
										<%} %>
										<div id="file-area">
										<input type="file" style="width: 250px" id="file1" name="profile" onchange="loadImg(this,1);" >
										</div>
									</div>
								</div>
							</div>
							<br>
							<!-- 자기소개등록변경-->
							<div class="form-group">
								<div class="col-md-6 inputGroupContainer">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-user"></i></span> <label
											class="col-md-4 control-label" align="">About Me <Meta:desc></Meta:desc></label>
										<input name="aboutMe" value="<%=aboutMe%>"
											class="form-control" type="text">
									</div>
								</div>
							</div>
							<br>
							<!-- 닉네임-->
							<div class="form-group">
								<div class="col-md-6 inputGroupContainer">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-user"></i></span> <label
											class="col-md-4 control-label" align="">NickName </label>
										<input name="nickName" value=<%=nickName%>
											class="form-control" type="text">
									</div>
								</div>
							</div>
							<br>
							<!-- 아이디변경-->
							<div class="form-group">
								<div class="col-md-6 inputGroupContainer">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-user"></i></span> <label
											class="col-md-4 control-label" align="">ID</label> <input
											name="memberId" value="<%=memberId%>" class="form-control"
											type="text" required readonly disabled>
									</div>
								</div>
							</div>
							<br>
							<!-- 비밀번호변경-->
							<div class="form-group">
								<div class="col-md-6 inputGroupContainer">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-user"></i></span> <label
											class="col-md-4 control-label" align="">password</label> <input
											name="memberPwd" class="form-control" type="password"
											required disabled>
									</div>
								</div>
							</div>
							<br>
							<!-- 이름변경-->
							<div class="form-group">
								<div class="col-md-6 inputGroupContainer">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-user"></i></span> <label
											class="col-md-4 control-label" align="">Name</label> <input
											name="memberName" value="<%=memberName%>"
											class="form-control" type="text" required readonly disabled>
									</div>
								</div>
							</div>
							<br>
							<!-- 핸드폰번호변경-->
							<div class="form-group">
								<div class="col-md-6 inputGroupContainer">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-user"></i></span> <label
											class="col-md-4 control-label" align="">Phone</label> <input
											name="phone" value="<%=phone%>" class="form-control"
											type="text">
									</div>
								</div>
							</div>
							<br>
							<!-- 이메일변경-->
							<div class="form-group">
								<div class="col-md-6 inputGroupContainer">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-user"></i></span> <label
											class="col-md-4 control-label" align="">E-mail</label> <input
											name="email" value="<%=email%>" class="form-control"
											type="text">
									</div>
								</div>
							</div>
							<br>
							<!-- 주소변경-->
							<div class="form-group">
								<div class="col-md-6 inputGroupContainer">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-user"></i></span> <label
											class="col-md-4 control-label" align="">Address</label>
										<textarea class="form-control" name="address"><%=address%></textarea>
									</div>
								</div>
							</div>



							<!-- Success message -->
							<div class="alert alert-success" role="alert"
								id="success_message">
								Success <i class="glyphicon glyphicon-thumbs-up"></i> Thanks for
								contacting us, we will get back to you shortly.
							</div>

							<!-- Button -->
							<div class="form-group">
								<label class="col-md-4 control-label"></label>
								<div class="col-md-6" align="center">
									<button type="submit" class="btn btn-warning">
										수정하기 <span class="glyphicon glyphicon-send"></span>
									</button>
								</div>
							</div>


						</fieldset>
					</form>
				</div>
			</div>
			<!-- /.container -->
	</div>
	<hr class="m-0" />
	<script>
	  $(function(){
	 $("#file-area").hide();
	 
	 $('#titleImg').click(function(){
         $("#file1").click();
     });
	  })
	 function loadImg(inputFile,num){
		 console.log(inputFile);
		 if(inputFile.files.length==1){
			 let reader = new FileReader();
			 reader.readAsDataURL(inputFile.files[0]);
			 reader.onload = function(e){
				 switch(num){
				 case 1 : $("#titleImg").attr("src",e.target.result); break
				 }
			 }
		 }else{
			 switch(num){
			 case 1 : $("#titleImg").attr("src",null); break
			 }
		 }
	 }
	 
	</script>
	
	
	<!-- Page Content-->
	<div class="container-fluid p-0">
		<!-- About-->
		<section class="resume-section" id="MyRecipe">
			<div class="resume-section-content" >
				<h2 class="mb-5">Recipe</h2>
				<hr>
 				 <div class="card" mb-6>
  					<img src="<%=contextPath%>/resources/image/recipeImg/39665_1.jpg" alt="Avatar">
 				 <div class="container">
 				 <br>
    				<h6><b><%=mp.getNickName() %></b></h6>
   					 <p>복날에 먹는 삼계탕</p>
   					 <br>
   					 <span style="font-size: 25px">♥　  　　　</span>
   					 <span>
   					 <small>삭제</small>
   					 </span>
 				 </div>
				</div>
				
 				 <div class="card" mb-6>
  					<img src="<%=contextPath%>/resources/image/recipeImg/39692_T.png" alt="Avatar">
 				 <div class="container">
 				 <br>
    				<h6><b><%=mp.getNickName() %></b></h6>
   					 <p>사골육수 하나로 너무쉬운 감자탕</p>		 
   					 <span style="font-size: 25px">♡　  　　　</span>
   					 <span>
   					 <small>삭제</small>
   					 </span>
 				 </div>
 				 </div>
 				 <div class="card" mb-6>
  					<img src="<%=contextPath%>/resources/image/recipeImg/90881_T.jpg" alt="Avatar">
 				 <div class="container">
 				 <br>
    				<h6><b><%=mp.getNickName() %></b></h6>
   					 <p>집들이때 요리 뭐해야하지 고민이라면?</p>
   					 <span style="font-size: 25px">♥　  　　　</span>
   					 <span>
   					 <small>삭제</small>
   					 </span>
 				 </div>
				</div>
				
				
			
			</div>
			</section>
		</div>
		
		<hr class="m-0" />

		<!-- Education-->
		<section class="resume-section" id="education">
			<div class="resume-section-content" style="width : 100%;">
				<h3 class="mb-5">댓글</h3>
				<hr>
				<input type="checkbox" style="margin-left: 15px;">　전체선택
				<hr>
				<div class="comment-area">
				    <div>
      				 	 <div class="comment" style="margin-top: 20px;">
      					  <input type="checkbox">
        				 </div>
        				 <div class="comment">
         				   <h6>우와 가지싫어하는데 한번 해먹어봐야겠어요</h6>
         				   <small>2022-11-15</small>
         				   <br>
        				    <small>가지싫어하는 사람마음도 돌릴 가지볶음</small>
       					  </div>
  				 	 </div>
				</div>
				<br><br><br><br><hr>
				<div class="comment-area">
				    <div>
      				 	 <div class="comment" style="margin-top: 20px;">
      					  <input type="checkbox">
        				 </div>
        				 <div class="comment">
         				   <h6>제 입맛에는 설탕을 반만넣는게 더 좋았을꺼같아요!</h6>
         				   <small>2022-11-12</small>
         				   <br>
        				    <small>잇몸으로 먹는 갈비찜</small>
       					  </div>
  				 	 </div>			
				</div>
								<br><br><br><br><hr>
				<div class="comment-area">
				    <div>
      				 	 <div class="comment" style="margin-top: 20px;">
      					  <input type="checkbox">
        				 </div>
        				 <div class="comment">
         				   <h6>오늘 저녁은 치킨에 맥주 어떠세요?</h6>
         				   <small>2022-10-29</small>
         				   <br>
        				    <small>저녁메뉴추천해주세요~~</small>
       					  </div>
  				 	 </div>			
				</div>
								<br><br><br><br><hr>
				<div class="comment-area">
				    <div>
      				 	 <div class="comment" style="margin-top: 20px;">
      					  <input type="checkbox">
        				 </div>
        				 <div class="comment">
         				   <h6>복날에는 역시 삼계탕이죠</h6>
         				   <small>2022-11-15</small>
         				   <br>
        				    <small>복날에 먹는 삼계탕</small>
       					  </div>
  				 	 </div>			
				</div>
				<br><br><br><br><br>
							<div class="form-group">
								<label class="col-md-4 control-label"></label>
								<div class="col-md-6" align="left" style="margin-left:70px;">
									<button type="submit" class="btn btn-warning">
										삭제하기 <span class="glyphicon glyphicon-send"></span>
									</button>
								</div>
							</div>				
				
				　
				
			</div>	
				 
				
		</section>
		<hr class="m-0" />
		<!-- Skills-->
		<section class="resume-section" id="skills">
			<div class="resume-section-content">
				<h2 class="mb-5">Like</h2>
				<hr>
				<div class="card" mb-6>
  					<img src="<%=contextPath%>/resources/image/recipeImg/62330_1.jpg" alt="Avatar">
 				 <div class="container">
 				 <br>
    				<h6><b>고먐미</b></h6>
   					 <p>설렁탕집 깍두기 완벽재현</p>
   					 
   					 <span style="font-size: 25px">♥　  　　　</span>
   					 <span>
   					 <small>삭제</small>
   					 </span>
 				 </div>
				</div>
				
 				 <div class="card" mb-6>
  					<img src="<%=contextPath%>/resources/image/recipeImg/73712_5.jpg" alt="Avatar">
 				 <div class="container">
 				 <br>
    				<h6><b>쿠킹마마</b></h6>
   					 <p>추운겨울날 생각나는 바지락 수제비</p>		 
   					 <span style="font-size: 25px">♥　  　　　</span>
   					 <span>
   					 <small>삭제</small>
   					 </span>
 				 </div>
 				 </div>
 				 <div class="card" mb-6>
  					<img src="<%=contextPath%>/resources/image/recipeImg/90881_T.jpg" alt="Avatar">
 				 <div class="container">
 				 <br>
    				<h6><b><%=mp.getNickName() %></b></h6>
   					 <p>집들이때 요리 뭐해야하지 고민이라면?</p>
   					 <span style="font-size: 25px">♥　  　　　</span>
   					 <span>
   					 <small>삭제</small>
   					 </span>
 				 </div>
				</div>
				<br><br>
				<div class="card" mb-6 style="margin-top: 50px;">
  					<img src="<%=contextPath%>/resources/image/recipeImg/39665_1.jpg" alt="Avatar">
 				 <div class="container">
 				 <br>
    				<h6><b><%=mp.getNickName() %></b></h6>
   					 <p>복날에 먹는 삼계탕</p>
   					 <br>
   					 <span style="font-size: 25px">♥　  　　　</span>
   					 <span>
   					 <small>삭제</small>
   					 </span>
 				 </div>
				</div>
			</div>
		</section>
		<hr class="m-0" />
		<!-- Interests-->
		<section class="resume-section" id="interests">
			<div class="resume-section-content" style="width: 1200px;">
		<h4 class="mb-5">문의결과</h4>	
		<hr>
		<div class="inquiry" >
      	  <div style="margin-left: 50px; margin-right: 50px;">문의유형</div>
       	  <div style="margin-left: 130px; margin-right: 130px;">내용</div>
      	  <div style="margin-left: 70px; margin-right: 50px;">작성일</div>
      	  <div style="margin-left: 50px; margin-right: 50px;">처리상태</div>
  		</div>	
  		<br>
		<hr>
		<div class="inquiry" >
      	  <div style="margin-left: 50px; margin-right: 50px;">[회원정보]</div>
       	  <div>비밀번호를 바꿨는데 변경이 안됐어요..!　</div>
      	  <div style="margin-left: 50px; margin-right: 50px;">22.11.12</div>
      	  <div style="margin-left: 40px; margin-right: 40px; color: blue;">[답변완료]</div>
  		</div>			
		<br>
		<hr>
		<br><br>
		<div class="form-group">
			<label class="col-md-4 control-label"></label>
				<div class="col-md-6" align="center">
			<button type="submit" class="btn btn-warning">
				1:1문의하기 <span class="glyphicon glyphicon-send"></span>
			</button>
				</div>
		</div>		
			</div>
		</section>
		<hr class="m-0" />
		<!-- Awards-->
		<section class="resume-section" id="awardss">
			<div class="resume-section-content" align="center">
				<h4 class="mb-5">회원탈퇴</h4>
				<hr>
				<br>
				<div align="center">
					<small>탈퇴 신청에 앞서 반드시 아래내용을 확인해주세요.</small> <br> <br>
				</div>
				<div class="list">
					<ul style="list-style-type: none">
						<li>1.CookCook 서비스 회원탈퇴 후 회원정보 및 이용기록은 모두 삭제되며, 다시 복구할 수
							없습니다.</li>
						<li>2.회원 탈퇴 시 고객정보가 삭제되어 추후 상담업무가 제한될 수 있습니다.</li>
						<li>3.작성한 후기와 결제내역은 이용약관과 관련 법률에 의해 보관됩니다.</li>
					</ul>
				</div>
				<br> <input type="checkbox" name="withdrawal" id="withdrawal">(필수)회원탈퇴
				안내사항을 확인하였습니다. <br> <br>
				<div class="col-md-6" align="center">
					<form action="<%=contextPath%>/delete.me" method="post">
						<input type="hidden" name="MemberId" value="<%=memberId%>">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <label
								class="col-md-5 control-label" align="">password</label> <input
								name="memberPwd" class="form-control" type="password" required>
						</div>
						<br>
						<button type="submit" class="btn btn-warning" id="secession"
							style="background-color: rgb(197, 197, 197);" disabled>
							탈퇴신청 <span class="glyphicon glyphicon-send"></span>
						</button>
						<a href="#page-top"></a>
						<button type="submit" class="btn btn-warning cancel">
							취소 <span class="glyphicon glyphicon-send"></span>
						</button>
					</form>

				</div>
				<!-- 체크박스 체크시 활성화 -->
				<script>
				
					$(document).ready(function() {
						$("#withdrawal").click(function() {
							if (this.checked) {
								$("#secession").prop("disabled", false);
							} else {
								$("#secession").prop("disabled", true);
							}

						});

					});
				</script>
			</div>
		</section>
	</div>
	</div>
</body>
</html>
A
