import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int T;
	private static int num;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		getResult();
		
		System.out.println(sb);
	}
	
	static void getResult() throws IOException {
		int biggest;
		
		for(int i=0; i<T; i++) {
			biggest = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {
				num = Integer.parseInt(st.nextToken());
				
				if(num > biggest) {
					biggest = num;
				}
			}
			
			sb.append("#" + (i + 1) + " " + biggest + "\n");
		}
	}
}