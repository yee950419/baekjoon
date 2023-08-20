import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static boolean[] isUsed = new boolean[26];
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int maxCount;
	
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
			}
		}
		
		maxCount = 1;
		dfs(0, 0, 1);
		
		System.out.println(maxCount);
	}
	
	static void dfs(int x, int y, int count) {
		
		visited[x][y] = true;
		isUsed[map[x][y] - 'A'] = true;
		
		if(count > maxCount) {
			maxCount = count;
		}
		
		for(int i=0; i<4; i++) {
			
			int dx = dr[i] + x;
			int dy = dc[i] + y;
			
			if(dx >= 0 && dx < R && dy >= 0 && dy < C) {
				int idx = map[dx][dy] - 'A';
				
				if(!isUsed[idx] && !visited[dx][dy]) {
					isUsed[idx] = true;
					visited[dx][dy] = true;
					dfs(dx, dy, count+1);
					visited[dx][dy] = false;
					isUsed[idx] = false;
				}
			}
		}
	}
}