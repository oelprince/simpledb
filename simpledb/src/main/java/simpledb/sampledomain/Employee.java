package simpledb.sampledomain;

import java.io.Serializable;

public class Employee implements Serializable {
	
	private static final long serialVersionUID = 6362891571015283263L;
	
	private String id;
	private String firstName;
	private String lastName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}
	
	
}
