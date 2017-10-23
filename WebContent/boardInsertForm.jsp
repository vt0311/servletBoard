<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>board Insert Form</title>
</head>
<body>
	<h1> 게시판 글쓰기 </h1>
	<br>
	<form id="form1" name="form1" method="post" action="./BoardInsert">
	title &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" maxlength="50" size="50" id="title" name="title"/>
	<br><br>
	writer &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" maxlength="10" size="10" id="writer" name="writer"/>
	<br><br>
	contents : <textarea maxlength="1000" rows="5" cols="50" id="contents" name="contents"></textarea>
	<br>	<br>
	<input type="submit" />
	</form>
	
</body>
</html>