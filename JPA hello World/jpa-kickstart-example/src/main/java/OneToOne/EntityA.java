package OneToOne;

import javax.persistence.*;

@Entity
@Table(name = "EntityAA")
public class EntityA {
	@Id
	@GeneratedValue
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToOne
	private EntityB entityB;

	public EntityB getEntityB() {
		return entityB;
	}

	public void setEntityB(EntityB entityB) {
		this.entityB = entityB;
	}
}
