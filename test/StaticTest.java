package test;

public class StaticTest
{
    static
    {
	System.out.println("Static Hello..");
    }

    public static void main(String[] args)
    {
	System.out.println("Output from main");
    }
}
