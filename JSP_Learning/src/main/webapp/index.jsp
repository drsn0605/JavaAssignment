<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<!-- kjdjkckacka -->
	
	<%-- kjkcbakcbka --%>
	
	<!-- Declaration -->
	<%!
		public int k;
	%>
	
	<!-- Scriptlet Tag -->
	<%
		k=13;
		int a=10;
		int b=20;
		int c = a+b;
		//System.out.println(c);  //this will print output only in console.
		int x = k/0;
		
		int d[] = new int[5];
		d[7] = 23;
	%>
	
	<!-- Expression Tag -->
	<%=c %>
</body>
</html>