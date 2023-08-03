import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int T, N, M;
	static int[][] map;
	static int[][] sumMap;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		
		for(int testCase=1; testCase<=T; testCase++) {
			sb.append("#" + testCase + " ");
			
			inputDatas();
			getMaxFlyKill();
		}
	}
	
	static void inputDatas() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void getMaxFlyKill() {
		
		int kill=0;
		int maxKill=0;
		// 전체 맵 순회
		for(int i=0; i<N-M+1; i++) {
			for(int j=0; j<N-M+1; j++) {
				
				kill=0;
				// 파리채 크기만큼 kill
				for(int k=i; k<i+M; k++) {
					for(int l=j; l<j+M; l++) {
						kill += map[k][l];
					}
				}
				maxKill = kill > maxKill ? kill : maxKill;
			}
		}
		
		sb.append(maxKill + "\n");
	}
}