<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<form action = "/guestbook3/guest/add" method = "post">
	<table border="1">
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"></td>
			<td>비밀번호</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
		 <td colspan="4"><textarea style="width:100%;" name = "content"></textarea></td>
		</tr>
		<tr>
		 
		 <td colspan="4">		 
		 <button type="submit">등록</button></td>
		</tr>
	</table>
	
  </form>
  <br>
    
    <!-- for(GuestBookVo guest : gbList){ -->
   <c:forEach items="${gbList }" var="gbList" >
	<table border = "1" style = "width:500px;">
		<tr>
			<td style = "width:50px;">${gbList.no }</td>
			<td style = "width:200px;">${gbList.name }</td>
			<td style = "width:200px;">${gbList.date }</td>
			<td style = "width:50px;"> <a href = "${pageContext.request.contextPath }/guest/deleteForm?no=${gbList.no }">삭제</a> </td>
		</tr>
		<tr>
			<td colspan="4">${gbList.content }</td>
		</tr>
	</table>
	<br>
	</c:forEach>

</body>
</html>