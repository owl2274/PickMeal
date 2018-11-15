<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style type="text/css">

.row {
    width: 1095px;
    margin: 40px auto;
}

.booking-list-media .media-body .media-heading .label.label-complete {
  background-color: #2196f3;
}
.booking-list-media .media-body .media-heading .label.label-rude {
  background-color: #000000;
}

.booking-list-media .media-left a img{
	border-top-left-radius: 0%;
    border-top-right-radius: 0%;
    border-bottom-right-radius: 0%;
    border-bottom-left-radius: 0%;
    width: 200px;
    height: auto;
}
</style>

<!-- LISTINGS DETAILS TITLE SECTION -->
<!--modal예약하기*****************************************************************************-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">예약변경하기</h4>
			</div>
			<div class="modal-body">
				<div class="form-group form-inline">
					<label>예약 일/시간</label>
					<div class='input-group date' id='datetimepicker10'>
						<input type='text' class="form-control" for="date" id="bookDate" name="bookDate"/> <span
							class="input-group-addon"> <span
							class="glyphicon glyphicon-calendar"> </span>
						</span>
					</div>
					<select class="form-control changeComment" for="time" id="bookTime" name="bookTime" onchange="javascript:getRestSeat();">
						<option value="--:--">--:--</option>
						<option value="00:00">AM 00:00</option>
						<option value="01:00">AM 01:00</option>
						<option value="02:00">AM 02:00</option>
						<option value="03:00">AM 03:00</option>
						<option value="04:00">AM 04:00</option>
						<option value="05:00">AM 05:00</option>
						<option value="06:00">AM 06:00</option>
						<option value="07:00">AM 07:00</option>
						<option value="08:00">AM 08:00</option>
						<option value="09:00">AM 09:00</option>
						<option value="10:00">AM 10:00</option>
						<option value="11:00">AM 11:00</option>
						<option value="12:00">AM 12:00</option>
						<option value="13:00">PM 01:00</option>
						<option value="14:00">PM 02:00</option>
						<option value="15:00">PM 03:00</option>
						<option value="16:00">PM 04:00</option>
						<option value="17:00">PM 05:00</option>
						<option value="18:00">PM 06:00</option>
						<option value="19:00">PM 07:00</option>
						<option value="20:00">PM 08:00</option>
						<option value="21:00">PM 09:00</option>
						<option value="22:00">PM 10:00</option>
						<option value="23:00">PM 11:00</option>
						<option value="24:00">PM 12:00</option>
					</select> <input type='number' class="form-control changeComment" min="0"
						max="1000" for="count" value="1" id="inputSeat" name="inputSeat"> <label>명</label>
						<input type="hidden" name="restSeat" id="restSeat">
						<p style="color:red; text-align: center; font-weight: bold;" id="restSeatLabel"></p>
						<p style="color:red; text-align: center; font-weight: bold;" id="restSeatMessage"></p>
				</div>
				<hr>
				<div class="comment result">요청 사항</div>
				<div class="form-group">
					<textarea rows="3" cols="30" class="form-control" id="bookCmt" name="bookCmt"></textarea>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary moBtn"
					data-dismiss="modal" onclick="javascript: cancel();">close</button>
				<button type="button" class="btn btn-primary moBtn"
					data-toggle="modal" data-backdrop="static" id="bookingBtn"
					onclick="javascript: booking();">booking</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>


<!--modal예약완료후*****************************************************************************-->
<div class="modal fade" id="myModalTwo" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<h4 class="modal-title" id="myModalLabel" style="color: firebrick">예약이
					접수되었습니다.</h4>
			</div>
			<div class="modal-body">
				<div class="form-group form-inline">
					<h5 style="font-weight: normal""color:darkgray">
						매장과 연결을 진행합니다. 연결 즉시, 확정여부를 알려드리겠습니다.<br>
						<br> 예약도 소중한 약속입니다.<br>
						<br> PickMeal과 함께 No-Show(노쇼)없는 예약 문화를 만들어 나가요!
					</h5>
				</div>
				<hr>
				<h5 style="color: firebrick" class="bold">예약 내역입니다</h5>
				<br>
				<p class="bold black" id="afterRstName"></p>
				<p>
					<span class="black">예약자명&nbsp;:&nbsp;</span><span
						style="color: dimgrey" "font-weight:normal" id="afterName"></span>
				</p>
				<p>
					<span class="black">예약날짜&nbsp;:&nbsp;</span><span
						style="color: dimgrey" "font-weight:normal" id="afterBookDate"></span>
				</p>
				<p>
					<span class="black">예약시간&nbsp;:&nbsp;</span><span
						style="color: dimgrey" "font-weight:normal" id="afterBookTime"></span>
				</p>
				<p>
					<span class="black">인원수&nbsp;:&nbsp;</span><span
						style="color: dimgrey" "font-weight:normal" id="afterBookNop"></span><span>명</span>
				</p>
				<p>
					<span class="black">연락처&nbsp;:&nbsp;</span><span
						style="color: dimgrey" "font-weight:normal" id="afterPhone"></span>
				</p>
				<p>
					<span class="black">요청사항&nbsp;:&nbsp;</span><span
						style="color: dimgrey" "font-weight:normal" id="afterBookCmt"></span>
				</p>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary moBtn"
					data-dismiss="modal" onclick="javascript:location.reload();">확인</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
    <div class="row">
      <div class="col-xs-12">
        <div class="dashboard-list-box">

