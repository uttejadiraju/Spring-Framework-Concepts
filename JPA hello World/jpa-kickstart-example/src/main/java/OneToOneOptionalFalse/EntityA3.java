package OneToOneOptionalFalse;

import javax.persistence.*;

@Entity
@Table(name = "Parent")
public class EntityA3 {
	@Id
	@GeneratedValue
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToOne(optional = false)
	private EntityB3 entityB1;

	public EntityB3 getEntityB() {
		return entityB1;
	}

	public void setEntityB(EntityB3 entityB) {
		this.entityB1 = entityB;
	}
}
