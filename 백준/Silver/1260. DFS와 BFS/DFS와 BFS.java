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
	static StringBuilder sb = new StringBuilder();
	
	static int N, M, V;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1;
		}
		
		visited = new boolean[N+1];
		dfs(V);
		
		sb.append("\n");
		Arrays.fill(visited, false);
		bfs(V);
		
		System.out.println(sb);
	}
	
	static void dfs(int v) {
		visited[v] = true;
		sb.append(v + " ");
		
		for(int i=1; i<=N; i++) {
			if(map[v][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(i);
			}
		}
	}
	
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			v = q.poll();
			sb.append(v + " ");
			
			for(int i=1; i<=N; i++) {
				if(map[v][i] == 1 && !visited[i]) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
	}
}
