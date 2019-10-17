import java.util.*;
import java.io.*;

public class paint {
	static Scanner in;
	static PrintWriter out;
	static int a;
	static int b;
	static int c;
	static int d;
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("paint.in"));
			out = new PrintWriter(new File("paint.out"));
			init();
			out.println(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		a = in.nextInt();
		b = in.nextInt();
		c = in.nextInt();
		d = in.nextInt();
	}
	
	private static int solve() {
		int result = 0;
		for(int i = 0; i < 100; i++) {
			if(i >= a && i + 1 <= b) {
				result++;
			}else if(i >= c && i + 1 <= d) {
				result++;
			}
		}
		return result;
	}
}