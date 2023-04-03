import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int N;
	
	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		getResult();
		System.out.println(sb);
		
	}
	
	static void getResult() {
		
		boolean isClap = false;
		String numToStr;
		char strToChar;
		
		for(int i=1; i<=N; i++) {
			isClap = false;
			numToStr = String.valueOf(i);
			for(int j=0; j<numToStr.length(); j++) {
				strToChar = numToStr.charAt(j);
				if((strToChar == '3' || strToChar == '6') || strToChar == '9') {
					sb.append("-");
					isClap = true;
				}
			}
			if(!isClap) {
				sb.append(numToStr);
			}
			sb.append(" ");
		}
	}
}