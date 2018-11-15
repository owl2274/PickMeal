<%@page import="com.itwill.dao.AreaDAO"%>
<%@page import="com.itwill.dto.FoodType"%>
<%@page import="com.itwill.dao.FoodTypeDAO"%>
<%@page import="com.itwill.interfaceDAO.FoodTypeDAOI"%>

<%@page import="java.util.Arrays"%>

<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>

<%
/* 	FoodTypeDAOI foodTypeDAO = new FoodTypeDAO();
	AreaDAO areaDAO = new AreaDAO();

	List<FoodType> foodTypes = foodTypeDAO.getFoodTypeAll();
	pageContext.setAttribute("foodTypes", foodTypes);
	
	List<String> cities = areaDAO.getCityList();
	pageContext.setAttribute("cities", cities); */
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style type="text/css">
.navbar-nav li.imgList.open .dropdown-menu{
    top: 100%;
    min-width: 0px;
    width: auto;
    padding: 0px 0;
    margin-top: -15px;
	overflow-y: visible;
	max-height:1000px;
}
.navbar-default a.navbar-brand{
	font-size: 36px;
	line-height:40px;
	color: #2196f3;
}
	div.navbar-ex1-collapse{
		float:right;
	}
/* 	ul.navbar-right{
		float:right;
	} */
#menuBar{
	height:97px;
}
.none{
	display: none;
}
</style>

    <header id="pageTop" class="header">

      <!-- TOP INFO BAR -->

      <div class="nav-wrapper navbarWhite">
        <!-- NAVBAR -->
        <nav id="menuBar" class="navbar navbar-default lightHeader animated " role="navigation">
          <div class="container">

            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="${pageContext.request.contextPath}/ ">
              <div>
                PickMeal
			  </div>
              </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
            	<form action="${pageContext.request.contextPath}/search" method="post">
                <ul class="nav navbar-nav navbar-left">
                    <li class="dropdown singleDrop">
                      <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">지역<i class="fa fa-angle-down" aria-hidden="true"></i></a>
                    <ul id="area1Ul" class="dropdown-menu dropdown-menu-left">
 <%--                    <C:forEach var="city" items="${cities}">
							<li><div class="area1Div">${city}</div></li>
					</C:forEach> --%>
                    </ul>
                  </li>
                    <li class="dropdown singleDrop">
                      <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">지역2<i class="fa fa-angle-down" aria-hidden="true"></i></a>
                    <ul id="area2Ul" class="dropdown-menu dropdown-menu-left">
<!-- 							<li>서울 강남<input type="checkbox"></li>
							<li>서울 강북<input type="checkbox"></li>
							<li>부산<input type="checkbox"></li>
							<li>제주<input type="checkbox"></li> -->
                    </ul>
                  </li>

                  <li class=" dropdown singleDrop">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">음식 종류<i class="fa fa-angle-down" aria-hidden="true"></i></a>
                    <ul id="foodTypeUl" class="dropdown-menu dropdown-menu-left">
<%--  					<%for(FoodTypeDTO ft: foodTypes ){%>
					<li><%=ft.getFtType() %><input type="checkbox" value="<%=ft.getFtNo()%>"></li> 
					<%} %>   --%>                 
<%--                     <C:forEach var="ftype" items="${foodTypes}">
						<li>${ftype.ftType}<input type="checkbox" value="${ftype.ftNo}" name="foodTypeList"></li> 
					</C:forEach>  --%> 
                    </ul>
                  </li>
                <li class="inputList">
				
              <input id="inputKeyword" type="text" class="form-control" placeholder="Search" name="keyword">
            	
				</li>
								<li class="buttonList">
	          <div class="form-group">
	            <button type="submit" class="btn btn-primary">Search </button>
	          </div>				</li>
	                          <li class="aList">
	                          
	                          <ul>
	                          <C:choose>
	                          <C:when test="${empty(loginMember) }">
	                            <li><a data-toggle="modal" href="#loginBox">로그인</a></li>
	                	    	<li><a data-toggle="modal" href="#joinRoot">회원가입</a></li>
	                          </C:when>
	                          <C:when test="${loginMember.status==2 }">
	                            <li><a  href="${pageContext.request.contextPath}/logout">로그아웃</a></li>
	                			<li><a  href="${pageContext.request.contextPath}/mypage">마이페이지</a></li>
	                			<li><a  href="${pageContext.request.contextPath }/selectRstList/${loginMember.id}">상점관리자</a></li>
	                          </C:when>
	                          <C:when test="${loginMember.status==9 }">
	                            <li><a  href="${pageContext.request.contextPath}/logout">로그아웃</a></li>
	                			<li><a  href="${pageContext.request.contextPath }/admin/memberListA">시스템관리자</a></li>
	                          </C:when>
	                          <C:otherwise>
	                          <li><a  href="${pageContext.request.contextPath}/logout">로그아웃</a></li>
	                			<li><a  href="${pageContext.request.contextPath}/mypage">마이페이지</a></li><li>
	                          </C:otherwise>
	                          </C:choose>
	                          </ul>
	      
	               
                </li>
                
<!--                 <li class="dropdown singleDrop imgList open">
                      <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
						<img class="border_radius circle" alt="" src="http://c1.poing.co.kr/original/images/common/default_profile_162.png">
						<i class="fa fa-angle-down" aria-hidden="true"></i></a>
                    <ul class="dropdown-menu dropdown-menu-left">
							<li class="first"><div class="area1Div">서울 강남</div></li>
							<li><div class="area1Div">서울 강북</div></li>
							<li><div class="area1Div">부산</div></li>
							<li><div class="area1Div">제주</div></li>
							<li><div class="area1Div">서울 강북</div></li>
							<li><div class="area1Div">부산</div></li>
							<li><div class="area1Div">제주</div></li>
                    </ul>
                  </li> -->
                
                
