package coforgespringexamples;

public class Address {
	
	int dno;
	String street;
	

	String city;
	
	public Address(int dno, String street, String city) {
		super();
		this.dno = dno;
		this.street = street;
		this.city = city;
	}
	
	/*
	public int getDno() {
		return dno;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getCity() {
		return city;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setCity(String city) {
		this.city = city;
	}
	*/
	@Override
	public String toString() {
		return "Address [dno=" + dno + ", street=" + street + ", city=" + city + "]";
	}
	
	
}
