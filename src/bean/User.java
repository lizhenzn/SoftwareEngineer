package bean;
/**
 * 用户类
 * @author 22901
 *
 */
public class User {
	String ID;  //ex:2-2117.... 
	String name; //ex:韩忠恺
	String password;
	float money; //ex:2.0
	String department; //ex:计算机科学与技术
	public User() {}
	public User(String ID,String name,float money,String department) {
		this.ID=ID;
		this.name=name;
		this.money=money;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		 this.password=password;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
