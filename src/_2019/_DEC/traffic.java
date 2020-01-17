package _2019._DEC;

/*
ID: ethanby1
LANG: JAVA
TASK: ride
*/

import java.util.*;
import java.io.*;

public class traffic {
	
	static Scanner in;
	static PrintWriter out;

	static int N;
	static int[] on;
	static int[] none;
	static int[] off;
	static ArrayList<Integer> start;
	static ArrayList<Integer> end;
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("traffic.in"));
			out = new PrintWriter(new File("traffic.out"));
			
			init();
			
			out.print(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		
		on = new int[2];
		none = new int[2];
		off = new int[2];
		
		start = new ArrayList<Integer>();
		end = new ArrayList<Integer>();
		
		N = Integer.parseInt(in.nextLine());
		for(int i = 0; i < N; i++) {
			String[] sp = (in.nextLine()).split(" ");
			
			if(sp[0].equals("on")) {
				on[0] = Integer.parseInt(sp[1]);
				on[1] = Integer.parseInt(sp[2]);
			}else if(sp[0].equals("none")) {
				none[0] = Integer.parseInt(sp[1]);
				none[1] = Integer.parseInt(sp[2]);
			}else {
				off[0] = Integer.parseInt(sp[1]);
				off[1] = Integer.parseInt(sp[2]);
			}
			
			start.add(Integer.parseInt(sp[1]));
			end.add(Integer.parseInt(sp[2]));
		}
		
		Collections.sort(start);
		Collections.sort(end);
	}
	
	private static String solve() {
		String result = "";
		
		return result;
	}
}
