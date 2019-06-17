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
	static String inFile = "xxx.in";
	static String outFile = "xxx.out";
	
	static String result = "";
	static String[] list;
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File(inFile));
			out = new PrintWriter(new File(outFile));
			
			init();
			result = solve();
			
			out.println(result);
			
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
		return result;
	}
}
