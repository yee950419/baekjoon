import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int T, N;
	static int check;	// 비트마스킹을 통한 체크
	static int isAllChecked = (1<<10) - 1;	// 10자리 다 체크되었는지 확인
	
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		
		for(int tc=1; tc<=T; tc++) {
			
			sb.append("#" + tc + " ");
			
			N = Integer.parseInt(br.readLine());
			check = 0;
			for(int i=1;;i++) {
				
				int temp = N*i;
				while(temp > 0) {
					int tempN = temp%10;
					if((check & 1<<tempN) == 0) {
						check |= (1<<tempN);
					}
					temp /= 10;
				}

				if(check == isAllChecked) {
					sb.append((N*i) + "\n");
					break;
				}
			}
		}
		
	}
}
