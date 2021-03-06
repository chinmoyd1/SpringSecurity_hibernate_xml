<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ page isELIgnored="false" %>
<html>
<body>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>Welcome : ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a></h2>  
	</c:if>

	<!-- Alternative 
	<c:if test="${pageContext.request.remoteUser != null}">
		<h2>Welcome : ${pageContext.request.remoteUser}</h2>
	</c:if>
 	-->
 	<c:set var="bid" value=" ${title}"/>
 	
<h1>Title : ${bid}</h1>
</body>
</html>