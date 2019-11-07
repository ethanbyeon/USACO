package _1_6;

/*
ID: ethanby1
LANG: JAVA
TASK: cowsignal
*/

import java.util.*;
import java.io.*;

public class cowsignal {
	
	static Scanner in;
	static PrintWriter out;

	static int r;
	static int c;
	static int k;
	static char[][] grid;
	static char[][] big;
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("cowsignal.in"));
			out = new PrintWriter(new File("cowsignal.out"));
			
			init();
			
			out.print(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		String[] line = (in.nextLine()).split(" ");
		r = Integer.parseInt(line[0]);
		c = Integer.parseInt(line[1]);
		k = Integer.parseInt(line[2]);
		
		grid = new char[r][];
		for(int i = 0; i < r; i++) {
			grid[i] = in.next().toCharArray();
		}
	}
	
	private static String solve() {
		String result = "";
		
		big = new char[r*k][c*k];
		for(int i = 0; i < r*k; i+=k) {
			for(int j= 0; j < c*k; j+=k) {
				for(int a = 0; a < k; a++) {
					for(int b = 0; b < k; b++) {
						big[i + a][j + b] = grid[i / k][j / k];
					}
				}
			}
		}
		
		for(int i = 0; i < r * k; i++) {
			out.println(new String(big[i]));
		}
		
		return result;
	}
}

