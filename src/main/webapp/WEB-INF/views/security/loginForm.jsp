<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value='/login'/>" method="post">
		<!-- ng가 null이 아니면 메시지를 표출 -->
		<c:if test="${param.ng != null}">
			<p>
				Login NG! <br/>
				<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != NULL }">
					message : <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"></c:out>
				</c:if>
			</p>
		</c:if>
		ID : <input type="text" name="bId" id="bId"><br>
		PW : <input type="text" name="bPw" id="bPw"><br>
		<input type="submit" value="Login">		
	</form>
</body>
</html>