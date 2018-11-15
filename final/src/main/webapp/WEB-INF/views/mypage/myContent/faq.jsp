<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- PAGE TITLE SECTION -->
<section class="clearfix pageTitleSection" style="background-image: url();">
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="pageTitle">
					<h2>FAQ</h2>
				</div>
			</div>
		</div>
	</div>
</section>

<!-- TERMS INFO SECTION -->
<section class="clearfix termsInfoSection">
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<ul class="list-unstyled termsList">
					<c:forEach var="faq" items="${faqList }">
					<li>
						<h3>${faq.content }</h3>
						<p>${faq.reply }</p>
					</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</section>


