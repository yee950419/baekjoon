import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int T;
	
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
		String S1 = st.nextToken();
		String S2 = st.nextToken();
		String sRepeatWord1 = getRepeatWord(S1);
		String sRepeatWord2 = getRepeatWord(S2);
		
		if(sRepeatWord1.equals(sRepeatWord2)) {
			sb.append("yes\n");;
		}
		else {
			sb.append("no\n");;
		}
	}
	
	static String getRepeatWord(String s) {

		String tempStr = "";
		String result = "";
		
		for(int i=0; i<s.length(); i++) {
			
			if(i >= s.length()/2) {
				result = s;
				break;
			}
			
			tempStr += s.charAt(i);
			if(validateIsRepeatWord(s, tempStr)) {
				result = tempStr;
				break;
			}
		}
		
		return result;
		
	}
	
	static boolean validateIsRepeatWord(String s, String tempStr) {
		
		boolean isRepeatWord = true;
		
		for(int i=0; i<s.length(); i+=tempStr.length()) {
			
			for(int j=0; j<tempStr.length(); j++) {
				
				if(i+j >= s.length()) {
					isRepeatWord = false;
					break;
				}
				if(tempStr.charAt(j) != s.charAt(i+j)) {
					isRepeatWord = false;
				}
			}
			
			if(!isRepeatWord) {
				break;
			}
		}
		
		return isRepeatWord;
	}	
}