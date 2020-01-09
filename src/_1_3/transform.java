package _1_3;

import java.io.File;
import java.io.PrintWriter;

/*
ID: ethanby1
LANG: JAVA
TASK: transform
*/

import java.util.*;

public class transform {

	static Scanner in;
	static PrintWriter out;

	static int N;
	static char[][] og;
	static char[][] tran;
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("transform.in"));
			out = new PrintWriter(new File("transform.out"));
			
			init();
			
			out.println(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		N = Integer.parseInt(in.nextLine());
		og = new char[N][N];
		tran = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String input = in.nextLine();
			for(int j = 0; j < N; j++) {
				og[i][j] = input.charAt(j);
			}
		}
		
		for(int k = 0; k < N; k++) {
			String next = in.nextLine();
			for(int m = 0; m < N; m++) {
				tran[k][m] = next.charAt(m);
			}
		}
	}
	
	private static char[][] rotate(char[][] r){
		char[][] c = new char[N][N];
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				c[i][j] = r[N - j - 1][i];
			}
		}
		
		return c;
	}
	
	private static char[][] reflect(char[][] f){
		char[][] c = new char[N][N];
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				c[i][N - 1 - j] = f[i][j];
			}
		}
		
		return c;
	}
	
	private static boolean compareSquare(char[][] a, char[][] b) {
		if(a.length != b.length) return false;
		if(a[0].length != b[0].length) return false;
		if(a[0].length != a.length) return false;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++ ) {
				if(a[i][j] != b[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static int transforms(char[][] o, char[][] t) {
		if(compareSquare(rotate(o),t)) return 1;
		if(compareSquare(rotate(rotate(o)),t)) return 2;
		if(compareSquare(rotate(rotate(rotate(o))),t)) return 3;
		if(compareSquare(reflect(o),t)) return 4;
		if(compareSquare(reflect(rotate(o)),t) || compareSquare(reflect(rotate(rotate(o))),t) || 
				compareSquare(reflect(rotate(rotate(rotate(o)))),t)) return 5;
		if(compareSquare(o,t)) return 6;
		else return 7;
	}
	
	private static String solve() {
		String result = "";
		result = "" + transforms(og,tran);
		return result;
	}
	
}
