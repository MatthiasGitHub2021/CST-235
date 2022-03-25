package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Order;
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
	
	//MySQL connection
	Connection conn = null; 
	
	public String onSubmit(User user) {
		fc.getExternalContext().getRequestMap().put("User", user);
		service.test();
		getAllOrders();
		insertOrder();
		getAllOrders();
		
		timer.setTimer(10000);
		return "TestResponse.xhtml";
	}
	
	public OrdersBusinessService getService() {
		return service;		
	}
	
	private void getAllOrders() {	
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testapp", "root", "root");
			System.out.println("Success!!");
			Statement st = conn.createStatement();
			String query = "SELECT * FROM testapp.ORDERS";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getInt("ID"));
				System.out.println(rs.getString("PRODUCT_NAME"));
				System.out.println(rs.getFloat("PRICE"));
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
	}
	
	private void insertOrder() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testapp", "root", "root");
			System.out.println("Success!!");
			Statement st = conn.createStatement();
			String insert = "INSERT INTO  testapp.ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES('001122334455', 'This was inserted new', 25.00, 100)";
			st.executeUpdate(insert);
			
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
	}
	
	public String onSendOrder() {
		service.sendOrder(new Order("orderNum", "productName", 1f, 1 ));
		return "OrdersResponse.xhtml";
	}
}
