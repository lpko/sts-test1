
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<html>
<head>
	<title> SringBoard</title>	
</head>
<body>

<table>
<!--  아래는 JSTL 문법 -->
<c:forEach items="${results}" var="result">
<tr>
<!--  EL태그 문법 -->
 <td>${result.NO}</td>
 <td>${result.TITLE}</td>
 <td>${result.CONTENT}</td>
</tr>
<!--  아래는 JSTL 문법 -->
</c:forEach>
</table>


</body>
</html>