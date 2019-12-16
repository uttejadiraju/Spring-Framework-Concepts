package jpaGeneratorSeq;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MyObject")
public class MyObject1 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public int getObjId() {
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
