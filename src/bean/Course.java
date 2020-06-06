package bean;
/**
 * 课程信息类
 * @author 22901
 *
 */
public class Course {
	String ID;
	String name;
	float money;
	float credit;
	String department;
	public Course() {}
	public Course(String ID,String name,float money,float credit,String department) {
		this.ID=ID;
		this.name=name;
		this.money=money;
		this.credit=credit;
		this.department=department;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public float getCredit() {
		return credit;
	}
	public void setCredit(float credit) {
		this.credit = credit;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
