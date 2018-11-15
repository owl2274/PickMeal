<%@page import="java.util.ArrayList"%>

<%@page import="java.util.Arrays"%>

<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%
	String pageNumStr = request.getParameter("pageNum");
	int pageNum = 1;
	if(pageNumStr != null){
		pageNum = Integer.parseInt(pageNumStr);
	}
	int pageSize = 7;
	String [] areaList = request.getParameterValues("areaList");
	
	List<Integer> areas = null;
	if(areaList != null){
		areas = new ArrayList<Integer>();
		for(String area:areaList){
			areas.add(Integer.parseInt(area));
		}
	}
/*  	List<Integer> foodTypes = null; */ 
	String [] foodTypeList = request.getParameterValues("foodTypeList");


  	List<Integer> foodTypes =  null;
  	
  	if(foodTypeList != null){
	  	foodTypes =  new ArrayList<Integer>();
		for(String foodType:foodTypeList){
			foodTypes.add(Integer.parseInt(foodType));
		}
  	}
	

	String keyword = request.getParameter("keyword");
	
	int blockSize = 10;
	
	int totalContents = RestaurantDAO.getDAO().getTotalRestaurantForSearch(areas, foodTypes, keyword);

 	List<RestaurantDTO> restList = 
		RestaurantService.getService().getRestaurantForSearch(pageNum, pageSize, areas, foodTypes, keyword); 
/* 	List<RestaurantDTO> restList = RestaurantDAO.getDAO().getRestaurantForSearch(null, null, null); */
	pageContext.setAttribute("restList", restList);
	

/*
paging처리에 관한 문제
이 모든 것을 get으로 처리하기엔 url이 지나치게 길어질 수 있다.
근데 포잉은 그렇게 했네? ㅁㅊ;
전달해야 할 정보: 지역 코드(복수), 음식 종류 코드(복수), 검색단어
get말고 post는? <input type="hidden">으로 전달 가능하긴 하지
html졸라 드러워진다
session으로의 공유 방법도 생각해보자
@SessionAttributes 활용 고려

다른 생각
controller로 매핑하는 단위는 어떻게 할거야?
각자 맡은 페이지에 따라 각자 생각하도록
나는 검색 기능에 관련된 것들, 그리고 마이페이지에 관련된 것들 
이렇게 묶을거다

수업 끝나고 spring을 이용한 프로젝트를 구축해보자
 */
	String url = "index.jsp?category=main&part=items&";
	ThePager pager = new ThePager(pageNum,blockSize,pageSize,totalContents,url);
	pageContext.setAttribute("pager", pager);
%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- <link rel="stylesheet" type="text/css" media="screen" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href="http://eonasdan.github.io/bootstrap-datetimepicker/css/prettify-1.0.css" rel="stylesheet">
<link href="http://eonasdan.github.io/bootstrap-datetimepicker/css/base.css" rel="stylesheet"> -->
<!-- <link href="http://cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/build/css/bootstrap-datetimepicker.css" rel="stylesheet">
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.js"></script>
<script src="http://cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/src/js/bootstrap-datetimepicker.js"></script> -->

<style type="text/css">
 .listContent .form-group {
    margin-bottom: 0px;
} 
.comment{
	margin-top: 15px;
	margin-bottom: 5px;
}

.categoryImage { 
    position:relative; 
    width:100%/* 상위 엘리먼트에 의존하여 계산 */ ; 
    height:0; 
    padding-bottom:66.666667% /* 가로크기에 비례함 */; 
    
    overflow: hidden;
    position:relative;
}

.categoryImage img{
	position:absolute; 
    left:0;
    top:0;
    width:100%; 
    height:100%;
}

ul.pagination li a span i{
	top:22.5px;
}
</style>

<section class="clerfix">
<div class="container">
	<div class="row">
		<div class="col-sm-12 col-xs-12">
			<div class="resultBar barSpaceAdjust">
				<h2>
					We found <span>${totalContents }</span> Results for you
				</h2>
				<ul class="list-inline">
					<li class="active"><a href="category-list-full.html"><i
							class="fa fa-th" aria-hidden="true"></i></a></li>
					<li><a href="category-list-right.html"><i
							class="fa fa-th-list" aria-hidden="true"></i></a></li>
				</ul>
			</div>
		</div>
	</div>
