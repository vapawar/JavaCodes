package test;

public class MethodTest
{

    public static void main(String[] args)
    {
	int t1 = 12;
	int t2 = 23;
	String t3 = "blah";
	StorageMetas sm = new StorageMetas();
	sm.setName("test01");
	sm.setNumber(123123);
	sm.setType("OLD");

	System.out.println("Before :" + (t1 + t2) + " " + t3 + " " + sm.toString());
	new MethodTest().updateData(t1, t2, t3, sm);
	System.out.println("After :" + (t1 + t2) + " " + t3 + " " + sm.toString());
    }

    public void updateData(int x, int y, String z, StorageMetas sx)
    {
	x = 40;
	y = 50;
	z = "blahblah";
	sx.setName("TEST02");
	sx.setNumber(12980);
	sx.setType("RAID");
    }
}
