package test;

import java.util.ArrayList;

public class StrOps
{

    public static void main(String[] args)
    {

	/*
	 * String str1="Cal"; String str2="Cal";
	 * System.out.println(str1==str2);
	 * String str3=new String("Cal");
	 * System.out.println(str3==str1);
	 */

	ArrayList<Integer> a = new ArrayList<>();
	for (int i = -3; i < 3; i++)
	    a.add(i);
	System.out.println("Data : " + a);

	// way01
	/*
	 * for(int i=-1;i<3;i++) { a.remove(new Integer(i)); }
	 */

	// way02
	while (a.size() != 0)
	{
	    System.out.println(a.remove(0));

	}
	System.out.println("Data : " + a);

    }
}
