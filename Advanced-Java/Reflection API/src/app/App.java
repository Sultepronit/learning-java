package app;

import java.util.Arrays;

class User {
	public int code;
}

class Employee extends User {
	private int id;
	public String name;
	
	private void calculate() {
		
	}
}

public class App {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Class<Employee> clazz = Employee.class;
		System.out.println(clazz);
		System.out.println(Arrays.asList(clazz.getFields()));
		System.out.println(Arrays.asList(clazz.getDeclaredFields()));
		
		System.out.println();
		Arrays.asList(clazz.getMethods()).forEach(System.out::println);
		
		System.out.println();
		Arrays.asList(clazz.getDeclaredMethods()).forEach(System.out::println);
		
	}

}
