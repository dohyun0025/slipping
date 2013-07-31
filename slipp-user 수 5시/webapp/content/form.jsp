<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SLiPP :: 새 글 작성 </title>

<%@ include file="../commons/_header.jspf"%>

</head>
<body>
	<%@ include file="../commons/_top.jspf"%>

	<div class="container">
		<div class="row">
			<div class="span12">
				<section id="typography">
				<div class="page-header">

				<c:if test="${empty loginUser}">
					<c:redirect url="/user/login.jsp">
					</c:redirect>					
				</c:if>
					
				</div>
				
				<c:set var="forwardUrl" value="/contents" /> <!-- create -->
				
				<!--
				<c:if test="${not empty user.userId}">
				<c:set var="forwardUrl" value="/users/${user.userId}" /> 
				</c:if>
				-->
				
				<form class="form-horizontal" action="${forwardUrl}" method="post">
					<div class="control-group">
						<label class="control-label" for="subject">제목 : </label>						
						<div class="controls">
							<input type="text" id="subject" name="subject" value="${content.subject}" placeholder="">
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="note">내용 : </label>
						<div class="controls">
							<textarea cols=45 rows=10 id="note" name="note"  placeholder="">
							${content.note}
							</textarea>
						</div>
					</div>
					
					
					<div class="control-group">
						<div class="controls">
							
						</div>
					</div>
					
					<div class="control-group">
						<div class="controls">
							<button type="submit" class="btn btn-primary">회원가입</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>