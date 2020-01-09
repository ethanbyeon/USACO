package _2014;

/*
ID: ethanby1
LANG: JAVA
TASK: barn1
*/

import java.util.*;
import java.io.*;

public class barn1 {
	
	static Scanner in;
	static PrintWriter out;
	
	static int M;
	static int S;
	static int C;
	static int[] list;
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("barn1.in"));
			out = new PrintWriter(new File("barn1.out"));
			
			init();
			
			out.print(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		String[] barn = in.nextLine().split(" ");
		M = Integer.parseInt(barn[0]);
		S = Integer.parseInt(barn[1]);
		C = Integer.parseInt(barn[2]);
		
		list = new int[C];
		for(int i = 0; i < C; i++) {
			list[i] = Integer.parseInt(in.nextLine());
		}
		Arrays.sort(list);
	}
	
	private static String solve() {
		String result = "";
		
		int[] gap = new int[C - 1];
		for(int i = 0; i < C - 1; i++) {
			gap[i] = list[i + 1] - list[i];
		}
		Arrays.sort(gap);
		
		int sum = Math.min(M, C);
		for(int j = 0; j <= gap.length - M; j++) {
			sum += gap[j];
		}
		result = "" + sum;
		
		return result + "\n";
	}
}

