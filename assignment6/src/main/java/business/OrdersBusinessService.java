package business;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import beans.Order;
import beans.Orders;
import data.OrdersDataService;

/**
 * Session Bean implementation class OrdersBusinessService
 */
@Alternative
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
public class OrdersBusinessService implements OrdersBusinessInterface {

	@EJB
	OrdersDataService service;
	List<Order> orders = new ArrayList<Order>();
	
	@Resource(mappedName="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName="java:/jms/queue/Order")
	private Queue queue;

	
	
    /**
     * Default constructor. 
     */
    public OrdersBusinessService() {
//		orders.add(new Order("004", "Product 4", 4.00f, 4));
//		orders.add(new Order("005", "Product 5", 5.00f, 5));
//		orders.add(new Order("006", "Product 6", 6.00f, 6));
    	
    	
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
		service.findAll();
		return orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		//this.orders = orders;		
	}

	@Override
	public void sendOrder(Order order) {
		// Send a Message for an Order
		try {
		
			Connection connection = connectionFactory.createConnection();
			Session  session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer messageProducer = session.createProducer(queue);
			TextMessage message1 = session.createTextMessage();
			message1.setText("This is test message");
			messageProducer.send(message1);
			connection.close();
			}catch (JMSException e){
				e.printStackTrace();
			}		
	}

}
