<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />

<div class="content">
	<h5>결제 완료</h5>
	<hr>
	<div>
		<table>
			<tr>
				<td colspan="4" class="separate message">결제가 완료되었습니다. 감사합니다.</td>
			</tr>
			<tr>
				<td colspan="2" class="title">주문일자</td>
				<td colspan="2">${currentTime}</td>
			</tr>
			<tr>
				<td colspan="2" class="title">주문자</td>
				<td colspan="2">${memberInfo.name}</td>
			</tr>
			<tr>
				<td colspan="2" class="title">전화번호</td>
				<td colspan="2">${memberInfo.phoneNum}</td>
			</tr>
			<tr>
				<td colspan="2" class="title">배송지</td>
				<td colspan="2">${address}</td>
			</tr>
			<tr>
				<td colspan="2" class="title">배송 요청사항</td>
				<td colspan="2">${req}</td>
			</tr>
			<tr>
				<td colspan="1" class="separate title">주문 상품</td>
				<td colspan="3" class="separate">상품 개수: ${orderQty}개</td>
			</tr>
			<c:forEach var="item" items="${orderItemsInfo}" varStatus="status"> 
				<tr>
					<td>
						<img src="${item.imageUrl}"  width="40" height="40" alt="상품이미지" class="productImg"/>
					</td>
					<td>
						${item.itemName}
					</td>
					<td>
						개수: ${orderItemQtyList[status.index]}개
					</td>
					<td>
						가격: <fmt:formatNumber value="${orderItemsPrice[status.index]}" pattern="#,###"/>원
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="1" class="separate title">결제 금액</td>
				<td colspan="3" class="separate"><fmt:formatNumber value="${totalPrice}" pattern="#,###"/>원 (적립금 적용 : <fmt:formatNumber value="${applyPoints}" pattern="#,###"/>원)</td>
			</tr>
		</table>
		<div class="bottom">
			<a href='<c:url value="/main"/>'>
				<Button class="btn btn-light order goToMainBtn">메인으로 돌아가기</Button>
			</a>
		</div>
	</div>	       
</div>