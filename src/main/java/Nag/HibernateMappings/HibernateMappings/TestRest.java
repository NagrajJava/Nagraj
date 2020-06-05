package Nag.HibernateMappings.HibernateMappings;

public class TestRest 
{
	private int id;
	private String name;
	private String mobilenumber;
	private String Addres;
	
	public TestRest(int id, String name, String mobilenumber, String addres) {
		super();
		this.id = id;
		this.name = name;
		this.mobilenumber = mobilenumber;
		Addres = addres;
	}
	public TestRest() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getAddres() {
		return Addres;
	}
	public void setAddres(String addres) {
		Addres = addres;
	}
	@Override
	public String toString() {
		return "TestRest [id=" + id + ", name=" + name + ", mobilenumber=" + mobilenumber + ", Addres=" + Addres + "]";
	}
	
	
	 
}
