package data;

import java.util.List;

import javax.ejb.Local;

import beans.UserInput;

@Local
public interface DataInterface {
	public List<UserInput> findFirstOccurence(String firstOccurence);
	public List<UserInput> findNumberOfOccurrences(String numberOfOccurences);
	public List<UserInput> verseLookup(String lookup);
	
}
