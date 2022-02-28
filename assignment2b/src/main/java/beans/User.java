package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="User")
@ViewScoped
public class User {
	String firstName, lastName;
	
	public User() {
		firstName = "Matthias";
		lastName = "Peterson";
	}
	
	//getters/setters
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

}
