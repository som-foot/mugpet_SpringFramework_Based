<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
	
	<form:form method="post" class="validation-form" action="${contextPath}/member/login">
    <div class="box">
		<h1>LOGIN</h1>
	   	 <c:if test="${!empty signonForwardAction}">
	      	<input type="hidden" name="forwardAction"
	        	value='<c:url value="${signonForwardAction}"/>' />
	    	</c:if>
			email : <input type="text" id="email" name="email"><br>
			PASSWORD : <input type="password" id="pwd" name="pwd"><br>
			<button type="submit" value="Login">Login</button>
	  </div>
	  <input type="hidden" name="item_id" value="${item_id}" />
	</form:form>