<!--                 <li class="imgList">
                	<div class="i_wrap">
						<img class="border_radius circle" alt="" src="http://c1.poing.co.kr/original/images/common/default_profile_162.png">				
					</div> 
                </li> -->
                </ul>

           		</form>
            </div>
         
           <script src="${pageContext.request.contextPath}/js/debugTool.js"></script>
            
          <script type="text/javascript">
 		$(".dropdown-toggle").click(function() {

			$(this).parent().find(".dropdownDiv").toggleClass("open");
		}) 
		
		var callArea = function(area1) {
			$.ajax({
		        url:"${pageContext.request.contextPath}/dong",
		        type:'GET',
		        data:{"area1":area1},
		        dataType: 'json',
		        success:function(data){
	        		$("#area2Ul").children().remove();
		        	data.forEach(function(elt, i, array) {
		        		$("<li>"+elt.dong+"<input type='checkbox' value='"+elt.areaNo+"' name='areaList'></li>").appendTo("#area2Ul");
		        	})
		        },
		        
		        error:function(jqXHR, textStatus, errorThrown){
		            alert("에러 발생~~ \n" + textStatus + " : " + errorThrown);
		        }
		    });
		}

		
		$.ajax({
	        url:"${pageContext.request.contextPath}/foodType",
	        type:'GET',
	        dataType: 'json',
	        success:function(json){
        		$("#foodTypeUl").children().remove();
        		json.forEach(function(elt, i) {
        			$("<li>"+elt.ftType+"<input type='checkbox' value='"+elt.ftNo+"' name='foodTypeList'></li>").appendTo("#foodTypeUl");
        		})

	        },
	        
	        error:function(jqXHR, textStatus, errorThrown){
	            alert("에러 발생~~ \n" + textStatus + " : " + errorThrown);
	        }
	    });
		$.ajax({
	        url:"${pageContext.request.contextPath}/city",
	        type:'GET',
	        dataType: 'json',
	        success:function(json){
        		$("#area1Ul").children().remove();
        		json.forEach(function(elt, i) {
        			$("<li><div class='area1Div'>"+elt+"</div></li>").appendTo("#area1Ul");
        		})
        		
        		$(".area1Div").click(function(){
        			callArea($(this).text());
        		});
        		
        		callArea($('#area1Ul > li>div').first().text());

	        },
	        
	        error:function(jqXHR, textStatus, errorThrown){
	            alert("에러 발생~~ \n" + textStatus + " : " + errorThrown);
	        }
	    });
		
		
		
		
		


	</script>
          
          
          
         
        </nav>
      </div>
      
     
			  
			  
			  
			  
			  <!-- LOGIN  MODAL -->
  <div id="loginBox" tabindex="-1" class="modal fade" role="dialog">
    <div class="modal-dialog">

      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">로그인</h4>
        </div>
        <div class="modal-body">
          <form class="loginForm" action="${pageContext.request.contextPath}/login" method="post" id="loginModal">
            <div class="form-group">
              <i class="fa fa-envelope" aria-hidden="true"></i>
              <input type="text" class="form-control" id="idM" name="id" placeholder="아이디">
              <p class="idMSG none">아이디를 입력해주세요</p>
            </div>
            <div class="form-group">
              <i class="fa fa-lock" aria-hidden="true"></i>
              <input type="password" class="form-control" id="passwordM" name="password" placeholder="비밀번호">
           	  <p class="passwordMSG none">비밀번호를 입력해주세요</p>
            </div>
            <div class="form-group">
              <button type="submit" class="btn btn-primary btn-block">로그인</button>
              
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <div class="pull-right">
				<a href="findId" class="">아이디 찾기</a>/
				<a href="findPassword" class="">비밀번호 찾기</a>
				<p>아직 회원이 아니신가요? <a data-toggle="modal" href="#joinRoot" data-dismiss="modal" class="link">회원가입</a></p>
			</div>
          
        </div>
      </div>
    </div>
  </div>
			  
			  
			  
			  
      
      
      <!-- modal 회원가입************************************************************************************************** -->
     <div class="modal fade" id="joinRoot" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title" id="myModalLabel" style="color: #2196f3;">회원가입</h4> </div>
                <div class="modal-body">
                    <div class="servicesItem">
					<ul class="list-inline listServices">
						<li>
							<div class="servicesIcon">
								<a href="signUp?status=1"><i class="icon-listy icon-user"></i></a>
							</div>
							<div class="servicesInfo">
								<h2>회원가입</h2>
								<p>Pick Meal에서 <br>음식점 정보를 <br>확인하세요! </p>
							</div>
						</li>
						<li>
							<div class="servicesIcon">
								<a href="signUp?status=2"><i class="icon-listy icon-store"></i></a>
							</div>
							<div class="servicesInfo">
								<h2>파트너 가입</h2>
								<p>Pick Meal 파트너가 <br>되어주세요!</p>
							</div>
						</li>
					</ul>
				</div>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    
    
    </header>
    <script type="text/javascript">
 $("#loginModal").submit(function () {
	var result=true;
	$(".none").css("display","none");
	
	if($("#idM").val()==null||$("#idM").val()==""){
		$(".idMSG").css("display","block");
		result=false;
	}
	
	if($("#passwordM").val()==null||$("#passwordM").val()==""){
		$(".passwordMSG").css("display","block");
		result=false;
	}
	
	return result;
	
	
});
 </script>
