<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.spring.mugpet.domain.*"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% pageContext.setAttribute("newLineChar", "\\n"); %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />

<table class="itemInfoTable">
	<tr>
		<td rowspan="6" id="itemImgBox">
			<img src="${item.imageUrl}" class="card-img-top" id="itemImg">
		</td>
		<td colspan="2" style="height:60px;"></td>
	</tr>
	<tr>
		<td id="info1">
			<span id="spe">${spe}</span><br/>
			<span id="brand">${item.brand}</span><br/>
			<span id="itemName">${item.itemName}</span><br/>
		</td>
	</tr>
	<tr>
		<td id="price">
			<fmt:formatNumber value="${item.price}" pattern="#,###"/>원
		</td>
	</tr>
	<tr>
		<td id="comments">${fn:replace(item.comments, newLineChar, "<br/>")}</td>
	</tr>
	<tr>
		<td id="qtyBox">
			<div id="qtyBtns" class="input-group mb-3">
  				<button type="button" id="minus" onclick="updateQty(-1, ${item.price})" class="btn btn-outline-secondary" >-</button>
  				<input type="text" id="itemQty" class="form-control" value="1" readonly/>
  				<button type="button" id="plus" onclick="updateQty(1, ${item.price})" class="btn btn-outline-secondary" >+</button>
			</div>
		</td>
	</tr>
	<tr>
		<td id="totalPrice">
			<span id="qtyLabel">총 수량<span id="qty">1</span>개</span>&nbsp;
			<span id="price2">
				<span id="total"><fmt:formatNumber value="${item.price}" pattern="#,###"/></span>원
			</span>
		</td>
	</tr>
	<tr>
		<td colspan="2" id="btnBox">
			<c:if test="${userSession.u_id eq 0}">
				<img id="wishBtn" onclick="goLogin(${item.item_id})" src="${contextPath}/resources/images/wish.png" />
			</c:if>
			<c:if test="${userSession.u_id ne 0}">
				<a href="${contextPath}/wish/updateWish?item_id=${item.item_id}&isWish=${isWish}">
					<c:if test="${isWish eq 0}">
						<img id="wishBtn" src="${contextPath}/resources/images/wish.png" />
					</c:if>
					<c:if test="${isWish eq 1}">
						<img id="wishBtn" src="${contextPath}/resources/images/wished.png" />
					</c:if>
				</a>
			</c:if>
			
			<!-- 장바구니 및 구매하기 버튼 -->
			<c:if test="${userSession.u_id eq 0}">
				<input type="button" value="장바구니" onclick="goLogin(${item.item_id})" class="btn btn-primary" id="cartBtn"/>
				<input type="button" value="구매하기" onclick="goLogin(${item.item_id})" class="btn btn-primary" id="buyBtn"/>
			</c:if>
			<c:if test="${userSession.u_id ne 0}">
					<input type="button" value="장바구니" onclick="goLocation(${item.item_id}, 1)" class="btn btn-primary" id="cartBtn"/>
					<input type="button" value="구매하기" onclick="goLocation(${item.item_id}, 2)" class="btn btn-primary" id="buyBtn"/>
			</c:if>
				
		</td>
	</tr>
</table>
<script>
	const pathname = "/" + window.location.pathname.split("/")[1];
	const origin = window.location.origin;
	const contextPath = origin + pathname;
	
	function goLogin(item_id)  {
		let want = confirm("해당 서비스는 로그인이 필요합니다.\n로그인하시겠습니까?");
		if (want) {
			location.href = contextPath + "/member/login?item_id=" + item_id;
		} else {
			history.go(0);
		}
	}
	
	function goLocation(item_id, temp) {
		var qty = parseInt(document.getElementById("itemQty").value, 10);
		var name = document.getElementById("itemName").value;
		
		if (temp == 1) {
			let want = confirm("장바구니에 상품을 담았습니다.\n장바구니로 이동하시겠습니까?");
			if (want) {
				location.href = contextPath + "/cart/insertCart?item_id=" + item_id + "&qty=" + qty + "&tmp=1";	
			} else {
				location.href = contextPath + "/cart/insertCart?item_id=" + item_id + "&qty=" + qty + "&tmp=0";	
			}
		} else {
			location.href = contextPath + "/order/orderItem?item_id=" + item_id + "&qty=" + qty;
		}
	}
	
	function updateQty(tmp, price) {
		var qty = document.getElementById("itemQty");
		var num = parseInt(qty.value, 10);
		
		var qtyLabel = document.getElementById("qty");
		var total = document.getElementById("total");
		
		if (tmp == 1) {
			num++;
		} else {
			if (num == 0) {
				num = 0;
			} else {
				num--;
			}
		}
		qty.value = num;
		qtyLabel.innerHTML = num;
		total.innerHTML = (num * price).toLocaleString();;
	}
</script>