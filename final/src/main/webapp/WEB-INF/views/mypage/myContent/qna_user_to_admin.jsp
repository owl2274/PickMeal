<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!-- Dashboard breadcrumb section -->
<div class="section dashboard-breadcrumb-section bg-dark">
  <div class="container">
    <div class="row">
      <div class="col-xs-12">
        <h2>고객센터</h2>
        <ol class="breadcrumb">
        </ol>
      </div>
    </div>
  </div>
</div>


<!-- DASHBOARD REVIEWS SECTION -->
<section class="clearfix bg-dark dashboard-review-section">
  <div class="container">
    <div class="row">
 	<div class="col-xs-12">
		<form name="addQnaForm" action=<c:url value="/insertQna"/> method="post" class="listing__form">
		<input type="hidden" name="regid" value="${loginMember.id}">
		<div class="dashboardBoxBg mb30">
				<div class="profileIntro paraMargin">
					<h3>1 : 1 문의 등록</h3>
					<p>Pickmeal 관리자에게 궁금한 점이 있으시다면 문의해주세요. <br>답변이 등록된 후에는 문의 내용을 수정하거나 삭제할 수 없습니다.</p>
					<div class="row">
						<div class="form-group col-sm-12 col-xs-12">
							<label for="linkedUrl">문의 제목</label>
							<input type="text" name="title" class="form-control" id="linkedUrl">
						</div>
						<div class="form-group col-sm-12 col-xs-12">
							<label for="linkedUrl">문의 내용</label>
							<textarea class="form-control" name="content" rows="3" placeholder=""></textarea>
						</div>
					</div>
				</div>
			</div>
			<div class="form-footer text-center" style="padding-bottom: 30px;">
				<button type="submit" class="btn-submit" id="addBtn">문의 저장</button>
			</div>
		 </form>
	  </div>
      <div class="col-xs-12 col-lg-12">
        <div class="dashboard-list-box">
          <div class="list-sort">
            <div class="sort-left">지난 문의 보기</div>
          </div>
          
          <c:forEach var="qna" items="${qnaList }" >
           <div class="single-list" id="qna_${qna.qnaNo }">
            <div class="media comments-media">
              <div class="media-body">
                <h4 class="media-heading">${qna.regname } <a href="">${qna.resname }</a></h4>
                <div class="date">등록일 (${qna.regdate })</div>
                <table width="100%">
                	<tr>
                		<td width="5%" rowspan="2" style="vertical-align:top; padding-top: 6px;"><span class="label label-success">질문</span></td>
                		<td  style="font-size: 1.1em; font-weight: bold; padding-bottom: 10px;">
                			<span id="qnaTitle_${qna.qnaNo }">${qna.title }</span>
                		</td>
                		<td width="20%" rowspan="3" style="text-align: right; vertical-align: top;">
                			<c:if test="${qna.status==1 }">
                				<button type="button" class="btn btn-primary" onclick="javascript: getQna(${qna.qnaNo });">수정</button>
                				<button type="button" class="btn btn-primary" onclick="javascript: remove(${qna.qnaNo });">삭제</button>
                			</c:if>
                		</td>
                	</tr>
                	<tr>
                		<td><span id="qnaContent_${qna.qnaNo }">${qna.content }</span>
                	</tr>
                	<tr style="vertical-align:top;">
                		<td style="padding-top: 30px;"><span class="label label-warning">답변</span></td>
                		<td style="padding-top: 20px;"><p>${qna.reply }</p></td>
                	</tr>
                </table>
                
              </div>
            </div>
           </div> 
          </c:forEach>
        </div>
      </div>
    </div>
  </div>
</section>
 
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
        <h4 class="modal-title" id="myModalLabel">문의 수정하기</h4>
      </div>
      <div class="modal-body">
      	<div class="row">
			<div class="form-group col-sm-12 col-xs-12">
				<input type="hidden" id="updateQnaNo">
				<label for="linkedUrl">문의 제목</label>
				<input type="text" id="updateTitle" class="form-control">
			</div>
			<div class="form-group col-sm-12 col-xs-12">
				<label for="linkedUrl">문의 내용</label>
				<textarea class="form-control" id="updateContent" rows="3" placeholder=""></textarea>
			</div>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" style="width: 100px" data-dismiss="modal">취소</button>
        <button type="button" class="btn btn-primary" style="width: 100px" onclick="javascript: modify();">저장</button>
      </div>
    </div>
  </div>
</div>


<script type="text/javascript">
$("#addBtn").click(function() {
	$("#addQnaForm").submit();
});

function getQna(qnaNo){
    $("#myModal").modal();
	$.ajax({
		type:"GET",
		url:"${pageContext.request.contextPath}/getQna/"+qnaNo,
		dataType:"json",
		success:function(json) {
			$("#updateQnaNo").val(qnaNo);
		    $("#updateTitle").val(json.title);
			$("#updateContent").val(json.content); 
		},
		error:function(req) {
			alert("응답 오류 = "+req.status);
		}
	});
};

function modify(){
	var qnaNo=$("#updateQnaNo").val();
	var title=$("#updateTitle").val();
	var content=$("#updateContent").val();
	
	if(title=="") {
		alert("변경하고자 하는 문의 제목을 반드시 입력해 주세요.");
		$("#updateTitle").focus();
		return;
	}
	
	if(content=="") {
		alert("변경하고자 하는 문의 내용을 반드시 입력해 주세요.");
		$("#updateContent").focus();
		return;
	}
	
	$.ajax({
		type:"PUT",
		url:"${pageContext.request.contextPath}/updateQna",
		headers:{"Content-Type":"application/json","X-HTTP-Method-override":"PUT"},
		data:JSON.stringify({"qnaNo":qnaNo,"title":title,"content":content}),
		dataType:"json",
		success:function(json) {
			$("#qnaTitle_"+qnaNo).html(json.title);
			$("#qnaContent_"+qnaNo).html(json.content);
		},
		error:function(req) {
			alert("응답 오류 = "+req.status);
		}
	});
	
	$("#myModal").modal('hide');
	$("#updateQnaNo").val();
	$("#updateTitle").val();
	$("#updateContent").val(); 
}; 

function remove(qnaNo) {
	if(confirm("문의 내역을 정말로 삭제하시겠습니까?")) {
		$.ajax({
			type:"GET",
			url:"${pageContext.request.contextPath}/removeQna/"+qnaNo,
			dataType:"text",
			success:function(qnaNo) {
				$("#qna_"+qnaNo).hide();
			},
			error:function(req) {
				alert("응답 오류 = "+req.status);
			}
		});
	}
};

</script>
