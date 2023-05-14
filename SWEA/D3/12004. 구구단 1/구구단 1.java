import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int TC;
	private static int N;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		TC = Integer.parseInt(st.nextToken());
		
		loopTest();
		System.out.println(sb);
	}

	static void loopTest() throws IOException {
		
		for(int testCase=1; testCase<=TC; testCase++) {
			sb.append("#" + testCase + " ");
			
			getYesOrNo();
		}
	}
	
	static void getYesOrNo() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		boolean isAvailable = false;
		
		int a, b;
		for(a=1; a<=9; a++) {
			
			for(b=1; b<=9; b++) {
				
				if(a*b == N) {
					isAvailable = true;
					break;
				}
			}
			
			if(isAvailable) {
				break;
			}
		}
		
		if(isAvailable) {
			sb.append("Yes\n");
		}
		else {
			sb.append("No\n");
		}
	}
}