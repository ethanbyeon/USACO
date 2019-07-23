//package _1_4;

/*
ID: ethanby1
LANG: JAVA
TASK: skidesign
*/

import java.util.*;
import java.io.*;

public class skidesign {
	
	static Scanner in;
	static PrintWriter out;

	static int[] list;
	static int N;
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("skidesign.in"));
			out = new PrintWriter(new File("skidesign.out"));
			
			init();
			
			out.print(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		N = Integer.parseInt(in.nextLine());
		list = new int[N];
		
		for(int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(in.nextLine());
		}
	}
	
	private static String solve() {
		String result = "";
		
		int minCost = 1000000000;
		for(int i = 0; i <= 83; i++) {
			int cost = 0;
			int x = 0;
			
			for(int j = 0; j < N; j++) {
				if(list[j] < i) {
					x = i - list[j];
				}else if(list[j] > i + 17) {
					x = list[j] - (i + 17);
				}else {
					x = 0;
				}
				cost += x * x;
			}
			minCost = Math.min(minCost,cost);
		}
		
		result = "" + minCost;
		return result + "\n";
	}
}

