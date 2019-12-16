package CascadePersist;

import javax.persistence.*;

@Entity
@Table(name = "Parent")
public class EntityA4 {
	@Id
	@GeneratedValue
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToOne(cascade = CascadeType.PERSIST)
	private EntityB4 entityB1;

	public EntityB4 getEntityB() {
		return entityB1;
	}

	public void setEntityB(EntityB4 entityB) {
		this.entityB1 = entityB;
	}
}
