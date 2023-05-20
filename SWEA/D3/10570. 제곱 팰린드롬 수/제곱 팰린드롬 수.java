import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int T;
	private static int A, B;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		for(int testCase=1; testCase<=T; testCase++) {
			sb.append("#" + testCase + " ");
			
			getResult();
		}
	}
	
	static void getResult() throws IOException {
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		int count = 0;
		for(int i=1; i*i<=B; i++) {
			if(i*i >= A && isPalindrome(i)) {
				count++;
			}
		}

		sb.append(count + "\n");
	}
	
	static boolean isPalindrome(int num) {
		
		String strNum = String.valueOf(num);
		for(int i=0; i<strNum.length()/2; i++) {
			if(strNum.charAt(i) != strNum.charAt(strNum.length()-1-i)) {
				return false;
			}
		}
		
		String strNum2 = String.valueOf(num*num);
		for(int i=0; i<strNum2.length()/2; i++) {
			if(strNum2.charAt(i) != strNum2.charAt(strNum2.length()-1-i)) {
				return false;
			}
		}
		
		return true;
	}
}