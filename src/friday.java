
/*
ID: ethanby1
LANG: JAVA
TASK: friday
*/

import java.util.*;
import java.io.*;

public class friday {
	
	static Scanner in;
	static PrintWriter out;
	
	static int[] list;
	static int N;
	static int[] dates = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static int[] leapDays = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static int date = 0;
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("friday.in"));
			out = new PrintWriter(new File("friday.out"));
			
			init();
			
			out.print(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		N = Integer.parseInt(in.nextLine()) + 1900;
		list = new int[7]; 	//MON-SUN
	}
	
	private static String solve() {
		String result = "";
		int calendar = 0;
		for(int i = 1900; i < N; i++) {	
			for(int month = 0; month < 12; month++) {	
				int day = (calendar + 12) % 7;
				list[day]++;
				calendar += isLeap(i) ? leapDays[month] : dates[month];		
			}
		}
		
		result = list[5] + " " + list[6] + " " + list[0] + " " + list[1] + 
					" " + list[2] + " " + list[3] +  " " + list[4] + "\n";
		return result;
	}
	
	public static boolean isLeap(int year) {
        if (year % 100 == 0) {
            return year % 400 == 0;
        } else {
            return year % 4 == 0;
        }
    }
	
	
}
