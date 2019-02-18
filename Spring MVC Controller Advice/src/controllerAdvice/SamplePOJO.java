package controllerAdvice;

public class SamplePOJO {
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = String.valueOf(Math.random());
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = String.valueOf(Math.random());
	}
	String id;
	String address;
}
