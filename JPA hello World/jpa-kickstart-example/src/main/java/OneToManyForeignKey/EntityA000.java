package OneToManyForeignKey;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "EntityA000")
public class EntityA000 {
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
	@JoinColumn(name = "MY_FK_COL")
	private List<EntityA011> entityB;


	public List<EntityA011> getEntityB() {
		return entityB;
	}

	public void setEntityB(List<EntityA011> entityB) {
		this.entityB = entityB;
	}

	@Override
	public String toString() {
		return "Parent [id=" + id + ", entityB=" + entityB + "]";
	}

}
