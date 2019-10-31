package _1_6;

/*
ID: ethanby1
LANG: JAVA
TASK: cowsignal
*/

import java.util.*;
import java.io.*;

public class cowsignal {
	
	static Scanner in;
	static PrintWriter out;

	static int n;
	static int len;
	static int fact;
	static String[] og;
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("cowsignal.in"));
			out = new PrintWriter(new File("cowsignal.out"));
			
			init();
			
			out.print(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		String[] line = (in.nextLine()).split(" ");
		n = Integer.parseInt(line[0]);
		len = Integer.parseInt(line[1]);
		fact = Integer.parseInt(line[2]);
		
		og = new String[n];
		for(int i = 0; i < n; i++) {
			og[i] = in.nextLine();
			System.out.println(og[i]);
		}
	}
	
	private static String solve() {
		String result = "";
		String[] sig = new String[n * fact];
		int[] numX = new int[n];
		int[] numD = new int[n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < og[i].length(); j++){
				if(og[i].charAt(j) == 'X') {
					numX[i]++;
				}
				if(og[i].charAt(j) == '.'){
					numD[i]++;
				}
			}
		}

		for(int i = 0; i < n; i++) {
			int xIndex = og[i].indexOf("X");
			int dIndex = og[i].indexOf(".");
			
			String addX = "";
			String addDot = "";
			String addedX = "";
			String addedDot = "";
			for(int j = 0; j < og[i].length(); j++) {
				if(j == xIndex) {
					for(int k = 0; k < numX[i]; k++) {
						addX += "X";
					}
					
				}
				
				if(j == dIndex) {
					for(int l = 0; l < numD[i]; l++) {
						addDot += ".";
					}
					
				}
				
				og[i] = addX + addDot;
				System.out.println(og[i]);
			}
		}
		
		return result;
	}
}

