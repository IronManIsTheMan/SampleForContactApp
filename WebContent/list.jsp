<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact List</title>
</head>
<body>

	<ul>
		<c:forEach var="personInfo" items="${personInfoList}">
			<li><a href="PersonDetail.do?id=${personInfo.id}"><c:out value="${personInfo.name}" /></a></li>
		</c:forEach>
	</ul>
</body>
</html>
