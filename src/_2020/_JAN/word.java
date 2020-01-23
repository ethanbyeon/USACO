package _2020._JAN;

import java.util.*;
import java.io.*;

public class word {
	
	static Scanner in;
    static PrintWriter out;
    
    static int N, K;
    static String essay;
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("word.in"));
			out = new PrintWriter(new File("word.out"));
			
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
        K = in.nextInt();

        in.nextLine();

        essay = in.nextLine();
	}
	
	static String solve() {

        String format = "";

        int count = 0;
        String[] words = essay.split(" ");

        for(int i = 0; i < words.length; i++){
          
            count += words[i].length();
            if(count <= K){
                if(i==0) format+= words[i];   
                else format+= " "+ words[i];
            }else{
                format += "\n" + words[i];
                count = words[i].length();
            }      
        }

        return format;
	}
}