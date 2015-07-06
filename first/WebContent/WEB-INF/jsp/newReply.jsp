<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Iterator, spring.board.dto.boardDto" %>

<%
 boardDto boardDto = (boardDto)request.getAttribute("boardDto");
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
   frm.action = "newReply.do";
   form.submit();
  }
 </script>
</head>
<body>
<form name="form" method="post" action="#">
 <input type="hidden" name="b_no" value="<% if(boardDto != null)  { %><%=boardDto.getB_no() %><% } %>">
 <input type="hidden" name="ref" value="<% if(boardDto != null)  { %><%=boardDto.getRef() %><% } %>">
 <input type="hidden" name="b_level" value="<% if(boardDto != null)  { %><%=boardDto.getB_level() %><% } %>">
 <input type="hidden" name="step" value="<% if(boardDto != null)  { %><%=boardDto.getStep() %><% } %>">
 
 <table cellpadding="1" cellspacing="1" border="1" width="650">
  <tr>
   <td> 
    이름 : <input type="text" name="name" value="">
   </td>
  </tr>
  <tr>
   <td>   
    제목 : <input type="text" name="subj" value="">
   </td>
  </tr>
  <tr>
   <td>    
    <textarea cols="100" id="content" name="content" rows="10"><%  if(boardDto != null) {  %><%=boardDto.getNewcontents() %><% } %></textarea>
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

