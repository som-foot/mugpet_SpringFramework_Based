<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.spring.mugpet.domain.*"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />

<div id="orderBy">
	<button class="btn btn-secondary btn-sm dropdown-toggle" type="button" id="orderBtn" 
			data-bs-toggle="dropdown" aria-expanded="false">
    	${standard}
 	</button>
 	<ul class="dropdown-menu" style="font-size:14px;">
 		<li><a class="dropdown-item" href="${contextPath}/item/orderByItem?spe_id=${spe_id}&category_id=${category_id}&stand=item_id&od=ASC&isFiltering=${isFiltering}">기본순</a></li>
		<li><a class="dropdown-item" href="${contextPath}/item/orderByItem?spe_id=${spe_id}&category_id=${category_id}&stand=itemName&od=ASC&isFiltering=${isFiltering}">이름순</a></li>
		<li><a class="dropdown-item" href="${contextPath}/item/orderByItem?spe_id=${spe_id}&category_id=${category_id}&stand=price&od=ASC&isFiltering=${isFiltering}">가격낮은순</a></li>
		<li><a class="dropdown-item" href="${contextPath}/item/orderByItem?spe_id=${spe_id}&category_id=${category_id}&stand=price&od=DESC&isFiltering=${isFiltering}">가격높은순</a></li>
	</ul>
</div>

<c:if test="${itemList.size() eq 0}">
	<div class="content">
		<div class="bottom">
			<img src="${contextPath}/resources/images/alert.png" name="alertImg" width="150" height="150" /> 
		</div>
		<div class="message">
			해당되는 상품이 없습니다!
		</div>
	</div>
</c:if>
		
<div id="itemList">
	<div id="itemCards">
		<c:forEach var="item" items="${itemList}" varStatus="i">
			<a href="${contextPath}/item/itemDetail?item_id=${item.item_id}">
			<div class="card" id="itemCard">
				<img src="${item.imageUrl}" class="card-img-top" id="itemImg">
				<div class="card-body">
					<p class="card-text">
						<span id="itemName">
							<c:choose>
								<c:when test="${fn:length(item.itemName) > 26}">
									<c:out value="${fn:substring(item.itemName,0,25)}" />...
								</c:when>
								<c:otherwise>
									${item.itemName}
								</c:otherwise>
							</c:choose>
						</span><br/>
  						<span id="brand">${item.brand}</span><br/>
  						<span id="price"><fmt:formatNumber value="${item.price}" pattern="#,###"/>원</span>
					</p>
				</div>
			</div>
			</a>
		</c:forEach>
	</div>
</div>