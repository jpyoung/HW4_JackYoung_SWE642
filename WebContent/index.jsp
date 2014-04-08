<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<!-- <script type="text/javascript" src="assets/jquery-1.11.0.min.js"></script> -->
<link rel="stylesheet" href="assets/jquery-ui-1.10.4/themes/base/jquery.ui.all.css">
<script src="assets/jquery-ui-1.10.4/jquery-1.10.2.js"></script>
<script src="assets/jquery-ui-1.10.4/ui/jquery.ui.core.js"></script>
<script src="assets/jquery-ui-1.10.4/ui/jquery.ui.widget.js"></script>
<script src="assets/jquery-ui-1.10.4/ui/jquery.ui.position.js"></script>
<script src="assets/jquery-ui-1.10.4/ui/jquery.ui.tooltip.js"></script>
<script src="assets/jquery-ui-1.10.4/ui/jquery-ui.js"></script>
	
	
<script>
$( document ).tooltip({
	track: true
});
</script>



	
<link rel="stylesheet" href="style.css"/>
<script src="zipJson.js"></script>
<script src="survey_functionality.js"></script>
<script type="text/javascript" src="assets/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	defaultSettings();
</script>



</head>
<body onload="defaultSettings();">

<div id="dialog-modal" title="Warning">
  <div id="errorBox"></div>
</div>


	<div id="header_bar">
		<div id="logo_top_bar">Department of Computer Science</div>
	</div>  <!-- end div header_bar -->
	

	<div id="contentArea">
		
		<h1>CS Department Survey</h1>
		<p>We ask that all prospective students provide feedback about their campus visit<p>


		
			
		<form id="survey_form" action="Driver" autocomplete="on">
		
			

		<table id="formTable" border="0">
			<tr>
				<td>
					<label>User Name:</label><br/>
					<input class="full tField" id="username" name="username" type="text" value="" autofocus/>
				</td>
				<td>
					<label>Full Name:</label><br/>
					<input class="full tField" id="fullName" name="fullName" type="text" value=""/>
				</td>
				<td>
						<label>Street Address:</label><br/>
						<input class="full tField" id="streetAddress" name="streetAddress" type="text" value=""/>
				</td>
			</tr>
			<tr>
				<td>
					<label>Zip:</label><br/>
					<input class="full tField" id="zip" name="zip" type="text" value="" placeholder="20120"/>
					<span style="margin-left: 20px; color: red;" id="zip_error_field"></span>
				</td>
				<td>
					<label>State:</label><br/>
					<input class="full tField" id="state" name="state" type="text" value="" placeholder="VA"/>
				</td>
				<td>
					<label>City:</label><br/>
					<input class="full tField" id="city" name="city" type="text" value=""/>
				</td>
			</tr>
			<tr>
				<td>
					<label>Telephone #:</label><br/>
					<input class="full tField" id="telephoneNumber" name="telephoneNumber" type="text" value="" placeholder="703-993-4622"/>
				</td>
				<td>
					<label>E-mail:</label><br/>
					<input class="full tField" id="email" name="email" type="text" value="" placeholder="johnDoe@gmu.edu"/>
				</td>
				<td>
					<label>URL:</label><br/>
					<input class="full tField" name="url" type="text" value="" placeholder="http://johnDoe.com"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>Survey Date</label><br/>
					<input class="full tField" id="surveyDate" name="surveyDate" type="text" value="" placeholder="02-05-2014"/>
				</td>
				<td>
				<label>What did you like most about this campus?</label><br/>
					<input type="checkbox"  class="chec" name="likeMost" value="students"/>Students<br>
					<input type="checkbox" class="chec" name="likeMost" value="location"/>Location<br>
					<input type="checkbox" class="chec" name="likeMost" value="campus"/>Campus<br>
					<input type="checkbox" class="chec" name="likeMost" value="atmospher"/>Atmosphere<br>
					<input type="checkbox" class="chec" name="likeMost" value="dorms"/>Dorm Rooms<br>
					<input type="checkbox" class="chec" name="likeMost" value="sports"/>Sports<br>
				</td>	
				<td colspan="2">
					<label>How did you become interested in the University?</label><br/>
					<input type="radio" class="rad" name="interestHow" value="Friends"/>Friends<br/>
					<input type="radio" class="rad" name="interestHow" value="Television"/>Television<br/>
					<input type="radio" class="rad" name="interestHow" value="Internet"/>Internet<br/>
					<input type="radio" class="rad" name="interestHow" value="Other"/>Other...<br/>
				</td>
			</tr>
				<tr>
					<td>
						<label>Graduation Month:</label><br/>
						<input class="full tField" type="text" id="gradMonth" list="months" placeholder="May"/>
						<datalist id="months">
							<option value="January">
							<option value="February">
							<option value="March">
							<option value="April">
							<option value="May">
							<option value="June">
							<option value="July">
							<option value="August">
							<option value="September">
							<option value="October">
							<option value="November">
							<option value="December">
						</datalist>
					</td>
					<td>
						<label>Graduation Year:</label><br/>
						<input class="full tField" id="GraduationYear" name="GraduationYear" type="text" value="" placeholder="2014"/>
					</td>
					<td>
						<label>Likelihood you would recommend this school to a friend?</label><br/>
						<select id="recommendToFriend" name="recommendToFriend">
						  <option value="VeryLikely">Very Likely</option>
						  <option value="likely">Likely</option>
						  <option value="unlikely">Unlikely</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<label>Enter 10 numbers separated by a comma.</label>
						<p id="data_error_field">Error Place</p>
						<input class="full tField" id="Data" name="Data" type="text" value="" placeholder="1,50, ..."/>
					</td>
					<td>
						<label>Student Id:</label><br/>
						<input class="full tField" id="studentID" name="studentID" type="text" value=""/>
					</td>
						<td>
					</td>
				</tr>
				<tr>
					<td>
						<label>Additional Comments:</label><br/>
						<textarea class="tArea" name="comments" id="comments" rows="3">
						</textarea>
					</td>
					<td>
						<input id="f-submit" type="submit" value="Submit">
					</td>
			
					<td>
						<button id="resetForm_button">Reset Form</button>
					</td>
				</tr>

		</table>
		
			
		</form>
	
	</div>  <!-- end div contentArea -->
		
	
	<div class="footer">
		<span class="creatorName">Site Created By: <b>Jack Young</b></span>
		<a href="http://www.gmu.edu/" title="Please visit http://www.gmu.edu for more information. (Click on the logo to go there now.)"><img id="gmuLogo" width="200px" src="GMU_LOGO.jpg"/></a>
	</div>

</body>
</html>