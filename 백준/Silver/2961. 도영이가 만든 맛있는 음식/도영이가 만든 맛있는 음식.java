import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, sin, ssun;
	static int[][] SB;
	static boolean[] visit;
	static int minScore = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine());
		SB = new int[N][2];
		visit = new boolean[N];
		
		for(int i=0; i<N; i++) {
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<SB[0].length; j++) {
				SB[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sin = 1;
		ssun = 0;
		int count = 0;
		getFood(0, count);
		System.out.println(minScore);
	}
	
	static void getFood(int depth, int count) {
		
		if(depth == N) {
			
			if(count > 0) {
				sin = 1;
				ssun = 0;
				for(int i=0; i<N; i++) {
					if(visit[i]) {
						sin *= SB[i][0];
						ssun += SB[i][1];
					}
				}
				int score = Math.abs(sin - ssun);
				
				if(minScore > score) {
					minScore = score;
				}
			}
			return;
		}
		
		visit[depth] = true;
		getFood(depth+1, count+1);
		visit[depth] = false;
		getFood(depth+1, count);
		
	}
}