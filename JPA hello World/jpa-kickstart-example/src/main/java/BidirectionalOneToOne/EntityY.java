package BidirectionalOneToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EntityY")
public class EntityY {

	@Id
	@GeneratedValue
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EntityX getEntityX() {
		return entityX;
	}

	public void setEntityX(EntityX entityX) {
		this.entityX = entityX;
	}

	public String getbValue() {
		return bValue;
	}

	public void setbValue(String bValue) {
		this.bValue = bValue;
	}

	@OneToOne(mappedBy = "entityY")
	private EntityX entityX;

	private String bValue;

	public String toString() {
		return "EntityY :- { id " + id + "value " + bValue + "}";
	}
}
