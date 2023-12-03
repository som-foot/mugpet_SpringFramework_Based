<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />
<% request.setCharacterEncoding("utf-8"); %>
<script>
	function check(){
		if(document.querySelector('input[name="allowPermission"]').checked){
			return true;
		} 
		else{
			alert('주문상품 및 결제대행 이용약관에 모두 동의하십니까?');
			document.querySelector('input[name="allowPermission"]').checked = true;
		}
	}	  
</script>
<!------------------------주문 결제 창-------------------->  
<form name="orderForm" action="${contextPath}/cart/ordering?oneItem=${oneItem}&item_id=${item_id}&qty=${qty}" method="post" >
	<div class="content">
		<p class="title">주문 결제</p>
		<p class="semiTitle">주문 고객 정보</p>
		<p class="userInfo">${memberInfo.name}, ${memberInfo.phoneNum}</p> <%-- memberService에서 전달받아 사용 --%>
		<hr>
		<p class="semiTitle">배송지</p>
		${memberInfo.address} <br /><%-- memberService에서 전달받아 사용 --%>
		<input type="text" placeholder=" 상세주소 입력란" value="${command.addrDetail}" class="userInfo" name="addrDetail" style="margin-Top:10px; width:300px;" />
		<br/>
		<br/>
		<hr>
		<p class="semiTitle">배송 요청사항</p>
		<input type="radio" name="req" value="문 앞에 놔주세요."/><span class="userInfo"> 문 앞에 놔주세요.</span><br />
		<input type="radio" name="req" value="배송 전 연락주세요."/><span class="userInfo"> 배송 전 연락주세요.</span><br />
		<input type="radio" name="req" value="부재 시 경비실에 맡겨주세요."/><span class="userInfo"> 부재 시 경비실에 맡겨주세요.</span><br />
		<input type="text" name="req" placeholder=" 직접 입력" value="${command.req}" class="userInfo" style="width:200px"/><br />
		<br/>
		<hr>
		<p class="semiTitle">주문 상품</p>
		<table>
			<c:forEach var="item" items="${cartItemsInfo}" varStatus="status"> 
				<tr>
					<td>
						<a href="${contextPath}/item/itemDetail?item_id=${item.item_id}">
							<img src="${item.imageUrl}"  width="90" height="90" alt="상품이미지" class="productImg"/>
						</a>
					</td>
					<td>
						<a href="${contextPath}/item/itemDetail?item_id=${item.item_id}">
						${item.itemName}
						</a>
					</td>
					<td>
						수량 : ${cartItemsQty[status.index]}개
					</td>
					<td>
						금액 : <fmt:formatNumber value="${cartItemsPrice[status.index]}" pattern="#,###"/>원
					</td>
				</tr>
			</c:forEach>
		</table>
		<br/>		
		<p class="semiTitle">적립금 적용</p>
			<input type="text" id="point" name="point" placeholder="직접 입력" class="userInfo" value="${applyPoints}" required oninvalid="this.setCustomValidity('적립금 적용을 안할 시엔 0을 입력해주세요.')" oninput="this.setCustomValidity('')" style="width:200px"/> 원
				<button type="submit" formaction="order" name="apply" style="margin-Left:30px" class="btn btn-light order updateBtn">적용</button>
			<span class="userInfo detail">총 적립금: <fmt:formatNumber value="${memberInfo.point}" pattern="#,###"/>원</span>
			<br/>
			<span class="userInfo detail">
				적용 후 남은 적립금: <fmt:formatNumber value="${resetPoints}" pattern="#,###"/>원
			</span> 
		<br/>
		<hr>
		<p class="semiTitle">결제 금액</p>
		<span class="userInfo">총 상품액</span><span class="userInfo detail"><fmt:formatNumber value="${totalPrice}" pattern="#,###"/>원</span><br/>
		<span class="userInfo">배송비</span><span class="userInfo detail">0원 </span><br/>
		<span class="userInfo">적립금 적용</span><span class="userInfo detail">-<fmt:formatNumber value="${applyPoints}" pattern="#,###"/>원 </span><br/>
		<br/>
		<hr>
		<span class="userInfo">총 결제 금액</span><span class="userInfo detail"><fmt:formatNumber value="${totalPrice - applyPoints}" pattern="#,###"/>원</span><br/>
		<span class="userInfo">포인트 적립: <fmt:formatNumber  value="${100}" pattern="#,###"/>원</span>
		<br/>
		<br/>
		<input type="checkbox" name="allowPermission"/>주문상품 및 결제대행 이용약관에 모두 동의합니다.<br/><br/>
		<button class="btnSubmit btn btn-light order orderBtn" onclick="check()">결제하기</button>
</form>
		<br/><br/>
</div>