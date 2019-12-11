package _1_8;

/*
ID: ethanby1
LANG: JAVA
TASK: ride
*/

import java.util.*;
import java.io.*;

public class mixmilk {
	
	static Scanner in;
	static PrintWriter out;

	static int[] cap;
	static int[] buckets;
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("mixmilk.in"));
			out = new PrintWriter(new File("mixmilk.out"));
			
			init();
			
			out.print(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		cap = new int[3];
		buckets = new int[3];
		
		for(int i = 0; i < 3; i++) {
			String[] split = (in.nextLine()).split(" ");
			cap[i] = Integer.parseInt(split[0]);
			buckets[i] = Integer.parseInt(split[1]);
		}
	}
	
	private static String solve() {
		String result = "";
		
		int j = 0;
		int k = 1;
		for(int i = 0; i < 100; i++) {
			int milk = buckets[j] + buckets[j + k];
			
			if(milk <= cap[j + k]) {
				buckets[j + k] = milk;
				buckets[j] = 0;
			}else {
				buckets[j + k] = cap[j + k];
				buckets[j] = milk - cap[j + k];
			}
			j++;
			
			if(j == 1) j = 0;
				
			System.out.println(buckets[0] + " " + buckets[1] + " " + buckets[2]);
		}
		
		result = "" + buckets[0] + "\n" + buckets[1] + "\n" + buckets[2];
		return result;
	}
}
