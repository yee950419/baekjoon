import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int T, N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws NumberFormatException, IOException {
		
		for(int testCase=1; testCase<=T; testCase++) {
			sb.append("#" + testCase + "\n");
			
			makeSnailMap();
			
		}
	}
	
	static void makeSnailMap() throws NumberFormatException, IOException {
		
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		int count = 1;
		int dc = 0;
		int dr = 0;
		int minDc = 1;
		int minDr = 0;
		int maxDc = N-1;
		int maxDr = N-1;
		boolean isRightAndDown = true;
		
		while(count <= N*N) {
			map[dc][dr] = count;
			if(isRightAndDown) {
				if(dr < maxDr) {
					dr++;
				}
				else if(dc < maxDc) {
					dc++;
				}
				
				if(dr == maxDr && dc == maxDc) {
					maxDr--;
					maxDc--;
					isRightAndDown = false;
				}
			}
			else {
				if(dr > minDr) {
					dr--;
				}
				else if(dc > minDc) {
					dc--;
				}
				
				if(dr == minDr && dc == minDc) {
					minDr++;
					minDc++;
					isRightAndDown = true;
				}
			}
			
			count++;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		
	}
}