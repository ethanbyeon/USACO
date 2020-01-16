package _2017._FEB;

import java.util.*;
import java.io.*;

public class crossroad {
	
	static Scanner in;
	static PrintWriter out;
    
    static int N;
	static int[] cow;
	public static void main(String[] args) {

		try {
			in = new Scanner(new File("crossroad.in"));
			out = new PrintWriter(new File("crossroad.out"));
			
			init();
			
			out.print(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static void init() {
        N = in.nextInt();
        cow = new int[11];
        Arrays.fill(cow, 2);
    }

    static int solve() {
        
        int count = 0;

        for(int i = 0; i < N; i++){
            int id = in.nextInt();
            int check = in.nextInt();
            if(cow[id] != 2 && cow[id] != check) count++;
            cow[id] = check;
        }

        return count;
    }
}