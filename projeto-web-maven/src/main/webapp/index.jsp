<html>
<body>
<h2>Hello World!</h2>
<%="Este texto esta sendo impresso por JSP" %>
<h2>Abaixo um loop feito em java:</h2>
<%
	for(int i =0; i<= 10; i++){
		out.print(i);
		out.print("-");
	}
%>
</body>
</html>
