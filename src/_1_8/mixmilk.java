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
		for(int i = 0; i < 100; i++) {
			int milk = 0;
			
			if(j < 2) {
				milk = buckets[j] + buckets[j + 1];
				if(milk <= cap[j + 1]) {
					buckets[j + 1] = milk;
					buckets[j] = 0;
				}else {
					buckets[j + 1] = cap[j + 1];
					buckets[j] = milk - cap[j + 1];
				}
			}else if(j == 2){
				milk = buckets[j] + buckets[j - 2];
				if(milk <= cap[j - 2]) {
					buckets[j - 2] = milk;
					buckets[j] = 0;
				}else {
					buckets[j - 2] = cap[j - 2];
					buckets[j] = milk - cap[j - 2];
				}
			}
			j++;
			
			if(j > 2) j = 0;
		}
		
		result = "" + buckets[0] + "\n" + buckets[1] + "\n" + buckets[2];
		return result;
	}
}
