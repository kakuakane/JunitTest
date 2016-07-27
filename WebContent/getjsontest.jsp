<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#sendButton").click(function(){
		var name = $("#name").val();
		var email = $("#email").val();
		var password = $("#password").val();
		var data = {
				"name":name,
				"email":email,
				"password":password
		}
		$.getJSON("/JunitTest/UserApiServlet",data,function(data){
			var result=data.message;
			$("#responseMessage").append("<span style='color:red'>"+msg+"</span>");
		})
	})
})
</script>


<title>Insert title here</title>
</head>
<body>
<c:if test="${!empty errorList}">
<c:forEach items="${errorList}" var="error">
<c:out value="${error}"></c:out>
</c:forEach>
<br>
<c:out value="${result}"></c:out>
</c:if>
<div>
	名前：
	<input id="name" type="text" name="name"> 
	メールアドレス：
	<input id="email" type="text" name="email"> 
	パスワード：
	<input id="password" type="password" name="password">
	<input id="sendButton" type="button" value="送信">
</div>
<div>
<p id="responseMessage"></p>
</div>
	
</body>
</html>