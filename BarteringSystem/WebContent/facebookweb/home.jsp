<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="facebook.FBConnection"%>
<%@page import=facebook.FBGraph"%>
<%@page import="java.util.Map"%>
<%@page import="javax.servlet.ServletOutputStream;"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>fb home</title>
</head>
<body>
getting home of FB
<%
String code = request.getParameter("code");
FBConnection fbConnection = new FBConnection();
String accessToken = fbConnection.getAccessToken(code);

FBGraph fbGraph = new FBGraph(accessToken);
String graph = fbGraph.getFBGraph();
Map<String, String> fbProfileData = fbGraph.getGraphData(graph);
%>
</body>
</html>