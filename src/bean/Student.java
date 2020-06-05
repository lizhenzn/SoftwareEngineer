package bean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * —ß…˙¿‡
 * @author 22901
 *
 */
public class Student extends Person{
	public boolean login(String password) {
		boolean logined=false;
		String sql="select *from student where s_id=? and password=?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, this.ID);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				logined=true;
			}else {
				logined=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		return logined;
	}
	public float queryScore(String scoreID) {
		float score=-1;
		
		return score;
	}
	public boolean chooseCourse(String courseID) {
		boolean choosed=false;
		
		return choosed;
	}
   
	public boolean undoCourse(String courseID) {
		boolean undoed=false;
		
		return undoed;
	}
}
