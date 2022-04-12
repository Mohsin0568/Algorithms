package com.systa.algo.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsDemo {

	public static void main(String[] args) {
		Employee emp1 = new Employee("Fifty", 50);
		Employee emp2 = new Employee("Ten", 10);
		Employee emp3 = new Employee("Fiteen", 15);
		Employee emp4 = new Employee("TwentyOne", 21);
		Employee emp5 = new Employee("TwentyFive", 25);
		Employee emp6 = new Employee("Tweleve", 12);
		Employee emp7 = new Employee("Thirty", 30);
		Employee emp8 = new Employee("Thirty-Duplicate", 30);
		
		List<Employee> list = Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6, emp7, emp8);
		
		Optional<Employee> maxAge = list.stream().max(Comparator.comparing(Employee :: getAge));
		System.out.println("Max age is of " + maxAge);
		
		Optional<Employee> minAge = list.stream().min(Comparator.comparing(Employee :: getAge));
		System.out.println("Min age is of " + minAge);
		
		String nameWithAgeGreaterThanTwenty = list.stream()
			.filter(s -> s.getAge() > 20)
			.map(s -> s.getName())
			.collect(Collectors.joining(", "));
		
		System.out.println("nameWithAgeGreaterThanTwenty " + nameWithAgeGreaterThanTwenty);
		
		Map<Integer, List<Employee>> mapOfEmployeeWithAgeGreaterThanTwenty = 
				list.stream()
					.filter(s -> s.getAge() > 20)
					.collect(Collectors.groupingBy(Employee :: getAge));
		
		System.out.println("mapOfEmployeeWithAgeGreaterThanTwenty " + mapOfEmployeeWithAgeGreaterThanTwenty);
		
		Map<Integer, Long> mapOfTotalEmployeeCountGroupByAge = 
				list.stream()					
					.collect(Collectors.groupingBy(Employee :: getAge, Collectors.counting())); // the downstream collector
		
		System.out.println("mapOfTotalEmployeeCountGroupByAge " + mapOfTotalEmployeeCountGroupByAge);
		
		
		// It will have employee objects in a list group by Age
		Map<Integer, List<String>> listOfEmployeeNamesGroupByAge =
				list.stream()
					.collect(Collectors.groupingBy(Employee :: getAge, Collectors.mapping(Employee :: getName, Collectors.toList())));
		System.out.println("listOfEmployeeNamesGroupByAge " + listOfEmployeeNamesGroupByAge);
		
		
		Map<Integer, Set<String>> setOfEmployeeNamesInSortedGroupByAge =
				list.stream()
					.collect(Collectors.groupingBy(Employee :: getAge, Collectors.mapping(Employee :: getName, Collectors.toSet())));
		System.out.println("setOfEmployeeNamesInSortedGroupByAge " + setOfEmployeeNamesInSortedGroupByAge);
		
		Map<Integer, String> stringOfEmployeeNamesSeperatedByCommaGroupByAge = 
				list.stream()
					.collect(Collectors.groupingBy(Employee :: getAge, Collectors.mapping(Employee :: getName, Collectors.joining(","))));
		
		System.out.println("stringOfEmployeeNamesSeperatedByCommaGroupByAge " + stringOfEmployeeNamesSeperatedByCommaGroupByAge);
		
		
	}
}


class Employee{
	
	String name;
	int age;
	
	
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}	
}
