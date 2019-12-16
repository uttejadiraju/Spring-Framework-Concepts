package nestedEmbeddedClasses;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class ClassA {

	private String myStr;
	private int myInt;

	@Embedded
	private ClassB classBRef;

	public ClassB getClassBRef() {
		return classBRef;
	}

	public void setClassBRef(ClassB classBRef) {
		this.classBRef = classBRef;
	}

	public String getMyStr() {
		return myStr;
	}

	public void setMyStr(String myStr) {
		this.myStr = myStr;
	}

	public int getMyInt() {
		return myInt;
	}

	public void setMyInt(int myInt) {
		this.myInt = myInt;
	}

	@Override
	public String toString() {
		return "ClassA{" + "myStr='" + myStr + '\'' + ", myInt=" + myInt + " ClassBRef= " +  classBRef + '}';
	}
}
