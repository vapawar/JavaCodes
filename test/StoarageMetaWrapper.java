package test;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Root")
public class StoarageMetaWrapper
{
    private ArrayList<StorageMetas> data = new ArrayList();

    @XmlElement(name = "StorageDetails")
    public ArrayList<StorageMetas> getData()
    {
	return data;
    }

    public void setData(ArrayList<StorageMetas> data)
    {
	this.data = data;
    }
}
