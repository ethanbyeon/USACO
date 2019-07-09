package _1_3;

/*
ID: ethanby1
LANG: JAVA
TASK: dualpal
*/
import java.util.*;
import java.io.*;

public class dualpal {
	
	static Scanner in;
	static PrintWriter out;

	static int findNum;
	static int smallNum;
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("dualpal.in"));
			out = new PrintWriter(new File("dualpal.out"));
			
			init();
			
			out.print(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		String[] input = (in.nextLine()).split(" ");
		findNum = Integer.parseInt(input[0]);
		smallNum = Integer.parseInt(input[1]);
	}
	
	private static boolean twoBases(int val) {
		int countPalin = 0;
		
		for(int i = 2; i <= 10; ++i) {
			final String valBase = toBase(val,i);
			
			if(isPalindrome(valBase)) {
				++countPalin;
				
				if(countPalin >= 2) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static String toBase(int num, int base) {
		StringBuilder sb = new StringBuilder();
		
		while(num > 0) {
			sb.append(num % base);
			num /= base;
		}
		return sb.toString();
	}
	
	private static boolean isPalindrome(String str) {
		for(int i = 0; i < str.length() / 2; ++i) {
			if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}

	private static String solve() {
		String result = "";

		for(int i = smallNum + 1; i <= Integer.MAX_VALUE; ++i) {
			if(twoBases(i)) {
				result += i + "\n";
				
				if(--findNum <= 0) {
					break;
				}
			}
		}
		
		return result;
	}
}

