package _1_2;

/*
ID: ethanby1
LANG: JAVA
TASK: milk2 
*/

import java.util.*;
import java.io.*;

public class milk2 {
	
	static Scanner in;
	static PrintWriter out;
	static int N;
	static String[] times;
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("milk2.in"));
			out = new PrintWriter(new File("milk2.out"));
			
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
		times = new String[N];
		
		for(int i = 0; i < times.length; i++) {
			times[i] = in.nextLine();
		}
	}
	
	private static String solve() {
		String result = "";
		
		farmer[] f = new farmer[N];
		for(int i = 0; i < f.length; i++) {
			String[] t = times[i].split(" ");
			f[i] = new farmer(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
		}
		Arrays.sort(f);
		
		int start = f[0].s;
		int end = f[0].e;
		int milk = f[0].e - f[0].s;
		int stop = 0;
		
		for(int i = 1; i < f.length; i++) {
			if(end >= f[i].s && end <= f[i].e) {
				end = f[i].e;
			}
			
			milk = Math.max(end - start, milk);
			
			if(f[i].s > end) {
				milk = Math.max(end - start, milk);
				stop = Math.max(stop, f[i].s - end);
				start = f[i].s;
				end = f[i].e;
			}
		}
		result = milk + " " + stop;
		
		return result;
	}
	
	static class farmer implements Comparable<farmer>{
		
		int s;
		int e;
		
		public farmer(int start, int end) {
			s = start;
			e = end;
		}
		
		@Override
		public int compareTo(farmer o) {
			// TODO Auto-generated method stub
			Integer a = this.s;
			Integer b = o.s;
			
			return a.compareTo(b);
		}
		
	}
}
