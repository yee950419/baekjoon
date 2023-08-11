import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[][] map;
	static int availableCount;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visit = new boolean[N][N];
		for(int i=0; i<N; i++) {
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		availableCount = 0;
		dfs(0, 1, 0);
		
		System.out.println(availableCount);
	}
	
	static void dfs(int x, int y, int dir) {
		
		if(x == N-1 && y == N-1) {
			availableCount++;
			return;
		}
		if(dir == 0) {
			goRight(x, y);
		}
		else if(dir == 1) {
			goRightDown(x, y);
		}
		else if(dir == 2) {
			goDown(x, y);
		}
		
	}
	
	static void goRight(int x, int y) {
		if(y+1 < N && map[x][y+1] != 1) {
			dfs(x, y+1, 0);
		}
		if(x+1 < N && y+1 < N && map[x+1][y+1] != 1 && map[x][y+1] != 1 && map[x+1][y] != 1) {
			dfs(x+1, y+1, 1);
		}
	}
	
	static void goRightDown(int x, int y) {
		if(y+1 < N && map[x][y+1] != 1) {
			dfs(x, y+1, 0);
		}
		if(x+1 < N && map[x+1][y] != 1) {
			dfs(x+1, y, 2);
		}
		if(x+1 < N && y+1 < N && map[x+1][y+1] != 1 && map[x][y+1] != 1 && map[x+1][y] != 1) {
			dfs(x+1, y+1, 1);
		}
	}
	
	static void goDown(int x, int y) {
		if(x+1 < N && map[x+1][y] != 1) {
			dfs(x+1, y, 2);
		}
		if(x+1 < N && y+1 < N && map[x+1][y+1] != 1 && map[x][y+1] != 1 && map[x+1][y] != 1) {
			dfs(x+1, y+1, 1);
		}
	}
}
