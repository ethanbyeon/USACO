package _1_9;
import java.util.*;
import java.io.*;

public class shell {
	
	static Scanner in;
	static PrintWriter out;
	static int N;
	static int[] S;
	static int[] A;
	static int[] B;
	static int[] G;
		
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("shell.in"));
			out = new PrintWriter(new File("shell.out"));
			init();
			out.print(solve());
			out.close();
			in.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void init() {
		N = in.nextInt();
		A = new int[N];
		B = new int[N];
		G = new int[N];
		
		for(int i = 0; i < N; i++) {
			A[i] = in.nextInt() - 1;
			B[i] = in.nextInt() - 1;
			G[i] = in.nextInt() - 1;
		}
	}
	
	public static int solve() {
		int max = 0;
		
		for(int i = 0; i < 3; i++) {
			int count = 0;
			S = new int[3];
			S[i] = 1;
			for(int j = 0; j < N; j++) {
				swap(A[j],B[j]);
				if(S[G[j]] == 1) {
					count++;
				}
			}
			max = Math.max(count,max);
		}
		
		return max;
	}
	
	public static void swap(int a, int b) {
		int t = S[a];
		S[a] = S[b];
		S[b] = t;
	}
}