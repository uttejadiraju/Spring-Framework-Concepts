package embeddedClasses;

import javax.persistence.Embeddable;

@Embeddable
public class ClassA {
	private String myStr;
	private int myInt;

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
		return "ClassA{" + "myStr='" + myStr + '\'' + ", myInt=" + myInt + '}';
	}
}
