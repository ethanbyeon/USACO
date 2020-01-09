package _2012;

/*
ID: ethanby1
LANG: JAVA
TASK: ride
*/

import java.util.*;
import java.io.*;

public class ride {
	
	static Scanner in;
	static PrintWriter out;
	
	static String[] list;
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("ride.in"));
			out = new PrintWriter(new File("ride.out"));
			
			init();
			
			out.println(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		//Get Data
		//Initialize Input Variables
		
		list = new String[2];
		list[0] = in.nextLine();
		list[1] = in.nextLine();
	}
	
	private static String solve() {
		//Process and Output
		String result = "";
		if(convert(list[0]) == convert(list[1])) result = "GO";
		else result = "STAY";
		return result;
	}
	
	private static int convert(String s) {
		int product = 1;
		for(int i = 0; i < s.length(); i++) {
			product *= s.charAt(i) - 'A' + 1;
		}
		
		product %= 47;

		return product;
	}
}

