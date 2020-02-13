package domain;



public class Customer {
	private long id;
	private String firstName;
	private String lastNAme;
	private String email;
//	private String email;
//	private Long mobile;
//	public int getSurname;
	
	public Customer(String email, String firstName, String lastName) {
		//		*/ String email, Long mobile*/
			// TODO Auto-generated constructor stub
			this.firstName = firstName;
			this.lastNAme = lastName;
			this.email = email;
			
	}
//			this.firstName=firstName;
//			this.surname=surname;
//			this.email=email;
//			this.mobile=mobile;
	
	public Customer(int id, String firstName, String lastName, String email) {
	//		*/ String email, Long mobile*/
		// TODO Auto-generated constructor stub
		this.id=id;
		this.firstName = firstName;
		this.lastNAme = lastName;
		this.email = email;
//		this.firstName=firstName;
//		this.surname=surname;
//		this.email=email;
//		this.mobile=mobile;
//		
	}
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastNAme = lastName;
	}
	
	public Customer(long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastNAme = lastName;
	}

	
		// TODO Auto-generated constructor stub
	

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastNAme() {
		return lastNAme;
	}

	public void setLastNAme(String lastNAme) {
		this.lastNAme = lastNAme;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
//	public String toString() {
//		return "id:" + id + " first name:" + firstName + " lastNAme:" + lastNAme;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
////		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((lastNAme == null) ? 0 : lastNAme.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Customer other = (Customer) obj;
//		if (firstName == null) {
//			if (other.firstName != null)
//				return false;
//		} else if (!firstName.equals(other.firstName))
//			return false;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		if (lastNAme == null) {
//			if (other.las != null)
//				return false;
//		} else if (!surname.equals(other.surname))
//			return false;
//		return true;
//	}
//
//}
//
//	
//
//}