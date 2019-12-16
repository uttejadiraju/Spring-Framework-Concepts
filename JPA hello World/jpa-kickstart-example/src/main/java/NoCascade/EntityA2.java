package NoCascade;

import javax.persistence.*;

@Entity
@Table(name = "Parent")
public class EntityA2 {
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
	private EntityB2 entityB1;

	public EntityB2 getEntityB() {
		return entityB1;
	}

	public void setEntityB(EntityB2 entityB) {
		this.entityB1 = entityB;
	}
}
