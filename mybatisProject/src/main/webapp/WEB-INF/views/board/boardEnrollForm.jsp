<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#enroll-form table{border:1px solid white}
	#enroll-form input, #enroll-form textarea{
		width:100%;
		box-sizing:border-box;
	}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="outer">
		<br>
		<h2 align="center">게시판 작성하기</h2>
		<br>
		
		<form id="enroll-form" action="insert.bo" method="post">
			<input type="hidden" name="userNo" value="${ loginUser.userNo }">
			<table align="center">
				<tr>
					<th>제목</th>
					<td width="450"><input type="text" name="title" required></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="10" name="content" required></textarea></td>
				</tr>
			</table>
			<br>
			
			<div align="center">
				<button type="submit">작성하기</button>
				<button type="reset">취소하기</button>
			</div>
		</form>
		
		<br><br>
		
		
	</div>
</body>
</html>