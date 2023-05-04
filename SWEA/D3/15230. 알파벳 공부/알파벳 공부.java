import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int T;
	private static String str;
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		
		for(int testCase=1; testCase<=T; testCase++) {
			
			sb.append("#" + testCase + " ");
			
			getCorrectCount();
		}
	}
	
	static void getCorrectCount() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		str = st.nextToken();
		
		int count = 0;
		for(int i=0; i<str.length(); i++) {
			
			if(str.charAt(i) == ALPHABET.charAt(i)) {
				count++;
			}
			else {
				break;
			}
		}
		
		sb.append(count + "\n");
	}
}