import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static String S;
	static int T, N;
	
	public static void main(String[] args) throws IOException {

		T = Integer.parseInt(br.readLine());
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		
		for(int testCase=1; testCase<=T; testCase++) {
			
			sb.append("#" + testCase + " ");
			
			getIsAvailable();
		}
	}
	
	static void getIsAvailable() throws IOException {
		
		N = Integer.parseInt(br.readLine());
		S = br.readLine();
		
		if(N % 2 != 0) {
			sb.append("No\n");
		}
		else {
			String s1 = S.substring(0, N/2);
			String s2 = S.substring(N/2);
			
			if(s1.equals(s2)) {
				sb.append("Yes\n");
			}
			else {
				sb.append("No\n");
			}
		}
	}
}