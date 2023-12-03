<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 쓴 댓글목록</title>
</head>
<body>

<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>댓글 내용</th>
			<th>작성일</th>
		</tr>
	</thead>
	
	<tbody>
	
		<c:forEach items="${replyList}" var="reply">
			<tr>
				<td>${reply.rp_id}</td>
				<td>${nickname }</td>
				<td>
				<c:choose>
					<c:when test="${reply.com_id ne 0 }">
						<a href="${contextPath }/community/view?com_id=${reply.com_id }">${reply.content }</a>
					</c:when>
					<c:when test="${reply.g_id ne 0 }">
						<a href="${contextPath }/usedGoods/view?g_id=${reply.g_id }">${reply.content }</a>
					</c:when>
				</c:choose>
				</td>
				<td>
					<fmt:formatDate value="${reply.enrollDt}" pattern="yyyy-MM-dd" />				
				</td>
			</tr>
		</c:forEach>
	
	</tbody>

</table>

</body>
</html>