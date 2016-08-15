<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#left {
	float: left;
	width: 200px;
}

#right {
	margin-left: 200px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact List</title>
</head>
<body>
	<div id="content">
		<div id="left">
			<p>
				<c:out value="${personInfo.name}" />
				<br/>
				<c:out value="${personInfo.userName}"/>
			</p>
		</div>
		<div id="right">
			<p>
				<c:out value="${personInfo.company.name}" />
				<br/>
				<c:out value="${personInfo.company.catchPhrase}"/>
				<br/>
				<c:out value="${personInfo.company.bs}" />
			</p>
			<p>
				Phone: <c:out value="${personInfo.phone}" />
				<br/>
				Email: <c:out value="${personInfo.email}"/>
				<br/>
				Url: <c:out value="${personInfo.webSite}" />
			</p>
		</div>
	</div>
</body>
</html>
