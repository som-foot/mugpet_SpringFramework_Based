<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />
<%--위시 리스트 창 --%>
<div class="content">
	<h5>위시 리스트</h5><br/>
	<hr>
	<p class="wish">상품</p>
	<table>
		<tr>
		<c:forEach var="wishItem" items="${wishItemsInfo}" varStatus="status"> <%-- foreach문으로 item 목록을 가져와서 출력 --%>	
			<td>
				<div class="item">
					<span class="product">
					<a href='<c:url value="/wish/deleteWish"><c:param name="item_id" value="${wishItem.item_id}"/></c:url>'>
						<button type="button" class="wishImg">
							<img src="${contextPath}/resources/images/wished.png" name="wishImg" width="20" height="20" alt="찜" /> 
						</button>
					</a>
					</span>
					<br/>
					<a href='<c:url value="/item/itemDetail"><c:param name="item_id" value="${wishItem.item_id}"/></c:url>'>
						<img src="${wishItem.imageUrl}"  width="150" height="150" alt="상품이미지" class="productImg"/>
						<br/>
						
						<span class="productName">
							<c:out value="${wishItem.itemName}"/>
						</span>
						<br/>
						<span class="productPrice">
							<fmt:formatNumber type="number" value="${wishItem.price}" pattern="#,###"/>원
						</span>
					</a>
				</div>
			</td>
			<c:if test="${status.count % 3 == 0}">
				<c:out value="</tr><tr>" escapeXml="false"/>
			</c:if>
		</c:forEach>
	</table>
	<hr>
</div>