import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int m = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		String str = "";
		while(m != 0) {
			
			int[] charCntList = new int[128];
			str = br.readLine();
			
			int startIdx = -1;
			int endIdx = -1;
			int charCnt = 0;
			int maxLength = 0;
			while(endIdx < str.length() - 1) {
				
				// 서로 다른 문자의 개수가 m 미만인 경우
				if(charCnt < m) {
					
					if(charCntList[str.charAt(endIdx+1)] == 0) {
						
						charCnt++;						
					}
					endIdx++;
					charCntList[str.charAt(endIdx)]++;
				}
				else {
					
					// 새로운 문자일 경우
					if(charCntList[str.charAt(endIdx+1)] == 0) {
						
						startIdx++;
						charCntList[str.charAt(startIdx)]--;
						if(charCntList[str.charAt(startIdx)] == 0) {
							
							charCnt--;
						}
					}
					// 기존의 문자일 경우
					else {
						
						endIdx++;
						charCntList[str.charAt(endIdx)]++;
					}
				}
				
				maxLength = Math.max(maxLength, endIdx - startIdx);
			}
			
			sb.append(maxLength).append("\n");
			
			m = Integer.parseInt(br.readLine());
		}
		
		System.out.println(sb);
	}
}