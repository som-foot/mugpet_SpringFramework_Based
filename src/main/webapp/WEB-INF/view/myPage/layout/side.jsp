<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
            <!-- 왼쪽 메뉴 -->
            <!-- 왼쪽 서브 메뉴 -->
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
<div class="left_sub_menu">
	 <div class="sub_menu">
           <h2>MYPAGE</h2>
           <ul class="big_menu">
               <li>내 활동 </li>
               <ul class="small_menu">
                   <li><a href="${contextPath }/wish/myWishList">마이 위시 리스트</a></li>
                   <li><a href="${contextPath }/myPage/myCommunityList">마이 작성글 리스트</a></li>
                   <li><a href="${contextPath }/myPage/myUsedGoodsList">마이 중고상품 리스트</a></li>
                   <li><a href="${contextPath }/myPage/myReplyList">마이 댓글 리스트</a></li>
               </ul>
           </ul>
           <ul class="big_menu">
               <li>내 쇼핑정보</li>
               <ul class="small_menu">
      	 		<li><a href="${contextPath }/myPage/myOrderList">마이 주문 리스트</a></li>
       	 		<%-- <li><a href="${contextPath }/myPage/myReviewList">마이 리뷰 리스트</a></li> --%>
     			</ul>
     		</ul>
           <ul class="big_menu">
               <li>내 정보관리</li>
               <ul class="small_menu">
      	 		<li><a href="${contextPath }/member/modifyMemberInfo">내 정보 수정</a></li>
       	 		<li><a href="${contextPath }/pet/modifyPetInfo">내 펫 관리</a></li>
     		   </ul>
          </ul>
    </div>
 </div>
 
 
            