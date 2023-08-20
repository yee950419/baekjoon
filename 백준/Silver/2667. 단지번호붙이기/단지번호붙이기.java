import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int count;
	static List<Integer> countList = new ArrayList<>();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					count = 0;
					bfs(new int[] {i, j});
					
					if(count > 0) {
						countList.add(count);
					}
				}
			}
		}
		
		Collections.sort(countList);
		System.out.println(countList.size());
		for(int n : countList) {
			System.out.println(n);
		}
	}
	
	static void bfs(int[] point) {
		
		Queue<int[]> q = new LinkedList<>();
		visited[point[0]][point[1]] = true;
		q.offer(point);
		
		while(!q.isEmpty()) {
			point = q.poll();
			
			for(int i=0; i<4; i++) {
				int dx = point[0] + dr[i];
				int dy = point[1] + dc[i];
				
				if(dx >= 0 && dx < N && dy >= 0 && dy < N 
						&& map[dx][dy] == 1 && !visited[dx][dy]) {
					visited[dx][dy] = true;
					q.offer(new int[] {dx, dy});
				}
			}
			
			count++;
		}
	}
}