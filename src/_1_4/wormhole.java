package _1_4;

/*
ID: ethanby1
LANG: JAVA
TASK: wormhole
*/

import java.util.*;
import java.io.*;

public class wormhole {
	
	static Scanner in;
	static PrintWriter out;
	
	static int N;
	static int[] pair;
	static int[] x;
	static int[] y;
	static int[] hasRight;
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("wormhole.in"));
			out = new PrintWriter(new File("wormhole.out"));
			
			init();
			
			out.print(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		N = in.nextInt();
		x = new int[N + 1];
		y = new int[N + 1];
		pair = new int[N + 1];
		hasRight = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			
			x[i] = x1;
			y[i] = y1;
			
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(x[j] > x[i] && y[i] == y[j]) {
					if(hasRight[i] == 0 || x[j] - x[i] < x[hasRight[i]] - x[i]){
						hasRight[i] = j;
					}
				}
			}
		}
	}
	
	private static String solve() {
		String result = "";
		result = "" + recurr();
		
		return result + "\n";
	}
	
	private static int recurr() {
		int total = 0;
		int i = 0;
		
		for(i = 1; i <= N; i++) {
			if(pair[i] == 0) {
				break;
			}
		}
		
		if(i > N) {
			if(isCycle()) {
				return 1;
			}else {
				return 0;
			}
		}
		
		for(int j = i + 1; j <= N; j++) {
			if(pair[j] == 0) {
				pair[i] = j;
				pair[j] = i;
				total += recurr();
				pair[i] = pair[j] = 0;
			}
		}
		
		return total;
	}
	
	public static boolean isCycle() {
		for(int start = 1; start <= N; start++) {
			int pos = start;
			for(int count = 0; count < N; count++) {
				pos = hasRight[pair[pos]];
			}
			
			if(pos != 0) {
				return true;
			}
		}
		
		return false;
	}
}

