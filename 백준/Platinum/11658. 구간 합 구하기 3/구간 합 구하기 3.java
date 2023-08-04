import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M;
	static int[][] map;
	static int[][] sumMap;
	
	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sumMap = new int[N+1][N+1];
		map = new int[N+1][N+1];
		for(int i=1; i<N+1; i++) {
			
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				int input = Integer.parseInt(st.nextToken());
				map[i][j] = input;
				sumMap[i][j] += sumMap[i][j-1] + input;
			}
		}

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			
			if(op == 0) {
				getCaseZeroResult();
			}
			else if(op == 1) {
				getCaseOneResult();
			}
		}
	}
	
	static void getCaseZeroResult() {
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int z = Integer.parseInt(st.nextToken());
		
		int dif = z - map[x][y];

		for(int i=y; i<N+1; i++) {
			sumMap[x][i] = sumMap[x][i] + dif;
		}
		map[x][y] = z;
	}
	
	static void getCaseOneResult() {
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());

		int sum=0;
		for(int i=x1; i<=x2; i++) {
			sum += sumMap[i][y2] - sumMap[i][y1-1];
		}
		
		System.out.println(sum);
	}
}
