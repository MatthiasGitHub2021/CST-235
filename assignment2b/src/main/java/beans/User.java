package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Size;

import org.wildfly.common.annotation.NotNull;


@SuppressWarnings("deprecation")
@ManagedBean(name="User")
@ViewScoped
public class User {
	
	@NotNull				//<h:messages/> added to TestForm to display @s
	@Size(min=5, max=15)
	String firstName, lastName;
	
	public User() {
		firstName = "1234";
		lastName = "12345";
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


