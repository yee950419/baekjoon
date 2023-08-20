import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		for(int i=1; i<N+1; i++) {
			String str = br.readLine();
			int idx = 0;
			for(int j=1; j<M+1; j++) {
				map[i][j] = str.charAt(idx) - '0';
				idx++;
			}
		}
		
		visited = new boolean[N+1][M+1];
		bfs(new int[]{1, 1});
		
		System.out.println(map[N][M]);
	}
	
	static void bfs(int[] point) {
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(point);
		visited[point[0]][point[1]] = true;
		
		while(!q.isEmpty()) {
			point = q.poll();
			if(point[0] == N && point[1] == M) {
				break;
			}
			
			for(int i=0; i<4; i++) {
				int dx = point[0] + dr[i];
				int dy = point[1] + dc[i];
				
				if(dx >= 0 && dx < N+1 && dy >= 0 && dy < M+1 
						&& !visited[dx][dy] && map[dx][dy] == 1) {
					visited[dx][dy] = true;
					map[dx][dy] = map[point[0]][point[1]] + 1;
					q.offer(new int[] {dx, dy});
				}
			}
		}
	}
}