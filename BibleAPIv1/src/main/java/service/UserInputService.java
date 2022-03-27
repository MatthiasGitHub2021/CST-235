package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.UserInput;
import data.DataInterface;

/*
 * Service takes user input and connects to db and returns results
 */

@Stateless
@LocalBean
public class UserInputService implements DataInterface {

	Connection conn = null;
	
	UserInput user;
	
	@EJB
	UserInputService service; 
	
	String sql = String.format("INSERT INTO  bibleapp.UserInput(FIRST_OCC, NUM_OF_OCCURRENCES, LOOKUP)"
			+ "VALUES('%s', '%s', %f, %d)", user.getFirstOccurence(), user.getNumberOfOccurrences(), user.getLookup("book", "chapter", "verse"));
	
	public UserInputService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<UserInput> findFirstOccurence(String firstOccurence) {
		
		List<UserInput> result = new ArrayList<UserInput>();
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibleapp", "root", "root");
			System.out.println("Success!!");
			Statement st = conn.createStatement();
			String query = "SELECT * FROM bibleapp.BIBLE";
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				
				result.add(new UserInput());
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println("Connection failed.");
			e.printStackTrace();
		}finally{
			if(conn == null) {
				try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				}
			}
		}
		return result;
		
	}

	@Override
	public List<UserInput> findNumberOfOccurrences(String numberOfOccurences) {
		List<UserInput> result = new ArrayList<UserInput>();
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibleapp", "root", "root");
			System.out.println("Success!!");
			Statement st = conn.createStatement();
			String query = "SELECT * FROM bibleapp.BIBLE";
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				
				result.add(new UserInput());
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println("Connection failed.");
			e.printStackTrace();
		}finally{
			if(conn == null) {
				try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				}
			}
		}
		return result;
		
	}

	@Override
	public List<UserInput> verseLookup(String lookup) {
		List<UserInput> result = new ArrayList<UserInput>();
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibleapp", "root", "root");
			System.out.println("Success!!");
			Statement st = conn.createStatement();
			String query = "SELECT * FROM bibleapp.BIBLE";
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				
				result.add(new UserInput());
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println("Connection failed.");
			e.printStackTrace();
		}finally{
			if(conn == null) {
				try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				}
			}
		}
		return result;
		
	}

}
