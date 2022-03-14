package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;
import beans.Orders;

/**
 * Session Bean implementation class OrdersBusinessService
 */
@Alternative
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
public class OrdersBusinessService implements OrdersBusinessInterface {

	List<Order> orders = new ArrayList<Order>();
	
    /**
     * Default constructor. 
     */
    public OrdersBusinessService() {
		orders.add(new Order("004", "Product 4", 4.00f, 4));
		orders.add(new Order("005", "Product 5", 5.00f, 5));
		orders.add(new Order("006", "Product 6", 6.00f, 6));
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    @Override
    public void test() {
        System.out.println("Hello from OBService.");
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
