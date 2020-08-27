package test;

import javax.xml.bind.annotation.XmlElement;

public class StorageMetas {

    private int number = 0;
    private String name = "NA";
    private String type = "Normal";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlElement
    public int getNumber() {
        return number;
    }

    public void setNumber(int snum) {
        this.number = snum;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String sname) {
        this.name = sname;
    }

    @Override
    public String toString() {
        return Integer.toString(number) + " : " + name + " : " + type;
    }
}
