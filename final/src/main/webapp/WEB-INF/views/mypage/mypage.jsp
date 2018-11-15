<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>   


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
				<!-- 상단에 배너가 있는 레이아웃 -->
<style type="text/css">
#content>.tab{
 border-top:2px solid #2196f3;
}
#content>.tab>.item.selected>a, #content>.tab>.item:hover>a {
    color: #2196f3;
}
.col-sm-8 {
    width: 100%;
/*     width: 66.66666667%; */
}
#content {
	width: 1095px;
}

#content>.tab {
    width: 1095px;
}

.col-sm-6 {
    width: 33.333333333%;
    max-width: 370px;
}


/* ul.navbar-nav li{
	float:right;
} */
.navbar-dashboard-area .navbar-dash ul.navbar-nav{
	width:100%;
}
.navbar-dashboard-area .navbar-dash ul.navbar-nav li a{
	font:18px bold;
}
.navbar-dashboard-area .navbar-dash ul.navbar-nav li{
	display:inline;
	width:10%;
	margin-right:3%;	
	text-align: center;
}
.navbar-dashboard-area .navbar-dash ul.navbar-nav li.first{
	margin-left:12%;	
	
}
section.navbar-dashboard-area{
	background-color: #2196f3
}

.pager li>a {
	border-top-left-radius: 0px;
    border-top-right-radius: 0px;
    border-bottom-right-radius: 0px;
    border-bottom-left-radius: 0px;
}
.navbar-default.navbar-dashboard .navbar-nav > li > a {
	color:white;
}
</style>
	

	<section class="navbar-dashboard-area">
      <nav class="navbar navbar-default lightHeader navbar-dashboard" role="navigation">
        <div class="container">

          <!-- Brand and toggle get grouped for better mobile display -->
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-dash">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
          </div>

          <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="navbar-collapse navbar-dash collapse" aria-expanded="false" style="height: 1px;">
            <ul class="nav navbar-nav mr0">
  <%--             <li class="first">
                <a href="${pageContext.request.contextPath }/mypage/bookings">예약</a>
              </li>
              <li class="">
                <a href="${pageContext.request.contextPath }/mypage/review" >리뷰</a>
              </li>
              <li class="">
                <a href="${pageContext.request.contextPath }/mypage/favorite">찜</a>
              </li>
              <li><a href="${pageContext.request.contextPath }/mypage/profile">설정</a></li> --%>
              <li class="first">
                <a href="javascript:getMypage('bookings')">예약</a>
              </li>
              <li class="">
                <a href="javascript:getMypage('review')" >리뷰</a>
              </li>
              <li class="">
                <a href="javascript:getMypage('favorite')">찜</a>
              </li>
              <li><a href="javascript:getMypage('profile')">설정</a></li>
<!--               <li><a href="dashboard.html#message" class="scrolling"><i class="fa fa-envelope icon-dash" aria-hidden="true"></i> Messages</a></li>
              <li><a href="profile.html"><i class="fa fa-user icon-dash" aria-hidden="true"></i> Personal Details</a></li> -->
              <li class="">
                <!-- <a href="javascript:getMypage('qna_user_to_admin')">고객센터</a> -->
                <a href="${pageContext.request.contextPath }/mypage/qna_user_to_admin">고객센터</a>
              </li>
              <li class="">
                <a href="javascript:getMypage('userFaqList')">FAQ</a>
              </li>
            </ul>

            
          </div>
        </div>
      </nav>
    </section>
    <div class="forAjax">
    </div>

	<script type="text/javascript">
	
	
	
	function getMypage(mypage){
		$.ajax({
		    url:"${pageContext.request.contextPath}/"+mypage,
		    type:'GET', 
		    data:{${forJavascript }}, 
		    dataType: 'html',
		    success:function(data){
				$(".forAjax").empty();
				$(".forAjax").html(data);
		    },
		    
		    error:function(jqXHR, textStatus, errorThrown){
		        alert("에러 발생~~ \n" + textStatus + " : " + errorThrown);
		    }
		});
	}
	getMypage("${type}"); 
	</script> 


