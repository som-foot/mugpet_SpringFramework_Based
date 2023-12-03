<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="cardList">
	<div class="row row-cols-1 row-cols-md-3 g-4">
		<input type="hidden"/>
		<c:forEach var="community" items="${myComList }">
  				<div class="col">
    				<div class="card h-100" style="width: 330px;">
      					<c:if test="${community.imageUrl ne null }">
    						<img style="heigth: 200px; width: 200px;" src="<c:url value='/upload/${community.imageUrl}'/>" class="card-img-top" alt="" onerror="">
      					</c:if>	      						
      					<div class="card-body">
        						<h6 style="font-weight: bold;" class="card-title">${community.title }</h6>
        						<p class="card-text" style="color: #FFD1FF; font-weight: bold;">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
  								<path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"/>
								</svg>${nickname }</p>
        						<a href="<c:url value='/community/view'>
						   			<c:param name='com_id' value='${community.com_id}'/>
				 				 	</c:url>" class="btn btn-outline-danger" style="background-color: #FFD1FF; border-color: #FFD1FF; color:white;">자세히보기</a>
      						</div>
    					</div>
  				</div>	
  		</c:forEach>
	</div>
<br>

	<div class="button_box">
		<a href="<c:url value='/community/writeForm' />" type="button" class="btn btn-danger" style="background-color: #FFD1FF; border-color: #FFD1FF; color: white;">글쓰기</a>
	</div> 
</div>