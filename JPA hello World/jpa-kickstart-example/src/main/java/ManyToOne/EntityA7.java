package ManyToOne;

import javax.persistence.*;

@Entity
@Table(name = "EntityA7")
public class EntityA7 {
	@Id
	@GeneratedValue
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	private EntityA8 entityA8;

	public EntityA8 getEntityA8() {
		return entityA8;
	}

	public void setEntityA8(EntityA8 entityA8) {
		this.entityA8 = entityA8;
	}

	@Override
	public String toString() {
		return "EntityA7 [id=" + id + ", entityB=" + entityA8 + "]";
	}

}
