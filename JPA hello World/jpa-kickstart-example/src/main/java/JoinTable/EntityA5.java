package JoinTable;

import javax.persistence.*;

@Entity
@Table(name = "Parent")
public class EntityA5 {
	@Id
	@GeneratedValue
	private int id;

	public int getId() {
		return id;
	}

	public void setIdA(int idA) {
		this.id = id;
	}

	public EntityB5 getEntityB() {
		return entityB;
	}

	public void setEntityB(EntityB5 entityB) {
		this.entityB = entityB;
	}

	@OneToOne
	@JoinTable(name = "MY_JOIN_TABLE", joinColumns = {
			@JoinColumn(name = "ENTITYA_FK", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "ENTITYB_FK", referencedColumnName = "id") })
	private EntityB5 entityB;
}
