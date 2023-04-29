import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution{
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int T;
	private static int N;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		
		for(int testCase=1; testCase<=T; testCase++) {
			
			sb.append("#" + testCase + "\n");
			
			getDocument();
		}
	}
	
	static void getDocument() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		char ch;
		int chCount = 0;
		int fillCount = 0;
		int maxWidth = 10;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			ch = st.nextToken().charAt(0);
			chCount = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<chCount; j++) {
				sb.append(ch);
				fillCount++;
				
				if(fillCount == maxWidth) {
					fillCount = 0;
					sb.append("\n");
				}
			}
		}
		sb.append("\n");
	}
}