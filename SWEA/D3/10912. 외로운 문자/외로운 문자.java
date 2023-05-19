import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int TC;
	private static String str;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		TC = Integer.parseInt(st.nextToken());
		
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		for(int testCase=1; testCase<=TC; testCase++) {
			sb.append("#" + testCase + " ");
			
			getRidOfPairs();
		}
	}
	
	static void getRidOfPairs() throws IOException {
		st = new StringTokenizer(br.readLine());
		str = st.nextToken();
		boolean[] isPair = new boolean[str.length()];
		List<Character> noPairs = new ArrayList<>();
		
		Arrays.fill(isPair, false);
		
		for(int i=0; i<str.length(); i++) {
			noPairs.add(str.charAt(i));
		}
		
		Collections.sort(noPairs);
		int idx = 0;
		for(int i=0; i<str.length()-1; i++) {
			
			if(noPairs.get(idx) == noPairs.get(idx+1)) {
				noPairs.remove(idx);
				noPairs.remove(idx);
				i++;
			}
			else {
				idx++;
			}
		}
		
		String newStr = "";
		for(int i=0; i<noPairs.size(); i++) {
			newStr += noPairs.get(i);
		}

		if(newStr.equals("")) {
			sb.append("Good\n");
		}
		else {
			sb.append(newStr + "\n");
		}
	}
}