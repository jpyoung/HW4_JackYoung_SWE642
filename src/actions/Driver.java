package actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.File;

import businessLogic.DataProcessor;
import businessLogic.StudentDAO;
import model.DataBean;
import model.StudentBean;

/**
 * @author Jack Young
 * @date April 01, 2014
 * SWE 642
 * 
 * Servlet implementation class Driver
 */
@WebServlet("/Driver")
public class Driver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static String WINNER_JSP = "WinnerAcknowledgement.jsp";
	private static String SIMPLE_JSP = "SimpleAcknowledgement.jsp";
	private static String STUDENT_JSP = "Student.jsp";
	private static String NOSUCHSTUDENT_JSP = "NoSuchStudent.jsp";
	private static String SURVEY_JSP = "index.jsp";
	
	private StudentBean studentBean;
	private DataBean dataBean;
	private List<StudentBean> allTakenSurveys;
	
 
	private ServletContext servletContext;


	/**
	 * @return the servletContext
	 */
	public ServletContext getServletContext() {
		return servletContext;
	}

	/**
	 * @param servletContext the servletContext to set
	 */
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Driver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Method is used to lookup a StudentBean by an id.
	 * If it finds a student, it returns that student to the caller.
	 * If it does not find a matching id, then it returns null. 
	 * 
	 * @param id
	 * @return StudentBean
	 */
	public StudentBean findStudent(String id) {
		if (id != null) {
			if (getAllTakenSurveys().size() > 0) {
				int index = -1;
				for (int i = 0; i < allTakenSurveys.size(); i++) {
					if (allTakenSurveys.get(i).getStudentId().equalsIgnoreCase(id)) {
						index = i;
					}
				}
				if (index > -1) {
					return allTakenSurveys.get(index);
				} else {
					System.out.println("Error, did not find a matching record corresponding to the studentID");
					return null;
				}
			} else {
				System.out.println("AllTakenSurveys is null: " + getAllTakenSurveys().size());
				return null;
			}
		} else {
			return null;
		}
	}
	
	public static boolean fieldsPopulated(HttpServletRequest request){
		 String full_name = request.getParameter("fullName");
		 String streetAddress = request.getParameter("streetAddress");
		 String city = request.getParameter("city");
		 String state = request.getParameter("state");
		 String zip = request.getParameter("zip");
		 String telephoneNumber = request.getParameter("telephoneNumber");
		 String email = request.getParameter("email");
		 String dataOfSurvey = request.getParameter("surveyDate");
		 String[] likedAboutCampus = request.getParameterValues("likeMost");
		 if (likedAboutCampus == null) {
			 likedAboutCampus = new String[]{"n/a"};
		 }
		 String originOfInterest = request.getParameter("interestHow");
		 String likelyhoodOfRecommendation = request.getParameter("recommendToFriend");
		 String raffle = request.getParameter("Data");
		 String comments = request.getParameter("comments");
		 String username = request.getParameter("username");
		 String studentId = request.getParameter("studentID");
		 
		 
		 if (full_name.equals("") || streetAddress.equals("") || studentId.equals("")) {
			 return false;
		 }
		 return true;
		 
		 
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		System.out.println("Found File at: " + servletContext.getRealPath("SurveyData_JackYoung.txt"));
		
		System.out.println("File Location: " + request.getServletContext().getRealPath("SurveyData_JackYoung.txt"));
	
		StudentDAO.FILENAME = request.getServletContext().getRealPath("SurveyData_JackYoung.txt");
		
		
		System.out.println("The Servlet Driver Class was called");
		
		System.out.println("UID = " + request.getParameter("uid"));
		
		allTakenSurveys = StudentDAO.readIn();
		
		System.out.println("All the Taken Surveys: " + allTakenSurveys);
		
		
		if (request.getParameter("uid") == null && fieldsPopulated(request)) {
			
			System.out.println("If Called");
		
		 String full_name = request.getParameter("fullName");
		 String streetAddress = request.getParameter("streetAddress");
		 String city = request.getParameter("city");
		 String state = request.getParameter("state");
		 String zip = request.getParameter("zip");
		 String telephoneNumber = request.getParameter("telephoneNumber");
		 String email = request.getParameter("email");
		 String dataOfSurvey = request.getParameter("surveyDate");
		 String[] likedAboutCampus = request.getParameterValues("likeMost");
		 if (likedAboutCampus == null) {
			 likedAboutCampus = new String[]{"n/a"};
		 }
		 String originOfInterest = request.getParameter("interestHow");
		 String likelyhoodOfRecommendation = request.getParameter("recommendToFriend");
		 String raffle = request.getParameter("Data");
		 String comments = request.getParameter("comments");
		 String username = request.getParameter("username");
		 String studentId = request.getParameter("studentID");
		
		
		 //where null is is where the likedAboutCampus will go
		studentBean = new StudentBean(full_name, streetAddress, city, state,
				zip, telephoneNumber, email, dataOfSurvey, likedAboutCampus,
				originOfInterest, likelyhoodOfRecommendation, raffle, comments,
				username, studentId);
	
		System.out.println(studentBean.toString());
		
		StudentDAO.writeOut(studentBean);
		
		//Calculating the Mean and STDV and setting the databean
		dataBean = DataProcessor.computeMetrics(studentBean.getRaffle());
		
		
		//allTakenSurveys = StudentDAO.readIn();
		
		List<String> allIDS = StudentDAO.gatherIDs();
		
		String address;
		if (dataBean.getMean() >= 90) {
			address = WINNER_JSP;
		} else {
			address = SIMPLE_JSP;
		}
		
		
		//Data that will be displayed on the results page (i.e. SimpleAck or WinnerAckno
		request.setAttribute("name", full_name);
		request.setAttribute("compMean", dataBean.getMean());
		request.setAttribute("compStdv", dataBean.getStdv());
		//request.setAttribute("ats",	allTakenSurveys);
		request.setAttribute("idList", allIDS);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
		
		} else if (request.getParameter("uid") != null) {
			//if (request.getParameter("uid") != null)
			System.out.println("ELSE IF");
			
			String address;
			
			
			StudentBean selectedStudent = findStudent(request.getParameter("uid"));
			
			if (selectedStudent == null) {
				System.out.println("go to the error student page");
				address = NOSUCHSTUDENT_JSP;
			} else {
				request.setAttribute("st", selectedStudent);
				address = STUDENT_JSP;
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(STUDENT_JSP);
			dispatcher.forward(request, response);
		}  else {
			System.out.println("The else was called");
//			RequestDispatcher dispatcher = request.getRequestDispatcher(SURVEY_JSP);
//			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	public List<StudentBean> getAllTakenSurveys() {
		return allTakenSurveys;
	}

	public void setAllTakenSurveys(List<StudentBean> allTakenSurveys) {
		this.allTakenSurveys = allTakenSurveys;
	}
	
	
}
