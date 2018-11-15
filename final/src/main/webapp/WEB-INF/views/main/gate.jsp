<%@page import="com.itwill.interfaceDAO.RestaurantDAOI"%>
<%@page import="com.itwill.dao.RestaurantDAO"%>
<%@page import="com.itwill.dto.Restaurant"%>
<%@page import="com.itwill.interfaceDAO.FoodTypeDAOI"%>
<%@page import="com.itwill.dto.FoodType"%>
<%@page import="com.itwill.dao.FoodTypeDAO"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<style type="text/css">

.thingsArea .container{
	padding:40px;
	border-top: 2px solid #e5e5e5;
}
/* .thingsArea .first{
	border-top: none;
} */
/* .thingsImage{
	width:276px;
	height:184px;
} */

.thingsImage { 
    position:relative; 
    width:100%/* 상위 엘리먼트에 의존하여 계산 */ ; 
    height:0; 
    padding-bottom:70% /* 가로크기에 비례함 */; 
    
    overflow: hidden;
    position:relative;
}

.thingsImage img{
	position:absolute; 
    left:0;
    top:0;
    width:100%; 
    height:100%;
}
</style>







<!-- THINGS SECTION -->
<section class="clearfix thingsArea">

	<C:forEach var="index" begin="0" end="${fn:length(foodTypes)-1 }">
<%-- 	<C:forEach var="foodType" items="${foodTypes}"> --%>
	
		<div class="container">
			<div class="page-header text-center">
				<h2>${foodTypes[index].ftType}</h2>
			</div>
			<div class="row">
		<C:forEach var="restaurant" items="${restLists[index]}">
				<div class="col-md-4 col-sm-6 col-xs-12">
				<%-- 	<a href="listing-details-left.html" style='display: block; background-image: url("img/restaurant/${restaurant.rstName }/${restaurant.mainImg}");'> --%>
					<div class="thingsBox thinsSpace">
						<div class="thingsImage">
				 		<img src="img/restaurant/${restaurant.rstName }/${restaurant.mainImg}" alt="Image things">
							<div class="thingsMask">
								
								<ul class="list-inline rating">
								<C:set var="dScore" value="${restaurant.reScore*2 }"></C:set>
								<C:set var="score" value="${(dScore+((dScore%1>0.5)?(1-(dScore%1))%1:-(dScore%1)) )/2 }"/>
								<C:forEach var="i" begin="1" end="5">
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
									<C:set var="score" value="${score-1}"/>
								</C:forEach>
<!-- 									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-half-full" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li> -->
								</ul>
								<a href="detail?rstNo=${restaurant.rstNo}"><h2>${restaurant.rstName } </h2></a>
								<p>${restaurant.address1}<br> ${restaurant.address2}</p>
							</div>
						</div>
						<div class="thingsCaption ">
							<ul class="list-inline captionItem">								
								<li><i class="fa fa-heart-o" aria-hidden="true"></i> 8 k</li>
								<li><a href="category-list-full.html">Eat & Drink</a></li>								
							</ul>
						</div>
					</div>
			<!-- 		</a> -->
				</div>

		</C:forEach>
	
				<div class="col-xs-12">
					<div class="btnArea btnAreaBorder text-center">
						<a href="javascript:foodTypeSubmit(${foodTypes[index].ftNo })" class="btn btn-primary">Explore More</a>
					</div>
				</div>
			</div>
		</div>
	</C:forEach>
	 	<form id="foodTypeSearch" action="${pageContext.request.contextPath}/search" method="post">
				<li><input id="foodTypeInput" type="hidden" value="${foodTypes[index].ftNo }" name="foodTypeList"></li>
		</form> 
</section>
<script	type="text/javascript">
function foodTypeSubmit(typeNo){
		$("#foodTypeInput").val(typeNo);
		$("#foodTypeSearch").submit();
}
</script>

<!-- APP DOWNLOAD SECTION -->

