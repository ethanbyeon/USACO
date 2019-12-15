

/*
ID: ethanby1
LANG: JAVA
TASK: ride
*/

import java.util.*;
import java.io.*;

public class whereami {
	
	static Scanner in;
	static PrintWriter out;

	static int N;
	static String S;
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("whereami.in"));
			out = new PrintWriter(new File("whereami.out"));
			
			init();
			
			out.print(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static void init() {
		N = Integer.parseInt(in.nextLine());
		S = in.nextLine();
	}
	
	static String solve() {
		String result = "";
		int[] list = new int[N];
		
		for(int i = 0; i < N; i++) {
			String temp = S.substring(i, i + 1);
			int index = 0;
			
			for(int j = i + 1; j < N; j++) {
				if(!(S.substring(j, j + 1).equals(temp))) {
					index = j;
				}
			}
		}
		
		return result;
	}
}
