package _1_8._December;

/*
ID: ethanby1
LANG: JAVA
TASK: ride
*/

import java.util.*;
import java.io.*;

public class backforth {
	
	static Scanner in;
	static PrintWriter out;

	static int[] first;
	static int[] sec;
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("backforth.in"));
			out = new PrintWriter(new File("backforth.out"));
			
			init();
			
			out.print(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		first = new int[10];
		sec = new int[10];
		
		String[] fsplit = (in.nextLine()).split(" ");
		String[] secsplit = (in.nextLine()).split(" ");
		
		for(int i = 0; i < 10; i++) {
			first[i] = Integer.parseInt(fsplit[i]);
			sec[i] = Integer.parseInt(secsplit[i]);
		}
	}
	
	private static int solve() {
		int result = 0;
		int mon = 1000;
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < ; j++) {
				
			}
		}
		
		return result;
	}
}

