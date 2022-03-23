<%@page import="com.znchn.dto.UserDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/web005/search">
		<input type="text" name="searchCont" id="searchCont" value="<%=request.getAttribute("searchCont")%>">
		<button>查询</button>
	</form>
	<%
	List<UserDto> userDtoList = (List<UserDto>)request.getAttribute("userDtoList");
	if(userDtoList != null && userDtoList.size() != 0){ %>
		<table>
			<%for(int i = 0; i < userDtoList.size(); i++){ 
				UserDto userDto = userDtoList.get(i);
			%>
				<tr>
					<td><%=userDto.getId() %></td>
					<td><%=userDto.getUsername() %></td>
					<td><%=userDto.getPositionName() %></td>
				</tr>
			<%} %>
		</table>
	<%} %>
</body>
</html>