package _1_4;

/*
ID: ethanby1
LANG: JAVA
TASK: crypt1
*/

import java.util.*;
import java.io.*;

public class crypt1 {
	
	static Scanner in;
	static PrintWriter out;

	static int N;
	static int[] list;
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("crypt1.in"));
			out = new PrintWriter(new File("crypt1.out"));
			
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
		list = new int[N];
		
		String[] val = (in.nextLine()).split(" ");
		for(int i = 0; i < val.length; i++) {
			list[i] = Integer.parseInt(val[i]);
		}
	}
	
	private static String solve() {
		String result = "";
		
		int count = 0;
		for(int i = 100; i <= 999; i++) {
			for(int j = 10; j <= 99; j++) {
				if(isValid(i, list) && isValid(j, list) && isProd(i, j, list)) {
					count++;
				}
			}
		}
		result = "" + count;
		
		return result + "\n";
	}
	
	public static boolean isValid(int x, int[] list) {
		while(x > 0) {
			int dig = x % 10;
			if(! contains(dig, list)) {
				return false;
			}
			x /= 10;
		}
		
		return true;
	}
	
	public static boolean contains(int x, int[] list) {
		for(int i = 0; i < list.length; i++) {
			if(list[i] == x) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isProd(int a, int b, int[] digs) {
		int bF = Integer.parseInt(Integer.toString(b).substring(0,1));
		int fProd = a * (b % 10);
		int sProd = a * bF;
		int fin = 10 * sProd + fProd;
		
		if(! isValid(fProd, list) || ! isValid(sProd, list) || ! isValid(fin, list)) {
			return false;
		}
		
		if(digCount(fProd) != 3 || digCount(sProd) != 3 || digCount(fin) != 4) {
			return false;
		}
		
		return true;
	}
	
	public static int digCount(int a) {
		int count = 0;
		while(a > 0) {
			count++;
			a /= 10;
		}
		return count;
	}
}

