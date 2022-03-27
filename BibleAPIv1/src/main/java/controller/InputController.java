package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import beans.UserInput;
import service.UserInputService;

/*
 * Get user input from Request page
 */

@SuppressWarnings("deprecation")
@ManagedBean(name="InputController")
@SessionScoped
public class InputController {

	//FacesContext fc = FacesContext.getCurrentInstance();
	
	@Inject
	UserInputService service;
	
	public List<UserInput> getFirst(String input) {
		List<UserInput> text = service.findFirstOccurence(input);
		
		return text;
	}
	
	
	public List<UserInput> getNumAll(String input) {
		List<UserInput> text = service.findNumberOfOccurrences(input);
		
		return text;
	}
	
	public List<UserInput> getLookup(String input) {
		List<UserInput> text = service.verseLookup(input);
		
		return text;
	}
	
}
