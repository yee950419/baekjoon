import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int T;
	private static int P, Q, R, S, W;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		
		for(int testCase=1; testCase<=T; testCase++) {
			
			sb.append("#" + testCase + " ");
			
			getLessFee();
		}
	}
	
	static void getLessFee() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		P = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		int fee1 = P * W;
		int fee2 = 0;
		
		if(W < R) {
			fee2 = Q;
		}
		else {
			fee2 = Q + (W - R) * S;
		}
		
		int lessFee = fee1 < fee2 ? fee1 : fee2;
		sb.append(lessFee + "\n");
	}
}