import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 본문
		char[] text = br.readLine().toCharArray();
		
		// pattern
		char[] pattern = br.readLine().toCharArray();
		
		int tlen = text.length;
		int plen = pattern.length;
		
		// 실패시 점프할 위치를 위한 접두사와 접미사가 동일한 길을 저장
		int[] p = new int[plen];
		
		
//		 1. P[i] 구하기
//		    1.1) i=1, j=0 으로 시작
		for(int i=1, j=0; i<plen; i++) {
			
//		    1.2) i와 j 위치의 문자를 비교해서 
//		         일치하지 않으면 j = p[j-1]로 이동해서 계속 비교한다 ==> 일치하거나, j>0까지 비교한다.
			while(j>0 && pattern[i] != pattern[j]) {
				j = p[j-1];
			}
			
//		         일치하면 p[i] = ++j, i를 증가시킨다 => 결국 i와 j가 증가한다.
			if(pattern[i] == pattern[j]) {
				p[i] = ++j;
			}
		}
		
		int cnt = 0;		// 패턴과 일치하는 본문의 문자 개수
		ArrayList<Integer> list = new ArrayList<>();
		
//		 2. 본문과 pattern 비교하기
//		    2.1) i=0(본문), j=0(패턴)으로 시작
		for(int i=0, j=0; i<tlen; i++) {
			
//		    2.2) i와 j 위치의 문자를 비교해서
//		         일치하지 않으면 j = p[j-1]로 이동해서 계속 비교한다 ==> 일치하거나, j>0까지 비교한다.
			while(j>0 && text[i] != pattern[j]) {
				j = p[j-1];
			}
			
//		        일치하면 
			if(text[i] == pattern[j]) {
				
//		        2.2.1) j가 패턴의 끝이면 ==> 본문에서 패턴과 일치하는 문자를 발견함
				if(j == plen-1) {
					cnt++;
					list.add(i + 1 - plen + 1);	// 패턴이 일치하는 본문의 시작 위치
					j = p[j];
				}
				
//		        2.2.2) j가 패턴의 끝이 아니면 ==> j만 증가, i는 이후 for문을 통해 증가
				else {
					j++;
				}
			}
		}
		sb.append(cnt + "\n");
		if(cnt > 0) {
			for(Integer idx : list) {
				sb.append(idx + " ");
			}
		}
		
		System.out.println(sb);
	}
}