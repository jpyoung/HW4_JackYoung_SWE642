CREATE TABLE StudentBean (
	s_id int NOT NULL,
	fullName varchar(40),
	streetAddress varchar(60),
	city varchar(50),
	state varchar(2),
	zip varchar(10),
	telephoneNumber varchar(20),
	email varchar(60),
	dateOfSurvey varchar(50),
	likedAboutCampus varchar(200),
	originOfInterest varchar(50),
	likelyhoodOfRecommendation varchar(30),
	gradMonth varchar(30),
	GraduationYear varchar(30),
	raffle varchar(35),
	comments varchar(500),
	username varchar(30),
	studentID varchar(12),
	PRIMARY KEY(s_id)
);

http://localhost:8080/AS4_JackYoung_SWE642/Driver?uid=12345



select s_id, studentID, fullName from StudentBean;
Update studentbean set likedaboutcampus = 'students' where s_id = 4;

CREATE SEQUENCE student_hw4_seq_swe642
MINVALUE 1
START WITH 1
INCREMENT BY 1

INSERT INTO StudentBean VALUES (student_hw4_seq_swe642.nextval, 'Ryan Young', '1435 South', 'centreville', 'va', '20120', '574-234-9900', 'r@gmail.com', '02-05-2014', 'food, internet,', 'school', 'likely', 'May', '2014', '1,2,3,4,5,6,7,8,9,10', 'good job', 'ryoung', '122686');