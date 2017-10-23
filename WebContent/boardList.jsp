<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ch3.BoardVO"%>
<%@page import="ch3.BoardListDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>board list</title>
</head>
<body>
	<h1> 게시판</h1>
	
	
	<%
//  HttpSession session = request.getSession();
ArrayList<BoardVO> blist = null;
blist = (ArrayList<BoardVO>)session.getAttribute("boardlist");

 //HashMap<String,String> map = null;
// BoardInsertDAO dao = new BoardInsertDAO();
//  blist = dao.blist();
%>

<table border="1">


<%
for(int i = 0; i < blist.size(); i++){
	BoardVO tmpVO = blist.get(i);
%>
	<tr>

	<td><a href="./BoardDetail?b_no=<%=tmpVO.getB_no() %>"><%= tmpVO.getB_no() %></a></td>
	<td><a href="./BoardDetail?b_no=<%=tmpVO.getB_no() %>"><%= tmpVO.getB_title() %></a></td>
	<td><%= tmpVO.getB_writer() %></td>
<%-- 	<td><%= tmpVO.getB_contents() %></td> --%>
	<td><%= tmpVO.getReg_date() %></td>
	
	</tr>
<%
	}
%>
</table>

	<br><br>
	
    <a href="./BoardInsertForm">게시판 글쓰기</a>
</body>
</html>