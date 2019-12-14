package _1_8._December;

import java.util.*;
import java.io.*;

public class blist {
	static Scanner in;
	static PrintWriter out;
	
	static int N;
	static int S;
	static int E;
	static int B;
	
	public static void main(String[] args) {
		
		try {
			in = new Scanner(new File("blist.in"));
			out = new PrintWriter(new File("blist.out"));
			
			out.print(solve());
			
			out.close();
			in.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static int solve() {
		N = in.nextInt();
		
		int[] cows = new int[1001];
		for(int i = 0; i < N; i++) {
			S = in.nextInt();
			E = in.nextInt();
			B = in.nextInt();
			
			for(int j = S; j <= E; j++) {
				cows[j] += B;
			}
		}
		
		Arrays.sort(cows);
		return cows[1000];
	}
}
