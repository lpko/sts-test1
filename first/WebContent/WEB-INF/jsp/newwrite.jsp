<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Iterator, spring.board.dto.boardDto" %>

<%
 boardDto BoardDto = (boardDto)request.getAttribute("BoardDto");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/web/ckeditor/ckeditor.js"></script>
<script src="/web/ckeditor/sample.js" type="text/javascript"></script>
<link href="/web/ckeditor/sample.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
 <script type="text/javascript">
  function savesubmit() {
   frm = document.form;
   var oEditor = CKEDITOR.instances.content;
   var con = document.getElementById('content');
   con.value = oEditor.getData();
   frm.action = "newwrite.do";
   form.submit();
  }
 </script>
</head>
<body>
<form name="form" method="post" action="#">
 <input type="hidden" name="b_no" value="<% if(BoardDto != null)  { %><%=BoardDto.getB_no() %><% } %>" >
 <table cellpadding="1" cellspacing="1" border="1" width="650">
  <tr>
   <td>
    이름 : <input type="text" name="name" value="<% if(BoardDto != null)  { %><%=BoardDto.getName() %><% } %>"><br>
   </td>
  </tr>
  <tr>
   <td>
    제목 : <input type="text" name="subj" value="<%  if(BoardDto != null) {  %><%=BoardDto.getSubj() %><% } %>"><br>
   </td>
  </tr>
  <tr>
   <td>
    <textarea cols="100" id="content" name="content" rows="10"><%  if(BoardDto != null) {  %><%=BoardDto.getNewcontents() %><% } %></textarea>
    <script type="text/javascript">
     var editor = CKEDITOR.replace( 'content' ,{customConfig:'/web/ckeditor/config.js', width:'750px', height:'450px'});   
    </script>
   </td>
  </tr>
  <tr>
   <td align="right">
    <input type="button" value="글쓰기" onclick="savesubmit();">
    <input type="button" value="목록보기" onclick="javascript:location.href='newlist.do'">   
   </td>
  </tr>
 </table>
</form>
</body>
</html>
