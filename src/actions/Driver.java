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
					if (allTakenSurveys.get(i).getStudentID().equalsIgnoreCase(id)) {
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
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("[INFO] :=:  doGet() method called in the Driver Servlet Class. :=: UID=" + request.getParameter("uid"));
		System.out.println("[Text File Location] :=: " + request.getServletContext().getRealPath("SurveyData_JackYoung.txt"));
		
		//looking up the relative location of the textfile.  
		StudentDAO.FILENAME = request.getServletContext().getRealPath("SurveyData_JackYoung.txt");
		System.out.println("IDS: " + StudentDAO.readIn());
		//reading in all data from text file
		//allTakenSurveys = StudentDAO.readIn();
		allTakenSurveys = StudentDAO.retrieveAllSurveys();
		
		System.out.println("[Info] :=: All the Taken Surveys: " + allTakenSurveys);
		
		
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
			String lbc = "";
			if (likedAboutCampus == null) {
				lbc = "n/a";
			} else {
				for (int i = 0; i < likedAboutCampus.length; i++) {
					lbc += likedAboutCampus[i];
				}
			}
			
			
			String originOfInterest = request.getParameter("interestHow");
			String likelyhoodOfRecommendation = request.getParameter("recommendToFriend");
			String gradMonth = request.getParameter("gradMonth");
			String graduationYear = request.getParameter("GraduationYear");
			String raffle = request.getParameter("Data");
			String comments = request.getParameter("comments");
			String username = request.getParameter("username");
			String studentID = request.getParameter("studentID");

			studentBean = new StudentBean(full_name, streetAddress, city, state,
					zip, telephoneNumber, email, dataOfSurvey,
					lbc, originOfInterest,
					likelyhoodOfRecommendation, gradMonth, graduationYear,
					raffle, comments, username, studentID);
			

			System.out.println("[NEW SURVEY] :=: " + studentBean.toString());

			//writing out the new student survey
			StudentDAO.writeOutID(studentID);
			
			boolean succInsert = StudentDAO.insertStudentSurveyRecord(studentBean);
			if (succInsert) {
				System.out.println("[INFO] Student Survey was successfully inserted into the Database");
			} else {
				System.out.println("[ERROR] The Student Survey was not successfully inserted into the Database.");
			}

			//Calculating the Mean and STDV and setting the databean
			dataBean = DataProcessor.computeMetrics(studentBean.getRaffle());

			//gathering all the IDs of the students
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
			request.setAttribute("idList", allIDS);

			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);

		} else if (request.getParameter("uid") != null) {
			//if (request.getParameter("uid") != null)
			System.out.println("ELSE IF");

			//gathering all the IDs of the students
			List<String> allIDS = StudentDAO.gatherIDs();
			request.setAttribute("idList", allIDS);
			
			String address;

			StudentBean selectedStudent = findStudent(request.getParameter("uid"));
			System.out.println("Selected Student: " + selectedStudent);
			if (selectedStudent == null) {
				System.out.println("[ERROR] :=: Going to the error student page.");
				address = NOSUCHSTUDENT_JSP;
			} else {
				request.setAttribute("st", selectedStudent);
				address = STUDENT_JSP;
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(STUDENT_JSP);
			dispatcher.forward(request, response);
		}  else {
			System.out.println("The else was called");
			RequestDispatcher dispatcher = request.getRequestDispatcher(SURVEY_JSP);
			dispatcher.forward(request, response);
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
	 * This method is used to check if the passed in url contained the 
	 * survey dataString.  It does a simple check for four of the required
	 * fields.  If they are empty, then return false; else return true.
	 * 
	 * @param request
	 * @return boolean
	 */
	@SuppressWarnings("unused")
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
		 
		 if (full_name.equals("") || streetAddress.equals("") || studentId.equals("") || email.equals("")) {
			 return false;
		 }
		 return true;
	}
	
}
