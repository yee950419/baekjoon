import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Monkey {
		int x;
		int y;
		int cnt;
		int horseSkill;
		
		public Monkey(int x, int y, int cnt, int horseSkill) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.horseSkill = horseSkill;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int K, W, H;
	static int[][] map;
	static boolean[][][] visited;
	static int min;
	static int cnt;
	static int[] dr = {-1, 0, 1, 0, -2, -2, -1, 1, 2, 2, 1, -1};
	static int[] dc = {0, 1, 0, -1, -1, 1, 2, 2, 1, -1, -2, -2};
	
	public static void main(String[] args) throws IOException {
		
		K = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		visited = new boolean[H][W][K+1];
		map = new int[H][W];
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt = 0;
		min = Integer.MAX_VALUE;
		bfs();
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(min);
		}
		
	}
	
	static void bfs() {
		Queue<Monkey> q = new LinkedList<>();
		Monkey monkey = new Monkey(0, 0, 0, K);
		visited[monkey.x][monkey.y][monkey.horseSkill] = true;
		q.offer(monkey);
		
		while(!q.isEmpty()) {
			Monkey curMonkey = q.poll();
			
			if(curMonkey.x == H-1 && curMonkey.y == W-1) {
				min = curMonkey.cnt;
				return;
			}
			
			if(curMonkey.horseSkill > 0) {
				for(int i=4; i<12; i++) {
					int dx = dr[i] + curMonkey.x;
					int dy = dc[i] + curMonkey.y;
					
					if(dx >= 0 && dx < H && dy >= 0 && dy < W && map[dx][dy] != 1) {
						
						if(!visited[dx][dy][curMonkey.horseSkill-1]) {
							visited[dx][dy][curMonkey.horseSkill-1] = true;
							q.offer(new Monkey(dx, dy, curMonkey.cnt + 1, curMonkey.horseSkill-1));
						}
					}
				}
			}

			for(int i=0; i<4; i++) {
				int dx = dr[i] + curMonkey.x;
				int dy = dc[i] + curMonkey.y;
				
				if(dx >= 0 && dx < H && dy >= 0 && dy < W && map[dx][dy] != 1) {
					
					if(!visited[dx][dy][curMonkey.horseSkill]) {
						visited[dx][dy][curMonkey.horseSkill] = true;
						q.offer(new Monkey(dx, dy, curMonkey.cnt + 1, curMonkey.horseSkill));
					}
				}
			}

		}
	}
}
