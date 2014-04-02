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
<!-- 		<div id="upperRight" class="upperRight">
			<p> Welcome No Name</p>
			<p> Reset</p>
		</div> -->
	</div>  <!-- end div header_bar -->
	
	<div id="contentArea">

		<div id="b_container">
			
		
		<div class="message">
			<fieldset>
			<h1 class="center">Congratulations! ${name}</h1>
			<h2>You Are A Winner Of Two Movie Tickets for Having a Raffle Average Greater Than 90.</h2>
			<h3 class="center">Thank you for taking the time to fill out the survey!</h3>
				<p>- The information has been successfully stored</p>
					<table border="1">
						<tr>
							<th colspan="2">Raffle Stats</th>
						</tr>
						<tr>
							<th>Mean</th>
							<td class="result">${compMean}</td>
						</tr>
						<tr>
							<th>Standard Deviation</th>
							<td class="result">${compStdv}</td>
						</tr>
					</table>
					<a href="index.jsp"><button id="backToHome" class="green">Return to Home</button></a>
			</fieldset>
		</div>

		
			<a href="index.jsp"></a>
		
		</div>  <!-- end div b_container -->

	</div>  <!-- end div contentArea -->
	
	<div class="footer">
		<span class="creatorName">Site Created By: <b>Jack Young</b></span>
		<a href="http://www.gmu.edu/" title="Please visit http://www.gmu.edu for more information. (Click on the logo to go there now.)"><img id="gmuLogo" width="200px" src="GMU_LOGO.jpg"/></a>
	</div>

</body>
</html>