import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, K;
	static int bit;		// 주어지는 비트
	static int maxCanReadCount;
	static String[] words;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		words = new String[N];
		for(int i=0; i<words.length; i++) {
			words[i] = br.readLine();
		}
		
		Set<Character> noDupleSet = new HashSet<>();
		String start = "anta";
		String end = "tica";
		
		// 필수 단어 중복 제거
		for(int i=0; i<start.length(); i++) {
			noDupleSet.add(start.charAt(i));
		}
		for(int i=0; i<end.length(); i++) {
			noDupleSet.add(end.charAt(i));
		}
		
		if(K < noDupleSet.size()) {	//배운 단어의 갯수가 필수 단어의 갯수 미만이거나 같을때
			System.out.println("0");
			System.exit(0);
		}
		else {
			// 필수 단어 비트화
			for(char c : noDupleSet) {
				bit = bit | 1<<(int)(c-'a');
			}
			
			K -= noDupleSet.size();
			getCanReadCount(0, 0, 0);
			System.out.println(maxCanReadCount);
		}
	}
	
	static void getCanReadCount(int depth, int start, int numBit) {
		
		if(depth == K) {
			
			int canReadCount = 0;
			for(int i=0; i<words.length; i++) {
				int wordBit = 0;
				for(int j=0; j<words[i].length(); j++) {
					wordBit = wordBit | 1<<(int)(words[i].charAt(j)-'a');
				}
				
				//필수 단어와 넘어온 단어를 조합한 비트
				numBit = numBit | bit;
				
				// 월드 비트가 조합 비트에 모두 속하는지 확인
				if((wordBit & numBit) == wordBit) {
					canReadCount++;
				}
			}
			
			if(maxCanReadCount < canReadCount) {
				maxCanReadCount = canReadCount;
			}
			
			return;
		}
		
		for(int i=start; i<26; i++) {
			
			if((bit & 1<<i) == 0) {
				getCanReadCount(depth+1, i+1, numBit | 1<<i);
			}
		}
	}
}
