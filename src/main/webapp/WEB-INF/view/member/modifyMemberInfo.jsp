<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />


	<form:form modelAttribute="modifyMemberInfoForm" method="post" enctype="multipart/form-data" class="validation-form" action="${contextPath }/member/modifyMemberInfo">
 
      <div class="input-form col-md-12 mx-auto">

        <h4 class="mb-3">회원정보 수정</h4>
        <div class="col-xs-6 profileplace">
			<img class="img-responsive center-block" id="default_photo" name="m_photo" src="${contextPath }/resources/images/person.png">
			<input type = "file" name = "imgFile" multiple="multiple" accept=".jpg, .png"/><br>
		</div>
          <div class="row">
            <div class="col-md-6 mb-3">
              <label for="name">이름</label>
              <form:input path="account.name" class="form-control" id="name" placeholder="이름을 입력하세요" value="" required="true" />
              <form:errors path="account.name" cssClass="error"/>
              <div class="invalid-feedback">
                이름을 입력해주세요.
              </div>
            </div>
            <div class="col-md-6 mb-4">
              <label for="nickname">별명
              </label>
              <form:input path="account.nickname" class="form-control" id="nickname" placeholder="닉네임을 입력하세요" value="" required="true" onchange= "isCheckNickName()"/>
              <form:errors path="account.nickname" cssClass="error"/>
             	<span class="nickname_ok">사용 가능한 닉네임입니다.</span>
             	 <span class="nickname_already">누군가 이 닉네임을 사용하고 있어요.</span>
              <div class="invalid-feedback">
                별명을 입력해주세요.
              </div>
            </div>
          </div>

          <div class="mb-3">
            <label for="email">이메일</label>
            <form:input path="account.email" class="form-control" name="email" id="email" placeholder="you@example.com" required="true" onchange= "isCheckEmail()" />
            <span class="id_ok">사용 가능한 이메일입니다.</span>
			<span class="id_already">누군가 이 이메일을 사용하고 있어요.</span>
            <form:errors path="account.email" cssClass="error" />
            <div class="invalid-feedback">
              이메일을 입력해주세요.
            </div>
          </div>

          <div class="mb-3">
            <label for="pwd">비밀번호</label>
            <form:password path="account.pwd" class="form-control" id="pwd" placeholder="비밀번호를 입력하세요" required="true" />
             <form:errors path="account.pwd" cssClass="error" />
            <div class="invalid-feedback">
              비밀번호를 입력해주세요.
            </div>
          </div>
          <div class="mb-3">
            <label for="checkPwd">비밀번호 확인</label>
            <form:password path="repeatedPassword" class="form-control" id="checkPwd" placeholder="비밀번호를 입력하세요" required="true" />
            <form:errors path="repeatedPassword" cssClass="error" />
            <div class="invalid-feedback">
           		비밀번호를 입력해주세요.
            </div>
          </div>
          
          <div class="mb-3">
            <label for="phoneNum">핸드폰 번호</label>
            <form:input path="account.phoneNum" class="form-control" id="phoneNum" placeholder="핸드폰 번호를 입력해주세요." required="true" onchange= "isCheckPhone()"/>
            <form:errors path="account.phoneNum" cssClass="error" />
			<span class="phoneNum_ok">사용 가능한 번호입니다.</span>
			<span class="phoneNum_already">누군가 이 번호를 사용하고 있어요.</span>
            <div class="invalid-feedback">
              핸드폰번호를 입력해주세요.
            </div>
          </div>
          <div class="mb-3">
            <label for="address">주소</label>
            <form:input path="account.address" class="form-control" id="address" placeholder="주소를 입력해주세요." required="true" />
            <form:errors path="account.address" cssClass="error" />
            <div class="invalid-feedback">
              주소를 입력해주세요.
            </div>
          </div>

          <hr class="mb-4">
         
          <button class="btn btn-primary btn-lg btn-block" type="submit">수정하기</button>
      </div>
	</form:form>
	
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script>
		function isCheckEmail() {
			var email = $('#email').val();
			
			$.ajax({
				url: "${pageContext.request.contextPath}/member/isCheckDuplicatedEmail",
				type:'post',
				data:{email:email},
				success:function(email) {
					if(email == 0) {
	                    $('.id_ok').css("display","inline-block"); 
	                    $('.id_already').css("display", "none");
					}
					else {
	                    $('.id_already').css("display","inline-block");
	                    $('.id_ok').css("display", "none");
	                    alert("이메일을 다시 입력해주세요");
	                    $('#email').val('');
					}
				}
				
				});
		};
				function isCheckNickName() {
					var nickname = $('#nickname').val();
					
					$.ajax({
						url: "${pageContext.request.contextPath}/member/isCheckDuplicatedNickname",
						type:'post',
						data:{nickname:nickname},
						success:function(nickname) {
							if(nickname == 0) {
			                    $('.nick_ok').css("display","table"); 
			                    $('.nick_already').css("display", "none");
							}
							else {
			                    $('.nick_already').css("display","table");
			                    $('.nick_ok').css("display", "none");
			                    alert("닉네임을 다시 입력해주세요");
			                    $('#nickname').val('');
							}
						}
						
						});
				};
				function isCheckPhone() {
					var phoneNum = $('#phoneNum').val();
					
					$.ajax({
						url: "${pageContext.request.contextPath}/member/isCheckDuplicatedPhoneNum",
						type:'post',
						data:{phoneNum:phoneNum},
						success:function(phoneNum) {
							if(phoneNum == 0) {
			                    $('.phoneNum_ok').css("display","inline-block"); 
			                    $('.phoneNum_already').css("display", "none");
							}
							else {
			                    $('.phoneNum_already').css("display","inline-block");
			                    $('.phoneNum_ok').css("display", "none");
			                    alert("번호를 다시 입력해주세요");
			                    $('#phoneNum').val('');
							}
						}
						
						});
						};

	
	</script>