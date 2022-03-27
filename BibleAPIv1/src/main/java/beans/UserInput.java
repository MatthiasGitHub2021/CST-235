package beans;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * User input bean
 */

@XmlRootElement
public class UserInput {

	private String firstOccurence;
	private String numberOfOccurrences;
	private String book;
	private String chapter;
	private String verse;
	private String lookup = book + chapter + verse;
	
	public UserInput() {
		super();
	}

	public String getFirstOccurence() {
		return firstOccurence;
	}

	public void setFirstOccurence(String firstOccurence) {
		this.firstOccurence = firstOccurence;
	}

	public String getNumberOfOccurrences() {
		return numberOfOccurrences;
	}

	public void setNumberOfOccurrences(String numberOfOccurrences) {
		this.numberOfOccurrences = numberOfOccurrences;
	}

	public String getLookup(String book, String chapter, String verse) {
		return lookup;
	}

	public void setLookup(String lookup) {
		this.lookup = lookup;
	}
	
	
}
