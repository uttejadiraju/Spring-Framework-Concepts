package jpaSeqGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MyObject")
public class MyObject2 {
	@Id
	@SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 1, allocationSize = 50)
	@GeneratedValue(generator = "mySeqGen")
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
