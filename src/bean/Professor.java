package bean;

import java.util.ArrayList;
import java.util.List;

/**
 * ½ÌÊÚÀà
 * @author 22901
 *
 */
public class Professor extends Person{
	public boolean login(String password) {
		boolean logined=false;
		
		return logined;
	}
	public boolean publishScore(String scoreID,String studentID) {
		boolean published=false;
		
		return published;
	}
	public boolean teachCourse(String courseID) {
		boolean teached=false;
		
		return teached;
	}
	public List<Student> queryStudentList(String courseID){
		List<Student> list=new ArrayList<>();
		
		return list;
	}

}
