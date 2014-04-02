package businessLogic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.StudentBean;

/**
 * @author Jack Young
 * @date April 01, 2014
 * SWE 642
 * 
 * Class Purpose:  The purpose of this class is to encapsulate the business logic for storing
 * and reading the Survey data from and to the text file.  In addition, this class contains the
 * method used for calculating the mean and standard deviation based on the users inputed
 * raffle numbers.    
 * 
 */
public class StudentDAO {

//	public static String FILENAME = "/Users/youngbuck14188/Documents/workspace_kep/Assignment4_jyoung17_swe642/WebContent/SurveyData_JackYoung.txt";

	
	
	//public static String FILENAME = "/Users/JackYoung/Desktop/HW4_JackYoung_SWE642/WebContent/SurveyData_JackYoung.txt";
	
	public static String FILENAME;
	
	
	/**
	 * This method is used to write the student object
	 * to the text file. 
	 * 
	 * @param student
	 */
	public static void writeOut(StudentBean s) {
		String txt = s.textFileStorageFormat();
		writeToFile(txt);
	}


	/**
	 * This method is used to reads in the data in the txt file,
	 * it then creates the students based on those entries.
	 * Then returns the list of students to the calling method.  
	 * 
	 * @return list of students
	 */
	public static List<StudentBean> readIn() {
		List<String> temp = readFromFile();
		List<StudentBean> students = new ArrayList<StudentBean>();
		if (temp.size() > 0) {
			for (int i = 0; i < temp.size(); i++) {
				students.add(decypher(temp.get(i)));
			}
			
		} else {
			System.out.println("Error, there was nothing to read in from the text file.");
		}
		return students;
	}
	
	public static List<String> gatherIDs() {
		List<StudentBean> students = readIn();
		List<String> temp = new ArrayList<String>();
		if (students.size() > 0) {
		for (int i = 0; i < students.size(); i++) {
			temp.add(students.get(i).getStudentId());
		}
		}
		return temp;
	}
	
	/**
	 * This method is used to write the passed in text
	 * to the text file.  
	 * @param txt
	 */
	private static void writeToFile(String txt) {
		try {
			File file = new File(FILENAME);
			if (!file.exists()) {
				System.out.println("File did not exist");
				file.createNewFile();
			}	
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			bw.write(txt);
			bw.close();
			System.out.println("Done writing to file.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This method reads in from the Specified Text File and returns
	 * a List<String>.  Each index of that list represents one entry
	 * (i.e. one line) from the text file.  
	 * 
	 * @return list
	 */
	private static List<String> readFromFile() {
		List<String> lines = new ArrayList<String>();
		try {
			FileInputStream fstream = new FileInputStream(FILENAME);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String fullLine;
			
			while ((fullLine = br.readLine()) != null)   {
				if (!fullLine.isEmpty())
					lines.add(fullLine);
			}
			in.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		
		return lines;
	}

	
	/**
	 * The decypher method is used to parse the text file document,
	 * then it creates a Student object from that data.  After all thats done
	 * the newly created student object is returned to the caller.
	 * 
	 * @param sentence
	 * @return Student Object
	 */
	private static StudentBean decypher(String sentence) {
		Pattern pattern = Pattern.compile("\\{(.+?)\\}");
		Matcher m = pattern.matcher(sentence);
		ArrayList<String> o = new ArrayList<String>();
		while (m.find()) {
			o.add(m.group(1));
		}

		StudentBean s = new StudentBean(o.get(0), o.get(1), o.get(2), o.get(3),
				o.get(4), o.get(5), o.get(6), o.get(7),
				convertStringToArray(o.get(8)), o.get(9), o.get(10),
				o.get(11), o.get(12), o.get(13), o.get(14));
		return s;
		// return null;
	}
	
	
	/**
	 * This method is used to convert a comma separated string
	 * into an String array.
	 * 
	 * @param comma separated string
	 * @return String array
	 */
	private static String[] convertStringToArray(String n) {
		if(n == null || n.length() == 0) {
			return new String[]{"N/A"};
		} 
		String[] p = n.split(",");
		return p;
	}
	
}
