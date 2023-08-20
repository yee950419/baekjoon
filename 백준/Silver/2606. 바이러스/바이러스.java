import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, E;
	static int map[][];
	static int count;
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		visited = new boolean[N+1];
		map = new int[N+1][N+1];
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1;
		}
		
		dfs(1);
		count--;
		System.out.println(count);
	}
	
	static void dfs(int v) {
		
		visited[v] = true;
		count++;
		
		for(int i=1; i<=N; i++) {
			if(map[v][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(i);
			}
		}
	}
}