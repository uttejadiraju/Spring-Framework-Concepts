package embeddedClasses;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Parent {
    @Id
    @GeneratedValue
    private int id;

    @Embedded
    private ClassA classARef;

    public ClassA getClassARef() {
        return classARef;
    }

    public void setClassARef(ClassA classARef) {
        this.classARef = classARef;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "id=" + id +
                ", classARef=" + classARef +
                '}';
    }
}
