import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int T;
	private static int N;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		loopTest();
		System.out.println(sb);
	}

	static void loopTest() throws IOException {
		
		for(int testCase=1; testCase<=T; testCase++) {
			sb.append("#" + testCase + " ");
			
			getTeamCount();
		}
	}
	
	static void getTeamCount() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		int teamCount = N/3;
		
		sb.append(teamCount + "\n");
	}
}