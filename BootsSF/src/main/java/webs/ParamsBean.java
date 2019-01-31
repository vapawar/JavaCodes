package webs;

import org.springframework.beans.factory.annotation.Required;

public class ParamsBean {

	private int id;
	private String name;

	@Required
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.id + "::" + this.name;
	}
}
