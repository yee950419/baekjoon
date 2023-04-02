import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int n;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		getResult();
	}
	
	static void getResult() {
		int sum = 0;
		
		for(int i=0; i<n; i++) {
			sum += i + 1;
		}
		
		System.out.println(sum);
	}
}