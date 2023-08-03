import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	static int[][] sumMap;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sumMap = new int[N+1][N+1];
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				//구간 합 구하기
				sumMap[i][j] = sumMap[i][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		int x1, y1, x2, y2;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			/*
			 * x1~x2 까지 y2값에서 y1-1값 빼기
			 * (2,2)  (3,4) 일 경우, 2~3 까지 sumMap[x][4]값에서 sumMap[x][2-1]값 빼기
			 */
			int result = 0;
			for(int j=x1; j<=x2; j++) {
				result += sumMap[j][y2] - sumMap[j][y1-1];
			}
			sb.append(result + "\n");
		}
		
		System.out.println(sb);
	}
}