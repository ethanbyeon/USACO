package _2013;

/*
ID: ethanby1
LANG: JAVA
TASK: namenum
*/

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

public class namenum {
	static Scanner in;
	static PrintWriter out;

	static Scanner read;
	static String name;
	static List<String> dict;
	static List<String> let;

	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("namenum.in"));
			out = new PrintWriter(new File("namenum.out"));
			read = new Scanner(new File("dict.txt"));
			
			init();
			
			out.print(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() throws IOException {
		name = in.nextLine();
		let = new ArrayList<String>();
	}
	
	private static String convert(String s){
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < s.length(); i++){
			sb.append(map(s.charAt(i)));
		}
		return sb.toString();
	}
	
	private static char map(char c){
		switch(c){
			case 'A': case 'B':	case 'C': return '2';
			case 'D': case 'E': case 'F': return '3';
			case 'G': case 'H': case 'I': return '4';
			case 'J': case 'K': case 'L': return '5';
			case 'M': case 'N': case 'O': return '6';
			case 'P': case 'R': case 'S': return '7';
			case 'T': case 'U': case 'V': return '8';
			case 'W': case 'X': case 'Y': return '9';
		}
		return 0;
	}
	
	private static List<String> readDict() {
		List<String> names = new ArrayList<String>(); 
	
		while(read.hasNextLine()) {
			names.add(read.nextLine());
		}
		
		return names;
	}
	
	private static String solve() {
		String result = "";
		
		dict = readDict();
		for(String s : dict) {
			if(convert(s).equals(name)) {
				let.add(s);
			}
		}
		
		if(let.size() == 0) 
			result = "NONE" +"\n";
		else{
			Collections.sort(let);
			for(String s: let) {
				result += s + "\n";		
			}
		}

		return result;
	}
}
