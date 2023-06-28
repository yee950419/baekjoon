import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	private static int A, B;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		getResult();
	}
	
	static void getResult() {
		
		String result = "";
		if(A == 1) {
			if(B == 2) {
				result = "B";
			}
			else if(B == 3) {
				result = "A";
			}
		}
		else if(A == 2) {
			if(B == 1) {
				result = "A";
			}
			else if(B == 3) {
				result = "B";
			}
		}
		else if(A == 3) {
			if(B == 2) {
				result = "A";
			}
			else if(B == 1) {
				result = "B";
			}
		}
		
		System.out.println(result);
	}
}