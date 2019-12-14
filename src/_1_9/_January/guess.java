package _1_9._January;

import java.util.*;
import java.io.*;

public class guess {
	
	static Scanner in;
	static PrintWriter out;
	
	static int N;
	static ArrayList<String>[] a;
	static int g;
	
	public static void main(String[] args) {
		
		try {
			in = new Scanner(new File("guess.in"));
			out = new PrintWriter(new File("guess.out"));
			init();
			out.println(solve());
			out.close();
			in.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void init() {
		N = in.nextInt();
		a = new ArrayList[N];
		
		for(int i = 0; i < N; i++) {
			in.next();
			int n = in.nextInt();
			a[i] = new ArrayList<String>();
			for(int j = 0; j < n; j++) {
				a[i].add(in.next());	
			}
		}
	}
	
	static int solve() {
		int max = 0;
		
		for(int i = 0; i < N - 1; i++) {
			for(int j = i + 1; j < N; j++) {
				int count = 0;
				for(String p: a[i]) {
					if(a[j].contains(p)) {
						count++;
					}
				}
				max = Math.max(count, max);
			}
		}
		
		return max + 1;
	}
}
