package beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {
	static String orderNum = "";
	static String productName = "";
	static float price = 0;
	static int quantity = 0;
		
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("static-access")
	public Order(String orderNum, String productName, float price, int quantity) {
		super();
		this.orderNum = orderNum;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	//getters/setters
	public static String getOrderNum() {
		return orderNum;
	}
	@SuppressWarnings("static-access")
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public static String getProductName() {
		return productName;
	}
	@SuppressWarnings("static-access")
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public static float getPrice() {
		return price;
	}
	@SuppressWarnings("static-access")
	public void setPrice(float price) {
		this.price = price;
	}
	public static int getQuantity() {
		return quantity;
	}
	@SuppressWarnings("static-access")
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
