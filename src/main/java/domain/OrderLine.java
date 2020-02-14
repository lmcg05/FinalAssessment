package domain;

public class OrderLine {
	private long id;
	private long orders_ID;
	private long items_ID;
	private int quantity;

	public OrderLine(long orders_ID, long items_ID, int quantity) {
		this.orders_ID = orders_ID;
		this.items_ID = items_ID;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOrders_ID() {
		return orders_ID;
	}

	public void setOrders_ID(long orders_ID) {
		this.orders_ID = orders_ID;
	}

	public long getItems_ID() {
		return items_ID;
	}

	public void setItems_ID(long items_ID) {
		this.items_ID = items_ID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderLine(long id, long orders_ID, long items_ID, int quantity) {
		this.orders_ID = orders_ID;
		this.items_ID = items_ID;
		this.quantity = quantity;
	}

	public String toString() {
		return "\n" + "OrderId " + orders_ID + "\n" + "ItemId: " + items_ID + "\n" + "quantity: " + quantity + "\n"
				+ "....................................................";
	}

}
