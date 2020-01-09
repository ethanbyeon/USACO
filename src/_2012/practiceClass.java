package _2012;

import java.util.Arrays;

public class practiceClass {
	
	public static void main(String[] args) {
		student [] list = new student[4];
			list[0] = new student("Julia", 'C', 2);
			list[1] = new student("HyeonChae", 'A', 4);
			list[2] = new student("Ethan", 'B', 3);
			list[3] = new student("YunJu", 'A', 4);
		Arrays.sort(list);
		
		for(int i = 0; i < list.length; i++) {
			System.out.println(list[i].name + " ");
		}
		
		//declare a variable
		int a;
		a = 5;
		//declare a reference variable
		student s1;
		s1 = new student("Julia", 'C', 2);
		//address
		
		System.out.println(a);
		System.out.println(s1);
	}
	
	static class student implements Comparable<student>{
		
		//data fields
		//constructor: initialize data field
			//default 
			//regular constructor: parameter (specific)
		//method
		
		String name;
		char letter;
		int gpa;
		
		public student(String n, char l, int g) {
			name = n;
			letter = l; 
			gpa = g;
		}

		@Override
		public int compareTo(student that) {
			// TODO Auto-generated method stub
			return that.gpa - this.gpa;
		}
	}
}