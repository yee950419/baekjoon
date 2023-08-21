import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static char[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int normalCount, jucksackCount;
	static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N];
		map = new char[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		normalCount = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					normalCount++;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 'G') {
					map[i][j] = 'R';
				}
			}
		}
		
		visited = new boolean[N][N];
		jucksackCount = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					jucksackCount++;
				}
			}
		}
		
		System.out.println(normalCount + " " + jucksackCount);
	}
	
	static void dfs(int x, int y) {
		
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int dx = dr[i] + x;
			int dy = dc[i] + y;
			
			if(dx >= 0 && dx < N && dy >= 0 && dy < N) {
				if(map[dx][dy] == map[x][y] && !visited[dx][dy]) {
					visited[dx][dy] = true;
					dfs(dx, dy);
				}
			}
		}
	}
}