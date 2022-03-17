package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;

/**
 * Session Bean implementation class AnotherOrdersBusinessService
 */
@Alternative
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
public class AnotherOrdersBusinessService implements OrdersBusinessInterface {

	List<Order> orders = new ArrayList<Order>();
	
    /**
     * Default constructor. 
     */
    public AnotherOrdersBusinessService() {
		orders.add(new Order("007", "Product 7", 7.00f, 7));
		orders.add(new Order("008", "Product 8", 8.00f, 8));
		orders.add(new Order("009", "Product 9", 9.00f, 9));
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    @Override
    public void test() {
    	System.out.println("Hello from AnotherOBService.");
    }
    
	@Override
	public List<Order> getOrders() {		
		return orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		this.orders = orders;
		
	}

}
