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
	private static int countA, countB;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		TC = Integer.parseInt(st.nextToken());
		
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		for(int testCase=1; testCase<=TC; testCase++) {
			sb.append("#" + testCase + " ");
			
			getSubscriberCounts();
		}
	}
	
	static void getSubscriberCounts() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		countA = Integer.parseInt(st.nextToken());
		countB = Integer.parseInt(st.nextToken());
		
		int maxCount = countA < countB ? countA : countB;
		int leastCount = 0;
		
		if(countA <= N/2 && countB <= N/2) {
			leastCount = 0;
		}
		else if(countA + countB <= N) {
			leastCount = 0;
		}
		else {
			leastCount = countA + countB - N;
		}
		
		sb.append(maxCount + " " + leastCount + "\n");
	}
}