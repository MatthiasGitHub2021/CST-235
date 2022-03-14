package controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;
import business.OrdersBusinessService;

@SuppressWarnings("deprecation")
@ManagedBean(name="FormController")
@ViewScoped
public class FormController {

	FacesContext fc = FacesContext.getCurrentInstance();
	
	@Inject
	OrdersBusinessService service;
	
	@EJB
	MyTimerService timer;
	
	public String onSubmit(User user) {
		fc.getExternalContext().getRequestMap().put("User", user);
		service.test();
		
		timer.setTimer(10000);
		return "TestResponse.xhtml";
	}
	
	public OrdersBusinessService getService() {
		return service;
		
	}
}
