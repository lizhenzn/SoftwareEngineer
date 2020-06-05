package bean;

import java.sql.Connection;

import util.JDBCUtil;

/**
 * ����Ա�����ڡ�ѧ��������
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
	 * ��¼����Ҫ��������ʵ��
	 * @param password
	 * @return
	 */
	public abstract boolean login(String password);
	/**
	 * ��ѯ�γ���Ϣ
	 * @param courseID
	 */
	public void queryCourseInfo(String courseID) {
		
	}
}
