	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SLiPP :: 게시물 보기 </title>

<%@ include file="../commons/_header.jspf"%>

</head>
<body>
	<%@ include file="../commons/_top.jspf"%>
	
	<div class="container">
		<div class="row">
			<div class="span12">
				<section id="typography">d
				<div class="page-header">
					<h1 >게시물 보기 </h1>
					<c:if test="${not empty loginUser}">
					<a style=float:right href="/contents/form">새글쓰기</a> 
					</c:if>
				</div>
				
				<form class="form-horizontal" action="${forwardUrl}" method="post">
				<table border=1 width=800>
					<c:forEach var="entry" items="${contents}" varStatus="status">
					<div class="control-group">								   
					<tr>   
    				 		<td><label class="control-label" for="userId"> <b><font size=10>${entry.index}</font></b></label></td>
    				 		<td><div class="controls"> <a href="/contents/${entry.index}">${entry.subject}</a></div></td>
    				 		<td><div class="controls"> ${entry.time}</div></td>
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