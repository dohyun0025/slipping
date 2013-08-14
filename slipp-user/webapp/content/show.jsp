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
					<h1 >글 읽기  </h1>
				</div>
			</div>
		</div>
	</div>
				<c:set var="forwardUrl" value="/contents" /> <!-- create -->
				
				<!--
				<c:if test="${not empty user.userId}">
				<c:set var="forwardUrl" value="/users/${user.userId}" /> 
				</c:if>
				-->
				
				<form class="form-horizontal" action="${forwardUrl}" method="post">
					<div class="control-group">
						<label class="control-label" for="subject"></label>						
						<div class="controls">
						<div class="span7">
							<font size=10><b>${content.subject}</b></font> 
						</div>
						</div>
						<div class="controls">
						<div class="span7">
						<label style=float:right>${content.owner}</label> 
						</div>
						</div>
									
					</div>
					
					<div class="control-group">
					<table width=400>
						<tr>
							<td width=400 colspan=1>
							<div class="controls">
							<div class="span7">
								<pre>${content.note}</pre>
							</div>						
							</div>
							</td>
						</tr>
						</table>
						<c:choose>
						<c:when test="${content.owner eq loginUser.userId}">
						<div class="controls">
							<div class="span7">
								<a style=float:left href="${index}/form"><font size=1>수정하기</font></a>
							</div>	
						</div>
						</c:when>
						</c:choose>
					</div>
						<div class="controls">
						<div class="span7">
							<div class="page-header">
							</div>	
						</div>
						</div>			
				</form>
				
				<br><br><br>
				<form class="form-horizontal" method="post" action="">
					<div class="control-group">
					
					<c:forEach var="entry" items="${replys}" varStatus="status">
					<div class="controls">
							<div class="span12">
					<!--
				<c:if test="${not empty user.userId}">
				<c:set var="forwardUrl" value="/users/${user.userId}" /> 
				</c:if>
				-->
							
							<table width=600>
							<tr>
							<td width=100><label class="control-label" for="subject">${entry.userId}</label></td>						
								<div class="controls">
									<td width=300>${entry.reply}</td>
									<td width = 290 align = left>${entry.time} </td>
									<c:if test="${entry.userId eq loginUser.userId}">
										<td width=10><a href ="/qnas/delete/${entry.id}/${content.index}" color=blue>x</a></td>
									</c:if>
									<c:if test="${entry.userId ne loginUser.userId}">
										<td width=10></td>
									</c:if>
									</td>
								</div>
							</tr>
							</table>
							</div>
					</div>						
    				</c:forEach>
    				</div>
    				<div class="controls">
							<div class="span7">
							<div class="page-header"></div>
							</div>
					</div>
				</form>
				<c:choose>
				<c:when test="${not empty loginUser}">
				<form class="form-horizontal" action="/qnas/insert" method="post">
						<input type=hidden name="index" value="${index}">
						<div class="control-group">
						<div class="span7">
						<div class="controls">
						댓글쓰기  
						</div>
						</div>
						</div>
						<div class="controls">
						<div class="span7">
						<table>
							<tr rowspan=2>
							<td><textarea cols=45 rows=10 id="reply" name="reply" style="min-width:500px; max-width:500px; min-height:100px; max-height:100px; resize:none"></textarea>
								</td>
								
							</tr>
							<tr>
							<td><input type="submit" name="submit"></td>
							</tr>		
						</table>
						</div>
						</div>
				</form>
				</c:when>
				</c:choose>		
						
</body>
</html>