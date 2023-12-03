<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script>
	function userRemove(){
   		return confirm("정말 삭제하시겠습니까?");   
	}
	var myModal = document.getElementById('myModal')
	var myInput = document.getElementById('myInput')

	myModal.addEventListener('shown.bs.modal', function () {
   		myInput.focus()
	})

	$(document).on("click", ".modify", function(){
 	
 	$(".replyModal").fadeIn(200);
 
 	var repNum = $(this).attr("data-repNum");
 	var repCon = $(this).parent().parent().children(".replyContent").text();
 
 	$(".modal_repCon").val(repCon);
 	$(".modal_modify_btn").attr("data-repNum", repNum);
	});
</script>

<div style="padding: 10px;">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
	
	<h4 class="card-title" id="text1" style="font-weight: bold;">&nbsp;${community.title }</h4>
	
	<hr style="color:#BDBDBD; size: 2px;">
	
	<h6 style="color:#FFD1FF; font-weight: bold;">
	&nbsp;
	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
  	<path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"/>
	</svg>&nbsp;${nickname }</h6>
	
	<h6 style="font-weight: bold;">
	&nbsp;	
	<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 32 32">
  		<path d="M8.2881437,19.1950792 C8.38869181,19.1783212 8.49195996,19.1926955 8.58410926,19.2362761 C9.64260561,19.7368747 10.8021412,20 12,20 C16.418278,20 20,16.418278 20,12 C20,7.581722 16.418278,4 12,4 C7.581722,4 4,7.581722 4,12 C4,13.7069096 4.53528582,15.3318588 5.51454846,16.6849571 C5.62010923,16.830816 5.63909672,17.022166 5.5642591,17.1859256 L4.34581002,19.8521348 L8.2881437,19.1950792 Z M3.58219949,20.993197 C3.18698783,21.0590656 2.87870208,20.6565881 3.04523765,20.2921751 L4.53592782,17.0302482 C3.54143337,15.5576047 3,13.818993 3,12 C3,7.02943725 7.02943725,3 12,3 C16.9705627,3 21,7.02943725 21,12 C21,16.9705627 16.9705627,21 12,21 C10.707529,21 9.4528641,20.727055 8.30053434,20.2068078 L3.58219949,20.993197 Z"/>
	</svg>
	${community.replyCnt } &nbsp;
	
	<svg viewBox="0 0 32 32" width="16" height="16" xmlns="http://www.w3.org/2000/svg">
	<defs><style>.cls-1{fill:#101820;}</style></defs><title/><g data-name="Layer 54" id="Layer_54">
	<path class="cls-1" d="M16,28.72a3,3,0,0,1-2.13-.88L3.57,17.54a8.72,8.72,0,0,1-2.52-6.25,8.06,8.06,0,0,1,8.14-8A8.06,8.06,0,0,1,15,5.68l1,1,.82-.82h0a8.39,8.39,0,0,1,11-.89,8.25,8.25,0,0,1,.81,12.36L18.13,27.84A3,3,0,0,1,16,28.72ZM9.15,5.28A6.12,6.12,0,0,0,4.89,7a6,6,0,0,0-1.84,4.33A6.72,6.72,0,0,0,5,16.13l10.3,10.3a1,1,0,0,0,1.42,0L27.23,15.91A6.25,6.25,0,0,0,29,11.11a6.18,6.18,0,0,0-2.43-4.55,6.37,6.37,0,0,0-8.37.71L16.71,8.8a1,1,0,0,1-1.42,0l-1.7-1.7a6.28,6.28,0,0,0-4.4-1.82Z"/></g></svg>
	${community.likes }</h6>
   
  	<p class="card-text">&nbsp;${community.content }</p>
    <c:if test="${community.imageUrl ne null}">
   		<img style="height: 400px; width: 400px;" src="<c:url value='/upload/${community.imageUrl }'/>" class="card-img-bottom" alt=""><br>
	</c:if>
	<br>
	<small class="text-muted">&nbsp;<fmt:formatDate value="${community.enrollDt }" pattern="yyyy-MM-dd" /> 에 올라옴</small>
	
	<hr style="color: #BDBDBD; size: 2px;">
	<br>

 <!-- 세션 u_id와 community의 u_id가 같으면 글 내용 하단 버튼을 수정, 삭제로 보여줌 -->
	<c:choose>
   		<c:when test="${userSession.u_id eq community.u_id }">
      		<div class="button_box" style="float: left;">
      		<a class="btn btn-danger" role="button" style="background-color: #FFD1FF; border-color: #FFD1FF; color: white;" href="<c:url value='/community/updateForm' >
                                    <c:param name='com_id' value='${community.com_id }' />
                                    </c:url>" >수정</a>
      		<a class="btn btn-danger" role="button" style="background-color: #FFD1FF; border-color: #FFD1FF; color: white;" href="<c:url value='/community/delete' >
                                    <c:param name='com_id' value='${community.com_id }' />
                                    </c:url>" onclick="return userRemove();">삭제</a>
      		</div>
   		</c:when>
   
   		<c:when test="${userSession.u_id ne null }">
   			<div class="button_box" style="float: left;">
      			<button type="button" class="btn btn-danger" style="background-color: #FFD1FF; border-color: #FFD1FF;" data-bs-toggle="modal" data-bs-target="#staticBackdrop2">
       				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16">
        			<path d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/>
      				</svg> 좋아요!
      			</button>
      		</div>
   		</c:when>
	</c:choose>   

 <!-- 목록버튼 누르면 게시글 목록으로 이동 -->
   <div class="button_box" style="float: right;">
   		<a class="btn btn-light" style="background-color: #FFE593; border-color: #FFE593; color: white;" role="button" href="<c:url value='/community/communityList'></c:url>" >목록</a>
   </div>
   
   <br><br><br>
   <div class="clearfix"></div>
    <div class="col-md-12 col-sm-12">
        <div class="comment-wrapper">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <strong>&nbsp;댓글 창</strong>
                </div>
                <!-- 댓글 입력 -->
                <div class="panel-body">
                <!-- 나머지 파라미터 넘겨주기 -->
                <input type="hidden" name="com_id" value='${community.com_id}' />
                <form name="form" method="POST" action="<c:url value='/community/replyInsert' > <c:param name='com_id' value='${community.com_id }'/></c:url>">
             	
                	<div class="input-group" style="width: 60%;">
  						<span class="input-group-text">댓글</span>
 						<textarea name="content" class="form-control" rows="3"  placeholder="댓글을 작성해주세요" aria-label="With textarea"></textarea>
					</div>

                    <br>
                    
                    <!-- 댓글 등록 버튼 -->
                    <button type="submit" class="btn btn-danger" style="background-color: #FFD1FF; border-color: #FFD1FF;" type="submit">등록</button>
                
                    </form>
                    
                    <div class="clearfix"></div>
                    <hr>
                    <ul class="media-list">
                    
                    <!-- 댓글 작성된 리스트 출력 -->
                    <c:forEach var="reply" items="${replyList}" varStatus="status">
                    
                        <li class="media">
                            <div class="media-body">
                                <span class="text-muted pull-right">
                                    <strong class="text-success"> ${rp_nicknameList[status.index] }</strong>
                                </span>
                                <small class="text-muted"><fmt:formatDate value="${reply.enrollDt }" pattern="yyyy-MM-dd" /></small>
                                
                                <!-- 댓글 삭제버튼 -->
								<c:if test="${userSession.u_id eq reply.u_id }">
								<div class="button_box" style="float: right;">								
								<a class="btn btn-danger btn-sm" role="button" style="background-color: #FFD1FF; border-color: #FFD1FF;" href="<c:url value='/community/replyDelete' >
								<c:param name='rp_id' value='${reply.rp_id }' />
								<c:param name='com_id' value='${reply.com_id }' />
								</c:url>" onclick="return userRemove();">삭제</a>
								</div>
                                </c:if>
                                <p>
                                    ${reply.content}
                                </p>
                            
  
                        </div>
                        </li>
                        
                        </c:forEach>
                        
                    </ul>
                </div>
            </div>
        </div>

    </div>
   </div>
   
   <!-- 위시 기능 -->
<div class="modal fade" id="staticBackdrop2" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">좋아요 클릭!</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        좋아요~!
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
        <a class="btn btn-danger" style="background-color: #FFD1FF; border-color: #FFD1FF; color: white;" role="button" href="<c:url value='/community/likes'>
        <c:param name='com_id' value='${community.com_id }'/>
        </c:url>">추가</a>
      </div>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>