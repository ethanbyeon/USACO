
/*
ID: ethanby1
LANG: JAVA
TASK: ride
*/

import java.util.*;
import java.io.*;

public class gymnastics {
	
	static Scanner in;
	static PrintWriter out;

	static int K;
	static int N;
	static String[] list;
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("gymnastics.in"));
			out = new PrintWriter(new File("gymnastics.out"));
			
			init();
			
			out.print(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static void init() {
		String[] first = (in.nextLine()).split(" ");
		K = Integer.parseInt(first[0]);
		N = Integer.parseInt(first[1]);
		list = new String[N];
	}
	
	static String solve() {
		String result = "";
		String ans = "";
		
		for(int i = 0; i < K; i++) {
			String[] sp = (in.nextLine()).split(" ");
			for(int j = 0; j < N; j++) {
				for(int k = j + 1; k < N; k++) {
					list[i] += " " + sp[j] + sp[k] + " ";
				}
				System.out.println(list[i]);
			}
		}
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			String[] sp = list[i].split(" ");
			for(int j = i + 1; j < N; j++) {
				if(list[j].contains(sp[i])) {
					count++;
				}
			}
		}
		
		return result;
	}
}
