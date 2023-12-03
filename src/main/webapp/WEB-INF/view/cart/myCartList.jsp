<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>

<div class="content">
	<h5>장바구니</h5></br>
	<div>
		 전체 상품 수 ( <span id='result'>${cartItemSize}개</span> ) 
	      <span class="remove">
	      		선택 삭제
	      </span>
	</div>	       
	<hr>
	<table>
		<form name="cart" action='<c:url value="/cart/updateCartQuantities"/>' method="post">
			<c:forEach var="item" items="${cartItemsInfo}" varStatus="status"> <%-- foreach문으로 item 목록을 가져와서 출력 --%>
				<tr>
					<td>
						<br/>
						<a href='<c:url value="/cart/removeItemFromCart"><c:param name="item_id" value="${item.item_id}"/></c:url>'>
							<button type="button" class="remove">
								<label for="remove">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-dash-square" viewBox="0 0 16 16">
								  		<path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
								  		<path d="M4 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 4 8z"/>
									</svg>
								</label>
							</button>
						</a>
						<div>
							<div class="item">
								<div class="productQty">
									<a href="${contextPath}/item/itemDetail?item_id=${item.item_id}">
										<img src="${item.imageUrl}"  width="150" height="150" alt="상품이미지" class="productImg"/>
									</a>
									<br/>
									개수 :
									<input type="text" name="${status.index}" value="${cartItemsQty[status.index]}" style="text-align:center; width:50px;"/>
								</div>
									<span class="productName">
									<a href="${contextPath}/item/itemDetail?item_id=${item.item_id}">
										<c:out value="${item.itemName}" />
									</a>
									</span>
								
									<span class="productPrice">
										<fmt:formatNumber value="${cartItemsPrice[status.index]}" pattern="#,###"/>원
									</span>
									<br/>
							</div>
						</div>
						<br />
					</td>
				</tr>
			</c:forEach>
		</table>
	<div class="bottom">
	  <div>
	  	<button type="submit" class="btn btn-light order updateBtn">카트 업데이트</button>
	  </div>
</form>	
	 <br/>
		<div class="spacing">
			<fmt:formatNumber value="${totalPrice}" pattern="#,###"/>원 + 배송비 무료 = <fmt:formatNumber value="${totalPrice}" pattern="#,###"/>원
		</div>
		<br /><br />
		<a href='<c:url value="/cart/order"/>'>
			<button type="button" class="btn btn-light order orderBtn">주문하기</button>
		</a>
		<br /><br />
	</div>
</div>
<div>
	<c:choose>
		<c:when test="${isCart eq null}">
			<span id="hidden">-1</span>
		</c:when>
		<c:otherwise>
			<span id="hidden">${isCart}</span>
		</c:otherwise>
	</c:choose>
</div>
<script>
window.onload = function(){
	var isCart = document.getElementById("hidden").innerHTML;
	if (isCart === "1") {
		alert("이미 장바구니에 추가된 상품입니다.");
	}
}
</script>