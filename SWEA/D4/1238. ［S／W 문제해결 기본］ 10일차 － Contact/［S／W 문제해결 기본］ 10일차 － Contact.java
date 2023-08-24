import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static final int T = 10;
	static int N, V;
	static int map[][];
	static boolean[] visited;
	static int maxV;
	
	public static void main(String[] args) throws IOException {
		
		for(int tc=1; tc<=T; tc++) {
			sb.append("#" + tc + " ");
			
			map = new int[101][101];
			visited = new boolean[101];
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				map[from][to] = 1;
			}
			
			maxV = 0;
			bfs(V);
			sb.append(maxV + "\n");
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			maxV = 0;
			for(int i=0; i<size; i++) {
				v = q.poll();
				if(maxV < v) {
					maxV = v;
				}
				for(int j=1; j<=100; j++) {
					if(map[v][j] == 1 && !visited[j]) {
						visited[j] = true;
						q.offer(j);
					}
				}
			}
		}
	}
}