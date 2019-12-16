package jpaGeneratorSeqAuto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MyObject")
public class MyObject {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
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
