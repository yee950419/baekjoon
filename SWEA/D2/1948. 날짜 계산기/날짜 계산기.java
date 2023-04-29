import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int T;
	private static int month1, month2, day1, day2;
	private static int[] maxDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		
		for(int testCase=1; testCase<=T; testCase++) {
			sb.append("#" + testCase + " ");
			
			st = new StringTokenizer(br.readLine());
			month1 = Integer.parseInt(st.nextToken());
			day1 = Integer.parseInt(st.nextToken());
			month2 = Integer.parseInt(st.nextToken());
			day2 = Integer.parseInt(st.nextToken());
			
			getDifference();
		}
	}
	
	static void getDifference() {
		
		int difference = 0;
		
		if(month1 == month2) {
			difference = day2 - day1 + 1;
		}
		
		else {
			for(int i=month1; i<=month2; i++) {
				if(i == month1) {
					difference += maxDay[month1-1] - day1 + 1;
				}
				else if(i == month2) {
					difference += day2;
				}
				else {
					difference += maxDay[i-1];
				}
			}
		}
		
		sb.append(difference + "\n");
	}
}