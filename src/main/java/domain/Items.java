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
	//		*/ String email, Long mobile*/
		// TODO Auto-generated constructor stub
		this.id=id;
		this.items_name = items_name;
		this.price_per_items = price_per_items;
//		this.firstName=firstName;
//		this.surname=surname;
//		this.email=email;
//		this.mobile=mobile;
//		
	
	}
	public Items( String items_name, Double price_per_items) {
		//		*/ String email, Long mobile*/
			// TODO Auto-generated constructor stub
			this.items_name = items_name;
			this.price_per_items = price_per_items;
			
	}

	
	public Items(Long id, String items_name, Double price_per_items) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.items_name = items_name;
		this.price_per_items = price_per_items;
	}


	
	public Items(Object itemName) {
		// TODO Auto-generated constructor stub
	}
	public Items(String itemName, Double itemPrice, Long itemQuantity) {
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
	public void add(ArrayList<Items> items) {
		// TODO Auto-generated method stub
		
	}

	
}


