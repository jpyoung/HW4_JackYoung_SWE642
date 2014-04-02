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
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<div id="contentArea">
		
			<h1>Student Information Page</h1>
		

		<h4>Username: ${st.username}</h4>
		<h4>Student ID: ${st.studentId}</h4>
		<table border="1">
			<tr>
				<th>fullName</th>
				<th>street address</th>
				<th>city</th>
				<th>state</th>
				<th>zip</th>
				<th>telephone</th>
				<th>email</th>
				<th>dateOfSurvey</th>
			</tr>
			<tr>
				<td>${st.fullName}</td>
				<td>${st.streetAddress}</td>
				<td>${st.city}</td>
				<td>${st.state}</td>
				<td>${st.zip}</td>
				<td>${st.telephoneNumber}</td>
				<td>${st.email}</td>
				<td>${st.dataOfSurvey}</td>
			</tr>
		</table>
		
		<br/>
		
		<table border="1">
			<tr>
				<th>likedAboutCampus</th>
				<th>Interests</th>
				<th>likelyhoodOfRecommendation</th>
				<th>raffle</th>
				<th>comments</th>
			</tr>
			<tr>
				<td>
				<c:forEach var="option" items="${st.likedAboutCampus}" >
  					${option}
				</c:forEach>
				
				</td>
				<td>${st.originOfInterest}</td>
				<td>${st.likelyhoodOfRecommendation}</td>
				<td>${st.raffle}</td>
				<td>${st.comments}</td>
			</tr>
		</table>

	<br/>

		<a href="index.jsp">Return to Survey Form.</a>
		</div>  <!-- end div contentArea -->


	<div class="footer">
		<span class="creatorName">Site Created By: <b>Jack Young</b></span>
		<a href="http://www.gmu.edu/" title="Please visit http://www.gmu.edu for more information. (Click on the logo to go there now.)"><img id="gmuLogo" width="200px" src="GMU_LOGO.jpg"/></a>
	</div>
</body>
</html>