package business;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: OrderMessageService
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/Order"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:/jms/queue/Order")
public class OrderMessageServicev2 implements MessageListener {

    /**
     * Default constructor. 
     */
    public OrderMessageServicev2() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        TextMessage text = (TextMessage) message;
        ObjectMessage object = (ObjectMessage)message;
    	if (message instanceof TextMessage) {
        	try {
        		System.out.println(text.getText());
        	}catch (JMSException e) {
        		e.printStackTrace();
        	}
        }
        //  https://examples.javacodegeeks.com/enterprise-java/jms/jms-textmessage-example/
     
    if (message instanceof ObjectMessage) {
    	
    	try {
    		System.out.println((ObjectMessage)object.getObject());
    	}catch (JMSException e) {
    		e.printStackTrace();
    	}
    }
   
}

}
