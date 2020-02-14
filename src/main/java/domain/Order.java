package domain;

public class Order {
	private long id;
	private Double price;
	private long customer_ID;
	private Long totalQuantity;
	private Double totalPrice;

	public Order(Long id) {
		this.id = id;

	}
	// private long item_ID;
//	private String email;
//	private Long mobile;
//	public int getSurname;

	public Order(long id, Double price, long customer_ID) {
		// */ String email, Long mobile*/
		// TODO Auto-generated constructor stub
		this.customer_ID = customer_ID;
		this.price = price;
		this.id = id;

	}

	public Order(long custId, float floatCost) {
		// */ String email, Long mobile*/
		// TODO Auto-generated constructor stub
		this.customer_ID = (long) floatCost;
		this.price = (double) custId;
	}

	public Order(Long customerId, Long totalQuantity, Double totalPrice) {
		this.setCustomer_ID(customerId);
		this.setTotalQuantity(totalQuantity);
		this.setPrice(totalPrice);
	}

	private void setTotalQuantity(Long totalQuantity2) {
		// TODO Auto-generated method stub

	}

	public Order(Long orderId, Long customerId, Long totalQuantity, Double totalPrice) {
		this.setId(orderId);
		this.setCustomer_ID(customerId);
		this.setTotalQuantity(totalQuantity);
		this.setPrice(totalPrice);
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getTotalQuantity() {
		return totalQuantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public long getCustomer_ID() {
		return customer_ID;
	}

	public void setCustomer_ID(long customer_ID) {
		this.customer_ID = customer_ID;

	}

	public String toString() {
		return "id:" + id + " price:" + price + " customer_ID:" + customer_ID + " totalQuantity:" + totalQuantity
				+ " totalPrice:" + totalPrice;

	}
}
