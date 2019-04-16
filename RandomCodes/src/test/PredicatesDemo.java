package test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PredicatesDemo {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		List<String> strs = new ArrayList<>();
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		numbers.add(40);
		numbers.add(50);
		numbers.add(60);
		numbers.add(70);
		numbers.add(80);
		numbers.add(90);
		numbers.add(100);
		strs.add("vinod");
		strs.add("pawar");
		strs.add("");
		strs.add(null);
		strs.add("test@test.com");
		strs.add("pune");
		strs.add("123212");
		strs.add("demo@test.com");
		strs.add("!@#$!$@^!&%@!");
		strs.add("Java");
		strs.add("120");
		strs.add("coder");
		Predicate<Integer> smallNumbers = x -> x < 60;

		numbers.stream().filter(x -> x >= 60).forEach(x -> System.out.println("number >= 60 : " + x));
		System.out.println("-----------------------------------------");
		numbers.stream().filter(x -> x < 60).forEach(x -> System.out.println("number < 60 : " + x));
		System.out.println("-----------------------------------------");
		numbers.stream().filter(smallNumbers).map(number -> process(number))
				.forEach(x -> System.out.println("small number/4: " + x));
		System.out.println("-----------------------------------------");
		strs.stream().filter(x -> x != null).filter(str -> isEmailValid(str))
				.forEach(x -> System.out.println("email: " + x));
		System.out.println("-----------------------------------------");
		strs.stream().filter(x -> x != null).filter(str -> !isEmailValid(str))
				.forEach(x -> System.out.println("noemail: " + x));
		System.out.println("-----------------------------------------");
		strs.stream().filter(x -> x != null).filter(str -> str.length() > 0)
				.filter(str -> str.matches("([A-Za-z\\s_])*")).map(str -> str.toUpperCase())
				.forEach(x -> System.out.println("words: " + x));
		System.out.println("-----------------------------------------");
		strs.stream().filter(x -> x != null).filter(str -> str.length() > 0).filter(str -> !str.matches("[\\w]+"))
				.filter(str -> !isEmailValid(str)).forEach(x -> System.out.println("special chars: " + x));
		System.out.println("-----------------------------------------");
		strs.stream().filter(x -> x != null).filter(str -> str.length() > 0).filter(str -> str.matches("[\\w]+"))
				.map(str -> str.toUpperCase()).forEach(x -> System.out.println("\\w: " + x));
		System.out.println("-----------------------------------------");
		strs.stream().filter(x -> x != null).filter(str -> str.matches("[\\d]+")).map(str -> Integer.parseInt(str) * 12)
				.forEach(x -> System.out.println("12*number: " + x));
		System.out.println("-----------------------------------------");
		numbers.stream().reduce(Integer::sum).ifPresent(x -> System.out.println("sum: " + x));
		System.out.println("sum: " + numbers.stream().reduce(Integer::sum).get());
		System.out.println("-----------------------------------------");
		numbers.stream().filter(x -> x < 60).collect(Collectors.toList())
				.forEach(x -> System.out.println("x < 60: " + x));
		// boolean z = numbers.removeIf(x -> x > 60);
		System.out.println("-----------------------------------------");
		numbers.forEach(x -> System.out.println("x: " + x));
	}

	static Integer process(Integer number) {
		return number / 4;
	}

	static boolean isEmailValid(String email) {
		final Pattern EMAIL_REGEX = Pattern.compile(
				"[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
				Pattern.CASE_INSENSITIVE);
		return EMAIL_REGEX.matcher(email).matches();
	}
}