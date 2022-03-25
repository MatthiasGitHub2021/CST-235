package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;

@Alternative
@Stateless
@Local(DataAccessInterface.class)
@LocalBean
public class OrdersDataService implements DataAccessInterface{

	Connection conn = null;
	
	String sql = String.format("INSERT INTO  testapp.ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) "
			+ "VALUES('%s', '%s', %f, %d)", Order.getOrderNum(), Order.getProductName(), Order.getPrice(), Order.getQuantity());
	@EJB
	OrdersDataService service;
	
	public OrdersDataService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Order> findAll() {
		
		List<Order> list = new ArrayList<Order>();
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testapp", "root", "root");
			System.out.println("Success!!");
			Statement st = conn.createStatement();
			String query = "SELECT * FROM testapp.ORDERS";
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
//				System.out.println(rs.getInt("ID"));
//				System.out.println(rs.getString("PRODUCT_NAME"));
//				System.out.println(rs.getFloat("PRICE"));
				
				list.add(new Order(String.valueOf(rs.getInt("ID")), rs.getString("PRODUCT_NAME"), rs.getFloat("PRICE"), rs.getInt("QUANTITY")));
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
		return list;
	}

	@Override
	public Order findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Order order) {
		// TODO Auto-generated method stub
		
	}

}
