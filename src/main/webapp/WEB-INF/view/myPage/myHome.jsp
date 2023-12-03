<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
    $(document).ready(function () {

        $(".big_menu > li").click(function () {
            $(this).next($(".small_menu")).slideToggle(300); 
            })
            	$('.small_menu > li > a').click(function(e){
            		e.stopPropagation();
            		 $(this).next($(".big_menu")).slideToggle(300); 
                })
          	})
	</script>
   

	
<div id = wrap>
<div class="container">
<div class="row">
<div id="mypage-content">
    <div id="mypage-content-list" class="row">
	    <div id="content-list" class="col-md-3 col-sm-4">
	      <div class="card" id="user-content">
	       <img src="${contextPath}/resources/images/foot.png" class="card-img-top" id="userImg">
	        <div id="user-nickname" class="card-body">
	       		 <p>${userSession.nickname }님</p>
	        </div>
		</div> 
	    </div>
	    <div id="content-list" class="col-md-3 col-sm-4">
	       <div class="card">
	        <h5 style="color:rgb(0 0 0 / 51%);">주문/배송</h5>
	        <p id="order-qty" >${orderCount }</p>
			</div>
	    </div>
	    <div id="content-list" class="col-md-3 col-sm-4">
		<div class="card" >
	        <h5 style="color:rgb(0 0 0 / 51%);"> 등록 상품</h5>
	        <p id="order-qty">${usedGoodsCount }</p>
		</div>
	    </div>
	    <div id="content-list" class="col-md-3 col-sm-4">
		<div class="card">
	        <h5 style="color:rgb(0 0 0 / 51%);">내펫관리</h5>
	        <p id="order-qty">${petName }</p>
		</div>
	    </div>
	    
    </div>
</div>
</div>

<div id="wish-title" class="row">
	
	<h4 style="color:#ff4f6894;">MY WISH LIST</h4>

</div>
<div id="wish-all-btn" class="d-grid gap-2 d-md-flex justify-content-md-end">
  <a href="${contextPath }/wish/myWishList"><button class="btn cyan rounded me-md-2" type="button" style="background-color: #FFF0F5">찜 리스트 전체보기</button></a>
</div>
<div class="row">
<div id="wishList">
<%-- <div id="wish-group-list" class="list-group">
 <c:forEach var="wishItem" items="${wishList }"  varStatus="i">
  <a href="#" id="wish-item"class="list-group-item list-group-item-action active" aria-current="true">
    <div class="row w-100 h-100">
      <div class="col-3">
     	<img src="${wishItem.imageUrl}" class="card-img-left" id="wishImg">
      </div>
      <div id="item_detail"class="col-6">
      		<p>${wishItem.itemName }</p>
    		<p class="mb-1">${wishItem.price }</p>
      </div>
      <div class="col-3">
      	<small>wish</small>
      </div>
    </div>
  </a>
  </c:forEach> --%>
  <c:if test="${not empty wishList }">
  <c:forEach var="wishItem" items="${wishList }"  varStatus="i">
  <div id="wish-item" class="row w-144 h-144">
   		<div class="col-3">
     	<img src="${wishItem.imageUrl}" class="card-img-top" id="itemImg">
      </div>
      <div class="col-6" id="wish-item-info">
    		<p id="win-1">${wishItem.itemName }</p>
    		<p>${wishItem.price }원 </p>
      </div>
      <div class="col-3 align-self-center" id="wish-go-cart">
  				<button class="btn cyan rounded" type="button" style="background-color: #FFF0F5">장바구니</button>
      </div>
  </div>
  </c:forEach>
  </c:if>
  <c:if test="${empty wishList }">

  	<div id="wish-null-img">
  			<img src="${contextPath }/resources/images/wishNull.png">
  			<p>Add your wish list!</p>
	  </div>
		
  </c:if>

  </div>
</div>	
</div>
</div>
