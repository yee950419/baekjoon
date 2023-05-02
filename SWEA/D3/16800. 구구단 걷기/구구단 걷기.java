import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int T;
	private static Long N;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		
		for(int testCase=1; testCase<=T; testCase++) {
			
			sb.append("#" + testCase + " ");
			
			getLessDistance();
		}
	}
	
	static void getLessDistance() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		
		long distance = 0;
		long lessDistance = N;
		for(long i=1; i*i<=N; i++) {
			
			if(N%i == 0) {
				
				distance = i + N/i - 2;
				if(lessDistance > distance) {
					lessDistance = distance;
				}
			}
		}
		
		sb.append(lessDistance + "\n");
	}
}