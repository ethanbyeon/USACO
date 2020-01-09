package _2019._DEC;

public class factorial {
	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		int[] b = {5,6,7,8};
		
//		for(int i = 0; i < a.length; i++) {
//			String out = "";
//			for(int j = 0; j < b.length; j++) {
//				out = a[i] + "" + b[j];
//				System.out.println(out);
//			}
//		}
		
		for(int z = 0; z < a.length; z++) {
			String out = "";
			for(int y = z + 1; y < a.length; y++) {
				for(int x = y + 1; x < a.length; x++) {
					for(int w = x + 1; w < a.length; w++ ) {
						out = a[z] + "" + a[y] + "" + a[x] + "" + a[w];
						System.out.println(out);
					}
				}
			}
		}
		
	}
}
