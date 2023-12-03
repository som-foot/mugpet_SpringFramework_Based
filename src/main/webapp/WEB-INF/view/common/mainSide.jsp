<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<div id="category">
	<div class="btn-group">
		<button type="button" class="btn btn-danger dropdown-toggle" id="categoryBtn"
				data-bs-toggle="dropdown" aria-expanded="false">
			${spe}
		</button>
		<ul class="dropdown-menu">
			<li><a class="dropdown-item" href="${contextPath}/main/speId?spe_id=<%=1%>">강아지</a></li>
			<li><a class="dropdown-item" href="${contextPath}/main/speId?spe_id=<%=2%>">고양이</a></li>
			<li><a class="dropdown-item" href="${contextPath}/main/speId?spe_id=<%=3%>">소동물</a></li>
		</ul>
	</div>
	<div id=category_name>
		<a href="${contextPath}/item/itemList?spe_id=${spe_id}&category_id=<%=1%>">사료</a><br /> 
		<a href="${contextPath}/item/itemList?spe_id=${spe_id}&category_id=<%=2%>">간식</a><br /> 
		<a href="${contextPath}/item/itemList?spe_id=${spe_id}&category_id=<%=3%>">건강관리</a><br /> 
		<a href="${contextPath}/item/itemList?spe_id=${spe_id}&category_id=<%=4%>">하우스/이동장</a><br /> 
		<a href="${contextPath}/item/itemList?spe_id=${spe_id}&category_id=<%=5%>">화장실/위생</a><br /> 
		<a href="${contextPath}/item/itemList?spe_id=${spe_id}&category_id=<%=6%>">의류/리드줄</a><br /> 
		<a href="${contextPath}/item/itemList?spe_id=${spe_id}&category_id=<%=7%>">장난감</a><br />
		<a href="${contextPath}/community/communityList">커뮤니티</a><br /> 
		<a href="${contextPath}/usedGoods/usedGoodsList">중고거래</a><br />
	</div>
</div>
