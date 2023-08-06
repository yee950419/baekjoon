import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int T;
	static int count;

	public static void main(String[] args) throws IOException {
		
		T = Integer.parseInt(br.readLine());
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		
		for(int testCase=0; testCase<T; testCase++) {
			
			String str = br.readLine();
			
			count = 0;
			sb.append(checkIsPalindrome(str, 0, str.length()-1) + " ");
			sb.append(count + "\n");
		}
	}
	
	static int checkIsPalindrome(String str, int left, int right) {
		
		count++;
		
		if(left >= right) {
			return 1;
		}
		else if(str.charAt(left) != str.charAt(right)) {
			return 0;
		}
		else {
			return checkIsPalindrome(str, left+1, right-1);
		}
	}
}
