<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>에러</title>
<%@ include file="../commons/_header.jspf"%>
</head>
<body>
<%@ include file="../commons/_top.jspf"%>

	<c:if test="${not empty errorMessage}">
		에러가 발생하였습니다 ${errorMessage}.	
		 <c:if test="${errorMessage eq '업데이트 권한없음 Error'}">
			<br>
			<a href = "/contents/list">list로 돌아가기 </a>	
		</c:if>
	</c:if>
	
</body>
</html>