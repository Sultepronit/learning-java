package app;

import java.util.Arrays;
import java.util.Date;

class User {
	public int code;
}

class Employee extends User {
	private int id;
	public String name;
	
	private void calculate() {
		
	}
	
	public boolean setUpdated(Date updated, int index) {
		return true;
	}
}

public class App {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, NoSuchMethodException {
		
		Class<Employee> clazz = Employee.class;
		System.out.println(clazz);
		System.out.println(Arrays.asList(clazz.getFields()));
		System.out.println(Arrays.asList(clazz.getDeclaredFields()));
		
		System.out.println();
		Arrays.asList(clazz.getMethods()).forEach(System.out::println);
		//Arrays.asList(clazz.getMethods()).forEach(d -> System.out.println(d));
		System.out.println();
		Arrays.asList(clazz.getDeclaredMethods()).forEach(System.out::println);
		
		System.out.println();
		var nameField = clazz.getField("name");
		System.out.println(nameField);
		
		System.out.println();
		var calculateMethod = clazz.getDeclaredMethod("calculate");
		System.out.println(calculateMethod);
		var setUpdatedMethod = clazz.getMethod("setUpdated", Date.class, int.class);
		System.out.println(setUpdatedMethod);
		
		var methodExists = Arrays.stream(clazz.getDeclaredMethods()).anyMatch(m -> m.getName().equals("setUpdated"));
		System.out.println(methodExists);
		
	}

}
