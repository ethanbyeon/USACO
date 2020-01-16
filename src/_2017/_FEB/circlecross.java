package _2017._FEB;

import java.util.*;
import java.io.*;

public class circlecross {
	
	static Scanner in;
    static PrintWriter out;
    
	public static void main(String[] args) {

		try {
			in = new Scanner(new File("circlecross.in"));
			out = new PrintWriter(new File("circlecross.out"));
			
			out.print(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

    static int solve() {

        int count = 0;

        String s = in.nextLine();

        String temp = "";
        for(int i = 'A'; i <= 'Z'; i++){
            int first = s.indexOf(i);
            int last = s.lastIndexOf(i);
            temp = s.substring(first + 1, last);

            int[] letter = new int[26];

            for(int j = 0; j < temp.length(); j++){
                int n = temp.charAt(j) - 'A';
                letter[n]++;
            }

            for(int k = 0; k < 26; k++){
                if(letter[k] == 1) count++;
            }
        }

        return count / 2;
    }
}