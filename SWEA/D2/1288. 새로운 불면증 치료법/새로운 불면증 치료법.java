import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int T;
	private static int N;
	
	private static boolean[] visit = new boolean[10];
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		
		for(int testCase=1; testCase<=T; testCase++) {
			
			sb.append("#" + testCase + " ");
			
			Arrays.fill(visit, false);
			getCount();
		}
	}
	
	static void getCount() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		String strN = "";
		
		int visitCount = 0;
		int multipleCount = 1;
		int index = 0;
		while(visitCount != 10) {	
			
			strN = String.valueOf(N * multipleCount);
			for(int i=0; i<strN.length(); i++) {
				
				index = strN.charAt(i)-'0';
				if(!visit[index]) {
					
					visit[index] = true;
					visitCount++;
				}
			}
			
			multipleCount++;
		}
		
		multipleCount--;
		sb.append(N*multipleCount + "\n");
	}
}