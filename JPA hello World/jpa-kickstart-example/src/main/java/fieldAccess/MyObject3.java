package fieldAccess;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MyObject")
public class MyObject3 {
	@Id
	@Access(AccessType.FIELD)
	private int id;

	public int getObjId() {
		System.out.println("GETTER CALLED!!! WHILE CREATING!!! --------- ");
		return id;
	}

	public void setObjId(int objId) {
		this.id = objId;
	}

	@Override
	public String toString() {
		return "MyObject{" + "objId=" + id + "}";
	}
}
