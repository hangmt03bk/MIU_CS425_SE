package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;


public class MyStudentRecordsMgmtApp {
	public List<Student> getListOfPlatinumAlumniStudents(List<Student> stList){
		LocalDate now = LocalDate.now();
		Period per30y = Period.ofYears(30);
		List<Student> platList = stList.stream()
				.filter(s -> Period.between(s.getDateOfAdmission(), now).getYears() >= per30y.getYears())
				.sorted((s1,s2)->s2.getDateOfAdmission().compareTo(s1.getDateOfAdmission()))
				.collect(Collectors.toList());
		return platList;
	}
	
	public void printListOfStudents(List<Student> stList) {
		stList.sort((s1,s2) -> s1.getName().compareTo(s2.getName()));
		stList.forEach(s -> System.out.println(s));
	}
	
	public void printHelloWorld(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i]%5 == 0) System.out.print("Hello");
			if(arr[i]%7 == 0) System.out.print("World");
			System.out.print(" ");
		};
		System.out.println();
	}
	
	public int findSecondBiggest(int[] arr) {
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max1) {max2 = max1; max1 = arr[i];}
			else if (arr[i] > max2) max2 = arr[i];
		}
		return max2;
	}
	
	public static void main(String[] args) {
		List<Student> stList = new ArrayList();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		stList.add(new Student("110001", "Dave", LocalDate.parse("11/18/1951", formatter)));
		stList.add(new Student("110002", "Anna", LocalDate.parse("12/07/1990", formatter)));
		stList.add(new Student("110003", "Erica", LocalDate.parse("01/31/1974", formatter)));
		stList.add(new Student("110004", "Carlos", LocalDate.parse("08/22/2009", formatter)));
		stList.add(new Student("110005", "Bob", LocalDate.parse("03/05/1990", formatter)));
		
		MyStudentRecordsMgmtApp app = new MyStudentRecordsMgmtApp();
		//------------3.3-----------------------------
		System.out.println("3.3 List of student ---------------");
		app.printListOfStudents(stList);
		System.out.println();
		
		//------------3.4-----------------------------
		System.out.println("3.4 List of Platinum Alumni student ---------------");
		List<Student> platList = app.getListOfPlatinumAlumniStudents(stList);
		platList.forEach(s -> System.out.println(s));
		System.out.println();
		
		//------------3.5.1-----------------------------
		System.out.println("3.5.1 Hello World ---------------");
		int[] arr1 = {3,4,5,6,7,35,36};
		for(int i = 0; i < arr1.length; i++) System.out.print(arr1[i] + " ");
		System.out.print("-> print: ");
		app.printHelloWorld(arr1);
		System.out.println();
		
		//------------3.5.2-----------------------------
		System.out.println("3.5.1 Second Biggest ---------------");
		int[] arr2 = {1,2,3,4,5};
		for(int i = 0; i < arr2.length; i++) System.out.print(arr2[i] + " ");
		System.out.println("-> second biggest: " + app.findSecondBiggest(arr2));
		
		int[] arr3 = {19,9,11,0,12};
		for(int i = 0; i < arr3.length; i++) System.out.print(arr3[i] + " ");
		System.out.println("-> second biggest: " + app.findSecondBiggest(arr3));

		System.out.println();
	}
}
