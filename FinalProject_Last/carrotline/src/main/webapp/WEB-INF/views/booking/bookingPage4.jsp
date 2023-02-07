<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CARROT LINE Booking</title>
<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/common/header.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/booking/bookingWrite.css" rel="stylesheet">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src='https://kit.fontawesome.com/77ad8525ff.js' crossorigin="anonymous"></script>

<link href="<%=request.getContextPath()%>/css/mypage/ticketCheck.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/mypage/mypageHeader.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,600,700' rel='stylesheet' type='text/css'>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="https://flyasiana.com/C/pc/css/reset.css">
<link rel="stylesheet" type="text/css" href="https://flyasiana.com/C/pc/css/layout.css">
<link rel="stylesheet" type="text/css" href="https://flyasiana.com/C/pc/css/common.css">
<link rel="stylesheet" type="text/css" href="https://flyasiana.com/C/pc/css/flyasiana.css">
<link rel="stylesheet" type="text/css" href="https://flyasiana.com/C/pc/css/calendar.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/header.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	.bs4-order-tracking{margin-bottom: 30px;overflow: hidden; color: #878788;padding-left: 0px;margin-top: 30px} 
	.bs4-order-tracking li{list-style-type: none;font-size: 13px;width: 15%;   float: left;position: relative;font-weight: 400;color: #878788;text-align: center}
	.bs4-order-tracking li:first-child:before{margin-left: 15px !important;padding-left: 11px !important;text-align : left !important}
	.bs4-order-tracking li:last-child:before{margin-right: 5px !important;padding-right: 11px !important;text-align : right !important}
	.bs4-order-tracking li>div{color: #fff;width: 29px; height: 29px; text-align: center; line-height: 29px;display: block;font-size: 12px;background: #878788;border-radius: 50%; margin: auto;}
	.bs4-order-tracking li>div>i{margin-top: 10px;}
	.bs4-order-tracking li:after{content: '';width: 150%;height: 2px;background: #878788;position: absolute;left: 0%;right: 0%;top: 15px;z-index: -1}
	.bs4-order-tracking li:first-child:after{left: 50%}
	.bs4-order-tracking li:last-child:after{left: 0%!important;width: 0% !important}
	.bs4-order-tracking li.active{font-weight: bold;color: #dc3545}
	.bs4-order-tracking li.active>div{background: #da5c3d}
	.bs4-order-tracking li.active:after{background: #da5c3d}
	.card-timeline{background-color: #fff;z-index: 0}
	.reservation_section li:first-child .section_tit {
    border-radius: 5px 5px 0px 0px;}
    .reservation_section .section_tit {
    position: relative;
    width: 100%;
    height: 40px;
    text-align: center;
    line-height: 40px;
    background-color: rgb(245, 245, 245);}
    
</style>

</head>
<body>


<!--넘어가는 과정 추가 -->
<div class="card card-timeline px-2 border-none">
	<ul class="bs4-order-tracking"> 
		<li class="step active">
			 <div><i class="fas fa-check"></i></div> 1.여정검색 </li>
		<li class="step active"> 
			<div><i class="fas fa-check"></i></div> 2.탑승자 정보 입력 </li> 
		<li class="step active"> 
			<div><i class="fas fa-check"></i></div> 3.부가서비스 </li>
		<li class="step active"> 
			<div><i class="fas fa-check"></i></div> 4.선택내역 확인 및 규정동의 </li>
		<li class="step "> 
			<div><i class="fas fa-check"></i></div> 5.결제 </li> 
		<li class="step "> 
			<div><i class="fas fa-check"></i></div> 6.예약완료 </li>  			 
	</ul> 
</div>



<div id="title">운임 정보</div>
<div id="tmsg" align="center">선택하신 운임정보를 확인하세요. </div>
<br>
<div class="reservation_section">
		<ul>
			<li>
				<div class="section_tit">
					<span class="num">구간1</span>
				</div>
		</ul>							
<div id="top">
<div id="topWrap">
<div id="top1">
<i class="fa fa-plane" style="font-size:30px;color:white; padding-top: 20px;"> 서울/인천</i><br><br>
<i class='fas fa-angle-right' style='font-size:10px;'></i> 2022-12-30  <br>
<i class='fas fa-angle-right' style='font-size:10px;'></i> 07:45 ~ 10:10  <br>
<i class='fas fa-angle-right' style='font-size:10px;'></i> 02h 25m<br>
<i class='fas fa-angle-right' style='font-size:10px;'></i> B737-800<br>

</div>

<div id="top2">
<%-- <c:if test="${bVO.kind == '왕복'}"> --%>
<i class="fa fa-plane" style="font-size:30px;color:white; padding-top: 20px;"> 도쿄/나리타</i><br><br>
<i class='fas fa-angle-right' style='font-size:10px;'></i> 2023-01-05  <br>
<i class='fas fa-angle-right' style='font-size:10px;'></i> 07:45 ~ 10:10  <br>
<i class='fas fa-angle-right' style='font-size:10px;'></i> 02h 25m<br>
<i class='fas fa-angle-right' style='font-size:10px;'></i> B737-800<br>
<%-- </c:if> --%>
</div>

<div id="top3"> 
<i class="material-icons" style="font-size:40px; color: white; padding-top: 20px;">person</i> 

<h5>성인 : 1 </h5>

<h5>아동 : 1</h5>


</div>

<div id="top4">
<i class='fas fa-credit-card' style="font-size:30px; color: white; padding-top: 24px;"></i>
<h5>가는편 : 300,000원</h5>
<%-- <c:if test="${bVO.kind == '왕복'}"> --%>
<h5>오는편 : 300,000원</h5>
<%-- </c:if> --%>
</div>

</div>
</div>
</div>





<div id="title" style="border: none;">예약규정(필수)</div>
<div id="tmsg" align="center">예약에 대해 통보된 규정을 정확히 확인하시기 바랍니다.</div>
	<div class="container" id="container">
			<div class="mem_wrap">			
				<form action="${pageContext.request.contextPath}/payment.pa" id="form_terms" method="get">
					<fieldset>
						<legend>회원 약관동의 폼</legend> 
						<ul class="list_type6 border">
						
							<li>
								<input type="checkbox" id="agree_all" data-type="all_ck_item">
								<label for="agree_all" class="fsz_23">캐럿라인클럽 일반규정, 약관 및 본인의 개인정보 수집·이용, 국외 이전, 제 3자 제공에 모두 동의합니다.</label> 
								
							</li>
							<li class="terms_area">
								<input type="checkbox" name="agree1" id="agree_hompageUse" data-type="ck_item">
								<label for="agree_hompageUse" class="fsz_23"><span class="col_brown2">[필수]</span>국제여객운송약관 </label> 
								
								<div class="terms_cont" name="terms01" tabindex="0">
								<p> 제 1 조 (정의)<br>
	 <br>
	 본 약관에서 사용하는 각 용어의 정의는 다음과 같다. <br>
	 <br>
	 1.&nbsp;“수하물 ”이란 여객이 자신의 여행과 관련하여 착용 또는 사용하거나 안락 또는 편의를 위하여 필요하거나 적절한 여객의 물품, 용품 및 기타 휴대품을 의미하며,별도로 명시되어 있지 않는 한 위탁 수하물 및 휴대 수하물을 공히 포함한다. 단, 동일한 품목을 다량 운송하는 경우에는 상업용 목적으로 간주하며 특별한 사유가 없는 한 수하물로 인정하지 않는다.  <br>
	 <br>
	 2. &nbsp;“수하물표 ”란 전적으로 위탁 수하물의 식별만을 위하여 운송인에 의하여 발행된 증표로서 위탁 수하물에 부착하는 수하물 확인표와 여객에게 인도되는 수하물 청구표로 구성된다. <br>
	 <br>
	 3.&nbsp; “운송”이란 수송과 동의어로서 유상 또는 무상으로 행하는 여객 또는 수하물의 항공운송을 말한다. <br>
	 <br>
	 6. 2008년 10월 1일부터 항공 탑승 또는 마일리지 적립 시점의 회원 자격에 따라, 매직마일즈 및 실버, 골드 회원 자격 으로 적립한 마일리지는10년 째 되는 해의 12월 31일까지, 다이아몬드         이상 우수회원 자격으로 적립한 마일리지는 12년째 되는 해의 12월 31일까지 유효하며, 유효기간 내에 사용되지 않은 마일리지는 소멸됩니다. 단, 2008년 9월 30일까지 적립된 마일리지는 유효기간이         적용되지 않습니다. 캐럿라인 또는 제휴 항공사를 탑승한 마일리지는 탑승일로부터, 제휴사를 포함한 기타 마일리지는 회원 계좌에 적립된 날로부터 유효기간이 적용됩니다. <br>
	 <br>
	 7.&nbsp;캐럿라인클럽의 제반 규정은, 관련 법령의 제정, 개정 및 폐지, 다른 항공사와의 국제적 업무 제휴 개시 또는 변경 등과 관련하여 업무 제휴 항공사의 규정과 균형을 맞추기 위해 불가피한 경우, 일반         항공권 가격의 상당한 변동으로 인하여 발생한 마일리지 제도의 불균형을 시정하기 위하여 필요한 경우, 예상치 못한 항공 수요의 급격한 변화, 기타 항공산업의 중대한 위기를 초래할 우려가 있는 불가항력적인         사정이 상당 기간동안 지속되는 경우, 국가 경제의 심각한 악화, 국가 신용도의 급격한 하락, 기타 이에 준하는 경제 상황의 중대한 변동으로 인하여 불가피한 경우 등 상당한 이유가 있는 경우 3개월 사전고지         후 변경될 수 있습니다. 다만, 규정변경 발효일 이전까지 회원님께서 취득한 마일리지의 경우에는 마일리지 공제로 지급되는 보너스항공권(좌석승급 보너스포함)에 대하여 발효일로부터 12개월까지는 변경전의 공제기준이         적용됩니다. <br>
	 <br>
	 8.&nbsp;캐럿라인은 언제든지 회원 계좌에 대해 검색을 할 수 있으며, 회원의 제반 실적이 잘못된 경우에는 이를 임의로 정정할 수 있습니다. 그리고 제반 규정을 위반 또는 악용하거나 부당한 방법으로 마일리지를         적립한 경우 회원님의 계좌를 취소할 수 있으며 적립된 마일리지 및 사용되지 않은 보너스(항공권 및 좌석 승급 등)도 말소할 수 있습니다.<br>
	 <br>
	 9. 캐럿라인은 회원님께서 캐럿라인클럽 규정을 위반한 경우 회원 자격을 박탈할 수 있습니다. 특히 캐럿라인클럽의 마일리지를 유상판매, 교환하려는 의사를 밝히거나, 실제 유상 판매 또는 교환하는 행위는 엄격히 금지되어 있습니다. 적발될 경우 모든 적립된 마일리지가 취소되며 회원 계좌도 정지됩니다. 그리고 고객의 안전과 서비스 향상을 위하여 위탁수하물 관련 규정과 라운지 이용 규정 위반 시  우수회원 혜택의 일부 또는 전부가 제한될 수 있습니다.<br>
	 <br>
	 10.&nbsp;캐럿라인은 마일리지 적립 기록이 없는 회원님에 대해 e-news letter, 마일리지 실적표 및 각종 프로모션 홍보물 등을 발송하지 않을 수도 있습니다. 또한 특별 보너스 마일리지 등의 프로모션         정보를 회원님의 정보 내용, 지리적 위치 등에 따라 선별적으로 회원님께 제공할 수 있습니다. 프로모션 정보 및 캐럿라인클럽 프로그램 변경 등의 정보는 캐럿라인클럽의 데이터베이스에 있는 주소에 한하여 발송합니다.<br>
	 <br>
	 11.&nbsp;캐럿라인은 우편물 등의 분실 및 지연 등에 책임이 없습니다. 회원님의 주소, e-mail 및 전화번호 등 개인정보가 변경된 경우 캐럿라인에 이를 알려주셔야 하며, 부정확한 정보로 인해 캐럿라인으로부터         연락을 받지 못하여 손해가 발생한 경우 캐럿라인은 이에 대해 책임을 지지 않습니다. <br>
	 <br>
	 12.&nbsp;캐럿라인클럽 마일리지는 금전적으로 환산되거나 환급되지않으며 타인에게 양도되지 않습니다. 회원 개인 신상에 변동(사망, 이혼 등의 경우)이 생겨도 적립된 마일리지 및 회원 혜택 사항 등이 가족이나         타인에게 상속 또는 양도되지 않으며, 회원이 탈퇴하거나 사망한 경우 회원 계좌 및 마일리지가 자동 소멸 됩니다.<br>
	 <br>
	 13.&nbsp;캐럿라인클럽의 제휴사 프로그램은 제휴사의 사정에 따라 사전 통보 없이 변경되거나 중단될 수 있습니다.<br>
	 <br>
	 14.&nbsp;회원님께서 등록하신 국가 및 주소지에 의해 지역별 혜택의 구분이 있을 수 있습니다. <br>
	 <br>
	 15.&nbsp;캐럿라인에서 통제할 수 없는 상황, 즉 노동문제, 사회혼란, 정부명령, 천재지변, 날씨, 전쟁 또는 본 프로그램을 유지함에 현저한 저해 요인이 발생할 경우 캐럿라인의 자체 판단에 의해 프로그램을         연기 또는 중단할 수 있습니다. <br>
	 <br>
	 16.&nbsp;캐럿라인 이용 실적 또는 보너스와 관련된 제반 이의는 해당 항공편 탑승일 또는 보너스 발행일로부터 1년 이내에 제기하셔야 합니다. 또한, 제휴사 이용 실적도 제휴사 이용일로부터 1년 이내에         이의를 제기하셔야 합니다. <br>
	 <br>
	 17.&nbsp;마일리지 보너스 사용시 세금, 검색비용, 공항세 등의 제세공과금과 유류 할증료, 전쟁보험료 등의 할증료 및 제반 수수료는 이용하시는 회원님께서 지불하셔야 합니다.<br>
	 <br>
	 18.&nbsp;보너스 항공권 또는 좌석승급 보너스의 사용은 여유좌석 이용이 원칙이며, 보너스 예약 클래스는 별도로 지정되어 있습니다. 또한 보너스 좌석수와 사용은 제한될 수 있습니다.<br>
	 <br> 19.&nbsp;캐럿라인은 잔여 마일리지 없이 10년 이상 장기간 활동이 없는 회원의 경우 탈퇴 처리할 수 있습니다.(2011년 9월 1일부 시행)</p><style type="text/css"> .policy_wrap p{ padding:15px 0;}   
	</style>
	<div class="policy_wrap"> 
	<p><strong>제1장 총칙</strong></p> 
	<p>제1조 [목적]<br> 본 약관은 '캐럿라인 주식회사 (이하 "캐럿라인"라고 합니다.)' 에서 운영하는 캐럿라인 온라인플랫폼에서 제공하는 인터넷 관련 서비스를 이용함에 있어 캐럿라인과 이용자간 권리ㆍ의무 및 기타 책임사항 등에 대하여 규정함을 목적으로 합니다.</p> 
	<p>제2조 [용어의 정의]<br>
	 ① “온라인플랫폼” 이란 캐럿라인이 상품 또는 서비스를 이용자에게 제공하기 위하여 컴퓨터 등 정보통신설비와 정보통신망을 이용하여 상품 등을 거래할 수 있도록 설정한 가상의 영업장(홈페이지, 모바일 웹/어플리케이션)을 말합니다.<br>
	 ② "이용자" 란 온라인플랫폼에 접속하여 본 약관에 따라 캐럿라인이 제공하는 서비스를 받는 회원 또는 비회원을 말합니다.<br>
	 ③ "회원"이라 함은 온라인플랫폼에 개인정보를 제공하고 회원등록을 한 자로서, 캐럿라인이 온라인플랫폼을 통해 지속적으로 제공하는 정보 및 서비스를 계속적으로 이용할 수 있는 자를 말합니다.<br>
	 ④ "비회원"이라 함은 회원으로 가입하지 않고 캐럿라인이 제공하는 정보 및 서비스를 이용하는 자를 말합니다.<br>
	 ⑤ "Asiana Club" 이란 캐럿라인의 탑승 및 제휴사를 이용할 때마다 보너스 마일리지를 적립하고 적립된 마일리지를 사용하고자 캐럿라인클럽 회원 약관에 동의하고 회원이 된 자를 말합니다.<br>
	 ⑥ "온라인플랫폼 회원"이란 캐럿라인클럽 회원 중 캐럿라인 온라인플랫폼을 이용하기 위해 아이디 및 비밀번호를 등록한 회원을 말합니다.<br>
	 ⑦ "입점 제휴사"라 함은 캐럿라인과 제휴되어 온라인플랫폼에 입점 및 연결된 사이트의 제휴사를 말합니다.<br>
	 ⑧ "에브리에어 연결 사이트" 란 온라인플랫폼과 하이퍼링크 방식 (하이퍼링크 대상에는 문자, 정지 및 동화상 등이 포함됨) 등으로 연결된 웹 사이트를 말합니다.<br> ⑨ "개인정보" 라 함은 당해 정보에 포함되어 있는 성명, 전자우편 등의 사항에 의하여 특정 개인을 식별할 수 있는 정보 (당해 정보만으로는 특정개인을 인식할 수 없더라도 다른 정보 용이하게 결합하여 식별할 수 있는 것을 포함한다)을 말합니다.</p> 
	<p>제3조 [약관의 게시 및 개정]<br>
	 ① 캐럿라인은 본 약관의 내용과 상호, 연락처, 영업장 주소지 등을 이용자가 알 수 있도록 캐럿라인 온라인플랫폼 초기 서비스화면에 게시합니다. 다만, 약관의 내용은 이용자가 연결화면을 통하여 볼 수 있도록 할 수 있습니다.<br>
	 ② 캐럿라인은 '전자상거래등에서의 소비자보호에 관한 법률', '약관의 규제에 관한 법률', '전자거래기본법', '전자서명법', '정보통신망이용촉진 및 정보보호 등에 관한 법률','방문판매 등에 관한 법률', '소비자기본법' 등 관련 법령을 위반하지 않는 범위 내에서 본 약관을 개정할 수 있습니다.<br>
	 ③ 약관을 개정할 경우에는 캐럿라인은 개정내용, 개정사유, 적용일자 등을 명시하여 현행 약관과 함께 온라인플랫폼의 초기화면에 공지하며, 공지기간은 적용일자 7일 이전부터 적용일자 전일까지로 합니다.<br> ④ 개정된 약관은 대한민국 내 관련 법령에 위반하지 않는 한, 약관 개정 이전에 가입한 회원에 대하여도 전항과 같이 공지 후 적용합니다. 단, 회원이 개정된 약관의 적용에 대하여 개정약관 적용일 이전까지 캐럿라인에 명시적으로 거부의 의사를 표시하는 경우, 해당 회원에 한하여 개정전의 구 약관이 적용됩니다.</p> 
	<p>제4조 [약관 이외의 준칙]<br> 본 약관에서 정하지 아니한 사항이나 본 약관의 해석에 관해서는 '약관의 규제에 관한 법률', '전자상거래등에서의 소비자보호에 관한 법률', '소비자기본법' 등 관련 법령과 대한민국의 일반적인 상관례에 따릅니다.</p> 
	<p><strong>제2장 서비스 이용</strong></p> 
	<p>제5조 [서비스의 제공]<br>
	 ① 캐럿라인은 온라인플랫폼을 통해 다음의 서비스를 제공합니다.&nbsp;<br>
	 &nbsp; 1. 항공권 예매 및 관련 서비스&nbsp;<br>
	 &nbsp; 2. 캐럿라인클럽 관련 서비스<br>
	 &nbsp; 3. 여행정보 제공 서비스<br>
	 &nbsp; 4. 캐럿라인이 제공하는 서비스 소개 <br>
	 5. 기타 캐럿라인이 정하는 업무<br> ② 캐럿라인은 필요한 경우 전항의 서비스의 내용을 임의로 추가, 조정 등 변경하여 적용할 수 있습니다.</p> 
	<p>제 6 조 [서비스의 이용 및 제한]<br>
	 ① 서비스의 이용은 연중무휴, 1일 24시간 이용을 원칙으로 합니다.<br>
	 ② 캐럿라인은 컴퓨터 등 정보통신설비의 보수점검, 교체 및 고장, 시스템의 고장, 통신두절 등의 사유가 발생한 경우 서비스의 제공을 일시적으로 중단할 수 있습니다.<br>
	 ③ 캐럿라인은 제2항의 사유로 인하여 서비스제공이 중단된 경우, 이로 인하여 이용자 또는 제3자가 입은 손해에 대하여는 배상하지 아니합니다. 단, 캐럿라인에 고의 또는 중과실이 있는 경우에는 그러하지 아니합니다.&nbsp;<br>
	 ④ 캐럿라인이 제공하는 인터넷 서비스의 일부는 온라인플랫폼에 회원으로 가입한 경우에 한하여 이용될 수 있습니다.<br>
	 ⑤ 캐럿라인은 이용자가 다음 각 호의 1에 해당하는 행위를 한 경우 사전통지 없이 서비스이용을 차단하거나 중지할 수 있습니다.&nbsp;<br>
	 &nbsp; &nbsp; 1. 공공질서 또는 미풍양속에 반하는 행위<br>
	 &nbsp; &nbsp; 2. 범죄와 관련되었다고 추정되는 일체의 행위<br>
	 &nbsp; &nbsp; 3. 공공의 이익을 저해할 목적으로 서비스 이용을 계획 또는 실행하는 행위<br>
	 &nbsp; &nbsp; 4. 타인의 아이디 및 비밀번호를 도용한 행위<br>
	 &nbsp; &nbsp; 5. 타인의 명예를 훼손하거나 모욕을 준 경우 기타 타인을 해할 목적의 행위<br>
	 &nbsp; &nbsp; 6. 한 사용자가 2개 이상의 아이디로 이중 등록한 행위<br>
	 &nbsp; &nbsp; 7. 서비스의 제공을 방해하는 등 서비스의 건전한 이용을 저해하는 행위<br>
	 &nbsp; &nbsp; 8. 기타 관련 법령이나 캐럿라인이 약관에서 정한 이용규칙을 위배하는 행위<br> ⑥ 전 제5항 각 호의 1에 해당하는 사유로 인하여 서비스이용이 중지된 경우, 캐럿라인은 이용자에게 이로 인한 손해배상책임을 지지 않습니다.</p> 
	<p>제7조 [회원의 가입]<br>
	 ① 이용자는 캐럿라인이 정한 가입양식에 따라 회원정보를 기입한 후 약관에 동의한다는 의사표시를 함으로써 회원가입이 이루어집니다.<br>
	 ② 이용자가 화면의 "동의" 버튼을 누르는 것은 본 약관의 내용에 합법적으로 동의하는 것으로 간주됩니다. 단, 만 14세 미만의 미성년자의 경우에는 법정 대리인의 동의를 받아 본 약관에 동의하고 가입신청을 할 수 있습니다.&nbsp;<br>
	 ③ 회원이 되고자 하는 자는 반드시 실명으로 회원가입을 하여야 하며, 캐럿라인이 요청하는 개인정보를 제공해야 합니다.<br>
	 ④ 다음 각 호의 1에 해당하는 자는 회원으로 등록할 수 없습니다.&nbsp;<br>
	 &nbsp; &nbsp; 1. 타인 또는 허무인 명의로 가입을 신청한 경우<br>
	 &nbsp; &nbsp; 2. 회원가입 신청서 내용의 일부 또는 전부를 허위로 기재한 경우<br>
	 &nbsp; &nbsp; 3. 신청자가 본 약관 제8조 제2항에 의하여 회원자격을 상실한 날로부터 3년이 경과되지 아니한 경우<br>
	 ⑤ 회원은 등록사항에 변경이 발생한 경우 &lt;회원정보변경&gt; 항목을 통해 직접 변경사항을 수정, 등록함으로써 최신의 정보가 유지되도록 하여야 합니다.<br> ⑥ 회원가입신청서에 기입한 모든 정보는 실제 데이터인 것으로 간주되며 실제 정보를 입력하지 않거나 수정하지 않음으로 인해 발생하는 불이익은 회원이 부담하게 됩니다.</p> 
	<p>제8조【회원 ID 및 Password】<br>
	 ① 온라인플랫폼 서비스를 이용하고자 하는 회원은 캐럿라인이 정하는 바에 따라 회원ID 및 Password를 캐럿라인 온라인플랫폼에 등록하여야 합니다.&nbsp;<br>
	 ② 회원 ID와 Password에 관한 관리책임은 회원 본인에게 있으므로 회원은 자신의 ID 및 Password를 제3자에게 알려주거나 이용하게 해서는 안됩니다.<br> ③ 회원이 자신의 ID 또는 Password를 도난 당하거나 제3자가 사용하고 있음을 인지한 경우에는 즉시 캐럿라인에 통보하고 캐럿라인의 안내가 있는 경우에는 그에 따라야 합니다.</p> 
	<p>제 9조 [회원탈퇴와 자격의 상실]<br>
	 ① 탈퇴를 희망하는 회원은 온라인플랫폼의 MY ASIANA내 회원탈퇴 기능을 통해 언제든지 용이하게 탈퇴가 가능합니다.<br>
	 ② 회원이 다음 각 호에 해당하는 경우에는 캐럿라인은 회원의 서비스이용을 제한하거나 회원의 자격을 상실시킬 수 있습니다.&nbsp;<br>
	 &nbsp; &nbsp; 1. 회원의 사망<br>
	 &nbsp; &nbsp; 2. 가입신청시 허위의 내용을 기재하거나 2개 이상의 ID로 이중등록한 경우<br>
	 &nbsp; &nbsp; 3. 타인의 서비스이용을 방해하거나 그 정보를 도용하는 등의 부정행위를 한 경우<br>
	 &nbsp; &nbsp; 4. 온라인플랫폼을 통해 구입한 항공권대금의 지급을 거부하거나 기타 온라인플랫폼에서 제공한 서비스를 이용하고 이에 대응한 채무를 불이행한 경우&nbsp;<br>
	 &nbsp; &nbsp; 5. 온라인플랫폼을 통해 본 약관이 금지하는 행위를 하거나 법령위반, 기타 공서양속에 반하는 행위를 하는 경우&nbsp;<br>
	 &nbsp; &nbsp; 6. 온라인플랫폼에서 아이디를 발급하신 캐럿라인클럽 회원이 3년 동안 캐럿라인 온라인플랫폼 (PC 및 모바일 앱/웹)에 로그인 한 기록이 없는 경우<br>
	 ③ 캐럿라인은 전항의 사유로 인하여 회원이 자격을 상실하여 회원등록을 말소하여야 할 경우, 회원에게 사전에 그 사실을 통지하여 그 소명을 들을 수 있습니다. 단, 전 제2항 제1호의 경우는 예외로 합니다.<br> ④ 회원이 전②항에 해당하는 사유로 인하여 회원의 자격을 상실하거나 서비스이용을 제한받은 경우, 캐럿라인은 이로 인한 손해에 대해서는 책임을 지지 않습니다.</p> 
	<p>제 10조 [회원에 대한 통지]<br>
	 ① 캐럿라인이 회원에 대한 통지를 하는 경우, 캐럿라인은 회원이 캐럿라인에 제출한 전자우편주소를 통한 통지, 서신발송, 전화 기타 방법을 이용할 수 있습니다.<br> ② 캐럿라인은 불특정 다수 회원에 대하여 통지를 하는 경우에는 온라인플랫폼에 7일 이상 공시함으로써 개별 통지를 갈음할 수 있습니다.</p> 
	<p>제 11조 [정보의 제공]<br> 캐럿라인은 회원에게 서비스 이용 및 각종행사(상업성 광고), 여행정보 등 다양한 서비스를 전자우편이나, 서신, 무선단문 메시지(SMS)발송 등의 방법으로 제공할 수 있습니다. 단, 제공을 원치 않는 회원은 캐럿라인이 제공하는 정보에 대하여 수신 거부할 수 있습니다 </p> 
	<p>제 12조 [항공권 등에 대한 구입]<br>
	 ① 이용자는 온라인플랫폼에서 정한 방식에 따라 항공권 등에 대한 구입을 신청 할 수 있습니다.<br>
	 ② 캐럿라인은 전항의 구입신청에 대하여 다음 각호의 1에 해당할 경우에는 이용자의 구입신청에 대하여 승낙하지 아니합니다.&nbsp;<br>
	 &nbsp; &nbsp; 1. 신청내용에 허위, 기재누락, 오기가 있는 경우<br>
	 &nbsp; &nbsp; 2. 구매신청에 대한 승낙이 현행법령이나 캐럿라인의 규정에 비추어 불가한 경우<br>
	 &nbsp; &nbsp; 3. 타 구매신청에 대한 승낙이 온라인플랫폼의 기술상 현저히 곤란한 경우<br>
	 ③ 이용자의 구입신청에 대한 캐럿라인의 승낙은 수신확인통지가 이용자에게 도달한 때에 이루어진 것으로 봅니다.<br> ④ 전항의 수신확인통지를 받은 이용자는 신청한 내용에 대하여 구매신청을 취소하거나 변경을 요청할 수 있으며, 캐럿라인은 이에 따라 처리합니다.</p> 
	<p>제 13조 [결제방식]<br>
	 온라인플랫폼에서 항공권 등을 구입한 이용자는 캐럿라인이 정한 아래의 방식중 하나를 선택하여 대금을 결제할 수 있습니다.&nbsp;<br>
	 &nbsp; &nbsp; 1. 신용카드결제<br>
	 &nbsp; &nbsp; 2. 실시간 계좌이체<br>
	 &nbsp; &nbsp; 3. 캐럿라인클럽 마일리지 결제<br> &nbsp; &nbsp; 4. 기타 캐럿라인이 정한 결제방식 </p> 
	<p><strong>제3장 정보의 보호</strong></p> 
	<p>제 14조 [개인정보의 보호]<br>
	 ① 캐럿라인은 이용자로부터 정보를 수집할 경우 서비스의 제공 및 계약이행에 필요한 최소한의 정보만을 수집합니다.<br> ② 개인정보보호에 관한 상세한 내용은 캐럿라인클럽 개인정보처리방침 및 온라인플랫폼 개인정보처리방침에 따릅니다.</p> 
	<p><strong>제 4장 책임과 의무</strong></p> 
	<p>제 15조 [캐럿라인의 의무]<br>
	 ① 캐럿라인은 법령과 본 약관이 금지한 행위를 하지 아니하며, 본 약관이 정하는 바에 따라 지속적이고, 안정적인 서비스를 제공하는데 최선을 다하도록 하겠습니다.<br>
	 ② 캐럿라인은 이용자가 안전하게 서비스를 이용할 수 있도록 개인정보 등에 관한 보안을 철저히 하며, 이를 위한 기술적 안전조치를 강구하고, 관리에 만전을 기하겠습니다.<br>
	 ③ 캐럿라인은 온라인플랫폼에 대한 공정하고 건전한 운영을 통하여 전자상거래질서를 유지하고, 지속적인 연구•개발을 통하여 양질의 서비스가 제공되도록 노력하겠습니다.<br>
	 ④ 캐럿라인은 온라인플랫폼을 통해 제공되는 상품이나 서비스에 대하여 [표시광고의 공정화에 관한 법률] 제3조에서 정한 부당한 표시, 광고행위를 하지 않겠습니다.<br> ⑤ 캐럿라인은 온라인플랫폼의 입점 제휴사의 상품 또는 서비스의 판매는 해당 제휴사의 책임하에 직접 이루어지며 캐럿라인은 동 사이트를 통한 중개 역할만을 수행합니다.</p> 
	<p>제 16조 [이용자의 의무]<br>
	 ① 이용자는 관련 법령, 본 약관에서 정한 사항, 기타 캐럿라인이 이용안내 및 주의사항으로서 고지한 내용을 준수하여야 하며, 기타 캐럿라인의 정상적 업무를 방해하는 행위를 하여서는 아니됩니다.<br>
	 ② 이용자는 가입 신청 시 사실에 입각하여 정직하고 성실하게 가입신청서를 작성하여야 하며, 기재한 사항에 대한 변경사유가 발생하는 경우 사실에 맞게 변경해야 합니다. 만일 변경하지 않아 발생하게 되는 모든 문제에 대해서는 이용자가 책임을 부담하게 됩니다.<br>
	 ③ 이용자는 서비스의 이용과정에서 습득한 정보를 캐럿라인의 사전동의 없이 임의로 복사, 복제, 변경해서는 아니되며, 기타 영리목적으로 활용하여서도 아니됩니다.<br>
	 ④ 이용자는 전항의 행위 이외에도 다음의 행위를 하여서는 안됩니다.&nbsp;<br>
	 &nbsp; &nbsp; 1. 캐럿라인이 온라인플랫폼에 게시한 정보의 변경<br>
	 &nbsp; &nbsp; 2. 캐럿라인이 정한 정보 이외의 정보(컴퓨터프로그램 등)의 송신 또는 게시<br>
	 &nbsp; &nbsp; 3. 캐럿라인 기타 제3자의 저작권 등 지적재산권에 대한 침해<br>
	 &nbsp; &nbsp; 4. 캐럿라인 기타 제3자의 이미지, 명예를 손상시키거나 정상적인 업무를 방해하는 행위<br>
	 &nbsp; &nbsp; 5. 음란 또는 폭력적인 메시지•화상•음성 기타 공서양속에 반하는 정보를 온라인플랫폼에 공개 또는 게시하는 행위<br>
	 &nbsp; &nbsp; 6. 이용자가 온라인플랫폼의 게시판 등을 이용하여 상품을 판매하거나 호객을 하는 행위<br>
	 &nbsp; &nbsp; 7. 기타 캐럿라인에서 부적절하다고 판단하는 행위<br> ⑤ 전항 각호의 정보 기타 캐럿라인의 온라인플랫폼 운영상 부적절하다고 판단한 정보가 온라인플랫폼에 게시되거나 링크된 경우 캐럿라인은 이용자 기타 정보게시자의 동의 없이 당해 정보를 삭제하거나 링크를 차단할 수 있습니다.</p> 
	<p>제 17조[온라인플랫폼과 타 웹사이트간의 관계 등]<br>
	 ① 온라인플랫폼과 하위 웹사이트가 하이퍼링크 (예: 하이퍼링크의 대상에는 문자, 그림 및 동화상 등이 해당)방식으로 연결된 경우, 캐럿라인은 피연결 웹사이트가 독자적으로 제공하는 재화나 용역 등에 대하여는 보증책임을 부담하지 아니합니다.<br> ② 캐럿라인은 이용자가 온라인플랫폼의 게시판 등에 게재한 정보나 자료 등에 관하여 신뢰성을 담보하지 아니하며, 그로 인하여 손해가 발생하더라도 책임을 지지 아니합니다.</p> 
	<p><strong>제5장 기타</strong></p> 
	<p>제 18조[저작권의 귀속]<br>
	 ① 캐럿라인이 작성한 저작물에 대한 저작권 기타 지적재산권은 캐럿라인에 귀속합니다.<br> ② 이용자는 온라인플랫폼을 통해 얻은 정보 중 캐럿라인에 지적재산권이 귀속된 정보에 대하여는 캐럿라인의 사전 동의 없이 복제, 송신, 출판, 배포, 방송 기타 방법으로 영리목적에 이용하거나 제3자의 이용에 제공할 수 없습니다.</p> 
	<p>제 19조[분쟁의 해결]<br>
	 ① 캐럿라인은 이용자가 제기하는 정당한 의견이나 불만을 반영하고 피해에 대한 보상처리를 위하여 전담부서인 고객만족팀을 운영합니다.<br> ② 이용자가 캐럿라인이 운영하는 온라인플랫폼의 이용과 관련하여 불만이 있거나 의견을 제시하고자 하는 경우에는 온라인플랫폼의 고객센터나 콜센터를 통해 제기할 수 있습니다.</p> 
	<p>제 20조[관할법원 및 준거법]<br>
	 ① 캐럿라인과 이용자는 서비스이용과 관련하여 발생한 분쟁에 대하여 상호 원만하게 처리될 수 있도록 필요한 모든 노력을 하여야 합니다.<br> ② 전항의 노력에도 불구하고, 소송 등이 제기된 경우 서울중앙지방법원을 전속관할법원으로 하고, 동 소송에는 대한민국법을 적용하도록 합니다.</p> 
	<p>제21조 [약관의 효력]<br> 본 약관은 2000년 6월 1일부터 시행하며, 본 약관이 시행되기 이전에 온라인플랫폼 회원으로 가입한 회원에게도 적용됩니다. 또한 개정된 약관은 적용일자 이전에 체결된 계약에 대해서도 적용됨을 원칙으로 합니다.</p> 
	<p>&nbsp;(부 칙)<br>
	 ☞ 본 약관은 2000년 6월 1일부터 시행<br>
	 ☞ 2001년 11월 21일 개정 : 인터넷 회원 개인정보보호 정책 신설로 개정<br>
	 ☞ 2008년 10월 17일 개정 : 제13조 개인정보보호 항목 변경<br>
	 ☞ 2009년 10월 15일 개정 : <br>
	 &nbsp;&nbsp;[제2조] Asiana I Club 용어 삭제 <br>
	 &nbsp;&nbsp;[제12조] 결제 방식 용어 변경<br>
	 &nbsp;&nbsp;[제13조] 개인정보취급방침과 중복 내용 삭제<br>
	 &nbsp;&nbsp;[제19조] 분쟁의 해결 전담부서 명칭 변경<br>
	 ☞ 2013년 1월 30일 개정 : [제8조] 회원탈퇴와 자격의 상실 ②항의 6번 사항 추가<br>
	 ☞ 2013년 11월 17일 개정: 홈페이지 통합에 따른 개정<br>
	 ☞ 2019년 4월 8일 개정: <br>
	 &nbsp;&nbsp;제 2조 [용어의 정의] ① 온라인플랫폼, ⑥ 온라인플랫폼 회원 용어 변경<br> &nbsp;&nbsp;제 5조 [서비스의 제공] ①항의 3번 여행상품 관련 정보 제공 서비스 삭제 </p> </div></div>
							</li>
							<li class="terms_area">
								<input type="checkbox" name="agree2" id="agree_personalCollection" data-type="ck_item">
								<label for="agree_personalCollection" class="fsz_23"><span class="col_brown2">[필수]</span> 제3자 정보 제공 동의</label> 
								
								<div class="terms_cont" name="terms06" tabindex="0">
								<p><strong>▶ 제3자 개인 정보 수집 및 동의 안내</strong></p>
	<p>[개인정보의 수집 목적 및 이용]<br> 캐럿라인은 서비스 제공 및 마케팅 활동을 위해 회원의 동의를 얻어 개인정보를 수집하고 있습니다.</p>
	<p>&nbsp;</p>
	<p>[개인정보 수집 항목]<br>
	 가. 캐럿라인클럽 회원 가입 시 <br>
	 &nbsp; &nbsp;- 필수항목 : 한글 및 영문 성명 , 성별, 전화번호, 주소, 우편번호, 이메일, 국적, 거주국가, 본인 인증번호, 아이디,비밀번호<br>&nbsp; &nbsp; &nbsp;- 만 14세 미만 회원 가입 시 추가 수집 항목 : 법정대리인의 성명,생년월일</p>
	<p>나. 캐럿라인클럽 가족회원 등록 : 가족관계를 증빙할 수 있는 서류</p>
	<p>&nbsp;</p>[개인정보의 보유 및 이용기간]<br>
	 캐럿라인은 회원이 캐럿라인클럽을 탈퇴하거나 자격을 상실하는 경우 또는 수집목적을 달성하거나 사업을 폐업하는 경우에는 회원DB 삭제, 문서 파기 등의 방법으로 해당 개인정보를 1일내 파기하고 있습니다. 다만, 전자상거래 등에서의 소비자보호에 관한 법률 등 관련 법령의 규정에 의하여 보존하여야 하는 기록은 일정 기간 보관 후 파기합니다. (계약 또는 청약철회 등에 관한 기록: 5년, 대금결제 및 재화 등의 공급에 관한 기록: 5년, 소비자의 불만 또는 분쟁처리에 관한 기록: 3년) 
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>▶ <strong>홈페이지 개인정보 수집 및 이용 안내</strong></p>
	<p>[개인정보의 수집 목적 및 이용]<br>
	 가. 서비스 제공을 위한 계약의 이행<br> 항공권 예약발권, 면세품 사전 주문, 콘텐츠 제공,금융거래 본인인증 및 금융서비스 등</p>
	<p>나. 회원 관리<br> 회원제 서비스 이용, 개인식별, 가입의사 확인, 민원처리 등</p>
	<p>다. 마케팅 및 광고 활용<br> 기타 새로운 서비스, 신상품이나 이벤트 정보 안내, 서비스 이용 통계 등</p>
	<p>&nbsp;</p>
	<p>[개인정보 수집 항목]<br>
	 가. 항공권 예매 시<br>
	 &nbsp; &nbsp; &nbsp;- 탑승자 성명, 회원번호(회원인 경우) , 생년월일(소아, 유아인 경우) , 전화번호, 이메일(선택적)<br>
	 &nbsp; &nbsp; &nbsp;- 신용카드 결제( 카드번호, 거래 인증번호), 계좌이체(거래은행명, 계좌번호)<br> &nbsp; &nbsp; &nbsp;- 여권정보 (여권번호, 만료일, 발급처, 국적)</p>
	<p>나. 고객센터 이용 시 <br> &nbsp; &nbsp; &nbsp;- 성명, 연락처 , 이메일 주소(선택적), 회원번호(선택적), 생년월일(선택적), 탑승정보(선택적)</p>
	<p>다. 면세품 주문 시<br>
	 &nbsp; &nbsp; &nbsp;- 주문자 성명(또는 회원 성명), 탑승자 성명, 회원번호 또는 생년월일, 연락 전화번호, 이메일 주소, 카드번호 및 카드 인증 정보, 포인트 상품 배송 주소<br> ※ 비회원의 경우 기내면세품 전달을 위해 캐럿라인은 성명, 생년월일, 탑승편 정보 등 필요한 최소한의 정보만을 수집합니다.</p>
	<p>라. 이벤트 응모 시<br> &nbsp; &nbsp; &nbsp;- 이벤트 응모 과정에서 회원 가입 시 수집하지 않았던 개인정보를 추가로 수집할 때에는 이용자들에게 고지하고 동의를 받습니다.</p>
	<p>마. 자동으로 생성되는 개인정보 <br> &nbsp; &nbsp; &nbsp;- 서비스 이용기록, 접속 로그, 쿠키, 접속 IP 정보, 결제기록</p>
	<p>&nbsp;</p>
	<p>[개인정보의 보유 및 이용기간]<br> 가. 이용자가 제공한 개인정보는 캐럿라인이 제공하는 서비스를 받는 동안 캐럿라인이 보유ㆍ이용하게 됩니다.</p>
	<p>나. 캐럿라인클럽의 개인정보의 보유 기간 및 파기 절차는 캐럿라인클럽 개인정보취급방침에 따릅니다. </p>
	<p>다. 전자상거래등에서의 소비자보호에 관한 법률 등 관계법령의 규정에 의하여 보존하여야 하는 기록은 일정 기간 보관 후 파기합니다.<br>
	 &nbsp; &nbsp; &nbsp;- 계약 또는 청약철회 등에 관한 기록 (보존기간 : 5년) : 전자상거래 등에서의 소비자 보호에 관한 법률<br>
	 &nbsp; &nbsp; &nbsp;- 대금결제 및 재화 등의 공급에 관한 기록 (보존기간 : 5년) : 전자상거래 등에서의 소비자 보호에 관한 법률<br>
	 &nbsp; &nbsp; &nbsp;- 소비자의 불만 또는 분쟁처리에 관한 기록 (보존기간 : 3년) : 전자상거래 등에서의 소비자 보호에 관한 법률<br>
	 &nbsp; &nbsp; &nbsp;- 홈페이지 방문에 관한 기록 (보존 기간: 3개월) : 통신비밀보호법<br>
	 &nbsp; &nbsp; &nbsp;- 이벤트 참여 기록 (보존 기간 : 1년) : 당사에서 정한 기준<br> &nbsp; &nbsp; &nbsp;- 기타 보유 정보: 정보의 수집 및 이용 목적이 달성된 때</p>
	<p>라. 전항의 규정에도 불구하고, 상법, 전자상거래 등에서의 소비자 보호에 관한 법률 등 관계법령의 규정에 따라 보존의 필요성이 있는 경우 혹은 요금의 정산, 소송 등 법적 분쟁에 대비하기 위하여 개인정보에 대한 계속적인 보유의 필요성이 있어 보유목적, 기간, 보유하는 개인정보 항목을 명시하여 고지한 경우 등은 이용자의 개인정보를 보관할 수 있습니다.</p>
	<p>&nbsp;</p>
	<p>▶ <strong>개인정보 수집 및 이용 동의 거부</strong></p>
	<p>개인정보 수집 및 이용 동의를 거부하실 수 있습니다. 다만, 이 경우 회원가입이 제한됩니다.</p></div>
							</li>
							<li class="terms_area">
								<input type="checkbox" name="agree3" id="agree_personalTransferToAbroad" data-type="ck_item">
								<label for="agree_personalTransferToAbroad" class="fsz_23"><span class="col_brown2">[필수]</span> 개인정보 국외 이전 동의</label> 
								
								<div class="terms_cont" name="terms10" tabindex="0">
								<p>▶ <strong>개인정보 국외 이전 안내</strong></p>
	<p>캐럿라인에서는 항공여행정보시스템 제공 업체인 AMADEUS사에 당사의 예약 및 운송 시스템 운영을 위탁하고 있으며, 예약에 필요한 개인정보 국외 이전 사항은 다음과 같습니다.</p>
	<p>&nbsp;</p>
	<p>가. 개인정보를 이전받는 자<br> &nbsp;- AMADEUS IT GROUP,S.A (dataprotection@amadeus.com)</p>
	<p>&nbsp;</p>
	<p>나. 이전하는 개인정보 항목<br>
	 &nbsp;- 캐럿라인클럽 회원번호, 탑승자 성명, 생년월일, 성별, 연락처, 이메일 <br>
	 &nbsp;- 신용카드 결제시 (카드번호, 유효기간, 거래 인증번호), 계좌이체 결제시(거래번호)<br> &nbsp;- 여권정보 (여권번호, 만료일, 발급처, 국적)</p>
	<p>&nbsp;</p>
	<p>다. 이전되는 국가, 이전 일시, 이전 방법<br> &nbsp;- 독일, 예약완료 시, 공용 네트워크 이용 전송(보안 프로토콜 처리)</p>
	<p>&nbsp;</p>
	<p>라. 이전받는 자의 개인정보 이용 목적 및 보유, 이용기간<br> &nbsp;- 당사 예약시스템 운영 및 예약기록 유지, 개인정보 이전 후 5년 간</p></div>
							</li>
							<li class="terms_area">
								<input type="checkbox" id="agree_personalCollectionOption" name="pO" data-type="ck_item">
								<label for="agree_personalCollectionOption" class="fsz_23"><span class="col_brown2">[선택]</span> 개인정보 수집 및 이용안내</label> 
								
								<div class="terms_cont" name="terms09" tabindex="0">
								<p><span style="font-size: 11pt;">캐럿라인은 이벤트 정보, 할인정보 등 마케팅 정보 제공을 위해 회원의 동의를 얻어 개인정보를 수집하고 있습니다.</span></p>
	<p><span style="font-size: 11pt;">&nbsp;</span></p>
	<p><span style="font-size: 11pt;">1. 개인정보 수집 항목(선택항목)</span><br>
	<span style="font-size: 11pt;"> - 회사명, 근무부서, 직위</span></p>
	<p><span style="font-size: 11pt;">&nbsp;</span></p>
	<p><span style="font-size: 11pt;">2.  개인정보의 보유기간 및 이용기간</span><br>
	<span style="font-size: 11pt;"> - 회원의 동의 하에 수집된 개인정보 항목 선택정보 제공 동의를 유지하고 있는 동안 이용됩니다. 단, 당사는 선택정보 제공 동의를 철회하거나 회원 탈퇴 요청이 있는 경우, 회원 자격을 상실하는 등 캐럿라인클럽 개인정보 처리방침에서 규정하는 개인정보의 수집 및 이용 목적이 달성된 때 수집된 개인정보를 지체 없이 파기하고 있습니다.</span></p>
	<p><span style="font-size: 11pt;">&nbsp;</span></p>
	<p><span style="font-size: 11pt;">3. 선택정보 제공 동의 거부</span><br>
	<span style="font-size: 11pt;"> - 회원은 선택정보 제공에 대한 동의를 거부할 권리가 있으며, 동의를 거부하더라도 회원 가입이 가능합니다.</span></p></div>
							</li>
							<li class="terms_area">
								<input type="checkbox" id="agree_personalProvide" name="pP" data-type="ck_item">
								<label for="agree_personalProvide" class="fsz_23"><span class="col_brown2">[선택]</span> 개인정보 제 3자 제공 동의</label> 
								
								<div class="terms_cont" name="terms07" tabindex="0">
								<p>1. 캐럿라인은 별도의 회원동의 없이 개인정보를 제 3자에게 제공하지 않습니다.(법률에 특별한 규정이 있는 경우 제외) 다만, 회원께서 아래의 제휴서비스 이용 시 다음의 최소한의 개인정보가 제공될 수 있습니다. <a onclick="" href="javascript:showPartnerDetail()">&gt;&gt;제휴사 상세 보기</a></p>
	<p>&nbsp;</p>
	<p>2. 전항의 경우를 제외하고, 회원으로부터 제공받은 개인정보를 수집 목적 이외의 용도로 이용하거나 동의없이 제3자에게 제공함으로 인해 발생하는 피해에 대하여는 캐럿라인에게 책임이 있습니다. 다만, 회원이 고의나 과실로 자신의 개인정보를 유출하거나 허위의 정보를 제공한 경우 또는 개인정보에 변경이 발생하였음에도 이를 알리지 않아 불일치가 발생한 경우에는 그러하지 아니합니다. </p>
	<p>&nbsp;</p>
	<p>3. 선택정보 제공 동의 거부<br> - 개인정보 제3자 제공 동의를 거부하실 수 있습니다. 다만, 이 경우 신용카드사를 통한 잔여 마일리 확인 등 일부 서비스가 제한됩니다.</p></div>
							</li>
							
						</ul>
					</fieldset>
				</form>
				<div class="btn_wrap_ceType1">
					<button type="button" class="btn_L white" id="btn_cancel">취소</button> 
					<button type="button" class="btn_L red" id="btn_agree">동의</button> 
				</div>
			</div>
			
			
			<div class="layer_wrap" id="layer_partnerDetail">
				<div class="dim_layer"></div>
				<div class="layer_pop" style="width: 600px; top: 460px;">
					
					<div class="pop_cont">
						<h4>개인정보의 제휴사 제공</h4> 
						<p class="fsz_16">
							캐럿라인은 법령에 근거가 있는 등의 예외적인 경우를 제외하고는 회원의 동의 없이 개인정보를 제3자에게 제공하지 않습니다.&nbsp;<br> 다만, 요금 정산과 마일리지 적립, 소진 및 항공 탑승 서비스 제공을 위해 아래의 제휴사에게 다음과 같은 개인정보가 제공될 수 있습니다.
						</p>
						<div class="gray_box border3">
							<ol class="list_type2">	
								<li><span class="fo_bol">성명, 회원번호, 회원등급, 잔여마일</span> 
									<ul>
										<li>제공받는자: 신한카드, BC카드, 씨티카드, 현대카드, 외환카드, 전북은행, 광주은행, 롯데카드, 삼성카드, KB국민 카드, 하나SK카드, 농협카드, BOA, UC카드, JCB카드</li> 
										<li>이용 목적: 마일리지 적립, 정산, 회원 잔여마일 제공서비스.</li> 
										<li>제공 기간: 해당 제휴사 서비스 종료시점까지</li> 
									</ul>
								</li>
								<li><span class="fo_bol">성명, 회원번호, 회원ID, 잔여마일</span> 
									<ul>
										<li>제공받는자: 금호리조트, 금호문화재단 ,CGV, 메가박스 ,이마트, 금호타이어</li> 
										<li>이용 목적: 마일리지 사용,정산</li> 
										<li>제공 기간: 해당 제휴사 서비스 종료시점까지</li> 
									</ul>
								</li>
								<li><span class="fo_bol">회원번호, 잔여마일</span> 
									<ul>
										<li>제공받는자: LG U+, 에스텔레콤</li> 
										<li>이용 목적: 마일리지 적립,정산</li> 
										<li>제공 기간: 해당 제휴사 서비스 종료시점까지</li> 
									</ul>
								</li>
								<li><span class="fo_bol">성명, 회원번호</span> 
									<ul>
										<li>제공받는자: KB국민은행, 신한은행, SC제일은행, CJ몰, 이마트몰, GS SHOP,현대 H몰, 신세계몰, 인터파크쇼핑, 롯데i몰, AK몰, 롯데닷컴, NS홈쇼핑, Yes24, 인터파크도서, 인터넷교보문고, 알라딘, 굿데이굿플라워, LF몰패션, 테이블엔조이, 라플라타플라워, 신라면세점, ANA HOUSE, 롯데렌터카, 허츠, rentalcars.com, 옥션, G마켓, 하프클럽, 11번가, 알라모&amp;내셔널,워커힐호텔, 신라호텔, 금호리조트, 호텔엔조이, Hilton, Hyatt , Marriott, IHG, Starwood, Swissotel, Carlson, Langham, WorldHotels, Regal, Best Western, Okura, Regent, ING생명, KDB생명, 금호케이아이, GS&amp;POINT, CJ대한통운(미국법인), 선화플라워, 경기도청, 전라남도청,에스텔레콤, SK플래닛, 익스피디아,아고다, 갤러리아몰, 지니집, 트립어드바이저,마이크로스튜디오,삼성페이</li> 
										<li>이용 목적: 마일리지 적립,정산</li> 
										<li>제공 기간: 해당 제휴사 서비스 종료시점까지</li> 
									</ul>
								</li>
								<li><span class="fo_bol">성명, 회원번호, 회원등급</span> 
									<ul>
										<li>제공받는자: 롯데호텔</li> 
										<li>이용 목적: 마일리지 적립, 정산</li> 
										<li>제공 기간: 해당 제휴사 서비스 종료시점까지</li> 
									</ul>
								</li>
								<li><span class="fo_bol">성명, 캐럿라인클럽회원번호, 회원등급, 마일리지 적립 및 사용내역,잔여 마일,가족마일리지 합산제도 등록정보</span> 
									<ul>
										<li>제공받는 자 : 주식회사 케이티, SK플래닛 주식회사, LG유플러스, (주)비엔에스웍스(SK플래닛 주식회사의 서비스 대행사), 오투웍스 (주식회사 케이티, LG유플러스의 서비스 대행사), 카카오/카카오페이, NHN엔터테인먼트/페이코, 삼성전자/삼성페이, 주식회사 엠콤플러스 (NHN엔터테인먼트/페이코, 삼성전자/삼성페이의 서비스 대행사)</li> 
										<li>이용 목적 : 모바일 멤버십 서비스 제공 및 운영</li> 
										<li>제공 기간: 해당 제휴사 서비스 종료시점까지</li> 
									</ul>
								</li>
								<li><span class="fo_bol">성명,회원번호,회원등급,탑승관련 정보</span> 
									<ul>
										<li>제공받는자:에게안항공, 에어캐나다, 아비앙카/타카항공, 아비앙카 브라질, 에바항공, 에어차이나, 에어아스타나, 에어인디아, 코파항공, 에티오피아항공, 아드리아항공, 루프트한자, 폴란드항공, 스위스국제항공, 이집트항공, 전일공, 에어뉴질랜드, 오스트리아항공, 크로아티아항공, 남아프리카항공, 스칸디나비아항공, 브뤼셀항공, 싱가포르항공, 타이항공, 터키항공, 탑 포르투갈, 유나이티드항공, 심천항공, 카타르항공, 에티하드항공</li> 
										<li>이용 목적: 마일리지 적립 및 마일리지 항공권(좌석승급 포함) 사용, 우수회원 혜택 제공(라운지 및 무료 수하물)</li> 
										<li>제공 기간: 해당 제휴사 서비스 종료시점까지</li> 
									</ul>
								</li>
							</ol>
						</div>
					</div>
					<div class="btn_wrap_ceType2">
						<button type="button" class="btn_M red" id="layer_close">확인</button> 
					</div>
					<a href="javascript:sharpNothig();" class="dim_close"><span class="hidden">닫기</span></a> 
				</div>
				
				
			</div>
		</div>
	<script type="text/javascript">
		$('input[type="checkbox"]').click(function(){
			
			if($('input[type="checkbox"]').index(this) ==0){
	
				if($(this).prop("checked")){
					$('input[type="checkbox"]').each(function(){
						$(this).prop("checked",true);
					});
				}else{
					$('input[type="checkbox"]').each(function(){
						$(this).prop("checked",false);
					});
				}
				
			}else{
	
				if($(this).prop("checked")){
					var count = 0;
					for(var i=1; i < 6; i++){
						if($('input[type="checkbox"]').eq(i).prop("checked")){
							count++;
						}
					}
	
					if(count == 5){
						$('input[type="checkbox"]').eq(0).prop("checked",true);
					}
				}else{
					$('input[type="checkbox"]').eq(0).prop("checked",false);
				}
			}
		});
	
		$("#btn_agree").click(function(){
			
			if($('input[type="checkbox"]').eq(1).prop("checked") && $('input[type="checkbox"]').eq(2).prop("checked") && $('input[type="checkbox"]').eq(3).prop("checked")
					&& $('input[type="checkbox"]').eq(4).prop("checked")&& $('input[type="checkbox"]').eq(5).prop("checked")){
				$("#form_terms").submit();
			}else{
				alert('모든 필수사항을 확인 후 동의하십시오');
			}
			
		});
	</script>




</body>
</html>