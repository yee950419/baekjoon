import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int R, C;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static Queue<int[]> hedgehog = new LinkedList<>();
	static Queue<int[]> water = new LinkedList<>();
	static char[][] map;
	static int minTime;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		visited = new boolean[R][C];
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
				
				if(map[i][j] == '*') {
					water.offer(new int[] {i, j});
				}
				else if(map[i][j] == 'S') {
					hedgehog.offer(new int[] {i, j, 0});
				}
			}
		}
		
		minTime = Integer.MAX_VALUE;
		bfs();
		
		if(minTime == Integer.MAX_VALUE) {
			System.out.println("KAKTUS");
		}
		else {
			System.out.println(minTime);
		}
	}
	
	static void bfs() {
		
		while(!hedgehog.isEmpty()) {
			
			waterFlooded();
			
			for(int i=0, size = hedgehog.size(); i<size; i++) {
				int[] hedgehogPoint = hedgehog.poll();
				visited[hedgehogPoint[0]][hedgehogPoint[1]] = true;
				for(int j=0; j<4; j++) {
					
					int dx = dr[j] + hedgehogPoint[0];
					int dy = dc[j] + hedgehogPoint[1];
					int time = hedgehogPoint[2];
					
					if(dx >= 0 && dx < R && dy >= 0 && dy < C && !visited[dx][dy]) {
						visited[dx][dy] = true;
						if(map[dx][dy] == '.') {
							map[dx][dy] = 'S';
							hedgehog.offer(new int[] {dx, dy, time+1});
						}
						else if(map[dx][dy] == 'D') {
							if(minTime > (time + 1)) {
								minTime = (time + 1);
								return;
							}
						}
					}
				}
			}
		}
	}
	
	static void waterFlooded() {
		for(int i=0, size=water.size(); i<size; i++) {
			int[] waterPoint = water.poll();
			
			for(int j=0; j<4; j++) {
				int dx = dr[j] + waterPoint[0];
				int dy = dc[j] + waterPoint[1];
				
				if(dx >= 0 && dx < R && dy >= 0 && dy < C && map[dx][dy] == '.') {
					map[dx][dy] = '*';
					water.offer(new int[] {dx, dy});
				}
			}
		}
	}
}