package UniqueConstraintsColumn;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "name", name = "uniqueNameConstraint") })
public class Customer {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String address;

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

	@Override
	public String toString() {
		return "Customer{" + "id=" + id + ", name='" + name + '\'' + ", address='" + address + '\'' + '}';
	}
}