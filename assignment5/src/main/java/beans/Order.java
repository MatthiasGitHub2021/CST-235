package beans;

public class Order {
	String orderNum = "";
	String productName = "";
	float price = 0;
	int quantity = 0;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Order(String orderNum, String productName, float price, int quantity) {
		super();
		this.orderNum = orderNum;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	//getters/setters
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
