import java.util.*;
import java.io.*;

public class sleepy {
	
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("sleepy.in"));
			out = new PrintWriter(new File("sleepy.out"));
			out.print(solve());
			out.close();
			in.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int solve() {
		int count = 0;
		
		int[] c = new int[in.nextInt()];
		for(int i = 0; i < c.length; i++) {
			c[i] = in.nextInt();
		}
		
		for(int i = c.length - 1; i > 0; i--) {
			if(c[i - 1] > c[i]) {
				count = i;
				break;
			}
		}
		
		return count;
	}
}
