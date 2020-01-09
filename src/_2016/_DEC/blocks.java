package _2016._DEC;

/*
ID: ethanby1
LANG: JAVA
TASK: ride
*/

import java.util.*;
import java.io.*;

public class blocks {
	static Scanner in;
	static PrintWriter out;

	static int n;
	static String[] word;
	static int first[];
	static int sec[];
	static int fin[];
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("blocks.in"));
			out = new PrintWriter(new File("blocks.out"));
			
			init();
			out.print(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		n = in.nextInt();
		word = new String[2 * n];
		first = new int[26];
		sec = new int[26];
		fin = new int[26];
		
		in.nextLine();
		
		for(int i = 0; i < n * 2; i+=2) {
			word[i] = in.next();
			word[i + 1] = in.next();
		}
	}
	
	private static String solve() {
		for(int i = 0; i < word.length; i++) {
			first = new int[26];
			sec = new int[26];
			for(int j = 0; j < word[i].length(); j++) {
				first[word[i].charAt(j) - 'a']++;
			}
			//System.out.println(word[i] + " " + Arrays.toString(first));
			i++;
			for(int k = 0; k < word[i].length(); k++) {
				sec[word[i].charAt(k) - 'a']++;
			}
			//System.out.println(word[i] + " " + Arrays.toString(sec));
			for(int c = 0; c < 26; c++) {
				fin[c] += Math.max(first[c], sec[c]);
			}
			//System.out.println("tot " + Arrays.toString(fin));
		}
		
		String s = "";
		for(int i = 0; i < fin.length; i++) {
			s += fin[i] + "\n";
		}
		return s;
	}
}
