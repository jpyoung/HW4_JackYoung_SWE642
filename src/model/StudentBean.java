package model;

import java.util.Arrays;

/**
 * @author Jack Young
 * @date April 1, 2014
 * SWE 642
 * 
 * Class Purpose: This class contains the fields/attributes that were
 * specified in the instructions.  These attributes match the fields on
 * the student survey form.  
 * 
 */
public class StudentBean {
	
	private String fullName;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	private String telephoneNumber;
	private String email;
	private String dataOfSurvey;
	private String[] likedAboutCampus;
	private String originOfInterest;
	private String likelyhoodOfRecommendation;
	private String raffle;
	private String comments;
	private String username;
	private String studentId;
	
	/**
	 * No arg Constructor
	 */
	public StudentBean() {
		this.fullName = "";
		this.streetAddress = "";
		this.city = "";
		this.state = "";
		this.zip = "";
		this.telephoneNumber = "";
		this.email = "";
		this.dataOfSurvey = "";
//		this.likedAboutCampus = "";
		this.originOfInterest = "";
		this.likelyhoodOfRecommendation = "";
		this.raffle = "";
		this.comments = "";
		this.username = "";
		this.studentId = "";
	}

	public StudentBean(String fullName, String streetAddress,
			String city, String state, String zip, String telephoneNumber,
			String email, String dataOfSurvey, String[] likedAboutCampus,
			String originOfInterest, String likelyhoodOfRecommendation,
			String raffle, String comments, String username, String studentId) {
		super();
		this.fullName = fullName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
		this.dataOfSurvey = dataOfSurvey;
		this.likedAboutCampus = likedAboutCampus;
		this.originOfInterest = originOfInterest;
		this.likelyhoodOfRecommendation = likelyhoodOfRecommendation;
		this.raffle = raffle;
		this.comments = comments;
		this.username = username;
		this.studentId = studentId;
	}
	
	
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the streetAddress
	 */
	public String getStreetAddress() {
		return streetAddress;
	}
	
	/**
	 * @param streetAddress the streetAddress to set
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	/**
	 * @return the telephoneNumber
	 */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	
	/**
	 * @param telephoneNumber the telephoneNumber to set
	 */
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the dataOfSurvey
	 */
	public String getDataOfSurvey() {
		return dataOfSurvey;
	}
	
	/**
	 * @param dataOfSurvey the dataOfSurvey to set
	 */
	public void setDataOfSurvey(String dataOfSurvey) {
		this.dataOfSurvey = dataOfSurvey;
	}
	
	/**
	 * @return the likedAboutCampus
	 */
	public String[] getLikedAboutCampus() {
		return likedAboutCampus;
	}
	
	/**
	 * @param likedAboutCampus the likedAboutCampus to set
	 */
	public void setLikedAboutCampus(String[] likedAboutCampus) {
		this.likedAboutCampus = likedAboutCampus;
	}
	
	/**
	 * @return the originOfInterest
	 */
	public String getOriginOfInterest() {
		return originOfInterest;
	}
	
	/**
	 * @param originOfInterest the originOfInterest to set
	 */
	public void setOriginOfInterest(String originOfInterest) {
		this.originOfInterest = originOfInterest;
	}
	
	/**
	 * @return the likelyhoodOfRecommendation
	 */
	public String getLikelyhoodOfRecommendation() {
		return likelyhoodOfRecommendation;
	}
	
	/**
	 * @param likelyhoodOfRecommendation the likelyhoodOfRecommendation to set
	 */
	public void setLikelyhoodOfRecommendation(String likelyhoodOfRecommendation) {
		this.likelyhoodOfRecommendation = likelyhoodOfRecommendation;
	}
	
	/**
	 * @return the raffle
	 */
	public String getRaffle() {
		return raffle;
	}
	
	/**
	 * @param raffle the raffle to set
	 */
	public void setRaffle(String raffle) {
		this.raffle = raffle;
	}
	
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the studentId
	 */
	public String getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StudentBean [fullName=" + fullName + ", streetAddress="
				+ streetAddress + ", city=" + city + ", state=" + state
				+ ", zip=" + zip + ", telephoneNumber=" + telephoneNumber
				+ ", email=" + email + ", dataOfSurvey=" + dataOfSurvey
				+ ", likedAboutCampus=" + Arrays.toString(likedAboutCampus)
				+ ", originOfInterest=" + originOfInterest
				+ ", likelyhoodOfRecommendation=" + likelyhoodOfRecommendation
				+ ", raffle=" + raffle + ", comments=" + comments
				+ ", username=" + username + ", studentId=" + studentId + "]";
	}

	/**
	 * This method is used to produced a string representation
	 * of the student object, in a specialized storage format
	 * manner.  This string is then returned to the calling
	 * method. 
	 * 
	 * @return String
	 */
	public String textFileStorageFormat() {
		String s =  "{" + fullName + "}{" + streetAddress + "}{" + city
				+ "}{" + state + "}{" + zip + "}{"
				+ telephoneNumber + "}{" + email + "}{"
				+ dataOfSurvey + "}{";
			if (likedAboutCampus != null) {
			for (int i = 0; i < likedAboutCampus.length; i++) {
				s += likedAboutCampus[i] + ",";
			}
			}
			s += "}{" + originOfInterest
				+ "}{" + likelyhoodOfRecommendation
				+ "}{" + raffle + "}{" + comments + "}{" + username + "}{" + studentId + "}";
		
		return s;
	}
}
