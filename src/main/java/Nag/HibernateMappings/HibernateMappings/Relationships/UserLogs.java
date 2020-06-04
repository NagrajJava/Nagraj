package Nag.HibernateMappings.HibernateMappings.Relationships;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="User_logs")
public class UserLogs {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="log_id")
    private int id;
  
  private String logs;
  
  @ManyToOne(cascade = CascadeType.ALL)
  private Users user;

  
  
public Users getUser() {
	return user;
}

public void setUser(Users user) {
	this.user = user;
}

public UserLogs() {
	super();
	// TODO Auto-generated constructor stub
}

public UserLogs(int id, String logs) {
	super();
	this.id = id;
	this.logs = logs;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getLogs() {
	return logs;
}

public void setLogs(String logs) {
	this.logs = logs;
}


  
  
}
