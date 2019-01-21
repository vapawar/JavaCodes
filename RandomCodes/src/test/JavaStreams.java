package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaStreams
{
	static JavaStreams d = new JavaStreams();

	public static void main(String[] args)
	{
		Map<Object, Object> data = new HashMap<>();
		data.put("key1", "vals1");
		data.put("key1", "vals1qw");
		data.put(1234, 32879);
		data.put("1234", 32879);
		data.put("keyew", "vals14334343");
		data.put(12234, 32879);
		data.put("kerwcx", "vals15463");
		data.put(12344, 3287945);

		for (Map.Entry entry : data.entrySet())
			System.out.println(entry.getKey() + "  :::  " + entry.getValue());

		data.forEach((k, v) -> System.out.println(k + "::" + v));

		data.forEach((k, v) -> {
			System.out.println(k.toString() + v.toString());
			if (k.equals("keyew"))
				new JavaStreams().showKey(k.toString());
		});

		List<String> items = new ArrayList<>();
		items.add("Abc");
		items.add("Bcd");
		items.add("Cde");
		items.add("Def");
		items.add("Efg");

		items.forEach(JavaStreams.d::showKey);
		items.stream().filter(x -> x.equals("Def")).forEach(System.out::println);
		items.stream().filter(x -> x.contains("c")).forEach(System.out::println);
		items.stream().filter(x -> x.contains("c")).reduce((x, y) -> x + y).ifPresent(x -> System.out.print(x));
		items.stream().map(x -> new JavaStreams().getMessage(x)).forEach(System.out::println);
		List dt = items.stream().map(x -> new JavaStreams().getMessage(x)).collect(Collectors.toList());
		System.out.println("::::::::::");
		dt.forEach(System.out::println);
		data.entrySet().stream().filter(k -> k.getKey().equals("kerwcx"))
				.forEach(k -> System.out.println(k.getValue()));
	}

	private void showKey(String str)
	{
		System.out.println("----------->" + str);
	}

	void showVal(int number)
	{
		System.out.println("----------->" + number + 1000);
	}

	public String getMessage(String str)
	{
		return str + "+++++++++++++";
	}

}
