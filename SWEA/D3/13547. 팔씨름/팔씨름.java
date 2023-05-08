import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int T;
	private static String S;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		
		for(int testCase=1; testCase<=T; testCase++) {
			
			sb.append("#" + testCase + " ");
			
			getPossibility();
		}
	}
	
	static void getPossibility() throws IOException {
		st = new StringTokenizer(br.readLine());
		S = st.nextToken();
		int loseCount = 0;
		boolean hasPossibilityToWin = true;
		
		for(int i=0; i<S.length(); i++) {
			if(S.charAt(i) == 'x') {
				loseCount++;
				if(loseCount == 8) {
					hasPossibilityToWin = false;
				}
			}
		}
		
		if(hasPossibilityToWin) {
			sb.append("YES\n");
		}
		else {
			sb.append("NO\n");
		}
	}
}