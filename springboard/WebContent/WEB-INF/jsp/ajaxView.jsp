<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title> SringBoard</title>
	<script type="text/javascript" src="/springboard/js/jquery-2.1.4.js" charset="utf-8"></script>
	<script type="text/javascript"> 
		function viewAjaxList() {
			$.ajax({ 
		        type     : "POST"
		    ,   url      : "/springboard/listjson.do"
		    ,   dataType : "json"
		    ,   data     : ""
		    ,   success  : function(result) {
		            $.each(result,function(key) {
		            	var list = result[key];	
		            	
		            	var content = "<table>";	

		            	for( i = 0;i < list.length ;i++) {
		            		content += "<tr>";
		            		content +="<td>" + list[i].NO + "</td>";
		            		content +="<td>" + list[i].TITLE + "</td>";
		            		content +="<td>" + list[i].CONTENT + "</td>";
		            		content +="</tr>";

		            	}
		            	content += "<table>";

		            	$("#ajaxList").html(content);		            	
		            });
		        }
		    }); 

			
		}
		
	</script>

</head>
<body>
<div id="ajaxList"></div>

<input type="button" value="리스트 가지고 오기" onclick="viewAjaxList() ">

</body>
</html>
