package OneToOneOptionalTrue;

import javax.persistence.*;

@Entity
@Table(name = "Parent")
public class EntityA1 {
	@Id
	@GeneratedValue
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToOne(optional = true)
	private EntityB1 entityB1;

	public EntityB1 getEntityB() {
		return entityB1;
	}

	public void setEntityB(EntityB1 entityB) {
		this.entityB1 = entityB;
	}
}
