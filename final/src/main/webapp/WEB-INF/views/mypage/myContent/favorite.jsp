
<%@page import="com.itwill.dto.Restaurant"%>
<%@page import="com.itwill.interfaceDAO.RestaurantDAOI"%>
<%@page import="com.itwill.dao.RestaurantDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>    

    
<%-- <%
	String pageNumStr = request.getParameter("pageNum");
	int pageNum = 1;
	if(pageNumStr != null)
		pageNum = Integer.parseInt(pageNumStr);
	System.out.println("pageNumStr = "+pageNumStr);
	int pageSize = 9;
	
	int blockSize= 10;
	String id = "ljh";
	int totalContents = RestaurantDAOI.getTotalgetRestaurantForWant(id);
 	List<Restaurant> restList = RestaurantService.getService().getRestaurantForWant(pageNum,pageSize,"ljh");
	pageContext.setAttribute("restList", restList);
	
	
	
	//요오기 페이지 작업하다 말았다.
	ThePager pager = new ThePager(pageNum,blockSize,pageSize,totalContents,"index.jsp?category=mypage&part=mypage&");

%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style type="text/css">
div.body.empty{
	text-indent:0px;
}

.thingsImage { 
    position:relative; 
    width:100%/* 상위 엘리먼트에 의존하여 계산 */ ; 
    height:0; 
    padding-bottom:66.666667% /* 가로크기에 비례함 */; 
    
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

@media (min-width: 992px){
.col-md-4 {
    width: 33.33333333%;
}
}
@media (min-width: 768px){
.col-sm-6 {
    width: 50%;
}
}
@media(min-width: 0px) and (max-width: 767px){
.col-sm-6 {
    width: 100%;
}
}
</style>

<section class="clearfix thingsArea">
	<div class="container">
		<div class="page-header text-center">
			<!-- <h2>Popular Things Near You <small>This are some of most popular listing</small></h2> -->
		</div>
		<div class="row">
		
		<C:forEach var="restaurant" items="${restList }">
			<div class="col-md-4 col-sm-6 col-xs-12">
				<div class="thingsBox thinsSpace">
					<div class="thingsImage">
						<img src="${pageContext.request.contextPath}/img/restaurant/${restaurant.rstName }/${restaurant.mainImg}" 
						alt="Image things">
						<div class="thingsMask">
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
							<h2><a href="${pageContext.request.contextPath}/detail?rstNo=${restaurant.rstNo }">${restaurant.rstName }</a> <i class="fa fa-heart forWant" rstNo="${restaurant.rstNo }" aria-hidden="true"></i></h2>
							<p>${restaurant.address1 }<br>${restaurant.address2 }</p>
						</div>
					</div>
				<!-- 	<div class="thingsCaption ">
						<ul class="list-inline captionItem">
							<li><i class="fa fa-heart-o" aria-hidden="true"></i> 8 k</li>
							<li><a href="category-list-full.html">Eat &amp; Drink</a></li>
						</ul>
					</div> -->
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
/* 		$("i.fa-heart").click(function() {
			icon = $(this)
			$.ajax({
		        url:"${pageContext.request.contextPath}/removeWant",
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
			
		}); */
/* 		$("i.fa-heart-o").click(function() {
			icon = $(this)
			$.ajax({
		        url:"${pageContext.request.contextPath}/addWant",
		        type:'GET',
		        data:{"rstNo":""+$(this).attr('rstNo')},
		        dataType: 'text',
		        success:function(text){
	        	 	if(text == "success"){
	        	 		icon.toggleClass("fa-heart");
	        	 		icon.toggleClass("fa-heart-o");
	        		}else{
	        			alert("fail 발생~~ \n" + textStatus + " : " + errorThrown);
	        		} 
	        		
	        		

		        },
		        
		        error:function(textStatus){
		            alert("에러 발생~~ \n" + textStatus);
		        }
		    });
			
		}) */
		</script>
		</div>
		<div class="pager">
		${pager }
		</div>
	</div>
</section>
