package OneToMany;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "EntityA000")
public class EntityA00 {
	@Id
	@GeneratedValue
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToMany
	private List<EntityA01> entityB;


	public List<EntityA01> getEntityB() {
		return entityB;
	}

	public void setEntityB(List<EntityA01> entityB) {
		this.entityB = entityB;
	}

	@Override
	public String toString() {
		return "Parent [id=" + id + ", entityB=" + entityB + "]";
	}

}
