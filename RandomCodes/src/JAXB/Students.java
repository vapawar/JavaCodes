package JAXB;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Students {

    List<Student> students = null;

    @XmlElement(name = "student")
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> l1) {
        this.students = l1;
    }
}
