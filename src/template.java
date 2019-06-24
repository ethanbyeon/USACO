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
	
	private static void init() {
		//Get Data
		//Initialize Input Variables
		
		
	}
	
	private static String solve() {
		//Process and Output
		String result = "";
		
		
		return result;
	}
}
