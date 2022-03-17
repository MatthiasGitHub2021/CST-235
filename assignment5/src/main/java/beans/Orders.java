package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@SuppressWarnings("deprecation")
@ManagedBean
@ViewScoped
public class Orders {
	List<Order> orders = new ArrayList<Order>();
	
	public Orders() {
		orders.add(new Order("001", "Product 1", 1.00f, 1));
		orders.add(new Order("002", "Product 2", 2.00f, 2));
		orders.add(new Order("003", "Product 3", 3.00f, 3));
	}

	//getters/setters
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
