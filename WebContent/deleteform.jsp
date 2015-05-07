<%@page import="guestbookDao.GuestBookDao"%>
<%@page import="guestbookVo.GuestBookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% GuestBookVo vo = new GuestBookVo(); 
	GuestBookDao dao = new GuestBookDao();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form method="post" action="/guestbook2/gb?a=delete">
	<input type='hidden' name="no" value="<%=request.getParameter("no")%>">
	
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"></td>
			<td><input type="submit" value="확인"></td>
			<td><a href="/guestbook2/gb?a=form">메인으로 돌아가기</a></td>
		</tr>
	</table>
	</form>
</body>
</html>