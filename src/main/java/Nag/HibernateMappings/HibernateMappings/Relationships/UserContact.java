package Nag.HibernateMappings.HibernateMappings.Relationships;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserContact {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ContactUserId")
	private int id;
  private Integer contact;

  
  @OneToOne(cascade = CascadeType.ALL)
  
  private Users users;
  

public UserContact() {
	super();
	// TODO Auto-generated constructor stub
}
public UserContact(int id, Integer contact) {
	super();
	this.id = id;
	this.contact = contact;
}


public Users getUsers() {
	return users;
}
public void setUsers(Users users) {
	this.users = users;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Integer getContact() {
	return contact;
}
public void setContact(Integer contact) {
	this.contact = contact;
}
  
  
}
