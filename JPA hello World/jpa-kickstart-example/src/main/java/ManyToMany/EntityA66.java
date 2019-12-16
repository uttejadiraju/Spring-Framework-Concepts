package ManyToMany;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "EntityA66")
public class EntityA66 {
	@Id
	@GeneratedValue
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToMany
	private List<EntityA77> entityB;

	public List<EntityA77> getEntityB() {
		return entityB;
	}

	public void setEntityB(List<EntityA77> entityB) {
		this.entityB = entityB;
	}

	@Override
	public String toString() {
		return "Parent [id=" + id + ", entityB=" + entityB + "]";
	}

}
