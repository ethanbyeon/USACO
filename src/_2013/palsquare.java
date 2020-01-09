package _2013;

/*
ID: ethanby1
LANG: JAVA
TASK: palsquare
*/

import java.util.*;
import java.io.*;

public class palsquare {
	
	static Scanner in;
	static PrintWriter out;

	static char[] loc = {'0','1','2','3','4','5','6','7','8','9',
            			 'A','B','C','D','E','F','G','H','I','J'};
	static int N;
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("palsquare.in"));
			out = new PrintWriter(new File("palsquare.out"));
			
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
	}
	
	private static boolean isPalindrome(String a) {
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) != a.charAt(a.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}
	
	private static String toBase(int x, int base, char[] c) {
		StringBuilder sb = new StringBuilder();
		
		int val = x;
		while(val >= base) {
			sb.insert(0, loc[val % base]);
			val = val / base;
		}
		return sb.insert(0, loc[val]).toString();
	}
	
	private static String solve() {
		String result = "";
		
		for(int i = 1; i <= 300; i++) {
			String sqr = toBase(i * i,N,loc);
			
			if(isPalindrome(sqr)) {
				result += (toBase(i,N,loc) + " " + sqr) + "\n";
			}
		}
		
		return result;
	}
}