<div class="list-sort">
            <div class="sort-left"></div>
            <div class="sort-right sort-select">
              <select name="guiest_id2" id="guiest_id2" class="select-drop" sb="11228386" style="display: none;">
                <option value="5">전체 보기</option>
                <option value="0">예약 취소</option>
                <option value="1">예약 대기</option>
                <option value="2">예약 완료</option>
                <option value="3">방문 완료</option>
                <option value="4">No-Show</option>
              </select>
					<div id="sbHolder_11228386" class="sbHolder">
						<a id="sbToggle_11228386" href="#" class="sbToggle sbToggleOpen"></a><a
							id="sbSelector_11228386" href="#" class="sbSelector">예약 상태</a>
						<ul id="sbOptions_11228386" class="sbOptions"
							style="top: 34px; max-height: 606px; display: none;">
							<li><a href="${pageContext.request.contextPath}/mypage/bookings?bookStatus=-1" rel="5">전체 보기</a></li>
							<c:forEach var="bookStatus" items="${bookStatusList }">
							<li><a href="${pageContext.request.contextPath}/mypage/bookings?bookStatus=${bookStatus.bookStatus}" rel="0">${bookStatus.statusName }</a></li>
							</c:forEach>
							
							<!-- <li><a href="#0" rel="0">예약 취소</a></li>
							<li><a href="#1" rel="1">예약 대기</a></li>
							<li><a href="#2" rel="2">예약 완료</a></li>
							<li><a href="#3" rel="3">방문 완료</a></li>
							<li><a href="#4" rel="4">No-Show</a></li> -->
						</ul>
					</div>

				</div>
          </div>

          
       	  <c:forEach var="book" items="${bookList }">
          <div class="single-list">
            <div class="media booking-list-media">
              <div class="media-left">
                <a href="#">
                  <img src="${pageContext.request.contextPath}/img/restaurant/${book.rstName }/${book.mainImg}" alt="User Image">
                </a>
              </div>
              <div class="media-body">
                <h4 class="media-heading"><a href="${pageContext.request.contextPath}/detail?rstNo=${book.rstNo}">${book.rstName }</a> 
                <c:choose>
                	<c:when test="${book.bookStatus eq 2 }">
                		<span class="label label-success">예약 확정</span>
                	</c:when>
                	<c:when test="${book.bookStatus eq 0 }">
                		<span class="label label-danger">예약 취소</span>
                	</c:when>
                	<c:when test="${book.bookStatus eq 1 }">
                		<span class="label label-warning">예약 대기</span>
                	</c:when>
                	<c:when test="${book.bookStatus eq 3 }">
                		<span class="label label-complete">방문 완료</span>
                	</c:when>
                	<c:when test="${book.bookStatus eq 4 }">
                		<span class="label label-rude">no-show</span>
                	</c:when>
                </c:choose>
                </h4>
                <div class="booking-list ">예약 날짜,시간: <span class="highlight bg-warning">${book.bookDate} ${book.bookTime}</span></div>
                <div class="booking-list">예약 인원: <span class="highlight bg-warning">${book.bookNop }</span></div>
                <div class="booking-list">Client: <span>Kathy Brown | dodo@example.com | ${book.phone }</span></div>
                <!-- <a href="#" class="btn btn-primary">send message</a> -->
              </div>
              <div class="right-btn">
              <c:if test="${book.bookStatus eq 0 or book.bookStatus eq 1 or book.bookStatus eq 2 }">
                <a data-toggle="modal" href="#myModal" class="btn btn-primary approved" data-backdrop="static" onclick="javascript:changeRstNo(${book.rstNo },${book.bookNo },'${book.rstName }');">예약 변경</a>
              </c:if>
              <c:if test="${book.bookStatus eq 1 or book.bookStatus eq 2 }">
                <a href="${pageContext.request.contextPath}/mypage/cancelBook?bookNo=${book.bookNo}${query}" class="btn btn-primary cancel">예약 취소</a>
              </c:if>
              </div>
            </div>
          </div>
          </c:forEach>
          <!-- 
          <div class="single-list">
            <div class="media booking-list-media">
              <div class="media-left">
                <a href="#">
                  <img src="img/dashboard/comments-01.jpg" alt="User Image">
                </a>
              </div>
              <div class="media-body">
                <h4 class="media-heading">Macgaiver <span class="label label-warning">pending</span></h4>
                <div class="booking-list ">Booking Date: <span class="highlight bg-warning">11.01.2018 at 8:30 a.M</span></div>
                <div class="booking-list">Booking details: <span class="highlight bg-warning">1-3 People</span></div>
                <div class="booking-list">Client: <span>Kathy Brown | dodo@example.com | 123-456-789</span></div>
                <a href="#" class="btn btn-primary">send message</a>
              </div>
              <div class="right-btn">
                <a href="#" class="btn btn-primary cancel">cancel</a>
                <a href="#" class="btn btn-primary approved">approve</a>
              </div>
            </div>
          </div>
          <div class="single-list">
            <div class="media booking-list-media">
              <div class="media-left">
                <a href="#">
                  <img src="img/dashboard/comments-03.jpg" alt="User Image">
                </a>
              </div>
              <div class="media-body">
                <h4 class="media-heading">John Doe  <span class="label label-danger">Canceled</span></h4>
                <div class="booking-list ">Booking Date: <span class="highlight bg-danger">11.01.2018 at 8:30 a.M</span></div>
                <div class="booking-list">Booking details: <span class="highlight bg-danger">1-3 People</span></div>
                <div class="booking-list">Client: <span>Kathy Brown | dodo@example.com | 123-456-789</span></div>
                <a href="#" class="btn btn-primary">send message</a>
              </div>
              <div class="right-btn">
                <a href="#" class="btn btn-primary delete">delete</a>
              </div>
            </div>
          </div>
          <div class="single-list">
            <div class="media booking-list-media">
              <div class="media-left">
                <a href="#">
                  <img src="img/dashboard/comments-02.jpg" alt="User Image">
                </a>
              </div>
              <div class="media-body">
                <h4 class="media-heading">Tom Wilson <span class="label label-success">Approved</span></h4>
                <div class="booking-list ">Booking Date: <span class="highlight bg-success">11.01.2018 at 8:30 a.M</span></div>
                <div class="booking-list">Booking details: <span class="highlight bg-success">1-3 People</span></div>
                <div class="booking-list">Client: <span>Kathy Brown | dodo@example.com | 123-456-789</span></div>
                <a href="#" class="btn btn-primary">send message</a>
              </div>
              <div class="right-btn">
                <a href="#" class="btn btn-primary cancel">cancel</a>
              </div>
            </div>
          </div>
 -->
        </div>
        ${pager }
      </div>
    </div>
    
    <!-- modal script -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/js/moment.ko.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript">

