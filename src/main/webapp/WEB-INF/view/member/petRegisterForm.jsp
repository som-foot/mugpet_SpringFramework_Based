<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />
	
	<form:form modelAttribute="petRegisterForm" method="post" enctype="" class="validation-form" action="${contextPath }/pet/petRegister">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-3">펫 등록</h4>
   
        <div class="frame">
			<input type="radio" name="species" value="1" />강아지
			<input type="radio" name="species" value="2" />고양이 
			<input type="radio" name="species" value="3" />소동물
		</div>

          <div class="mb-3">
            <label for="name">이름</label>
            <form:input path="pet.name" class="form-control" placeholder="이름을 입력해주세요." value="" required="true" />
            <div class="invalid-feedback">
              이름을 입력해주세요.
            </div>
          </div>

          <div class="mb-3">
            <label for="birth">생년월일</label>
            <form:input path="pet.birth" class="form-control" placeholder="생년월일을 입력해주세요." required="true" />
            <div class="invalid-feedback">
              생년월일을 입력해주세요.
            </div>
          </div>
<!--           <div class="mb-3">
            <label for="species">종류</label>
            <input id="species" class="form-control" placeholder="종류를 입력해주세요." required="true" />
			</div> -->
          <div class="mb-4"></div>
          <button class="btn btn-primary btn-lg btn-block" type="submit">회원가입 완료</button>
      </div>
	</div>
	</form:form>