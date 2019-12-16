package nestedEmbeddedClasses;

import javax.persistence.Embeddable;

@Embeddable
public class ClassB {
	private boolean gender;

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "ClassB{" + "gender'" + gender + '}';
	}
}
