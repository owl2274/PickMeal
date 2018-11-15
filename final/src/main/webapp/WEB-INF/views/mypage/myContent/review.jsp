
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%
	List<Review> reviewList = ReviewDAO.getDAO().getReviewById("ljh");
	System.out.println("reviewList.size() = "+reviewList.size());
	reviewList.size();
	
	pageContext.setAttribute("reviewList", reviewList);
%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script> -->
<!-- <script src="jquery.js"></script> -->

<%-- <script src="${pageContext.request.contextPath}/jquery.js"></script>
<script src="${pageContext.request.contextPath}/jquery.rateyo.js"></script> --%>
<style type="text/css">

.container {
    width: 1095px;
}

.col-lg-6 {
    margin: 40px auto;
    width: 100%;
}

.comments-media .media-left a img{
	border-top-left-radius: 0%;
    border-top-right-radius: 0%;
    border-bottom-right-radius: 0%;
    border-bottom-left-radius: 0%;
    width: 300px;
    height: auto;
}

.form-control[disabled], fieldset[disabled] .form-control {
    cursor: default;
}

/* div.reviewContainer{
	height:340px;
} */
</style>
    <div class="row">
      <div class="col-xs-12 col-lg-6">
        <div class="dashboard-list-box">
          <div class="list-sort">
            <div class="sort-left">Your Reviews</div>
          </div>
		<c:forEach var="review" items="${reviewList }">
		<!-- <div class="reviewContainer"> -->
		<form id="reviewEditForm${review.reNo }" 
		action="<c:if test='${pageNum != null }'>?pageNum=${pageNum }<c:if test='${rstName != null }'>&rstName=${rstName }</c:if></c:if><c:if test='${pageNum == null and rstName != null }'>?rstName=${rstName }</c:if>" method="post" enctype="multipart/form-data" >
		<input type="hidden" name="reNo" value="${review.reNo }">
