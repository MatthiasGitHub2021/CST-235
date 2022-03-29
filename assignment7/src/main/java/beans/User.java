package beans;

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Size;

import org.wildfly.common.annotation.NotNull;


@SuppressWarnings("deprecation")
@ManagedBean(name="User")
@SessionScoped
public class User {
	
	@NotNull				//<h:messages/> added to TestForm to display @s
	@Size(min=5, max=15)
	String firstName, lastName;
	
	public User() {
		firstName = "1234";
		lastName = "12345";
	}
	
	@PostConstruct
	public void init() {
		
		// Get the logged in Principle
		Principal principle= FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
			if(principle == null)
			{
				setFirstName("Unknown");
				setLastName("");
			}
			else
			{
				setFirstName(principle.getName());
				setLastName("");
			}
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


