package OneToOneEagerFetch;

import javax.persistence.*;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String address;
	@OneToOne(fetch = FetchType.LAZY)
	private OrderItem orderItem;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	@Override
	public String toString() {
		return "Customer{" + "id=" + id + ", name='" + name + '\'' + ", address='" + address + '\'' + '}';
	}
}