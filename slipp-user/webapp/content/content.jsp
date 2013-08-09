	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SLiPP :: Q&A </title>

<%@ include file="../commons/_header.jspf"%>

</head>
<body>
	<%@ include file="../commons/_top.jspf"%>
	
	<div class="container">
		<div class="row">
			<div class="span12">
				<section id="typography">
				<div class="page-header">
					<h1 >Q&A </h1>
					<a style=float:right href="/contents/form">질문 하기</a> 
					
				</div>
				
				<form class="form-horizontal" action="${forwardUrl}" method="post">
				<table border=1 width=810>
					<tr bgcolor="yellow">
						<td align=left width=1><label class="control-label"><b>index</b></label></td>
						<td align=center><b>제목</b></td>
						<td align=center><b>작성 시간</b></td>
						<td align=center><b>작성자</b></td>
					</tr>
					
					<c:choose>
					<c:when test="${empty contents}">
						<tr><td colspan=4 align = center>작성된글이 없습니다.</td></tr>
					</c:when>
					</c:choose>
					
					<c:forEach var="entry" items="${contents}" varStatus="status">
					<div class="control-group">								   
					<tr>   
    				 		<td width=1><label class="control-label" for="userId"> <b>${entry.index}</b></label></td>
    				 		<td width=300 align = center> <a href="/contents/${entry.index}">${entry.subject}</a></td>
    				 		<td width=150 align = center> ${entry.time}</td>
    				 		<td width=150 align = center> ${entry.owner}</td>
    				</tr>
    					    				
    				</div>			
    				</c:forEach>		
    			</table>	
					<div class="control-group">
						
					</div>
					<div class="control-group">
							
						</div>
						<div class="control-group">
							
						</div>
						
						
					</form>
				</div>
			</div>
		</div>
	</body>
	</html>