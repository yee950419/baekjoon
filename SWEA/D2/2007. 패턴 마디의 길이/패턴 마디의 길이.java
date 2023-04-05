import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int T;
	private static String str;
	private static final int STR_LENGTH = 30;

	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		getResult();
		System.out.println(sb);
	}
	
	static void getResult() throws IOException {
		
		for(int testCase=1; testCase<=T; testCase++) {
			
			st = new StringTokenizer(br.readLine());
			str = st.nextToken();
			boolean isSuccess = true;
			
			for(int j=1; j<=STR_LENGTH/2; j++) {

				if(test(j)) {
					sb.append("#" + (testCase) + " " + (j) + "\n");
					break;
				}
			}
			if(!isSuccess) {
				sb.append("#" + (testCase) + " " + 1 + "\n");
			}
		}
	}
	
	static boolean test(int length) {
		
		for(int i=0; i<STR_LENGTH; i+=length) {
			if(!(str.substring(i, i+length).equals(str.substring(i+length, i+(length*2))))) {
				return false;
			}
			else {
				break;
			}
		}
		
		return true;
	}
}