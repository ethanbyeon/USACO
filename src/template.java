
/*
ID: ethanby1
LANG: JAVA
TASK: ride
*/

import java.util.*;
import java.io.*;

public class template {
	
	static Scanner in;
	static PrintWriter out;

	static String[] list;
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("file.in"));
			out = new PrintWriter(new File("file.out"));
			
			init();
			
			out.print(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static void init() {
		
	}
	
	static String solve() {
		String result = "";
		
		
		return result;
	}
}