<%-- 		<form action="${pageContext.request.contextPath}/modifyReview" method="post" enctype="multipart/form-data"> --%>
          <div class="single-list">
            <div class="media comments-media">
              <div class="media-left">
                <a href="#">
                  <img src="${pageContext.request.contextPath}/img/review/${review.reImg }" alt="User Image">
                </a>
                <input id="file${review.reNo }" type="file" class="form-control inputForm${review.reNo }" name="file" style="display: none;">
              </div>
              <div class="media-body">
              	
           <%--   리뷰dto, 테이블에 레스토랑 이름이 없다...! 	 --%>
                <h4 class="media-heading">${review.name } <a href="">on ${review.rstName }</a>
                
                	
                 <div class="user star jq-ry-container outputForm${review.reNo }" id="rateYoReadOnly${review.reNo }" ></div>
				
                 <div class="user star jq-ry-container inputForm${review.reNo }" id="rateYo${review.reNo }" style="display: none;" ></div>
				<input  type="hidden" name="reScore" value="${review.reScore }"> 
				
				<script type="text/javascript">
				$(function () {			 
				  $("#rateYo"+${review.reNo }).rateYo({
					  rating: ${review.reScore },
					  halfStar: true,
					  onChange: function (rating, rateYoInstance) {				    	 
					        $(this).next().val(rating);
					      }
				  });			  
				  $("#rateYo"+${review.reNo }).rateYo("option", "starWidth", "20px");			 
				}); 
				
				$(function () {			 
				  $("#rateYoReadOnly"+${review.reNo }).rateYo({
					  rating: ${review.reScore },
					  halfStar: true,
					  readOnly: true,
					  onChange: function (rating, rateYoInstance) {				    	 
					        $(this).next().val(rating);
					      }
				  });			  
				  $("#rateYoReadOnly"+${review.reNo }).rateYo("option", "starWidth", "20px");			 
				}); 
				</script>

				<div class="displayScore" style="display:inline;float:right;">

				</div>
				</h4>
                <div class="date">${review.reDate }</div>
                <div id="outputForm${review.reNo }" class="reContent outputForm${review.reNo }">${review.reContent }</div>
                <textarea class="form-control inputForm${review.reNo }" rows="" cols="" id="reContent${review.reNo }" name="reContent" style='display: none;' ></textarea>
             
                <!-- <a href="" class="btn btn-primary"><i class="fa fa-pencil" aria-hidden="true"></i>edit</a> -->
                <div class="changeUse outputForm${review.reNo }">
					<button type="button" class="btn btn-primary showFormBtn modify" reNo="${review.reNo }">변경 </button>
					<button type="button" class="btn btn-primary remove" onclick="javascript:removeReview(${review.reNo});">삭제 </button>
				</div>
				<div class="changeDontUse inputForm${review.reNo }" style="display:none;">
					<button type="button" class="btn btn-primary modifyBtn modify" onclick="javascript:modifyReview(${review.reNo});">변경 </button>
					<button type="button" class="btn btn-primary cancelBtn modify" reNo="${review.reNo }">취소 </button>
				</div>
              </div>
            </div>
          </div>
        </form>  
        <!-- </div> -->
		</c:forEach>
		<script type="text/javascript">
		 					$(".showFormBtn").click(function() {
					/* 	$(this).parentsUntil("form").find("div.changeUse").hide();
						$(this).parentsUntil("form").find("div.changeDontUse").show();
						$(this).parentsUntil("form").find(".form-control").prop("disabled",false); */
						
						var reNo = $(this).attr("reNo");
						
						$(".outputForm"+reNo).hide();
					 	$(".inputForm"+reNo).show(); 
						$("#reContent"+reNo).val( $("#output"+reNo).text() );
						
						var score = $("#rateYoReadOnly"+reNo).rateYo("option", "rating");
						$("#rateYo"+reNo).rateYo("option", "rating", score);
					/*	$("#reContent"+reNo).show();
					 	$("#output"+reNo).hide(); */
					});
					
					$(".cancelBtn").click(function() {
				/* 		$("div.changeUse").show();
						$("div.changeDontUse").hide();
						$(this).parentsUntil("form").find(".form-control").prop("disabled",true); */
						
				/* 		var reNo = $(this).attr("reNo");
						
						$("#reContent"+reNo).val("");
						$("#reContent"+reNo).hide();
						$("#output"+reNo).show(); */
						var reNo = $(this).attr("reNo");
						
						$(".outputForm"+reNo).show();
						$(".inputForm"+reNo).hide();
						$("#reContent"+reNo).val("");
						$("#file"+reNo).val("");
					});
					
					function modifyReview(reNo){
						$("#reviewEditForm"+reNo)
						.attr("action", "${pageContext.request.contextPath}/modifyReview"+$("#reviewEditForm"+reNo).attr("action"));
						$("#reviewEditForm"+reNo).submit();
					}				
					function removeReview(reNo){
						if(window.confirm("리뷰를 삭제하시겠습니까?")){
							$("#reviewEditForm"+reNo)
							.attr("action", "${pageContext.request.contextPath}/removeReview"+$("#reviewEditForm"+reNo).attr("action"));
							$("#reviewEditForm"+reNo).submit();
						}
					}				
	

		</script>
	<!-- 	<script type="text/javascript">
		$(function () {
			 
			  $("#rateYo").rateYo({
				  rating: 1.0,
				  halfStar: true,
				  onChange: function (rating, rateYoInstance) {
				    	 
				     /*    $(this).next().text(rating); */
				        $(this).next().val(rating);
				      },
				      /* onSet: function (rating, rateYoInstance) {
				    	  
				          alert("Rating is set to: " + rating);
				        } */

			  })
			  
			  $("#rateYo").rateYo("option", "starWidth", "15px");

			 
			}); 
		</script> -->
        </div>
      </div>
    </div>

     <ul class="nav navbar-nav navbar-left">
    <li>
    ${pager }
    </li>
    <li style="float: right;">
    <form id="keywordSearch" action="${pageContext.request.contextPath}/mypage/review" method="get">
    <ul class="nav navbar-nav navbar-left">
    <li class="inputList">
				
              <input style="width:200px;" id="reviewKeyword" type="text" class="form-control" placeholder="식당 이름" name="rstName">
            	
				</li>
								<li class="buttonList">
	          <div class="form-group">
	            <button type="submit" class="btn btn-primary">Search </button>
	          </div>				</li>
	          </ul>
	          </form>
	          </li>
	          </ul> 

<!-- 	<script type="text/javascript">
	$("#keywordSearch").submit(function() {
		alert($("#keywordSearch input").val());
		var keword = encodeURIComponent($("#keywordSearch input").val());
		$("#keywordSearch input").val(keyword);
		alert($("#keywordSearch input").val());
		return true;
		
	})
	</script> -->
<!-- <div class="paginationCommon blogPagination text-center">
      <nav aria-label="Page navigation">
        <ul class="pagination">
          <li>
            <a href="#" aria-label="Previous">
              <span aria-hidden="true"><i class="fa fa-angle-left" aria-hidden="true"></i></span>
            </a>
          </li>
          <li class="active"><a href="#">1</a></li>
          <li><a href="#">2</a></li>
          <li><a href="#">3</a></li>
          <li><a href="#">4</a></li>
          <li><a href="#">5</a></li>
          <li>
            <a href="#" aria-label="Next">
              <span aria-hidden="true"><i class="fa fa-angle-right" aria-hidden="true"></i></span>
            </a>
          </li>
        </ul>
      </nav>
    </div> -->
