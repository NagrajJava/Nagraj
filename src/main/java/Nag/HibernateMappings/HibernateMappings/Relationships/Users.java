package Nag.HibernateMappings.HibernateMappings.Relationships;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UsersInfo")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private int id;
	private String name;
	private Integer salary;
	private String department;
	
	@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name ="user_id",referencedColumnName = "log_id")
	private List<UserLogs> userLogs;
	
	public List<UserLogs> getUserLogs() {
		return userLogs;
	}
	public void setUserLogs(List<UserLogs> userLogs) {
		this.userLogs = userLogs;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int id, String name, Integer salary, String department) {
		super();
		
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
}
