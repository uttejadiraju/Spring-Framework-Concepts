package BidirectionalOneToOne;

import javax.persistence.*;

@Entity
@Table(name = "EntityX")
public class EntityX {
	@Id
	@GeneratedValue
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EntityY getEntityY() {
		return entityY;
	}

	public void setEntityY(EntityY entityY) {
		this.entityY = entityY;
	}

	@OneToOne
	private EntityY entityY;

	public String toString() {
		return "EntityX :- { id " + id + "}";
	}

}
