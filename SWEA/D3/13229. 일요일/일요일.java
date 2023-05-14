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
	private static final String[] DAYS = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		
		for(int testCase=1; testCase<=T; testCase++) {
			sb.append("#" + testCase + " ");
			
			getLeftDays();
		}
	}
	
	static void getLeftDays() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		S = st.nextToken();
		int leftDays = 0;
		
		for(int i=0; i<DAYS.length; i++) {
			if(S.equals(DAYS[i])) {
				leftDays = 7-i;
			}
		}
		
		sb.append(leftDays + "\n");
	}
}