var curRstNo;
var curBookNo;
var curRstName;
var holidays;
function changeRstNo(rstNo,bookNo,rstName){
	curRstNo = rstNo;
	curBookNo = bookNo;
	curRstName = rstName;
	
	$.ajax({
		url:"${pageContext.request.contextPath}/holidayList",
		type:'POST',
		data:{"rstNo":""+curRstNo },
		dataType:'json',
		success:function(json){
			holidays=[];
			json.forEach(function(elt, i) {	
				var holiday=elt.holiday
			//	alert(holiday+" "+holiday.substring(5,7)+"/"+holiday.substring(8,10)+"/"+holiday.substring(0,4));
				holidays.push(moment(holiday.substring(5,7)+"/"+holiday.substring(8,10)+"/"+holiday.substring(0,4)));
			});
		/* 	holidays.forEach(function(elt, i) {	
					alert(elt);
				}); */
			
			$('#datetimepicker10').data("DateTimePicker").disabledDates(holidays);
		//	$('#datetimepicker10').data("DateTimePicker").disabledDates([ moment('2018-08-07'),moment('2018-08-08')]);
			
		},
		error:function(textStatus){
            alert("에러 발생~~ \n" + textStatus.status);
        }
	});
	
}

function getRestSeat() {
	$("#restSeatLabel").text("");
	$("#restSeatMessage").text("");
	
	var rstNo=""+curRstNo;
	var bookDate=$("#bookDate").val();
	bookDate=bookDate.substring(0,4)+bookDate.substring(6,8)+bookDate.substring(10,12);
	var bookTime=$("#bookTime option:selected").val();
	
	//예약 잔여 좌석 수 조회
 	$.ajax({
		type:"POST",
		url:"${pageContext.request.contextPath}/getRestSeat",
		headers:{"Content-Type":"application/json","X-HTTP-Method-override":"POST"},
		data:JSON.stringify({"rstNo":rstNo,"bookDate":bookDate,"bookTime":bookTime}),
		dataType:"json",
		success:function(cnt) {
			$("#restSeatLabel").text("(예약 가능 좌석 : "+cnt+"석)");
			$("#restSeat").val(cnt);
		},
		error:function(req) {
			alert("응답 오류 = "+req.status);
		}
	}); 
}

