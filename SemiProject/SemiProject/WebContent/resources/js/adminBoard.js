

<!-- 게시글을 tbody에 넣는 메소드 -->
function tbodyInsert(list){
    let tableEl = "";
    if(list!=null&&list.length!=0){
        for (var i = 0; i < list.length; i++) {
            tableEl += "<tr>";
            tableEl += "<td id='boardCheck'><input type='checkbox' value='"+list[i]['boardNo']+"' name='bno' id='bno' style='width:25px;height:25px'></td>";
            tableEl += "<td>"+list[i]['rowNum']+"</td>";
            tableEl += "<td>"+list[i]['boardCode']+"</td>";
            tableEl += "<td style='width:240px;display:inline-block;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;'>"+list[i]['boardTitle']+"</td>";
            tableEl += "<td>"+list[i]['boardWriter']+"</td>";
            tableEl += "<td>"+list[i]['Views']+"</td>";
            tableEl += "<td>"+list[i]['Likes']+"</td>";
            tableEl += "<td>"+list[i]['createdDateStr']+"</td> ";
            tableEl += "</tr>";
        }
    }else{
        tableEl += "<tr><td colspan='8' style='pointer-events: none;'>The thread does not exist</td></tr>"

    }
    $("#list-area>tbody").html(tableEl);
    $("#list-area>tbody>tr>td").css("padding-top","20px");
    $("#list-area>tbody>tr>td").css("height","70px");
    
    $("#list-area>tbody>tr").each(function() {
		let num = $(this).children().eq(6).text();
		if (num>999999) {
			$(this).children().eq(6).attr("title",num);
			$(this).children().eq(6).text("99999+");
		}
		
		num = $(this).children().eq(7).text();
		if (num>999999) {
			$(this).children().eq(7).attr("title",num);
			$(this).children().eq(7).text("99999+");
		}
	})
    boardSelect();
}

<!-- 게시글 조회 매서드 -->   
function boardSelect(){
    $("#list-area>tbody>tr").on('click',function(e){
        if (!$(e.target).is('#boardCheck')&&!$(e.target).is('#boardCheck>input[type=checkbox]')) {
            let bno = $(this).children().eq(0).children().val();
            let bt = $(this).children().eq(2).text();
            location.href = "<%= request.getContextPath() %>/adminBoardDetail.bo?bno="+bno+"&bt="+bt;
        }else{
            const checkEl = $(this).children().eq(0).children();
            if($(checkEl).is(':checked')){
                $(checkEl).attr("checked",false);
            }else{
                $(checkEl).attr("checked",true);
            }

        }
    });
}

<!-- 게시글 삭제 메서드 -->
function boardDelete(){
    let index = 0;
    let bno = [];
    let bt = [];
    $("#list-area>tbody>tr").each(function(e){
        const checkEl = $(this).children().eq(0).children();
        if($(checkEl).is(':checked')){
            bno[index] = $(this).children().eq(0).children().val();
            bt[index] = $(this).children().eq(2).text();
            index++;
        }
    })
    if(bno.length > 0){
       $(location).attr("href","<%= request.getContextPath() %>/adminBoardListDelete.bo?bno="+bno+"&bt="+bt);
    }else{
        alert("There are no selected posts");
    }
}
<!-- 페이징 생성 메소드 -->
function paging(url,search,bt,pageInfo){
    
    let btnEl = "<button class='btn btn-light' ";
    if(pageInfo['startPage']==1){
        btnEl += "disabled";
    }
    btnEl += ">&lt;</button>";

    for (let index = pageInfo['startPage']; index < pageInfo['endPage']+1; index++) {
        btnEl += "<button ";
        if(pageInfo['currentPage']==index){
            btnEl += "class='btn btn-link' style='text-decoration-line : none;'";
        }else{
            btnEl += "class='btn btn-light'";
        }
        btnEl += ">"+index+"</button>";
    }

    btnEl += "<button class='btn btn-light' ";
    
    if (pageInfo['endPage']==pageInfo['maxPage']) {
        btnEl += "disabled";
    }
    btnEl += ">&gt;</button>";

    $("#page-area").html(btnEl);
    btnHerf(url,search,bt,pageInfo);
}
<!-- 페이지 이동 처리 메소드 -->
function btnHerf(url,search,bt,pageInfo){
    $("#page-area>button").on('click',function(){
        let regExp = /^[0-9]*$/;
        
        let cPage = 1;
        if(regExp.test($(this).text())){
            cPage = $(this).text();
        }else if($(this).text()=='<'){
            cPage = pageInfo['startPage']-1;
        }else{
            cPage = pageInfo['endPage']+1;
        }
        if(search!=null){
        	BoardSearchList(cPage);
        }else{
            BoardList(cPage);
        }
    })
}
<!-- 타이틀 이름 바꾸는 기능 -->  
function changeTitle(bt){ 
    if(bt!=null){
        $("#boardCode>option").each(function(){
            if(bt==$(this).val()){
                $(this).attr("selected",true);
                $("h1").eq(0).text($(this).text())
            }
        });
    }
    if(bt=="B1"){
		$("#infoInsertBtn").css("display","inline");
    }else if(bt=="B3") {
		$("#todayInsertBtn").css("display","inline");
	}else{
		$("#todayInsertBtn").css("display","none");
		$("#infoInsertBtn").css("display","none");
	}
}
<!-- 게시글 리스트 출력 메소드 -->
function BoardList(cPage) {
    $.ajax({
        url:"adminBoardSearch.bo",
        target:"get",
        data:{bt:"<%= bt %>",
        cPage:cPage},
        success:function(jMap){
            let url = "/adminBoardList.bo";
            <!-- tbody에 테이블 추가 이벤트 -->
            tbodyInsert(jMap['list']);
            <!-- 페이징 처리 이벤트 -->   
            paging(url,null,"<%= bt %>",jMap['pageInfo']);
            changeTitle("<%= bt %>");
        },
        error:function(){
            alert("The thread does not exist");
        }
    });
}
<!-- 검색한 게시글의 리스트 출력 메소드 -->
function BoardSearchList(cPage) {
    $.ajax({
        url:"adminBoardSearch.bo",
        target:"get",
        data:{search:$("#boardName").val(),
        bt:$("#boardCode").val(),
        cPage:cPage},
        success:function(jMap){
            let url = "/adminBoardSearch.bo";  
            <!-- tbody에 테이블 추가 이벤트 -->
            tbodyInsert(jMap['list']);
            <!-- 페이징 처리 이벤트 --> 
            paging(url,$("#boardName").val(),$("#boardCode").val(),jMap['pageInfo']);
        },
        error:function(){
            alert("The thread does not exist");
        }
    });
}

$(function(){
    let cPage = 1;
    BoardList(cPage);
    <!-- 게시글 리스트 조회 이벤트 -->         
    $("#searchBtn").on('click',function(){
        let cPage = 1;
        changeTitle($("#boardCode").val());
        BoardSearchList(cPage);
    });
})