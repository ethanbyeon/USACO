package _2018._JAN;

import java.util.*;
import java.io.*;

public class outofplace {
	
	static Scanner in;
	static PrintWriter out;
    
    static int N;
	static int[] cow, copy;
	public static void main(String[] args) {

		try {
			in = new Scanner(new File("outofplace.in"));
			out = new PrintWriter(new File("outofplace.out"));
			
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

        cow = new int[N];
        copy = new int[N];

        for(int i = 0; i < cow.length; i++){
            cow[i] = in.nextInt();
            copy[i] = cow[i];
        }
        Arrays.sort(copy);
    }

    static int solve() {
        
        int count = 0;

        for(int i = 0; i < N; i++){
            if(cow[i] != copy[i]) count++;
        }

        return count - 1;
    }
}