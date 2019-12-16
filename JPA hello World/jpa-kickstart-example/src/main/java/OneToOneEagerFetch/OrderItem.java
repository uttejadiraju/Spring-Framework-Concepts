package OneToOneEagerFetch;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderItem {
	@Id
	@GeneratedValue
	private int id;
	private String itemName;
	private int quantity;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItem{" + "id=" + id + ", itemName='" + itemName + '\'' + ", quantity=" + quantity + '}';
	}
}
