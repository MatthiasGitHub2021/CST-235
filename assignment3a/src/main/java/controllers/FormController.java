package controllers;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.User;

@SuppressWarnings("deprecation")
@ManagedBean(name="FormController")
@ViewScoped
public class FormController {
	FacesContext fc = FacesContext.getCurrentInstance();
	
	public String onSubmit(User user) {
		fc.getExternalContext().getRequestMap().put("User", user);
		return "TestResponse.xhtml";
	}
	
	public String onFlash(User user) {
		fc.getExternalContext().getFlash().put("User", user);
		
		Map<String, Object> sessionMap = fc.getExternalContext().getSessionMap();
		
		sessionMap.put("firstname", user.getFirstName());
		sessionMap.put("lastname", user.getLastName());
		
		return "TestResponse.xhtml";
	}
}
