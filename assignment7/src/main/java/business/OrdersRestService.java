package business;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Order;

@RequestScoped
@Path("/orders")
public class OrdersRestService {

	@Inject
	OrdersBusinessInterface service;
	
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getOrdersAsJson() {
		return service.getOrders();
	}
	
	@GET
	@Path("/getxml")
	@Produces(MediaType.APPLICATION_XML)
	public Order[] getOrdersAsXml() {
		
		/*
		 * call the service variables getOrders() method, 
		 * convert the ArrayList List<Order> returned from the service call to an Order[] array
		 * return the array as a return value for the method implementation.
		 */
				
		Order[] orders = new Order[service.getOrders().size()];
		
		orders = service.getOrders().toArray(orders);
		
		return orders;
	}

}
