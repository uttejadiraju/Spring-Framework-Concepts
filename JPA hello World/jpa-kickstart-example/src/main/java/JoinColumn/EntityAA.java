package JoinColumn;

import javax.persistence.*;

@Entity
@Table(name = "Parent")
public class EntityAA {
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
	@JoinColumn(name = "joinColumnCustom")
	private EntityBB entityBB;

	public EntityBB getEntityB() {
		return entityBB;
	}

	public void setEntityB(EntityBB entityB) {
		this.entityBB = entityB;
	}
}
