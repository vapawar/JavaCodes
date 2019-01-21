package test;

public enum StudentMapper
{

	ARTS(10001), SCIENCE(10000), COMMERCE(10002);
	private int bno;

	private StudentMapper(int branch)
	{
		this.bno = branch;
	}

	public int getCode()
	{
		return bno;
	}
}
