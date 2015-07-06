<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Iterator, spring.board.dto.boardDto" %>
<%
 boardDto BoardDto = (boardDto)request.getAttribute("BoardDto");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <table cellpadding="1" cellspacing="1" border="1" width="650">
  <tr>
   <td>이름</td>
   <td><%=BoardDto.getName() %></td>
  </tr>
  <tr>
   <td>제목</td>
   <td><%=BoardDto.getSubj() %></td>
  </tr>  
  <tr>
   <td colspan="2"><%=BoardDto.getNewcontents() %></td>
  </tr>
 </table>
 
 <input type="button" value="목록보기" onclick="javascript:location.href='newlist.do'">
 <input type="button" value="수정하기" onclick="javascript:location.href='newwrite.do?b_no=<%=BoardDto.getB_no()%>'">
 <input type="button" value="답글" onclick="javascript:location.href='newReply.do?b_no=<%=BoardDto.getB_no()%>'">
</body>
</html>
