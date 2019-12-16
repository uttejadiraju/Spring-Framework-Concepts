package embeddedId;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {
	public Person(PersonInfo personInfo) {
		super();
		this.personInfo = personInfo;
	}

	@EmbeddedId
	private PersonInfo personInfo;

	@Override
	public String toString() {
		return "Person [personInfo=" + personInfo + "]";
	}

	public Person() {

	}
}
