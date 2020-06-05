package bean;

import java.sql.Connection;

import util.JDBCUtil;

/**
 * 管理员、教授、学生公共类
 * @author 22901
 *
 */
public abstract class Person {
	public String ID;
	public String username;
	public Connection conn;
	public Person() {
		this.conn=JDBCUtil.getLocalConnection();
	}
	public void setID(String ID) {
		this.ID=ID;
	}
	public String getID() {
		return this.ID;
	}
	public void setUserName(String username) {
		this.username=username;
	}
	public String getUserName() {
		return this.username;
	}
	/**
	 * 登录、需要各个子类实现
	 * @param password
	 * @return
	 */
	public abstract boolean login(String password);
	/**
	 * 查询课程信息
	 * @param courseID
	 */
	public void queryCourseInfo(String courseID) {
		
	}
}