function booking() {
	$("#restSeatMessage").text("");
	var bookTime=$("#bookTime option:selected").val();
	if(bookTime=="--:--") {
		$("#restSeatMessage").text("예약 시간을 선택해 주세요.");
		$("#bookingBtn").attr("data-dismiss","");
		return;
	} 
	
	var inputSeat=$("#inputSeat").val();
	var restSeat=$("#restSeat").val();
	
	if(inputSeat==0){
		$("#restSeatMessage").text("예약 인원을 입력해 주세요.");
		$("#bookingBtn").attr("data-dismiss","");
		return;
	}
	
	
	
	if(parseInt(inputSeat)>parseInt(restSeat)) {
		$("#restSeatMessage").text("예약 가능 좌석 수를 초과하였습니다. 예약 인원을 다시 입력해 주세요.");
		$("#bookingBtn").attr("data-dismiss","");
	} else {
				/* new */
				
				var id="${loginMember.id}";
				var name="${loginMember.name}";
				var phone="${loginMember.phone}";
				var rstNo=curRstNo;
				var bookNop=$("#inputSeat").val();
				var bookDate=$("#bookDate").val();
				bookDate=bookDate.substring(0,4)+bookDate.substring(6,8)+bookDate.substring(10,12);
				var bookTime=$("#bookTime option:selected").val();
				var bookCmt=$("#bookCmt").val();
				var rstName=curRstName;
				
				
				
				$.ajax({
					type:"POST",
					url:"${pageContext.request.contextPath}/modifyBooking",
					headers:{"Content-Type":"application/json"},
					data:JSON.stringify({"bookNop":bookNop,"bookDate":bookDate,"bookTime":bookTime,"bookCmt":bookCmt,"bookNo":curBookNo}),
					dataType:"text",
					success:function(result){
						if(result=="success"){
						$("#bookingBtn").attr("data-dismiss","modal");
						$("#bookTime").val("--:--");
						$("#inputSeat").val("1");
						$("#bookCmt").val("");
						$("#restSeatLabel").text("");
						$("#restSeatMessage").text("");
						
						var bookDate2=$("#bookDate").val();
						/* newnew */
						$("#afterRstName").text(rstName);
						$("#afterName").text(name);
						$("#afterBookDate").text(bookDate2);
						$("#afterBookTime").text(bookTime);
						$("#afterBookNop").text(bookNop);
						$("#afterPhone").text(phone);
						$("#afterBookCmt").text(bookCmt);
						$("#myModalTwo").modal();

						
						}
					},
					error:function(req) {
						alert("응답 오류 = "+req.status);
					}
					
				});
				
				
			}

		}
		
	
function cancel() {
	$("#bookTime").val("--:--");
	$("#inputSeat").val("1");
	$("#restSeatLabel").text("");
	$("#restSeatMessage").text("");
}


</script>
<script type="text/javascript">
        /*예약모달*/
        var now;
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth()+1; //January is 0!
        var yyyy = today.getFullYear();
        var maxDateString = mm+2<=11? (mm+2)+"/01/"+yyyy : (mm+2-12)+"/01/"+(yyyy+1);
  /*       alert( (mm+5)+"/01/"+yyyy ); 
        alert( (mm+5-12)+"/01/"+(yyyy+1) );  */
        $(function () {
            $('#datetimepicker10').datetimepicker({
                defaultDate: new Date() - 1
                , format: 'YYYY년 MM월 DD일(ddd)'
                , locale: moment.locale('ko')
                , minDate: moment(mm+"/"+dd+"/"+yyyy)                
                , maxDate: moment(maxDateString)-1
                
            });
        });
        
        $(".sbSelector").click(function() {
        	$(this).next().toggle();
        })
    </script>
