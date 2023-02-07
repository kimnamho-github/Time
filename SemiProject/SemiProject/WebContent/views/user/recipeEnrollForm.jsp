<%@page import="com.user.board.recipe.model.vo.DoseUnit"%>
<%@page import="com.user.board.recipe.model.vo.Ingrd"%>
<%@page import="com.common.model.vo.Attachment"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Ingrd> ingrdList = (ArrayList<Ingrd>)request.getAttribute("ingrdList");
	ArrayList<DoseUnit> doseUnitList = (ArrayList<DoseUnit>)request.getAttribute("doseUnitList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/recipeinsert1.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/recipeinsert2.css">

<style>
	#ingrdPlusBtn,#ingrdDeleteBtn{
		border: none; 
		border-radius: 4px; 
		text-align: center; 
		padding: 5px 25px; 
		font-size: 12px;
		margin: 10px 20px;
	}
	
	select{
    	width: 150px;
	}
	
</style>

</head>
<body>
	<%@include file="/views/common/menubar.jsp"%>

	<form action="<%=contextPath%>/insert.re" method="post" enctype="multipart/form-data">
	<input type="hidden" name="boardWriter" value="<%=loginUser.getMemberNo() %>">
		<div class="outer">
	        <div id="r1">
	            <h2 id="re">레시피 등록</h2>
	        </div>
	        <div id="r2">
	            <div id="r21">
	                <div id="r21-1"><span>레시피 제목*</span><input type="text" name="boardTitle" id="input1" size="49"><br></div>
	                <div id="r21-2"><span>레시피 소개*</span></div>
	                <textarea name="boardContent" id="input2" cols="50" rows="7" style="resize: none;"></textarea><br>
	            </div>	
	            <div id="r22" style="text-align: center;">
	                <img src="<%=contextPath %>/resources/image/common/레시피 대표사진 등록.jpg" id="titleImg" width="225" height="225">
   	                <input type="hidden" name="refCno1" value="0">
	            </div>
				<input type="file" id="file1" class="file-area" name="titleImg" onchange="loadImg(this,1);" required> <!--대표이미지라서 필수-->
	        </div>
	        
	        <div id="r3">
	        	<!-- 나중에 다 만들고 시간 남으면 데이터베이스 테이블 생성하고 진행하기  -->
	            <div id="r31" class="inline"><span>카테고리*</span></div>
	            <div class="dropdown2">
	                <div id="ca" class="inline">종류별 </div>
	                <div id="caa" class="inline">
	                    <select class="" name="" id="" style="text-align: center;">
	                        <option value="">전체</option>
	                        <option value="">한식</option>
	                        <option value="">양식</option>
	                        <option value="">간식</option>
	                        <option value="">기타</option>
	                    </select>
	                </div>
	            </div>
	            <div class="dropdown2">
	                <div id="ca" class="inline">상황별 </div>
	                <div id="caa" class="inline">
	                    <select name="" id="" style="text-align: center;">
	                        <option value="">일상</option>
	                        <option value="">간편요리</option>
	                        <option value="">손님초대</option>
	                        <option value="">도시락</option>
	                        <option value="">이유식</option>
	                        <option value="">기타</option>
	                    </select>
	                </div>
	            </div>
	            <div class="dropdown2">
	                <div id="ca" class="inline">재료별 </div>
	                <div id="caa" class="inline">
	                    <select name="" id="" style="text-align: center;">
	                        <option value="">육류</option>
	                        <option value="">채소류</option>
	                        <option value="">해물류</option>
	                        <option value="">달걀/유제품</option>
	                        <option value="">버섯류</option>
	                        <option value="">콩/견과류</option>
	                        <option value="">곡류</option>
	                        <option value="">기타</option>
	                    </select>
	                </div>
	
	            </div>
	            <div><img src="<%=contextPath %>/resources/image/common/체크크.png" id="ck"></div>
	            <div id="ckk">분류를 바르게 설정해주시면 이용자들이 쉽게 레시피를 검색할 수 있어요.</div>
	
	
	
	            <div id="r3-1">
	           		<!-- 나중에 다 만들고 시간 남으면 데이터베이스 테이블 생성하고 진행하기  -->
	                <div id="r31" class="inline"><span>요리정보*</span></div>
	                <div class="dropdown2">
	                    <div id="ca" class="inline">인원</div>
	                    <div id="caa" class="inline">
	                        <select name="" id="" style="text-align: center;">
	                            <option value="">1인분</option>
	                            <option value="">2인분</option>
	                            <option value="">3인분</option>
	                            <option value="">4인분</option> 
	                            <option value="">5인분</option>
	                            <option value="">6인분 이상</option>
	                        </select>
	                    </div>
	                </div>
	                <div class="dropdown2">
	                    <div id="ca" class="inline">시간 </div>
	                    <div id="caa" class="inline">
	                        <select name="" id="" style="text-align: center;">
	                            <option value="">5분</option>
	                            <option value="">15분</option>
	                            <option value="">25분</option>
	                            <option value="">35분</option> 
	                            <option value="">45분</option>
	                            <option value="">45분</option>
	                            <option value="">1시간</option>
	                            <option value="">1시간이상</option>
	                        </select>
	                    </div>
	                </div>
	                <div class="dropdown2">
	                    <div id="ca" class="inline">난이도 </div>
	                    <div id="caa" class="inline">
	                        <select name="" id="" style="text-align: center;">
	                            <option value="">상</option>
	                            <option value="">중상</option>
	                            <option value="">중</option>
	                            <option value="">중하</option>
	                            <option value="">하</option>
	                        </select>
	                    </div>
	    
	                </div>
	
	        </div>
	        
	        <div id="r4">
	            <div id="r41" class="inline"><span>재료*</span></div>
				<div class="dropdown2">
	                <div id="ca" class="inline">재료</div>
	                <div id="caa" class="inline">
	                    <select class="" id="ingrd" style="text-align: center;">
	                    	<%for(Ingrd i : ingrdList){ %>
								<option value="<%=i.getIngrdCode()%>"><%=i.getIngrdName() %></option>
							<%} %>
	                    </select>
	                </div>
	            </div>
	            <div class="dropdown2">
	                <div id="ca" class="inline">정량</div>
	                <div id="caa" class="inline">
	                    <input id="dose" class="inline" type="text" style="width: 150px">
	                </div>
	            </div>
	            <div class="dropdown2">
	                <div id="ca" class="inline">정량단위</div>
	                <div id="caa" class="inline">
	                    <select class="" id="doseCode" style="text-align: center;">
	                        <%for(DoseUnit d : doseUnitList){ %>
								<option value="<%=d.getDoseCode()%>"><%=d.getDoseName() %></option>
							<%} %>
	                    </select>
	                </div>
	            </div>
	            	<br>
	            <div class="dropdown2" style="margin-left: 350px;">
	                <button type="button" class="inline" id="ingrdPlusBtn" onclick="ingrdPlus();">재료 추가</button>
	                <button type="button" class="inline" id="ingrdDeleteBtn" onclick="ingrdDelete();">재료 삭제</button>
	                
	            </div>

	            <div><img src="<%=contextPath %>/resources/image/common/체크크.png" id="ck2"></div>
		        <div id="ckk2">재료가 남거나 부족하지 않도록 정확한 계량정보를 적어주세요.</div>
	            
	            <div id="ingrdInsert" style="margin-top: 10px;">
	            	<!-- 버튼 클릭시 재료 추가 -->
            		

	        	</div>
	        	
	            <script>
	            	
		            let ingrdCount = 1;
		            	
		            function ingrdPlus() {
		            	
		                let ingrd = $("#ingrd option:selected").text();
		                let doseCode = $("#doseCode option:selected").text();
		        		
		                let ingrdval = $("#ingrd option:selected").val();
		                let dose = $("#dose").val();
		                let doseCodeval = $("#doseCode option:selected").val();
		                
		                // 재료 추가 최대 20개로 제한
		                if(ingrdCount <= 20){
		                	$("#ingrdInsert").append(
		                			"<input type=\"checkbox\" name=\"ingrdChk\" id=\"ingrdChk\" value=\"" + ingrd + dose + doseCode + "\">" 
				                	+ "<input type=\"hidden\" name=\"ingrdCode" + ingrdCount + "\" value=\"" + ingrdval + "\">"
				                	+ "<input type=\"hidden\" name=\"dose" + ingrdCount + "\" value=\"" + dose + "\">"
				                	+ "<input type=\"hidden\" name=\"doseCode" + ingrdCount + "\" value=\"" + doseCodeval + "\">"
				                	+ "<label for=\"ingrdChk\">" + "&nbsp;&nbsp;재료 : " +  ingrd + dose + doseCode + "</label><br>"
				                );
			                ingrdCount++;
			                
		                }else{
		                	alert("재료 추가는 최대 20개입니다.");
		                }
		            }
		            
		            function ingrdDelete() {
		            	
		            	if($("input:checkbox[name=ingrdChk]:checked")){ // 체크 되어있을때만 삭제 가능
			            	$("input:checkbox[name='ingrdChk']:checked").each(function() {
			            		$(this).next().next().next().next().next().remove();
			            		$(this).next().next().next().next().remove();
			            		$(this).next().next().next().remove();
			            		$(this).next().next().remove();
			            		$(this).next().remove();
			            		$(this).remove();
			            		ingrdCount--
			            	});
		            	}
		            }
		            
	            </script>
	            
	        </div>
	        <br>
	        
			<div id="insertContent">
                <div id="r51"> <span>요리순서*</span></div><br>
                <div id="r51-1" class="order1" style="display: inline; float: left"><span>Step1</span></div>
                <input type="hidden" name="orderNo1" value="1">
		        <div id="r5" class="orderContent1">
	                <div class="inline" id="r51-2">
	                    <textarea name="recipeContent1" id="step1" cols="66" rows="10" style="resize: none;"
	                        placeholder="예) 소고기는 기름기를 떼어내고 적당한 크기로 썰어주세요."></textarea><br>
	                </div>
	                <div class="inline" id="r51-3"> 
	                <input type="hidden" name="refCno2" value="1">
	                <img src="<%=contextPath %>/resources/image/common/레시피 대표사진 등록.jpg" id="recipImg1" width="225" height="225">
	                </div>
	                <input type="file" id="file2" class="file-area" name="recipImg1" onchange="loadImg(this,2);" required> <!--대표이미지라서 필수-->
		    	</div>
	    	</div>
            
            <div align="center">
                <button type="button" class="createDelete" id="copy" onclick="createContent();">순서 추가하기</button>
                <button type="button" class="createDelete" id="delete" onclick="deleteContent();">순서 삭제하기</button>
                
            </div>
            
			<script>
				$(function(){
					$(".file-area").hide();
					
					$("#titleImg").on('click',function(){
						$("#file1").click();
					});
					
					
					$("#recipImg1").on('click',function(){
						$("#file2").click();
					});
					
				});
				
				let count = 2;
				
				function createContent() { 
					// 조리내용 최대 10개로 제한
					if(count <= 10){
						$("#insertContent").append(
								  "<div id=\"r51-1\" class=\"order" + count + "\" style=\"display: inline; float: left\"><span>Step" + count + "</span></div>"
								+ "<input type=\"hidden\" name=\"orderNo" + count + "\" value=\"" + count + "\">"
								+ "<div id=\"r5\" class=\"orderContent" + count + "\">"
								+ "<div class=\"inline\" id=\"r51-2\">"
								+ "<textarea name=\"recipeContent" + count + "\" id=\"step" + count + "\" cols=\"66\" rows=\"10\" style=\"resize: none;\""
								+ "placeholder=\"예) 소고기는 기름기를 떼어내고 적당한 크기로 썰어주세요.\"></textarea><br>"
								+ "</div>"
								+ "<div class=\"inline\" id=\"r51-3\">"
								+ "<input type=\"hidden\" name=\"refCno" + (count+1) + "\"value=\"" + count + "\">"
								+ "<img src=\"" + "http://localhost:8888/SemiProject/resources/image/common/레시피 대표사진 등록.jpg\"" + "id=\"recipImg" + count + "\"width=\"225\" height=\"225\">"
								+ "</div>"
								+ "<input type=\"file\" id=\"file" + (count+1) + "\" class=\"file-area\" name=\"recipImg" + count + "\" onchange=\"loadImg(this," + (count+1) + ");\">"
								+ "</div>"
						);
						count++;
						
					}else{
						alert("조리내용은 최대 10개입니다.");
					}
					
				$(function(){
					// 이미지 클릭시 파일첨부 2번 나오는거 해결하기
					$(".file-area").hide();
					
					for(let i = 2; i < count; i++){
						$("#recipImg" + i).on('click',function(){
							$("#file" + (i+1)).click();
						});
					}
				});
				
			}
				
				function deleteContent() {
					
					if(count > 2){
						let count1 = count;
						count1 = count1-1;
		                // step 삭제
		                $(".order"+count1).remove();
		                // content 삭제
		                $(".orderContent"+count1).remove();
		                $("#titleImg"+count1).remove();
			                
						for(let i = 2; i < count1; i++){
							$("#recipImg" + i).off('click',function(){
								$("#file" + (i+1)).click();
							});
							
						}
		                count--;
					}
					
				}
				
				function loadImg(inputFile,num){
							// inputFile : 현재 변화가 생긴 input type="file" 요소 객체
							// num : 몇번째 input 요소인지 확인 후 해당 영역에 미리보기를 위한 매개변수  
			
							//files속성은 업로드된 파일의 정보를 배열의 형태로 묶어서 반환하는 속성
							//파일 선택시 length가 1을 반환 취소하면 0을 반환한다.
							console.log(inputFile.files);
							
							if(inputFile.files.length == 1){
								//선택된 파일이 존재하면
								//선택된 파일을 읽어서 해당 영역에 미리보기 띄워주기
			
								//파일을 읽어주기 위한 객체 FileReader 
								let reader = new FileReader();
			
								//파일을 읽어들이는 메소드 -어떤 파일을 읽을것인지 매개변수로 제시
								//readAsDataUrl(파일);
								//파일을 읽어들이는 순간 해당 파일만의 고유 url을 부여한다. 
								//부여된 url을 src 속성에 추가하면 된다.
								reader.readAsDataURL(inputFile.files[0]);
			
								//파일 읽기가 완료된 시점에 src에 url을 부여하는 함수 만들기
								reader.onload = function(e){
									//e는 이벤트 객체 
									//부여된 url은 e객체의 target에 result에 들어있음 
									//각 영역에 맞춰서 이미지 미리보기 
									switch(num){
										case 1 : $("#titleImg").attr("src",e.target.result); break;
										case 2 : $("#recipImg1").attr("src",e.target.result); break;
										case 3 : $("#recipImg2").attr("src",e.target.result); break;
										case 4 : $("#recipImg3").attr("src",e.target.result); break;
										case 5 : $("#recipImg4").attr("src",e.target.result); break;
										case 6 : $("#recipImg5").attr("src",e.target.result); break;
										case 7 : $("#recipImg6").attr("src",e.target.result); break;
										case 8 : $("#recipImg7").attr("src",e.target.result); break;
										case 9 : $("#recipImg8").attr("src",e.target.result); break;
										case 10 : $("#recipImg9").attr("src",e.target.result); break;
										case 11 : $("#recipImg10").attr("src",e.target.result); break;
										
									}
								}
							}else{
								switch(num){
									case 1 : $("#titleImg").attr("src",e.target.result); break;
									case 2 : $("#recipImg1").attr("src",e.target.result); break;
									case 3 : $("#recipImg2").attr("src",e.target.result); break;
									case 4 : $("#recipImg3").attr("src",e.target.result); break;
									case 5 : $("#recipImg4").attr("src",e.target.result); break;
									case 6 : $("#recipImg5").attr("src",e.target.result); break;
									case 7 : $("#recipImg6").attr("src",e.target.result); break;
									case 8 : $("#recipImg7").attr("src",e.target.result); break;
									case 9 : $("#recipImg8").attr("src",e.target.result); break;
									case 10 : $("#recipImg9").attr("src",e.target.result); break;
									case 11 : $("#recipImg10").attr("src",e.target.result); break;
									
								}
							}
						}
			
	    	</script>
			
            <div id="r6">
                <div class="rbtng" align="center">
                    <button class="rbtn" id="cancel"
						onclick="location.href='<%=contextPath%>/list.re?currentPage=1'">
                    	취소
                    </button>
                    <button class="rbtn" id="save" onclick="textArea();">등록</button>
                </div>
            </div>
            
            
            <script>
            
            function textArea() {
				let txt = document.getElementById("input2").value;
				txt = txt.replace(/(\n|\r\n)/g,'<br/>');
				document.getElementById("input2").value = txt;

				for(let i = 1; i <= count ; i++){
					console.log(count);
					let txt2 = document.getElementById("step" + i).value;
					txt2 = txt2.replace(/(\n|\r\n)/g,'<br/>');
					document.getElementById("step" + i).value = txt2;
				}
			}
            
            
            </script>
		</div>
			
			
			<%@include file="/views/common/footer.jsp"%>
			
    	</div>
	</form>

</body>
</html>