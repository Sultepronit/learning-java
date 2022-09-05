package app;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Repository<T> {
	public void save(T t) {
		//System.out.println(t);
		var clazz = t.getClass();
		
		var fields = clazz.getDeclaredFields();
		
		for(var field: fields) {
			var annotations = field.getDeclaredAnnotationsByType(Field.class);
			System.out.println(Arrays.asList(annotations));
			if(annotations.length > 0) System.out.println(field);
		}
		
		var fieldList = Arrays
			.stream(fields)
			.filter(f -> f.getAnnotationsByType(Field.class).length > 0)
			.collect(Collectors.toList());
		System.out.println();
		System.out.println(fieldList);
	}
}
