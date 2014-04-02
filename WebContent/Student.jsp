<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css"/>
</head>
<body>

	<div id="header_bar">
		<div id="logo_top_bar">Department of Computer Science</div>

	</div>  <!-- end div header_bar -->
	
	
		<div id="contentArea">
		
			<h1>Student Information Page</h1>
		


		<table border="1">
			<tr>
				<th>fullName</th>
				<th>street address</th>
				<th>city</th>
				<th>state</th>
				<th>zip</th>
			</tr>
			<tr>
				<td>${st.fullName}</td>
				<td>${st.streetAddress}</td>
				<td>${st.city}</td>
				<td>${st.state}</td>
				<td>${st.zip}</td>
			</tr>
		</table>

		<a href="index.jsp"></a>
		</div>  <!-- end div contentArea -->
	
	

	<div class="footer">
		<span class="creatorName">Site Created By: <b>Jack Young</b></span>
		<a href="http://www.gmu.edu/" title="Please visit http://www.gmu.edu for more information. (Click on the logo to go there now.)"><img id="gmuLogo" width="200px" src="GMU_LOGO.jpg"/></a>
	</div>
</body>
</html>