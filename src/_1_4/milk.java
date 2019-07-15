package _1_4;

/*
ID: ethanby1
LANG: JAVA
TASK: milk
*/

import java.util.*;
import java.io.*;
import java.util.Collections;

public class milk {
	
	static Scanner in;
	static PrintWriter out;

	static int A;
	static int F;
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("milk.in"));
			out = new PrintWriter(new File("milk.out"));
			
			init();
			
			out.print(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		String[] demand = in.nextLine().split(" ");
		A = Integer.parseInt(demand[0]);
		F = Integer.parseInt(demand[1]);
	}
	
	private static String solve() {
		String result = "";
		
		List<Farmer> farmers = new ArrayList<Farmer>();
		
		for(int i = 0; i < F; i++) {
			String[] idv = in.nextLine().split(" ");
			farmers.add(new Farmer(Integer.parseInt(idv[0]), Integer.parseInt(idv[1])));
		}
		
		Collections.sort(farmers, new Comparator<Farmer>() {
			@Override
			public int compare(Farmer a, Farmer b){
				return a.getPrice() - b.getPrice();
			}
		});
		
		int amount = 0;
		int price = 0;
		
		for(Farmer f : farmers) {
			if(f.getAmount() + amount >= A) {
				int diff = A - amount;
				price += diff * f.getPrice();
				amount += diff;
				break;
			}else {
				amount += f.getAmount();
				price += f.getPrice() * f.getAmount();
			}
		}
		result = "" + price;
		
		return result + "\n";
	}
	
	static class Farmer{
		private final int amount;
		private final int price;
		
		public Farmer(int prc, int amt) {
			price = prc;
			amount = amt;
		}
		
		public int getAmount() {
			return amount;
		}
		
		public int getPrice() {
			return price;
		}
		
		public String toString() {
			return price + "";
		}
	}
}

