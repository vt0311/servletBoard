<%@page import="java.util.HashMap"%>
<%@page import="ch3.BoardVO"%>
<%@page import="ch3.BoardDetailDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 상세보기</title>
</head>
<body>
<h1> 게시판 상세보기</h1>
<%
BoardVO tmpVO = (BoardVO) session.getAttribute("boardvo");
%>
글번호 : <%= tmpVO.getB_no() %><p>
제목 : <%= tmpVO.getB_title() %><p>
작성자 : <%= tmpVO.getB_writer() %><p>
작성일 : <%= tmpVO.getReg_date() %><p>
<%-- 조회건수 : <%= map.get("clickcnt") %><p> --%>
내용 : <%= tmpVO.getB_contents() %><p>

</body>
</html>