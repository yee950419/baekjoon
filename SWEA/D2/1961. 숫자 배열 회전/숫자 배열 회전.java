import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution{
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int T;
	private static int N;
	private static int[][] arrays;
	
	public static void main(String[] args) throws IOException {
	
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		
		for(int testCase=1; testCase<=T; testCase++) {
			
			sb.append("#" + testCase + "\n");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			arrays = new int[N][N];
			inputArrays();
			getResult();
			
		}
	}
	
	static void inputArrays() throws IOException {
		
		for(int i=0; i<N; i++) {
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				
				arrays[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void getResult() {
		
		for(int i=0; i<N; i++) {
			
			for(int j=0; j<N; j++) {
				
				sb.append(arrays[N-j-1][i]);
			}
			
			sb.append(" ");
			for(int j=0; j<N; j++) {
				
				sb.append(arrays[N-i-1][N-j-1]);
			}
			sb.append(" ");
			
			for(int j=0; j<N; j++) {
				
				sb.append(arrays[j][N-i-1]);
			}			
			sb.append("\n");
		}
	}
}