<%@ page import="java.util.*, Projets.*" %>
<!DOCTYPE html>
<html>

<head>
	<title>Gestion des projets</title>	
</head>

<%
	// get the students from the request object (sent by servlet)
	List<Projet> projets = 
					(List<Projet>) request.getAttribute("Projets_LIST");
%>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<table>
			
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				
				<% for (Projet tempProjet : projets) { %>
				
					<tr>
						<td> <%= tempProjet.getProject_name() %> </td>
						<td> <%= tempProjet.getDateDebut() %> </td>
						<td> <%= tempProjet.getDateFin() %> </td>
					</tr>
				
				<% } %>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








