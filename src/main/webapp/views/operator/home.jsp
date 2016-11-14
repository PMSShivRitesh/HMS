<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="icon" type="image/png" href="resources/images/favicon.ico">

<script type="text/javascript" src="resources/js/jquery-1.11.1.min.js"></script>
<script src="resources/bootstrap/js/bootstrap-dropdown.js"></script>

<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/login.css" type="text/css">
<link rel="stylesheet" href="resources/css/panel.css" type="text/css">

<link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<link href="resources/bootstrap/css/docs.css" rel="stylesheet">
</head>

<body>
	<%-- <%
		if (session.getAttribute("role") == "TEAMMEMBER"
				|| session.getAttribute("role").equals("TEAMMEMBER")
				|| session.getAttribute("role") == "MANAGER"
				|| session.getAttribute("role").equals("MANAGER")) {
	%> --%>
	<%@ include file="../template/headeremployee.jsp"%>
	<%-- <%
		} else if (session.getAttribute("role") == "ADMIN"
				|| session.getAttribute("role").equals("ADMIN")) {
	%>
	<%@ include file="WEB-INF/Pages/template/headeradmin.jsp"%>
	<%
		}
	%>	
	 --%>
	<%@ include file="../template/operatorleftmenu.jsp"%>

	<%-- <%
		if (session.getAttribute("role") == "TEAMMEMBER"
				|| session.getAttribute("role").equals("TEAMMEMBER")
				|| session.getAttribute("role") == "MANAGER"
				|| session.getAttribute("role").equals("MANAGER")) {
	%> --%>
	<%@ include file="../template/homeemployeebody.jsp"%>
	<%-- <%
		} else if (session.getAttribute("role") == "ADMIN"
				|| session.getAttribute("role").equals("ADMIN")) {
	%>
	<%@ include file="/Pages/admin/homeadminbody.jsp"%>
	<%
		}
	%>
 --%>
	<%@ include file="../template/footer.jsp"%>

<%-- 	<input type="hidden" value=${sessionScope.role } id="role">
	<input type="hidden" value=${sessionScope.empid } id="empid"> --%>

</body>
</html>