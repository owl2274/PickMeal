<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<style type="text/css">



.col-sm-6 {
	width: 100%;
	max-width: 700px;
}

.form-control[disabled]{
	cursor: default;
}

/* button.activeForm{
	display:inline;
} */
button.nonActive{
	display:none;
}

.col-xs-1{
	width:33%;
}

@media (min-width: 768px){
	.col-sm-1, .col-sm-10, .col-sm-11, .col-sm-12, .col-sm-2, .col-sm-3, .col-sm-4, .col-sm-5, .col-sm-6, .col-sm-7, .col-sm-8, .col-sm-9 {
	    float:none;
	    margin: 0 auto; 
	}
}
.form-control::-ms-input-placeholder { color: black; }
.form-control::-webkit-input-placeholder { color: black; } 
.form-control::-moz-placeholder { color: black; }
</style>
<section class="clearfix bg-dark profileSection">
			<div class="col-md-8 col-sm-7 col-xs-12">
					<div class="dashboardBoxBg">
						<div class="profileIntro">
							<h2>Your Profile</h2>
							<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form Ipsum available.</p>
						</div>
					</div>
					<div class="dashboardBoxBg mt30">
						<div class="profileIntro">
							<h3>기본 정보</h3>
							<div class="row">
								<div class="form-group col-sm-6 col-xs-12">
									<label for="idProfile">아이디</label>
									<input type="text" class="form-control" id="idProfile" placeholder="${loginMember.id }" disabled>
								</div>
								<form:form action="${pageContext.request.contextPath}/modifyMember" id="modifyMemberForm" method="POST" modelAttribute="member">
									<div class="form-group col-sm-6 col-xs-12">
									
										<label for="name">이름&nbsp;&nbsp;&nbsp;
										<form:errors path="name"/><span class="nameMessage message"></span></label>
										<form:input path="name" class="form-control" value="${loginMember.name}" disabled="true" />									
									</div>
									<div class="form-group col-sm-6 col-xs-12">
									
										<label for="email">이메일주소&nbsp;&nbsp;&nbsp;
										<form:errors path="email"/><span class="emailMessage message"></span></label>
										<form:input path="email" class="form-control" value="${loginMember.email}" disabled="true"/>									
									</div>
									
									<div class="form-group col-sm-6 col-xs-12">
										<div><label for="emailAdress" class="control-label">핸드폰번호&nbsp;&nbsp;&nbsp;
										<form:errors path="phone2"/><span  class="phone2Message message"></span>
										<form:errors path="phone3"/><span  class="phone3Message message"></span></label></div>
                                        <div class="col-xs-1 col-md-2">
                                    
											<form:select class="form-control col-xs-6" path="phone1" disabled="true">
			                                    <option value="010" <c:if test='${loginMember.phone1 eq "010"}'>selected</c:if>>010</option>
			                                    <option value="016" <c:if test='${loginMember.phone1 eq "016"}'>selected</c:if>>016</option>
			                                    <option value="011" <c:if test='${loginMember.phone1 eq "011"}'>selected</c:if>>011</option>
			                                    <option value="017" <c:if test='${loginMember.phone1 eq "017"}'>selected</c:if>>017</option>
			                                    <option value="018" <c:if test='${loginMember.phone1 eq "018"}'>selected</c:if>>018</option>
			                                    <option value="019" <c:if test='${loginMember.phone1 eq "019"}'>selected</c:if>>019</option>
	                                    	</form:select>
                                        </div>
                                       
                                        <div class="col-xs-1 col-md-2">
                                        	<form:input path="phone2" class="form-control" value="${loginMember.phone2}" size="4" disabled="true"/>
                                        </div>
                                           
                                        <div class="col-xs-1 col-md-2">
                                        	<form:input path="phone3" class="form-control" value="${loginMember.phone3}" size="4" disabled="true"/>
                                        </div>
                                            
									</div> 
									<hr>
						
									<div class="form-group col-sm-6 col-xs-12">
										<div class="changeUse">
											<button type="button" class="btn btn-primary showFormBtn modify">변경 </button>
										</div>
										<div class="changeDontUse" style="display:none;">
											<button type="submit" class="btn btn-primary modifyBtn modify">변경 </button>
											<button type="button" class="btn btn-primary cancelBtn modify">취소 </button>
										</div>
									</div>
								</form:form>
	
							</div>
						</div>
					</div>
					<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
					<script type="text/javascript" src="${pageContext.request.contextPath}/js/debugTool.js"></script>
					<script type="text/javascript">
 					$(".showFormBtn").click(function() {
						$(this).parentsUntil("form").find("div.changeUse").hide();
						$(this).parentsUntil("form").find("div.changeDontUse").show();
						
						$(this).parentsUntil("div.row").find(".form-control").prop("disabled",false);
					/* 	$(this).parentsUntil("div.row").find("input").prop("disabled",false); */
					});
					
					$(".cancelBtn").click(function() {
						$("div.changeUse").show();
						$("div.changeDontUse").hide();
						$(this).parentsUntil("div.row").find(".form-control").prop("disabled",true);
					/* 	$(this).parentsUntil("div.row").find("input").prop("disabled",true); */
					});
					

					//resultSelector($(".showFormBtn").parentsUntil("div.row"));
					</script>
					
					<div class="dashboardBoxBg mt30">
						<div class="profileIntro">
							<h3>Update password&nbsp;&nbsp;&nbsp;&nbsp;<span class="messageForUP">${messageForUP }</span></h3>
							<form action="${pageContext.request.contextPath}/modifyPassword" method="POST" id="modifyPasswordForm">
						<%-- 	<form:form action="${pageContext.request.contextPath}/modifyPassword" method="POST" id="modifyPasswordForm" modelAttribute="member"> --%>
								<div class="row">
									<div class="form-group col-xs-12">
										<label for="curPassword">Current Password&nbsp;&nbsp;&nbsp;&nbsp;</label><span class="curPasswordMessage"></span></label>
										<input type="password" id="curPassword" name="curPassword" class="form-control" />
									</div>
									<div class="form-group col-xs-12">
										<label for="newPassword">New Password&nbsp;&nbsp;&nbsp;&nbsp;</label><span class="newPasswordMessage">${newPasswordMessage }</span></label>
										<input type="password" id="newPassword" name="newPassword" class="form-control"/>
									</div>
									<div class="form-group col-xs-12">
								 		<label for="confirmPassword">Confirm Password&nbsp;&nbsp;&nbsp;&nbsp;<span id="passwordReMsg" class="confirmPasswordMessage"></span></label>
										<input type="password" id="confirmPassword" name="confirmPassword" class="form-control" />
										<div class="form-group col-xs-12">
											<button class="btn btn-primary" type="submit">Change Password</button>
										</div>
									</div>
								</div>
						<%-- 	</form:form> --%>
							</form>
