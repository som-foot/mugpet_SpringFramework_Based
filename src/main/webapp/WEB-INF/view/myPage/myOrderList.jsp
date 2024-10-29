<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />

<div class="content">
	<h5>주문 목록</h5>
	<hr>
	<div>
		<c:forEach var="map" items="${orderItemsInfoList}" varStatus="status"> 
			<table>
			<tr>
				<td colspan="4" class="separate title">주문일자 ${map.key}</td>
			</tr>
			<tr>
				<td colspan="2" class="title">주문자</td>
				<td colspan="2">${userSession.name}</td>
			</tr>
			<tr>
				<td colspan="2" class="title">전화번호</td>
				<td colspan="2">${userSession.phoneNum}</td>
			</tr>
			<tr>
				<td colspan="2" class="title">배송지</td>
				<td colspan="2">${map.value[0].orderAddr}</td>
			</tr>
			<tr>
				<td colspan="2" class="title">배송 요청사항</td>
				<td colspan="2">${map.value[0].req}</td>
			</tr>
			<tr>
				<td colspan="1" class="separate title">주문 상품</td>
				<td colspan="3" class="separate">상품 개수: ${itemsSize[status.index]}개</td>
			</tr>
			<c:forEach var="row" items="${map.value}" varStatus="rowStatus">
				<tr>
					<td> 
						<a href="${contextPath}/item/itemDetail?item_id=${row.item_id}">
							<img src="${row.imageUrl}"  width="50" height="50" alt="상품이미지" class="productImg"/>
						</a>
					</td>
					<td>
						<a href="${contextPath}/item/itemDetail?item_id=${row.item_id}">
							${row.itemName}
						</a>
					</td>
					<td>${row.orderQty}개</td>
					<td><fmt:formatNumber value="${map.value[rowStatus.index].itemPrice}" pattern="#,###"/>원</td>
				</tr>
			</c:forEach>
				<tr>
					<td colspan="1" class="separate title">결제 금액</td>
					<td colspan="3" class="separate">
						<fmt:formatNumber value="${orderItemsPrice[status.index] - map.value[0].applyPoints}" pattern="#,###"/>원 
						(적립금 적용 : <fmt:formatNumber value="${map.value[0].applyPoints}" pattern="#,###"/>원) 
					</td>
				</tr>
			</table>
		</c:forEach>
	</div>	       
</div>

