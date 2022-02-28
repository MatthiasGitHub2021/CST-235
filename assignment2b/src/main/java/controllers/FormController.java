package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.User;

@ManagedBean(name="FormController")
@ViewScoped
public class FormController {
	FacesContext fc = FacesContext.getCurrentInstance();
	
	public String onSubmit(User user) {
		//FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().getRequestMap().put("User", user);
		return "TestResponse.xhtml";
	}
	
	public String onFlash(User user) {
		fc.getExternalContext().getFlash().put("User", user);
		return "FlashResponse.xhtml";
	}
}
