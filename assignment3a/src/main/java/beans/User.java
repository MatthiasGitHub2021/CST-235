package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("deprecation")
@ManagedBean(name="User")
@ViewScoped
public class User {
	
	@NotNull()
	@Size(min=5,max=15)
	String firstName, lastName;
	
	public User() {
		firstName = "";
		lastName = "";
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
