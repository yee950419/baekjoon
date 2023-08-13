import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int T, N, M;
	
	public static void main(String[] args) throws IOException {
		
		T = Integer.parseInt(br.readLine());
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		
		for(int tc=1; tc<=T; tc++) {
			
			sb.append("#" + tc + " ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			int mask = (1<<N)-1;	// 오른쪽부터 M만큼 1로 변경
			if(mask == (M & mask)) {	// & 연산자를 통해 결과가 mask와 같은지 확인
				sb.append("ON\n");
			}
			else {
				sb.append("OFF\n");
			}
		}
	}
}