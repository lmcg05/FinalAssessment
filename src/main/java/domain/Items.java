package domain;

import java.util.ArrayList;

public class Items {
	private long id;
//	private String firstName;
//	private String surname;
	private String items_name;
	private Double price_per_items;
//	private String email;
//	private Long mobile;
//	public int getSurname;

	public Items(int id, String items_name, Double price_per_items) {
		// */ String email, Long mobile*/
		// TODO Auto-generated constructor stub
		this.id = id;
		this.items_name = items_name;
		this.price_per_items = price_per_items;

	}

	public Items(String items_name, Double price_per_items) {
		// */ String email, Long mobile*/
		// TODO Auto-generated constructor stub
		this.items_name = items_name;
		this.price_per_items = price_per_items;

	}

	public Items(Long id, String items_name, Double price_per_items) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.items_name = items_name;
		this.price_per_items = price_per_items;
	}

	public Items(Object itemName) {
		// TODO Auto-generated constructor stub
	}

	public Items(String itemName, Double itemPrice, Long itemQuantity) {
		// TODO Auto-generated constructor stub
	}

	public Items(long l, String items_name2, String string) {
		// TODO Auto-generated constructor stub
	}

	public Items(long id2, String items_name2, double price_per_items2) {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItems_name() {
		return items_name;
	}

	public void setItems_name(String items_name) {
		this.items_name = items_name;
	}

	public Double getPrice_per_items() {
		return price_per_items;
	}

	public void setPrice_per_items(Double price_per_items) {
		this.price_per_items = price_per_items;

	}

	public String toString() {
		return "id:" + id + " items_name:" + items_name + " price_per_items:" + price_per_items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((items_name == null) ? 0 : items_name.hashCode());
		result = prime * result + ((price_per_items == null) ? 0 : price_per_items.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Items other = (Items) obj;
		if (id != other.id)
			return false;
		if (items_name == null) {
			if (other.items_name != null)
				return false;
		} else if (!items_name.equals(other.items_name))
			return false;
		if (price_per_items == null) {
			if (other.price_per_items != null)
				return false;
		} else if (!price_per_items.equals(other.price_per_items))
			return false;
		return true;

	}

	public static void add(Items items) {
		// TODO Auto-generated method stub

	}

}
