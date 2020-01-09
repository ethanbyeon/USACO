package _2014;

/*
ID: ethanby1
LANG: JAVA
TASK: combo
*/

import java.util.*;
import java.io.*;

public class combo {
	
	static Scanner in;
	static PrintWriter out;

	static int N;
	static int[] farmer = new int[3];
	static int[] master = new int[3];
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("combo.in"));
			out = new PrintWriter(new File("combo.out"));
			
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
		String[] joe = (in.nextLine()).split(" ");
		String[] mc = (in.nextLine()).split(" ");
		
		for(int i = 0; i < 3; i++) {
			farmer[i] = Integer.parseInt(joe[i]);
			master[i] = Integer.parseInt(mc[i]);
		}
	}
	
	private static String solve() {
		String result = "";
		
		int count = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				for(int k = 1; k <= N; k++) {
					if(comb(i,j,k,farmer[0],farmer[1],farmer[2])
							|| comb(i,j,k,master[0],master[1],master[2])) {
						count++;
					}
				}
			}
		}
		result = "" + count;
		
		return result + "\n";
	}
	
	private static boolean comb(int x, int y, int z, int c, int c2, int c3) {
		return check(x, c) && check(y, c2) && check(z, c3);
	}
	
	private static boolean check(int a, int b) {
		if(Math.abs(a - b) <= 2) return true;
		if(Math.abs(a - b) >= N - 2) return true;
		return false;
	}
}

