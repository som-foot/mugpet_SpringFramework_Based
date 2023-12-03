<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />

<div class="content">
	<h5>주문 목록</h5>
	<hr>
	<div class="bottom">
		<img src="${contextPath}/resources/images/alert.png" name="alertImg" width="150" height="150" alt="장바구니가 비어있습니다." /> 
	</div>
	<div class="message">
		주문 목록이 없습니다.
	</div>

	<div class="bottom">
		<a href='<c:url value="/main"/>'>
			<Button class="btn btn-light order goToMainBtn">상품 담으러 가기</Button>
		</a>
	</div>
</div>