<%-- 							<form action="">
								<div class="row">
									<div class="form-group col-xs-12">
										<label for="currentPassword">Current Password</label>
										<input type="password" class="form-control" id="currentPassword" placeholder="********">
									</div>
									<div class="form-group col-xs-12">
										<label for="newPassword">New Password</label>
										<input type="password" class="form-control" id="newPassword" placeholder="New Password">
									</div>
									<div class="form-group col-xs-12">
										<label for="confirmPassword">Confirm Password</label>
										<input type="password" class="form-control" id="confirmPassword" placeholder="Confirm Password">
									</div>
									<div class="form-group col-xs-12">
										<button class="btn btn-primary" type="button">Change Password</button>
									</div>
								</div>
							</form> --%>
							<script type="text/javascript">
							$("#modifyMemberForm").submit(function() {
								result=true;
								var emailReg=/[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;

								$(".nameMessage").text("");
								$(".emailMessage").text("");
								$(".phone2Message").text("");
								
								if($("#name").val() == ""){
									$(".nameMessage").text("이름을 입력해 주세요");
									result=false
								}
								
								if($("#email").val() == ""){
									$(".emailMessage").text("이메일을 입력해 주세요");
									result=false
								}else if (!emailReg.test($("#email").val())) {
									$(".emailMessage").text("형식에 맞게 입력해 주세요");
									result=false;
								}
								
								var mobileReg=/^\d{4}$/;
							 	if($("#phone2").val() =="" || $("#phone3").val() ==""){
							 		$(".phone2Message").text("전화번호를 입력해 주세요");
							 		result=false;
							 	}else if ( !mobileReg.test($("#phone2").val()) || !mobileReg.test($("#phone3").val()) ) {
							 		$(".phone2Message").text("형식에 맞게 입력해 주세요");
									result=false;
								}
								
								return result;
							});
							
							
					 		 $("#modifyPasswordForm").submit(function() {
									var result=true;
							
									$(".curPasswordMessage").text("");
									$(".newPasswordMessage").text("");
									$(".confirmPasswordMessage").text("");
									var passwordReg=
										/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$/;
										
									
									if($("#curPassword").val()==null || $("#curPassword").val()=="" ){
										$(".curPasswordMessage").text("반드시 입력해 주세요!");
										result=false;
									}
									
									if($("#newPassword").val()==null || $("#newPassword").val()=="" ){
										$(".newPasswordMessage").text("반드시 입력해 주세요!");
										result=false;
									}else if(!passwordReg.test($("#newPassword").val())){
										$(".newPasswordMessage").text("형식에 맞게 입력해 주세요");
										result=false;
									}
									
									
									if($("#confirmPassword").val()==null || $("#confirmPassword").val()=="" ){
										$(".confirmPasswordMessage").text("반드시 입력해 주세요");
										result=false;
									}else if($("#confirmPassword").val()!=$("#newPassword").val()){
										$(".confirmPasswordMessage").text("일치하지 않습니다");
										result=false;
									}				
									
									
									return result;								 
								});
							</script>
						</div>
					</div>
			</div>
		
</section>