<!-- 	<div class="listContent">
				<div class="row">
					<div class="col-sm-5 col-xs-12">
						<div class="categoryImage">
							<img
								src="http://c2.poing.co.kr/PIMAGE-original/MjAxNzA2/149638923659311674ad91e.jpeg"
								alt="Image category" class="img-responsive img-rounded"> <span
								class="label label-primary">Verified</span>
						</div>
					</div>
					<div class="col-sm-7 col-xs-12">
						<div class="categoryDetails">
							<ul class="list-inline rating">
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
							</ul>
							<h2>
								<a href="blog-details.html" style="color: #222222">장 스테이크
									하우스</a> <span class="likeCount"><i class="fa fa-heart-o"
									aria-hidden="true"></i> 10 k</span>
							</h2>
							<p>
								<span class="placeName">서울시 강남구 신사동 644-18 2층</span>
							</p>
							<p>압구정 로데오에 합리적인 가격의 스테이크를 만날 수 있는 레스토랑</p>
							<ul class="list-inline list-tag">
								<li><a href="category-list-full.html">예약하기</a></li>
								<li><a href="category-list-full.html">리뷰쓰기</a></li>
							</ul>
						</div>
						<div class="form-group form-inline">

							<input type='number' class="form-control changeComment" min="0" max="8" for="count" value="1">
							<div class='input-group date' id='datetimepicker10'>
								<input type='text' class="form-control" for="date"/> <span
									class="input-group-addon"> <span
									class="glyphicon glyphicon-calendar"> </span>
								</span>
							</div>

							<select class="form-control changeComment" for="time">
								<option>hello</option>
								<option>bye</option>
								<option>hi</option>
							</select>
						</div>
						<div class="comment result">
							요청 사항
						</div>
						<div class="form-group">
							<textarea rows="3" cols="30" class="form-control"></textarea>
						</div>
	<script type="text/javascript">
		var now;
        $(function () {

            $('#datetimepicker10').datetimepicker({
            	defaultDate: new Date()-1,
                format: 'YYYY년 MM월 DD일(ddd)',
                locale: moment.locale('ko')
            });
           
        });

    </script>
					</div>
				</div>

								<div class="row">
    <div class="col-sm-6">
        <div class="form-group form-inline">
        
        	<input type='number'  class="form-control" min="0" max="8">
            <div class='input-group date' id='datetimepicker10'>
                <input type='text' class="form-control" />
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar">
                    </span>
                </span>
            </div>
            <select class="form-control">
    			<option>hello</option>
    		</select>
        </div>
    </div>


			</div>
 -->
 	<C:forEach var="restaurant" items="${restList }">
	<div class="listContent">
		<div class="row">
			<div class="col-sm-5 col-xs-12">
				<div class="categoryImage">
					<img
						src="${pageContext.request.contextPath}/img/restaurant/${restaurant.rstName }/${restaurant.mainImg}"
						class="img-responsive img-rounded"> <span
						class="label label-primary">Verified</span>
				</div>
			</div>
			<div class="col-sm-7 col-xs-12">
				<div class="categoryDetails">
						<ul class="list-inline rating">
							<C:set var="dScore" value="${restaurant.reScore*2 }"></C:set>
							<C:set var="score"
								value="${(dScore+((dScore%1>0.5)?(1-(dScore%1))%1:-(dScore%1)) )/2 }" />
							<C:forEach var="index" begin="1" end="5">
								<C:choose>
									<C:when test="${score >= 1}">
										<li><i class="fa fa-star" aria-hidden="true"></i></li>
									</C:when>
									<C:when test="${score <= 0}">
										<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
									</C:when>
									<C:otherwise>
										<li><i class="fa fa-star-half-full" aria-hidden="true"></i></li>
									</C:otherwise>
								</C:choose>
								<C:set var="score" value="${score-1}" />
							</C:forEach>
						</ul>
						<h2>
						<a href="${pageContext.request.contextPath}/detail?rstNo=${restaurant.rstNo}" style="color: #222222">${restaurant.rstName }</a>
						<%-- <i class="fa fa-heart-o forWant" rstNo="${restaurant.rstNo }"
							aria-hidden="true"></i> --%>
					</h2>
					<p>
						<span class="placeName">${restaurant.address1 } ${restaurant.address2 }</span>
					</p>
					<p>${restaurant.detailText }</p>
					<!-- <ul class="list-inline list-tag">
						<li><a href="category-list-full.html">예약하기</a></li>
						<li><a href="category-list-full.html">리뷰쓰기</a></li>
					</ul> -->
				</div>
			</div>
		</div>

	</div>
	</C:forEach>
	<script type="text/javascript">
	$("i.forWant").click(function() {
		icon = $(this)
		$.ajax({
	        url:"${pageContext.request.contextPath}/toggleWant",
	        type:'GET',
	        data:{"rstNo":""+$(this).attr('rstNo')},
	        dataType: 'text',
	        success:function(text){
        	 	if(text == "success"){
        	 		icon.toggleClass("fa-heart");
        	 		icon.toggleClass("fa-heart-o");
        		}else{
        			alert("fail 발생~~");
        		}
	        },
	        
	        error:function(textStatus){
	            alert("에러 발생~~ \n" + textStatus);
	        }
	    });
		
	});
	</script>
	<div class="paginationCommon blogPagination categoryPagination">
	${pager }

	</div>
</div>
</div>
</div>
</section>
