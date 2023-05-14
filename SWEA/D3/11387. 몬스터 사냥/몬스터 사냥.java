import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int T;
	private static int D, L, N;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		loopTest();
		System.out.println(sb);
	}

	static void loopTest() throws IOException {
		
		for(int testCase=1; testCase<=T; testCase++) {
			sb.append("#" + testCase + " ");
			
			getTotalDamage();
		}
	}
	
	static void getTotalDamage() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int damage = 0;
		long sumOfDamage = 0;
		for(int i=0; i<N; i++) {
			
			damage = D + D/100 * i * L;
			sumOfDamage += damage;
		}
		
		sb.append(sumOfDamage + "\n");
	}
}