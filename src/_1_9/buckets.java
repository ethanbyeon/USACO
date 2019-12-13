package _1_9;

/*
ID: ethanby1
LANG: JAVA
TASK: ride
*/

import java.util.*;
import java.io.*;

public class buckets {
	
	static Scanner in;
	static PrintWriter out;
	
	static int[][] map;
	static int[] barn;
	static int[] rock;
	static int[] lake;
	
	public static void main(String [] args) {
		
		try {
			in = new Scanner(new File("buckets.in"));
			out = new PrintWriter(new File("buckets.out"));
			
			init();
			
			out.print(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		map = new int[10][10];
		
		barn = new int[2];
		rock = new int[2];
		lake = new int[2];
		
		for(int i = 0; i < 10; i++) {
			String line = in.nextLine();
			for(int j = 0; j < 10; j++) {
				if(line.charAt(j) == '.') {
					map[i][j] = 0;
				}else if(line.charAt(j) == 'B') {
					map[i][j] = 2;
					barn[0] = i;
					barn[1] = j;
				}else if(line.charAt(j) == 'R') {
					map[i][j] = 3;
					rock[0] = i;
					rock[1] = j;
				}else if(line.charAt(j) == 'L') {
					map[i][j] = 4;
					lake[0] = i;
					lake[1] = j;
				}
			}
		}
	}
	
	private static int solve() {
		int cows = 0;
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(map[i][j] == 4) {
					BFS(i,j);
					cows++;
				}
			}
		}
		return cows;
	}
	
	private static void BFS(int i, int j) {
		Queue<Integer> q = new LinkedList<Integer>();;
		int dx[] = {-1,1,0,0};
		int dy[] = {0,0,-1,1};
		
		q.add(i);
		q.add(j);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();
			map[x][y] = 0;
			
			for(int c = 0; c < 4; c++) {
				int nx = x + dx[c];
				int ny = y + dy[c];
				
				if(nx < 0 || nx >= 10 || ny < 0 || ny >= 10) continue;
				
				if(map[nx][ny] == 0 && map[nx][ny] != 3) {
					q.add(nx);
					q.add(ny);
					map[nx][ny] = map[x][y] + 1;
				}
			}
		}
		
	}
}

//implementation
//blist
//complete search (back and forth)
