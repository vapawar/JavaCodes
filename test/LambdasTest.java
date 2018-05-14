package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.SortedMap;

@SuppressWarnings("all")
public class LambdasTest 
{

	public static void main(String[] args) 
	{
	
		ArrayList a=new ArrayList<>();
		a.add("data1");
		a.add(1234);
		a.forEach(ax->System.out.println(ax));
		
		HashMap hm=new HashMap<>();
		hm.put("1216", "number 1216");
		hm.put(112, 1837912);
		hm.put(12.343, "None");		
		hm.forEach((k,v)->System.out.println("Key: "+k+"    Value: "+v));
	}
}
